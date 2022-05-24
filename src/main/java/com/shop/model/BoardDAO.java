package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.BoardVO;
import com.shop.common.JDBCConnection;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<BoardVO> getBordList(){
		ArrayList<BoardVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setNote(rs.getString("note"));
				vo.setNickname(rs.getString("nickname"));
				vo.setIndate(rs.getDate("indate"));
				vo.setVisited(rs.getInt("visited"));
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
	
	public BoardVO getBoard(int seq) {
		BoardVO vo = new BoardVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setNickname(rs.getString("nickname"));
				vo.setNote(rs.getString("note"));
				vo.setIndate(rs.getDate("indate"));
				vo.setVisited(rs.getInt("visited"));
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
	public int addBoard(BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into board values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getNickname());
			pstmt.setString(3, vo.getNote());
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
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int editBoard(BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update board set title=?, note=? indate=sysdate where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getNote());
			pstmt.setInt(3, vo.getSeq());
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
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int delBoard(BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from board where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSeq());
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
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}
