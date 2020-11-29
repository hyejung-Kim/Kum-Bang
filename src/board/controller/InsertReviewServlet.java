package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.RoomReview;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/board/insertreview")
public class InsertReviewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		String br_cp_id = request.getParameter("br_cp_id");
		
		//int reviewId = Integer.parseInt(request.getParameter("reviewno"));
		String reviewContent = request.getParameter("reviewcontent");
		String[] ratings = request.getParameterValues("rating");
		int rating = Integer.parseInt(ratings[ratings.length-1]);
		int roomId = Integer.parseInt(request.getParameter("roomnum"));
		String userId = request.getParameter("memberId");
		
		//System.out.println("review==========="+reviewId);
		System.out.println("content=========="+reviewContent);
		System.out.println("rating=========="+rating);
		System.out.println("roomno=========="+roomId);
		System.out.println("writer==============="+userId);
		
		RoomReview rr = new RoomReview(0, reviewContent, rating, roomId, userId, null);
		int result = new BoardService().insertReview(rr);
		
		String msg = result > 0 ? "리뷰 등록 성공!" : "리뷰 등록 실패!";
		String loc ="/board/boardView?board_num=" + boardno + "&br=" + br_cp_id;
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}
}
