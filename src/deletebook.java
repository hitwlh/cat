import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deletebook {
	public String ISBN;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String delete(){
			get_conn util=new get_conn();
			Connection conn=util.getConnection();
			System.out.println("delete from book where ISBN="+"'"+ISBN+"'");
			try {
				Statement stmt=conn.createStatement();
				String sql="delete from book where ISBN="+"'"+ISBN+"'";
				stmt.execute(sql);
				return "1";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "0";
			}finally{
				util.closeConnection(conn);
			}
	}
}