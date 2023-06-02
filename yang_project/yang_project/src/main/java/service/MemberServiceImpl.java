package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	
	@Override
	public void insert(MemberVO mvo) {
		mdao.insert(mvo);
	}

	@Override
	public MemberVO select(MemberVO mvo) {
		return mdao.select(mvo);
	}

	@Override
	public void delete(String id) {
		mdao.delete(id);
	}

	@Override
	public List<MemberVO> list() {
		return mdao.list();
	}

	@Override
	public void update(MemberVO mvo) {
		mdao.update(mvo);
	}

}
