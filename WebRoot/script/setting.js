var propen = 0;
function setTextView(id,kind){
	if(propen==0){
		var xmlhttp=null;
		if(kind=="1"){
			var td = document.getElementById('prp_'+id);
		}
		if(kind=="2"){
			var td = document.getElementById('dep_'+id);
		}
		if(kind=="3"){
			var td = document.getElementById('mep_'+id);
		}
		if(kind=="4"){
			var td = document.getElementById('ce1p_'+id);
		}
		if(kind=="5"){
			var td = document.getElementById('ce2p_'+id);
		}
	    var content = td.innerText;
	    content=content.substring(0,content.length-1);
	    td.innerHTML=""; 
	    var input = document.createElement('input');
	    input.id = 'prp';
	    input.type = 'text';
	    input.value = content;
	    input.style.width = "30px";
	    input.onblur=function(){
	    	//alert("heihei");
	    	var val = input.value;
	    	if(isNaN(val)){
	    	    alert("ÇëÊäÈëÊı×Ö");
	    	    return false;
	    	}
	    	var intval = parseInt(val);
	    	if(intval>100||intval<0){
	    		alert("±ÈÀı·¶Î§1-100");
	    		return false;
	    	}
	    	//submit data
	    	//clear input
	    	if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject){// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            var data = "per="+val+"&uid="+id+"&kind="+kind;
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
            xmlhttp.open("post","updatePercentage");
            xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
            xmlhttp.send(data);
	    };
	    td.appendChild(input);
	    var sign=document.createElement('b');
	    sign.innerHTML = '%';
	    td.appendChild(sign,input);
	    input.focus();
	    propen = 1;
	    //document.getElementById('text_1').focus();
	}
}

function getJoinins(id,type){
	if(type=="1"){
		var personalCtl = document.getElementById("personal_"+id);
		var joinin_1=personalCtl.value;
		alert(personalCtl.value);
		
		if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
            xmlhttp=new XMLHttpRequest();
        }
        else if (window.ActiveXObject){// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        var data = "joinin_1="+joinin_1+"&type="+type+"&user_id="+id;
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
        xmlhttp.open("post","updateJoinin");
        xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
        xmlhttp.send(data);
	}
	
	if(type=="2"){
		var deptStaffCtl = document.getElementById("dept_staff_"+id);
        var deptJoinin="";
        for(var i=0;i<deptStaffCtl.length;i++)
        {
            if(deptStaffCtl.options[i].selected)
            	deptJoinin+=deptStaffCtl.options[i].value+",";
        }
		
		if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
            xmlhttp=new XMLHttpRequest();
        }
        else if (window.ActiveXObject){// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        var data = "deptJoinin="+deptJoinin+"&type="+type+"&user_id="+id;
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
        xmlhttp.open("post","updateJoinin");
        xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
        xmlhttp.send(data);
	}
	if(type=="3"){
		var managerCtl = document.getElementById("manager_"+id);
		var joinin_1=managerCtl.value;
		alert(managerCtl.value);
		
		if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
            xmlhttp=new XMLHttpRequest();
        }
        else if (window.ActiveXObject){// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        var data = "joinin_1="+joinin_1+"&type="+type+"&user_id="+id;
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
        xmlhttp.open("post","updateJoinin");
        xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
        xmlhttp.send(data);
	}
	if(type=="5"){
		var companyStaffCtl = document.getElementById("company_staff_"+id);
        var companyJoinin="";
        for(var i=0;i<companyStaffCtl.length;i++)
        {
            if(companyStaffCtl.options[i].selected)
            	companyJoinin+=companyStaffCtl.options[i].value+",";
        }
		
		if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
            xmlhttp=new XMLHttpRequest();
        }
        else if (window.ActiveXObject){// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        var data = "companyJoinin="+companyJoinin+"&type="+type+"&user_id="+id;
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
        xmlhttp.open("post","updateJoinin");
        xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
        xmlhttp.send(data);
	}
}
