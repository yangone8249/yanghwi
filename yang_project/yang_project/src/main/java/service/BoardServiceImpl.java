package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
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
	public BoardVO detail(int parameter) {
		return bdao.detail(parameter);
	}

	@Override
	public void count(int parseInt) {
		bdao.count(parseInt);
	}

	@Override
	public void update(BoardVO boardVO) {
		bdao.update(boardVO);
	}

	@Override
	public void remove(int parseInt) {
		bdao.remove(parseInt);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return bdao.getTotal(pgvo);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		return bdao.getPageList(pgvo);
	}
	
}
