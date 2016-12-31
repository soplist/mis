var Browser=new Object();
Browser.isMozilla=(typeof document.implementation!='undefined')&&(typeof document.implementation.createDocument!='undefined')&&(typeof HTMLDocument!='undefined');
Browser.isIE=window.ActiveXObject ? true : false;
Browser.isFirefox=(navigator.userAgent.toLowerCase().indexOf("firefox")!=-1);
Browser.isSafari=(navigator.userAgent.toLowerCase().indexOf("safari")!=-1);
Browser.isOpera=(navigator.userAgent.toLowerCase().indexOf("opera")!=-1);
function init(){
    //alert(Browser.isIE?'ie':'not ie');
    //alert(Browser.isFirefox?'Firefox':'not Firefox');
    //alert(Browser.isSafari?'Safari':'not Safari');
    //alert(Browser.isOpera?'Opera':'not Opera');
}
window.onload=init;

var chart;
var chart1;
var chart2;
var chart3;
$(document).ready(function () {
	
	$.ajax({  
        url:'catchManagerPmTaskData',  
        type:'post', 
        async:false,
        data:"{}",  
        dataType:'json',  
        success:function (data) { 
        	var name = "";
        	var nameArr = [];
        	var allPoints = new Array();
        	$(data.managerPmTaskUserList).each(function (i, value) {  
        		//alert("name:"+value.name+",leader:"+value.leaderValue+",self:"+value.selfValue+",staff:"+value.staffValue);
        		name = value.name;
            	nameArr.push(name);
            	allPoints[i] = new Array();
            	allPoints[i][0]=value.leaderValue;
            	allPoints[i][1]=value.selfValue;
            	allPoints[i][2]=value.staffValue;
        	});  
        	
        	var points2 = {
            	chart: {
            		renderTo: 'container2',
            		defaultSeriesType: 'line', //type:line,spline,area,areaspline,bar,column
            		marginRight: 130,
            		marginBottom: 25
                },
                title: {
            		text: '管理考评情况', //first title
            		x: -20 //center
            	},
            	subtitle: {
            		text: '人员:全体员工', //second
            		x: -20
            	},
            	xAxis: {
            		categories: ['领导','个人','同事']//x axis
                },
            	yAxis: {
            		title: {
            		    text: 'Value' //y axis title
            		},
            		plotLines: [{
            		    value: 0,
            		    width: 1,
            		    color: '#808080'
            		}]
                },
                tooltip: {
            		formatter: function () {
            		    return '<b>' + this.series.name + '</b><br/>' + this.x + ': ' + this.y + '';  //show message when put mouse on value point
            		}
                },
                legend: {
            		layout: 'vertical',
            		align: 'right', //set description textleft/right/top/
            		verticalAlign: 'top',
            		x: -10,
            		y: 100,
            		borderWidth: 0
            	},
                exporting: {
            		enabled: true, //set print ot export button
            		url: "http://localhost:49394/highcharts_export.aspx" 
            	},
            	plotOptions: {
            		line: {
            		    dataLabels: {
            		        enabled: true //show every points value
            		    },
            		    enableMouseTracking: false
            		}
                },
                series: []
            };
        	
        	points2.series = new Array();
    	    var i;
    	    for(i=0;i<nameArr.length;i++)
    	    {
    	    	points2.series[i] = new Object();
    	    	points2.series[i].name = nameArr[i];
    	    	points2.series[i].data = allPoints[i];
    	    }
        		
    	    chart2 = new Highcharts.Chart(points2);
        }
	
    }); 

	$.ajax({  
        url:'catchPmTaskData',  
        type:'post', 
        async:false,
        data:"{}",  
        dataType:'json',  
        success:function (data) { 
        	var name = "";
        	var nameArr = [];
        	var allPoints = new Array();
        	$(data.pmTaskUserList).each(function (i, value) {  
        		//alert("name:"+value.name+",self:"+value.selfValue+",department:"+value.departmentValue+",manager:"+value.managerValue+",company:"+value.companyValue+",staff:"+value.staffValue);
        		name = value.name;
            	nameArr.push(name);
            	allPoints[i] = new Array();
            	allPoints[i][0]=value.selfValue;
            	allPoints[i][1]=value.departmentValue;
            	allPoints[i][2]=value.managerValue;
            	allPoints[i][3]=value.companyValue;
            	allPoints[i][4]=value.staffValue;
        	});  
        	var points1 = {
        		chart: {
        		    renderTo: 'container1',
        		    defaultSeriesType: 'line', //type:line,spline,area,areaspline,bar,column
        		    marginRight: 130,
        		    marginBottom: 25
        		},
        		title: {
        		    text: '员工总体绩效考核情况', //first title
        		    x: -20 //center
        		},
        		subtitle: {
        		    text: '人员:全体员工', //second
        		    x: -20
        		},
        		xAxis: {
        		    categories: ['个人','部门','主管','公司','同事']//x axis
        		},
        		yAxis: {
        		    title: {
        		        text: '分值' //y axis title
        		    },
        		    plotLines: [{
        		        value: 0,
        		        width: 1,
        		        color: '#808080'
        		    }]
        		},
        		tooltip: {
        		    formatter: function () {
        		        return '<b>' + this.series.name + '</b><br/>' + this.x + ': ' + this.y + '';  //show message when put mouse on value point
        		    }
        		},
        		legend: {
        		    layout: 'vertical',
        		    align: 'right', //set description textleft/right/top/
        		    verticalAlign: 'top',
        		    x: -10,
        		    y: 100,
        		    borderWidth: 0
        		},
        		exporting: {
        		    enabled: true, //set print ot export button
        		    url: "http://localhost:49394/highcharts_export.aspx" 
        		},
        		plotOptions: {
        		    line: {
        		        dataLabels: {
        		            enabled: true //show every points value
        		        },
        		        enableMouseTracking: false
        		    }
        		},
        		series: []
            };
        	
        	points1.series = new Array();
    	    var i;
    	    for(i=0;i<nameArr.length;i++)
    	    {
    	    	points1.series[i] = new Object();
    	    	points1.series[i].name = nameArr[i];
    	    	points1.series[i].data = allPoints[i];
    	    }
        		
            chart1 = new Highcharts.Chart(points1);
        }
	
    }); 
	
	
	
    
	//alert("hehe");
		var xAxis1="";
		var xAxis2="";
		var xAxis3="";
		var xAxis4="";
		var xAxis5="";
		var xAxis6="";
		var xAxis7="";
		var xAxis8="";
		var xAxis9="";
		var xAxis10="";
		var xAxis11="";
		var xAxis12="";
		var xAxis13="";
		var xAxis14="";
		var xAxis15="";
		var xAxis16="";
		var xAxis17="";
		var xAxis18="";
		var xAxis19="";
		var xAxis20="";
		var xAxis21="";
		var xAxis22="";
		var xAxis23="";
		var xAxis24="";
		var xAxis25="";
		var xAxis26="";
		var xAxis27="";
		var xAxis28="";
		var xAxis29="";
		var xAxis30="";
		$.ajax({  
	        url:'catchPointsChartData',  
	        type:'post', 
	        async:false,
	        data:"{}",  
	        dataType:'json',  
	        success:function (data) { 
	        	var name = "";
	        	var nameArr = [];
	        	var allPoints = new Array();
	        	
	            $(data.userList).each(function (i, value) {  
	            	//alert("name:"+value.name);
	            	name = value.name;
	            	nameArr.push(name);
	            	
	            	allPoints[i] = new Array();
	            	//alert(";"+i+";");
	            	//alert(i==0);
	            	//get x axis title
	            	var j = 0;
	            	for(var key in value.mapValue){
	            		j++;
	                    if(j==1){
	                    	xAxis1 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==2){
	                    	xAxis2 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==3){
	                    	xAxis3 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==4){
	                    	xAxis4 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==5){
	                    	xAxis5 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==6){
	                    	xAxis6 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==7){
	                    	xAxis7 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==8){
	                    	xAxis8 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==9){
	                    	xAxis9 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==10){
	                    	xAxis10 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==11){
	                    	xAxis11 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==12){
	                    	xAxis12 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==13){
	                    	xAxis13 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==14){
	                    	xAxis14 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==15){
	                    	xAxis15 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==16){
	                    	xAxis16 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==17){
	                    	xAxis17 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==18){
	                    	xAxis18 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==19){
	                    	xAxis19 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==20){
	                    	xAxis20 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==21){
	                    	xAxis21 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==22){
	                    	xAxis22 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==23){
	                    	xAxis23 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==24){
	                    	xAxis24 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==25){
	                    	xAxis25 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==26){
	                    	xAxis26 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==27){
	                    	xAxis27 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==28){
	                    	xAxis28 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==29){
	                    	xAxis29 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==30){
	                    	xAxis30 = key;
	                    	allPoints[i][j-1] = value.mapValue[key];
	                    }
	                    
	            	};
	            	
	            	for(var key in value.mapValue){
	            		//alert("key:" + key + ",value:"+ value.mapValue[key]);
	            	    //console.log("key:" + key + ",value:"+ jsonData[key]);  
	            	};  
	                //$("#allUser").append("<div>����ˣ�id:" + value.id + ", name: " + value.name + "</div>");  
	            	
	            	
	            	
	            });  
	            var points = {
	        	        chart: {
	        	            renderTo: 'container',
	        	            defaultSeriesType: 'line', //type:line,spline,area,areaspline,bar,column
	        	            marginRight: 130,
	        	            marginBottom: 25
	        	        },
	        	        title: {
	        	            text: '员工积分总体情况', //first title
	        	            x: -20 //center
	        	        },
	        	        subtitle: {
	        	            text: '人员:全体员工', //second
	        	            x: -20
	        	        },
	        	        xAxis: {
	        	            categories: [xAxis1, xAxis2, xAxis3, xAxis4, xAxis5, xAxis6, xAxis7, xAxis8, xAxis9, xAxis10,
	        	                         xAxis11, xAxis12, xAxis13, xAxis14, xAxis15, xAxis16, xAxis17, xAxis18, xAxis19, xAxis20,
	        	                         xAxis21, xAxis22, xAxis23, xAxis24, xAxis25, xAxis26, xAxis27, xAxis28, xAxis29, xAxis30]//x axis
	        	        },
	        	        yAxis: {
	        	            title: {
	        	                text: '分值' //y axis title
	        	            },
	        	            plotLines: [{
	        	                value: 0,
	        	                width: 1,
	        	                color: '#808080'
	        	            }]
	        	        },
	        	        tooltip: {
	        	            formatter: function () {
	        	                return '<b>' + this.series.name + '</b><br/>' +
	        	           this.x + ': ' + this.y + '';  //show message when put mouse on value point
	        	            }
	        	        },
	        	        legend: {
	        	            layout: 'vertical',
	        	            align: 'right', //set description textleft/right/top/
	        	            verticalAlign: 'top',
	        	            x: -10,
	        	            y: 100,
	        	            borderWidth: 0
	        	        },
	        	        exporting: {
	        	            enabled: true, //set print ot export button
	        	            url: "http://localhost:49394/highcharts_export.aspx" 
	        	        },
	        	        plotOptions: {
	        	            line: {
	        	                dataLabels: {
	        	                    enabled: true //show every points value
	        	                },
	        	                enableMouseTracking: false
	        	            }
	        	        },
	        	        series: []
	        	    };
	        		
	        		points.series = new Array();
	        	    var i;
	        	    for(i=0;i<nameArr.length;i++)
	        	    {
	        	    	points.series[i] = new Object();
	        	    	points.series[i].name = nameArr[i];
	        	    	points.series[i].data = allPoints[i];
	        	    }
	        		
	        	    chart = new Highcharts.Chart(points);

	        }  
		
	    }); 
	
		
		var x1="";
		var x2="";
		var x3="";
		var x4="";
		var x5="";
		var x6="";
		var x7="";
		var x8="";
		var x9="";
		var x10="";
		var x11="";
		var x12="";
		var x13="";
		var x14="";
		var x15="";
		var x16="";
		var x17="";
		var x18="";
		var x19="";
		var x20="";
		var x21="";
		var x22="";
		var x23="";
		var x24="";
		var x25="";
		var x26="";
		var x27="";
		var x28="";
		var x29="";
		var x30="";
		$.ajax({  
	        url:'catchInputCustomerData',  
	        type:'post', 
	        async:false,
	        data:"{}",  
	        dataType:'json',  
	        success:function (data) { 
	        	var name = "";
	        	var nameArr = [];
	        	var addCustomerData = new Array();
	        	$(data.customerMessageInputList).each(function (i, value) {
	        		//var mapValueStr = "";
	        		//for(var key in value.mapValue){
	            		//alert("key:" + key + ",value:"+ value.mapValue[key]);
	        			//mapValueStr += "key:" + key + ",value:"+ value.mapValue[key]+";";
	        		//}
	        		//alert(value.name+":"+mapValueStr);
	        		//alert(value.name);
	        		name = value.name;
	            	nameArr.push(name);
	            	
	            	addCustomerData[i] = new Array();
	            	//alert(";"+i+";");
	            	//alert(i==0);
	            	//get x axis title
	            	var j = 0;
	            	for(var key in value.mapValue){
	            		j++;
	                    if(j==1){
	                    	x1 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==2){
	                    	x2 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==3){
	                    	x3 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==4){
	                    	x4 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==5){
	                    	x5 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==6){
	                    	x6 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==7){
	                    	x7 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==8){
	                    	x8 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==9){
	                    	x9 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==10){
	                    	x10 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==11){
	                    	x11 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==12){
	                    	x12 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==13){
	                    	x13 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==14){
	                    	x14 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==15){
	                    	x15 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==16){
	                    	x16 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==17){
	                    	x17 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==18){
	                    	x18 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==19){
	                    	x19 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==20){
	                    	x20 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==21){
	                    	x21 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==22){
	                    	x22 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==23){
	                    	x23 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==24){
	                    	x24 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==25){
	                    	x25 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==26){
	                    	x26 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==27){
	                    	x27 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==28){
	                    	x28 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==29){
	                    	x29 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    else if(j==30){
	                    	x30 = key;
	                    	addCustomerData[i][j-1] = value.mapValue[key];
	                    }
	                    
	            	};
	        	});
	        	//alert('hehe');
	        	var points3 = {
	            	chart: {
	            		renderTo: 'container3',
	            		defaultSeriesType: 'line', //type:line,spline,area,areaspline,bar,column
	            		marginRight: 130,
	            		marginBottom: 25
	                },
	                title: {
	            		text: '客户信息录入情况', //first title
	            		x: -20 //center
	            	},
	            	subtitle: {
	            		text: '人员:全体员工', //second
	            		x: -20
	            	},
	            	xAxis: {
	            		categories: [x1, x2, x3, x4, x5, x6, x7, x8, x9, x10,
        	                         x11, x12, x13, x14, x15, x16, x17, x18, x19, x20,
        	                         x21, x22, x23, x24, x25, x26, x27, x28, x29, x30]//x axis
	                },
	            	yAxis: {
	            		title: {
	            		    text: 'Value' //y axis title
	            		},
	            		plotLines: [{
	            		    value: 0,
	            		    width: 1,
	            		    color: '#808080'
	            		}]
	                },
	                tooltip: {
	            		formatter: function () {
	            		    return 'aaa';  //show message when put mouse on value point
	            		}
	                },
	                legend: {
	            		layout: 'vertical',
	            		align: 'right', //set description textleft/right/top/
	            		verticalAlign: 'top',
	            		x: -10,
	            		y: 100,
	            		borderWidth: 0
	            	},
	                exporting: {
	            		enabled: true, //set print ot export button
	            		url: "http://localhost:49394/highcharts_export.aspx" 
	            	},
	            	plotOptions: {
	            		line: {
	            		    dataLabels: {
	            		        enabled: true //show every points value
	            		    },
	            		    enableMouseTracking: false
	            		}
	                },
	                series: []
	            };
	        	
	        	points3.series = new Array();
        	    var i;
        	    for(i=0;i<nameArr.length;i++)
        	    {
        	    	points3.series[i] = new Object();
        	    	points3.series[i].name = nameArr[i];
        	    	points3.series[i].data = addCustomerData[i];
        	    }
	        	chart3 = new Highcharts.Chart(points3);
	        }
		
	    }); 
});