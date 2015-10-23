<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改菜品</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/saveoredit.js"></script>

</head>
<body>
菜品信息：
<c:if test="${errors!=null }">
<c:forEach items="${errors}" var="error">
	${error.defaultMessage }<br/>
</c:forEach>
</c:if>
<br />
<form action="${pageContext.request.contextPath}/dish/${dish.id ==null ? 'addDishSubmit' : 'editDishSubmit'}.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${dish.id}" />
	菜品名<input type="text" name="name" value="${dish.name }" />
	价格<input type="text" name="price" value="${dish.price }" />
	分类:<br />
	<c:forEach items="${ categorys}" var="category"> 
		<input type="radio" name="rcategoryid" id="rcategoryid" value="${category.id }" ${dish.rcategoryid==category.id?'checked':'' }>${category.name }
	</c:forEach>
	<br />
	子材料类型：
	<c:if test="${dish.id==null }">
	<div id="images">
		<input type="button" value="addImages" onclick="CloneNodeByid('dishImages','images')">
		<input type="button" value="removeImages" onclick="removeNodeByid('dishImages')"><br/>
		<input type="file" name="dishImages" id="dishImages"><br>
	</div>
<!-- 	<input type="file" name="dishImages" id="dishImages">
	<input type="file" name="dishImages" id="dishImages"> -->
	</c:if>
	<label><input   type="radio" onclick="showDishes('${hasAuxiliarydishesid}','${hasAuxiliarydishesQuantitys }')" />套餐</label> 
	<label><input  type="radio" onclick="showMaterials('${hasMaterialsid}','${ hasMaterialsQuantitys}')" />单菜</label> 
 	<%-- <c:if test="${dish.id!=null }">
		<input type="hidden" name="dishImages" id="dishImages" value="${dish. }">
		<input type="hidden" name="dishImages" id="dishImages" value="${ }">
	</c:if> --%>
	
	<div name="Materials" id="Materials" style="display:none">
		<c:forEach items="${Materials }" var="material">
			<input type="checkbox" name="MaterialsId" id="MaterialsId" class="MaterialsId" value="${material.id }" >${material.name }
			<input type="text" name="MaterialsQuantity" id="MaterialsQuantity" class="MaterialsQuantity">${material.unit }<br/>
		</c:forEach>
	</div>
	<div name="Dishes" id="Dishes" style="display:none">
		<c:forEach items="${Dishes}" var="Dish">
				<input type="checkbox" name="auxiliaryDish" id="auxiliaryDish" class="auxiliaryDish" value="${Dish.id }" >${Dish.name }
				<input type="text" name="subDishQuantity" id="subDishQuantity" >份 <br/>
		</c:forEach>
	</div>
	<input type="submit" value="submit"/>
</form>
</body>
</html>