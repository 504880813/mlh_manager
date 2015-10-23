<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改角色</title>
</head>
<body>
角色信息：
<br />
<form action="${pageContext.request.contextPath}/role/${role.id ==null ? 'addroleSubmit' : 'editroleSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${role.id}" />
	角色名称<input type="text" name="name" value="${role.name}" > <br />
	角色值<input type="text" name="value" value="${role.value}" > <br />
	角色描述<input type="text" name="description" value="${role.description}" > <br />
	
	<!-- 权限。。 -->
								<table>
									<tr>
										<td class="tdFormLabel" colspan="2">
											<table>
												<tr>
													<td width="45%" align="right">
							<!-- 							<s:select id="left" 
															name="ownRightIds" 
															list="rights" 
															listKey="id" 
															listValue="rightName"
															multiple="true"
															size="15"
															cssStyle="width:100px">
														</s:select> -->
														<select id="left" name="ownRightIds" Style="width:100px"  multiple="true" size="15">
															<c:forEach items="${role.rights }" var="right">
																<option value ="${right.id }">${right.name}</option>
															</c:forEach>
														</select>
													</td>
													<td width="10%" valign="middle" align="center">
														<input type="button" id="one1" value="&gt;" class="btn"></input><br><br>
														<input type="button" id="one2" value="&lt;" class="btn"></input><br><br>
														<input type="button" id="all1" value="&gt;&gt;" class="btn"></input><br><br>
														<input type="button" id="all2" value="&lt;&lt;" class="btn"></input><br><br>
													</td>
													<td width="45%" align="left">
														<!-- <s:select id="right" 
															list="noOwnRights" 
															name="noOwnRightIds"
															listKey="id" 
															listValue="rightName"
															multiple="true"
															size="15"
															cssStyle="width:100px">
														</s:select> -->
														<select id="right" name="noOwnRightIds" style="width:100px;" multiple="true" size="15">
															<c:forEach items="${Norights }" var="right">
																<option value ="${right.id}">${right.name}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td class="tdFormLabel"></td>
										<td class="tdFormControl"><input type="submit" value="submit" onclick='return submitForm1()'/></td>
									</tr>
								</table>
</form>
</body>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css"> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/role/saveoreditRole.js"></script>
</html>