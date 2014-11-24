<%@page import="java63.servlets.test04.domain.Member"%>
<%@page import="java63.servlets.test04.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel='stylesheet'
    href='../../css/bootstrap.min.css'>
<link rel='stylesheet'
    href='../../css/bootstrap-theme.min.css'>
<link rel='stylesheet'
    href='../../css/common.css'>
</head>
<body>
<div class='container'>
<h1>길냥이 상세정보</h1>
<%
Board board = 
(Board)request.getAttribute("board");
Member member = 
(Member)request.getAttribute("member");
%>

<form class='form-horizontal' role='form' action='update' method='post'>
 <div class='form-group'>
 <label for='no' class='col-sm-2 control-label'>글쓴이</label>
 <div class='col-sm-10'>
  <input type='text' class='form-control'  readonly
     id='name' name='name' value='<%=member.getName()%>'>
  </div>
</div>
<div class='form-group'>
  <label for='name' class='col-sm-2 control-label'>연락처</label>
 <div class='col-sm-10'>
   <input type='text' class='form-control' 
      id='tel' name='tel' value='<%=board.getTel()%>'>
  </div>
  </div>
<div class='form-group'>
<label for='qty' class='col-sm-2 control-label'>발견날짜</label>
<div class='col-sm-10'>
   <input type='text' class='form-control' 
     id='findDate' name='findDate' value='<%=board.getFindDate()%>'>
 </div>
 </div>
<div class='form-group'>
<label for='mkno' class='col-sm-2 control-label'>발견장소</label>
<div class='col-sm-10'>
  <input type='text' class='form-control' 
   id='findPlace' name='findPlace' value='<%=board.getFindPlace()%>'>
 </div>
</div>
<div class='form-group'>
<label for='mkno' class='col-sm-2 control-label'>성별</label>
<div class='col-sm-10'>
  <input type='text' class='form-control' 
   id='gender' name='gender' value='<%=board.getGender()%>'>
 </div>
</div>
<div class='form-group'>
<label for='mkno' class='col-sm-2 control-label'>제목</label>
<div class='col-sm-10'>
  <input type='text' class='form-control' 
   id='title' name='title' value='<%=board.getTitle()%>'>
 </div>
</div>
<div class='form-group'>
<label for='mkno' class='col-sm-2 control-label'>내용</label>
<div class='col-sm-10'>
  <input type='text' class='form-control' 
   id='content' name='content' value='<%=board.getContent()%>'>
 </div>
</div>
<div class='form-group'>
<img src=../../photo/<%=board.getPhoto()%> width:300px>
</div>
<div class='form-group'>
 <div class='col-sm-offset-2 col-sm-10'>
  <button id='btnUpdate' type='submit' class='btn btn-primary'>변경</button>
  <button id='btnDelete' type='button' class='btn btn-primary'>삭제</button>
  <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>
 </div>
 </div>
</form>
</div>
<script src='../../js/jquery-1.11.1.js'></script>
<script>
 $('#btnCancel').click(function(){
  history.back();
 });
$('#btnDelete').click(function(){
 if (confirm('삭제하시겠습니까?')){
  location.href = 'delete?no=<%=board.getNo()%>';
 }
});
$('#btnUpdate').click(function() {
 if ($('#name').val().length == 0) {
  alert('글쓴이는 필수 입력 항목입니다.');
  return false;
 }
 if ($('#tel').val().length == 0) {
  alert('연락처는 필수 입력 항목입니다.');
  return false;
 }
 if ($('#findDate').val().length == 0) {
  alert('발견날짜는 필수 입력 항목입니다.');
  return false;
 }
 if ($('#findPlace').val().length == 0) {
  alert('발견장소는 필수 입력 항목입니다.');
  return false;
 }
 if ($('#gender').val().length == 0) {
  alert('성별은 필수 입력 항목입니다.');
  return false;
 }
 if ($('#title').val().length == 0) {
  alert('제목은 필수 입력 항목입니다.');
  return false;
 }
 if ($('#content').val().length == 0) {
  alert('내용은 필수 입력 항목입니다.');
  return false;
 }
});
</script>
</body>
</html>
