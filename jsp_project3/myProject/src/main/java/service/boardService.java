package service;

import java.util.List;

import domain.PagingVO;
import domain.boardVO;

public interface boardService {

	void create(boardVO bvo);

	List<boardVO> list();

	void counter(int string);

	void update(boardVO updateBvo);

	void remove(int num);

	int getTotal(PagingVO pgvo);

	List<boardVO> getPageList(PagingVO pgvo);

}
