package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.PagingVO;
import domain.boardVO;
import orm.DatabaseBuilder;

public class boardDAOImpl implements boardDAO {
	private static final Logger log = LoggerFactory.getLogger(boardDAOImpl.class);
	private SqlSession sql;
	private String NS = "boardMapper.";
	
	public boardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public void create(boardVO bvo) {
		sql.insert(NS+"create", bvo);
		sql.commit();
	}

	@Override
	public List<boardVO> list() {
		return sql.selectList(NS+"list");
	}

	@Override
	public void counter(int string) {
		sql.update(NS+"counter", string);
		sql.commit();
	}

	@Override
	public void update(boardVO updateBvo) {
		sql.update(NS+"update", updateBvo);
		sql.commit();
	}

	@Override
	public void remove(int num) {
		sql.delete(NS+"remove", num);
		sql.commit();
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return sql.selectOne(NS+"getTotal", pgvo);
	}

	@Override
	public List<boardVO> getPageList(PagingVO pgvo) {
		//return sql.selectList(NS+"getPageList",pgvo);
		return sql.selectList(NS+"selectList",pgvo);
	}

}
