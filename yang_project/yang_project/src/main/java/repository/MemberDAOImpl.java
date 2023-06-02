package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;


public class MemberDAOImpl implements MemberDAO{
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public void insert(MemberVO mvo) {
		int isOk = sql.insert(NS+"insert", mvo);
		if (isOk == 1) {
			log.info("insert 성공!!");
			log.info(">>> isOk : "+isOk);
			sql.commit();
		}else {
			log.info("insert 실패ㅠㅠ");
			log.info(">>> isOk : "+isOk);
		}
		
	}

	@Override
	public MemberVO select(MemberVO mvo) {
		return sql.selectOne(NS+"select",mvo);
	}

	@Override
	public void delete(String id) {
		int isOk = sql.delete(NS+"delete",id);
		if (isOk == 1) {
			log.info("delete 성공!!");
			log.info(">>> isOk : "+isOk);
			sql.commit();
		}else {
			log.info("delete 실패ㅠㅠ");
			log.info(">>> isOk : "+isOk);
		}
	}

	@Override
	public List<MemberVO> list() {
		return sql.selectList(NS+"list");
	}

	@Override
	public void update(MemberVO mvo) {
		sql.update(NS+"update",mvo);
		sql.commit();
	}

}
