package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO{
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private String NS = "BoardMapper.";
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public void insert(BoardVO bvo) {
		int isOk = sql.insert(NS+"insert",bvo);
		if(isOk == 1) {
			log.info("insert성공!");
			sql.commit();
		}else {
			log.info("insert실패ㅠㅠ");
		}
	}

	@Override
	public List<BoardVO> list() {
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO detail(int parameter) {
		return sql.selectOne(NS+"detail", parameter);
	}

	@Override
	public void count(int parseInt) {
		int isOk = sql.update(NS+"count", parseInt);
		if(isOk == 1) {
			log.info("update성공!");
			sql.commit();
		}else {
			log.info("update실패ㅠㅠ");
		}
	}

	@Override
	public void update(BoardVO boardVO) {
		int isOk = sql.update(NS+"update", boardVO);
		if(isOk == 1) {
			log.info("update성공!");
			sql.commit();
		}else {
			log.info("update실패ㅠㅠ");
		}
	}

	@Override
	public void remove(int parseInt) {
		int isOk = sql.delete(NS+"remove", parseInt);
		if(isOk == 1) {
			log.info("remove성공!");
			sql.commit();
		}else {
			log.info("remove실패ㅠㅠ");
		}
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return sql.selectOne(NS+"getTotal",pgvo);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		return sql.selectList(NS+"getPageList",pgvo);
	}
	
}