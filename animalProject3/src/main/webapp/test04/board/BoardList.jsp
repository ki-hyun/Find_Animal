<%@page import="java63.servlets.test04.domain.Board"%>
<%@page import="java.util.List"%>
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
<div class='container'>
<table class='table table-hover'>
<br>
<br>
<br>
<tr>
<th>#</th>
<th>사진</th>
<th>품종</th>
<th>제목</th>
<th>발견장소</th>
<th>발견날짜</th>
<th>조회</th>
</tr>
<%
List<Board> boards = 
(List<Board>)request.getAttribute("boards");
int pageNo = (Integer)request.getAttribute("pageNo");
int pagingCount = (((pageNo - 1) / 5) + 1) * 5;

for (Board board :boards) {
%>
   <tr>
   <td><%=board.getNo()%></td>
   <td><a href='view?no=<%=board.getNo()%>'><img src=../../photo/<%=board.getPhoto()%> width=100></a></td>
   <td><%=board.getBreed()%></td>
   <td><a href='view?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
   <td><%=board.getFindPlace()%></td>
   <td><%=board.getFindDate()%></td>
   <td>3</td>
   </tr>
<% } %>


</table>
<div class='container'>
<table>
<tr>
<td class='customPadding'>
<select class='form-control'>
<option>품종</option>
<option>페르시안고양이</option>
<option>브리티시 숏헤어</option>
<option>러시안 블루</option>
<option>노르웨이 숲</option>
<option>터키쉬 앙골라</option>
<option>샴 고양이</option>
<option>스코티시 폴드</option>
<option>셀커크렉스</option>
<option>뱅갈 고양이</option>
<option>아메리칸 숏헤어</option>
<option>아비시니안</option>
<option>먼치킨</option>
<option>사바나캣</option>
<option>메인쿤</option>
<option>코리안 숏헤어(korean shorthair)</option>
<option>기타</option>
</select>
</td>
<td class='customPadding'>
<nav>
<ul class='pagination'>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount-5%>'><span aria-hidden='true'>&lt;</span><span class='sr-only'>Previous</span></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount-4%>'><%=pagingCount-4%></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount-3%>'><%=pagingCount-3%></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount-2%>'><%=pagingCount-2%></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount-1%>'><%=pagingCount-1%></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount%>'><%=pagingCount%></a></li>
  <li><a class='pageClass' href='list?pageNo=<%=pagingCount+1%>'><span aria-hidden='true'>&gt;</span><span class='sr-only'>Next</span></a></li>
 </ul>
</nav>
</td>
<td class='customPadding'>
<a href='../member/boardAddF' class='btn btn-primary'>유기묘 등록</a>
</td>
</tr>
</table>
</div>
 </div>
<script src='../../js/jquery-1.11.1.js'></script>
<script>
$('a[href=list?pageNo=1]')
.parent().attr('class','active');
</script>
</body>
</html>
