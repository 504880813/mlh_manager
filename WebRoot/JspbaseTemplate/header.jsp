<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="random" uri="http://www.rms.com/CustomTag" %>

<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/system/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/system/css.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/system/errorStyles.css" />


<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/system/laydate/laydate.js"></script>
<script type="text/javascript">
Date.prototype.format=function(fmt) {        
    var o = {        
    "M+" : this.getMonth()+1, //月份        
    "d+" : this.getDate(), //日        
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时        
    "H+" : this.getHours(), //小时        
    "m+" : this.getMinutes(), //分        
    "s+" : this.getSeconds(), //秒        
    "q+" : Math.floor((this.getMonth()+3)/3), //季度        
    "S" : this.getMilliseconds() //毫秒        
    };        
    var week = {        
    "0" : "\u65e5",        
    "1" : "\u4e00",        
    "2" : "\u4e8c",        
    "3" : "\u4e09",        
    "4" : "\u56db",        
    "5" : "\u4e94",        
    "6" : "\u516d"       
    };        
    if(/(y+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));        
    }        
    if(/(E+)/.test(fmt)){        
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);        
    }        
    for(var k in o){        
        if(new RegExp("("+ k +")").test(fmt)){        
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));        
        }        
    }        
    return fmt;        
} 
</script>

<div class="header">
	 <div class="logo"><img  src="${pageContext.request.contextPath }/img/logo.png" /></div>
		<div class="header-right">
               
                <c:if test="${sessionScope.OnlineUser==null }">
               		<i class="icon-off icon-white"></i> 
					<a href="${pageContext.request.contextPath }/user/login.action">登陆</a>
				</c:if>
               <c:if test="${sessionScope.OnlineUser!=null }">
             		<a href="#"> 欢迎 ${ sessionScope.OnlineUser.username }</a>
               		<i class="icon-off icon-white"></i> 
					<a id="modal-973558" href="#modal-container-973558"  data-toggle="modal">注销</a>
				</c:if>
               
                
                <div id="modal-container-973558" class="modal hide fade"  style="width:300px; margin-left:-150px; top:30%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" >×</button>
					<h3 id="myModalLabel">
						注销系统
					</h3>
				</div>
				<div class="modal-body">
					<p>
						您确定要注销退出系统吗？
					</p>
				</div>
				<div class="modal-footer">
					 <button class="btn" data-dismiss="modal" >关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="${pageContext.request.contextPath }/user/logout.action" >确定退出</a>
				</div>
			</div>
		</div>
</div>
<%-- <c:if test="${sessionScope.OnlineUser==null }">
<a href="${pageContext.request.contextPath }/user/login.action">登陆</a>
</c:if>
<c:if test="${sessionScope.OnlineUser!=null }">
欢迎 ${ sessionScope.OnlineUser.username }
<a href="${pageContext.request.contextPath }/user/logout.action">注销</a>
</c:if>
<random:Right_A uri="${pageContext.request.contextPath }/index.jsp">主页</random:Right_A><br /> --%>
<hr />