package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://127.0.0.1:3306/BBSS";
			String dbID = "root";
			String dbPassword = "root5986";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int login(String userID, String userPassword){
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(userPassword))
					return 1; //로그인 성공
				else
					return 0; //비밀번호 불일치	
			}
			return -1; //아이디가 없음
		} catch (Exception e){
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}
	
	public static void main(String[] args) {
		UserDAO() 여기서 호출해서 자바 런해서 확인바람
		
	}
}
