<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- head-start -->
<jsp:include page="/common/head.jsp"></jsp:include>
<!-- head-end -->



</head>
<body>
	<div id="wrapper">
		<!-- recommend-start -->
		<jsp:include page="/common/recommend.jsp"></jsp:include>
		<!-- recommend-end -->

		<!-- navigation top-start -->
		<jsp:include page="/common/nav-top.jsp"></jsp:include>
		<!-- navigation top-end -->

		<!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
            
				<div class="col-md-12" >
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>添加用户</h4>
						</div>	
						<div class="panel-body">
							<div class="tab-content">
								<table class="table table-striped table-hover top10" id="showTable">
								</table>
								<ul class="pager" id="showTablePager"></ul>
							</div>
						</div>
					</div>
				</div>
                <!--/.Row-->
                
                <hr />
                
				<div class="col-md-4" >
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>添加用户</h4>
						</div>	
						<div class="panel-body">
							<div class="tab-content">
								<table class="table table-striped table-hover top10">
									<tr>
										<td>
											<input id="addUserWorkNumber" type="number" class="form-control" placeholder="输入工号">
										</td>
									</tr>
									<tr>
										<td>
											<input id="addUserName" type="text" class="form-control" placeholder="输入姓名">
										</td>
									</tr>
									<tr>
										<td>
											<input id="addUserUsername" type="text" class="form-control" placeholder="输入用户名">
										</td>
									</tr>
									<tr>
										<td>
											<input id="addUserPassword" type="text" class="form-control" placeholder="输入登陆密码">
										</td>
									</tr>
									<tr>
										<td>
											<select id="addUserSex" class="form-control">
												<option value= "女" >女</option>
												<option value= "男" >男</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<select id="addUserRole" class="form-control">
												<option value= "libAdmin" >图书管理员</option>
												<option value= "borrower" >借阅者</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<button class="btn btn-primary btn-lg" id="addUserBtn">
                               					 添加
                            				</button>
										</td>
									</tr>
								</table>
								
							</div>
						</div>
					</div>
				</div>
                <!--/.Row-->
                
                
				<hr />
                
				<div class="col-md-4" >
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>修改用户</h4>
						</div>	
						<div class="panel-body">
							<div class="tab-content">
								<table class="table table-striped table-hover top10">
									<tr>
										<td>
											<input id="editUserWorkdate" style="display:none;" type="text" class="form-control" placeholder="用户r入职时间">
											<input id="editUserId" style="display:none;" type="text" class="form-control" placeholder="用户id">
											<input id="editUserWorkNumber" type="number" class="form-control" placeholder="输入工号">
										</td>
									</tr>
									<tr>
										<td>
											<input id="editUserName" type="text" class="form-control" placeholder="输入姓名">
										</td>
									</tr>
									<tr>
										<td>
											<input id="editUserUsername" type="text" class="form-control" placeholder="输入用户名">
										</td>
									</tr>
									<tr>
										<td>
											<input id="editUserPassword" type="text" class="form-control" placeholder="输入登陆密码">
										</td>
									</tr>
									<tr>
										<td>
											<select id="editUserSex" class="form-control">
												<option value= "女" >女</option>
												<option value= "男" >男</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<select id="editUserRole" class="form-control">
												<option value= "libAdmin" >图书管理员</option>
												<option value= "borrower" >借阅者</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<button class="btn btn-info btn-lg" data-toggle="modal" id="getOneUserData">
                               					读取用户信息
                            				</button>
											<button class="btn btn-warning btn-lg" id="editUserBtn">
                               					 确认修改
                            				</button>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
                <!--/.Row-->
                
                
                <div class="col-md-2" >
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>批量删除</h4>
						</div>	
						<div class="panel-body">
							<div class="tab-content">
								<table class="table table-striped table-hover top10">
									<span class="btn btn-danger btn-lg" data-toggle="modal" id="delUserBtn">
                               			<i class="fa fa-sitemap"></i> 删除
                            		</span>
								</table>
							</div>
						</div>
					</div>
				</div>
                <!--/.Row-->
                
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    <!-- recommend-start -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
	<!-- recommend-end -->

</body>

<script type="text/javascript">

	// 用来记录 每页的数据条数 
	var currentPageRows = 1;

	$(document).ready(function(){
		onclickSeeAll( 0, currentPageRows );
	});

	// 执行分页查找 page 页码  ， rows 每页的数据条数  ，注意 ： 首页为0
	function onclickSeeAll(page , rows){
		$.ajax({
			type : "GET",
			url : "<%= basePath%>findUserPage",
			data : { page : page , rows : rows } ,
			dataType:"json",
			success:function(data){
				// 清空 表单信息
				$("#showTable").empty();
				// 清空分页按钮 上一页下一页等
				$("#showTablePager").empty();
				var _thead=$("<thead><tr>"+
							"<th><h4>选择</h4></th>"+
							"<th><h4>工号</h4></th>"+
							"<th><h4>姓名</h4></th>"+
							"<th><h4>用户名</h4></th>"+
							"<th><h4>性别</h4></th>"+
							"<th><h4>角色</h4></th>"+
							"<th><h4>入职年份</h4></th>"+
						"</tr></thead>");
				$("#showTable").append(_thead);
				
				// 遍历  添加 用户信息
				$.each(data.itemList,function(i,item){
					var _tr=$(
							"<tr >"+
								"<td>"+
									"<input class='checkbox' type='checkbox' id='checkboxList' name='checkboxList' value='"+item.id+"'>"+
								"</td>"+
								"<td>"+
									"<h5>"+item.workNumber+"</h5>"+
								"</td>"+
								"<td>"+
									"<h5>"+item.name+"</h5>"+
								"</td>"+
									"<td>"+
									"<h5>"+item.username+"</h5>"+
								"</td>"+
								"<td>"+
									"<h5>"+item.sex+"</h5>"+
								"</td>"+
								"<td>"+
								"<h5>"+  getRoleName( item.role ) + "</h5>"+
							"</td>"+
								"<td>"+
									"<h5>"+item.workdate+"</h5>"+
								"</td>"+
							"</tr>");
					$("#showTable").append(_tr);
				});
				
				// 添加 分页 上一页下一页等按钮
				var pagination = 
					"  <li><a id=\"previows\" ><«</a></li>\n" +
					"  <li class=\"disabled\" id=\"pageCount\" value=\""+ data.pageCount +"\" ><a >共"+ data.pageCount +"页</a></li>\n" +
					"  <li class=\"disabled\" id=\"pageNum\" value=\""+ data.pageNum++ +"\" ><a >当前:"+ data.pageNum +"页</a></li>\n" +
					"  <li class=\"disabled\" id=\"totalCount\" value=\""+ data.totalCount +"\" ><a >总数量:"+ data.totalCount +"</a></li>\n" +
					"  <li><a id=\"next\" >»></a></li>\n" ;
				$("#showTablePager").append( pagination );

				// 给上一页按钮添加点击事件
				$("#previows").click(function(){
					// 获取当前页码
					var pageNum = $("#pageNum").attr("value");
					if( pageNum <= 0){
						return false ;
					}
					// 减一
					pageNum -- ;
					// 查询
					onclickSeeAll( pageNum , currentPageRows );
				});
				// 给上一页按钮添加点击事件
				$("#next").click(function(){
					// 获取当前页码
					var pageNum = $("#pageNum").attr("value");
					// 获取总页数
					var pageCount = $("#pageCount").attr("value");
					// 加一
					pageNum ++ ;
					if( pageNum >= pageCount ){
						pageNum -- ;
						return false ;
					}
					// 查询
					onclickSeeAll( pageNum , currentPageRows );
				});
				
			}
		});
	}
	
	// 将 role 转化成 中文名称 : sysAdmin-》系统管理员 ; libAdmin-》图书管理员 ; borrower-》借阅者 ;
	function getRoleName(role){
		if( "sysAdmin" == role ){
			return "系统管理员";
		}else if ( "libAdmin" == role ) {
			return "图书管理员";
		}else{
			return "借阅者";
		}
		
	}
	
	
	
	// 用户记录当前正在修改的用户
	var userToEdit ;
	
	// 获取用户信息按钮 ， 按钮点击事件
	$("#getOneUserData").click(function(){
		// 获取复选框选中的条目
		var userIds =  $('[name=checkboxList]:checked');
		// 修改时只有复选框选中一个的时候才可以
		if( userIds.length == 1 ){
			// 得到选中的用户信息
			findUserById(userIds[0].value);
			console.log($('[name=checkboxList]:checked'));
			// 显示
			$("#editUserId").val( userToEdit.id );
			$("#editUserWorkNumber").val( userToEdit.workNumber );
			$("#editUserName").val( userToEdit.name );
			$("#editUserUsername").val( userToEdit.username );
			$("#editUserPassword").val( userToEdit.password );
			$("#editUserSex").val( userToEdit.sex );
			$("#editUserRole").val( userToEdit.role );
			$("#editUserWorkdate").val( userToEdit.workdate );
		}else{
			alert("进行修改操作时,必须一个用户被选中");
			return false ;
		}
		
	});
	
	// 通过 用户id 向后台 查询 用户信息
	function findUserById(userId){
		$.ajax({
			type : "GET",
			url : "<%= basePath%>findUserById",
			async:false,//取消异步请求
			data : { userId: userId } ,
			dataType:"json",
			success:function(data){
				console.log(data);
				userToEdit = data ;
			}
		});
	}
	
	
	// 确认修改按钮 ， 按钮点击事件
	$("#editUserBtn").click(function(){

		var id = $("#editUserId").val();
		var workNumber = $("#editUserWorkNumber").val();
		var name = $("#editUserName").val();
		var username = $("#editUserUsername").val();
		var password = $("#editUserPassword").val();
		var sex = $("#editUserSex").val();
		var role = $("#editUserRole").val();
		var workdate = $("#editUserWorkdate").val();
		
		// 初始化一个 用户
		var user = {} ;
		if( id == "" || workNumber == "" || name == "" || username == "" || password == "" || sex == "" || role == "" ){
			alert("检查是否有选中要修改的用户 或者 信息是否填写完整");
			return false ;
		}else{
			user.id = id ;
			user.workNumber = workNumber ;
			user.name = name ;
			user.username = username ;
			user.password = password ;
			user.sex = sex ;
			user.role = role ;
			user.workdate = workdate ;
			// 发送请求
			submitEditUser(user);
		}
		
	});
	
	// 删除按钮点击事件
	$("#delUserBtn").click(function(){
		// 获取复选框选中的条目
		var userIds =  $('[name=checkboxList]:checked');
		if( userIds.length <= 0 ){
			alert("请选择要删除的用户");
			return false ;
		}
		
		// 构造 要删除的用户id 数组
		var userIdArray = new Array();
		userIds.each(function(){
	        userIdArray.push( $(this).val() );
	    });
		// 发送请求
		submitDeleteUser( userIdArray );
		
	});
	
	// 添加按钮点击事件
	$("#addUserBtn").click(function(){
		
		var workNumber = $("#addUserWorkNumber").val();
		var name = $("#addUserName").val();
		var username = $("#addUserUsername").val();
		var password = $("#addUserPassword").val();
		var sex = $("#addUserSex").val();
		var role = $("#addUserRole").val();
		
		// 初始化一个 用户
		var user = {} ;
		if( workNumber == "" || name == "" || username == "" || password == "" || sex == "" || role == "" ){
			alert("信息未填写完整");
			return false ;
		}else{
			user.workNumber = workNumber ;
			user.name = name ;
			user.username = username ;
			user.password = password ;
			user.sex = sex ;
			user.role = role ;
			// 发送请求
			submitAddUser(user);
			
		}
	});
	
	// 用户判断用户名是否已存在
	var usernaemIsExict = "" ;
	
	// 发送添加 用户的 请求
	function submitAddUser(user){
		
		// 检查用户名是否被使用
		checkUserIsExict( user.username );
		if( usernaemIsExict ){
			alert("该用户名已被使用");
			return false ;
		}
		
		$.ajax({
			type : "POST",
			url : "<%= basePath%>addUser",
			data : { user: JSON.stringify(user) } ,
			success:function(data){
				if( data == "true" ){
					alert("添加成功");
					// 更新用户信息表数据
					onclickSeeAll( 0 , currentPageRows );
				}else{
					alert("添加失败");
				}
			}
		});
	}
	
	// 校验用户名是否已存在
	function checkUserIsExict(username){
		$.ajax({
			type : "GET",
			url : "<%= basePath%>findUserByUsername",
			async:false,//取消异步请求
			data : { username: username } ,
			success:function(data){
				if( data=="null" ){
					usernaemIsExict = false ;
				}else{
					usernaemIsExict = true ;
				}
			}
		});
	}
	
	// 发送修改 用户的 请求
	function submitEditUser(user){
		console.log(user);
		$.ajax({
			type : "POST",
			url : "<%= basePath%>updateUser",
			data : { user: JSON.stringify(user) } ,
			success:function(data){
				if( data == "true" ){
					alert("修改成功");
					// 更新用户信息表数据
					onclickSeeAll( 0 , currentPageRows );
				}else{
					alert("修改失败");
				}
			}
		});
	}
	
	// 发送删除 用户的 请求
	function submitDeleteUser(ids){
		$.ajax({
			type : "POST",
			url : "<%= basePath%>deleteUsersByIds",
			data : { ids: JSON.stringify(ids) } ,
			success:function(data){
				if( data == "true" ){
					alert("删除成功");
					// 更新用户信息表数据
					onclickSeeAll( 0 , currentPageRows );
				}else{
					alert("删除失败");
				}
			}
		});
	}
	
	
</script>
	
</html>
