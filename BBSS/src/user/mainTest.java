package user;

public class mainTest {
//���⼭ �� ȭ�� ��Ŭ�� �ϰ� run as  java���ø����̼����� �����ϼ���
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

}
