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
            
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>基本树</legend>
</fieldset>
 
<div style="display: inline-block; width: 180px; height: 210px; padding: 10px; border: 1px solid #ddd; overflow: auto;">
  <ul id="demo1"></ul>
</div>
 
<ul id="demo2"></ul>             
          
<script src="js/layui/src/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
//Demo
layui.use(['tree', 'layer'], function(){
  var layer = layui.layer
  ,$ = layui.jquery; 
  
  layui.tree({
    elem: '#demo1' //指定元素
    ,target: '_blank' //是否新选项卡打开（比如节点返回href才有效）
    ,click: function(item){ //点击节点回调
      layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item));
      console.log(item);
    }
    ,nodes: [ //节点
      {
        name: '用户管理'
        ,id: 1
        ,alias: 'changyong'
        ,children: [
          {
            name: '查询用户（设置跳转）'
            ,id: 11
            ,href: 'http://www.layui.com/'
            ,alias: 'weidu'
          }
        ]
      },{
          name: '段子管理'
              ,id: 1
              ,alias: 'changyong'
              ,children: [
                {
                  name: '段子管理（设置跳转）'
                  ,id: 11
                  ,href: 'http://www.layui.com/'
                  ,alias: 'weidu'
                }, {
                  name: '新增段子'
                  ,id: 12
                }
              ]
            },{
                name: '图片管理'
                    ,id: 1
                    ,alias: 'changyong'
                    ,children: [
                      {
                        name: '新增图片（设置跳转）'
                        ,id: 11
                        ,href: 'http://www.layui.com/'
                        ,alias: 'weidu'
                      }
                    ]
                  }
    ]
  });
 
  layui.tree({
    elem: '#demo2' //指定元素
    ,nodes: createTree()
  });
  
});
</script>

</body>
</html>
