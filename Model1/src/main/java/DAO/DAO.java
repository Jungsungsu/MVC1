package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	int cnt = 0;
	   Connection conn = null;   
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   MemberVO vo = null;
	   
	   // �޼��带 ���� data base ���� �ڵ� ����
	   // ctrl + shift + o
	   
	   // connection
	   public void connection() {
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url = "jdbc:oracle:thin:@localhost:1521:xe";
	         String dbid = "hr";
	         String dbpw = "hr";
	         conn = DriverManager.getConnection(url, dbid, dbpw);
	         
	      } catch (Exception e) {
	         // TODO: handle exception
	      }
	      
	   }
	   // ================================================
	   
	   // close
	   public void close() {
	      try {
	         if( rs != null){
	            rs.close();
	         }
	         if( psmt != null){
	            psmt.close();
	         }
	         if(conn != null){
	            conn.close();
	         }
	      } catch (Exception e2) {
	         // TODO: handle exception
	      }
	   }
	   
	   // 1. login
	   public MemberVO login(String id, String pw) {
	      
	      try{
	      
	      connection();
	      
	      String sql = "select * from jdbc_member where id = ? and pw = ?";
	      
	      psmt = conn.prepareStatement(sql);
	      
	      psmt.setString(1, id); // (���° ����ǥ����, ����� ����������)
	      psmt.setString(2, pw);
	      
	      rs =  psmt.executeQuery();
	      
	      if(rs.next() == true) {
	         // �α��� ����
	         String userId = rs.getString("id"); // �÷� �̸� or �÷� �ε���
	         String userPw = rs.getString(2);
	         String userNick = rs.getString(3);
	         
	         vo = new MemberVO(userId, userPw, userNick);
	      }
	      
	      
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         close();
	      }
	      return vo;
	   }
	   // =====================================
	   
	   
	   // 2. Join
	   public int Join(String id, String pw, String nick){
	      
	      try{
	      connection();
	      
	      // 3. sql�� �غ�
	      String sql = "insert into jdbc_member values(?, ?, ?)";
	      
	      // 4. PreparedStatement ��ü �غ�
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. ���ε庯�� ä���
	      psmt.setString(1, id); // (���° ����ǥ����, ����� ����������)
	      psmt.setString(2, pw);
	      psmt.setString(3, nick);
	      
	      // ����
	      // executeQuery() : select���϶���!
	      // executeUpdate() : update / insert / delete : DB�� ��ȭ������� ��û
	      cnt = psmt.executeUpdate();
	      // ResultSet
	      // rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false
	      
	      }catch(Exception e){
	         
	      }finally{
	         close();
	      }
	      
	      return cnt;
	   }
	   // =====================================


}
