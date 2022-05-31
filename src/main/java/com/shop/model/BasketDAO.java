package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.BasketVO;
import com.shop.common.JDBCConnection;

public class BasketDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<BasketVO> getGoodsList(String mid){
		ArrayList<BasketVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from basket where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			list = new ArrayList<BasketVO>();
			while(rs.next()) {
				BasketVO vo = new BasketVO();
				vo.setBno(rs.getInt("bno"));
				vo.setBid(rs.getString("bid"));
				vo.setBcode(rs.getInt("bcode"));
				vo.setBname(rs.getString("bname"));
				vo.setBprice(rs.getInt("bprice"));
				vo.setBcolor(rs.getString("bcolor"));
				vo.setBsize(rs.getString("bsize"));
				vo.setBmaterial(rs.getString("bmaterial"));
				vo.setBorder(rs.getInt("border"));
				vo.setRegdate(rs.getDate("regdate"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 처리 실패.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 오류.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public BasketVO getGoods(int bcode){
		BasketVO vo = new BasketVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from basket where bcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setBno(rs.getInt("bno"));
				vo.setBid(rs.getString("bid"));
				vo.setBcode(rs.getInt("bcode"));
				vo.setBname(rs.getString("bname"));
				vo.setBprice(rs.getInt("bprice"));
				vo.setBcolor(rs.getString("bcolor"));
				vo.setBsize(rs.getString("bsize"));
				vo.setBmaterial(rs.getString("bmaterial"));
				vo.setBorder(rs.getInt("border"));
				vo.setRegdate(rs.getDate("regdate"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 처리 실패.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 오류.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return vo;
	}
	
	public String getRegdate(int bno) {
		String sdate = "";
		try {
			conn = JDBCConnection.getConnection();
			sql = "select to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as sdate from basket where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sdate = rs.getString("sdate");
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 처리 실패.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 오류.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return sdate;
	}
	
	
	
	public int insertBasket(BasketVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into basket values ((select nvl(max(bno), 0)+1 from basket), ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBid());
			pstmt.setInt(2, vo.getBcode());
			pstmt.setString(3, vo.getBname());
			pstmt.setInt(4, vo.getBprice());
			pstmt.setString(5, vo.getBcolor());
			pstmt.setString(6, vo.getBsize());
			pstmt.setString(7, vo.getBmaterial());
			pstmt.setInt(8, vo.getBorder());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 처리 실패.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 오류.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return cnt;
	}
	public int delBasket(int bno) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from basket where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문 처리 실패.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 오류.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return cnt;
	}
}
