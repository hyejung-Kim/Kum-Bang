package member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import member.model.exception.memberException;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberProfileServlet
 */
@WebServlet("/member/updateCertificate")
public class UpdateCertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCertificateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			throw new memberException("enctype오류!");
		}
		int fileMaxSize = 10 * 1024 * 1024;
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		String saveDirectory = getServletContext().getRealPath("/") + "/upload/certificate";
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, fileMaxSize, "utf-8", policy);
		
		
		
		String memberId = multi.getParameter("memberId");
		String certificate = multi.getOriginalFileName("certificate");
		
		System.out.println("저장경로 -----------> "+ saveDirectory);
		System.out.println("인증서파일 -----------> "+ certificate);
		
		
		Member m = new Member(memberId, null, null, null, null, null, 0, null ,null, certificate);
		int result = new MemberService().updateMemberCertificate(m);
		
		HttpSession session = request.getSession();
		Member memberLoggedIn 
			= (Member)session.getAttribute("memberLoggedIn");
		//세션에 변경내역 반영
		if(result > 0 && memberId.equals(memberLoggedIn.getMemberId())) {
//					memberLoggedIn.setPassword(password);
			memberLoggedIn.setCertificate(certificate);
		} 
		 
		System.out.println("memberCertificate@servlet"+m);	
		
		
		
		//4. view단
		String msg = result > 0 ? "인증서 수정 성공!" : "인증서 수정 실패!";
		String loc = "/member/memberProfileView";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);
	}

}
