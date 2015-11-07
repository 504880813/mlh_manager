<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改菜品</title>


</head>
<body>

<%@ include file="/JspbaseTemplate/header.jsp" %>
<%@ include file="/JspbaseTemplate/left.jsp" %>


<div class="right" id="mainFrame">
     
<div class="right_cont">
   
   <div class="title_right"><strong>添加或修改菜品信息</strong></div>
   <div style="width:900px; margin:auto">
  <form action="${pageContext.request.contextPath}/dish/${dish.id ==null ? 'addDishSubmit' : 'editDishSubmit'}.action" method="post" enctype="multipart/form-data">
   	<input type="hidden" name="id" value="${dish.id}" />
   <table  class="table table-bordered">
     <tbody>
       <tr>
	
       <td align="right" bgcolor="#f1f1f1" >菜品名</td>
       <td>
	       <input type="text" name="name" value="${dish.name }" />
	   </td>
     </tr>
       <tr>
       <td align="right" bgcolor="#f1f1f1" >价格</td>
       <td>
	       <input type="text" name="price" value="${dish.price }" />
	   </td>
     </tr>
       <tr>
       <td align="right" bgcolor="#f1f1f1" >分类</td>
       <td>
	       	<c:forEach items="${ categorys}" var="category"> 
				<input type="radio" name="rcategoryid" id="rcategoryid" value="${category.id }" ${dish.rcategoryid==category.id?'checked':'' }>${category.name }
			</c:forEach>
	   </td>
     </tr>
     	<c:if test="${dish.id==null }">
     	<tr>
     	 <td align="right" bgcolor="#f1f1f1" >图片集</td>
     	 <td>
			<div id="images">
			<input type="button" value="addImages" onclick="CloneNodeByid('dishImages','images')">
			<input type="button" value="removeImages" onclick="removeNodeByid('dishImages')"><br/>
			<input type="file" name="dishImages" id="dishImages"><br>
			</div>
		</td>
		</tr>
			<!-- 	<input type="file" name="dishImages" id="dishImages">
			<input type="file" name="dishImages" id="dishImages"> -->
		</c:if>
       <tr>
       <td align="right" bgcolor="#f1f1f1" >子材料类型</td>
       <td>
	       	<label><input   type="radio" onclick="showDishes('${hasAuxiliarydishesid}','${hasAuxiliarydishesQuantitys }')" />套餐</label> 
			<label><input  type="radio" onclick="showMaterials('${hasMaterialsid}','${ hasMaterialsQuantitys}')" />单菜</label> 
	   </td>
     </tr>
      <tr>
       <td align="right" bgcolor="#f1f1f1" >子材料</td>
       <td>
	       		<div name="Materials" id="Materials" style="display:none">
					<c:forEach items="${Materials }" var="material">
					<input type="checkbox" name="MaterialsId" id="MaterialsId" class="MaterialsId" value="${material.id }" >${material.name }
					<input type="text" name="MaterialsQuantity" id="MaterialsQuantity" class="MaterialsQuantity">${material.unit }<br/>
					</c:forEach>
				</div>
				<div name="Dishes" id="Dishes" style="display:none">
					<c:forEach items="${Dishes}" var="Dish">
					<input type="checkbox" name="auxiliaryDish" id="auxiliaryDish" class="auxiliaryDish" value="${Dish.id }" >${Dish.name }
					<input type="text" name="subDishQuantity" id="subDishQuantity" class="subDishQuantity" >份 <br/>
					</c:forEach>
				</div>
	   </td>
     </tr>
   	</tbody>
   </table>
   <table class="margin-bottom-20 table  no-border">
        <tbody><tr>
     	<td class="text-center"><input value="确定" class="btn btn-info " style="width:80px;" type="submit"></td>
     </tr>
 	</tbody>
  </table>
 	<!-- <div id="cardMessage"></div> -->
   </form>   
   </div> 
  </div>     
</div>

<%@ include file="/JspbaseTemplate/footer.jsp" %> 
















<%-- 菜品信息：
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
 	<c:if test="${dish.id!=null }">
		<input type="hidden" name="dishImages" id="dishImages" value="${dish. }">
		<input type="hidden" name="dishImages" id="dishImages" value="${ }">
	</c:if>
	
	<div name="Materials" id="Materials" style="display:none">
		<c:forEach items="${Materials }" var="material">
			<input type="checkbox" name="MaterialsId" id="MaterialsId" class="MaterialsId" value="${material.id }" >${material.name }
			<input type="text" name="MaterialsQuantity" id="MaterialsQuantity" class="MaterialsQuantity">${material.unit }<br/>
		</c:forEach>
	</div>
	<div name="Dishes" id="Dishes" style="display:none">
		<c:forEach items="${Dishes}" var="Dish">
				<input type="checkbox" name="auxiliaryDish" id="auxiliaryDish" class="auxiliaryDish" value="${Dish.id }" >${Dish.name }
				<input type="text" name="subDishQuantity" id="subDishQuantity" class="subDishQuantity" >份 <br/>
		</c:forEach>
	</div>
	<input type="submit" value="submit"/>
</form> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dish/saveoredit.js"></script>
</html>