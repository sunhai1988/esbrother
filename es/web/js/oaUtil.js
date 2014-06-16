//打开修改页面功能
function update(updateId, title, height, width, htmlPage) {
	var id;
	if ($('#' + updateId).length == 0) {
		id = updateId;
	} else {
		var ids = $('#' + updateId).datagrid('getSelections');

		if (ids.length <= 0) {
			alert('至少选择一条记录');
			return;
		}
		if (ids.length > 1) {
			alert('只能选择一条记录');
			return;
		}
		id = $('#' + updateId).datagrid('getSelections')[0].id;
	}
	$('#czid').val(id);
	var dg = new $.dialog({
		id : 'ddd',
		title : title,
		width : width,
		height : height,
		page : htmlPage,
		cover : true,
		bgcolor : '#000'
	});
	dg.ShowDialog();
}

// 打开修改页面功能(tree)
function update_tree(updateId, title, height, width, htmlPage) {
	var id;
	if ($('#' + updateId).length == 0) {
		id = updateId;
	} else {
		var ids = $('#' + updateId).treegrid('getSelections');
		if (ids.length <= 0) {
			alert('至少选择一条记录');
			return;
		}
		if (ids.length > 1) {
			alert('只能选择一条记录');
			return;
		}
		id = $('#' + updateId).treegrid('getSelections')[0].id;
	}
	$('#czid').val(id);
	var dg = new $.dialog({
		id : 'ddd',
		title : title,
		width : width,
		height : height,
		page : htmlPage,
		cover : true,
		bgcolor : '#000'
	});
	dg.ShowDialog();
}

function bntemplate(updateId, title, height, width, htmlPage) {
	var id;
	var type;
	if ($('#' + updateId).length == 0) {
		id = updateId;
	} else {
		var ids = $('#' + updateId).datagrid('getSelections');

		if (ids.length <= 0) {
			alert('至少选择一条记录');
			return;
		}
		if (ids.length > 1) {
			alert('只能选择一条记录');
			return;
		}
		id = $('#' + updateId).datagrid('getSelections')[0].id;
		type = $('#' + updateId).datagrid('getSelections')[0].type;
	}
	$('#czid').val(id);
	$('#type').val(type);
	var dg = new $.dialog({
		id : 'ddd',
		title : title,
		width : width,
		height : height,
		page : htmlPage,
		cover : true,
		bgcolor : '#000'
	});
	dg.ShowDialog();
}
// 打开添加页面
function add(title, height, width, htmlPage) {
	var dg = new $.dialog({
		id : 'ddd',
		title : title,
		width : width,
		height : height,
		page : htmlPage,
		cover : true,
		bgcolor : '#000'
	});
	dg.ShowDialog();
}

// 报警弹窗

// 初始化查询页面
function initQueryPage(divId, title, width, height) {
	$('#' + divId).window({
		title : title,
		modal : true,
		shadow : false,
		closed : false,
		width : width,
		height : height
	});
	$('#' + divId).window('close');
}
// 打开查询页面
function openQueryPage(divId) {
	clearForm();
	$('#' + divId).window('open');
}
function clearForm() {
	$('#queryForm').form('clear');
}
//
function displayMsg(divId) {
	$('#' + divId).datagrid('getPager').pagination({
		displayMsg : '当前显示从{from}到{to}共{total}记录',
		beforePageText : '第',
		afterPageText : '页,共{pages}'
	});
}
// 表格查询
function searchUser(dateGrid_id, queryForm_id) {
	var params = $('#' + dateGrid_id).datagrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数

	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).datagrid('reload'); // 设置好查询参数 reload 一下就可以了
	$('#' + queryForm_id).window('close');
	clearForm();
}

function clearParams(dateGrid_id, queryForm_id) {
	var params = $('#' + dateGrid_id).datagrid('options').queryParams; // 先取得
	// datagrid的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		// field.value="";
		params[field.name] = ""; // 设置查询参数
	});
	params['company_name'] = "";
	$('#' + dateGrid_id).datagrid('reload'); // 设置好查询参数 reload 一下就可以了
	$('#' + queryForm_id).window('close');
	clearForm();

}

// 表格查询-用户
function searchUser_client(dateGrid_id, queryForm_id) {
	var params = $('#' + dateGrid_id).datagrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).datagrid('reload'); // 设置好查询参数 reload 一下就可以了
}

// 表格查询-用户(tree)
function searchUser_client_tree(dateGrid_id, queryForm_id) {
	var params = $('#' + dateGrid_id).treegrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).treegrid('reload'); // 设置好查询参数 reload 一下就可以了
}

// 表格查询-用户-所有
function searchUser_client_all(dateGrid_id, queryForm_id) {
	reset_client();
	var params = $('#' + dateGrid_id).datagrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).datagrid('reload'); // 设置好查询参数 reload 一下就可以了
}

// 表格查询-用户-所有(tree)
function searchUser_client_all_tree(dateGrid_id, queryForm_id) {
	reset_client();
	var params = $('#' + dateGrid_id).treegrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).treegrid('reload'); // 设置好查询参数 reload 一下就可以了
}

// 表格查询-重置
function reset_client() {
	$(':input', '#queryForm').not(':button, :submit, :reset, :hidden').val('')
			.removeAttr('checked').removeAttr('selected');
}

// 以下是功能函数
function deleterow(datagrid_id, actionName) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			var rows = $('#' + datagrid_id).datagrid('getSelections');
			var ps = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			} else {

				$.each(rows, function(i, n) {
					ps += n.id + ":";
				});
			}
			$.post(actionName, {
				id : ps
			}, function(data) {
				$('#' + datagrid_id).datagrid('unselectAll');
				$('#' + datagrid_id).datagrid('reload');
				$.messager.alert('提示', '成功', 'info');
			});
		}
	});
}

// 以下是功能函数(tree)
function deleterow_tree(datagrid_id, actionName) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			var rows = $('#' + datagrid_id).treegrid('getSelections');
			var ps = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			} else {

				$.each(rows, function(i, n) {
					ps += n.id + ":";
				});
			}
			$.post(actionName, {
				id : ps
			}, function(data) {
				$('#' + datagrid_id).treegrid('unselectAll');
				$('#' + datagrid_id).treegrid('reload');
				$.messager.alert('提示', '成功', 'info');
			});
		}
	});
}

// 对应设备信息
function duiinfo(datagrid_id, actionName, datagrid_id1) {
	var rows = $('#' + datagrid_id).datagrid('getSelections');
	var ps = "";
	var params = $('#' + datagrid_id1).datagrid('options').queryParams;
	$.each(rows, function(i, n) {
		ps += n.company_name;
		params['company_name'] = ps;
	});
	$('#' + datagrid_id1).datagrid('reload');
}

// 删除
function del(datagrid_id, actionName) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			var rows = $('#' + datagrid_id).datagrid('getSelections');
			var ps = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			} else {
				$.each(rows, function(i, n) {
					ps += n.id + ":";
				});
			}
			$.post(actionName, {
				id : ps
			}, function(data) {
				$('#' + datagrid_id).datagrid('unselectAll');
				$('#' + datagrid_id).datagrid('reload');
			});
		}
	});
}

// 根据id取值
function queryById(queryByIdAction) {
	var ids = J('#czid', DG.curDoc).val();
	$.getJSON(queryByIdAction, {
		id : ids
	}, function(data) {
		$.each(data,
				function(idx, item) {
					var _key = data[idx].id.split(',');
					for ( var i = 0; i < _key.length; i++) {
						alert("dsds");
						if ($("[jsn$=" + _key[i] + "]").is('p')
								|| $("[jsn$=" + _key[i] + "]").is('div')) {

							$("[jsn$=" + _key[i] + "]").html(
									data[idx]['list'][_key[i]]);
						} else {
							$("[jsn$=" + _key[i] + "]").val(
									data[idx]['list'][_key[i]]);
						}
					}
				});
	});
}
// 第二种
function queryByIdone(queryByIdAction) {
	var ids = J('#czid', DG.curDoc).val();
	$.getJSON(queryByIdAction, {
		id : ids
	}, function(data) {
		$.each(data, function(idx, item) {
			if ($("[jsn$=" + idx + "]").is('p')
					|| $("[jsn$=" + idx + "]").is('div')) {
				$("[jsn$=" + idx + "]").html(item);
			}
			if ($("[jsn$=" + idx + "]").is('textarea')) {
				if (typeof KE != 'undefined') {
					KE.html('editor', item);
				} else {
					$("[jsn$=" + idx + "]").val(item);
				}
			} else {
				$("[jsn$=" + idx + "]").val(item);
			}
			var a = true;
			return a;
		});
	});
}

function addorupdate(form_id, action_name) {
	var params = $("#" + form_id).serializeArray();
	$.post(action_name, $("#" + form_id).serializeArray(), function(data) {
		DG.curWin.location.reload();
	});
	DG.curWin.location.reload();
}

function encode(v) {
	if (v == null || v == "")
		return "";
	var result = "";
	for ( var i = 0; i < v.length; i++)
		switch (v.charAt(i)) {
		case "&#38;":
			result += "&";
			break;
		case "&#34;":
			result += "\"";
			break;
		case "&#60;":
			result += "<";
			break;
		case "&#62;":
			result += ">";
			break;
		case "'":
			result += "&#39;";
			break;
		default:
			result += v.charAt(i);
			break;
		}
	return result;
}
String.prototype.replaceAll = function(AFindText, ARepText) {
	raRegExp = new RegExp(AFindText, "g");
	return this.replace(raRegExp, ARepText);
};

function vv(s) {
	alert(s);
	s.replaceAll("&#60;", "<");
	alert(s);
	return s;
}
// 导出doc文档
function exportDOC(action_name, ids) {
	$.post(action_name, {
		id : ids
	}, function(data) {
	}, "json");
}

// 生成下拉列表 根据id生成
function downList(actionName, value_one, value_two, lable_id) {
	$.getJSON(actionName, function(data) {
		var html = '';
		var fhtml = '';
		var down_id = '';
		var flag = true;
		if ($("[jsn$=" + lable_id + "]").val() != '') {
			down_id = $("[jsn$=" + lable_id + "]").val();
		}
		$.each(data, function(idx, item) {
			if (item[value_one] == down_id) {
				fhtml = '<option value="' + item[value_one] + '">'
						+ item[value_two] + '</option>';
			} else {
				html += '<option value="' + item[value_one] + '">'
						+ item[value_two] + '</option>';
			}
		});
		fhtml += html;
		$("#" + lable_id + "").append(fhtml);
	});
}

// 生成下拉列表 根据id生成
function select_List_client(actionName, value_one, value_two, lable_id) {
	$.getJSON(actionName, function(data) {
		var html = '';
		var fhtml = '';
		var down_id = '';
		var flag = true;
		if ($("[jsn$=" + lable_id + "]").val() != '') {
			down_id = $("[jsn$=" + lable_id + "]").val();
		}
		$.each(data, function(idx, item) {
			fhtml = '<option value="">请选择</option>';
			if (item[value_one] == down_id) {
				fhtml = '<option value="' + item[value_two] + '">'
						+ item[value_two] + '</option>';
			} else {
				html += '<option value="' + item[value_two] + '">'
						+ item[value_two] + '</option>';
			}
		});
		fhtml += html;
		$("#" + lable_id + "").append(fhtml);
	});
}

function limitList(actionName, value_one, value_two, lable_id) {
	var ids = J('#czid', DG.curDoc).val();
	$.getJSON(actionName + "?id=" + ids, function(data) {
		var html = '';
		var fhtml = '';
		var down_id = '';
		var flag = true;
		while (flag) {
			if ($("[jsn$=" + lable_id + "]").val() != '') {
				down_id = $("[jsn$=" + lable_id + "]").val();
				flag = false;
			}
		}
		$.each(data, function(idx, item) {
			if (item[value_one] == down_id) {
				fhtml = '<input value="' + item[value_one] + '">'
						+ item[value_two] + '</input><br>';
			} else {
				html += '<input value="' + item[value_one] + '">'
						+ item[value_two] + '</input><br>';
			}
		});
		fhtml += html;
		$("#" + lable_id + "").append(fhtml);
	});
}
function RolelimitList(actionName, value_one, value_two, lable_id) {
	var ids = J('#czid', DG.curDoc).val();
	$.getJSON(actionName + "?id=" + ids, function(data) {
		var html = '';
		var fhtml = '';
		var down_id = '';
		var flag = true;
		while (flag) {
			if ($("[jsn$=" + lable_id + "]").val() != '') {
				down_id = $("[jsn$=" + lable_id + "]").val();
				flag = false;
			}
		}
		$.each(data, function(idx, item) {
			if (item[value_one] == down_id) {
				fhtml += '<input type="checkbox"  cvalue="' + item[value_one]
						+ '">' + item[value_two] + '</input><br>';
			} else {
				html += '<input type="checkbox"  value="' + item[value_one]
						+ '">' + item[value_two] + '</input><br>';
			}
		});
		fhtml += html;
		$("#" + lable_id + "").append(fhtml);
	});
}

function checkList(actionName, value_one, value_two, lable_id) {
	$
			.getJSON(
					actionName,
					function(data) {
						var html = '';
						var fhtml = '';
						var down_id = '';
						var flag = true;
						if ($("[jsn$=" + lable_id + "]").val() != '') {
							down_id = $("[jsn$=" + lable_id + "]").val();
						}
						$
								.each(
										data,
										function(idx, item) {
											if (item[value_one] == down_id) {
												fhtml = '<input type="checkbox" name="checkone" value="'
														+ item[value_one]
														+ '">'
														+ item[value_two]
														+ '</input>';
											} else {
												html += '<input type="checkbox" name="checkone" value="'
														+ item[value_one]
														+ '">'
														+ item[value_two]
														+ '</input>';
											}
										});
						fhtml += html;
						$("#" + lable_id + "").append(fhtml);
					});

}
function Elemachine(actionName, value_one, value_two, value_three, value_four,
		value_five, value_six, value_seven, value_eight, lable_id) {
	$
			.getJSON(
					actionName,
					function(data) {
						var html = '';
						var fhtml = '<table border=1><tr><th>设备编号</th><th>电压</th><th>1#电流</th><th>2#电流</th><th>功率</th><th>频率</th><th>转速</th><th>日期</th></tr>';
						var down_id = '';
						$.each(data, function(idx, item) {

							html += '<tr><td>' + item[value_eight]
									+ '</td><td>' + item[value_two]
									+ '</td><td>' + item[value_three]
									+ '</td><td>' + item[value_seven] + '</td>'
									+ '<td>' + item[value_four] + '</td><td>'
									+ item[value_five] + '</td><td>'
									+ item[value_six] + '</td><td>'
									+ item[value_one] + '</td></tr>';
						});
						html += '</table>';
						fhtml += html;
						$("#" + lable_id + "").append(fhtml);
					});
}
function elewarnInfo(actionName, value_one, value_two, value_three, value_four,
		lable_id) {
	$
			.getJSON(
					actionName,
					function(data) {
						var html = '';
						var fhtml = '<table border=1><tr><th>报警时间</th><th>报警原因</th><th>报警设备</th><th>设备编号</th></tr>';
						var down_id = '';
						$.each(data, function(idx, item) {

							html += '<tr><td>' + item[value_one] + '</td><td>'
									+ item[value_two] + '</td><td>'
									+ item[value_three] + '</td><td>'
									+ item[value_four] + '</td></tr>';
						});
						html += '</table>';
						fhtml += html;
						$("#" + lable_id + "").append(fhtml);
					});
}

function queryByIdoneother(queryByIdAction) {
	var bol = false;
	var ids = J('#czid', DG.curDoc).val();
	$.ajax({
		type : "POST",
		async : false,
		url : queryByIdAction + "?id=" + ids,
		success : function(data) {
			$.each(data, function(idx, item) {

				if ($("[jsn$=" + idx + "]").is('p')
						|| $("[jsn$=" + idx + "]").is('div')) {
					$("[jsn$=" + idx + "]").html(item);
				}
				if ($("[jsn$=" + idx + "]").is('textarea')) {
					if (typeof KE != 'undefined') {
						KE.html('editor', item);
					} else {
						$("[jsn$=" + idx + "]").val(item);
					}
				} else {
					$("[jsn$=" + idx + "]").val(item);
				}
			});
			bol = true;
		}
	});
	return bol;
}
function fillsize(percent) {
	var bodyWidth = document.body.clientWidth;
	return (bodyWidth - 90) * percent;
}

function fillsizeH(percent) {
	var bodyWidth = document.body.clientHeight;
	alert(bodyWidth);
	return (bodyWidth) * percent;
}

function tohomepage(datagrid_id, actionName) {
	var rows = $('#' + datagrid_id).datagrid('getSelections');
	var ps = "";
	if (rows.length <= 0) {
		alert('至少选择一行');
		return;
	} else if (rows.length > 1) {
		alert('只能选择一条记录');
		return;
	} else {
		$.each(rows, function(i, n) {
			ps = n.id;
		});
		$.messager.confirm('提示', '确定要显示在主页吗?', function(result) {
			if (result) {
				$.post(actionName, {
					id : ps
				}, function(data) {
					$('#' + datagrid_id).datagrid('reload');
					$.messager.alert('提示', '成功', 'info');
				});
			}
		});
	}
}

function point(updateId, title, height, width, htmlPage) {
	var id;
	if ($('#' + updateId).length == 0) {
		id = updateId;
	} else {
		var ids = $('#' + updateId).datagrid('getSelections');

		if (ids.length <= 0) {
			alert('至少选择一条记录');
			return;
		}
		if (ids.length > 1) {
			alert('只能选择一条记录');
			return;
		}
		id = $('#' + updateId).datagrid('getSelections')[0].id;
	}
	$('#czid').val(id);
	var page = htmlPage + "?id=" + id;
	var dg = new $.dialog({
		id : 'update',
		title : title,
		width : width,
		height : height,
		page : page,
		cover : true,
		bgcolor : '#000'
	});
	dg.ShowDialog();
}

function delimg(datagrid_id, actionName) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			var flag = false;
			var rows = $('#' + datagrid_id).datagrid('getSelections');
			var ps = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			} else {
				$.each(rows, function(i, n) {
					if (n.flag == '1') {
						flag = true;
					}
					ps += n.id + ":";
				});
			}
			if (flag) {
				$.messager.alert('提示', '主页显示图片不能删除', 'info');
			} else {
				$.ajax({
					type : "POST",
					url : actionName,
					data : 'id=' + ps,
					dataType : "json",
					complete : function(data) {
						var jsonData = eval("(" + data.responseText + ")");
						$('#' + datagrid_id).datagrid('unselectAll');
						$('#' + datagrid_id).datagrid('reload');
						$.messager.alert('提示', jsonData.msg, 'info');
					}
				});
			}
		}
	});
}

function updateself(updateId, title, height, width, htmlPage) {
	var id;
	if ($('#' + updateId).length == 0) {
		id = updateId;
	} else {
		var ids = $('#' + updateId).datagrid('getSelections');

		if (ids.length <= 0) {
			alert('至少选择一条记录');
			return;
		}
		if (ids.length > 1) {
			alert('只能选择一条记录');
			return;
		}
		id = $('#' + updateId).datagrid('getSelections')[0].id;
	}
	var username = $('#' + updateId).datagrid('getSelections')[0].username;
	$.post("getdluserUsername.action", function(date) {
		if (username != date.msg) {
			$.messager.alert('提示', '只能对本用户添加的数据进行修改操作!', 'info');
			return;
		} else {
			$('#czid').val(id);
			var dg = new $.dialog({
				id : 'ddd',
				title : title,
				width : width,
				height : height,
				page : htmlPage,
				cover : true,
				bgcolor : '#000'
			});
			dg.ShowDialog();
		}
	}, "json");
}

function delself(datagrid_id, actionName) {
	$.messager.confirm('提示', '确定要删除吗?', function(result) {
		if (result) {
			var rows = $('#' + datagrid_id).datagrid('getSelections');
			var ps = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			} else {
				$.each(rows, function(i, n) {
					ps += n.id + ":";
				});
			}
			$.ajax({
				type : "POST",
				url : actionName,
				data : 'id=' + ps,
				dataType : "json",
				success : function(data) {
					$('#' + datagrid_id).datagrid('unselectAll');
					$('#' + datagrid_id).datagrid('reload');
					$.messager.alert('提示', data.msg, 'info');
				}
			});
		}
	});
}
// 下载附件
function downloadfujian(filename, name, id) {
	$.post("downloadcheck.action", {
		json : filename
	}, function(date) {
		if (date.suc == 2) {
			alert('下载失败!');
		}
		if (date.suc == 1) {
			var form = document.forms['upForm'];
			form.setAttribute("action", "downloadfujian.action?fileName="
					+ filename + "&name=" + name + "&id=" + id);
			form.submit();
		}
	}, "json");
}
// 下载图片
function downfile(filename, name) {
	$.post("downloadcheck.action", {
		json : filename
	}, function(date) {
		if (date.suc == 2) {
			alert('下载失败!');
		}
		if (date.suc == 1) {
			var form = document.forms['upForm'];
			form.setAttribute("action", "downloadimage.action?fileName="
					+ filename + "&name=" + name);
			form.submit();
		}
	}, "json");
}

// 弹窗信息提示
function infoprompt(msg) {
	alert('aaa');
	$.messager.alert('提示', msg, 'info');
}

function downinfo(filename) {
	$.ajax({
		type : "POST",
		url : 'check.action',
		data : 'name=' + filename,
		dataType : "json",
		complete : function(data) {
			var jsonData = eval("(" + data.responseText + ")");
			if (jsonData.msg == 'nohave') {
				$.messager.alert('提示', '下载失败!', 'info');
			} else {
				window.location.href = "downloadEquip.action?fileName="
						+ filename;
			}
		}
	});
}

function callback(json) {
	alert(json.msg);
	if (json.suc == 1) {
		window.location.href = "indexother.html";
	}
}

// 检查超链接是否有传值
function checkvalue(htmlPage) {
	var homepage = htmlPage;
	if (htmlPage.indexOf("?") != -1) {
		var pageurl = htmlPage.split("?");
		homepage = pageurl[0];
	}
	return homepage;
}

function getTime() {
	var toDay = new Date();// 创建时间对象
	var Year1 = toDay.getFullYear();// 年
	var Month1 = toDay.getMonth() + 1;// 月
	var day1 = toDay.getDate();// 日
	var Hours1 = toDay.getHours();// 时
	var Mi1 = toDay.getMinutes();// 分
	var Sec1 = toDay.getSeconds();// 秒

	var month = Month1.toString();
	if (month.length == 1) {
		month = "0" + month;
	}
	var day = day1.toString();
	if (day.length == 1) {
		day = "0" + day;
	}

	var hours = Hours1.toString();
	if (hours.length == 1) {
		hours = "0" + hours;
	}

	var mini = Mi1.toString();
	if (mini.length == 1) {
		mini = "0" + mini;
	}

	var sec = Sec1.toString();
	if (sec.length == 1) {
		sec = "0" + sec;
	}
	var time = Year1 + "/" + month + "/" + day + "  " + hours + ":" + mini
			+ ":" + sec;
	$("#datetime").text(time);
	setTimeout("getTime()", 1000); // 每格1秒刷新一次
}

function timecheck() {
	var stime = $("#stime").val();
	var etime = $("#etime").val();
	if (stime == '' && etime == '') {
		searchUser_client('test', 'queryForm');
	} else {
		if (stime == '' || etime == '' || stime > etime) {
			alert('请选择合适的查询时间!');
			return;
		}
		searchUser_client('test', 'queryForm');
	}
}

// 设备弹窗中的信息
function queryByIdEquip(queryByIdAction, ids) {
	var bol = false;
	$.ajax({
		type : "POST",
		async : false,
		url : queryByIdAction + "?id=" + ids,
		timeout : 15000,
		success : function(data) {
			$.each(data, function(idx, item) {
				if ($("[jsn$=" + idx + "]").is('p')
						|| $("[jsn$=" + idx + "]").is('div')) {
					$("[jsn$=" + idx + "]").html(item);
				}
				if ($("[jsn$=" + idx + "]").is('textarea')) {
					if (typeof KE != 'undefined') {
						KE.html('editor', item);
					} else {
						$("[jsn$=" + idx + "]").val(item);
					}
				} else {
					$("[jsn$=" + idx + "]").val(item);
				}
			});
			bol = true;
		}
	});
	return bol;
}

function queryEquipCompanyName(actionName, ids, companyname) {
	$.post(actionName + "?id=" + ids, function(date) {
		$("#" + companyname).val(date.msg);
	}, "json");
}

function typechange() {
	var type = $("#type").find("option:selected").val();
	if (type == '1') {
		modulehid();
	}
	if (type == '2') {
		ammeterhid();
	}
}
function ammeterhid() {
	for ( var i = 1; i <= 8; i++) {
		$("#moduletr" + i).show();
	}
	$("#ammetertr").hide();
	$("#addresstr").hide();
}
function modulehid() {
	for ( var i = 1; i <= 8; i++) {
		$("#moduletr" + i).hide();
	}
	$("#ammetertr").show();
	$("#addresstr").show();
}
// 通过行业子系统加载预览图片
function loadPreImage() {
	var companyid = $("#companyName").find("option:selected").val();
	var templatename = $("#templateName").find("option:selected").val();
	templatename = encodeURI(encodeURI(templatename));
	if (templatename == 'undefined') {
		templatename = '';
	}
	var url = "findPreImage.action?companyid=" + companyid + "&templatename="
			+ templatename
	$.post(url, function(date) {
		if (date.msg != '') {
			$("#image").attr("src", "../upload/" + date.msg);
		} else {
			$("#image").attr("src", "");
		}
	}, "json");
}

// 通过行业子系统加载预览图片(详细)
function loadPreImageDetail() {
	var companyid = $("#companyName").find("option:selected").val();
	var templatename = $("#templateName").val();
	templatename = encodeURI(encodeURI(templatename));
	if (templatename == 'undefined') {
		templatename = '';
	}
	var url = "findPreImage.action?companyid=" + companyid + "&templatename="
			+ templatename
	$.post(url, function(date) {
		if (date.msg != '') {
			$("#image").attr("src", "../upload/" + date.msg);
		} else {
			$("#image").attr("src", "");
		}
	}, "json");
}

// 对应企业选择权限信息
function CompMobelinfo(datagrid_id, actionName, datagrid_id1) {
	var rows = $('#' + datagrid_id).datagrid('getSelections');
	var ps = "";
	var params = $('#' + datagrid_id1).datagrid('options').queryParams;
	$.each(rows, function(i, n) {
		ps += n.company_name;
		params['company_name'] = ps;
	});
	$('#' + datagrid_id1).datagrid('reload');
}

// 判断是否选
function companysel(datagrid_id, datagrid_id1, company_id, companysel_id,
		typename, actionname, queryForma) {
	var id;
	var ids = $('#' + datagrid_id).datagrid('getSelections');
	var ps = "";
	if (ids.length <= 0) {
		alert('至少选择一条记录');
		return;
	}
	if (ids.length > 1) {
		alert('只能选择一条记录');
		return;
	}
	id = $('#' + datagrid_id).datagrid('getSelections')[0].id;
	var rows = $('#' + datagrid_id).datagrid('getSelections');
	$.each(rows, function(i, n) {
		ps = n.type;
	});
	$("#" + company_id).val('');
	$("#" + company_id).val(id);
	$("#" + companysel_id).val('');
	$("#" + companysel_id).val(id);
	$("#" + typename).val('');
	$("#" + typename).val(ps);
	searchUser_client(datagrid_id1, queryForma);
}

// 判断是否选
function companyselmob(datagrid_id, datagrid_id1, company_id,
		companymobelsel_id, template_id, actionname, queryForma) {
	var id;
	var ids = $('#' + datagrid_id).datagrid('getSelections');
	var ps;
	var sel_id;
	var temp_id;
	if (ids.length <= 0) {
		alert('至少选择一条记录');
		return;
	}
	if (ids.length > 1) {
		alert('只能选择一条记录');
		return;
	}
	var rows = $('#' + datagrid_id).datagrid('getSelections');
	$.each(rows, function(i, n) {
		ps = n.template_name;
		sel_id = n.id;
		temp_id = n.template_id;
	});

	$("#" + company_id).val('');
	$("#" + company_id).val(ps);
	$("#" + companymobelsel_id).val('');
	$("#" + companymobelsel_id).val(sel_id);
	$("#" + template_id).val('');
	$("#" + template_id).val(temp_id);
	searchUser_client(datagrid_id1, queryForma);
}

// 保存选择的企业模版
function saveCompMobelrow(datagrid_id, actionName, datagrid_id1, queryForma,
		Ccompanysel_id, Ccompanymobelsel_id, Ctemplate_id) {
	$.messager.confirm('提示', '确定要保存吗?', function(result) {
		if (result) {
			var rows = $('#' + datagrid_id).datagrid('getSelections');
			var ps = "";
			var mainurl = "";
			var tempid = "";
			var comsel = "";
			var comselmob = "";
			if (rows.length <= 0) {
				alert('至少选择一行');
				return;
			}
			if (rows.length > 1) {
				alert('只能选择一行');
				return;
			} else {
				$.each(rows, function(i, n) {
					ps += n.id + ":";
					mainurl = n.storage_location + "/" + n.industry_pageurl;
				});
				tempid = $("#" + Ctemplate_id).attr("value");
				comsel = $("#" + Ccompanysel_id).attr("value");
				comselmob = $("#" + Ccompanymobelsel_id).attr("value");
			}
			$.post(actionName, {
				id : ps,
				url : mainurl,
				companyselid : comsel,
				companymobelselid : comselmob,
				templateid : tempid
			}, function(data) {
				$('#' + datagrid_id).datagrid('reload');
				$.messager.alert('提示', '成功', 'info');
				searchUser_client(datagrid_id1, queryForma);
			});
		}
	});
}
// 企业选择模板保存子程序
function Selcompteml(dateGrid_id, queryForm_id) {
	var params = $('#' + dateGrid_id).datagrid('options').queryParams; // 先取得
	// datagrid
	// 的查询参数
	var fields = $('#' + queryForm_id).serializeArray(); // 自动序列化表单元素为JSON对象
	$.each(fields, function(i, field) {
		params[field.name] = field.value; // 设置查询参数
	});
	$('#' + dateGrid_id).datagrid('reload'); // 设置好查询参数 reload 一下就可以了
}

function SelcomptemlSave(actionName, ids, companyname) {
	$.post(actionName + "?id=" + ids, function(date) {
		$("#" + companyname).val(date.msg);
	}, "json");
}

formatString = function(str) {
	for ( var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};