<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Atkinson+Hyperlegible:ital@1&family=Lobster&family=Nanum+Gothic&family=Nanum+Myeongjo:wght@700&family=Noto+Sans+KR:wght@700&family=Pacifico&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>123상회 관리자 페이지</title>
<link rel="stylesheet" href="/resources/admin/css/common.css">
<link rel="stylesheet" href="/resources/admin/css/main.css">
</head>
<body>
	<%--header import --%>
	<c:import url="/resources/admin/common/header.jsp" />
	<div id="bodyWrap">
		<%--sideBar import --%>
		<c:import url="/resources/admin/common/sideBar.jsp" />
		<%-- mainContents --%>
		<div id="mainContents">
<%-- 카운트 요약 부분 --%>
			<div class="countWrap">
				<div class="count-graphWrap">
					<canvas id="enterHome"></canvas>
				</div>
			</div>
			<div class="countWrap">
				<div class="count-graphWrap">
					<canvas id="joinCount"></canvas>
				</div>
			</div>
			<div class="countWrap">
				<div class="count-graphWrap">
					<div style="height:10%; width:100%;"><span class="graphInfo">구매 : ${sugMap.PURCHASE } 환불 : ${sugMap.REFUND }</span> <span id="refundPer" class="graphInfo"></span></div>
					<div style="height:90%; width:100%;"><canvas id="refundData"></canvas></div>
				</div>
			</div>
			<div class="countWrap">
				<div class="count-graphWrap">
<%-- 추천 작업 부분 --%>
					<div class="boardHeader">
						<span class="boardTitle boardSpan">추천 작업</span> 
					</div>
					<hr style="border:1px solid #48bb78;">
					<div class="boardBody">
						<ul id="sugWorkUL">
							<li id="liText">
								판매 대기 중인 낙찰건 : ${sugMap.BID_SELL_YN }<br>
								답변 대기 중인 유저 문의 : ${sugMap.QUSER_ANSWER_YN }<br>
								답변 대기 중인 농가 문의 : ${sugMap.QFARM_ANSWER_YN }<br>
								환불 대기 중인 환불 건 : ${sugMap.REFUND_YN }<br>
							</li>
							<li id="liGraph">
								<canvas id="test"></canvas>
							</li>
						</ul>
					</div>
				</div>
			</div>
<%-- 보드 요약 부분 --%>
			<div class="boardWrap">
				<div class="borderDesignWrap">
					<div class="boardHeader">
<%-- 유저 문의 사항 --%>
						<span class="boardTitle boardSpan">유저 문의사항</span> 
						<span class="boardPlus boardSpan"><a href="/admin/adminUserQNAPage.do">+ 더보기</a></span>
					</div>
					<div class="boardBody">
						<table class="boardTBL" style="word-break: break-all;">
							<tr>
								<th style="width: 15%;">번호</th>
								<th style="width: 65%;">문의 제목</th>
								<th style="width: 20%;">작성자</th>
							</tr>
							<c:forEach items="${requestScope.qUser }" var="q">
								<tr class="qUserList userQNA">
									<td>${q.questionUserNo }</td>
									<td>${q.questionUserTitle }</td>
									<td>${q.userNick }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="boardWrap">
				<div class="borderDesignWrap">
					<div class="boardHeader">
<%-- 농가 문의 사항 --%>
						<span class="boardTitle boardSpan">농가 문의사항</span> 
						<span class="boardPlus boardSpan"><a href="/admin/adminFarmQNAPage.do">+ 더보기</a></span>
					</div>
					<div class="boardBody">
						<table class="boardTBL" style="word-break: break-all;">
							<tr>
								<th style="width: 15%;">번호</th>
								<th style="width: 65%;">문의 제목</th>
								<th style="width: 20%;">작성자</th>
							</tr>
							<c:forEach items="${requestScope.qFarm }" var="q">
								<tr class="qUserList farmQNA">
									<td style="width:15%;">${q.questionFarmNo }</td>
									<td style="width:65%;">${q.questionFarmTitle }</td>
									<td style="width:20%;">${q.farmName }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="boardWrap">
				<div class="borderDesignWrap">
					<div class="boardHeader">
<%-- 유저 환불 목록 --%>
						<span class="boardTitle boardSpan">유저 환불목록</span> 
						<span class="boardPlus boardSpan"><a href="">+ 더보기</a></span>
					</div>
					<div class="boardBody">
						<table class="boardTBL" style="word-break: break-all;">
							<tr>
								<th style="width: 15%;">번호</th>
								<th style="width: 15%;">문의 번호</th>
								<th style="width: 70%;">주문 번호</th>
							</tr>
							<c:forEach items="${requestScope.refund }" var="r">
								<tr class="qUserList userQNA">
									<td>${r.refundNo }</td>
									<td>${r.questionUserNo }</td>
									<td>${r.orderNo }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- jQuery CDN --%>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<%-- chart.js CDN --%>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@3.7.0/dist/chart.min.js"
		integrity="sha256-Y26AMvaIfrZ1EQU49pf6H4QzVTrOI8m9wQYKkftBt4s="
		crossorigin="anonymous"></script>
	<script>
<%-- 사이드바 선택 표시 --%>
		$(function() {
			$('#mainUl>li').eq(0).css('background-color', '#34734e');
			$('#mainUl>li>a').eq(0).css('color', 'white');
			$('#mainUl>li>a').eq(0).css('font-weight','bolder');
		});
<%-- 그래프설정 --%>
<%-- 그래프 1 일일 방문자 --%>
		$(function() {
			var context1 = document.getElementById('enterHome').getContext('2d');
			var yester = ${dayMap.yester};
			var today = ${dayMap.today};
			var enterHome = new Chart(context1,{
				type:'bar',
				data:{
					labels:['어제','오늘'],
					datasets:[{
						label: '일일 방문자 수', // 차트 제목
						fill:false, // line 형태일 때 선 안쪽을 채울지 말지
						data: [yester, today],
						backgroundColor:[
							'rgba(255,99,132,0.2)',
							'rgba(54,162,235,0.2)'
						],
						borderColor:[
							'rgba(255,99,132,1)',
							'rgba(54,162,235,1)'
						],
						borderWidth:1
					}]
				},
				options:{
					maintainAspectRatio: false, //false일 경우 포함된 div의 크기에 맞춰서 그려짐.
					scales:{
						y:{
							beginAtZero:true
						}
					}
				}
			});
		});
<%-- 그래프2 일일 가입자 --%>
		$(function(){
			var context2 = document.getElementById('joinCount').getContext('2d');
			var yesterMember = ${joinMap.yester};
			var todayMember = ${joinMap.today};
			var yesterFarm = ${farmMap.yester};
			var todayFarm = ${farmMap.today};
			var joinCount = new Chart(context2,{
				type:'bar',
				data:{
					labels:['어제(회원)','오늘(회원)','어제(농가)','오늘(농가)'],
					datasets:[{
						label: '일일 가입자 수', // 차트 제목
						fill:false, // line 형태일 때 선 안쪽을 채울지 말지
						data: [yesterMember, todayMember, yesterFarm, todayFarm],
						backgroundColor:[
							'rgba(255,99,132,0.2)',
							'rgba(54,162,235,0.2)',
							'rgba(255, 159, 64, 0.2)',
							'rgba(75, 192, 192, 0.2)'
						],
						borderColor:[
							'rgba(255,99,132,1)',
							'rgba(54,162,235,1)',
							'rgba(255, 159, 64, 1)',
							'rgba(75, 192, 192, 1)'
						],
						borderWidth:1
					}]
				},
				options:{
					maintainAspectRatio: false, //false일 경우 포함된 div의 크기에 맞춰서 그려짐.
					scales:{
						y:{
							beginAtZero:true
						}
					}
				}
			});
		});
		$(function(){
			var context = document.getElementById('test').getContext('2d');
			var num1 = ${sugMap.BID_SELL_YN };
			var num2 = ${sugMap.QUSER_ANSWER_YN };
			var num3 = ${sugMap.QFARM_ANSWER_YN };
			var num4 = ${sugMap.REFUND_YN };
			var test = new Chart(context,{
				type:'bar',
				data:{
					labels:['판매대기','유저문의','농가문의','환불대기'],
					datasets:[{
						label:'추천 작업',
						data: [num1,num2,num3,num4],
						backgroundColor:[
							'rgba(255,99,132,0.2)',
							'rgba(54,162,235,0.2)',
							'rgba(255, 159, 64, 0.2)',
							'rgba(75, 192, 192, 0.2)'
						],
						borderColor:[
							'rgba(255,99,132,1)',
							'rgba(54,162,235,1)',
							'rgba(255, 159, 64, 1)',
							'rgba(75, 192, 192, 1)'
						],
						borderWidth:1
					}],
				},
				options:{
					maintainAspectRatio: false, //false일 경우 포함된 div의 크기에 맞춰서 그려짐.
					indexAxis: 'y',
					scales:{
						y:{
							beginAtZero:true
						}
					}
				},
				plugins:{
					legend:{
						position: 'right',
					}
				},
			});
		});
		$(function(){
			var context = document.getElementById('refundData').getContext('2d');
			var purchase = ${sugMap.PURCHASE};
			var refund = ${sugMap.REFUND};
			$('#refundPer').html("&nbsp&nbsp환불 비율 : "+Math.round(refund/purchase*100)+"%");
			var test = new Chart(context, {
					type:'pie',
					data:{
					labels:['구매수','환불수'],
					datasets:[{
						label: '환불 비율',
						data:[purchase, refund],
						backgroundColor: [
							'rgba(75, 192, 192, 0.4)',
							'rgb(255, 99, 132, 0.4)'
						],
						hoverOffset:2
					}]
				},
				options:{
					maintainAspectRatio: false,
				}
			})
		});
<%-- tr 클릭시 해당 글로 이동하는 로직 --%>
		$('.userQNA').click(function(){
			var qBoardNo = $(this).children().eq(0).html();
			location.replace("/admin/adminUserQNAContent.do?questionUserNo="+qBoardNo)
		});
		$('.farmQNA').click(function(){
			var qBoardNo = $(this).children().eq(0).html();
			location.replace("/admin/adminFarmQNAContent.do?questionFarmNo="+qBoardNo);
		});
	</script>
</body>
</html>