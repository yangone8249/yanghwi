package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;
import service.BoardServiceImpl;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private SqlSession sql;
	//NameSpace = SQL이 mapper를 구분하기 위한 이름이다.
	//NameSpace.SQL 구문이름을 적는다.
	private String NS = "BoardMapper."; //boardMapper의 Mapper_namespace="BoardMapper"를 변수로 사용한다.
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public void insert(BoardVO bvo) {
		sql.insert(NS+"insert", bvo);
		sql.commit();
	}

	@Override
	public List<BoardVO> list() {
		return sql.selectList(NS+"list");
	}

	@Override
	public void update(BoardVO bvo) {
		sql.update(NS+"update", bvo);
		sql.commit();
	}

	@Override
	public void remove(int parameter) {
		sql.delete(NS+"remove", parameter);
		sql.commit();

	}

	@Override
	public void counter(int i) {
		sql.update(NS+"counter",i);
		sql.commit();
	}
}
