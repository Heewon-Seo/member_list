let btns = document.querySelectorAll('.delete-btn');

btns.forEach(value => {
	value.addEventListener('click', function (e) {
		e.preventDefault();

		console.log("click!");

		fetch(`/${value.id}`, {
			method: 'delete',
			redirect: "follow"
		}).then(response => response.text())
			.then(response => {
				window.location.replace(response);
			});
	})
})

