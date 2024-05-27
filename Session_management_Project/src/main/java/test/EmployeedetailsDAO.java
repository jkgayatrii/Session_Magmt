package test;
import java.sql.*;
public class EmployeedetailsDAO {
	public EmployeeBean eb=null;
	public EmployeeBean login(String eid) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Employee59 where eid=?");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				eb=new EmployeeBean();
				eb.seteId(rs.getString(1));
				eb.seteName(rs.getString(2));
				eb.seteDesg(rs.getString(3));
				eb.setbSal(Integer.parseInt(rs.getString(4)));
				eb.setHra(Float.parseFloat(rs.getString(5)));
				eb.setDa(Float.parseFloat(rs.getString(6)));
				eb.setTotsal(Float.parseFloat(rs.getString(7)));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return eb;
	}
}
