<%@page import="board.model.vo.BoardForList"%>
<%@page import="board.model.vo.RoomBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/brokerHeader.jsp"%>
<%
	List<RoomBoard> list = (List<RoomBoard>) request.getAttribute("list");
String pageBar = (String) request.getAttribute("pageBar");
int cnt = (int) request.getAttribute("totalContents");
String location = (String) request.getAttribute("location");
%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/board.css" />
<script>

//방올리기
$(document).ready(function(){
    
    $(".roomUpdateBtn").click(function(){
    	location.href='<%=request.getContextPath()%>/brokerBoard/insertBoard'
    });
});
</script>
<div class="nav-bar">
	<a href="<%=request.getContextPath()%>/board/lookingRoom"
		class="RoomSearch-nav">매물 검색</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div class="lookinRoomView">
	<section id="option-tab" style="display: inline;">
		<form action="<%=request.getContextPath()%>/brokerBoard/searchRoom"
			style="display: inline">
			<select name="room_val" class="selectOption">
				<option value="OO">오픈형 원룸</option>
				<option value="SO">분리형 원룸</option>
				<option value="OT">오픈형 투룸</option>
				<option value="ST">분리형 투룸</option>
			</select> <select name="tax_val" class="selectOption">
				<option value="M">월세</option>
				<option value="Y">전세</option>
			</select> <select name="price" class="selectOption">
				<option value="45">월 ~ 45</option>
				<option value="100">45 ~ 100</option>
			</select> <select name="fee" class="selectOption">
				<option value="5">관리비 ~5만</option>
				<option value="10">5~10만</option>
				<option value="20">10~20만</option>
			</select> <select name="option" class="selectOption">
				<option value="oneRoom">추가옵션</option>
				<option value="twoRoom">세탁기</option>
				<option value="threeRoom">냉장고</option>
			</select> <input type="submit" class="room-searchBtn" value="검색">
		</form>
	</section>
	<form id="map-searchFrm"
		action="<%=request.getContextPath()%>/brokerBoard/searchLocationRoom"
		onsubmit="return searchPlaces();">
		<input type="text" name="localSearch" id="localSearch"
			placeholder="지역별 검색">
		<button type="submit" class="room-searchBtn">검색</button>
	</form>
	<section class="RoomInsert">
		<button class="roomUpdateBtn">방 올리기</button>
	</section>
</div>


<div id="roomViewCon1">
	<h2>
		전체 게시글 :
		<%=cnt%>개
	</h2>
	<%
		if (list == null || list.isEmpty()) {
	%>
	<%--조회된 행이 없는 경우 --%>
	<div>조회된 행이 없습니다.</div>
	<%
		} else {
	for (RoomBoard b : list) {
	%>
	<%--조회된 행이 있는 경우 --%>

	<div>
		<a
			href="<%=request.getContextPath()%>/brokerBoard/boardView?board_num=<%=b.getBoard_num()%>&br=<%=b.getBr_cp_id()%>">
			<%
				if (b.getOk().equals("T")) {
			%> <img
			src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName()%>"
			onerror="this.src='<%=request.getContextPath()%>/images/roomImg01.jpg'">
			<%
				} else {
			%> <img
			src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName()%>"
			onerror="this.src='<%=request.getContextPath()%>/images/roomImg01.jpg'"
			style="filter: brightness(50%);"> <%
 	}
 %>
		</a> <br> <input type="text" value="등록날짜  <%=b.getEnrolldate()%>">
		<br />
		<%=b.getBoard_title()%>
	</div>
	<%
		}

	}
	%>
	<div id='pageBar'>
		<%= pageBar %>
	</div>


</div>

<div id="roomViewCon2">
		<div id="map" style="width:100%;height:40em;" ></div>
</div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4120f12d95cc4f5578582277470d4fc9&libraries=services,clusterer,drawing""></script>

<script>
//마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

// 키워드로 장소를 검색합니다
ps.keywordSearch('<%=location%>', placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            //displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

/* // 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
} */
</script>

</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>