<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--jQuery 라이브러리 --%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
<%--jstl 라이브러리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 내역</title>

<!--부트스트랩-->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   
 
 <!--font-->
   <link rel="preconnect" href="https://fonts.googleapis.com">
   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
   <link href="https://fonts.googleapis.com/css2?family=Atkinson+Hyperlegible:ital@1&family=Lobster&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@700&family=Noto+Sans+KR:wght@700&family=Pacifico&display=swap" rel="stylesheet">

<!-- css 파일 -->
	<link rel="stylesheet" type="text/css" href="/resources/farm/css/farmOrderListPopupPage.css">
    
</head>
<body>
 	<div id="farmMemberWrap">
       <fieldset>상품정보</fieldset>
           <table>    
              <tbody>
                  <tr>
                    <td class="fixWord">경매번호</td>
                    <td>${list.get(0).getAuctionNo()}</td>
                  </tr>
                  <tr>
                     <td class="fixWord">상품명</td>
                     <td>${list.get(0).getAuctionProduct()}</td>
                  </tr>
                  <tr>
                      <td class="fixWord">상품가격</td>
                      <td>${list.get(0).getAuctionPrice()}</td>
                  </tr>
                </tbody>
            </table>
                <br>
            <button type="button" class="btn btn-success btn-sm" id="lastBtn">닫기</button>
    </div>
                
    <script>
        $('#lastBtn').click(function(){
           window.close();
        });
    
    </script>    


</body>
</html>