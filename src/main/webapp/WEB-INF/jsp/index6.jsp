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
					<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd class="layui-this">
							<a href="javascript:;" data-id="1" data-title="用户列表" data-url="customer_list.php?&a=adminList"
                               class="site-demo-active" data-type="tabAdd">用户列表</a>
							</dd>
						</dl>
						</li>
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
		</div>

		<div class="layui-body"></div>

	</div>

	<script src="js/layui/src/layui.js"></script>
	<script>

	layui.use(['element', 'layer', 'jquery'], function () {
	    var element = layui.element;
	    // var layer = layui.layer;
	    var $ = layui.$;
	    // 配置tab实践在下面无法获取到菜单元素
	    $('.site-demo-active').on('click', function () {
	        var dataid = $(this);
	        //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
	        if ($(".layui-tab-title li[lay-id]").length <= 0) {
	            //如果比零小，则直接打开新的tab项
	            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
	        } else {
	            //否则判断该tab项是否以及存在
	            var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
	            $.each($(".layui-tab-title li[lay-id]"), function () {
	                //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
	                if ($(this).attr("lay-id") == dataid.attr("data-id")) {
	                    isData = true;
	                }
	            })
	            if (isData == false) {
	                //标志为false 新增一个tab项
	                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
	            }
	        }
	        //最后不管是否新增tab，最后都转到要打开的选项页面上
	        active.tabChange(dataid.attr("data-id"));
	    });

	    var active = {
	        //在这里给active绑定几项事件，后面可通过active调用这些事件
	        tabAdd: function (url, id, name) {
	            //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
	            //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
	            element.tabAdd('demo', {
	                title: name,
	                content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:99%;"></iframe>',
	                id: id //规定好的id
	            })
	            FrameWH();  //计算ifram层的大小
	        },
	        tabChange: function (id) {
	            //切换到指定Tab项
	            element.tabChange('demo', id); //根据传入的id传入到指定的tab项
	        },
	        tabDelete: function (id) {
	            element.tabDelete("demo", id);//删除
	        }
	    };
	    function FrameWH() {
	        var h = $(window).height();
	        $("iframe").css("height",h+"px");
	    }
	});
	</script>

</body>
</html>
