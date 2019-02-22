<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/datepicker/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
<title>添加患者</title>
<style type="text/css">
	th {
		text-align: center;
	}
	
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<iframe src="${pageContext.request.contextPath}/iframe/nav.html" width="100%" frameborder="0"></iframe>
		</div>
		
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!--信息管理table-->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" align="center" style="text-align: center;">
				<form class="form-inline" action="${pageContext.request.contextPath}/insertExam" method="get">
						<table align="center" class="table  table-bordered" style="width:70%;">
							<tr class="bg-info">
								<td style="text-align: center;" colspan="4"><span style="font-size: 20px;font-weight: bold;">药品审核</span></td>
							</tr>
							<!---->
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">药品名</td>
								<input type="hidden" name="dId" value="${requestScope.drug.id}">
								<td><input readonly="readonly" type="text" style="width: 90%;" placeholder="请输入药品名" value="${requestScope.drug.name}" class="form-control" ></td>
								<td style="width: 15%; vertical-align: middle">生产厂商</td>
								<td><input readonly="readonly" type="text" style="width: 90%;" placeholder="请输入制药厂" value="${requestScope.drug.productCompany}" class="form-control" ></td>
							</tr>
							
							<tr class="active">
								<td colspan="1" style="width: 15%; vertical-align: middle">审核意见</td>
                                <c:if test="${requestScope.exam.examStatus==1}">
                                    <td>通过：<input type="radio" name="examStatus" value="1" checked="checked"/></td>
                                </c:if>
                                <c:if test="${requestScope.exam.examStatus==2}">
                                    <td>通过：<input type="radio" name="examStatus" value="1" /></td>
                                </c:if>
                                <c:if test="${requestScope.exam.examStatus==null}">
                                    <td>通过：<input type="radio" name="examStatus" value="1" /></td>
                                </c:if>
                                <c:if test="${requestScope.exam.examStatus==1}">
                                    <td colspan="2">
                                        不予通过：<input type="radio" name="examStatus" value="2" />
                                    </td>
                                </c:if>
                                <c:if test="${requestScope.exam.examStatus==2}">
                                    <td colspan="2">
                                        不予通过：<input type="radio" name="examStatus" value="2" checked="checked" />
                                    </td>
                                </c:if>
                                <c:if test="${requestScope.exam.examStatus==null}">
                                    <td colspan="2">
                                        不予通过：<input type="radio" name="examStatus" value="2" />
                                    </td>
                                </c:if>

							</tr>
							
							
							<tr class="active">
								<td style="width: 15%; vertical-align: middle">审核意见</td>
								<td colspan="3">
									<textarea name="examAdvice" class="form-control" style="width: 96%;" rows="5" cols="">${requestScope.exam.examAdvice}</textarea>
									
								</td>
							</tr>
							
							<tr>
								<td colspan="4"><input type="submit" style="width: 200px;" class="btn btn-success" value="添加"></td>
							</tr>
						</table>
					</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<!--底部-->
		<div class="row">
			<div class="com-md-12">
				<!--底部-->
				<footer class="modal-footer navbar-fixed-bottom">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8" style="text-align: left;">
							&trade;百知教育 网址:<a href="http://www.baizhiedu.com">http://www.baizhiedu.com</a>
						</div>
						<div class="col-md-2"></div>
					</div>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>
