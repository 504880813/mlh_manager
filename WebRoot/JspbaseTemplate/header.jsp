<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="random" uri="http://www.rms.com/CustomTag" %>
<c:if test="${sessionScope.OnlineUser==null }">
<a href="${pageContext.request.contextPath }/user/login.action">登陆</a>
</c:if>
<c:if test="${sessionScope.OnlineUser!=null }">
欢迎 ${ sessionScope.OnlineUser.username }
<a href="${pageContext.request.contextPath }/user/logout.action">注销</a>
</c:if>
<random:Right_A uri="${pageContext.request.contextPath }/index.jsp">主页</random:Right_A><br />
<hr />