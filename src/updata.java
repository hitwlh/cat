import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class updata {
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private double Price;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String updata(){
		return "0";
	}
	public String update(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql1="update book set Title="+"'"+Title+"'"+ "where ISBN="+"'"+ISBN+"'";
			String sql2="update book set AuthorID="+"'"+AuthorID+"'"+ "where ISBN="+"'"+ISBN+"'";
			String sql3="update book set Publisher="+"'"+Publisher+"'"+ "where ISBN="+"'"+ISBN+"'";
			String sql4="update book set PublishDate="+"'"+PublishDate+"'"+ "where ISBN="+"'"+ISBN+"'";
			String sql5="update book set Price="+"'"+Price+"'"+ "where ISBN="+"'"+ISBN+"'";
			System.out.println(sql1);
			stmt.execute(sql1);
			System.out.println(sql2);
			stmt.execute(sql2);
			System.out.println(sql3);
			stmt.execute(sql3);
			System.out.println(sql4);
			stmt.execute(sql4);
			System.out.println(sql5);
			stmt.execute(sql5);
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
