const regExpEmail = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z]{2,8}$/;
const regExpPhone = /^01([016789])-?([0-9]{3,4})-?([0-9]{4})$/

const email = document.getElementById("email");
const phone = document.getElementById("phoneNumber");
const invalidEmail = document.getElementById("invalid-email");
const invalidPhone = document.getElementById("invalid-phone");

const autoHyphen = (target) => {
	target.value = target.value
		.replace(/[^0-9]/, '')
		.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}


email.addEventListener("keyup", function () {
	if(!regExpEmail.test(email.value)) {
		invalidEmail.innerHTML = "유효한 이메일 주소를 입력해 주세요";
	} else {
		invalidEmail.innerHTML = "등록이 가능합니다";
	}
})

phone.addEventListener("keyup", function () {
	autoHyphen(phone);
	if(!regExpPhone.test(phone.value)) {
		invalidPhone.innerHTML = "전화번호를 바르게 입력해 주세요";
	} else {
		invalidPhone.innerHTML = "등록이 가능합니다";
	}
})
