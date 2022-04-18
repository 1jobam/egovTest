var UNDEFINED = "undefined";

var DEF_DATEFORMAT = "YYYY-MM-DD";
var DEFAULT_LOCALE = "ko";
var DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";

if(typeof String.prototype.trim !== 'function') {
	  String.prototype.trim = function() {
	    return this.replace(/^\s+|\s+$/g, ''); 
	  };
} 
function gfn_ajax_call(strUrl, params, fn_success, fn_error){
	var lError = function(request,status,error){
        alert("code:"+request.status+"\n"+"error:"+error);
    };
    
    if (typeof fn_error != 'undefined') {
    	lError = fn_error;
    }
    
    $("#loadingArea").hide();
    
    $.ajax({
        type       : "POST",
        cache      : false,                   
        url        : strUrl,
        data       : params,            
        dataType   : "json",                 
        success    : fn_success,
        error      : lError
    });
    
    
    $(window).ajaxStart(function() {
    	$("#loadingArea").css("height", $(document).height());
    	
    	$("#loadingArea img").css("top", (($(window).height() / 2) + $(document).scrollTop()) - 100);
    	$("#loadingArea").show();
    })
    .ajaxStop(function() {
    	$("#loadingArea").hide();
    });
}

function gfn_ajax_async_call(strUrl, params, fn_success, fn_error){
	var lError = function(request,status,error){
        alert("code:"+request.status+"\n"+"error:"+error);
    };
    
    if (typeof fn_error != 'undefined') {
    	lError = fn_error;
    }
    
    $("#loadingArea").hide();
    
    $.ajax({
        type       : "POST",
        cache      : false,                   
        url        : strUrl,
        async      : false,
        data       : params,            
        dataType   : "json",                 
        success    : fn_success,
        error      : lError
    });
    
    
    $(window).ajaxStart(function() {
    	$("#loadingArea").css("height", $(document).height());
    	
    	$("#loadingArea img").css("top", (($(window).height() / 2) + $(document).scrollTop()) - 100);
    	$("#loadingArea").show();
    })
    .ajaxStop(function() {
    	$("#loadingArea").hide();
    });
}

function gfn_ajax_json_call(strUrl, params, fn_success, fn_error){
	
	var lError = function(request,status,error){
        alert("code:"+request.status+"\n"+"error:"+error);
    };
    
    if (typeof fn_error != 'undefined') {
    	lError = fn_error;
    }
    
    $("#loadingArea").hide();
    
    $.ajax({
        type       : "POST",
        cache      : false,   
        url        : strUrl,
        data       : "json=" + params,            
        dataType   : "json",                 
        success    : fn_success,
        error      : lError
    });
    
    $(window).ajaxStart(function() {
    	$("#loadingArea").css("height", $(document).height());
    	
    	$("#loadingArea img").css("top", (($(window).height() / 2) + $(document).scrollTop()) - 100);
    	$("#loadingArea").show();
    })
    .ajaxStop(function() {
    	$("#loadingArea").hide();
    });
}

function checkPhoneNumber(text, fn_callback){
	var exp = /^\d{10}$/;
	if(text.match(exp)){
		if (typeof fn_error != UNDEFINED) {
			fn_callback(true);
		}
		else{
			return true;
		}
	}  
	else{
		if (typeof fn_error != UNDEFINED) {
			fn_callback(true);
		}
		else{
			return false;
		}
	}
}

function isBlank(str){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length == 0){
		return true;
	}
	return false;
}
function isNotBlank(str){
	return !isBlank(str);
}

/**
 * 핸펀 번호가 유효한지 검사, 자리수만 검사한다.
 */
function isValidMobileNo(str){
	var s = getOriginText(str);
	
	if(s == UNDEFINED || s == null){
		return false;
	}
	
	var len = s.length;
	return len == 10 || len == 11;
}

/**
 * 날자가 유효한지 검사, 자리수만 검사한다.
 */
function isValidDate(str){
	var s = getOriginText(str);
	
	if(s == UNDEFINED || s == null){
		return false;
	}
	
	var len = s.length;
	return len == 8;
}

/**
 * 사업자등록번호가 유효한지 검사, 자리수만 검사한다.
 */
function isValidBusinessNo(str){
	var s = getOriginText(str);
	
	if(s == UNDEFINED || s == null){
		return false;
	}
	
	var len = s.length;
	return len == 10;
}

function replaceAll(str, targetChar, replaceChar){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length == 0){
		return str;
	}

	var s = "";
	var len = str.length;
	for(var i = 0; i < len; i++){
		var c = str.charAt(i);
		if(c == targetChar){
			c = replaceChar;
		}
		s += c; 
	}
	return s;
}

function removePhoneSeparator(str){
	return getOriginText(str);
}

function removeDateSeparator(str){
	return getOriginText(str);
}

/**
 * 전화번호, 날짜와 같이 mask 가 설정된 문자열의 원본 text를 반환한다.
 * 	getOriginText("010-1234-5678"); 를 요청할 경우 "01012345678" 을 반환한다. 
 *  getOriginText("010-1234-____"); 를 요청할 경우 "0101234" 을 반환한다.
 * @param str
 * @returns
 */
function getOriginText(str){
	var s = replaceAll(str, "-", "");
	return replaceAll(s, "_", "");
}

function number_format(val){
	 return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function phone_format(str){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length == 0){
		return str;
	}
	
	var len = str.length;
	if(len == 10 || len == 11){
		var s1 = str.substr(0, 3);
		var s2 = str.substr(3, len == 10 ? 3 : 4);
		var s3 = str.substr(len-4, 4);
		return s1 + "-" + s2 + "-" + s3; 
	}
	else{
		return str;
	}	
}

function hospitalNo_format(str, separator){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length != 10){
		return str;
	}
	
	var sep = separator;
	if(typeof separator == UNDEFINED){
		sep = "-";
	}
	
	var s1 = str.substr(0, 3);
	var s2 = str.substr(3, 2);
	var s3 = str.substr(5, 5);
	return s1 + sep + s2 + sep + s3; 
}

function dateString_format(str, separator){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length != 8){
		return str;
	}
	
	var sep = separator;
	if(typeof separator == UNDEFINED){
		sep = "-";
	}
	
	var s1 = str.substr(0, 4);
	var s2 = str.substr(4, 2);
	var s3 = str.substr(6, 2);
	return s1 + sep + s2 + sep + s3; 
}

function date_format(date, separator) {
	if(typeof date == UNDEFINED || date == null){
		return "";
	}

	var sep = separator;
	if(typeof separator == UNDEFINED){
		sep = "-";
	}

	var year = date.getFullYear();
	var month = (1 + date.getMonth()).toString();
	month = month.length > 1 ? month : '0' + month;
	var day = date.getDate().toString();
	day = day.length > 1 ? day : '0' + day;
	return year + sep + month + sep + day;
}
function datetimeString_format(str, separator){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length != 14){
		return str;
	}
	var sep = separator;
	if(typeof separator == UNDEFINED){
		sep = ":";
	}
	
	var datestr = str.substr(0, 8);
	var date = dateString_format(datestr);
	var t1 = str.substr(8, 2);
	var t2 = str.substr(10 ,2);
	var t3 = str.substr(12 ,2);
	
	return date + " " + t1 + sep + t2 + sep + t3;
}

/*아이선택 check  */
function childCheck(animalSeq){
	if(animalSeq==null||animalSeq==""){
		alert("아이를 선택해 주세요");
		return false;
	}
	return true;
}

/* 날짜 시분초 변환*/
function datetimeString_format(str, separator){
	if(typeof str == UNDEFINED || str == null || str == "" || str.trim().length != 14){
		return str;
	}
	var sep = separator;
	if(typeof separator == UNDEFINED){
		sep = ":";
	}
	
	var datestr = str.substr(0, 8);
	var date = dateString_format(datestr);
	var t1 = str.substr(8, 2);
	var t2 = str.substr(10 ,2);
	var t3 = str.substr(12 ,2);
	
	return date + " " + t1 + sep + t2 + sep + t3;
}

// IE 8,9,10 maxlength option
$(document).on('keyup', 'textarea[maxlength]', function(e) {
    var $this = $(this);
    var maxlength = $this.attr('maxlength');
    if (!!maxlength) {
        var text = $this.val();
        
        if (text.length > maxlength) {
        	alert(maxlength + "글자 이내로 입력해주세요.")
            $this.val(text.substring(0,maxlength));
            e.preventDefault(); // 클릭 이벤트외에 별도의 브라우저의 행동을 막기 위함.
        }
    }
});

//Info메세지
function gfn_InfoMessage(text, title) {
	$.gritter.add({
		title: title == null ? '확인' : title,
		text: text,
		fade_out_speed: 2000,
		time: 4000, // hang on the screen for...
		class_name: 'gritter-info gritter-light gritter-center'
	});
}

// Alert메세지
function gfn_alertMessage(text, title) {
	$.gritter.add({
		title: title == null ? '경고': title,
		text: text,
		fade_out_speed: 2000,
		time: 4000, // hang on the screen for...
		class_name: 'gritter-error gritter-lightgritter-center'
	});
}

//Confirm메세지
function gfn_confirmMessage(text, fn_callback) {

	bootbox.confirm({
		message: text,
		buttons: {
		  confirm: {
			 label: "확인",
			 className: "btn-primary btn-sm",
		  },
		  cancel: {
			 label: "취소",
			 className: "btn-warnning btn-sm",
		  }
		},callback: fn_callback
	});
}

function moneyFormat(obj){
	obj.value = parseFloat(obj.value.replace(/,/g, ""))
	.toFixed(0)
	.toString()
	.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function compNumFormat(obj){
	if(obj.length != 10){
		return obj
	}
	var str = obj.substring(0,3) + "-" + obj.substring(3,5) + "-" + obj.substring(5,10);
	
	return str
}

function lawRegNumFormat(obj){
	if(obj.length != 13){
		return obj
	}
	var str = obj.substring(0,6) + "-" + obj.substring(6,13);
	
	return str
}

function actionSubmit(formId, mvPage){
	$('#pageNum').val(mvPage);
	$('#'+ formId).submit();
}

/*
 * drawPaging 을 사용할려면
 * form과 form안에 page 히든인풋이 있어야한다.
 * <input type="hidden" id="page" name="page" value="${page }"/>
 * */
function drawPaging(nowPage, maxPage, targetId, formId, pageSizeId){
	var startPage = 1;
	var endPage = 10;
	
	if(nowPage > 6){
		startPage = nowPage-5;
		endPage = nowPage + 4;
	}
	
	if(endPage > maxPage){
		endPage = maxPage;
	}
	
	var html ="";
	var pageSize = $('#' + pageSizeId).val();

	if(nowPage > 1){
		html += "<a href='javascript:actionSubmit(\"" + formId + "\", 1)' class='btn-pre'><i class='icon-double-angle-left'></i></a>";
	    html += "<a href='javascript:actionSubmit(\"" + formId + "\", " + (nowPage-1) + ")' class='btn-pre'><i class='icon-angle-left'></i></a>";
	}
	
	for(var i= startPage; i<=endPage; i++){
		html += "<a href='javascript:actionSubmit(\"" + formId + "\", " + i + ")' >"+ i +"</a>";
	}
	
	if(nowPage < endPage){
		html += "<a href='javascript:actionSubmit(\"" + formId + "\", " + (nowPage+1) + ")' class='btn-next'><i class='icon-angle-right' ></i></a>";
		html += "<a href='javascript:actionSubmit(\"" + formId + "\", " + (maxPage) + ")' class='btn-next'><i class='icon-double-angle-right' ></i></a>";
	}
	
	$('#'+targetId).append(html)	
}

function clear_form_elements(selector) {
	selector.find(':input').each(function() {
		switch(this.type) {
	        case 'password':
	        case 'text':
	        case 'textarea':
	        case 'file':
	        case 'select-one':
	        case 'select-multiple':
	        case 'date':
	        case 'number':
	        case 'tel':
	        case 'email':
	        case 'hidden':
	            $(this).val('');
	            break;
	        case 'checkbox':
	        case 'radio':
	            this.checked = false;
	            break;
	    }
	});
}

function fileDownload(fileName, filePath){
	$('#filedownload').find('#fileName').val(fileName);
	$('#filedownload').find('#filePath').val(filePath);
	$('#filedownload').submit();
}

function onlyNumberKeyUp(id){
	$("#"+id).keyup(function(event){
	    if (!(event.keyCode >=37 && event.keyCode<=40)) {
	        var inputVal = $(this).val();
	        $(this).val(inputVal.replace(/[^0-9]/gi,''));
	    }
	});
}


//사용 : onkeypress="javascript:inpuOnlyNumber(this);"
function inpuOnlyNumber(obj) {
    if (event.keyCode >= 48 && event.keyCode <= 57) {
        return true;
    } else {
        event.returnValue = false;
    }
}

function isOnlyNumberCommas(id) {
	$("#" + id).val($("#" + id).val().toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	
	
	$("#" + id).focusout(function(){
		$(this).val($(this).val().toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	});
	$("#" + id).focusin(function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,''));
	});
}


function validatorForm(formId) {
	try {
		$("#" + formId + " [required=Y]").each(function() {
			if($(this).val() == "") {
				alert($(this).attr("title") + "은(는) 필수입니다.");
				$(this).focus();
				throw this;
			}
		});
	} catch(e) {
		return false;
	}
	
	return true;
}


String.prototype.format = function() {
    var formatted = this;
    for (var i = 0; i < arguments.length; i++) {
        var regexp = new RegExp('\\{'+i+'\\}', 'gi');
        formatted = formatted.replace(regexp, arguments[i]);
    }
    return formatted;
};


function focusCal(id){
	setTimeout(function() { $('#' + id).focus(); }, 0);
}

function getTodayAddDays(days) {
	var result = new Date();
	result.setDate(result.getDate() + days);
		
	return result;
}

function getTodayAddDaysOnWeek(days) {
	var result = new Date();
	result.setDate(result.getDate() + days);
	
	if(result.getDay() == 0 || result.getDay() == 6) {
		return getTodayAddDaysOnWeek(days + 1);
	}
	
	return result;
}

function getAddDays(day, days) {
	var arr = day.split("-");
	var result = new Date(arr[0], arr[1] - 1, arr[2]);
	result.setDate(result.getDate() + days);
	return result;
}

function getDaysCal(day1, day2) {
	var arr1 = day1.split("-");
	var arr2 = day2.split("-");		
	var date1 = new Date(arr1[0], arr1[1] - 1, arr1[2]);
	var date2 = new Date(arr2[0], arr2[1] - 1, arr2[2]);		
	var diff = date2 - date1;		
	var day = 24*60*60*1000;		
	return Number(diff / day);
}