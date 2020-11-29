package member.model.service;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class MemberService {
	
	public static final String MEMBER_ROLE_USER = "U";
	public static final String MEMBER_ROLE_ADMIN = "A";
	public static final String MEMBER_ROLE_Owner = "O";
	
	private MemberDAO memberDAO = new MemberDAO();

	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		Member m = memberDAO.selectOne(conn, memberId);
		close(conn);
//		System.out.println("m@service = "+m);
		return m;
		
	}

	public int insertMember(Member newMember) {
		Connection conn = getConnection();
		
		//dao단에 요청
		int result = memberDAO.insertMember(conn, newMember);
		
		//트랜잭션 처리
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		//자원반납
		close(conn);
		
		return result;
	}

	public int updateMember(Member updateMember) {
		Connection conn = getConnection();
		int result = memberDAO.updateMember(conn, updateMember);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}

	public Member selectOneEmail(String email) {
		Connection conn = getConnection();
		Member m = memberDAO.selectOneEmail(conn, email);
		close(conn);
//		System.out.println("m@service = "+m);
		return m;
	}

	public List<Member> selectAll(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = memberDAO.selectAll(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	public int selectTotalContents() {
		Connection conn = getConnection();
		int totalContents = memberDAO.selectTotalContents(conn);
		close(conn);
		return totalContents;
	}

	public List<Member> searchMember(String searchType, String searchKeyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = memberDAO.searchMember(conn, searchType, searchKeyword, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectTotalContents(String searchType, String searchKeyword) {
		Connection conn = getConnection();
		int totalContents = memberDAO.selectTotalContents(conn, searchType, searchKeyword);
		close(conn);
		return totalContents;
	}

	public int updatePassword(String memberId, String newPassword) {
		Connection conn = getConnection();
		int result = memberDAO.updatePassword(conn, memberId, newPassword);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn, memberId);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateMemberProfile(Member m) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberProfile(conn, m);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int updatePassword(Member updateMember) {
		Connection conn = getConnection();
		int result = memberDAO.updatePassword(conn, updateMember);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int updateMemberCertificate(Member m) {
		Connection conn = getConnection();
		int result = memberDAO.updateMemberCertificate(conn, m);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateAuthority(Member m)
	{
		Connection conn = getConnection();
		int result = memberDAO.updateMemberCertificate(conn, m);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
