function load_performance_measurement_page(){
	var assign_task_finished_panel = document.getElementById("assign_task_finished_panel");
	var assign_task_not_finished_panel = document.getElementById("assign_task_not_finished_panel");
	var personal_task_panel = document.getElementById("personal_task_panel");
	var all_task_panel = document.getElementById("all_task_panel");
	
	
	var assign_task_finished_panel_status = "";
	var assign_task_not_finished_panel_status = "";
	var personal_task_panel_status = "";
	var all_task_panel_status = "";
	
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
		    //alert(arr[0]=="personal_task_panel_status");
		    if(arr[0].trim()=="personal_task_panel_status"){
			    personal_task_panel_status = arr[1];
			    //alert(personal_task_panel_status);
		    }
		    //alert(arr[0]=="all_task_panel_status");
		    if(arr[0].trim()=="all_task_panel_status"){
			    all_task_panel_status = arr[1];
			    //alert(all_task_panel_status);
		    }
		
	    }
	}
	
	//alert("status:"+assign_task_finished_panel_status+","+assign_task_not_finished_panel_status+","+personal_task_panel_status+","+all_task_panel_status);
	//alert("1:"+(assign_task_finished_panel_status==""));
	//alert("2:"+(assign_task_not_finished_panel_status==""));
	//alert("3:"+(personal_task_panel_status==""));
	//alert("4:"+(all_task_panel_status==""));
	//alert("init:"+((assign_task_finished_panel_status=="")&&(assign_task_not_finished_panel_status=="")&&(personal_task_panel_status=="")&&(all_task_panel_status=="")));
	if(strCookie==null||((assign_task_finished_panel_status=="")&&(assign_task_not_finished_panel_status=="")&&(personal_task_panel_status=="")&&(all_task_panel_status==""))){
		//alert("haha");
		assign_task_finished_panel.style.display="none";
		assign_task_not_finished_panel.style.display="";
		personal_task_panel.style.display="";
		all_task_panel.style.display="none";
	}else{
		if(assign_task_finished_panel!=null)
		    assign_task_finished_panel.style.display=assign_task_finished_panel_status;
		if(assign_task_not_finished_panel!=null)
		    assign_task_not_finished_panel.style.display=assign_task_not_finished_panel_status;
		if(personal_task_panel!=null)
		    personal_task_panel.style.display=personal_task_panel_status;
		if(all_task_panel!=null)
		    all_task_panel.style.display=all_task_panel_status;
	}
	
	
}

function hiddenTask(){
    document.getElementById("assign_task_content").style.display="none";
}

function showTask(){
    document.getElementById("assign_task_content").style.display="";
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

function show_all_task_panel(){
	document.getElementById("personal_task_panel").style.display="none";
	document.getElementById("all_task_panel").style.display="";
	
	save_layout_status();
}

function show_personal_task_panel(){
	document.getElementById("personal_task_panel").style.display="";
	document.getElementById("all_task_panel").style.display="none";
	
	save_layout_status();
	
	/*document.cookie = "a=1";
	document.cookie = "b=2";
	document.cookie = "c=3";
	
	var strCookie=document.cookie; 
	var arrCookie=strCookie.split("; ");
	
	for(var i=0;i<arrCookie.length;i++){ 
		var arr=arrCookie[i].split("=");
		alert(arr[0]+","+arr[1]);
	}
	
	var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    document.cookie= "a=1"+";expires="+exp.toGMTString(); 
    document.cookie= "b=2"+";expires="+exp.toGMTString();
    document.cookie= "c=3"+";expires="+exp.toGMTString();*/
}

function save_layout_on_change_all_pmtask_page(){
	save_layout_status();
}

function save_layout_on_change_finished_pmtable_page(){
	save_layout_status();
}

function save_layout_status(){
	var assign_task_finished_panel_status = document.getElementById("assign_task_finished_panel").style.display;
	var assign_task_not_finished_panel_status = document.getElementById("assign_task_not_finished_panel").style.display;
	var personal_task_panel_status = document.getElementById("personal_task_panel").style.display;
	var all_task_panel_status = document.getElementById("all_task_panel").style.display;
	//alert(assign_task_finished_panel_status+","+assign_task_not_finished_panel_status+","+personal_task_panel_status+","+all_task_panel_status);
	
	document.cookie = "assign_task_finished_panel_status="+assign_task_finished_panel_status;
	document.cookie = "assign_task_not_finished_panel_status="+assign_task_not_finished_panel_status;
	document.cookie = "personal_task_panel_status="+personal_task_panel_status;
	document.cookie = "all_task_panel_status="+all_task_panel_status;
}

