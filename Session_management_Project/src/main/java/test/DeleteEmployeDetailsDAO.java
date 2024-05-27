package test;
import java.sql.*;
public class DeleteEmployeDetailsDAO {
	public int k=0;
	public int delete(String eid) {
		try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("delete from Employee59 where eid=?");
		ps.setString(1, eid);
		k=ps.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return k;
	}
}
