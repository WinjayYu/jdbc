import java.sql.*;


public class testJdbc {

	/**
	 * jdbc对mysql的select（查询）操作
	 * author winjayyu
	 * 2015年12月27日
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		  try {
	            Class.forName("com.mysql.jdbc.Driver");//利用Class.forName()方法来加载JDBC驱动程序（Driver）至DriverManager
	            conn = DriverManager.getConnection(
	            		"jdbc:mysql://localhost/test?user=root&password=helloworld");//通过JDBC URL，用户名，密码来获取相应的数据库连接
	            stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from stu");//select查询的结果存放在rs中
                while(rs.next()){
                	System.out.print(rs.getString("name"));
                	System.out.print(" ");
                	System.out.println(rs.getString("age"));
                }
	        } catch(ClassNotFoundException e){
	        	e.printStackTrace();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }finally{
	        	if(conn != null){
	        		try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	        	}
	        	if(stmt != null) {
	        		try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	        	}
	        }
    }

}
