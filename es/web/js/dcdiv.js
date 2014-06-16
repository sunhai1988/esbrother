  var manager = null; 
function popupDiv(div_id) {   
	var blg = $("#issystemmaterplate").val();
	if(blg == ""){
		alert("请选择模板");
		return;
	}
        var div_obj = $("#"+div_id);  
        var windowWidth = document.body.clientWidth;       
        var windowHeight = document.body.clientHeight;  
        var popupHeight = div_obj.height();       
        var popupWidth = div_obj.width();    
        //添加并显示遮罩层   
        $("<div id='mask'></div>").addClass("mask")   
                                  .width(windowWidth + document.body.scrollWidth)   
                                  .height(windowHeight + document.body.scrollHeight)   
                                  .click(function() {hideDiv(div_id); })   
                                  .appendTo("body")   
                                  .fadeIn(200);   
        div_obj.css({"position": "absolute"})   
               .animate({left: windowWidth/2-popupWidth/2,    
                         top: windowHeight/2-popupHeight/2, opacity: "show" }, "slow"); 
        initTreeOne(blg);   
                        
    }   
      
    function hideDiv(div_id) {   
        $("#mask").remove(); 
//        $("#tt2").remove(); 
        $("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow");   
    }  
    
    function hideDiv1(div_id) {   
    	var node = $('#tt2').tree('getSelected');
		alert(node.text);

//    	$("#sd").val(tree.getSelectedItemText());
    	$("#mask").remove();   
        $("#" + div_id).animate({left: 0, top: 0, opacity: "hide" }, "slow");   
//    	alert(tree.getSelectedItemText());
    }  
    
    function initTree(){
    	$('#tt2').tree({
    		checkbox: false,
    		url: 'queryTree.action',
    		onClick:function(node){
    			$(this).tree('toggle', node.target);
    				alert('you dbclick '+node.text);
    		},
    		onContextMenu: function(e, node){
    			e.preventDefault();
    			$('#tt2').tree('select', node.target);
    			$('#mm').menu('show', {
    				left: e.pageX,
    				top: e.pageY
    			});
    		}
    	});
    }
    
    function initTreeOne(blg){
    	
//    	alert(blg);
//    	alert($("#issystemmaterplate").val()=="");
//    	manager=null;
    	manager = $("#tt2").ligerTree({
    		url: 'queryTree.action?num='+blg,
    		checkbox:false,
    		
   		 onSuccess:function(){
//            	var manager = $("#tt2").ligerGetTreeManager();
            	 manager.collapseAll();
            }
    	});
    	$("#pageloading").hide();
    }
    
   function initTreeOne_other(blg,biao){
    	
//    	alert(blg);
//    	alert($("#issystemmaterplate").val()=="");
//    	manager=null;
    	manager = $("#"+biao).ligerTree({
    		url: 'queryTree.action?num='+blg,
    		checkbox:false,
    		
   		 onSuccess:function(){
//            	var manager = $("#tt2").ligerGetTreeManager();

            	 manager.collapseAll();
            }
    	});
    	$("#pageloading").hide();
    }
//    var DG = frameElement.lhgDG;
