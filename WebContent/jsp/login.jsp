<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<form action="../jp.co.aforce.servlets/login" method="post">

<p>ログイン名<input type="text" name="id"required="required"></p>
<p>パスワード<input type="password" name="password"required="required"></p>
<p><input type ="submit" value ="ログイン"></p>

</form>

<%@include file="../footer.html" %>