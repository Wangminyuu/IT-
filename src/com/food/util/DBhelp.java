package com.food.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


	/**
	 * 
	 * @author 锟斤拷锟斤拷;
	 * @version 0.0.1  2017-09-05
	 */
public class DBhelp {
	private final String URL="jdbc:mysql://localhost:3307/food";
	private final String USERNAME="root";
	private final String PASSWORD="usbw";
	
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Connection getConn() {
		return conn;
	}
	public PreparedStatement getPs() {
		return ps;
	}
	public ResultSet getRs() {
		return rs;
	}
	/**
	 * 锟斤拷取锟斤拷锟斤拷锟斤拷菘锟侥讹拷锟斤拷
	 * @return Connection锟斤拷锟斤拷;
	 */
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//锟斤拷锟斤拷锟斤拷菘锟�
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;		
	}
	/**
	 * 实锟斤拷锟斤拷删锟侥诧拷锟斤拷
	 * @param sql锟斤拷锟�
	 * @param param锟斤拷锟斤拷值
	 * @return int锟斤拷锟酵ｏ拷int>0锟斤拷示锟斤拷映晒锟� int<0失锟斤拷
	 */
	public int executeUpdate(String sql,Object[] param){
		this.getConnection();	
		try {
		    ps =conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
				ps.setObject(i+1, param[i]);	
				}
			}
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(conn, ps, rs);
		}return 0;
	}
	
	public ResultSet executeQuery(String sql,Object[] param){
		this.getConnection();	
		try {
		    ps =conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
				ps.setObject(i+1, param[i]);	
				}
			}
			rs= ps.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) throws SQLException {
		DBhelp db=new DBhelp();
		
		String sql="select * from admin";
		ResultSet rs=db.executeQuery(sql, null);
		while(rs.next()){
			System.out.println(rs.getString("userName")+" "+rs.getString("password"));		
		}
		db.close(db.getConn(), db.getPs(),db.getRs());
	}
}
//	public static void main(String[] args) {
//		DBhelp db=new DBhelp();
//		Connection conn=db.getConnection();
//		String sql="insert into admin values(default,?,?)";			
//		try {
//			PreparedStatement ps=conn.prepareStatement(sql);//preparedStarement锟斤拷statement 锟斤拷锟皆继筹拷 锟斤拷围锟斤拷 锟斤拷锟斤拷 锟斤拷全锟皆革拷
//			ps.setString(1, "admin01");
//			ps.setString(2, "admin01");
//			int count=ps.executeUpdate();
//			System.out.println(count);
//			ps.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
