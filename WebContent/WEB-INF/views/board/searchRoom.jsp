<%@page import="board.model.vo.BoardForList"%>
<%@page import="board.model.vo.RoomBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	//List<Room> list = (List<Room>)request.getAttribute("list");
	List<RoomBoard> list = (List<RoomBoard>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int cnt = (int)request.getAttribute("totalContents");
	String location = (String)request.getAttribute("location");
%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css" />
     <div class="lookinRoomView">
     	<section id="option-tab">
     		<form action="<%= request.getContextPath() %>/board/searchRoom" >
	            <select name="room_val" class="selectOption" >
	                <option value="OO">오픈형 원룸</option> 
	                <option value="SO">분리형 원룸</option>
	                <option value="OT">오픈형 투룸</option>
	                <option value="ST">분리형 투룸</option>
	            </select>
	
	            <select name="tax_val" class="selectOption" >
	                <option value="M" >월세</option>
	                <option value="Y" >전세</option>
	            </select>
	
	            <select name="price" class="selectOption" >
	                <option value="45" >월 ~ 45</option>
	                <option value="100" >45 ~ 100</option>
	            </select>
	
	            <select name="fee" class="selectOption" >
	                <option value="5" >관리비 ~5만</option>
	                <option value="10" >5~10만 </option>
	                <option value="20" >10~20만</option>
	            </select>
	            <select name="option" class="selectOption" >
	                <option value="oneRoom" >추가옵션</option>
	                <option value="twoRoom" >세탁기</option>
	                <option value="threeRoom" >냉장고</option>
	            </select>
     			<input type="submit" class="room-searchBtn" value="검색">
     		</form>
     	</section>
     		<form action="<%= request.getContextPath() %>/board/searchLocationRoom" id="map-searchFrm" >
	            <!-- <input type="text" name="localSearch" id="localSearch" placeholder="지역별 검색" > -->
	            <button type="submit" class="room-searchBtn">검색</button>
     		</form>
     	<section class="RoomInsert">
     		<button class="roomUpdateBtn" >방 올리기</button>
     	</section>
     </div>  
	
	
		<div id="roomViewCon1">
            
	 <% 
	 if(list == null || list.isEmpty()){ %>           
      <%--    	조회된 행이 없는 경우
				<div>조회된 행이 없습니다.</div>
		<% 
			} 
		   	else {
				for(RoomBoard b : list){
		%>  
		조회된 행이 있는 경우 
            
               <div>
		                <% if(b.getOk().equals("T")){ %>
		                	
			            	<a href="<%= request.getContextPath() %>/board/boardView?board_num=<%= b.getBoard_num() %>&br=<%= b.getBr_cp_id() %>" >
			                	<img src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName() %>">
			            	</a>
		            	<% } else{ %>
		            	
		            	<input <%= memberLoggedIn.getMemberRole().equals("A") ? "type='button'" : "type='hidden'" %>  class="okBtn" value="<%= b.getBoard_num() %>" style="z-index:10;cursor:pointer; width:400px; height:280px;background-color:rgba(0,0,0,0.1); border: none;color:rgba(0,0,0,0);position: absolute;margin: 0;"/>
			                	<img src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName() %>" <%= memberLoggedIn.getMemberRole().equals("A") ? "" : "onclick='alret();'" %> style="filter: brightness(50%); cursor: pointer;">
		            	
		            	<% } %> 
		            <br>
		            <input type="text" value="등록날짜  <%= b.getEnrolldate() %>"> <br />
		             	<%= b.getBoard_title() %>
		        </div>
		         <% 		}
				
					} 
				%>  
				
		<div id='pageBar'>
			<%= pageBar %>
		</div> --%>
		
		<div>조회된 행이 없습니다.</div>
	<% 
			} 
		   	else {
				for(RoomBoard b : list){
		%>

	<div>
		<% if(b.getOk().equals("T")){ %>

		<a
			href="<%= request.getContextPath() %>/board/boardView?board_num=<%= b.getBoard_num() %>&br=<%= b.getBr_cp_id() %>">
			<img
			src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName() %>"
			onerror="this.src='<%= request.getContextPath() %>/images/roomImg01.jpg'">
		</a>
		<% } else{ %>
		<input
			<%= memberLoggedIn.getMemberRole().equals("A") ? "type='button'" : "type='hidden'" %>
			class="okBtn" value="<%= b.getBoard_num() %>"
			style="z-index: 10; cursor: pointer; width: 400px; height: 280px; background-color: rgba(0, 0, 0, 0.1); border: none; color: rgba(0, 0, 0, 0); position: absolute; margin: 0;" />
		<img
			src="<%=request.getContextPath()%>/upload/board/<%=b.getRenameName() %>"
			onerror="this.src='<%= request.getContextPath() %>/images/roomImg01.jpg'"
			<%= memberLoggedIn.getMemberRole().equals("A") ? "" : "onclick='alret();'" %>
			style="filter: brightness(50%); cursor: pointer;">

		<% } %>
		<br> <input type="text" value="등록날짜  <%= b.getEnrolldate() %>">
		<br />
		<%= b.getBoard_title() %>
	</div>
	<% 		}
				
					} 
				%>
	<div id='pageBar'>
		<%= pageBar %>
	</div>
		
		
	</div>
	<div id="roomViewCon2">
		<div id="map" style="width:100%;height:800px;" ></div>
	</div>
    
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4120f12d95cc4f5578582277470d4fc9&libraries=services,clusterer,drawing""></script>
<script>
//방올리기
$(document).ready(function(){
    
    $(".roomUpdateBtn").click(function(){
    	alert("방을 올리시려면 중개인에게 연락해주세요!");
    });
});
function alret(){
    alert("비공개 게시글입니다.");
}
$(document).ready(function(){
    $(".okBtn").click(function(){
	if(!confirm("게시물을 공개처리 하시겠습니까?")) return;
		$.ajax({
			url: "<%= request.getContextPath() %>/admin/moveOk",
			method: "POST", 
			dataType: "text", //html, text, json, xml 리턴된 데이터에 따라 자동설정됨
			data:  {"board_num": $(".okBtn").val()}, //사용자 입력값전달
			success: function(data){
				//요청성공시 호출되는 함수
				console.log(data);
				//$(".result-container").html(data);
				location.href="<%=request.getContextPath()%>/board/lookingRoom";
				history.go(0);
			},
			error: function(xhr, textStatus, errorThrown){
				console.log("ajax 요청 실패!");
				console.log(xhr, textStatus, errorThrown);
			}
		});
    });
});
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch('<%= location %>', function(result, status) {

// 정상적으로 검색이 완료됐으면 
 if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: coords
    });

    // 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
} 
}); 

</script>



