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
	
	public MemberDTO login(String id) {
		//int result = 0;
		//String sql =  "insert into membership values (MEMBERSHIP_SEQ.nextval,?,?,?,?,?)";
		String sql =  "select * from membership where member_id = '"+id+"'";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setNick(rs.getString("nick"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public MemberDTO login_pwd(String pwd) {
		String sql =  "select * from membership where member_pwd = '"+pwd+"'";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setNick(rs.getString("nick"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public MemberDTO search_id(String phone) {
		String sql =  "select * from membership where phone = '"+phone+"'";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setNick(rs.getString("nick"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public MemberDTO search_pwd(String id) {
		String sql =  "select * from membership where member_id = '"+id+"'";
		MemberDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_pwd(rs.getString("member_pwd"));
				dto.setNick(rs.getString("nick"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public int delete(String id) {
		String sql = "delete from membership where member_id = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
		return result;
	}
}

