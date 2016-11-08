//下一页 
function setNextPage(formName){
        var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var nowPg = parseInt($("#nowPg").val());
        var pgSize = parseInt($("#pgSize").val());
        start = start + pgSize;
        end = end + pgSize;
        nowPg = nowPg + 1;
        
        $("#start").val(start);
        $("#end").val(end);
        $("#nowPg").val(nowPg);
        //obj.href = actionName + ".action?start=" + start + "&end=" + end + "&nowPg=" +  nowPg;
        document.getElementById(formName).submit();
    }
//上一页
    function setLastPage(formName){
        var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var nowPg = parseInt($("#nowPg").val());
        var pgSize = parseInt($("#pgSize").val());
        start = start - pgSize;
        end = end - pgSize;
        nowPg = nowPg - 1;
        //obj.href = actionName + ".action?start=" + start + "&end=" + end + "&nowPg=" +  nowPg;
        $("#start").val(start);
        $("#end").val(end);
        $("#nowPg").val(nowPg);
        document.getElementById(formName).submit();
    }
    
    //obj1上一页对象，obj2下一页对象
    function initPage(obj1,obj2){
        var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var count = parseInt($("#count").val());
        var pgSize = parseInt($("#pgSize").val());
        if(start-pgSize<0){
            document.getElementById(obj2).style.display = "none";
        }
        if(end-count>=0){
            document.getElementById(obj1).style.display = "none";
        }
    }
    
    function initPageCnt(obj){
    	var count = parseInt($("#count").val());
        var pgSize = parseInt($("#pgSize").val());
        var pgCount = 1;
        if(count%10 != 0){
        	pgCount = parseInt(count/pgSize+1);
        }else{
        	pgCount = parseInt(count/pgSize);
        }
        
        document.getElementById(obj).innerHTML = "当前共有" + count + "条数据，" + "共" + pgCount + "页     ";
        
    }
    
    function redirectTo(formName){
    	var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var pgSize = parseInt($("#pgSize").val());
        var pgNum = parseInt($("#pageNum").val());
        
        start = pgSize*(pgNum - 1) + 1;
        end = pgSize*(pgNum);
        //window.location.href = actionName + ".action?start=" + start + "&end=" + end + "&nowPg=" +  pgNum;
        $("#start").val(start);
        $("#end").val(end);
        $("#pageNum").val(pgNum);
        $("#nowPg").val(pgNum);
        document.getElementById(formName).submit();
    }
    
    function goTop(formName){
    	var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var pgSize = parseInt($("#pgSize").val());
        var pgNum = parseInt($("#pageNum").val());
        
        start = 1;
        end = pgSize;
        
        $("#start").val(start);
        $("#end").val(end);
        $("#pageNum").val(1);
        $("#nowPg").val(1);
        
        document.getElementById(formName).submit();
    }
    
    function goDown(formName){
    	var start = parseInt($("#start").val());
        var end = parseInt($("#end").val());
        var pgSize = parseInt($("#pgSize").val());
        var pgNum = parseInt($("#pageNum").val());
    	var count = parseInt($("#count").val());
        var pgSize = parseInt($("#pgSize").val());
        var pgCount = parseInt(count/pgSize+1);
        
        start = (pgCount-1)*pgSize + 1;
        end = pgCount*pgSize;
        pgNum=pgCount;
        
        $("#start").val(start);
        $("#end").val(end);
        $("#pageNum").val(pgNum);
        $("#nowPg").val(pgCount);
        
        document.getElementById(formName).submit();
    }
  