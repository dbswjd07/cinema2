package Member;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class MemberService {
public static void main(String[] args) {
	MemberDB db = new MemberDB();
	Scanner input = new Scanner(System.in);
	MemberDTO m1 = new MemberDTO();
	String id,pwd,nick=null,phone;
	int num;
	
	while(true) {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디 찾기");
		System.out.println("4. 비밀번호 찾기");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 종료");
		System.out.print(">>> ");
		num = input.nextInt();
		switch(num) {
		case 1: 
			System.out.println("===== 회원 가입 =====");
			while(true) {
				System.out.print("아이디 입력: ");
				id = input.next();
				System.out.print("비밀번호 입력: ");
				pwd = input.next();
				System.out.print("닉네임 입력: ");
				nick = input.next();
				System.out.print("생년월일 입력 (yyyy-mm-dd): ");
				String date = input.next();
				java.sql.Date birth = java.sql.Date.valueOf(date);
				System.out.print("전화번호 입력 : ");
				phone = input.next();
				
				m1.setMember_id(id);
				m1.setMember_pwd(pwd); 
				m1.setNick(nick);m1.setBirth(birth);m1.setPhone(phone);
				int result = db.register(m1);
				
				if(result == 0) {
					
					System.out.println("이미 존재하는 아이디입니다");
					System.out.println("다시 입력해주세요");
					
				}else {
//					System.out.print("비밀번호 입력: ");
//					pwd = input.next();
//					System.out.print("닉네임 입력: ");
//					nick = input.next();
//					System.out.print("생년월일 입력 (yyyy-mm-dd): ");
//					String date = input.next();
//					java.sql.Date birth = java.sql.Date.valueOf(date);
//					System.out.print("전화번호 입력 : ");
//					phone = input.next();
//					
//					
//					m1.setMember_pwd(pwd); m1.setNick(nick);m1.setBirth(birth);m1.setPhone(phone);
					System.out.println("회원 가입을 축하합니다");
					break;
				}
				
				
			}
			
			
			
			
			
			//System.out.println("회원 가입을 축하합니다");
			
			break;
			
		case 2:
			//MemberDB mb = new MemberDB();
			System.out.print("아이디 입력: ");
			id = input.next();
			db.login(id);
			//MemberDTO m1 = new MemberDTO();
			//m1.setMember_id(id);
			MemberDTO d = db.login(id);
			
			if(d ==null) {
				System.out.println("존재하지 않는 회원입니다");
				
				
			}
			else {
				System.out.print("비밀번호 입력: ");
				pwd = input.next();
				d=db.login_pwd(pwd);
				
				if(d==null) {
					System.out.println("비밀번호 틀림");
				}else {
					System.out.println(d.getNick()+"님 안녕하세요");
				}
				
			}
			
			
			break;
			
		case 3:
			System.out.println("===== 아이디 찾기 ====");
			System.out.print("전화번호 입력: ");
			phone = input.next();
			db.search_id(phone);
			MemberDTO d1 = db.search_id(phone);
			if(d1 == null) {
				System.out.println("존재하지 않는 회원입니다");
			}else {
				System.out.println("id: "+d1.getMember_id());
			}
			
			break;
			
		case 4:
			System.out.println("===== 비밀번호 찾기 ====");
			System.out.print("아이디 입력: ");
			id = input.next();
			db.search_pwd(id);
			MemberDTO d2 = db.search_pwd(id);
			if(d2 == null) {
				System.out.println("존재하지 않는 회원입니다");
			}else {
				System.out.println("pwd: "+d2.getMember_pwd());
			}
			
			break;
			
		case 5:
			System.out.println("===== 회원 정보 수정 =====");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 닉네임 수정");
			System.out.println("4. 나가기");
			System.out.print(">>> ");
			num = input.nextInt();
			switch(num) {
			case 1: 
				System.out.print("아이디 입력: ");
				id = input.next();
				break;
			case 2: 
				System.out.print("아이디 입력: ");
				id = input.next();
				break;
			case 3: 
				System.out.print("아이디 입력: ");
				id = input.next();
				break;
			case 4:
				break;
			}
			break;
		case 6:
			System.out.println("===== 회원 탈퇴 =====");
			System.out.println("탈퇴하시겠습까? 네/아니요");
			System.out.print(">>> ");
			String s = input.next();
			switch(s) {
			case "네": 
				System.out.print("아이디 입력 : ");
				id = input.next();
				int result2 = db.delete(id);
				if(result2 == 0) {
					System.out.println("존재하지 않는 회원입니다");
				}else {
					
					System.out.println(id+"님 회원 탈퇴 완료");
				}
				
				break;
			case "아니요": 
				break;
			}
			break;
		case 7:
			System.out.println("회원 정보 페이지 종료");
			return;
			
		}
		
		
		
		
		
	}
	
	
	
	
}
}
