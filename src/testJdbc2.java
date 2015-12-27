import java.sql.*;
/*
 * jdbc��mysql��insert�����룩����
 * author winjayyu
 * 2015��12��27��
 */

public class testJdbc2 {
	public static void main(String[] args) {//argsҪ���ղ������������е�ʱ��Ҫѡ��Run configuraions��,
		                                   //������еĻ���ִ�С�java application�����ᱨ��Ȼ��ִ��ǰ�������
		//�ж��û��ǲ�������4������
		if (args.length != 4) {
			System.out.println("parameter error,please check it and input again!");
			System.exit(-1);//�������˳�
		}

		Connection conn = null;
		Statement stmt = null;

		int id = Integer.parseInt(args[0]);
		String name = args[1];
		String sex = args[2];
		int age = Integer.parseInt(args[3]);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//����Class.forName()����������JDBC��������Driver����DriverManager
			conn = DriverManager.getConnection(
    		"jdbc:mysql://localhost/test?user=root&password=helloworld");//ͨ��JDBC URL���û�������������ȡ��Ӧ�����ݿ�����
			/*stmt = conn.createStatement();
			String sql = "insert into stu values (" + id + ",'" + name + "','" + args[2] + "'," + age + ")";
			stmt.executeUpdate(sql);//ִ��sql���
            */
			
			//�ڶ��ֲ���ķ�����ʹ��ռλ����ռλ�����������׳���
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
