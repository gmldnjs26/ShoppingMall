function go_cart() {
	if(document.formm.loginUser.value==null){
		alert("ログインしてください。");
		document.formm.action = "login_form.do";
		document.formm.submit();
	}
	else if (document.formm.quantity.value == "") {
		alert("数量を入力してください。");
		document.formm.quantity.focus();
	} else {
		document.formm.action = "cart_insert.do";
		document.formm.submit();
	}
}

function go_cart_delete() {
	var count = 0;
	alert("d" + document.formm.cseq.length);
	for (var i = 0; i < document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			alert("d" + document.formm.cseq.length);
			count++;
		}
	}
	if (count == 0) {
		alert("削除する項目を選択してください。");

	} else {
		document.formm.action = "cart_delete.do";
		document.formm.submit();
	}
}

function go_order_insert() {
	var count = 0;
	for(var i=0; i < document.formm.cseq.length; i++){
		if(document.formm.cseq[i].checked == true){
			count++;
		}
	}
	if(count == 0){
		alert("注文する項目を選択してください。");	
	}else{
		document.formm.action = "order_insert.do";
		document.formm.submit();
	}
}

function go_order_delete() {
	var count = 0;
	for (var i = 0; i < document.formm.oseq.length; i++) {
		if (document.formm.oseq[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("削除する項目を選択してください。");

	} else {
		document.formm.action = "order_delete.do";
		document.formm.submit();
	}
}

function go_order() {
	document.formm.action = "mypage.do";
	document.formm.submit();
}