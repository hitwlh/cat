import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import	java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class show_by_author {
	private List<Book> l = new ArrayList();
	public List getL() {
		return l;
	}

	public void setL(List l) {
		this.l = l;
	}
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

	public String list(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		String sql="select * from book";
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int flag=1;
			while(rs.next()){
				Book use=new Book();
				use.setISBN(rs.getString(1));
				use.setTitle(rs.getString(2));
				use.setAuthorID(rs.getInt(3));
				use.setPublisher(rs.getString(4));
				use.setPublishDate(rs.getString(5));
				use.setPrice(rs.getDouble(6));
				if(use.getAuthorID()==AuthorID){
					flag=0;
					l.add(use);
					System.out.println(AuthorID+":::"+use.getISBN() +'+'+ use.getTitle() +'+'+use.getAuthorID()+'+'+use.getPublisher()+'+'+use.getPublishDate()+'+'+use.getPrice());
					System.out.println(getISBN() +'+'+ getTitle() +'+'+getAuthorID()+'+'+getPublisher()+'+'+getPublishDate()+'+'+getPrice());
				}
			}
			if(flag==0)
				return "1";
			else 
				return "0";
		}catch(SQLException e){
			e.printStackTrace();
			return "0";
		}finally{
			util.closeConnection(conn);
		}
	}
}
