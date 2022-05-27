package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;

public class GoodsDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<GoodsVO> getGoodsList(){
		ArrayList<GoodsVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<GoodsVO>();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setGcode(rs.getInt("gcode"));
				vo.setGcategory(rs.getString("gcategory"));
				vo.setGname(rs.getString("gname"));
				vo.setGprice(rs.getInt("gprice"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setGsize(rs.getString("gsize"));
				vo.setGmeterial(rs.getString("gmaterial"));
				vo.setGamount(rs.getInt("gamount"));
				vo.setGcomment(rs.getString("gcomment"));
				vo.setGimg(rs.getString("gimg"));
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
	
	public ArrayList<GoodsVO> getGoodsList(String search){
		ArrayList<GoodsVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods where gname like %?%";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			list = new ArrayList<GoodsVO>();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setGcode(rs.getInt("gcode"));
				vo.setGcategory(rs.getString("gcategory"));
				vo.setGname(rs.getString("gname"));
				vo.setGprice(rs.getInt("gprice"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setGsize(rs.getString("gsize"));
				vo.setGmeterial(rs.getString("gmaterial"));
				vo.setGamount(rs.getInt("gamount"));
				vo.setGcomment(rs.getString("gcomment"));
				vo.setGimg(rs.getString("gimg"));
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
	
	public GoodsVO getGoods(int gcode){
		GoodsVO vo = new GoodsVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from goods where gcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setGcode(rs.getInt("gcode"));
				vo.setGcategory(rs.getString("gcategory"));
				vo.setGname(rs.getString("gname"));
				vo.setGprice(rs.getInt("gprice"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setGsize(rs.getString("gsize"));
				vo.setGmeterial(rs.getString("gmaterial"));
				vo.setGamount(rs.getInt("gamount"));
				vo.setGcomment(rs.getString("gcomment"));
				vo.setGimg(rs.getString("gimg"));
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
	
	public String getRegdate(int code) {
		String sdate = "";
		try {
			conn = JDBCConnection.getConnection();
			sql = "select to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as sdate from goods where gcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
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
	
	
	
	public int insertGoods(GoodsVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into goods values (CODE_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGcategory());
			pstmt.setString(2, vo.getGname());
			pstmt.setInt(3, vo.getGprice());
			pstmt.setString(4, vo.getGcolor());
			pstmt.setString(5, vo.getGsize());
			pstmt.setString(6, vo.getGmeterial());
			pstmt.setInt(7, vo.getGamount());
			pstmt.setString(8, vo.getGcomment());
			pstmt.setString(9, vo.getGimg());
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
	
	public int updateGoods(GoodsVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update goods set gcategory=?, gname=?, gprice=?, gcolor=?, gsize=?, gmaterial=?, gamount=?, gcomment=?, gimg=?, regdate=sysdate;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGcategory());
			pstmt.setString(2, vo.getGname());
			pstmt.setInt(3, vo.getGprice());
			pstmt.setString(4, vo.getGcolor());
			pstmt.setString(5, vo.getGsize());
			pstmt.setString(6, vo.getGmeterial());
			pstmt.setInt(7, vo.getGamount());
			pstmt.setString(8, vo.getGcomment());
			pstmt.setString(9, vo.getGimg());
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
