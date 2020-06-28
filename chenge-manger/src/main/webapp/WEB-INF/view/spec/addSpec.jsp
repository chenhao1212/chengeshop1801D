<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			    <label for="specName" class="col-sm-2 col-form-label">规格名称</label>
			    <div class="col-sm-4">
			      <input type="text" class="form-control" id="specName" name="specName">
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
			 		<tr>
			 			<td><input name="optios[0].optionName"></td>
			 			<td><input type="number" name="optios[0].orders"></td>
			 			<td><button type="button" onclick="removeLine($(this))">删除</button></td>
			 		</tr>
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
	var index=1;
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
			url:"/spec/addSpec",
			data:formData,
			type:"post",
			contentType:false,
			processData:false,
			success:function(flag){
				if(flag){
					alert("添加成功");
					$("#workContent").load("/spec/list");
				}else{
					alert("添加失败")
				}
			}
		})
	}
</script>
</html>