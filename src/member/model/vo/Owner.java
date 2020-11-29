package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Owner implements Serializable 
{

	private String ownerId;
	private String email;
	private String password;
	private String ownerName;
	private String phoneNum;
	private Date enrolldate;
	private String profile;
	private String black;
	private int sellcount;
	private int outcount;
	
	public Owner() {
		super();

	}

	public Owner(String ownerId, String email, String password, String ownerName, String phoneNum,
			Date enrolldate, String profile, String black, int sellcount, int outcount) {
		super();
		this.ownerId = ownerId;
		this.email = email;
		this.password = password;
		this.ownerName = ownerName;
		this.phoneNum = phoneNum;
		this.enrolldate = enrolldate;
		this.profile = profile;
		this.black = black;
		this.sellcount = sellcount;
		this.outcount = outcount;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getBlack() {
		return black;
	}

	public void setBlack(String black) {
		this.black = black;
	}

	public int getSellcount() {
		return sellcount;
	}

	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}

	public int getOutcount() {
		return outcount;
	}

	public void setOutcount(int outcount) {
		this.outcount = outcount;
	}
}
