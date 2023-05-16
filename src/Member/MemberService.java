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
		System.out.print(">>> ");
		num = input.nextInt();
		switch(num) {
		case 1: 
			System.out.println("===== 회원 가입 =====");
			while(true) {
				System.out.print("아이디 입력: ");
				id = input.next();
				//MemberDTO m1 = new MemberDTO();
				m1.setMember_id(id);
				int result = db.register(m1);
				
				if(result == 0) {
					System.out.println("이미 존재하는 아이디입니다");
					System.out.println("다시 입력해주세요");
					
				}else {
					System.out.print("비밀번호 입력: ");
					pwd = input.next();
					System.out.print("닉네임 입력: ");
					nick = input.next();
					System.out.print("생년월일 입력 (yyyy-mm-dd): ");
					String date = input.next();
					java.sql.Date birth = java.sql.Date.valueOf(date);
					System.out.print("전화번호 입력 : ");
					phone = input.next();
					
					m1.setMember_pwd(pwd); 
					m1.setNick(nick);m1.setBirth(birth);m1.setPhone(phone);
					result = db.register(m1);
					
					
					System.out.println("회원 가입을 축하합니다");
					break;
				}
			}
			

			
			break;
			
		case 2:
			
			System.out.print("아이디 입력: ");
			id = input.next();
			//MemberDTO m1 = new MemberDTO();
			m1.setMember_id(id);
			int result = db.register(m1);
			
			if(result == 0) {
				System.out.print("비밀번호 입력: ");
				pwd = input.next();
				
				m1.setMember_pwd(pwd);
				result = db.register(m1);
				
				if(result == 0) {
					System.out.println(nick+"님 안녕하세요");
				}else {
					System.out.println("잘못된 비밀번호입니다");
				}
				
				
			}else {
				System.out.println("존재하지 않는 회원입니다");
			}
			
			
			break;
			
		case 3:
			
			break;
			
		}
		
		
		
	}
	
	
	
	
}
}
