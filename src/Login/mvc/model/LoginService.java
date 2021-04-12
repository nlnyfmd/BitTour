package Login.mvc.model;

import static Login.mvc.model.LoginCase.*;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import Domain.Member;


public class LoginService {
	private LoginDAO dao;
	
	private static final LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	public int checkMember(String email, String pwd) {
		Member m = dao.getMember(email);
		System.out.println("email:"+email);
		if(m ==null) {
			System.out.println("m�� ����");
			return NO_ID;
			
		}else {
			System.out.println("m�� ���̾ƴ�");
			String pwdDb = m.getPwd();
			if(pwdDb != null) pwdDb = pwdDb.trim();
			
			if(!pwd.equals(pwdDb)) {
				return NO_PWD;				
			}else {
				System.out.println("PASS�Ȱǰ�");
				return PASS;
			}
		}
	}
	public int joinS(String email) {//ȸ�����Կ�
		Member m = dao.getMember(email);	
		String emailDb = m.getEmail();		
		//if(emailDb !=null) emailDb = emailDb.trim();	
		if(m==null) {
			return SIGN_UP;
		}else {
			return ER_SIGNUP;
		}
	}
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd(""); //for ���ȼ�
		return m;
	}
	public int insertS(Member dto, String email) {
		Member m = dao.getMember(email);//�񱳰� �ƴϰ� �����̴�..
		if(m==null) {//�̰� �񱳾�..
			dao.insert(dto);
			return SIGN_UP;
		}else {
			return ER_SIGNUP;
		}
		
	}
	public int checkPwd(String email, String pwd) {
		Member m = dao.getMember(email);
		String pwdDb = m.getPwd();		
		if(pwdDb != null) pwdDb = pwdDb.trim();			
		if(pwdDb != null) {
			return NO_PWD;
		}else {
			return PASS;
		}
	}
	public String findIdS(String name, String phone) {
		String email = dao.findId(name, phone);
		if(email !=null) {
			return email; //email �� ���Ͷ�
		}else {
			return null;//email �� ����
		}
	}
	public String findPwdS(String phone, String email) {
		String pwd = dao.findPwd(phone, email);
		if(pwd !=null) {
			return pwd; //pwd �� ���Ͷ�
		}else {
			return null;//pwd �� ����
		}
	}
	public Member joinUpdateS(int member_no) {
			return dao.update1(member_no);
	}
	public void joinupdateS2(Member dto) {
		dao.update2(dto);
	}
	public void delS(int seq) {
		dao.del(seq);
	}
}

