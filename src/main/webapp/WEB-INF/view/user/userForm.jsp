<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- daum 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui API -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- jquery ui css -->
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<script>
	$(document).ready(function() {
		// 개발 과정에서 사용한 기본 값 설정
		$("#userId").val();
		$("#pass").val("pass1234");
		$("#name").val("testUserId");
		$("#addr1").val("대전광역시 중구 중앙로 76");
		$("#addr2").val("영민빌딩 2층 대덕인재개발원");
		$("#zipcd").val("34940");
		$("#birth").val("2018-08-08");
		$("#email").val("newUser@gmail.com");
		$("#tel").val("042-2222-8202");

		// 생일 input datepicker 적용
		$("#birth").datepicker({
			yearRange : "1900:2018",
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});

		// 주소 검색 버튼 클릭이벤트가 발생 했을 때 실행
		$("#addrSearchBtn").click(function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);
					// 주소 : roadAddress
					// 상세 주소:
					// 우편번호 : zonecode

					// 주소 input value 설정 : data.roadAddress
					$("#addr1").val(data.roadAddress);
					// 우편 input value 설정 : data.zonecode
					$("#zipcd").val(data.zonecode);
				}
			}).open();
		});
	});
</script>
<form class="form-horizontal" role="form" action="/user/userForm"
	method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<input type="file" name="profilePic">
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userId" name="userId"
				placeholder="사용자 아이디">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="비밀번호">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name"
				placeholder="사용자 이름">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr1" name="addr1"
				readonly placeholder="주소">
			<button type="button" class="btn btn-default" id="addrSearchBtn">주소검색</button>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr2" name="addr2"
				placeholder="상세주소">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="zipcd" name="zipcd"
				readonly placeholder="우편번호">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="birth" name="birth"
				placeholder="생년월일">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">이메일</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email" name="email"
				placeholder="이메일">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">연락처</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="tel" name="tel"
				placeholder="연락처">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">등록</button>

		</div>
	</div>
</form>

