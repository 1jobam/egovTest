<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta name="robots" content="noindex, nofollow"/>

<title>test</title>
<meta name="title" content="test">

<link rel="canonical" href="http://bridge.smtech.go.kr/home.do"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css"/>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<script src="js/jquery.bxslider.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script src="js/slides.min.jquery.js"></script>
<script src="js/tabmenu.js"></script>
<script src="js/script.js"></script>
</head>


<body>
<form id="mvPage" name="mvPage" action="<c:url value="/login.do" />" method="post">
	<input type="hidden" id="type" name="type" value="U" />
</form>

<div class="wrap">
	
	<!-- Header Start-->
	<div id="header">
		<!-- gnbbox Start -->
		<div class="gnb">
			<ul class="iconBox">
				<h1><a href="<c:url value="" />" title="중소기업기술혁신센터LOGO"><img src="images/main/logo.png" width="233" height="36" alt="중소기업기술혁신센터LOGO"/></a></h1>
				<li>
					<a href="<c:url value="" />" class="btn-home" title="홈"><i class="icon-home"></i> HOME</a>
					<c:if test="${ not empty sessionScope.mbrId}">
						<a href="javascript:fnLogout();" class="btn-unlock" title="로그아웃"><i class="icon-unlock"></i> LOGOUT</a>
						<a href="<c:url value="/com/my/mypage.do" />" class="btn-lock" title="마이페이지"><i class="icon-user"></i> MYPAGE</a>
					</c:if>
					<c:if test="${ empty sessionScope.mbrId}">
						<a href="<c:url value="/login.do" />" class="btn-lock" title="로그인"><i class="icon-lock"></i> LOGIN</a>						
					</c:if>
					<a href="<c:url value="/com/if/sitemap.do" />" class="btn-sitemap" title="사이트맵"><i class="icon-sitemap"></i> SITEMAP</a>
				</li>
			</ul>
		</div>
		<!--// gnbbox End -->
	</div>
	<!--// Header End-->
	
	
	<!--Container Start-->
	<div id="container">
		<!--Content Start-->
		<div class="content">
			
			<!-- Lnb Start -->
            <div class="LnbBox">
             
              <ul class="menu">
                <li><a href="<c:url value="/com/cn/vision.do" />">기술혁신센터</a>
                    <ul>
                        <li><a href="<c:url value="/com/cn/vision.do" />">센터소개</a></li>
                        <li><a href="<c:url value="/com/cn/location.do" />">찾아오시는 길</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/mbs/cn/membershipInfo.do" />">멤버십기업</a>
                    <ul>
                        <li><a href="<c:url value="/mbs/cn/membershipInfo.do" />">멤버십기업 혜택</a></li>
                        <li><a href="<c:url value="/mbs/mg/membershipAppl.do" />">멤버십기업 신청</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/res/cn/resourceInfo.do" />">센터시설</a>
                    <ul>
                        <li><a href="<c:url value="/res/cn/resourceInfo.do" />">시설현황</a></li>
                        <li><a href="#" onclick="resPostMove2('_self', '<c:url value='/res/sc/resourceRsrv.do'/>', 'H12005', 'H12000');">예약하기</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/pgm/rc/programList.do" />">프로그램</a>
                    <ul>
                        <li><a href="<c:url value="/pgm/rc/programList.do" />">기술교류 프로그램</a></li>
                        <li><a href="<c:url value="/pgm/cs/counselAppl.do" />">기술상담</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/tco/cn/rndInfo.do" />">협력R&amp;D</a>
                    <ul>
                        <li><a href="<c:url value="/tco/cn/rndInfo.do" />">기술교류 연계과제(R&amp;D)</a></li>
                        <li><a href="<c:url value="/tco/mt/mentoInfo.do" />">R&amp;D멘토링</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="/ifg/no/noticeList.do" />">정보마당</a>
                    <ul>
                        <li><a href="<c:url value="/ifg/no/noticeList.do" />">공지사항</a></li>
                        <li><a href="<c:url value="/ifg/in/noticeList.do" />">협력기관 사업홍보</a></li>
                    </ul>
                </li>
              </ul>
            
            </div>			
			<!--// Lnb End-->
			
			<!--mainbanner Start -->
			<div id="mbanBox"> 
				
				<ul class="bxslider">
					<!-- <li class="mbanner01" style="float:left;left:0;"><div style="margin-left: 353px; background-image:url('/brg/images/main/main_2.jpg'); height:549px;width:1903px;"/></li> -->
					<c:if test="${empty mainBanner}">
						<li class="mbanner01" style="float:left;left:0;"><div style="margin-left: 353px; background-image:url('/brg/images/main/main_2.jpg'); height:549px;width:1903px;"/></li>
					</c:if>
					<c:forEach var="item" items="${mainBanner}" varStatus="status">
						<a href="http://${item.url }" style="float:left;position:absolute; width:100%; z-index: 0; display: none;left:0;top:0">
							<li class="mbanner01" style="float:left;left:0;"><img src="<c:url value="/comn/AtchFileDownload.do"/>?atchFileId=${item.atchFileId }" style="height:549px;width:1903px;"></img></li>
						</a>
					</c:forEach>
				</ul>
			</div>
			<!--// mainbanner End -->
			
			
			<!--conbox start -->
			<div id="conBox">
				
				<!--tab list Start-->
				<div class="tab_list m1" id="tab">
					<ul>
						<li class="m1">
							<a title="공지사항" style="cursor:pointer"><span class="tabtit">공지사항</span></a>
							<ul class="slistbox">
								<c:forEach var="item" items="${noticeList}" varStatus="status">
									<li><a href="<c:url value="/ifg/no/noticeView.do" />?&boardSeq=${item.boardSeq }">${item.subject }</a><span class="date">${item.regDt }</span></li>
								</c:forEach>
							</ul>
							<p class="more"><a href="<c:url value= "/ifg/no/noticeList.do" />" title="더보기"></a></p>
						</li>
					</ul>
				</div>
				<!--//tab list End-->
				
				<!--infomation  slider banner Start-->
				<div id="slides" class="slides">
					<ul class="slide" style="overflow: visible !important;">
						<c:forEach var="item" items="${subBanner}" varStatus="status">
							<li><a href="http://${item.url }" target="_blank" rel="noopener noreferrer"><img src="<c:url value="/comn/AtchFileDownload.do"/>?atchFileId=${item.atchFileId }" ></a></li>  
						</c:forEach>
					</ul>
				</div>
				<!--//infomation  slider banner End-->
				
				<!-- sbanner Start-->
				<ul class="sbanBox">
					<li><a href="<c:url value="/mbs/cn/membershipInfo.do" />" title="멤버십기업"><img src="images/main/sban1.png" alt="멤버십기업"></a></li>
					<li><a href="#" onclick="resPostMove2('_self', '<c:url value='/res/sc/resourceRsrv.do'/>', 'H12005', 'H12000');" title="센터시설"><img src="images/main/sban2.png" alt="센터시설"></a></li>
					<li><a href="<c:url value="/pgm/rc/programList.do" />" title="프로그램"><img src="images/main/sban3.png" alt="프로그램"></a></li>
					<li><a href="<c:url value="/pgm/cs/counselAppl.do" />" title="기술상담"><img src="images/main/sban4.png" alt="기술상담"></a></li>
				</ul>
				<!--//sbanner End-->
			
				<!--company banner Start-->
				<div class="combanBox" style="margin-top:50px;">
					<div class="nav" style="width:165px;">
						<button onClick="moveType=0;" class="btn-left"><i class="icon-angle-left"></i></button>  
						<button onClick="movePause=true;" class="btn-pause" id="playBtn"><i class="icon-pause"></i></button>
						<button onClick="moveType=1;" class="btn-left"><i class="icon-angle-right" ></i></button>  
					</div>
					
					<div class="RollDiv" style="width:835px;">  
						<div>  
							<a href="http://www.tipa.or.kr" title="중소기업기술정보진흥원" target="_blank" rel="noopener noreferrer"><img src="images/main/ban_link01.png" alt="중소기업기술정보진흥원"></a>  
							<a href="http://www.mss.go.kr/site/smba/main.do" title="중소벤처기업부" target="_blank" rel="noopener noreferrer"><img src="images/main/ban_link02.png" alt="중소벤처기업부"></a>  
							<a href="http://www.smtech.go.kr" title="중소기업기술개발사업종합괸리시스템" target="_blank" rel="noopener noreferrer"><img src="images/main/ban_link04.png" alt="중소기업기술개발사업종합괸리시스템"></a>
							<a href="http://webzine.tipa.or.kr/tipa/" title="중소기업기술정보진흥원웹진" target="_blank" rel="noopener noreferrer"><img src="images/main/ban_link07.png" alt="중소기업기술정보진흥원웹진"></a>
							<a href="http://www.nst.re.kr/nst/index.jsp" title="국가과학기술연구회" target="_blank" rel="noopener noreferrer"><img src="images/main/ban_link03.png" alt="국가과학기술연구회"></a>
						</div>  
					</div>
				</div>
				<!--//company banner End-->
				
			</div>
			<!--//conbox End -->
			
		</div>
		<!--// Content End-->

	</div>
	<!--// Container End-->
	
	
    <!--Footer Start-->
	<div id="footer">
		<div class="footerBox">
			<div class="conFBox">
				<ul class="conLtxt">
					<li class="mb15">
						<!-- <a href="<c:url value="/com/if/perPolicy.do" />" title="개인정보처리방침" class="privacy" >개인정보처리방침</a> -->
						<a href="<c:url value="https://www.smtech.go.kr/front/etc/care.do" />" title="개인정보처리방침" class="privacy" >개인정보처리방침</a>
						<a href="<c:url value="/com/if/emailPolicy.do" />" title="이메일무단수집거부">이메일무단수집거부</a>
						<a href="<c:url value="/com/cn/location.do" />" title="찾아오시는 길">찾아오시는 길</a>
					</li>
					<li>(세종 센터) 30141 세종특별자치시 집현중앙로 79, 중소기업기술정보진흥원(TIPA) 1층 중소기업기술혁신센터<span>TEL 044-390-0634</span></li>
					<li>(판교 센터) 13487 경기도 성남시 분당구 대왕판교로 645번길 12, 3층 중소기업기술혁신센터<span style="margin-left:103px;">TEL 031-739-6900</span></li>
					<li class="liLine2">COPYRIGHT (c) 2015.TIPA. ALL RIGHT RESERVED.</li>
				</ul>
				<ul class="conRtxt">
					<li>
						<select class="secBox" name="select" onchange="window.open(value,'_blank');">
							<option selected>Family Site</option>
							<option value="http://www.tipa.or.kr">중소기업기술정보진흥원</option>
							<option value="http://www.mss.go.kr/site/smba/main.do">중소벤처기업부</option>
							<option value="http://www.nst.re.kr/nst/index.jsp">국가과학기술연구회</option>
							<option value="http://www.smtech.go.kr">중소기업기술개발사업종합관리시스템</option>
							<!-- <option value="http://www.kipa.org/kipa/index.jsp">한국발명진흥회</option> -->
						</select>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!--//Footer End-->

</div>
</body>
</html>
