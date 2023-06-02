package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}
	
	@Override
	public void insert(BoardVO bvo) {
		bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> list() {
		return bdao.list();
	}

	@Override
	public void update(BoardVO bvo) {
		bdao.update(bvo);
	}

	@Override
	public void remove(int parameter) {
		bdao.remove(parameter);
	}

	@Override
	public void counter(int i) {
		bdao.counter(i);
	}

}
