function changePSetting(id,type){
	var ctl;
	var value;
	if(type=="1"){
		ctl = document.getElementById("c_"+id);
	}
	if(type=="2"){
		ctl = document.getElementById("r_"+id);
	}
	if(type=="3"){
		ctl = document.getElementById("u_"+id);
	}
	if(type=="4"){
		ctl = document.getElementById("d_"+id);
	}
	if(type=="5"){
		ctl = document.getElementById("pmsetting_"+id);
	}
	if(type=="6"){
		ctl = document.getElementById("psetting_"+id);
	}
	if(type=="7"){
		ctl = document.getElementById("viewall_"+id);
	}
	value=ctl.value;
	
	if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject){// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var data = "value="+value+"&type="+type+"&permission_id="+id;
    xmlhttp.onreadystatechange=function(){
    	if (xmlhttp.readyState==4){// 4 = "loaded"
            if (xmlhttp.status==200){// 200 = "OK"
                //alert("form has been submit!");
            	location.reload();
            }
  	        else{
    	        alert("Problem retrieving data:" + xmlhttp.statusText);
            }
        }
    };
    xmlhttp.open("post","updatePermissionSetting");
    xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
    xmlhttp.send(data);
}

function updateUsers(id){
	var ctl = document.getElementById("users_"+id);
    var users="";
    for(var i=0;i<ctl.length;i++)
    {
        if(ctl.options[i].selected)
        	users+=ctl.options[i].value+",";
    }
	
	if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject){// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var data = "users="+users+"&id="+id;
    xmlhttp.onreadystatechange=function(){
    	if (xmlhttp.readyState==4){// 4 = "loaded"
            if (xmlhttp.status==200){// 200 = "OK"
                //alert("form has been submit!");
            	location.reload();
            }
  	        else{
    	        alert("Problem retrieving data:" + xmlhttp.statusText);
            }
        }
    };
    xmlhttp.open("post","updateUsers");
    xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
    xmlhttp.send(data);
}