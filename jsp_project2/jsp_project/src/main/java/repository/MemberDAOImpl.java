package repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private SqlSession sql;
	//NameSpace = SQL이 mapper를 구분하기 위한 이름이다.
	//NameSpace.SQL 구문이름을 적는다.
	private String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(MemberVO mvo) {
		//sql.insert(NS+이름, 객체);
		//transaction 처리가 자동으로 이루어진다.
		int isOk = sql.insert(NS+"reg", mvo);
		if (isOk>0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public MemberVO selectOne(MemberVO mvo2) {
		return sql.selectOne(NS+"login",mvo2);
	}
	@Override
	public int lastLogin(String id2) {
		log.info(">>> logout DAO 진입");
		int isOk = sql.update(NS+"logout", id2);
		if(isOk > 0 ) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public void update(MemberVO mvo3) {
		int isOk = sql.update(NS+"update", mvo3);
		 if(isOk > 0) {
			 sql.commit();
		 }
		 
	}
	@Override
	public List<MemberVO> list() {
		return sql.selectList(NS+"list");
	}
	@Override
	public void remove(String id) {
		int isOk = sql.delete(NS+"remove", id);
		if(isOk > 0) {
			sql.commit();
		}
	}

}
