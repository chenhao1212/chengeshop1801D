<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
		function add(){
			$("#workContent").load("/spec/toAdd");
		}
		function del(id){
			var ids=new Array();
			ids.push(id);
			$.post("/spec/del",{id:ids},function(flag){
				if(flag){
					alert("删除成功");
					$("#workContent").load("/spec/list");
				}else{
					alert("删除失败");
				}
			})
		}
		
		function toUpdate(id){
			$("#workContent").load("/spec/toUpdate",{id:id});
		}
		function selAll(){
			var checked=$("[name=check1]").prop("checked")
			$("[name=check2]").each(function(){
				$(this).prop('checked',checked);
			})
		}
		function selRevers(){
			$("[name=check2]").each(function(){
				$(this).prop('checked',!$(this).prop("checked"));
			})
		}
		function selOne(){
			var checked=$("[name=check2]").length == $("[name=check2]:checked").length;
			$("[name=check1]").prop("checked",checked);
		}
		function delBatch(){
			if($("[name=check2]:checked").length<1){
				alert("请至少选中一条数据");
			}else{
				var ids=new Array();
				if(confirm("确认要删除吗?")){
					//被删除的数据的id数组
					
					$("[name=check2]:checked").each(function(){
						ids.push($(this).val());
					})
					alert(ids)
					$.post("/spec/del",{id:ids},function(flag){
						if(flag){
							alert("删除成功");
							$("#workContent").load("/spec/list");
						}else{
							alert("删除失败");
						}
					})
				}
			}
			
		}
	</script>
    <div>
    	<div>
    		<a href="#" onclick="add()">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;
    		<a href="#" onclick="delBatch()">批量删除</a>
    	</div>
		<table class="table">
			<Tr>
				<td>id<input type="checkbox" name="check1" onclick="selAll()" ><button onclick="selRevers()">反选</button> </td>
				<td>名称</td>
				<td>属性</td>
				<td>操作</td>
			</Tr>
			<c:forEach items="${pageInfo.list}" var="spec">
				<Tr>
					<td>${spec.id}<input type="checkbox" name="check2" value="${spec.id}" onchange="selOne()"></td>
					<td>${spec.specName}</td>
					<td>
						<c:forEach items="${spec.optios}" var="option" varStatus="index">
							<c:if test="${index.index!=0}">
								,
							</c:if>
							${option.optionName}
							
						</c:forEach>
					</td>
					<td><A href="#" onclick="del(${spec.id})">删除</A>&nbsp;&nbsp;&nbsp;&nbsp;<A href="#" onclick="toUpdate(${spec.id})">修改</A></td>
				</Tr>
			</c:forEach>
		</table>
	 </div>
