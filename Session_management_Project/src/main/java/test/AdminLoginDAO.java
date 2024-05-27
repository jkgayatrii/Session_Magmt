package test;

import java.sql.*;
public class AdminLoginDAO  {
	public AdminBean ab=null;
	public AdminBean login(String uname,String pword) {
		
			try {
				Connection con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from EmpAdmin59 where uname=? and pword=?");
				ps.setString(1, uname);
				ps.setString(2, pword);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					ab=new AdminBean();
					ab.setuName(rs.getString(1));
					ab.setPword(rs.getString(2));
					ab.setfName(rs.getString(3));
					ab.setlName(rs.getString(4));
					ab.setAddr(rs.getString(5));
					ab.setmId(rs.getString(6));
					ab.setPhNo(rs.getLong(7));
					
					
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
		
	}
}
