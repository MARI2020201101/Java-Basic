<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../bbs/ssi.jsp" %>

<!-- 본문 시작 updateForm.jsp-->
<div class="container-2">
<h3>* 회원 정보 수정 *</h3>
<%
	String id = (String)session.getAttribute("s_id");
	memberDto=memberDao.select(id);
	
	if(memberDto==null){
		out.print("<p>로그인 시간이 초과되었습니다.</p>");
		out.print("<p>다시 로그인 해주시기 바랍니다.</p>");
		out.println("<p><a href='loginForm.jsp'>[로그인 페이지로]</a></p>");
	}else{
		String passwd=memberDto.getPasswd();
		String mname=memberDto.getMname();
		String email=memberDto.getEmail();
		String tel=memberDto.getTel();
		String zipcode=memberDto.getZipcode();
		String address1=memberDto.getAddress1();
		String address2=memberDto.getAddress2();
		String job=memberDto.getJob();
%>
<form name="memfrm" id="memfrm" method="post" style="text-align:left;" action="updateProc.jsp" onsubmit="return memberCheck()">
<span style="color:red; font-weight: bold">* 필수입력</span>
<br>
<table class="table">
<tr>
    <th>*아이디</th>
    <td>
      <input type="text" style="border:1px solid #ddd;border-radius: 5px;"name="id" id="id" size="15" readonly value="<%=id %>">
    </td>
</tr>
<tr>
    <th>*비밀번호</th>
    <td><input type="password" name="passwd" id="passwd" size="15" required style="border:1px solid #ddd;border-radius: 5px;" value="<%=passwd %>"></td>
</tr>
<tr>
    <th>*비밀번호 확인</th>
    <td><input type="password" name="repasswd" id="repasswd" size="15" required style="border:1px solid #ddd;border-radius: 5px;" ></td>
</tr>
<tr>
    <th>*이름</th>
    <td><input type="text" name="mname" id="mname" size="15" required style="border:1px solid #ddd;border-radius: 5px;" value="<%=mname %>"></td>
</tr>
<tr>
    <th>*이메일</th>
    <td>
      <input type="email" name="email" id="email" size="30" readonly style="border:1px solid #ddd;border-radius: 5px;" value="<%=email %>">
      <input type="button" value="Email 중복확인" class="btn btn-primary" onclick="emailCheck()">  
    </td>
</tr>
<tr>
    <th>전화번호</th>
    <td><input type="text" name="tel" id="tel" size="15" style="border:1px solid #ddd;border-radius: 5px;" value="<%=tel %>"></td>
</tr>
<tr>
    <th>우편번호</th>
    <td>
      <input type="text" name="zipcode" id="zipcode" size="7"  readonly style="border:1px solid #ddd;border-radius: 5px;" value="<%=zipcode%>">
      <input type="button" value="주소찾기" class="btn btn-primary" onclick="DaumPostcode()">    
    </td>
</tr>
<tr>  
  <th>주소</th>
  <td><input type="text" name="address1" id="address1" size="45" readonly style="border:1px solid #ddd;border-radius: 5px;" value="<%=address1%>"></td>
</tr>
<tr>  
  <th>나머지주소</th>
  <td><input type="text" name="address2" id="address2" size="45" style="border:1px solid #ddd;border-radius: 5px;" value="<%=address2 %>"></td>
</tr>
<tr>  
  <th>*직업</th>
  <td><select name="job"  id="job" class="form-control" style="width:200px;">
          <option value="0" >선택하세요.</option>
          <option value="A01" >회사원</option>
          <option value="A02" >전산관련직</option>
          <option value="A03" >학생</option>
          <option value="A04" >주부</option>
          <option value="A05">기타</option>
        </select>
  </td>
  <input type="hidden" name="selectedJob" id="selectedJob" value="<%=job%>">
</tr>

<script>
//option에 selected태그 붙임
$(document).ready(function(){
	$("#job option").each(
			function(index){
				if($(this).val()==$("#selectedJob").val())
					$(this).attr("selected","selected");
				});
	
});
</script>
<tr style="text-align:center">
    <td colspan="2">
        <input type="submit" value="수정"  class="btn btn-primary"/>
        <input type="reset"  onclick="history.back();" value="취소"  class="btn btn-primary" />
    </td>
</tr>
</table>

<!-- ----- DAUM 우편번호 API 시작 ----- -->
<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 110px;position:relative">
  <img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function DaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address1').value = fullAddr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
                
                $('#address2').focus();
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<!-- ----- DAUM 우편번호 API 종료----- -->

</form>
</div>
<%
	}
%>
<!-- 본문 끝 -->           
<%@ include file="../footer.jsp"%>