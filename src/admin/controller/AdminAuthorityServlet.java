package admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import broker.model.service.BrokerService;
import broker.model.vo.Broker;
import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Owner;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/admin/updateAuthority")
public class AdminAuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAuthorityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("utf-8");
		
		//2.사용자입력값처리
		String memberId = request.getParameter("memberId");
		System.out.println("brokerBlack@servlet"+memberId);
		
		
		Member updateM = new Member(memberId, null, null, "O", null, null, 0, null, null, null); 
		
		//3.업무로직
		int result = new MemberService().updateAuthority(updateM);
		System.out.println("result@servlet="+result);
	}

}
