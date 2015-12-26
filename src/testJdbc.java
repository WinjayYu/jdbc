import java.sql.*;

public class testJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		  try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(
	            		"jdbc:mysql://localhost/test?user=root&password=helloworld");
	            stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from stu");
                while(rs.next()){
                	System.out.print(rs.getString("name"));
                	System.out.print(" ");
                	System.out.println(rs.getString("age"));
                }
	        } catch(ClassNotFoundException e){
	        	e.printStackTrace();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}

}
