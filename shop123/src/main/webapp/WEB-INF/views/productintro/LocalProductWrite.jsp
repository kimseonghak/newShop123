<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%-- jstl 라이브러리 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%--jQuery 라이브러리 --%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<%-- 폰트 설정 라이브러리 --%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Atkinson+Hyperlegible:ital@1&family=Lobster&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@700&family=Noto+Sans+KR:wght@700&family=Pacifico&display=swap" rel="stylesheet">

<%-- 부트스트랩 라이브러리 --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%-- css import --%>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

*{
	box-sizing: border-box;
}

html {
	height: 100%;
}
body {
	height: 100%;
}

.wrapForm{
	width: 100%;
	min-height: 100%;
}

.headerForm{
	width: 100%;
	height: 175px;
}

.contentForm{
	padding: 30px;
	width: 100%;
	
}

.footerForm{
	width: 100%;
	height: 242px;
}

.contentwrap{
	width: 60%;
	height: 80%;
	margin: 100px auto;
	padding: 10px;
	background-color: white;
	border-radius: 5px/5px;
	box-shadow: 3px 3px 10px #aeaeae;
}

.page_name{
	width: 40%;
	height: 60px;
	text-align: center;
	padding: 50px 20px 0px;
	margin: 5% 75% 5% 4.5%;
	color: #3BBD5A;
	font : normal bold 30px "Nanum Gothic",sans-serif;
}

.insert_zone{
	width: 80%;
	min-height: 850px;
}

.empty{
	width: 100%;
	height: 30px;
}

.optiontitle{
	min-width: 3%;
	height: 30px;
	color: #3BBD5A;
	font : normal bold 20px "Nanum Gothic",sans-serif;
	text-align: left;
	float: left;
}

.option_form{
	width: 100%;
	height: 50px;
}

.option{
	min-width: 50px;
	height: 30px;
	border: none;
	text-align: left;
	font : normal bold 20px "Nanum Gothic",sans-serif;
	float: left;
	margin-left: 10px;
	margin-top: -4px;
	outline: none;
}

.title{
	width: 100%;
	height: 40px;
	border-radius: 5px / 5px;
	border: none;
	background-color: #f0f0f0;
	font : normal 20px "Nanum Gothic",sans-serif;
	outline: none;
}

.contextForm{
	width: 100%;
	min-height: 400px;
	margin-top: 30px;
	
}

.content{
	width: 100%;
	min-height: 450px;
	text-align: left;
	border: none;
	resize: none;
	font : normal 20px "Nanum Gothic",sans-serif;
	background-color: #f0f0f0;
	outline: none;
}

.imgForm{
	width: 100%;
	height: 30px;
	text-align: left;
}

#img_Submit{
    float: right;
    width: 100px;
    height: 30px;
    background-color: #3BBD5A;
    font : normal bold 17.5px "고딕체";
    color: #ffffff;
    border-radius: 15px;
    border : none;
    cursor : pointer;
}

.Btnform{
	width: 95%;
	height: 40px;
	padding: 10px;
	margin-top: 40px;
	text-align: center;
}

.listbtn{
	width: 100px;
	height: 40px;
	border: none;
	border-radius: 5px;
	background-color: gray;
	color: white;
	margin: 15px;
	cursor: pointer;
	font : normal bold 17.5px "Nanum Gothic",sans-serif;
}

.resetbtn{
	width: 100px;
	height: 40px;
	border: none;
	border-radius: 5px;
	background-color: gray;
	color: white;
	margin: 15px;
	cursor: pointer;
	font : normal bold 17.5px "Nanum Gothic",sans-serif;
}

.submitbtn{
	width: 100px;
	height: 40px;
	border: none;
	border-radius: 5px;
	background-color:#3BBD5A;
	color: white;
	margin: 15px;
	cursor: pointer;
	font : normal bold 17.5px "Nanum Gothic",sans-serif;
}

</style>

<body>

<div id="wrapForm" align="center">
	
	<div class="headerForm">
		<c:import url="/WEB-INF/views/commons/header.jsp"/>
	</div>
	
	<div class="contentForm">
		<div class="contentwrap">
			
			<%-- 제목 공간 --%>
			<div class="page_name">
				<span>지역 특산물 작성 페이지</span>
			</div>
			
			<%-- 빈 공간 --%>		
			<div class="empty"></div>
			
			<%-- 입력 폼 --%>
			<div class="insert_zone">
			<form action="/local/localWrite.do" id="textWrite" method="post">
				<input type="hidden" name="LocalProductPhotoNo" value="1">
				<%-- 옵션 1 --%>
				<div class="optiontitle">지역별로 선택해 주세요.</div>
					<div class="option_form">
						<select class="option" name="LocalProductClassify">
								<option value="" disabled selected>지역 선택</option>
									<option value="SEOUL">서울</option>
									<option value="GYEONGGI">경기도</option>
									<option value="GANGWWON">강원도</option>
									<option value="CHUNGBUK">충청북도</option>
									<option value="CHUNGNAM">충청남도</option>
									<option value="GYEONGBUK">경상북도</option>
									<option value="GYEONGNAM">경상남도</option>
									<option value="JEONBUK">전라북도</option>
									<option value="JEONNAM">전라남도</option>
									<option value="JEJU">제주도</option>
						</select>
					</div>
					
	
				
				<%-- 빈 공간 --%>		
				<div class="empty"></div>	
						
				<%-- 글 제목 입력 --%>
				<input type="text" class="title" name="LocalProductTitle" placeholder="제목을 입력하시오"/>
				
				<%-- 글 제목 입력 --%>
				<div class="contextForm">
					<textarea class="content" name="LocalProductContent" placeholder="내용을 입력하시오"></textarea>
				</div>
				
			</form>
				<%-- 빈 공간 --%>		
				<div class="empty"></div>
				
				<%-- 첨부파일 --%>
				<div class="imgForm">
					<input type="file" id="file_submit" name="file"/>
					<button id="img_Submit">업로드하기</button>
				</div>
				
				<%-- 빈 공간 --%>		
				<div class="empty"></div>
				
				<%-- 버튼 폼 --%>
				<div class="Btnform">
					<input type="button" class="listbtn" value="리스트" onclick="location='/productintro/LocalProductListPage.do'">
					<input type="submit" class="submitbtn" value="글쓰기">
					
				</div>

				
			
			</div>
		</div>
	</div>
	
	<div class="footerForm">
		<c:import url="/WEB-INF/views/commons/footer.jsp"/>
	</div>	

</div>

<!-- 이미지 처리 -->
<script type="text/javascript">
	$('#img_Submit').click(function(){
		var formData = new FormData();
		var inputFile = $("input[name='file']");
		var files = inputFile[0].files;
		formData.append("file", files[0]);
		
		$.ajax({
			url : "/local/localPhotoAjax.do",
			processData : false,
		    contentType : false,
		    data : formData,
		    type : "POST",
		    success:function(result){
		    	if(result != null && result != 0){
	                alert("파일이 업로드되었습니다.");
	                $("input[name='LocalProductPhotoNo']").val(result);
	                console.log($("input[name='LocalProductPhotoNo']").val());
	            }else{
	                alert("파일 업로드에 실패하였습니다.");
	            }
		    }
		});
	});


$(".submitbtn").click(function(){
	$("#textWrite").submit();
});
</script>

</body>
</html>