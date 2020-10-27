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


<div id="roomViewCon2">
	<div id="map" style="width: 500px; height: 400px;"></div>
</div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4120f12d95cc4f5578582277470d4fc9&libraries=services,clusterer,drawing""></script>
<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);


//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch('<%=location%>
	', function(result, status) {

		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map : map,
				position : coords
			});

			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	});
</script>



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
		<%=pageBar%>
	</div>



</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>