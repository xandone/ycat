<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="js/layui/src/css/layui.css" media="all">
</head>
<body>

	<div class="layui-btn-group demoTable">
		<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
		<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
		<button class="layui-btn" data-type="isAll">验证是否全选</button>
	</div>

	<table class="layui-table"
		lay-data="{width: 1000, height:500, url:'/ycat/item/list',page:true,request: {pageName: 'page',limitName: 'rows'},
		response: {statusName: 'code' ,statusCode: 200,msgName: 'msg' ,countName: 'total' ,dataName: 'rows' }}"
		lay-filter="andone">
		<thead>
			<tr>
				<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
				<th lay-data="{field:'user_id', width:150}">用户ID</th>
				<th lay-data="{field:'name', width:150}">用户名</th>
				<th lay-data="{field:'password',width:100}">用户密码</th>
				<th lay-data="{field:'nickname',width:150}">用户昵称</th>
				<th lay-data="{field:'rtime', width:150}">注册时间</th>
				<th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
			</tr>
		</thead>
	</table>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script>
		layui.use('table',function() {
							var table = layui.table;
							//监听表格复选框选择
							table.on('checkbox(andone)', function(obj) {
								alert("ee");
								console.log(obj);
							});
							//监听工具条
							table.on('tool(andone)',
									function(obj) {
										console.log(obj);
										var data = obj.data;
										if (obj.event === 'detail') {
											layer.msg('ID：' + data.nickname
													+ ' 的查看操作');
										} else if (obj.event === 'del') {
											layer.confirm('真的删除行么', function(
													index) {
												obj.del();
												layer.close(index);
											});
										} else if (obj.event === 'edit') {
											layer.alert('编辑行：<br>'
													+ JSON.stringify(data))
										}
									});

							var $ = layui.$, active = {
								getCheckData : function() { //获取选中数据
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									layer.alert(JSON.stringify(data));
								},
								getCheckLength : function() { //获取选中数目
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									layer.msg('选中了：' + data.length + ' 个');
								},
								isAll : function() { //验证是否全选
									var checkStatus = table
											.checkStatus('idTest');
									layer.msg(checkStatus.isAll ? '全选' : '未全选')
								}
							};

							$('.demoTable .layui-btn').on('click', function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							});
						});
	</script>
</body>
</html>