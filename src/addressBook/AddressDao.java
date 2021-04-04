package addressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressDao {

	String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";
//	String id = "sbsst"; 
//	String pw = "sbs123414";
	String id = "root"; 
	String pw = "";
	
	Scanner sc = new Scanner(System.in);

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pw); // 연결.
		
		return conn;
	}
	
	public void insertArticle() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		System.out.println("이름을 입력해주세요 :");
		String name = sc.next();
		System.out.println("주소를 입력해주세요 :");
		String address = sc.next();
		System.out.println("전화번호를 입력해주세요 :");
		int phoneNumber = sc.nextInt();
		
		String sql = "insert into Address set `name` = '" + name + "', address='" + address + "', phoneNumber='" + phoneNumber + "' ";
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
		close(stmt, conn);
		
	}
	
	public ArrayList<Address> selectAddress() throws ClassNotFoundException, SQLException {
	
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM article";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		
		ArrayList<Address> Addresses = new ArrayList<>();
		
		while (rs.next()) {
			String name = rs.getString("name"); 
			String address = rs.getString("address");  
			int phoneNumber = rs.getInt("phoneNumber");  
			
			Address a = new Address(name, address, phoneNumber);
			Addresses.add(a);
			
		}

		close(rs, stmt, conn);
		
		return Addresses;
	}
	public ArrayList<Address> selectAddressByName() throws SQLException, ClassNotFoundException {
		
		Connection conn = getConnection();
		
		System.out.println("이름을 입력해주세요 :");
		String name = sc.nextLine();

		String sql = "SELECT * FROM article WHERE `name` = " + name ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		
		ArrayList<Address> Addresses = new ArrayList<>();
		
		while (rs.next()) {
			String name1 = rs.getString("name"); 
			String address = rs.getString("address");  
			int phoneNumber = rs.getInt("phoneNumber");  
			
			Address a = new Address(name1, address, phoneNumber);
			Addresses.add(a);
			
		}

		close(rs, stmt, conn);
		
		return Addresses;
		
	}
	
	private void close(Statement stmt, Connection conn) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
	
	private void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		close(stmt, conn);
	}

	public void modifyAddress() {
		// TODO Auto-generated method stub
		
	}

	public void deleteAddress() {
		// TODO Auto-generated method stub
		
	}


}
