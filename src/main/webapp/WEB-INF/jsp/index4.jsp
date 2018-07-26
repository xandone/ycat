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

		<!-- <div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				左侧导航区域（可配合layui已有的垂直导航）
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd class="layui-this">
								 <a href="javascript:;" data-url="/ycat/html/clist.html" data-id="2">测试列表</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">段子管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">段子管理</a>
							</dd>
							<dd>
								<a href="javascript:;" data-type="tabAdd">新增段子</a>
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
		</div> -->
		
		 <!-- 左侧菜单 -->
        <div class="layui-side layui-bg-black left-menu-all">
            <div class="layui-side-scroll">
            	<ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                    <li class="layui-nav-item layui-this">
                        <a href="javascript:;" data-url="clist.html" data-id="1">后台首页</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">测试管理</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="lists.html" data-id="2">测试列表</a>
                            </dd>
							<dd>
                                <a href="javascript:;" data-url="login.html" data-id="8">登录页</a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="tabletree.html" data-id="9">树表示例</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
                <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                    <li class="layui-nav-item">
                        <a href="javascript:;">后台用户</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="https://www.layui.com/doc/" data-id="3">登录日志</a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="https://www.layui.com/doc/" data-id="4">操作日志</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
				<ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                    <li class="layui-nav-item">
                        <a href="javascript:;">导航管理</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="https://www.layui.com/doc/" data-id="5">导航列表</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
				<ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                    <li class="layui-nav-item">
                        <a href="javascript:;">广告管理</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="https://www.layui.com/doc/" data-id="6">广告列表</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
				<ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                    <li class="layui-nav-item">
                        <a href="javascript:;">会员管理</a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="https://www.layui.com/doc/" data-id="7">会员列表</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 主体 -->
        <div class="layui-body">
            <!-- 顶部切换卡 -->
            <div class="layui-tab layui-tab-card" lay-filter="top-tab" lay-allowClose="true">
                <ul class="layui-tab-title"></ul>
                <div class="layui-tab-button">
                </div>
                <div class="layui-tab-content"></div>
            </div>
        </div>

	</div>

	<script type="text/javascript" src="js/layui/src/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
	</script>

	<script type="text/javascript">
		function load(view) {
			layui.jquery(".layui-body").load('/ycat/html/' + view + '.html',
					function() {
					});
		}
	</script>

	<script>
		layui.use('element', function() {
			var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
			var mainHeight = $(window).height() - 60 - 41 - 44 - 5;
			var l_m='left-menu',tab = 'top-tab';
			
			 element.on('nav(' + l_m + ')',function(data) {
			    	console.log("data---"+data);
			        var a_t 	= data.children("a"),
						id 		= a_t.data("id"),
						url 	= a_t.data("url"),
						url='index7';
			            id='2';
						title 	= a_t.html(),
						length 	= $(".layui-tab-title").children("li[lay-id='" + id + "']").length;
			        console.log("dataa_t:"+a_t);
			        console.log("dataurl:"+url);
			        if (!length) {
			            var iframe = '<iframe src="' + url + '" style="height:' + mainHeight + 'px;"></iframe>';
			            element.tabAdd(tab, {
			                title	: title,
			                content	: iframe,
			                id		: id
			            });
			        }
			        
			        element.tabChange(tab, id);
			        
			        length && loadPage();
			    });
			 
			    	
				// 重新载入页面
				function loadPage(){
			    	var index = $(".layui-tab-content").find(".layui-show").index();
					window[index].location.reload();
			    }
		});
	</script>

</body>
</html>
