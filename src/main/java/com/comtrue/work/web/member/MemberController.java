package com.comtrue.work.web.member;

import com.comtrue.work.domain.member.Member;
import com.comtrue.work.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = {"/", "/list"})
    public String members(Model model) {
        List<Member> members = memberService.viewMemberList();
        if(!members.isEmpty()) {
            model.addAttribute("members", members);
        }
        return "members";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/list";
    }

    @GetMapping("/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Member member = memberService.viewMember(id);
        model.addAttribute("member", member);
        return "editForm";
    }

    @PostMapping("/{id}")
    public String modifyMember(Member member) {
        memberService.editMember(member);
        return "redirect:/list";
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
        return "/";
    }

    @GetMapping("/search")
    public String searchMember(@RequestParam(value="keyword") String keyword, Model model) {
        List<Member> searchMembers = memberService.searchMembers(keyword);
//        ObjectMapper mapper = new ObjectMapper();
        model.addAttribute("members", searchMembers);
        return "searchList";
    }

    @GetMapping("/csv")
    public String downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("utf-8");
        response.addHeader("Content-Disposition","attachment; filename=\"members.csv\"");
        memberService.csvDownload(response.getWriter());
        return "redirect:/list";
    }

}
