import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
public class createable {
	public static void main(String[] args){
		createable s1=new createable();
		//s1.create();
		s1.add();
		//s1.delete();
		//s1.update();
	}
//������
	public void create(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="create table ssssss1(id int)";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
//������
//��ѯԪ��
	public void list(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		String sql="select * from book";
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String ISBN=rs.getString(1);
				String Title=rs.getString(2);
				int AuthorID=rs.getInt(3);
				String Publisher=rs.getString(4);
				String PublishDate=rs.getString(5);
				double Price=rs.getDouble(6);
				System.out.println(ISBN+" "+Title+" "+AuthorID+" "+Publisher+" "+PublishDate+" "+Price);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
//��ѯԪ��
//����Ԫ��
	public void add(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="insert into author (AuthorID,Name,Age,Country) values (111,'grg',1,'chi')";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
//����Ԫ��
//ɾ��Ԫ��
	public void delete(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="delete from ssssss1 where id=2";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
//ɾ��Ԫ��	
//�޸�Ԫ��
	public void update(){
		get_conn util=new get_conn();
		Connection conn=util.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="update ssssss1 set id=10 where id=1";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
	}
//�޸�Ԫ��
}
