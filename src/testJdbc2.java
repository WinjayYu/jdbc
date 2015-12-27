import java.sql.*;
/*
 * jdbc对mysql的insert（插入）操作
 * author winjayyu
 * 2015年12月27日
 */

public class testJdbc2 {
	public static void main(String[] args) {//args要接收参数，所以运行的时候要选择“Run configuraions”,
		                                   //如果不行的话先执行“java application”，会报错，然后执行前面的命令
		//判断用户是不是输入4个参数
		if (args.length != 4) {
			System.out.println("parameter error,please check it and input again!");
			System.exit(-1);//非正常退出
		}

		Connection conn = null;
		Statement stmt = null;

		int id = Integer.parseInt(args[0]);
		String name = args[1];
		String sex = args[2];
		int age = Integer.parseInt(args[3]);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//利用Class.forName()方法来加载JDBC驱动程序（Driver）至DriverManager
			conn = DriverManager.getConnection(
    		"jdbc:mysql://localhost/test?user=root&password=helloworld");//通过JDBC URL，用户名，密码来获取相应的数据库连接
			/*stmt = conn.createStatement();
			String sql = "insert into stu values (" + id + ",'" + name + "','" + args[2] + "'," + age + ")";
			stmt.executeUpdate(sql);//执行sql语句
            */
			
			//第二种插入的方法，使用占位符先占位，这样不容易出错
			PreparedStatement ps = conn.prepareStatement("insert into stu values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setInt(4, age);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
