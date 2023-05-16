package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnection;


public class MemberDB {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public MemberDB() {
			try {
				con = DBConnection.getConnection();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void select() {
		
		
	
			
	}

	public int register(MemberDTO m) {
		int result = 0;
		System.out.println(m);
//		String sql = "insert into membership(num,member_id,member_pwd,nick,birth,phone) vlaues (MEMBERSHIP_SEQ.nextval,?,?,?,?,?)";
		String sql = "insert into membership values (MEMBERSHIP_SEQ.nextval,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMember_id());
			ps.setString(2, m.getMember_pwd());
			ps.setString(3, m.getNick());
			ps.setDate(5, m.getBirth());
			ps.setString(4, m.getPhone());
			//System.out.println("가입 완료");
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	public int login(String id) {
		int result = 0;
		//String sql =  "insert into membership values (MEMBERSHIP_SEQ.nextval,?,?,?,?,?)";
		String sql =  "select member_id from membership";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
}

