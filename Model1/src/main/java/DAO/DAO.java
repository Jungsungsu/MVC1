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
	   
	   // 메서드를 만들어서 data base 접근 코드 관리
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
	      
	      psmt.setString(1, id); // (몇번째 물음표인지, 어떤값을 넣을것인지)
	      psmt.setString(2, pw);
	      
	      rs =  psmt.executeQuery();
	      
	      if(rs.next() == true) {
	         // 로그인 성공
	         String userId = rs.getString("id"); // 컬럼 이름 or 컬럼 인덱스
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
	      
	      // 3. sql문 준비
	      String sql = "insert into jdbc_member values(?, ?, ?)";
	      
	      // 4. PreparedStatement 객체 준비
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. 바인드변수 채우기
	      psmt.setString(1, id); // (몇번째 물음표인지, 어떤값을 넣을것인지)
	      psmt.setString(2, pw);
	      psmt.setString(3, nick);
	      
	      // 실행
	      // executeQuery() : select문일때만!
	      // executeUpdate() : update / insert / delete : DB에 변화가생기는 요청
	      cnt = psmt.executeUpdate();
	      // ResultSet
	      // rs.next() : 다음 데이터가 있다면 true / 없으면 false
	      
	      }catch(Exception e){
	         
	      }finally{
	         close();
	      }
	      
	      return cnt;
	   }
	   // =====================================


}
