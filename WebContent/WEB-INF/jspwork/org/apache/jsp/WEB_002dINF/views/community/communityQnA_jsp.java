/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-21 00:01:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.community;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import community.model.vo.ComBoard;
import member.model.vo.Member;
import broker.model.vo.Broker;

public final class communityQnA_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1595171440000L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1594259972000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("community.model.vo.ComBoard");
    _jspx_imports_classes.add("member.model.vo.Member");
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
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/community.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//session : 선언없이 사용할 수 있는 jsp내장객체
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
	Broker brokerLoggedIn = (Broker) session.getAttribute("brokerLoggedIn");

	//쿠키관련
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String saveIdValue = "";

	if (cookies != null) {
		for (Cookie c : cookies) {
			String k = c.getName();
			String v = c.getValue();

			//saveId 쿠키 존재여부 확인
			if ("saveId".equals(k)) {
				saveIdChecked = true;
				saveIdValue = v; //memberId
			}
		}

	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>DamoaBang</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/style.css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.5.1.js\"></script>\r\n");
      out.write("<script>\r\n");
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
      out.write("\t\t\t\t\t$(\"#id_check\").text(\"사용 불가\");\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").css(\"color\", \"red\");\r\n");
      out.write("\t\t\t\t\t$(\"#submit\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t\t}else if(memberId.length!=0&&data==\"usable\"){\r\n");
      out.write("\t\t\t\t\t$(\"#id_check\").text(\"사용가능\");\r\n");
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
      out.write("\t//회원 가입\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#register\").submit(function() {\r\n");
      out.write("\t\t\t//아이디검사\r\n");
      out.write("\t\t\tlet $memberId = $(\"#userId\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (!/^[\\w]{4,}$/.test($memberId.val())) {\r\n");
      out.write("\t\t\t\talert(\"아이디가 유효하지 않습니다.\");\r\n");
      out.write("\t\t\t\t$memberId.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t//아이디 중복검사 \r\n");
      out.write("\t\t\t/* let $isIdValid = $(\"#isIdValid\");\r\n");
      out.write("\t\t\tif($isIdValid.val() == 0){\r\n");
      out.write("\t\t\t\talert(\"아이디 중복검사 해주세요.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\r\n");
      out.write("\t\t\t//비밀번호 검사\r\n");
      out.write("\t\t\tlet $pwd1 = $(\"#userPwd\");\r\n");
      out.write("\t\t\tlet $pwd2 = $(\"#userPwdChk\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tif ($pwd1.val() !== $pwd2.val()) {\r\n");
      out.write("\t\t\t\talert(\"비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("\t\t\t\t$pwd1.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t//마이페이지 연결 리스트(토글버튼처럼 구현)\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\".nav-user-link\").click(function() {\r\n");
      out.write("\t\t\tif ($(\".profile__list\").css(\"display\") == \"none\")\r\n");
      out.write("\t\t\t\t$(\".profile__list\").show();\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t\t$(\".profile__list\").hide();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\".filter-select__header\").click(function() {\r\n");
      out.write("\t\t\tif ($(\".filter-select__list\").css(\"display\") == \"none\")\r\n");
      out.write("\t\t\t\t$(\".filter-select__list\").show();\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t\t$(\".filter-select__list\").hide();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header class=\"navbar navbar-expand\" id=\"mainNav\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("\" class=\"navbar-brand\">다모아방</a>\r\n");
      out.write("\t\t\t<div class=\"navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("\t\t\t\t<ul class=\"navbar-nav\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");
if (memberLoggedIn != null || brokerLoggedIn != null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if (memberLoggedIn != null && brokerLoggedIn == null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
if (memberLoggedIn.getMemberRole().equals("U")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item-community\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQnA\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item-room\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-user-link\"><img style=\"background-color: rgb(255, 136, 81); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></a></li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul class=\"profile__list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-img\"><img style=\"background-color: rgb(255, 136, 81); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\">");
      out.print(memberLoggedIn.getMemberId());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-email\">");
      out.print(memberLoggedIn.getEmail());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-info\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/memberProfileView'\">내 정보 보기</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-logout\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/logout'\">로그아웃</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item-community\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQnA\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item-room\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-user-link\"><img style=\"background-color: rgb(0, 0, 255); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul class=\"profile__list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-img\"><img style=\"background-color: rgb(0, 0, 255); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\">");
      out.print(memberLoggedIn.getMemberId());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-email\">");
      out.print(memberLoggedIn.getEmail());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-info\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/admin/memberList';\">회원정보 조회</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-logout\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/logout'\">로그아웃</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"nav-item-community\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQnA\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"nav-item-room\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/brokerBoard/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-user-link\"><img style=\"background-color: rgb(0, 255, 0); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"profile__list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-img\"><img style=\"background-color: rgb(0, 255, 0); border-radius: 60%;\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\" /></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"login-profile\">");
      out.print(brokerLoggedIn.getBr_name());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"login-profile\" id=\"login-profile-email\">");
      out.print(brokerLoggedIn.getEmail());
      out.write("</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-info\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/broker/brokerProfileView'\">내 정보 보기</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li class=\"login-mypage\" id=\"login-mypage-logout\"><div onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/broker/logout'\">로그아웃</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQnA\" class=\"nav-link\">커뮤니티</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\" class=\"nav-link\">방 찾기</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" onclick=\"signupbtn()\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<!-- \t\t\t\t<ul class=\"navbar-nav\"> --> ");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t<li class=\"nav-item\"><a href=\"#\" class=\"nav-link\" onclick=\"signupbtn()\">로그인</a></li> -->\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t\t<ul class=\"profile__list\"> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t\t</ul> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t<ul class=\"profile__list\"> -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t\t</ul> -->\r\n");
      out.write("\r\n");
      out.write("<!-- //  \t\t\t\t\t\t\t\t\t}  -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t</ul> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 로그인 창 -->\r\n");
      out.write("\t<div id=\"signWrap\"></div>\r\n");
      out.write("\t<div id=\"wrap\">\r\n");
      out.write("\t\t<div class=\"form-wrap\">\r\n");
      out.write("\t\t\t<div class=\"button-wrap\">\r\n");
      out.write("\t\t\t\t<div id=\"btn\"></div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" id=\"loginBtn\" class=\"togglebtn\" onclick=\"login()\">로그인</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" id=\"registerBtn\" class=\"togglebtn\" onclick=\"register()\">회원가입</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<input type=\"button\" class=\"HeaderCloseBtn\" id=\"closeBtn\" value=\"x\" onclick=\"closeBtn();\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/member/login\" id=\"login\" method=\"post\" class=\"input-group\">\r\n");
      out.write("\t\t\t\t<div class=\"social-icons\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/naver.png\" alt=\"naver\"> <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/facebook.png\" alt=\"facebook\"> <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/google.png\" alt=\"google\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"loginId\" name=\"memberId\" class=\"input-field\" placeholder=\"아이디를 입력해주세요\" required value=\"");
      out.print(saveIdChecked ? saveIdValue : "");
      out.write("\" /> <input type=\"password\" id=\"loginPwd\" name=\"password\" class=\"input-field\" placeholder=\"비밀번호를 입력해주세요\" required>\r\n");
      out.write("\t\t\t\t<div id=\"chkWrap\">\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" class=\"checkbox\" name=\"saveId\" ");
      out.print(saveIdChecked ? "checked" : "");
      out.write(" />아이디 저장 <span class=\"checkbox brokerChk\" id=\"br_frm\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/broker/index'\">중개인이세요?</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"submit\" value=\"로그인\" /> <a id=\"findLink\" onclick=\"findLink()\">비밀번호 찾기</a>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<form id=\"register\" action=\"");
      out.print(request.getContextPath());
      out.write("/member/enroll\" method=\"post\" onsubmit=\"return resisterVal();\" class=\"input-group\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"userId\" name=\"memberId\" class=\"input-field\" placeholder=\"User ID\" required>\r\n");
      out.write("\t\t\t\t<div id=\"id_check\"></div>\r\n");
      out.write("\t\t\t\t<input type=\"email\" id=\"userEmail\" name=\"email\" class=\"input-field\" placeholder=abc@xyz.com required> <input type=\"password\" id=\"userPwd\" name=\"password\" class=\"input-field\" placeholder=\"Enter Password\" required> <input type=\"password\" id=\"userPwdChk\" class=\"input-field\" placeholder=\"Enter Password Check\" required> <input type=\"tel\" id=\"userPhone\" name=\"phone\" class=\"input-field\" placeholder=\"(-없이)01012345678\" maxlength=\"11\" required>\r\n");
      out.write("\t\t\t\t<button class=\"submit\">회원가입</button>\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/broker/enroll\">중개인 회원가입</a>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 비밀번호 찾기 추가!!! -->\r\n");
      out.write("\t<div id=\"find_wrap\">\r\n");
      out.write("\t\t<div class=\"findFrm-wrap\">\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"find_closeBtn\" value=\"x\" onclick=\"find_closeBtn();\">\r\n");
      out.write("\t\t\t<p>비밀번호 찾기</p>\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/member/findPwd\" id=\"find-pwd\" method=\"post\" class=\"input-group\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"input-email\" name=\"email\" class=\"input-field\" placeholder=\"이메일을 입력해주세요\" required /> \r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"findId-submit\" value=\"이메일 전송\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//로그인 관련\r\n");
      out.write("\t\tlet x = document.getElementById(\"login\");\r\n");
      out.write("\t\tlet y = document.getElementById(\"register\");\r\n");
      out.write("\t\tlet z = document.getElementById(\"btn\");\r\n");
      out.write("\t\tlet loginbtn = document.getElementById(\"loginBtn\");\r\n");
      out.write("\t\tlet registerbtn = document.getElementById(\"registerBtn\");\r\n");
      out.write("\r\n");
      out.write("\t\tfunction login() {\r\n");
      out.write("\t\t\tx.style.left = \"50px\";\r\n");
      out.write("\t\t\ty.style.left = \"450px\";\r\n");
      out.write("\t\t\tz.style.left = \"0\";\r\n");
      out.write("\t\t\tloginbtn.style.color = \"white\";\r\n");
      out.write("\t\t\tregisterbtn.style.color = \"black\";\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction register() {\r\n");
      out.write("\t\t\tx.style.left = \"-400px\";\r\n");
      out.write("\t\t\ty.style.left = \"50px\";\r\n");
      out.write("\t\t\tz.style.left = \"110px\";\r\n");
      out.write("\t\t\tloginbtn.style.color = \"black\";\r\n");
      out.write("\t\t\tregisterbtn.style.color = \"white\";\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction signupbtn() {\r\n");
      out.write("\t\t\twrap.style.display = \"block\";\r\n");
      out.write("\t\t\tsignWrap.style.display = \"block\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction closeBtn() {\r\n");
      out.write("\t\t\twrap.style.display = \"none\";\r\n");
      out.write("\t\t\tsignWrap.style.display = \"none\";\r\n");
      out.write("\t\t\t$(\"#register\").children().val('');\r\n");
      out.write("\t\t\t$(\"#loginPwd\").val('');\r\n");
      out.write("\t\t\t$(\"#id_check\").text(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t/* 추가!!!!! */\r\n");
      out.write("\t\tfunction find_closeBtn() {\r\n");
      out.write("\t\t\tfind_wrap.style.display = \"none\";\r\n");
      out.write("\t\t\tsignWrap.style.display = \"none\";\r\n");
      out.write("\t\t\t$(\"#register\").children().val('');\r\n");
      out.write("\t\t\t$(\"#loginPwd\").val('');\r\n");
      out.write("\t\t\t$(\"#id_check\").text(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction findLink() {\r\n");
      out.write("\t\t\twrap.style.display = \"none\";\r\n");
      out.write("\t\t\tfind_wrap.style.display = \"block\";\r\n");
      out.write("\t\t\t$(\"#register\").children().val('');\r\n");
      out.write("\t\t\t$(\"#loginPwd\").val('');\r\n");
      out.write("\t\t\t$(\"#id_check\").text(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>");
      out.write('\r');
      out.write('\n');

	List<ComBoard> comlist = (List<ComBoard>)request.getAttribute("comlist");
	ComBoard comboard = (ComBoard)request.getAttribute("comboard");
	int[] replycount = (int [])request.getAttribute("replycount");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"nav-bar\">\r\n");
      out.write("\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQnA\" class=\"community-nav\">질문과 답변</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"commu-info-container\">\r\n");
      out.write("\t<section id=\"features\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row aln-center\">\r\n");
      out.write("\t\t\t\t<div class=\"col-4 col-6-medium col-12-small\">\r\n");
      out.write("\t\t\t\t\t<!-- Feature -->\r\n");
      out.write("\t\t\t\t\t<div class=\"questions-filter__content container\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"questions-filter__filters\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"filter-select\" id=\"questions-filter-sort\" data-modal-id=\"questions-filter-sort-modal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<dl class=\"filter-select__header\" role=\"button\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<dt class=\"filter-select__header__name\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t정렬 ▼<span class=\"icon icon-pointer-angle-down-dark-sm\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<dd class=\"filter-select__header__value\">최신순</dd>\r\n");
      out.write("\t\t\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"questions-filter__actions\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"set-reply btn btn-normal btn-sm\" href=\"");
      out.print(request.getContextPath() );
      out.write("/community/communityQnAzero\"> 답변을 기다리는 질문</a> <a class=\"questions-filter__actions__new-question btn btn-priority btn-sm\" href=\"");
      out.print(request.getContextPath());
      out.write("/community/communityQuestion\">질문하기</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");
int i = 0; 
      out.write("\r\n");
      out.write("\t\t\t\t");
 for(ComBoard cb : comlist){ 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"info-questionList\">\r\n");
      out.write("\t\t\t\t\t<!-- 질문 목록 -->\r\n");
      out.write("\t\t\t\t\t<article class=\"questions-item\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/community/communityQnADetail?boardnum=");
      out.print( cb.getboardnum() );
      out.write("'\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"questions-item__image\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"image-wrap square\">\r\n");
      out.write("<!-- \t\t\t\t\t\t\t\t<img src=\"https://image.ohou.se/image/central_crop/bucketplace-v2-development/uploads-cards-snapshots-1548687459_vMyG4GyO.jpeg/320/320\"> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/upload/community/");
      out.print(cb.getRenamename() );
      out.write("\" onerror=\"this.src='");
      out.print( request.getContextPath() );
      out.write("/images/roomImg01.jpg'\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<h1 class=\"questions-item__title text-heading-5 bold text-black\">");
      out.print( cb.getTitle() );
      out.write("</h1>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"questions-item__content\" id=\"text-caption-1\">");
      out.print( cb.getContent() );
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ProfileIdDateReplyCheck\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"Question-ProfileImge\"> <img class=\"MemberProfileImg\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\"></span> \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"QuestionEnrolldateReplyCheck\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"questions-list-MemberId\">");
      out.print(cb.getMemberid() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<time datetime=\"2019-01-28T23:57:51+09:00\" class=\"QuestionEnrolldate\">");
      out.print( cb.getEnrolldate() );
      out.write("</time> \r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"QuestionReply\">댓글 <span class=\"questions-item__footer__comments__content active\"> ");
      out.print(replycount[i] );
      out.write("</span></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
 i++; } 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>Copyright 2020 <strong class=\"rot\">RoomOfTruth</strong>. All rights reserved.</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("</html>");
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
