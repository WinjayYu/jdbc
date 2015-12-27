import java.sql.*;


public class testJdbc {

	/**
	 * jdbc��mysql��select����ѯ������
	 * author winjayyu
	 * 2015��12��27��
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		  try {
	            Class.forName("com.mysql.jdbc.Driver");//����Class.forName()����������JDBC��������Driver����DriverManager
	            conn = DriverManager.getConnection(
	            		"jdbc:mysql://localhost/test?user=root&password=helloworld");//ͨ��JDBC URL���û�������������ȡ��Ӧ�����ݿ�����
	            stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from stu");//select��ѯ�Ľ�������rs��
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
