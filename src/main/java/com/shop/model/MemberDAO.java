package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.shop.common.JDBCConnection;
import com.shop.common.MemberVO;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	
	public ArrayList<MemberVO> getMemberList(){
		ArrayList<MemberVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from Member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMaddress(rs.getString("maddress"));
				vo.setMlank(rs.getInt("mlank"));
				vo.setMpoint(rs.getInt("mpoint"));
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
	
	public ArrayList<MemberVO> JSONMemberList(){
		ArrayList<MemberVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select mid, mpw, mname, maddress, mlank, mpoint, to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as sdate from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMaddress(rs.getString("maddress"));
				vo.setMlank(rs.getInt("mlank"));
				vo.setMpoint(rs.getInt("mpoint"));
				vo.setSdate(rs.getString("sdate"));
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
	
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMaddress(rs.getString("maddress"));
				vo.setMlank(rs.getInt("mlank"));
				vo.setMpoint(rs.getInt("mpoint"));
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
	
	public MemberVO JSONMember(String id){
		MemberVO vo = new MemberVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select mid, mpw, mname, maddress, mlank, mpoint, to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as sdate from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMaddress(rs.getString("maddress"));
				vo.setMlank(rs.getInt("mlank"));
				vo.setMpoint(rs.getInt("mpoint"));
				vo.setSdate(rs.getString("sdate"));
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
	
	public int addMember (MemberVO vo){
		//인코딩해야함
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into member values(?, ?, ?, ?, 9, 100, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMaddress());
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
	
	public int loginMember (String id, String pw) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String mpw = rs.getString("mpw");

				if(mpw.equals(pw)) {
					cnt = 1;
				}
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
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int editMember(MemberVO vo){
		//인코딩해야함
		try {
			conn = JDBCConnection.getConnection();
			sql = "update member set mname=?, maddress=? where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMname());
			pstmt.setString(2, vo.getMaddress());
			pstmt.setString(3, vo.getMid());
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
