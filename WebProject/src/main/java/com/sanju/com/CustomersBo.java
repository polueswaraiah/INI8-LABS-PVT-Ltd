package com.sanju.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomersBo  implements CustomersInterface{
	    private static Connection  connection;
	    private static PreparedStatement pStatement;
	    private static  ResultSet resultSet;
	    private static Statement statement;
	    private static final  String INSERTQUERY = "insert into  mycustomers (Id, Name, Email, Address, City) values (?, ?, ?, ?, ?)"; 
	    private static final  String UPDATQUERY = "Update mycustomers set `Name` = ?, `Email` = ?, `Address` = ?, `City` = ?  where  Id = ?";
	    private static final  String DELETEQUERY = " Delete from mycustomers  where Id = ? ";
	    private static final String  SELECTBYID = " Select * from  mycustomers where Id = ? ";
	    private static final String SELECTQUERY = " Select * from  mycustomers";
	     
//	create constructor to call Connection....
	public CustomersBo() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sanju@71");	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	InsertCustomers Details...
@Override
public int insertCust(Customers cus) {
	       try {
			 pStatement = connection.prepareStatement(INSERTQUERY);
			 pStatement.setInt(1, cus.getC_Id());
			 pStatement.setString(2, cus.getC_Name());
			 pStatement.setString(3, cus.getC_email());
			 pStatement.setString(4, cus.getC_Address());
			 pStatement.setString(5, cus.getC_city());
			 return pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return 0;
}
//UpdateCustomers Details.....
@Override
public int upadteCust(Customers cus) {
	          try {
			 pStatement = connection.prepareStatement(UPDATQUERY);
			 pStatement.setString(1, cus.getC_Name());
			 pStatement.setString(2, cus.getC_email());
			 pStatement.setString(3, cus.getC_Address());
			 pStatement.setString(4, cus.getC_city());
			 pStatement.setInt(5, cus.getC_Id());
				  return  pStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	return 0;
}

@Override
public int delete(int C_Id) {
	int status = 0;
	 try {
		pStatement = connection.prepareStatement(DELETEQUERY);
		 pStatement.setInt(1, C_Id);
		  status = pStatement.executeUpdate();
//		 return status;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return status;
}

@Override
public int delete(Customers cus) {
	return  delete(cus.getC_Id());
}

@Override
public Customers getcust(int Id) {
	try {
		pStatement = connection.prepareStatement(SELECTBYID);
		 pStatement.setInt(1, Id);
		 resultSet = pStatement.executeQuery();
		  if ( resultSet.next()) {
			 int id = resultSet.getInt("Id");   
			String ename = resultSet.getString("Name");		 
			String email = resultSet.getString("Email");	
			String Address = resultSet.getString("Address");	
			String city = resultSet.getString("City");	
		     return new Customers(id, ename, email, Address, city);
		  }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

@Override
public List<Customers> getAll() {
	 List<Customers> list = new ArrayList<>();
	 try {
		statement = connection.createStatement();
		 resultSet = statement.executeQuery(SELECTQUERY);
		 while( resultSet.next()) {
			 int id = resultSet.getInt("Id");   
				String ename = resultSet.getString("Name");		 
				String email = resultSet.getString("Email");	
				String Address = resultSet.getString("Address");	
				String city = resultSet.getString("City");	
			     list.add(new Customers(id, ename, email, Address, city));
		 }

	} catch (SQLException e) {
		e.printStackTrace();
	}   
	return list;
}
}
