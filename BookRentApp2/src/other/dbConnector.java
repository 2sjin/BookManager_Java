//

package other;

import java.sql.*;

public class dbConnector {

	Connection conn; // java.sql.Connection
	Statement stmt = null;

	
	public dbConnector() {
		
		// 생성자가 실행되면 DB에 자동 연결되어 Connection 객체 생성
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// MySQL의 JDBC 드라이버 클래스 로드
			conn = DriverManager.getConnection("jdbc:mysql://jdb.deu.monster:60001/java03_team02",
					"java03_team02","whdldl123!");	// 자바 애플리케이션을 JDBC 드라이버에 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();	// SQL문을 실행하기 위해 Statement 객체 생성

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	
	// SQL문 실행하기 위한 메소드 - Parameter : String객체로 만든 SQL문
	// 실행결과는 ResultSet으로 반환
	public ResultSet executeQurey(String sql) {
		ResultSet src = null;
		try {
			src = stmt.executeQuery(sql); // 매개변수로 받은 SQL문 실행
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("SQL 실행 에러");
			return null;
		}
		
		return src;
	}
	
	// 데이터 삽입, 수정, 삭제를 위한 SQL 실행 메소드
	public void executeUpdate(String sql) {
		// SQL문 실행하기 위한 메소드 - Parameter : String객체로 만든 SQL문

		try {
			stmt.executeUpdate(sql); // 매개변수로 받은 SQL문 실행
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	public Connection getConnection() {
		//PreparedStatement이용해 SQL 작성할 경우 Connection 객체가 필요해 만든 메소드
		
		if(conn!=null) {
			return conn;
		}else {
			return null;
		}
		
	}
	
	
	
}
