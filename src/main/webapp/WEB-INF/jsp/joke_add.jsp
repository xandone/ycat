<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
		<table cellpadding="5">
			<tr>
				<td>段子标题:</td>
				<td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input readonly="readonly" value="152138655864350" class="easyui-textbox" name="joke_user_id" data-options="multiline:true,validType:'length[0,150]'"
						style="width: 280px;"></input></td>
			</tr>
			<tr>
				<td>段子内容:</td>
				<td><textarea style="width: 800px; height: 300px; visibility: visible;" name="content"></textarea></td>
			</tr>
		</table>
		<input type="hidden" name="itemParams" />
	</form>
	<div style="padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor;
	//页面初始化完毕后执行此方法
	$(function() {
		//创建富文本编辑器
		itemAddEditor = KindEditor.create("#itemAddForm [name=content]",
				TT.kingEditorParams);
	}); 

	console.log('this is submitForm');
	
	/* 待考究
	html页面调用js文件里的函数，写法必须为submitForm = function (){}形式，其他方式写，html页面会搜索不到该函数。 */
	//提交表单
	submitForm = function() {
		//有效性验证
		if (!$('#itemAddForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}
		//同步文本框中的描述
		itemAddEditor.sync();
		$.post("/ycat/joke/add", $("#itemAddForm").serialize(), function(data) {
			if (data.code == 1) {
				$.messager.alert('提示', '新增成功!');
			}
		});
	}


</script>
