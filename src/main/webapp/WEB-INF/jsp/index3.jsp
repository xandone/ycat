<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>开始使用</title>
<link rel="stylesheet" href="js/layui/src/css/layui.css">
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="https://upload-images.jianshu.io/upload_images/2518499-f5c1aa291b65d334.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240"
						class="layui-nav-img"> xandone
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
						    <dd class="layui-this">
				          	    <a href="javascript:load('customer_list');">用户列表</a>
			                </dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">段子管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">段子管理</a>
							</dd>
							<dd>
								<a href="javascript:;">新增段子</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item"><a href="javascript:;">图片管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">新增图片</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
		
			<!-- 内容主体区域 -->
			<div class="layui-tab">
				<ul class="layui-tab-title">
					<li class="layui-this">网站设置</li>
					<li>用户管理</li>
					<li>权限分配</li>
					<li>商品管理</li>
					<li>订单管理</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						1. 高度默认自适应，也可以随意固宽。 <br>2. Tab进行了响应式处理，所以无需担心数量多少。
					</div>
					<div class="layui-tab-item">内容2</div>
					<div class="layui-tab-item">内容3</div>
					<div class="layui-tab-item">内容4</div>
					<div class="layui-tab-item">内容5</div>
				</div>
			</div>
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 50px;">
				<legend>动态操作Tab</legend>
			</fieldset>

			<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
				<ul class="layui-tab-title">
					<li class="layui-this" lay-id="11">网站设置</li>
					<li lay-id="22">用户管理</li>
					<li lay-id="33">权限分配</li>
					<li lay-id="44">商品管理</li>
					<li lay-id="55">订单管理</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">内容1</div>
					<div class="layui-tab-item">内容2</div>
					<div class="layui-tab-item">内容3</div>
					<div class="layui-tab-item">内容4</div>
					<div>
					</div>
				</div>
				<div class="layui-footer">
					<!-- 底部固定区域 -->
					© layui.com - 底部固定区域
				</div>
			</div>
			<script src="js/layui/src/layui.js"></script>
			<script>
				//JavaScript代码区域
				layui.use('element', function() {
					var element = layui.element;
				});
			</script>

			<script type="text/javascript">
				function load(view) {
					layui.jquery(".layui-body").load(
							  view, function() {});
				}
			</script>

			<script>
				layui.use('element', function() {
					var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

					//触发事件
					var active = {
						tabAdd : function() {
							//新增一个Tab项
							element.tabAdd('demo', {
								title : '新选项' + (Math.random() * 1000 | 0) //用于演示
								,
								content : 'item-list',
								id : new Date().getTime()
							//实际使用一般是规定好的id，这里以时间戳模拟下
							})
						},
						tabDelete : function(othis) {
							//删除指定Tab项
							element.tabDelete('demo', '44'); //删除：“商品管理”

							othis.addClass('layui-btn-disabled');
						},
						tabChange : function() {
							//切换到指定Tab项
							element.tabChange('demo', '22'); //切换到：用户管理
						}
					};

					$('.site-demo-active').on('click', function() {
						var othis = $(this), type = othis.data('type');
						active[type] ? active[type].call(this, othis) : '';
					});

					//Hash地址的定位
					var layid = location.hash.replace(/^#test=/, '');
					element.tabChange('test', layid);

					element.on('tab(test)', function(elem) {
						location.hash = 'test=' + $(this).attr('lay-id');
					});

				});
			</script>
</body>
</html>
