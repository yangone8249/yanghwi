package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import domain.ProductVO;
import orm.DatabaseConnector;

public class ProductDAO implements DAO {
	//DAO는 DB connet와 연결되어야 한다.
	private Connection conn; //DB Connector 선언
	
	private PreparedStatement pst; //DB연결 후 sql 전송 객체
	
	private String query = ""; //Query작성 변수
	
	//생성자
	public ProductDAO() {
		//싱글톤 방식의 객체 생성
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		
		System.out.println(">>> DAO 접근 완료");
		query = "insert into product(pname, price, madeby) value(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			// executeUpdate() : insert, update, delete
			// executeQuery() : se
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		System.out.println(">>> DAO 접근완료");
		query = "select * from product order by pno desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) { // list에 ProductVO 객체를 추가한다. (DB명과 변수명과 맞춰서 입력해야한다.)
				list.add(new ProductVO(rs.getInt("pno"),rs.getString("pname"),rs.getString("regdate")));
			}
			return list;
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		System.out.println(">>> DAO 접근완료");
		query = "select * from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price"), rs.getString("regdate"), rs.getString("madeby") );
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(int pno, String updateName, int updatePrice, String updateMadeby) {
		System.out.println(">>> DAO 접근완료");
		query = "update product set pname =?, price =?, madeby =?, regdate = now() where pno =?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, updateName);
			pst.setInt(2, updatePrice);
			pst.setString(3, updateMadeby);
			pst.setInt(4, pno);
			return pst.executeUpdate(); //1
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public void remove(int pno3) {
		System.out.println(">>> DAO 접근완료");
		query = "delete from product where pno =?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno3);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	



}
