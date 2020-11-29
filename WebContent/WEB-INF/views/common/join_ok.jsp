<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String email = request.getParameter("email");
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
 String uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
 //
 StringBuffer query = new StringBuffer("");
 query.append("insert into tb_user(email, activation_key, is_activation) \n");
 query.append("values(?, ?, 'N') \n"); //최초 등록시 활성화 플래그를 'N'으로 저장
 //
 Class.forName("com.mysql.cj.jdbc.Driver");
 conn = DriverManager.getConnection(db_url, db_user, db_passwd);
 pstmt = conn.prepareStatement(query.toString());
 int idx = 1;
 pstmt.setString(idx++, email); //이메일 주소
 pstmt.setString(idx++, uuid); //이메일과 매핑과 UUID 값
 pstmt.executeUpdate();
 //
 //활성 URL 메일 발송하기
 String mail_title = "사용자 활성화 메일";
 String host = "localhost";
 String sender = "dalbikim@naver.com";
 String sender_name = "관리자";
 //
 Session sess = null;
 Message msg = null;
 Properties props = null;
 //
 props = new Properties();
 props.put("mail.smtp.host", host);
 sess = Session.getDefaultInstance(props, null);
 //
 msg = new MimeMessage(sess);
 msg.setFrom(new InternetAddress(sender, sender_name, "UTF-8"));
 InternetAddress[] address = {new InternetAddress(email)};
 msg.setRecipients(Message.RecipientType.TO, address);
 msg.setSubject(mail_title);
 String mail_body = "<a href='http://localhost:8080/common/user_activation.jsp?email=" + email + "&key=" + uuid + "' target='_blank'>활성화</a>";
  msg.setContent(mail_body, "text/html;charset=UTF-8");
  msg.setHeader("Content-Transfer-Encoding", "base64");
  msg.setSentDate(new java.util.Date());
  Transport.send(msg);
  //
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
