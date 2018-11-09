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

<title>prodPagingList.jsp</title>

<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
<style type="text/css">
	.prodClick{
		cursor : pointer;
	}
</style>
<script type="text/javascript">
	// 교수님 방법
	$(document).ready(function(){
		var ev = "click";
		$(".prodClick").on(ev, function(){
			console.log("prodClick");
			var prod_id = $(this).children()[1].innerHTML; // userId 구하기
			
			$("#prodId").val(prod_id);
			$("#frm").submit();
		});
	});
</script>

</head>
<form action="/prod/prodDetail" method="get" id="frm">
	<input type="hidden" id="prodId" name="prodId" />
</form>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/WEB-INF/view/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover" id="tableId">
								<tr>
									<th>번호</th>
									<th>제품 아이디</th>
									<th>제품명</th>
									<th>제품그룹명</th>
									<th>제품등록일</th>
								</tr>
								<!-- userList loop -->
								
								<c:forEach items="${prodList }" var="vo">
									<tr class="prodClick">
										<td>${vo.rnum }</td>
										<td>${vo.prod_id }</td>
										<td>${vo.prod_name }</td>
										<td>${vo.lprod_nm }</td>
										<td><fmt:formatDate value ="${vo.prod_insdate }" pattern = "yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						
						<a class="btn btn-default pull-right" href="#">제품 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="/prod/prodPageList?page=<%=1%>&pageSize=10" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								
								<c:forEach begin="0" end="${pageCnt-1 }" var="i">
									<li><a href="/prod/prodPageList?page=${i+1 }&pageSize=10">${i+1 }</a>
								</c:forEach>
								<li><a href="/prod/prodPageList?page=${pageCnt }&pageSize=10" aria-label="Next"> <span
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