package service;

import java.util.List;

import domain.ProductVO;

public interface Service {

	int register(ProductVO pvo);

	List<ProductVO> list();

	ProductVO detail(int pno);

	int update(int pno, String updateNamE, int updatePrice, String updateMadeby);

	void remove(int pno3);

}