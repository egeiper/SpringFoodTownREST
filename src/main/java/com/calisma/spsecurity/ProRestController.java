package com.calisma.spsecurity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import props.AdminPro;
import props.BlogPro;
import props.CartPro;
import props.ContactUsPro;
import props.FoodsPro;
import props.NewOrderPro;
import props.UserPro;

@RestController

public class ProRestController {
	
	@Autowired DriverManagerDataSource dataSource;
	
	
	
	@RequestMapping(value = "/allAdmins", method = RequestMethod.GET)
	public HashMap<String, Object> allAdmins() {
		HashMap<String, Object> hm = new HashMap<>();
		List<AdminPro> ls = new ArrayList<AdminPro>();
		try {
			String query = "select * from admin";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				AdminPro ac = new AdminPro();
				ac.setAid(rs.getInt("aid"));
				ac.setAname(rs.getString("aname"));
				ac.setAmail(rs.getString("amail"));
				ac.setApass(rs.getString("apass"));
				ac.setRole(rs.getString("role"));
				ls.add(ac);
			}
			hm.put("adminlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allBlogs", method = RequestMethod.GET)
	public HashMap<String, Object> allBlogs() {
		HashMap<String, Object> hm = new HashMap<>();
		List<BlogPro> ls = new ArrayList<BlogPro>();
		try {
			String query = "select * from blog";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				BlogPro ac = new BlogPro();
				ac.setPostid(rs.getInt("postid"));
				ac.setPosttitle(rs.getString("posttitle"));
				ac.setPosttext(rs.getString("posttext"));
				ac.setPostimage(rs.getString("postimage"));
				ac.setPostauthorimage(rs.getString("postauthorimage"));
				ac.setPostdate(rs.getString("postdate"));
				ac.setPostauthor(rs.getString("postauthor"));
				ac.setPosttextparagraph1(rs.getString("posttextparagraph1"));
				ac.setPosttextparagraph2(rs.getString("posttextparagraph2"));
				ls.add(ac);
			}
			hm.put("bloglist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allCarts", method = RequestMethod.GET)
	public HashMap<String, Object> allCarts() {
		HashMap<String, Object> hm = new HashMap<>();
		List<CartPro> ls = new ArrayList<CartPro>();
		try {
			String query = "select * from cart";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				CartPro ac = new CartPro();
				ac.setCartid(rs.getInt("cartid"));
				ac.setFoodname(rs.getString("foodname"));
				ac.setFoodprice(rs.getInt("foodprice"));
				ac.setFoodstatus(rs.getString("foodstatus"));
				ls.add(ac);
			}
			hm.put("cartlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allContacts", method = RequestMethod.GET)
	public HashMap<String, Object> allContacts() {
		HashMap<String, Object> hm = new HashMap<>();
		List<ContactUsPro> ls = new ArrayList<ContactUsPro>();
		try {
			String query = "select * from contactus";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				ContactUsPro ac = new ContactUsPro();
				ac.setContactid(rs.getInt("contactid"));
				ac.setNamesurname(rs.getString("namesurname"));
				ac.setMail(rs.getString("mail"));
				ac.setMessage(rs.getString("message"));
				
				ls.add(ac);
			}
			hm.put("contactlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public HashMap<String, Object> allProducts() {
		HashMap<String, Object> hm = new HashMap<>();
		List<FoodsPro> ls = new ArrayList<FoodsPro>();
		try {
			String query = "select * from foods";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				FoodsPro ac = new FoodsPro();
				ac.setFoodid(rs.getInt("foodid"));
				ac.setFoodname(rs.getString("foodname"));
				ac.setFoodtext(rs.getString("foodtext"));
				ac.setFoodprice(rs.getInt("foodprice"));
				ac.setFoodimage(rs.getString("foodimage"));
				ls.add(ac);
			}
			hm.put("productlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allNeworders", method = RequestMethod.GET)
	public HashMap<String, Object> allNeworders() {
		HashMap<String, Object> hm = new HashMap<>();
		List<NewOrderPro> ls = new ArrayList<NewOrderPro>();
		try {
			String query = "select * from neworder";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				NewOrderPro ac = new NewOrderPro();
				ac.setOrderid(rs.getInt("orderid"));
				ac.setFullname(rs.getString("fullname"));
				ac.setAddress(rs.getString("address"));
				ac.setFoodname(rs.getString("foodname"));
				ac.setFoodstatus(rs.getString("foodstatus"));
				ac.setPhonenumber(rs.getString("phonenumber"));
				ac.setNote(rs.getString("note"));
				ac.setTotalprice(rs.getInt("totalprice"));
				ls.add(ac);
			}
			hm.put("orderlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public HashMap<String, Object> allUsers() {
		HashMap<String, Object> hm = new HashMap<>();
		List<UserPro> ls = new ArrayList<UserPro>();
		try {
			String query = "select * from users";
			PreparedStatement pre = dataSource.getConnection().prepareStatement(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				UserPro ac = new UserPro();
				ac.setUserid(rs.getInt("userid"));
				ac.setUsermail(rs.getString("usermail"));
				ac.setUserpassword(rs.getString("userpassword"));
				ac.setUsername(rs.getString("username"));
				
				ls.add(ac);
			}
			hm.put("userlist", ls);
			
		} catch (Exception e) {
			System.err.println("DB Error : " + e);
		}
		
		return hm;
	}
	
}
