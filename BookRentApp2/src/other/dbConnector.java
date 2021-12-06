package other;

import java.sql.*;

public class dbConnector {

	Connection conn; // java.sql.Connection
	Statement stmt = null;

	
	public dbConnector() {
		
		// �����ڰ� ����Ǹ� DB�� �ڵ� ����Ǿ� Connection ��ü ����
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://jdb.deu.monster:60001/j20194146",
					"20194146","!!!!20194146");
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}
	}
	
	
	public ResultSet executeQurey(String sql) {
		//SQL�� �����ϱ� ���� �޼ҵ� - Parameter : String��ü�� ���� SQL��
		//�������� ResultSet���� ��ȯ
		
		ResultSet src = null;
		try {
			src = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("SQL ���� ����");
			return null;
		}
		
		return src;
	}
	
	public Connection getConnection() {
		//PreparedStatement�̿��� SQL �ۼ��� ��� Connection ��ü�� �ʿ��� ���� �޼ҵ�
		
		if(conn!=null) {
			return conn;
		}else {
			return null;
		}
		
	}
	
	
	
}
