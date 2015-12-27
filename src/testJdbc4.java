
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * jdbc对mysql的update（修改）操作
 *author winjayyu
 *2015年12月27日
 */
public class testJdbc4 {
	public static void main(String [] args) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		String name = args[0];
		int id = Integer.parseInt(args[1]);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=helloworld");
			ps = conn.prepareStatement("update stu set name = ? where id = ?");
			ps.setString(1,name);
			ps.setInt(2,id);
			ps.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			}finally {
				try{
					if(conn != null) {
						conn.close();
					}
					if(ps != null) {
						ps.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
}
