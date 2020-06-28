<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form  id="specForm">
			<div class="form-group row">
				<input type="hidden" name="id" value="${spec.id}">
			    <label for="specName" class="col-sm-2 col-form-label">规格名称</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="specName" name="specName" value="${spec.specName}">
			    </div>
			 </div>
			 <div class="form-group row">
				 <div class="col-sm-1">
				 </div>
			 	<div class="col-sm-6">
			 	<table id="table">
			 		<tr>
			 			<td>属性名称</td>
			 			<td>显示顺序</td>
			 			<td><button type="button" onclick="addLine()">添加</button></td>
			 		</tr>
			 		<c:forEach items="${spec.optios}" var="option" varStatus="index">
			 			<tr>
				 			<td><input value="${option.optionName}" name="optios[${index.index}].optionName"></td>
				 			<td><input value="${option.orders}" type="number" name="optios[${index.index}].orders"></td>
				 			<td><button type="button" onclick="removeLine($(this))">删除</button></td>
			 			</tr>
			 		</c:forEach>
			 		
			 	</table>
			 	</div>
			 </div>
			 <div class="form-group row">
			 	<button type="button" onclick="commitData()">提交</button>
			 </div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var index=${spec.optios.size()};
	function addLine(){
		
		$("#table").append('<tr><td><input name="optios['+index+'].optionName"></td><td><input type="number" name="optios['+index+'].orders"></td><td><button type="button" onclick="removeLine($(this))">删除</button></td></tr>')
		index++;
	}
	function removeLine(obj){
		$(obj).parent().parent().remove();
		
	}
	function commitData(){
		var formData=new FormData($('#specForm')[0]);
		$.ajax({
			url:"/spec/Update",
			data:formData,
			type:"post",
			contentType:false,
			processData:false,
			success:function(flag){
				if(flag){
					alert("修改成功");
					$("#workContent").load("/spec/list");
				}else{
					alert("修改失败")
				}
			}
		})
	}
</script>
</html>