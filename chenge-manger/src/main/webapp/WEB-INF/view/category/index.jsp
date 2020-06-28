<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet">
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<div class="container">
	<div class="row">
		<div class="col-md-4" id="tree">
			
		</div>
		<div class="col-md-5">
			<form id="form">
				<fieldset>
					<label for="parentNodeName">父节点名称</label>
					<input type="hidden" id="parentId" name="parentId" ><br>
					<input id="parentNodeName" disabled="disabled"><br>
					<br>
					<label for="name">分类的名称</label>
					<input id="name" name="name">
					<br>
					<input type="button" value="提交"  onclick="addCategory()">
				</fieldset>
			</form>
			<form id="form2">
				<fieldset>
					<input type="hidden" id="currentId" name="parentId" >
					<label for="currentName">分类的名称</label>
					<input id="currentName" name="name">
					<br>
					<input type="button" value="修改"  onclick="updateCategory()">
					<input type="button" id="delCategory" value="删除"  disabled="disabled" onclick="delCategory()">
				</fieldset>
			</form>
		</div>
	</div>
	
</div>
<script>
	function initTree(){
		$.post("/category/data",{},function(data){
			$('#tree').treeview({
				  data: data,         // data is not optional
				  levels: 5,
				  onNodeSelected:function(event, data) {
					  //用于显示添加部分
					  $("#parentNodeName").val(data.text);
					  $("#parentId").val(data.id)
					  $("#name").val("");
					  
					  //用于显示修改和删除的部分
					  $("#currentName").val(data.text);
					  $("#currentId").val(data.id)
					 $("#delCategory").prop("disabled",data.nodes.length>0)
				  }
					})
		})
	}
	//初始化树状图
	initTree();
	function updateCategory(){
		$.post("/category/updateCategory",$("#form2").serialize(),function(flag){
			if(flag){
				alert("修改成功");
				initTree();
			}else{
				alert("修改失败");
			}
		})
	}
	function addCategory(){
		$.post("/category/addCategory",$("#form").serialize(),function(flag){
			if(flag){
				alert("添加成功");
				initTree();
			}else{
				alert("添加失败");
			}
		})
	}
	function delCategory(){
		if(confirm("确认要删除吗？")){
			$.post("/category/delCategory",$("#form2").serialize(),function(flag){
				if(flag){
					alert("删除成功");
					initTree();
				}else{
					alert("删除失败");
				}
			})
		}
	}          
</script>