package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@AllArgsConstructor : ��� �ʵ忡 ���� �ʱ�ȭ ������ ������ �����ڸ� �����ϴ� ������̼� 
//@AllArgsConstructor 
//@RequiredArgsConstructor : final �����ڸ� ����Ͽ� �ۼ��� �ʵ忡 ���� �ʱ�ȭ ������ ������ �����ڸ� �����ϴ� ������̼�
// => final ������ ��� @NonNull ������̼��� ����� �ʵ忡 ���� ������ ����
@RequiredArgsConstructor
@Service("memberService")
public class MemberServiceimpl implements MemberService {
	//�ʵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - �ʵ� ������ ������ ����
	// => �ʵ忡 Setter �޼ҵ尡 ��� �ʵ忡 ������ ���� ����
	// => ���� �������� ������ ���� ��������� ��ȯ ������ ������ �߻����� �ʾ� StackOverflow �߻� ����
	//@Autowired
	//private MemberDAO memberDAO;
	
	//@RequiredArgsConstructor ������̼����� ������ �����ڷ� �ʱ�ȭ ó���ϱ� ���� �ʵ�
	//private final MemberDAO memberDAO;
	@NonNull private MemberDAO memberDAO;
	
	//�ʵ忡 ���� Setter �޼ҵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - Setter ������ ������ ����
	// => Setter �޼ҵ��� ���� �����ڰ� [public]�� ��� Setter �޼ҵ带 ���� ȣ���Ͽ� �������� ���� ����
	/*
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	*/
	
	/*
	public MemberServiceimpl() {
		log.info("MemberServiceimpl Ŭ������ �⺻ ������ ȣ��");
	}
	*/
	
	/*
	//�Ű������� ���޹��� ��ü�� �ʵ忡 ������ �����ϴ� �����ڿ� @Autowired ������̼��� 
	//����Ͽ� ������ ���� - Constructor ������ ������ ����
	// => Spring �����ӿ�ũ������ ��ȯ ���� ������ ���� �����ڸ� �̿��� ������ ���� ����
	// => �Ű������� ����� �����ڸ� �ϳ��� �ۼ��� ��� @Autowired ������̼� ���� ����
	//@Autowired
	public MemberServiceimpl(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
		log.info("MemberServiceimpl Ŭ������ �Ű������� ����� ������ ȣ��");
	}
	*/
	
	@Override
	public void addMember(Member member) {
		log.info("MemberServiceimpl Ŭ������ addMember() �޼ҵ� ȣ��");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		log.info("MemberServiceimpl Ŭ������ modifyMember() �޼ҵ� ȣ��");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		log.info("MemberServiceimpl Ŭ������ removeMember() �޼ҵ� ȣ��");
		memberDAO.deleteMember(id);
	}

	@Override
	public Member getMember(String id) {
		log.info("MemberServiceimpl Ŭ������ getMember() �޼ҵ� ȣ��");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		log.info("MemberServiceimpl Ŭ������ getMemberList() �޼ҵ� ȣ��");
		return memberDAO.selectMemberList();
	}

}