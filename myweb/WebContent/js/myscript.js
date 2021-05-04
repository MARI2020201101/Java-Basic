/**
 * myscript.js
 */

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
var message="";
function pwCheck(){
	var passwd = $("#passwd").val().trim();
	if(passwd.length<4||isNaN(passwd)){
		alert("비밀번호는 네글자 이상 숫자이어야 합니다.");
		$("#passwd").focus();
		return false;
		}
		
		message="삭제된 내용은 복구되지 않습니다. \n진행할까요?";
		if(confirm(message)){
			return true;
		}else{
			return false;
		}
	}//pwCheck() end
function searchCheck(){
	var word=$("#word").val().trim();
	if(word.length<1||word==null||word.equals("")){
		alert("검색어를 입력해 주십시요");
		return false;
	}else{
		return true;
	}
}
function noticeCheck(){
	var subject =$("#subject").val();
	var content =$("#content").val();
	console.log(subject);
	console.log(content);
	if(subject==null||content==null||subject.length<1||content.length<1){
		alert("제목과 내용을 확인해 주십시요");
		return false;
	}else {return true;}
}

function loginCheck(){
	var id=$("#id");
	var passwd=$("#passwd");
	console.log(id);
	console.log(passwd);
	if(id.val().length<5||id.val().length>10){
		alert("아이디를 5~10자 이내로 입력해주십시요");
		id.focus();
		return false;
	}
	if(passwd.val().length<5||passwd.val().length>10){
		alert("비밀번호를 5~10자 이내로 입력해주십시요");
		passwd.focus();
		return false;
	}
	else{return true;}
}//loginCheck()end

function idCheck(){
	window.open("idCheckForm.jsp", "idwin", "width=450, height=300");
}//idCheck() end

function emailCheck(){
	window.open("emailCheckForm.jsp", "emailwin", "width=450, height=300");	
}//emailCheck() end

function memberCheck(){
	var id = $("#id").val().trim();
	if(id.length<5||id.length>10){
		alert("아이디는 5자이상 10자 이내입니다.");
		$("#id").focus();
		return false;
	}
	var passwd = $("#passwd").val().trim();
		if(passwd.length<5||passwd.length>10){
		alert("비밀번호는 5자이상 10자 이내입니다.");
		$("#passwd").focus();
		return false;
	}
	var repasswd = $("#repasswd").val().trim();
	if(passwd!=repasswd){
		alert("비밀번호 확인을 진행해 주십시요.");
		$("#repasswd").focus();
		return false;
	}
	var mname = $("#mname").val().trim();
		if(mname.length<1||mname.length>5){
		alert("이름은 1자이상 5자 이내입니다.");
		$("#mname").focus();
		return false;
	}
	var email = $("#email").val().trim();
		if(email.length<5){
		alert("이메일 확인을 해주십시요");
		$("#email").focus();
		return false;
	}
	var job = $("#job").val();
		if(job.length<1){
		alert("직업선택을 해주십시요");
		$("#job").focus();
		return false;
	}
	
	return true;
}//memberCheck()end