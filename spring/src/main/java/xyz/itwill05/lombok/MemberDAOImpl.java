package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		log.info("MemberDAOImpl Ŭ������ �⺻ ������ ȣ��");
	}
	
	@Override
	public int insertMember(Member member) {
		log.info("MemberDAOImpl Ŭ������ insertMember() �޼ҵ� ȣ��");
		return 0;
	}
	
	@Override
	public int updateMember(Member member) {
		log.info("MemberDAOImpl Ŭ������ updateMember() �޼ҵ� ȣ��");
		return 0;
	}
	
	@Override
	public int deleteMember(String id) {
		log.info("MemberDAOImpl Ŭ������ deleteMember() �޼ҵ� ȣ��");
		return 0;
	}
	
	@Override
	public Member selectMember(String id) {
		log.info("MemberDAOImpl Ŭ������ selectMember() �޼ҵ� ȣ��");
		return null;
	}
	
	@Override
	public List<Member> selectMemberList() {
		log.info("MemberDAOImpl Ŭ������ selectMemberList() �޼ҵ� ȣ��");
		return null;
	}
}