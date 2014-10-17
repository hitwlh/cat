import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class addbook {
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private String PublishDate;
	private double Price;
	public String getISBN() {
		String name="1212a";
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
		int a=9;
		Price = price;
	}


	public String add(){
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) " +
					"values("+"'"+ISBN+"'"+","+"'"+Title+"'"+","+AuthorID+","+"'"+Publisher+"'"+","+"'"+PublishDate+"'"+","+Price+")";
			String sql2="select * from author";
			stmt.execute(sql2);
			try{
				ResultSet rs=stmt.executeQuery(sql2);
				while(rs.next()){
					System.out.println(sql2);
					int AuthorID2=rs.getInt(1);
					if(AuthorID2==AuthorID){
						stmt.execute(sql);
						return "2";
					}
				}
				stmt.execute(sql);
				return "1";
			}catch(SQLException e){
				e.printStackTrace();
			}
			return "0";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}finally{
			util.closeConnection(conn);
		}
	}
	}