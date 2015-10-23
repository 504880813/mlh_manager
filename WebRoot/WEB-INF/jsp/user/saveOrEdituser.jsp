<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JspbaseTemplate/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加或修改用户</title>
</head>
<body>
用户信息：
<br />
<form action="${pageContext.request.contextPath}/user/${user.id ==null ? 'addUserSubmit' : 'editUserSubmit'}.action" method="post">
	<input type="hidden" name="id" value="${user.id}" />
	用户名称<input type="text" name="username" value="${user.username}" > <br />
	用户密码<input type="text" name="password"> <br />
	是否为超级管理员<select id="superadmin" name="superadmin">
					<option value="false">否</option>
					<option value="true">是</option>
			   </select>
	<!-- 权限。。 -->
								<table>
									<tr>
										<td class="tdFormLabel" colspan="2">
											<table>
												<tr>
													<td width="45%" align="Role">
							<!-- 							<s:select id="left" 
															name="ownRoleIds" 
															list="roles" 
															listKey="id" 
															listValue="RoleName"
															multiple="true"
															size="15"
															cssStyle="width:100px">
														</s:select> -->
														<select id="left" name="ownRoleIds" Style="width:100px"  multiple="true" size="15">
															<c:forEach items="${user.roles }" var="Role">
																<option value ="${Role.id }">${Role.name}</option>
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
															list="noOwnroles" 
															name="noOwnRoleIds"
															listKey="id" 
															listValue="RoleName"
															multiple="true"
															size="15"
															cssStyle="width:100px">
														</s:select> -->
														<select id="right" name="noOwnRoleIds" style="width:100px;" multiple="true" size="15">
															<c:forEach items="${Noroles }" var="Role">
																<option value ="${Role.id}">${Role.name}</option>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/saveoredituser.js"></script>
</html>