package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo2);

	int lastLogin(String id2);

	void update(MemberVO mvo3);

	List<MemberVO> list();

	void remove(String id);


}
