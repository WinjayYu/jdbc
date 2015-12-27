import java.sql.*;

/*
 * jdbc对mysql的delete（删除）操作
 *author winjayyu
 *2015年12月27日
 */
public class testJdbc3 {
	public static void main(String [] args) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		int id = Integer.parseInt(args[0]);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=helloworld");
			ps = conn.prepareStatement("delete from stu where id = ?");
			ps.setInt(1,id);
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
