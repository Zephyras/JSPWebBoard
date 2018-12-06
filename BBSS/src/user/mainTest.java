package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mainTest {
//���⼭ �� ȭ�� ��Ŭ�� �ϰ� run as  java���ø����̼����� �����ϼ���
	private static String userID;
	private static String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs;
		
		
		
		
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
		
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(userPassword))
					System.out.println(1); //�α��� ����
				else
					System.out.println(0); //��й�ȣ ����ġ	
			}
			System.out.println(-1); //���̵� ����
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(-2);//�����ͺ��̽� ����

	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}	
	
}
