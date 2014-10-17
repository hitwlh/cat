import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
public class addauthor {
	private int AuthorID;
	private String Name;
	public int getAuthorID() {
		String name="1212a";
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		int a=1;
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getAge() {
		return Age;
	}
	public void setAge(double age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	private double Age;
	private String Country;
	public String add(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into author(AuthorID,Name,Age,Country) " +
					"values("+AuthorID+","+"'"+Name+"'"+","+Age+","+"'"+Country+"'"+")";
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