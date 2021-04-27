/**
 * myscript.js
 */
/*$(document).ready(function(){
	bbsCheck();
});*/
function bbsCheck(){
	//1) wname 작성자 : 두글자 이상
	var wname = $("#wname").val().trim();
	console.log(wname);
	if(wname.length<2){
		alert("작성자 이름은 두글자 이상이어야 합니다.");
		$("#wname").focus();
		return false;
	}
	//2) subject 제목 : 두글자 이상
	var subject = $("#subject").val().trim();
		if(subject.length<2){
		alert("제목은 두글자 이상이어야 합니다.");
		$("#subject").focus();
		return false;
	}
	//3) content 내용 : 두글자 이상
	var content = $("#content").val().trim();
		if(content.length<2){
		alert("내용은 두글자 이상이어야 합니다.");
		$("#content").focus();
		return false;
	}
	//4) passwd 비밀번호 : 4글자 이상 + 숫자만 입력
	var passwd = $("#passwd").val().trim();
	if(passwd.length<4||isNaN(passwd)){
		alert("비밀번호는 네글자 이상 숫자이어야 합니다.");
		$("#passwd").focus();
		return false;
	}
	return true;
}//bbsCheck() end