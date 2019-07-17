function go_save() {
	if (document.formm.id.value == "") {
		alert("IDをご入力してください。");
		document.formm.id.focus();
	} else if (document.formm.id.value != document.formm.reid.value) {
		alert("ID重複ご確認してください。");
		document.formm.id.focus();
	} else if (document.formm.pwd.value == "") {
		alert("パスワードをご入力ください。");
		document.formm.pwd.focus();
	} else if ((document.formm.pwd.value != document.formm.pwdCheck.value)) {다릅니다
		alert("確認パスワードが異なります。");
		document.formm.pwd.focus();
	} else if (document.formm.name.value == "") {
		alert("名前を入力してください。");
		document.formm.name.focus();
	} else if (document.formm.email.value == "") {
		alert("Eメールを入力してください。");
		document.formm.email.focus();
	} else {
		document.formm.address.value = document.formm.addr1.value+" "+document.formm.addr2.value;
		alert(document.formm.address.value);
		document.formm.action = "join.do";
		document.formm.submit();
	}
}

function idcheck() {
	if (document.formm.id.value == "") {
		alert('IDをご入力してください。');
		document.formm.id.focus();
		return;
	}
	var url = "id_check_form.do?id="+ document.formm.id.value;
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
}

function post_zip() {
	var url = "find_zip_num.do";
	window
			.open(
					url,
					"_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}

function go_next() {
	if (document.formm.okon1[0].checked == true) {
		document.formm.action = "join_form.do";
		document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
		alert('約款に同意しない場合,会員加入は不可能です。');
	}
}