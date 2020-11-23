package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board.model.exception.BoardException;
import board.model.service.BoardService;
import board.model.vo.Room;
import board.model.vo.RoomBoard;
import board.model.vo.RoomImage;
import board.model.vo.RoomReview;
import common.WebFileRenamePolicy;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/board/reviewupdate")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.parameterHandling
		int reviewId;
		try{
			reviewId = Integer.parseInt(request.getParameter("reviewno"));
		}catch(NumberFormatException e){
			throw new BoardException("유효하지 않은 리뷰입니다.");
		}
		
		System.out.println("************************************************************************************"+reviewId);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		String br_cp_id = request.getParameter("br_cp_id");
		
		int reviewId = Integer.parseInt(request.getParameter("reviewno"));
		String reviewContent = request.getParameter("reviewcontent");
		String[] ratings = request.getParameterValues("rating");
		int rating = Integer.parseInt(ratings[ratings.length-1]);
		int roomId = Integer.parseInt(request.getParameter("roomno"));
		String userId = request.getParameter("memberId");
		
		System.out.println("review==========="+reviewId);
		System.out.println("content=========="+reviewContent);
		System.out.println("rating=========="+rating);
		System.out.println("roomno=========="+roomId);
		System.out.println("writer==============="+userId);
		
		RoomReview rr = new RoomReview(0, reviewContent, 0, 0, null, null);
		int result = new BoardService().updateReview(rr);
		
		String msg = result > 0 ? "리뷰 수정 성공!" : "리뷰 수정 실패!";
		String loc ="/board/boardView?board_num=" + boardno + "&br=" + br_cp_id;
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			
	}
}
