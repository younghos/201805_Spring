<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
.prodClick {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	// 교수님 방법
	$(document).ready(function() {
		var ev = "click";
		$("#prodList").on(ev, ".prodClick", function() {
			var prod_id = $(this).children()[1].innerHTML; 

			$("#prodId").val(prod_id);
			$("#frm").submit();
		});
		
		getProdPageListJson(1);
// 		getProdListHtml(1);
// 		getProdPagenationHtml(1);
	});
	
	function getProdListHtml(page){
		var pageSize=10;
		$.ajax({
			type : "GET",
			url  : "/prod/prodPageListHtml",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				console.log(dt);
				$("#prodList").html(dt);
			}
		});
	}
	
	function getProdPagenationHtml(page){
		var pageSize = 10;
		$.ajax({
			type : "GET",
			url  : "/prod/prodPagenationHtml",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				$(".pagination").html(dt);
			}
		});
	}
	
	function getProdPageListJson(page){
		var pageSize=10;
		$.ajax({
			type : "GET",
			url  : "/prod/prodPageListJson",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				var html = "";
				$.each(dt.prodList, function(idx, prod){
					html += "<tr class='prodClick'>";
					html += "	<td>"+prod.rnum+"</td>";
					html += "	<td>"+prod.prod_id+"</td>";
					html += "	<td>"+prod.prod_name+"</td>";
					html += "	<td>"+prod.lprod_nm+"</td>";
					html += "	<td>"+prod.prod_date+"</td>";
					html += "</tr>";
				});
				
				$("#prodList").html("");
				$("#prodList").html(html);
				
				var html2 = "";
				html2 += "<li><a href=\"javascript:getProdListHtml(1)\" aria-label=\"Previous\">";
				html2 += "<span aria-hidden=\"true\">&laquo;</span>";
				html2 += "</a></li>";	
				for(var i=1;i<dt.pageCnt;i++){
					html2 += "<li><a href=\"javascript:getProdListHtml("+i+")\">"+i+"</a>";
				}
				html2 += "<li><a href=\"javascript:getProdListHtml("+dt.pageCnt+")\" aria-label=\"Next\">"; 
				html2 += "<span aria-hidden=\"true\">&raquo;</span>";
				html2 += "</a></li>";
				
				$(".pagination").html("");
				$(".pagination").html(html2);
			}
		});
	}
</script>

<form action="/prod/prodDetail" method="get" id="frm">
	<input type="hidden" id="prodId" name="prodId" />
</form>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">제품</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="tableId">
				<thead>
					<tr>
						<th>번호</th>
						<th>제품 아이디</th>
						<th>제품명</th>
						<th>제품그룹명</th>
						<th>제품등록일</th>
					</tr>
				</thead>
				
				<!-- prodList loop -->
				<tbody id="prodList">
<%-- 					<c:forEach items="${prodList }" var="vo"> --%>
<!-- 						<tr class="prodClick"> -->
<%-- 							<td>${vo.rnum }</td> --%>
<%-- 							<td>${vo.prod_id }</td> --%>
<%-- 							<td>${vo.prod_name }</td> --%>
<%-- 							<td>${vo.lprod_nm }</td> --%>
<%-- 							<td><fmt:formatDate value="${vo.prod_insdate }" --%>
<%-- 									pattern="yyyy-MM-dd" /></td> --%>
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="#">제품 등록</a>

		<div class="text-center">
			<ul class="pagination">
<!-- 				<li><a href="/prod/prodPageList?page=1&pageSize=10" -->
<!-- 					aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
<!-- 				</a></li> -->

<%-- 				<c:forEach begin="0" end="${pageCnt-1 }" var="i"> --%>
<%-- 					<li><a href="/prod/prodPageList?page=${i+1 }&pageSize=10">${i+1 }</a> --%>
<%-- 				</c:forEach> --%>
<%-- 				<li><a href="/prod/prodPageList?page=${pageCnt }&pageSize=10" --%>
<!-- 					aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
<!-- 				</a></li> -->
			</ul>
		</div>
	</div>
</div>