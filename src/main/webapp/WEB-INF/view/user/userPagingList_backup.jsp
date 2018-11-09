<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>userPagingList.jsp</title>

<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
<style type="text/css">
	.userClick{
		cursor : pointer;
	}
</style>
<script type="text/javascript">

// 테이블 클릭시 alert창 띄우기
	/*$(document).ready(function addRowHandlers() {
		var table = document.getElementById("tableId");
		var rows = table.getElementsByTagName("tr");
		for (i = 0; i < rows.length; i++) {
			var currentRow = table.rows[i];
			var createClickHandler = 
			function(row) {
				return function() {
					var cell = row.getElementsByTagName("td")[1];
					var id = cell.innerHTML;
					alert("사용자 아이디 : " + id);
				};
			};
			currentRow.onclick = createClickHandler(currentRow);
		}
	});*/
	/*
	function alertId(userId){
		alert("사용자 아이디 : "+ userId);
		location.href = "/userDetail?userId="+userId;
	}*/
	
	// 교수님 방법
	$(document).ready(function(){
		console.log("document.ready"); // 브라우저 개발자 도구의 console창에 보임(f12)
		
		// tr에 select (class="userClick")
		/*$(".userClick").click(function(){
			
		});*/
		
		var ev = "click";
		$(".userClick").on(ev, function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML; // userId 구하기
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
	});
</script>

</head>
<form action="/user/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name="userId" />
</form>
<body>
	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/WEB-INF/view/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover" id="tableId">
								<tr>
									<th>번호</th>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>생일</th>
								</tr>
								<!-- userList loop -->
								
								<c:forEach items="${userList }" var="vo">
									<tr class="userClick">
										<td>${vo.rnum }</td>
										<td>${vo.userId }</td>
										<td>${vo.name }</td>
										<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="/user/userPageList?page=<%=1%>&pageSize=10" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								
								<c:forEach begin="0" end="${pageCnt-1 }" var="i">
<%-- 									<c:if test="${i<5 }"> --%>
										<li><a href="/user/userPageList?page=${i+1 }&pageSize=10">${i+1 }</a>
<%-- 									</c:if> --%>
								</c:forEach>
								<li><a href="/user/userPageList?page=${pageCnt }&pageSize=10" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
