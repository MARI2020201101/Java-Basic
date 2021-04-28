<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>index.jsp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- 사용자정의 CSS + javascript -->
  <!-- 주의사항 : CSS와 JS는 각 웹 브라우저에서 쿠키삭제하고 확인할 것. -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css">
  <script src="js/myscript.js"></script>
</head>
<body>

<!-- Navar 메인카테고리-->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">HOME</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="bbs/bbsList.jsp">게시판</a></li>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">포토갤러리</a></li>
        <li><a href="#">메일보내기</a></li>
      </ul>
    </div>
  </div>
</nav><!--Navbar End 메인카테고리 끝-->


<!-- 그림 Container -->
<div class="container-fluid">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class=""></li>
	    <li data-target="#myCarousel" data-slide-to="1" class=""></li>
	    <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item">
	      <div class="carousel-caption margin">
	        <h3>환 영 합 니 다 !</h3> 
	      </div> 
	      <img src="images/toy.jpg" class="img-responsive"alt="boardIntroImage" width="100%">
	      
	    </div>
	
	    <div class="item">
	      <div class="carousel-caption margin">
	        <h3>환 영 합 니 다 !</h3> 
	      </div> 
	      <img src="images/teddy2.jpg" class="img-responsive"alt="boardIntroImage" width="100%">
	     
	    </div>
	  
	    <div class="item active">
	      <div class="carousel-caption margin">
	        <h3>환 영 합 니 다 !</h3> 
	      </div> 
	      <img src="images/teddy.jpg" class="img-responsive"alt="boardIntroImage" width="100%">
	        
	    </div>
	  </div>
	
	  <!-- Left and right controls -->
	  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
</div>
<!--그림 Container end-->

<!--콘텐츠 시작-->
<div class="container-2 bg-3 text-center">
	<div class="row">
		<!-- 본문 시작 -->
			<div id="clock"></div>
		<!-- 본문 끝 --> 
	</div><!-- row end -->
</div><!--콘텐츠 끝-->

<!-- Footer -->
<footer class="container-fluid-2 bg-4 text-center">
  <p>Copyright &copy; 2021  MYWEB</p>
  <p>mari20201101@gmail.com</p>
</footer>
<script src="js/clock.js"></script>
</body>
</html>