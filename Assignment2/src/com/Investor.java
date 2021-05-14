package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Investor {
	// DB Connection
				public Connection connect() {
					Connection con = null;

					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/invest", "root", "");

						// For testing
						System.out.print("DB Successfully connected");
					}

					catch (Exception e) {
						e.printStackTrace();
						System.out.print("DB not connected");
					}

					return con;
					
				}
				
				//insert
				public String insertinvestor(String investorName, String Mail,String ProjectCode,String ProjectName,String InvestAmount) {

					String output = "";

					try {
						
						Connection con = connect();
							if (con == null) {
							return "Error while connecting to the database for inserting";
						}

						// create a prepared statement
						String query = " insert into invest1 values (?, ?, ?, ?, ?, ?)";
						PreparedStatement preparedStmt = con.prepareStatement(query);

						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, investorName);
						preparedStmt.setString(3, Mail);
						preparedStmt.setString(4, ProjectCode);
						preparedStmt.setString(5, ProjectName);
						preparedStmt.setDouble(6, Double.parseDouble(InvestAmount));
						
					

						// execute the statement
						preparedStmt.execute();
						con.close();
						
						//output = "Insertion successful";
						String newItems = readInvestor(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newItems + "\"}";
						

					} catch (Exception e) {
						//output = "Insertion failure";
						output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
						System.err.println(e.getMessage());
					}
					return output;
				}
				
				//read
				public String readInvestor() {

					String output = "";

					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for reading.";
						}

						// Prepare the html table to be displayed
						output = "<table border='1'><tr><th> Investor Name </th>"
								+" <th> Mail </th> "
								+" <th> Project Code </th> " 
								+" <th> Project Name </th> "  
								+" <th> Invest Amount </th> "
								+ " <th> ACTION </th> "
								+ " <th> ACTION </th></tr> ";

						String query = "select * from invest1";
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);

						// iterate through the rows in the result set
						while (rs.next()) {

							String investorID  = Integer.toString(rs.getInt("investorID"));
							String investorName = rs.getString("investorName");
							String Mail = rs.getString("Mail");
							String ProjectCode = rs.getString("ProjectCode");
							String ProjectName = rs.getString("ProjectName");
							String InvestAmount = Double.toString(rs.getDouble("InvestAmount"));
							
						
							

							// Add into the html table
							output += "<tr><td>"+ investorName + "</td>";
							output += "<td>" + Mail  + "</td>";
							output += "<td>" + ProjectCode + "</td>";
							output += "<td>" + ProjectName + "</td>";
							output += "<td>" + InvestAmount + "</td>";
							
							//buttons
							output += "<td><input name='btnUpdate' type='button' value='Update' "
									+ "class='btnUpdate btn btn-secondary' data-itemid='" + investorID + "'></td>"
									+ "<td><input name='btnRemove' type='button' value='Remove' "
									+ "class='btnRemove btn btn-danger' data-itemid='" + investorID + "'></td></tr>";
						}

						con.close();

						// Complete the html table
						output += "</table>";

					} 
					
					catch (Exception e) {
						output = "Error while reading the investors.";
						System.err.println(e.getMessage());
					}
					return output;
				}
				
				// Update
				public String updateInvestor(String investorID, String investorName, String Mail, String ProjectCode,String ProjectName,String InvestAmount) {

					String output = "";

					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for updating.";
						}

						// create a prepared statement
						String query = "UPDATE invest1 SET investorName=?,Mail=?,ProjectCode=?,ProjectName=?,InvestAmount=? WHERE investorID=?";
						PreparedStatement preparedStmt = con.prepareStatement(query);

						// binding values
						
						preparedStmt.setString(1, investorName);
						preparedStmt.setString(2, Mail);
						preparedStmt.setString(3, (ProjectCode));
						preparedStmt.setString(4, ProjectName);
						preparedStmt.setDouble(5, Double.parseDouble(InvestAmount));
						preparedStmt.setInt(6, Integer.parseInt(investorID)); 
						
						// execute the statement
						preparedStmt.execute();
						con.close();
						
						//output = " Updated Successfully";
						String newItems = readInvestor(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newItems + "\"}";

					} catch (Exception e) {
						//output = "Error while updating the project .";
						output = "{\"status\":\"error\", \"data\":  \"Error while updating the item.\"}"; 
						System.err.println(e.getMessage());
						
					}
					
					return output;
				}
				
				
				// Delete
				public String deleteinvestor(String investorID) {
					String output = "";

					try {
						Connection con = connect();
						if (con == null) {
							return "Error while connecting to the database for deleting.";
						}

						// create a prepared statement
						String query = "delete from invest1 where investorID=?";
						PreparedStatement preparedStmt = con.prepareStatement(query);

						// binding values
						preparedStmt.setInt(1, Integer.parseInt(investorID));

						// execute the statement
						preparedStmt.execute();
						con.close();
						//output = "Deleted successfully";
						
						String newItems = readInvestor(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newItems + "\"}";

					} 
						catch (Exception e) {
							//output = "Error while deleting the investor Details.";
							output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
							System.err.println(e.getMessage());
					}
					return output;
				}
}
