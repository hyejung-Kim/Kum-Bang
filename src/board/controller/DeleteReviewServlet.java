package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.RoomReview;
import board.model.vo.RoomBoard;

/**
 * Servlet implementation class DeleteReviewServlet
 */
@WebServlet("/board/reviewdelete")
public class DeleteReviewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewServlet() {
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
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		String br_cp_id = request.getParameter("br_cp_id");
		
		int reviewId = Integer.parseInt(request.getParameter("reviewno"));
		RoomReview rr = new RoomReview();
		int result = new BoardService().deleteReview(reviewId);
		
		String msg = result > 0 ? "리뷰 삭제 성공!" : "리뷰 삭제 실패!";
		String loc ="/board/boardView?board_num=" + boardno + "&br=" + br_cp_id;
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		
		
	}
}
