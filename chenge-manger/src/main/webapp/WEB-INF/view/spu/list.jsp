<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spu管理</title>
<script type="text/javascript">
	function query(page){
		var formdata=$("#form1").serialize();
		$("#workContent").load("/spu/list?pageNum="+page,formdata);
	}
	
	function toAdd(){
		$("#workContent").load("/spu/toAdd");
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<!-- 查询条件 -->
		<div>
			<form id="form1">
				<fieldset>
					<label for="goodsName">关键字</label>
					<input type="text" id="goodsName" name="goodsName" value="${vo.goodsName}">
					<label for="brand">品牌</label>
					<select id="brand" name="brandId">
						<option value="0">--请选择--</option>
						<c:forEach items="${brands.list}" var="brand">
							<option value="${brand.id}" ${vo.brandId == brand.id?'selected':'' }>${brand.name}</option>
						</c:forEach>
					</select><br>
					<label for="sortColumn">排序字段</label>
					<select id="sortColumn" name="orderColumn">
						<option value="">--请选择--</option>
						<option value="goods_name" ${vo.orderColumn=='goods_name'?'selected':''}>名称</option>
						<option value="caption" ${vo.orderColumn=='caption'?'selected':''}>标题</option>
						<option value="category_id" ${vo.orderColumn=='category_id'?'selected':''}>分类</option>
						<option value="brand_id" ${vo.orderColumn=='brand_id'?'selected':''}> 品牌</option>
					</select>
					<label for="orderType">排序方式</label>
					<input type="radio" id="orderType" name="orderType" value="ASC" ${vo.orderType=='ASC'?'checked':''}>升序&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="orderType" value="DESC" ${vo.orderType=='DESC'?'checked':''}>降序
				</fieldset>
				<fieldset>
					<button type="button" class="btn btn-info btn-sm" onclick="query(1)">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-info btn-sm" onclick="toAdd()">添加</button>
				</fieldset>
			</form>
		</div>
		<!-- 查询内容 -->
		<div>
			<table class="table">
				<Tr>
					<td>id<input type="checkbox"> </td>
					<td>名称</td>
					<td>在售</td>
					<td>品牌</td>
					<td>标题</td>
					<td>分类</td>
					<td>图片</td>
					<td>操作</td>
				</Tr>
				<c:forEach items="${info.list}" var="spu">
					<Tr>
						<td>${spu.id}<input type="checkbox"></td>
						<td>${spu.goodsName}</td>
						<td>${spu.isMarketable==1?'在售':'已下架'}</td>
						<td>${spu.brand.name}</td>
						<td>${spu.caption}</td>
						<td>${spu.category.name}</td>
						<td><img src="/pic/${spu.smallPic}" style="width: 50px;height: 50px"> </td>
						<td>
							<a href="#" onclick="">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#" onclick="">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="#" onclick="">查看</a>
						</td>
					</Tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item"><a class="page-link" href="#">首页</a></li>
		    <c:forEach begin="1" end="${info.pages}" var="page">
		    	<c:if test="${page==info.pageNum}">
		   	 		<li class="page-item"><a class="page-link" href="javascript:void(0)" ><font color="red">${page}</font></a></li>
		    	</c:if>
		    	<c:if test="${page!=info.pageNum}">
		   	 		<li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="query(${page})">${page}</a></li>
		    	</c:if>
		    
		    </c:forEach>
		    <li class="page-item"><a class="page-link" href="#">尾页</a></li>
		  </ul>
		</nav>
		</div>
	</div>
</body>
</html>