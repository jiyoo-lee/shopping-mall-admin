<%@page import="java.util.List"%>
<%@page import="admin.notice.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  	request.setCharacterEncoding("utf-8");
  	List<NoticeDTO> notices = (List<NoticeDTO>)request.getAttribute("notices");
  %> 
<meta charset="UTF-8">
<p>공지사항 관리페이지</p>
<div class="subpage_view">
<ul>
    <li><input type="checkbox" name="deleteCheck" onclick="selectAll(this)"></li>
    <li>NO</li>
    <li>제목</li>
    <li>글쓴이</li>
    <li>날짜</li>
    <li>조회</li>
</ul>
<%if(notices.size() != 0){ %>
<%for(NoticeDTO notice : notices){ %>
<ol>
    <li><input type="checkbox" name="deleteCheck" value="<%=notice.getId()%>"></li>
    <li><%=notice.getRow()%></li>
    <li><a href="./noticeview?page=<%=notice.getId()%>"style="color: black"><%=notice.getTitle()%></a></li>
    <li><%=notice.getWriter() %></li>
    <li><%=notice.getCreateDatetime().substring(0,10)%></li>
    <li><%=notice.getViews() %></li>
</ol>
<% } %>
<%}else{ %>
<ol class="none_text">
    <li>등록된 공지 내용이 없습니다.</li>
</ol>
<%} %>
</div>
<div class="board_btn">
    <button class="border_del" onclick="noticeDeletor()">공지삭제</button>
    <button class="border_add" onclick="noticeRegistor()">공지등록</button>
</div>
<div class="border_page">
    <ul class="pageing">
        <li><img src="./ico/double_left.svg"></li>
        <li><img src="./ico/left.svg"></li>
        <li>1</li>
        <li><img src="./ico/right.svg"></li>
        <li><img src="./ico/double_right.svg"></li>
    </ul>
</div>