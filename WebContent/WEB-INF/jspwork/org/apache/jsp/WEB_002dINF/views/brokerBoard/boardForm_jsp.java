/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-15 05:04:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.brokerBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.model.vo.RoomImage;
import board.model.vo.RoomBoard;
import board.model.vo.Room;
import java.util.List;
import broker.model.vo.Broker;

public final class boardForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/brokerHeader.jsp", Long.valueOf(1594781649006L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1594259972000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("board.model.vo.RoomImage");
    _jspx_imports_classes.add("board.model.vo.RoomBoard");
    _jspx_imports_classes.add("board.model.vo.Room");
    _jspx_imports_classes.add("broker.model.vo.Broker");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//session : 선언없이 사용할 수 있는 jsp내장객체
	Broker brokerLoggedIn = (Broker)session.getAttribute("brokerLoggedIn");


      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>DamoaBang</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" />\r\n");
      out.write("<script src=\"");
      out.print( request.getContextPath() );
      out.write("/js/jquery-3.5.1.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("//로그인\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#login\").submit(function(){\r\n");
      out.write("\t\tlet $loginId = $(\"#loginId\");\r\n");
      out.write("\t\tlet $loginPwd = $(\"#loginPwd\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($loginId.val().length == 0) {\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t\t$loginId.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($loginPwd.val().length == 0) {\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t\t$loginPwd.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//중복체크\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#userId\").blur(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet memberId = $(\"#userId\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"");
      out.print( request.getContextPath() );
      out.write("/member/checkIdDuplicate\",\r\n");
      out.write("\t\t\tmethod: \"GET\", \r\n");
      out.write("\t\t\tdata: {\"memberId\": memberId}, \r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\tif(data==\"notUsable\"){\r\n");
      out.write("\t\t\t\t\t// 아이디 중복 시 문구\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").text(\"ID in use\");\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").css(\"color\", \"red\");\r\n");
      out.write("\t\t\t\t\t$(\"#submit\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t\t}else if(memberId.length!=0&&data==\"usable\"){\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").text(\"Available ID\");\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").css(\"color\", \"blue\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, error : function() {\r\n");
      out.write("\t\t\t\t\tconsole.log(\"실패\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("//회원 가입\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#register\").submit(function(){\r\n");
      out.write("\t\t//아이디검사\r\n");
      out.write("\t\tlet $memberId = $(\"#userId\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!/^[\\w]{4,}$/.test($memberId.val())){\r\n");
      out.write("\t\t\talert(\"아이디가 유효하지 않습니다.\");\r\n");
      out.write("\t\t\t$memberId.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//아이디 중복검사 \r\n");
      out.write("\t\t/* let $isIdValid = $(\"#isIdValid\");\r\n");
      out.write("\t\tif($isIdValid.val() == 0){\r\n");
      out.write("\t\t\talert(\"아이디 중복검사 해주세요.\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//비밀번호 검사\r\n");
      out.write("\t\tlet $pwd1 = $(\"#userPwd\");\r\n");
      out.write("\t\tlet $pwd2 = $(\"#userPwdChk\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($pwd1.val() !== $pwd2.val()){\r\n");
      out.write("\t\t\talert(\"비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("\t\t\t$pwd1.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("//마이페이지 연결 리스트(토글버튼처럼 구현)\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("    \r\n");
      out.write("    $(\".nav-user-link\").click(function(){\r\n");
      out.write("    \t if ( $(\".profile__list\").css(\"display\") == \"none\" )\r\n");
      out.write("    \t\t   $(\".profile__list\").show();\r\n");
      out.write("    \t\t  else\r\n");
      out.write("    \t\t   $(\".profile__list\").hide();\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\".filter-select__type\").click(function(){\r\n");
      out.write("   \t if ( $(\".filter-select__typelist\").css(\"display\") == \"none\" )\r\n");
      out.write("   \t\t   $(\".filter-select__typelist\").show();\r\n");
      out.write("   \t\t  else\r\n");
      out.write("   \t\t   $(\".filter-select__typelist\").hide();\r\n");
      out.write("   });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<!-- 헤더 -->\r\n");
      out.write("\t\t<header class=\"navbar navbar-expand\" id=\"mainNav\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("\" class=\"navbar-brand\">다모아방</a>\r\n");
      out.write("\t\t\t\t<div class=\"navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"navbar-nav\">\r\n");
      out.write("\t\t\t\t\t\t");
 if(brokerLoggedIn == null) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/community/communityView\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/brokerBoard/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" onclick=\"signupbtn()\">중개인로그인</a></li>\r\n");
      out.write("\t\t\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item-community\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/community/communityView\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item-room\"><a href=\"");
      out.print(request.getContextPath() );
      out.write("/brokerBoard/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-user-link\"><img style=\"background-color: rgb(0, 255, 0); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"profile__list\">\r\n");
      out.write("\t\t\t                  <li class=\"login-profile\" id=\"login-profile-img\" ><img style=\"background-color: rgb(0, 255, 0); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></li>\r\n");
      out.write("\t\t\t                  <li class=\"login-profile\">");
      out.print( brokerLoggedIn.getBr_name() );
      out.write("</li>\r\n");
      out.write("\t\t\t                  <li class=\"login-profile\" id=\"login-profile-email\">");
      out.print( brokerLoggedIn.getEmail() );
      out.write("</li>\r\n");
      out.write("\t\t\t                  <li class=\"login-mypage\" id=\"login-mypage-info\" ><div onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/memberView?memberId=");
      out.print(brokerLoggedIn.getBr_name() );
      out.write("';\">내 정보 보기</div></li>\r\n");
      out.write("\t\t\t                  <li class=\"login-mypage\" id=\"login-mypage-logout\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/broker/logout'\">로그아웃</div></li> \r\n");
      out.write("\t\t\t              \t</ul>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<!-- 로그인 창 -->\r\n");
      out.write("\t\t<div id=\"signWrap\"></div> \r\n");
      out.write("\t        <div id=\"wrap\">\r\n");
      out.write("\t            <div class=\"form-wrap\">\r\n");
      out.write("\t                <div class=\"button-wrap\">\r\n");
      out.write("\t                    <div id=\"btn\"></div>\r\n");
      out.write("\t                    <button type=\"button\" id=\"loginBtn\" class=\"togglebtn\" onclick=\"login()\">로그인</button>\r\n");
      out.write("\t                    <button type=\"button\" id=\"registerBtn\" class=\"togglebtn\" onclick=\"register()\">회원가입</button>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t                <input type=\"button\" id=\"closeBtn\" value=\"x\" onclick=\"closeBtn();\">\r\n");
      out.write("\t                \r\n");
      out.write("\t                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/broker/login\" id=\"login\" method=\"post\" class=\"input-group\">\r\n");
      out.write("\t\t                <div class=\"social-icons\">\r\n");
      out.write("\t\t                    <img src=\"");
      out.print( request.getContextPath() );
      out.write("/images/naver.png\" alt=\"naver\">\r\n");
      out.write("\t\t                    <img src=\"");
      out.print( request.getContextPath() );
      out.write("/images/facebook.png\" alt=\"facebook\">\r\n");
      out.write("\t\t                    <img src=\"");
      out.print( request.getContextPath() );
      out.write("/images/google.png\" alt=\"google\">\r\n");
      out.write("\t\t                </div> \r\n");
      out.write("\t                    <input type=\"text\" id=\"br_cp_id\" name=\"br_cp_id\" class=\"input-field\" placeholder=\"등록번호를 입력해주세요\" required />\r\n");
      out.write("\t                    <input type=\"password\" id=\"br_loginPwd\" name=\"password\" class=\"input-field\" placeholder=\"비밀번호를 입력해주세요\" required>\r\n");
      out.write("\t                    <div id=\"chkWrap\">\r\n");
      out.write("\t\t                    <div class=\"userChk\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/#'\" >일반회원이세요?</div>\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                    <input type=\"submit\" class=\"submit\" value=\"로그인\" />\r\n");
      out.write("\t                    <a id=\"findLink\" href=\"");
      out.print( request.getContextPath() );
      out.write("/member/findMember\">아이디 찾기</a>\r\n");
      out.write("\t                </form>\r\n");
      out.write("\t                <form id=\"register\" action=\"");
      out.print( request.getContextPath() );
      out.write("/member/enroll\" method=\"post\" onsubmit=\"return resisterVal();\" class=\"input-group\">\r\n");
      out.write("\t                    <input type=\"text\" id=\"userId\" name=\"memberId\" class=\"input-field\" placeholder=\"User ID\" required>\r\n");
      out.write("\t                    <div id=\"id_check\"></div>\r\n");
      out.write("\t                    <input type=\"email\" id=\"userEmail\" name=\"email\" class=\"input-field\" placeholder=abc@xyz.com required>\r\n");
      out.write("\t                    <input type=\"password\" id=\"userPwd\" name=\"password\" class=\"input-field\" placeholder=\"Enter Password\" required>\r\n");
      out.write("\t                    <input type=\"password\" id=\"userPwdChk\" class=\"input-field\" placeholder=\"Enter Password Check\" required>\r\n");
      out.write("\t                    <input type=\"tel\" id=\"userPhone\" name=\"phone\" class=\"input-field\" placeholder=\"(-없이)01012345678\" maxlength=\"11\" required>\r\n");
      out.write("\t                    <button class=\"submit\">회원가입</button>\r\n");
      out.write("\t                    <a href=\"");
      out.print( request.getContextPath() );
      out.write("/broker/enroll\">중개인 회원가입</a>\r\n");
      out.write("\t                </form>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t//로그인 관련\r\n");
      out.write("\t\tlet x = document.getElementById(\"login\");\r\n");
      out.write("\t\tlet y = document.getElementById(\"register\");\r\n");
      out.write("\t\tlet z = document.getElementById(\"btn\");\r\n");
      out.write("\t\tlet loginbtn = document.getElementById(\"loginBtn\");\r\n");
      out.write("\t\tlet registerbtn = document.getElementById(\"registerBtn\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction login(){\r\n");
      out.write("\t\t    x.style.left = \"50px\";\r\n");
      out.write("\t\t    y.style.left = \"450px\";\r\n");
      out.write("\t\t    z.style.left = \"0\";\r\n");
      out.write("\t\t    loginbtn.style.color = \"white\";\r\n");
      out.write("\t\t    registerbtn.style.color = \"black\";\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction register(){\r\n");
      out.write("\t\t    x.style.left = \"-400px\";\r\n");
      out.write("\t\t    y.style.left = \"50px\";\r\n");
      out.write("\t\t    z.style.left = \"110px\";\r\n");
      out.write("\t\t    loginbtn.style.color = \"black\";\r\n");
      out.write("\t\t    registerbtn.style.color = \"white\";\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction signupbtn() {\r\n");
      out.write("\t\t    wrap.style.display = \"block\";\r\n");
      out.write("\t\t    signWrap.style.display = \"block\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction closeBtn() {\r\n");
      out.write("\t\t    wrap.style.display = \"none\";\r\n");
      out.write("\t\t    signWrap.style.display = \"none\";\r\n");
      out.write("\t\t    $(\"#register\").children().val('');\r\n");
      out.write("\t\t    $(\"#loginPwd\").val('');\r\n");
      out.write("\t\t    $(\"#id_check\").text(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>");
      out.write('\r');
      out.write('\n');

	Room room = (Room)request.getAttribute("room");
	RoomBoard roomBoard = (RoomBoard)request.getAttribute("roomBoard");
	Broker br = (Broker)request.getAttribute("broker");
	RoomImage ri = (RoomImage)request.getAttribute("rImage");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/board.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<section class=\"roomDetail-info\">\r\n");
      out.write("\t\t\t<div id=\"roomDetailView1\">\r\n");
      out.write("\t\t\t\t");
      out.print( room.getRoom_val().contains("T")?"투룸":"원룸" );
      out.write("<br />\r\n");
      out.write("\t\t\t\t<span id=\"roomDetailTxt1\">");
      out.print( room.getTax_val().equals("M")?"월세":"전세" );
      out.write(' ');
      out.print( room.getPrice() );
      out.write("</span>만원\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"roomDetailView2\">\r\n");
      out.write("\t\t\t\t전용면적<br />\r\n");
      out.write("\t\t\t\t<span id=\"roomDetailTxt2\">");
      out.print( room.getSize() );
      out.write("</span>평\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"roomDetailView3\">\r\n");
      out.write("\t\t\t\t관리비<br />\r\n");
      out.write("\t\t\t\t<span id=\"roomDetailTxt1\">");
      out.print( room.getTax_val().equals("M")?"월세":"전세" );
      out.write(' ');
      out.print( room.getPrice() );
      out.write("</span>만원\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"roomDetailView4\">\r\n");
      out.write("\t\t\t\t<p>");
      out.print( br.getBr_cp_name() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t<p>");
      out.print( br.getBr_name() );
      out.write("</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"roomDetailView5\">\r\n");
      out.write("\t\t\t\t<button class=\"brokerPhoneBtn\" onclick=\"brokerPhone();\" >연락처 보기</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<!-- 중개인 연결 팝업  -->\r\n");
      out.write("\t\t <div id=\"connectBack\"></div> \r\n");
      out.write("\t\t <div id=\"connectWrap\">\r\n");
      out.write("\t            <div class=\"form-wrap\">\r\n");
      out.write("\t                <div class=\"button-wrap\">\r\n");
      out.write("\t                    <h1>연락처 보기</h1>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t                <input type=\"button\" id=\"closeBtn\" value=\"x\" onclick=\"brokerCloseBtn();\">\r\n");
      out.write("\t                \r\n");
      out.write("\t                <div>\r\n");
      out.write("\t\t                <p>");
      out.print( br.getBr_cp_name() );
      out.write("</p>\r\n");
      out.write("\t\t                <p>주소</p>\r\n");
      out.write("\t\t                <br />\r\n");
      out.write("\t\t                <p>");
      out.print( br.getBr_name() );
      out.write("</p>\r\n");
      out.write("\t\t                <p>");
      out.print( br.getPhone() );
      out.write("</p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t                <div>\r\n");
      out.write("\t                <div class=\"profileImg\">사진\r\n");
      out.write("\t\t                <p>담당 : ");
      out.print( br.getBr_name() );
      out.write("(중개 보조원)</p>\r\n");
      out.write("\t\t                <p>보증보험 : ");
      out.print( br.getInsurance().equals("T")?"유":"무" );
      out.write("</p>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t                </div>\r\n");
      out.write("\t                \r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"roomDetail-info2\">\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/heart.png\" alt=\"\" />좋아요\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/alert.png\" onclick=\"roomReportBtn();\" alt=\"\" />허위매물 신고\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t  <!-- 본인 인증 팝업 -->   \r\n");
      out.write("\t    <div id=\"certificationWrap\"></div> \r\n");
      out.write("\t        <div id=\"certification\">\r\n");
      out.write("\t            <div class=\"certification-frmWrap\">\r\n");
      out.write("\t                    \r\n");
      out.write("\t                <input type=\"button\" id=\"closeBtn\" value=\"x\" onclick=\"roomReportcloseBtn();\">\r\n");
      out.write("\t                \r\n");
      out.write("\t                <form action=\"");
      out.print( request.getContextPath() );
      out.write("/member/login\" id=\"cerFrm\" method=\"post\" class=\"input-group\">\r\n");
      out.write("\t\t                <h3>허위매물 신고</h3>\r\n");
      out.write("\r\n");
      out.write("\t\t                <div class=\"social-icons\">\r\n");
      out.write("\t\t                    <img src=\"");
      out.print( request.getContextPath() );
      out.write("/images/google.png\" alt=\"google\">\r\n");
      out.write("\t\t                </div>   \r\n");
      out.write("\t\t                <p>허위매물을 신고해주세요!</p>\r\n");
      out.write("\t\t                <p>허위매물 신고를 접수해주시면, 허위매물 여부를 판정하여 목록에서 삭제등의 조치가 진행됩니다.</p>\r\n");
      out.write("\t\t                \r\n");
      out.write("\t\t                <p>본인인증을 진행해주세요.</p>\r\n");
      out.write("\t\t                <p>허위매물 신고는 본인인증 후 작성하실 수 있습니다.</p>\r\n");
      out.write("\t\t                <p id=\"cerTitle\">휴대폰 인증</p>\r\n");
      out.write("\t\t                <select name=\"agency\" id=\"cerSelect\" class=\"cer-field\">\r\n");
      out.write("\t\t                \t<option value=\"kt\">KT</option>\r\n");
      out.write("\t\t                \t<option value=\"skt\">SKT</option>\r\n");
      out.write("\t\t                \t<option value=\"lg\">LG u+</option>\r\n");
      out.write("\t\t                \t<option value=\"alttl\">알뜰통신사</option>\r\n");
      out.write("\t\t                </select>\r\n");
      out.write("\t\t                \r\n");
      out.write("\t\t                <input type=\"tel\" id=\"cerPhone\" name=\"cerPhone\" class=\"cer-field\" placeholder=\"(-없이)01012345678\" maxlength=\"11\" required>\r\n");
      out.write("\t                    \r\n");
      out.write("\t                    <br />\r\n");
      out.write("\t                    <input type=\"text\" id=\"cerNumber\" name=\"cerNumber\" class=\"cer-field\" placeholder=\"인증번호를 입력해주세요\" required>\r\n");
      out.write("\t                    <input type=\"submit\" class=\"submit\" value=\"인증\" />\r\n");
      out.write("\t                </form>\r\n");
      out.write("\t                \r\n");
      out.write("\t              \r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div> \r\n");
      out.write("\t\r\n");
      out.write("   \t<div class=\"roomDetail-info3\">\t\r\n");
      out.write("   \t\t<section id=\"detail-infoTitle\">\r\n");
      out.write("   \t\t\t<p class=\"detail-info1\">");
      out.print( roomBoard.getOk().equals("F")?"비 확인 매물":"확인 매물" );
      out.write(' ');
      out.print( roomBoard.getEnrolldate() );
      out.write("</p>\r\n");
      out.write("   \t\t\t<p>");
      out.print( roomBoard.getOk().equals("F")?"관리자의 매매등록 승인처리가 필요합니다":"확인된 매물입니다" );
      out.write("</p>\r\n");
      out.write("   \t\t</section>\r\n");
      out.write("   \t\t<ul id=\"detail-list\">\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>해당층/건물층</p>\r\n");
      out.write("   \t\t\t\t<div>");
      out.print(room.getFloor() );
      out.write("</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>전용/공급면적</p>\r\n");
      out.write("   \t\t\t\t<div>");
      out.print( room.getSize() );
      out.write("평</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>난방종류</p>\r\n");
      out.write("   \t\t\t\t<div>개별난방</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>빌트인</p>\r\n");
      out.write("   \t\t\t\t<div>빌트인/주방</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>엘리베이터</p>\r\n");
      out.write("   \t\t\t\t<div>없음</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>반려동물</p>\r\n");
      out.write("   \t\t\t\t<div>가능</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>베란다/발코니</p>\r\n");
      out.write("   \t\t\t\t<div>있음</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>전세자금대출</p>\r\n");
      out.write("   \t\t\t\t<div>불가능</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>냉장고</p>\r\n");
      out.write("   \t\t\t\t<div>있음</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>세탁기</p>\r\n");
      out.write("   \t\t\t\t<div>있음</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>에어컨</p>\r\n");
      out.write("   \t\t\t\t<div>있음</div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t\t<li>\r\n");
      out.write("   \t\t\t\t<p>기타</p>\r\n");
      out.write("   \t\t\t\t<div></div>\r\n");
      out.write("   \t\t\t</li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   \t</div>\r\n");
      out.write("   \r\n");
      out.write("\t<div class=\"roomDetail-info4\">\r\n");
      out.write("\t\t<div id=\"roomImg-number\"><p>매물번호 : ");
      out.print( room.getRoom_num() );
      out.write("</p></div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("   \t\t\t<img class=\"roomDetailImg01\" src=\"");
      out.print(request.getContextPath());
      out.write("/upload/board/");
      out.print( ri.getRenameName() );
      out.write("\" alt=\"\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"roomDetailImg03\">\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t   \t\t\t<img class=\"roomDetailImg02\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/roomImg01.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<span>\t\r\n");
      out.write("\t   \t\t\t<img class=\"roomDetailImg02\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/roomImg01.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t   \t\t\t<img class=\"roomDetailImg02\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/roomImg01.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t   \t\t\t<img class=\"roomDetailImg02\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/roomImg01.jpg\" alt=\"\" />\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"roomDetail-info5\">\r\n");
      out.write("\t\t<p>");
      out.print( roomBoard.getBoard_title() );
      out.write(" </p>\r\n");
      out.write("\t\t<div id=\"roomDetail-info5-content\">\r\n");
      out.write("\t\t\t");
      out.print( roomBoard.getContent() );
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t<div class=\"roomDetail-info6\">\r\n");
      out.write("\t\t<p class=\"map-title\">위치 및 주변시설</p>\r\n");
      out.write("\t\t<input type=\"text\" id=\"roomLocation\" value=\"");
      out.print(room.getLocation() );
      out.write("\" readonly/>\r\n");
      out.write("\t\t<div id=\"roomMap\" style=\"width:800px;height:500px;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=f812560fa3200866e643713203eb962f\"></script>\t\r\n");
      out.write("<script>\r\n");
      out.write("var mapContainer = document.getElementById('roomMap'), // 지도를 표시할 div \r\n");
      out.write("mapOption = {\r\n");
      out.write("    center: new kakao.maps.LatLng(37.56682, 126.97865), // 지도의 중심좌표\r\n");
      out.write("    level: 3, // 지도의 확대 레벨\r\n");
      out.write("    mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류\r\n");
      out.write("}; \r\n");
      out.write("\r\n");
      out.write("// 지도를 생성한다 \r\n");
      out.write("var map = new kakao.maps.Map(mapContainer, mapOption); \r\n");
      out.write("\r\n");
      out.write("function brokerPhone() {\r\n");
      out.write("\tconnectWrap.style.display = \"block\";\r\n");
      out.write("\tconnectBack.style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("function brokerCloseBtn() {\r\n");
      out.write("\tconnectWrap.style.display = \"none\";\r\n");
      out.write("\tconnectBack.style.display = \"none\";\r\n");
      out.write("}\r\n");
      out.write("function roomReportBtn() {\r\n");
      out.write("\tcertification.style.display = \"block\";\r\n");
      out.write("\tcertificationWrap.style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("function roomReportcloseBtn() {\r\n");
      out.write("\tcertification.style.display = \"none\";\r\n");
      out.write("\tcertificationWrap.style.display = \"none\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>Copyright 2020 <strong class=\"rot\">RoomOfTruth</strong>. All rights reserved.</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
