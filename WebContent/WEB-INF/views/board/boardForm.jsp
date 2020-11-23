<%@page import="board.model.vo.BoardLike"%>
<%@page import="board.model.vo.RoomBoard"%>
<%@page import="board.model.vo.Room"%>
<%@page import="board.model.vo.RoomImage"%>
<%@page import="board.model.vo.RoomReview"%>
<%@page import="member.model.service.MemberService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	Room room = (Room)request.getAttribute("room");
	RoomBoard roomBoard = (RoomBoard)request.getAttribute("roomBoard");
	RoomReview roomReview = (RoomReview)request.getAttribute("roomReview");
	Broker br = (Broker)request.getAttribute("broker");
	List<RoomImage> imgList = (List<RoomImage>)request.getAttribute("imgList");
	List<RoomReview> reviewList = (List<RoomReview>)request.getAttribute("reviewList");
	boolean like = (boolean)request.getAttribute("like");
%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css" />


	<div>
		<section class="roomDetail-info">
			<div id="roomDetailView1">
				<%= room.getRoom_val().contains("T")?"투룸":"원룸" %><br />
				<span id="roomDetailTxt1"><%= room.getTax_val().equals("M")?"월세":"전세" %> <%= room.getPrice() %></span>만원
			</div>
			<div id="roomDetailView2">
				전용면적<br />
				<span id="roomDetailTxt2"><%= room.getSize() %></span>평
			</div>
			<div id="roomDetailView3">
				관리비<br />
				<span id="roomDetailTxt1"><%= room.getTax_val().equals("M")?"월세":"전세" %> <%= room.getPrice() %></span>만원
			</div>
			<div id="roomDetailView4">
				<p><%= br.getBr_cp_name() %></p>
				<p><%= br.getBr_name() %></p>
			</div>
			<div id="roomDetailView5">
				<button class="brokerPhoneBtn" onclick="brokerPhone();" >연락처 보기</button>
			</div>
			
		<!-- 중개인 연결 팝업  -->
		 <div id="connectBack"></div> 
		 <div id="connectWrap">
	                <div class="button-wrap">
	                    <h1>연락처 보기</h1>
	                </div>
	                <input type="button" class="closeShowBrokerBtn" value="x" onclick="brokerCloseBtn();">
	                
	                <div style="padding:0 0 30px 40px;margin-bottom:30px;border-bottom: 1px solid rgb(235, 235, 235);">
		                <p  style="font-size:18px; font-weight: 800;"><%= br.getBr_cp_name() %></p>
		                <p>주소</p>
		                <br />
		                <p>담당자 : <%= br.getBr_name() %></p>
		                <p>연락처 : <%= br.getPhone() %></p>
	                </div>
	                <div>
	                <div class="profileImg">
		                <img id="profileImg" src="<%= request.getContextPath() %>/upload/member/<%= br.getProfile() %>" onerror="this.src='<%= request.getContextPath() %>/upload/member/user.png'" alt="profile">
               			<p><%= br.getBr_name() %>(중개 보조원)</p>
		                <p>보증보험 : <%= br.getInsurance().equals("T")?"유":"무" %></p>
	                </div>
	                </div>
	        </div> 
		</section>
	</div>
	
	<!-- 좋아요 -->
	<form name="likeFrm" action="<%= request.getContextPath()%>/board/boardView" method="POST">
		<input type="hidden" id="likeMemId" name="memberId" value="<%= memberLoggedIn.getMemberId() %>" />
		<input type="hidden" id="likeBrId" name="br_cp_id" value="<%= roomBoard.getBr_cp_id() %>" />
		<input type="hidden" id="likeBoardNum" name="board_num" value="<%= room.getBoard_num() %>" />
		<input type="hidden" id="alsjdhakjsdbaskjbd"  name="roomLocation" value="<%= room.getLocation()%>" />
	</form>

	<div id="roomDetail-LikeAlarm">
		<img src=<%= like ? "../images/colorHeart.png" : "../images/heart.png" %> id="likeBtn" alt="" />좋아요 
		<img src="<%=request.getContextPath()%>/images/alert.png" onclick="roomReportBtn();" alt="" />허위매물 신고
	</div>
	
	  <!-- 본인 인증 팝업 -->   
	    <div id="certificationWrap"></div> 
	        <div id="certification">
	            <div class="certification-frmWrap">
	                    
	                <input type="button" class="closeBtn" value="x" onclick="roomReportcloseBtn();">
	                
	                <form action="<%= request.getContextPath() %>/board/report" id="cerFrm" method="POST" class="input-group">
		                <h3>허위매물 신고</h3>

		                <div class="social-icons">
		                    <img src="<%= request.getContextPath() %>/images/alert.png" alt="alarm">
		                </div>   
		                <p class="FakeForSaleParagraph">허위매물을 신고해주세요!</p>
		                <p>허위매물 여부를 판정하여 목록에서 삭제등의 조치가 진행됩니다.</p>
		                
		                <p class="CheckYourIdentity">본인인증을 진행해주세요.</p>
		                <p>허위매물 신고는 본인인증 후 작성하실 수 있습니다.</p>
		                <p id="cerTitle">이메일 인증</p>
		                <input type="hidden" name="br_cp_id" id="cerHidden" value="<%= br.getBr_cp_id() %>" />
		                <input type="hidden" name="board_num" id="cerHidden2" value="<%= roomBoard.getBoard_num() %>" />
		                <input type="email" id="cerEmail" name="cerEmail" class="cer-field" placeholder="abc@naver.com" required>
	                    <input type="button" class="sendMail" value="전송" />
	                    <br />
	                    <input type="text" id="cerNumber" name="cerNumber" class="cer-field" placeholder="인증번호를 입력해주세요" required>
	                    <input type="submit" class="submit" id="cerSubmit" value="인증" />
	                </form>
	            </div>
	        </div> 
	
   	<div class="roomDetail-info3">	
   		<section id="detail-infoTitle">
   			<p class="detail-info1"><%= roomBoard.getOk().equals("F")?"비 확인 매물":"확인 매물" %> <%= roomBoard.getEnrolldate() %></p>
   			<p><%= roomBoard.getOk().equals("F")?"관리자의 매매등록 승인처리가 필요합니다":"확인된 매물입니다" %></p>
   		</section>
   		<ul id="detail-list">
   			<li>
   				<p>해당층/건물층</p>
   				<div><%=room.getFloor() %></div>
   			</li>
   			<li>
   				<p>전용/공급면적</p>
   				<div><%= room.getSize() %>평</div>
   			</li>
   			<li>
   				<p>난방종류</p>
   				<div>개별난방</div>
   			</li>
   			<li>
   				<p>빌트인</p>
   				<div>빌트인/주방</div>
   			</li>
   			<li>
   				<p>엘리베이터</p>
   				<div>없음</div>
   			</li>
   			<li>
   				<p>반려동물</p>
   				<div>가능</div>
   			</li>
   			<li>
   				<p>베란다/발코니</p>
   				<div>있음</div>
   			</li>
   			<li>
   				<p>전세자금대출</p>
   				<div>불가능</div>
   			</li>
   			<li>
   				<p>냉장고</p>
   				<div>있음</div>
   			</li>
   			<li>
   				<p>세탁기</p>
   				<div>있음</div>
   			</li>
   			<li>
   				<p>에어컨</p>
   				<div>있음</div>
   			</li>
   			<li>
   				<p>기타</p>
   				<div></div>
   			</li>
   		</ul>
   	</div>
	<div class="roomDetail-info4">
		<div id="roomImg-number"><p name="roomnum">매물번호 : <%= room.getRoom_num() %></p></div>
   <%
   	if(imgList != null){ 
   		for(RoomImage ri : imgList){ %>
		<div>
   			<img class="roomDetailImg01" src="<%=request.getContextPath()%>/upload/board/<%=ri.getRenameName()%>" alt="" onerror="this.src='<%= request.getContextPath() %>/images/roomImg01.jpg'" />
		</div>
   			
   <%		}
   	}
   
   %>
    </div>
	<div class="roomDetail-info5">
		<p><%= roomBoard.getBoard_title() %> </p>
		<div id="roomDetail-info5-content">
			<%= roomBoard.getContent() %>
		</div>
	</div>
	<hr />
	<div class="roomDetail-info6">
		<p class="map-title">위치 및 주변시설</p>
		<input type="text" id="roomLocation" value="<%=room.getLocation() %>" readonly/>
		<div id="roomMap" style="width:800px;height:500px;"></div>
	</div>
	
	<div class="roomReview">
		<p class="review-title">후기</p>
		<form name="reviewform" class="reviewform" method="post" action="<%= request.getContextPath() %>/board/insertreview">
	        <input type="hidden" name="rate" id="rate" value="0"/>
	        <input type="hidden" id="revBrId" name="boardno" value="<%= roomBoard.getBoard_num() %>" />
			<input type="hidden" id="revBrcpId" name="br_cp_id" value="<%= roomBoard.getBr_cp_id() %>" />
	        <input type="hidden" id="revMemId" name="memberId" value="<%= memberLoggedIn.getMemberId() %>" />
			<input type="hidden" id="revRoomNum" name="roomnum" value="<%= room.getRoom_num() %>" />
			
	        <p class="title_star">별점과 리뷰를 남겨주세요.</p>
	 
	        <div class="review_rating">
	            <div class="warning_msg">별점을 선택해 주세요.</div>
	            <div class="rating">
	                <!-- 해당 별점을 클릭하면 해당 별과 그 왼쪽의 모든 별의 체크박스에 checked 적용 -->
	                <input type="checkbox" name="rating" id="rating1" value="1" class="rate_radio" title="1점">
	                <label for="rating1"></label>
	                <input type="checkbox" name="rating" id="rating2" value="2" class="rate_radio" title="2점">
	                <label for="rating2"></label>
	                <input type="checkbox" name="rating" id="rating3" value="3" class="rate_radio" title="3점" >
	                <label for="rating3"></label>
	                <input type="checkbox" name="rating" id="rating4" value="4" class="rate_radio" title="4점">
	                <label for="rating4"></label>
	                <input type="checkbox" name="rating" id="rating5" value="5" class="rate_radio" title="5점">
	                <label for="rating5"></label>
	            </div>
	        </div>
	        <div class="review_contents">
	            <div class="warning_msg">두 글자 이상 작성해 주세요.</div>
	            <textarea rows="10" name="reviewcontent" placeholder="두 글자 이상 작성해 주세요." class="review_textarea"></textarea>
	        </div>   
	        <div class="cmd">
	            <input type="button"  name="save" id="save" value="등록"> <!-- onclick="reviewBtn()" -->
	        </div>
   		 </form>
	</div>
	
	<!--  리뷰 조회&삭제 -------------------------------------------------------------------------- -->
	<table id="tbl-review">
		<% 
			if(reviewList != null && !reviewList.isEmpty())
			{ 
				for (RoomReview rr : reviewList)
				{
		%>				
				<tr class="review">
					<td class="reviewMemProfileIdDate">
						<sub class="coveredMemberProfileWriterDate">
						<sub class="review-memberProfile"> <img class="reviewMemberProfileImg" src="<%=request.getContextPath()%>/images/user.png"></sub>
						<sub class="review-writer" name="userId"> <%= rr.getUserId() %></sub> 
						<sub class="review-date" name="reviewenrolldate"> <%= rr.getEnrolldate() %></sub>
						</sub>
						<br /> 
					</td>
					
					<td class="reviewContentAndDelete">
						<sub class="review-rating">
							<script>
								function showRating()
								{
									<%switch(rr.getRating())
									{
										case 1: %>document.write("★☆☆☆☆"); <%break;
										case 2: %>document.write("★★☆☆☆"); <%break;
										case 3: %>document.write("★★★☆☆"); <%break;
										case 4: %>document.write("★★★★☆"); <%break;
										case 5: %>document.write("★★★★★"); <%break;
									}%>
								}
								showRating();
							</script>
						</sub>
						<sub class="ReviewMainContent">
						<div id="myDiv" style="display:inline"><%= rr.getReviewContent() %></div>
						<textarea id="myTextarea" cols=50 rows=1 style="visibility:hidden"></textarea>
									<%if(memberLoggedIn != null && (rr.getUserId().equals(memberLoggedIn.getMemberId()) || memberLoggedIn.getMemberRole().equals(MemberService.MEMBER_ROLE_ADMIN)))
									{ %>
																		
									<form class="reviewupdate" action = "<%= request.getContextPath()%>/board/reviewupdate" method = "POST" name="reviewupdate">
									<button class="Reviewbtn-update" value="<%= rr.getReviewId() %>" onclick = "reviewupdate();" class="update">수정</button>
									<input type="hidden" name="reviewno" value=<%=rr.getReviewId() %> />
									<input type="hidden" id="revBrId" name="boardno" value="<%= roomBoard.getBoard_num() %>" />
									<input type="hidden" id="revBrcpId" name="br_cp_id" value="<%= roomBoard.getBr_cp_id() %>" />
								    <input type="hidden" id="revMemId" name="memberId" value="<%= memberLoggedIn.getMemberId() %>" />
									<input type="hidden" id="revRoomNum" name="roomno" value="<%= room.getRoom_num() %>" />
									<input type="hidden" id="revRating" name="rating" value="<%= rr.getRating() %>" />
									</form>
									 
									<form class="reviewdelete" action = "<%= request.getContextPath()%>/board/reviewdelete" method = "POST" name="reviewdelete"> 
									<button class="Reviewbtn-delete" value="<%= roomBoard.getBoard_num() %>" onclick = "reviewdelete();" class="delete">삭제</button>
									<input type="hidden" name="reviewno" value=<%=rr.getReviewId() %> />
									<input type="hidden" id="revBrId" name="boardno" value="<%= roomBoard.getBoard_num() %>" />
									<input type="hidden" id="revBrcpId" name="br_cp_id" value="<%= roomBoard.getBr_cp_id() %>" />
								    <input type="hidden" id="revMemId" name="memberId" value="<%= memberLoggedIn.getMemberId() %>" />
									<input type="hidden" id="revRoomNum" name="roomno" value="<%= room.getRoom_num() %>" />
									</form>
									<% } %>
						</sub>
					</td>
					
				</tr>
		<% 
				}
			} 
		%>
	</table>
	
	<!--  리뷰 조회&삭제 끝 -------------------------------------------------------------------------- -->
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f812560fa3200866e643713203eb962f&libraries=services"></script>	
<script>

function reviewupdate() {
    function cmUpdateOpen(comment_num){
        window.name = "parentForm";
        window.open("CommentUpdateFormAction.co?num="+reviewno,
                    "updateForm", "width=570, height=350, resizable = no, scrollbars = no");
    }
}

function reviewdelete() {
	reviewdelete.submit();
}

//별점 마킹 모듈 프로토타입으로 생성
function Rating(){};
Rating.prototype.rate = 0;
Rating.prototype.setRate = function(newrate){
    //별점 마킹 - 클릭한 별 이하 모든 별 체크 처리
    this.rate = newrate;
    let items = document.querySelectorAll('.rate_radio');
    items.forEach(function(item, idx){
        if(idx < newrate){
            item.checked = true;
        }else{
            item.checked = false;
        }
    });
}
let rating = new Rating();//별점 인스턴스 생성 

document.addEventListener('DOMContentLoaded', function(){
    //별점선택 이벤트 리스너
    document.querySelector('.rating').addEventListener('click',function(e){
        let elem = e.target;
        if(elem.classList.contains('rate_radio')){
            rating.setRate(parseInt(elem.value));
        }
    })
});

//리뷰 작성 글자수 초과 체크 이벤트 리스너
document.querySelector('.review_textarea').addEventListener('keydown',function(){
    //리뷰 500자 초과 안되게 자동 자름
    let review = document.querySelector('.review_textarea');
    let lengthCheckEx = /^.{500,}$/;
    if(lengthCheckEx.test(review.value)){
        //500자 초과 컷
        review.value = review.value.substr(0,500);
    }
});

//저장 전송전 필드 체크 이벤트 리스너
document.querySelector('#save').addEventListener('click', function(e){
    //별점 선택 안했으면 메시지 표시
    if(rating.rate == 0){
        rating.showMessage('rate');
        return false;
    }
    //리뷰 2자 미만이면 메시지 표시
    if(document.querySelector('.review_textarea').value.length < 2){
        rating.showMessage('review');
        return false;
    }
    //폼 서밋
    reviewform.submit();
});

Rating.prototype.showMessage = function(type){//경고메시지 표시
switch(type){
    case 'rate':
        //안내메시지 표시
        document.querySelector('.review_rating .warning_msg').style.display = 'block';
        //지정된 시간 후 안내 메시지 감춤
        setTimeout(function(){
            document.querySelector('.review_rating .warning_msg').style.display = 'none';
        },1000);            
        break;
    case 'review':
        //안내메시지 표시
        document.querySelector('.review_contents .warning_msg').style.display = 'block';
        //지정된 시간 후 안내 메시지 감춤
        setTimeout(function(){
            document.querySelector('.review_contents .warning_msg').style.display = 'none';
        },1000);    
        break;
}
}
//메일발송
$(document).ready(function(){
    $(".sendMail").click(function(){
	if($("#cerEmail").val()==null) alert("메일주소를 입력해주세요");
		$.ajax({
			url: "<%= request.getContextPath() %>/board/sendMail",
			method: "POST", 
			dataType: "text", //html, text, json, xml 리턴된 데이터에 따라 자동설정됨
			data:  {"email": $("#cerEmail").val()}, //사용자 입력값전달
			success: function(data){
				alert("인증번호가 전송되었습니다! 30초 안에 인증을 완료해 주세요!!!")
			},
			error: function(xhr, textStatus, errorThrown){
				alert("메일주소가 일치하지 않습니다.")
				console.log("ajax 요청 실패!");
				console.log(xhr, textStatus, errorThrown);
			}
		});
    });
});
//신고
$(document).ready(function(){
    $("#cerSubmit").click(function(){
	if($("#cerNumber").val()==null) alert("메일주소를 입력해주세요");
		$.ajax({
			url: "<%= request.getContextPath() %>/board/report",
			method: "POST", 
			dataType: "text", //html, text, json, xml 리턴된 데이터에 따라 자동설정됨
			data:  {"cerNumber": $("#cerNumber").val(),
					"br_cp_id" : $("#cerHidden").val(),
					"board_num" : $("#cerHidden2").val()
				}, //사용자 입력값전달
			success: function(data){
				
			},
			error: function(xhr, textStatus, errorThrown){
				alert("인증번호가 일치하지 않습니다.")
				console.log("ajax 요청 실패!");
				console.log(xhr, textStatus, errorThrown);
			}
		});
    });
});
//like
$(document).ready(function(){
    $("#likeBtn").click(function(){
		$.ajax({
			url: "<%= request.getContextPath() %>/board/boardView",
			method: "POST", 
			dataType: "text", //html, text, json, xml 리턴된 데이터에 따라 자동설정됨
			data:  {"memberId": $("#likeMemId").val(),
					"board_num" : $("#likeBoardNum").val(),
					"br_cp_id" : $("#likeBoardNum").val()
				}, //사용자 입력값전달
			success: function(data){
				history.go(0);
			},
			error: function(xhr, textStatus, errorThrown){
				alert("인증번호가 일치하지 않습니다.")
				console.log("ajax 요청 실패!");
				console.log(xhr, textStatus, errorThrown);
			}
		});
    });
});

var mapContainer = document.getElementById('roomMap'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch('<%=room.getLocation() %>', function(result, status) {

// 정상적으로 검색이 완료됐으면 
 if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: coords
    });


    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
} 
});  

function brokerPhone() {
	connectWrap.style.display = "block";
	connectBack.style.display = "block";
}
function brokerCloseBtn() {
	connectWrap.style.display = "none";
	connectBack.style.display = "none";
}
function roomReportBtn() {
	certification.style.display = "block";
	certificationWrap.style.display = "block";
}
function roomReportcloseBtn() {
	certification.style.display = "none";
	certificationWrap.style.display = "none";
}

</script>