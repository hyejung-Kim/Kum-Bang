package board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class RoomReview implements Serializable
{
	private int reviewId;
	private String reviewContent;
	private int rating;
	private int roomId;
	private String userId;
	private Date enrolldate;
	
	public RoomReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RoomReview(int reviewId, String reviewContent, int rating, int roomId, String userId, Date enrolldate)
	{
		super();
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.roomId = roomId;
		this.userId = userId;
		this.enrolldate = enrolldate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		//id=" + reviewId + ", 
		return "Review [id=" + reviewId + ", content=" + reviewContent + ", rating=" + rating + ", roomId=" + roomId + ", userId="
				+ userId + ", enrolldate=" + enrolldate + "]";
	}
}
