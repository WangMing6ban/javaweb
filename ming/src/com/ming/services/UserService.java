package com.ming.services;

import java.awt.SystemColor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ming.beans.Address;
import com.ming.beans.User;
import com.ming.dao.UserDao;

import jdk.management.cmm.SystemResourcePressureMXBean;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	@Transactional
	public void insert(User user) {
		userdao.insert(user);
	}
	@Transactional
	public int selet(String name) {
		System.out.println(name);
		int a=userdao.selectByUsername(name);
		System.out.println(a);
		return a;
	}
	public boolean sendMail(String email,HttpServletResponse response) {
		boolean flag=false;
		String fm="zhangsan_email@163.com";
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.163.com");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		Authenticator auth=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fm,"zhangsan163sqm");
			}
		};
		Session mailSession=Session.getInstance(props,auth);
		mailSession.setDebug(true);
		Message msg=new MimeMessage(mailSession);
		try {
			msg.setFrom(new InternetAddress(fm));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			msg.setSubject("激活注册ming");
			msg.setSentDate(new Date());
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent("<a href=\"http://localhost:8080/ming/user/jihuojsp.jsp\">点击进行激活</a>","text/html;charset=UTF-8");
			MimeMultipart mm = new MimeMultipart();
			mm.addBodyPart(mbp);
			msg.setContent(mm);
			Transport.send(msg);
			flag=true;
		}catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	@Transactional
	public boolean login(String user_username,String user_passwd) {
		
		boolean flag=false;
		flag=userdao.selectBynaem(user_username,user_passwd);
		return flag;
			
	}
	@Transactional
	public void xiangxi(String textarea,int id) {
		System.out.println("详细服务");
		userdao.xiangxi(textarea,id);
	}
	@Transactional
	//sessin 中的用户名邮箱查用户
	public User selectByName(String user_username) {
		User user=new User();
		user=userdao.selectByname(user_username);
		return user;
			
	}
	//删除用户的所有订单
	@Transactional
	public boolean deleteOrders(int user_id) {
		userdao.deleteOrders(user_id);
		return true;
	}
	//修改密码
	@Transactional
	public boolean xiugaipass(String password,int id) {
		userdao.xiugaipass(password,id);
		return true;
	}
	//添加收获地址
	@Transactional
	public Set<Address> addaddress(Address address,int id) {
		
		return userdao.addaddress(address, id);
	}
	//修改收货地址
	@Transactional
	public void updatadd(String tele,String telee) {
		
		userdao.updatadd(tele,telee);
	}
	//查询地址
	@Transactional
	public Set<Address> seleaddress(int id){
		return userdao.seleaddress(id);
	}
	//删除收货地址
	@Transactional
	public void deletadd(int id) {
		
		userdao.deletadd(id);
	}
	//查询所有用户
	@Transactional
	public List<User> viewuser(){
		return userdao.viewuser();
	}
	//删除用户
	@Transactional
	public void deleteuser(int id) {
		userdao.deleteuser( id);
	}
	//后台修改用户
	@Transactional
	public User selectByNaps(int id) {
		return userdao.selectByNaps(id);
	}
	
}
