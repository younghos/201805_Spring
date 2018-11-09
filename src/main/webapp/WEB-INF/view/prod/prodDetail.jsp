<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form class="form-horizontal" role="form" action="#" method="get"
	enctype="multipart/form-data">

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">제품 아이디</label>
		<div class="col-sm-10">
			<label class="control-label">${prodVo.prod_id }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">제품명</label>
		<div class="col-sm-10">
			<label class="control-label">${prodVo.prod_name }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">제품그룹명</label>
		<div class="col-sm-10">
			<label class="control-label">${prodVo.lprod_nm }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">바이어 이름</label>
		<div class="col-sm-10">
			<label class="control-label">${prodVo.buyer_name }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">바이어이메일</label>
		<div class="col-sm-10">
			<label class="control-label">${prodVo.buyer_mail }</label>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">수정</button>
			<input type="hidden" name="prodId" value="${prodVo.prod_id }" />
		</div>
	</div>
</form>
