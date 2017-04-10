function load_performance_appraisal_index_page(){
	var assign_task_finished_panel = document.getElementById("assign_task_finished_panel");
	var assign_task_not_finished_panel = document.getElementById("assign_task_not_finished_panel");
	
	
	var assign_task_finished_panel_status = "";
	var assign_task_not_finished_panel_status = "";
	
	var strCookie=document.cookie; 
	//alert("strCookie:"+strCookie);
	if(strCookie!=null){
	    var arrCookie=strCookie.split(";");
	    for(var i=0;i<arrCookie.length;i++){ 
		    var arr=arrCookie[i].split("=");
		    //alert(arr[0]+","+arr[1]);
		    //alert(arr[0]=="assign_task_finished_panel_status");
		    if(arr[0].trim()=="assign_task_finished_panel_status"){
			    assign_task_finished_panel_status = arr[1];
			    //alert(assign_task_finished_panel_status);
		    }
		    //alert(arr[0]=="assign_task_not_finished_panel_status");
		    if(arr[0].trim()=="assign_task_not_finished_panel_status"){
			    assign_task_not_finished_panel_status = arr[1];
			    //alert(assign_task_not_finished_panel_status);
		    }
		
	    }
	}
	
	if(strCookie==null||((assign_task_finished_panel_status=="")&&(assign_task_not_finished_panel_status==""))){
		//alert("haha");
		assign_task_finished_panel.style.display="none";
		assign_task_not_finished_panel.style.display="";
	}else{
		if(assign_task_finished_panel!=null)
		    assign_task_finished_panel.style.display=assign_task_finished_panel_status;
		if(assign_task_not_finished_panel!=null)
		    assign_task_not_finished_panel.style.display=assign_task_not_finished_panel_status;
	}
}

function show_assign_task_finished_panel(){
	document.getElementById("assign_task_finished_panel").style.display="";
	document.getElementById("assign_task_not_finished_panel").style.display="none";
	
	save_layout_status();
}

function show_assign_task_not_finished_panel(){
	document.getElementById("assign_task_finished_panel").style.display="none";
	document.getElementById("assign_task_not_finished_panel").style.display="";
	
	save_layout_status();
}

function save_layout_status(){
	var assign_task_finished_panel_status = document.getElementById("assign_task_finished_panel").style.display;
	var assign_task_not_finished_panel_status = document.getElementById("assign_task_not_finished_panel").style.display;
	
	document.cookie = "assign_task_finished_panel_status="+assign_task_finished_panel_status;
	document.cookie = "assign_task_not_finished_panel_status="+assign_task_not_finished_panel_status;
}