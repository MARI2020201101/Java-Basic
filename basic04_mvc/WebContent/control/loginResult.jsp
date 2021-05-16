<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginResult</title>
</head>
<body>
${requestScope.r_uid }
${requestScope.r_upw }
<hr>
${sessionScope.s_uid }
${sessionScope.s_upw }
<hr>
${applicationScope.a_uid }
${applicationScope.a_upw }
<hr>
${msg }
</body>
</html>