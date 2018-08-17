layui.use([ 'element', 'layer' ], function() {
	console.log("layui.use...");
	var $ = layui.jquery, element = layui.element, layer = layui.layer;
	var tab = 'top-tab', l_m = 'left-menu';

	var mainHeight = $(window).height() - 60 - 41 - 44 - 5;

	// element.on('nav(' + t_m + ')',function(data) {
	// l_o.hide().eq(data.index()).show();
	// });
	//	
	// l_o.on("click", "li",function() {
	// $(this).siblings().removeClass("layui-nav-itemed");
	// });

	element.on('nav(' + l_m + ')',
			function(data) {

				var a_t = data.children("a"), id = a_t.data("id"), url = a_t
						.data("url"), title = a_t.html();
				console.log("data=url:" + url + "  id:" + id);
				url = 'clist.html';
				id = '2';

				console.log("a_t:" + a_t);

				length = $(".layui-tab-title").children(
						"li[lay-id='" + id + "']").length;

				if (!length) {
					var iframe = '<iframe src="' + url + '" style="height:'
							+ mainHeight + 'px;"></iframe>';
					element.tabAdd(tab, {
						title : title,
						content : iframe,
						id : id
					});
				}

				element.tabChange(tab, id);

				length && loadPage();
			});

	// l_o.children("li:first").children("a:first").click();

	// $(".menu-flexible").click(function(){
	// console.log("menu-flexible...");
	// $(".left-menu-all").toggle();
	// $(".layui-body,.layui-footer").css("left",($(".left-menu-all").is(":hidden"))
	// ? '0' : '200px');
	// })
	//	
	// $(".layui-tab-button").on("click","a",function(){loadPage()})

	// 重新载入页面
	function loadPage() {

		var index = $(".layui-tab-content").find(".layui-show").index();
		window[index].location.reload();
	}
});