<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %>       
  <article>
    <h1>Login</h1>
    <form method="post" action="login.do">
        <fieldset>
        <legend></legend>
          <label>User ID</label>
          <input name="id" type="text" value="${id}" value="one"><br> 
          <label>Password</label> 
          <input name="pwd" type="password" value="1111"><br> 
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="ログイン" class="submit">
            <input type="button" value="会員加入" class="cancel" onclick="location='join_form.do'">
            <input type="button" value="IDパスワード探し" class="submit" onclick="location='find_id_form.do'">     
        </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>      
