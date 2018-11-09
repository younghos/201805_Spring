<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
.userClick {
	cursor: pointer;
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
	$(document).ready(function() {
		console.log("document.ready"); // 브라우저 개발자 도구의 console창에 보임(f12)

		// tr에 select (class="userClick")
		/*$(".userClick").click(function(){
			
		});*/

		var ev = "click";
		$("#userList").on(ev, ".userClick", function() {
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML; // userId 구하기

			$("#userId").val(userId);
			$("#frm").submit();
		});
		
// 		getUserList(1);
		getUserListHtml(1); // userList를 html로 리턴해주는 함수
		
	});
	
	function getUserListHtml(page){
		var pageSize = 10;
		$.ajax({
			type : "GET",
			url  : "/user/userPageListAjaxHtml",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				$("#userList").html(dt);
				getUserPagenationHtml(1); // 해당페이지의 페이지 네이션 정보를 리턴해주는 함수
			}
		});
	}
	
	function getUserPagenationHtml(page){
		var pageSize = 10;
		$.ajax({
			type : "GET",
			url  : "/user/userPagenationAjaxHtml",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				$(".pagination").html(dt);
			}
		});
	}
	// page, pageSize 인자를 받아서
	// 해당 페이지에 속하는 사용자 리스트 정보를 가져온다.
	function getUserList(page){
		var pageSize = 10;
		
		// ajax call
		// 사용자 리스트 데이터만 가져오기
		// html(as-is) -> json(to-be) 데이터를 받는 형태로 변경
		$.ajax({
			type : "GET",
			url : "/user/userPageListAjax",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(data){
				// data(사용자 json 데이터)를 바탕으로
				// 사용자 리스트를 갱신
				// 1. 기존 리스트 삭제
				// 2. date를 이용하여 table 태그 tr)를 작성
				// 3. 기존 리스트 위치에다가 붙여넣기
				var html = "";
				$.each(data.userList, function(idx, user){
					console.log(user);
					html += "<tr class='userClick'>";
					html += "	<td>"+user.rnum+"</td>";
					html += "	<td>"+user.userId+"</td>";
					html += "	<td>"+user.name+"</td>";
					html += "	<td>"+user.formattedBirth+"</td>";
					html += "</tr>";
					
				});
				
				$("#userList").html("");
				$("#userList").html(html);
				
					
				var html2 = "";
				html2 += "<li>";
				html2 += "	<a href='javascript:getUserList(1);' aria-label='Previous'>";
				html2 += "	<span aria-hidden='true'>&laquo;</span>";
				html2 += "	</a>";
				html2 += "</li>";
				for(var i=1; i<=data.pageCnt;i++){
					html2 += "<li>";
					html2 += "	<a href='javascript:getUserList("+i+");'>"+i+"</a>";
					html2 += "</li>";
				}
				html2 += "<li>";
				html2 += "	<a href='javascript:getUserList("+data.pageCnt+");' aria-label='Previous'>";
				html2 += "	<span aria-hidden='true'>&raquo;</span>";
				html2 += "	</a>";
				html2 += "</li>";
				
				$(".pagination").html("");
				$(".pagination").html(html2);
				
			}
		});
	}
</script>

</head>
<form action="/user/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name="userId" />
</form>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id="tableId">
				<thead>
					<tr>
						<th>번호</th>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>생일</th>
					</tr>
				</thead>
				<!-- userList loop -->

				<tbody id="userList">
<!-- 					<tr class="userClick"> -->
<%-- 						<td>${vo.rnum }</td> --%>
<%-- 						<td>${vo.userId }</td> --%>
<%-- 						<td>${vo.name }</td> --%>
<%-- 						<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd" /></td> --%>
<!-- 					</tr> -->
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
<%-- 				<li><a href="/user/userPageList?page=<%=1%>&pageSize=10" --%>
<!-- 					aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="javascript:getUserList(1);" -->
<!-- 					aria-label="Previous"> <span aria-hidden="true">&laquo;</span> -->
<!-- 				</a></li> -->

<%-- 				<c:forEach begin="1" end="${pageCnt }" var="i"> --%>
<%-- 					<li><a href="/user/userPageList?page=${i+1 }&pageSize=10">${i+1 }</a> --%>
<%-- 					<li><a href="javascript:getUserList(${i });">${i }</a></li> --%>
<%-- 				</c:forEach> --%>
<%-- 				<li><a href="javascript:getUserList(${pageCnt });" --%>
<!-- 					aria-label="Next"> <span aria-hidden="true">&raquo;</span> -->
<!-- 				</a></li> -->
			</ul>
		</div>
	</div>
</div>