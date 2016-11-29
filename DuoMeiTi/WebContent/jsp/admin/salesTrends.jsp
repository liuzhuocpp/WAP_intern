<%@ include file="/jsp/base/taglib.jsp"%>
<layout:override name="main_content">

<div class="mycontent">
	<div class="alert alert-success">
		Give the user an intuitive graph 
	</div>
	<div>
			<form class="form-inline" role="form">
			  <div class="form-group">
			    <div class="input-group">
			      <div class="input-group-addon">Start Time</div>
			      <input type="date" class="form-control"/>
			    </div>
			    <div class="input-group">
			      <div class="input-group-addon">End Time</div>
			      <input type="date" class="form-control"/>
			    </div>
   			    <div class="input-group">
			      <div class="input-group-addon">Time unit</div>
			      <select class="form-control">
			      		<option > By year </option>
			      		<option > By month </option>
			      		<option > By day </option>
			      </select>
			    </div>
			    
			  </div>
			  <button type="submit" class="btn btn-default">Show</button>
			</form>
		
	</div>
	<br/>
	
	
	
	
 <style type="text/css">
 body{margin:0;padding:0;}
ul,li,dl,dd,dt,p{margin:0;padding:0;}
ul,li{list-style:none;}
/*柱状图样式*/
.histogram-container{position:relative;margin-left:60px;margin-top:10px;margin-bottom:25px;}
.histogram-bg-line{border:#999 solid;border-width:0 1px 1px 1px;border-right-color:#eee;overflow:hidden;width:99%;}
.histogram-bg-line ul{overflow:hidden;border:#eee solid;border-width:1px 0 0 0;}
.histogram-bg-line li{float:left;width:20%;/*根据.histogram-bg-line下的ul里面li标签的个数来控制比例*/overflow:hidden;}
.histogram-bg-line li div{border-right:1px #eee solid;}
.histogram-content{position:absolute;left:0px;top:0;width:99%;height:100%;}
.histogram-content ul{height:100%;}
.histogram-content li{float:left;height:100%;width:20%;/*根据直方图的个数来控制这个width比例*/text-align:center;position:relative;}
.histogram-box{position:relative;display:inline-block;height:100%;width:20px;}
.histogram-content li a{position:absolute;bottom:0;right:0;display:block;width:20px;}
.histogram-content li .name{position:absolute;bottom:-20px;left:0px;white-space:nowrap;display:inline-block;width:100%;font-size:12px;}
.histogram-y{position:absolute;left:-60px;top:-10px;font:12px/1.8 verdana,arial;}
.histogram-y li{text-align:right;width:55px;padding-right:5px;color:#333;}
.histogram-bg-line li div,.histogram-y li{height:60px;/*控制单元格的高度及百分比的高度，使百分数与线条对齐*/}
 
</style>



<div class="histogram-container" id="histogram-container">
    <!--背景方格-->
    <div class="histogram-bg-line">
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
    </div>
    <!--柱状条-->
    <div class="histogram-content">
        <ul>
            <li>
                <span class="histogram-box"><a style="height:20%;background:#2f87d9;" title="20%"></a></span>
                <span class="name">2001</span>
            </li>
            <li>
                <span class="histogram-box"><a style="height:40%;background:green;" title="40%"></a></span>
                <span class="name">2002</span>
            </li>
            <li>
                <span class="histogram-box"><a style="height:50%;background:orange;" title="50%"></a></span>
                <span class="name">2003</span>
            </li>
            <li>
                <span class="histogram-box"><a style="height:80%;background:gray;" title="80%"></a></span>
                <span class="name">2004</span>
            </li>
        </ul>
    </div>
    <!--百分比 y轴-->
    <div class="histogram-y">
        <ul>
            <li>500W</li>
            <li>400W</li>
            <li>300W</li>
            <li>200W</li>
            <li>100W</li>
            <li>0W</li>
        </ul>
    </div>
</div>



















 
 
 

</div>
</layout:override>

<%@ include file="/jsp/admin/base.jsp"%>