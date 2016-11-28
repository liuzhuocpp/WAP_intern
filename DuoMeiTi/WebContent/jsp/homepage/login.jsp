<%@ include file="/jsp/base/taglib.jsp" %>

<layout:override name="main_content">
<br/>

	<form action="" method="POST" style="position:relative;left:20%">
	
	  <div class="form-group">
	    <label for="username">Username</label>	    
	    <input style="width:30%" type="text" class="form-control" name="username" value="<s:property value="username"/>" >
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input style="width:30%" type="password" class="form-control" name="password" value="<s:property value="password"/>" >
	  </div>
	  <a type="submit" class="btn btn-default" href="/admin/repertory">Login</a>
	</form>
	
	
	<script>

	</script>
	



</layout:override>



<%@ include file="/jsp/homepage/new_home_base.jsp" %>

