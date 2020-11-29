<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String email = request.getParameter("email");
String key = request.getParameter("key");
//
String db_url = "jdbc:mysql://localhost:3306/kumbang?serverTimezone=UTC&useSSL=false";
String db_user = "root";
String db_passwd = "rlaekfql05";
//
Connection conn = null;
PreparedStatement pstmt = null;
//
String err_mesg = "정상적으로 가입되었습니다.";
boolean is_error = false;
try {
 StringBuffer query = new StringBuffer("");
 query.append("update tb_user \n");
 query.append("set is_activation = 'Y' \n");
 query.append("where email = ? \n");
 query.append(" and activation_key = ? \n");
 query.append(" and is_activation = 'N' \n");
 //
 Class.forName("com.mysql.cj.jdbc.Driver");
 conn = DriverManager.getConnection(db_url, db_user, db_passwd);
 pstmt = conn.prepareStatement(query.toString());
 int idx = 1;
 pstmt.setString(idx++, email);
 pstmt.setString(idx++, key);
 int affected = pstmt.executeUpdate();
 if(affected == 0) {
  is_error = true;
  err_mesg = "활성화할 사용자 정보가 존재하지 않습니다.";
 } else {
  is_error = false;
  err_mesg = "정상적으로 활성화되었습니다.";
 }
} catch(Exception ex) {
 is_error = true;
 err_mesg = ex.getMessage();
 out.println(err_mesg);
} finally {
 if(null != pstmt) pstmt.close();
 if(null != conn) conn.close();
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 [<%=is_error ? "ERROR" : "OK"%>]<%=err_mesg%>
</body>
</html>