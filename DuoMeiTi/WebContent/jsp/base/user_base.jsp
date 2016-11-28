<%@ include file="/jsp/base/taglib.jsp" %>

<layout:override name="base_content">
	
 

<div class="row pageHeader"  >
   	
   
	  <div class="col-md-5">
			 <a href="/">
			 	<div class="pageHeader">			 	
			 	</div>
			 	
			 </a>
	  </div>
 	<div class="col-md-5"  >  	
       <ul class="nav navbar-right">
           <li id="welcome_word">            	
	           	欢迎您: 
	           	<span id="login_user_name">
	           		<s:property value="#session.fullName"/>
	           	</span>
	           	     (您是管理员)		           	
           </li>
       </ul>
	</div>
</div>



<div class="container-fluid main-container">
    <div class="row col-lg-12">
        <div class="col-lg-3 ">	                    
            <layout:block name="menu_list">
            </layout:block>	
        </div>
        <div class="col-lg-9">
        	<div class="main-content">
            	<layout:block name="main_content">
            	</layout:block>
         </div>
        </div>
    </div>
</div>



        
 <layout:block name="nav_content">
 
 </layout:block>
	

	
	
</layout:override>

<%@ include file="/jsp/base/base.jsp" %>


   	