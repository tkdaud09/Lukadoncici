package xyz.itwill.dto;

//create table member(id varchar(20) primary key, passwd varchar2(200), name varchar2(30)
//	    , email varchar2(50), mobile varchar(20), zipcode varchar2(10), address varchar2(200)
//	    , address2 varchar2(100), join_date date, last_login date, member_status number(1));

/*
이름            널?       유형            
------------- -------- ------------- 
ID            NOT NULL VARCHAR2(20)   - 아이디
PASSWD                 VARCHAR2(200)  - 비밀번호 : 암호화 처리
NAME                   VARCHAR2(30)   - 이름
EMAIL                  VARCHAR2(50)   - 이메일
MOBILE                 VARCHAR2(20)   - 전화번호
ZIPCODE                VARCHAR2(10)   - 우편번호
ADDRESS1               VARCHAR2(200)  - 기본주소
ADDRESS2               VARCHAR2(100)  - 상세주소
JOIN_DATE              DATE           - 회원가입 날짜
LAST_LOGIN             DATE           - 마지막 로그인 날짜
MEMBER_STATUS          NUMBER(1)      - 회원 상태 : 0(탈퇴), 1(일반), 9(관리자)
*/

public class MemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String mobile;
	private String zipcode;
	private String address1;
	private String address2;
	private String joinDate;
	private String lastLogin;
	private int memberStatus;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}
	
	
	
}