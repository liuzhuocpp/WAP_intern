<%@ include file="/jsp/base/taglib.jsp" %>

<layout:override name="main_content">
<br/>

	<form action="" method="POST" style="position:relative;left:20%">
	
	  <div class="form-group">
	    <label for="username">用户名</label>	    
	    <input style="width:30%" type="text" class="form-control" name="username" value="<s:property value="username"/>" placeholder="">
	  </div>
	  <div class="form-group">
	    <label for="password">密码</label>
	    <input style="width:30%" type="password" class="form-control" name="password" value="<s:property value="password"/>" placeholder="">
	  </div>
	  <a type="submit" class="btn btn-default" href="/admin/repertory">登录</a>
	</form>
	
	
	<script>

	</script>
	



</layout:override>



<%@ include file="/jsp/homepage/new_home_base.jsp" %>

