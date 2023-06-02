package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo2);

	int lastLogin(String id2);

	void update(MemberVO mvo3);

	List<MemberVO> list();

	void remove(String id);

}
