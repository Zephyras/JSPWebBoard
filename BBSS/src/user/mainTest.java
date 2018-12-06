package user;

public class mainTest {
//여기서 이 화면 우클릭 하고 run as  java어플리케이션으로 실행하세요
	public static void main(String[] args) {
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
					System.out.println(1); //로그인 성공
				else
					System.out.println(0); //비밀번호 불일치	
			}
			System.out.println(-1); //아이디가 없음
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(-2);//데이터베이스 오류

	}

}
