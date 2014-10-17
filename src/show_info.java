import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class show_info {
	int use_AuthorID;
	public String ISBN;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	private List<Book> l = new ArrayList();
	private List<Author> ls = new ArrayList();
	public List<Author> getLs() {
		return ls;
	}
	public void setLs(List<Author> ls) {
		this.ls = ls;
	}
	public List getL() {
		return l;
	}
	public void setL(List l) {
		this.l = l;
	}
	public String show(){
			get_conn util=new get_conn();
			Connection conn=util.getConnection();
			String sql="select * from book";
			String sql2="select * from author";
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
					if(use.getISBN().equals(this.getISBN())){
						use_AuthorID=use.getAuthorID();
						l.add(use);
						System.out.println("第一处"+use.getISBN()+use.getTitle()+use.getAuthorID());
						flag=0;
					}
				}
				if(flag==1){
					return "0";
				}
			}catch(SQLException e){
				e.printStackTrace();
				return "0";
			}
			try{
				int flag=1;
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql2);
				while(rs.next()){
					Author use=new Author();
					use.setAuthorID(rs.getInt(1));
					use.setName(rs.getString(2));
					use.setAge(rs.getInt(3));
					use.setCountry(rs.getString(4));
					if(use.getAuthorID()==use_AuthorID){
						System.out.println("第二处"+use.getAuthorID()+use.getName()+use.getAge());
						ls.add(use);
						flag=0;
					}
				}
				if(flag==1){
					System.out.println("标记出2");
					return "0";
				}
			}catch(SQLException e){
				e.printStackTrace();
				return "0";
			}finally{
				util.closeConnection(conn);
				return "1";
			}
	}
}
