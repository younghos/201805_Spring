<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form class="form-horizontal" role="form" action="/user/userUpdateForm"
	method="get" enctype="multipart/form-data">
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<c:choose>
				<c:when test="${userVo.profile != null }">
					<%-- 									<img src="${userVo.profile }" width="200" height="200"/> --%>
					<img src="${userVo.profile }" width="200" height="200" />
				</c:when>
				<c:otherwise>
					<img src="/profile/noImage.png" width="200" height="200" />
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.userId }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.name }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.addr1 }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.addr2 }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.zipcd }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<label class="control-label"><fmt:formatDate
					value="${userVo.birth }" pattern="yyyy-MM-dd" /></label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">이메일</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.email }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">연락처</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.tel }</label>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">수정</button>
			<input type="hidden" name="userId" value="${userVo.userId }" />
		</div>
	</div>
</form>
