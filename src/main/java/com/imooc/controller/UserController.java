package com.imooc.controller;

import java.beans.Encoder;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.plaf.synth.SynthInternalFrameUI;
import javax.ws.rs.Encoded;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSInput;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.imooc.pojo.User;
import com.imooc.service.IUserService;
  
@Controller  
@RequestMapping("/user")  
// /user/**
public class UserController {
	
     @Resource  
     private IUserService userService;   
     
     @Value("${TEST_URL}")
     private String test_url;
     
    @RequestMapping(value="/showUser2")  
    @ResponseBody
    public String toIndex2( int id ){  
    	System.out.println("userController:  "+test_url);
    	
        User user = this.userService.getUserById(id);
        return user.toString();
    }  
    
    //文件上传
    @RequestMapping("/upload")
    public String showUploadPage(){
        return "file";
    }
    //文件上传
    @RequestMapping("/index")
    public String index(){
        return "forward:/user/upload";
    }
    
/*    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
        	System.out.println("fileName:   "+file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\temp/",System.currentTimeMillis()+file.getOriginalFilename()));
        return "success";
    }*/
    @RequestMapping(value="/doUpload")
    public String doUploadFile2(MultipartFile file,HttpServletRequest request) throws IOException{
    	String  username=request.getParameter("username");
    	String  password=request.getParameter("password");
    	System.out.println("username:   "+username+"         password:     "+password);
        if (!file.isEmpty()) {
        	System.out.println("fileName:   "+file.getOriginalFilename());
        	   FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\temp/",System.currentTimeMillis()+file.getOriginalFilename()));
        	   return "success";
        }
        return "file";
    }
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test(){
        return "test";
    }
    @RequestMapping("/getPerson")
    public void getPerson(String name,PrintWriter pw){ 
        try {
			pw.write("hello,"+URLEncoder.encode(name, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
   
        @ResponseBody
        @RequestMapping("/getUser")
        public  User get(){
            User u = new User();
            u.setId(1);
            u.setUsername("jayjay");
            u.setPassword("1111");
            u.setAge(20);
            return u;
        }
        @RequestMapping("/redirect")
        public String redirect(){
            return "redirect:upload";
        }
        
        @RequestMapping("/hello")
        public String error(){
            int i = 5/0;
            return "hello";
        }
        @RequestMapping(value="/param")
        public String testRequestParam(Integer id,
                String name){
            System.out.println(id+" "+name);
            return "success";
        }   
        //处理json数据（数据绑定之json）
        @RequestMapping(value="/handleJson")
        @ResponseBody
        public void handleJson(String strJSON) {
        	JSONObject object=JSONObject.parseObject(strJSON);
        	System.out.println(object);
        }
        //处理时间（根据毫秒转为当前时间）
        @RequestMapping(value="/getTime")
        @ResponseBody
        public void getTime(long time) {
        	SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	Date date=new Date();
        	date.setTime(time);
        	System.out.println(simpleDateFormat.format(date));
        }
        //返回json数据
        @RequestMapping(value="/getJson")
        @ResponseBody
        public ArrayList<HashMap<String, Object>> getJson() {
        	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
        	for(int i=0;i<10;i++) {
        		HashMap<String, Object> map=new HashMap<String, Object>();
            	map.put("grade", "软件162");
            	map.put("sum", 50);
            	list.add(map);
        	}
        	return list;
        }
        @RequestMapping(value="/getList")
        public String getList(Model model) {
        	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
/*        	for(int i=0;i<10;i++) {
        		HashMap<String, Object> map=new HashMap<String, Object>();
            	map.put("grade", "软件162");
            	map.put("sum", 50);
            	list.add(map);
        	}*/
        	model.addAttribute("list", list);
        	return "test";
        }
        @RequestMapping("/model")
        public String model(Model model) {
        	model.addAttribute("username", "zs");
        	model.addAttribute("age",22);
        	return "test";
        }
        @RequestMapping("/request")
        public String request(Map<String, Object> map){
           map.put("gender", "female");
            return "test";
        }
        @RequestMapping("/eltest")
        public String eltest(){
            return "eltest";
        }
        @RequestMapping("/session")
        public String session(HttpServletRequest request) {
        HttpSession session=	request.getSession();
        session.setAttribute("ss", "aa");
        return "test";
        }
        @RequestMapping("/application")
        public String application(HttpServletRequest request) {
        	ServletContext servletContext=request.getServletContext();
        	servletContext.setAttribute("aa", 666);
        	return "test";
        }
        @RequestMapping("/testForm")
        public String testForm(HttpServletRequest request,@RequestParam("files")MultipartFile[] files) {
        	String username=request.getParameter("username");
        	String password=request.getParameter("password");
        	System.out.println(username+"    "+password);
        	if (files!=null&&files.length>0) {
				for (MultipartFile multipartFile2 : files) {
					System.out.println(multipartFile2.getOriginalFilename());
				}
			}
        	return "success";
        }
        @RequestMapping("/shirotest")
        @ResponseBody
        public String testShiro() {
   		 //2.主体提交认证请求
        	try {
          		 Subject subject=SecurityUtils.getSubject();
           		 UsernamePasswordToken token=new UsernamePasswordToken("Mark", "123456");
           		 subject.login(token);
           		 return "登录成功";
			} catch (Exception e) {
				return e.getMessage();
			}
        }
        @RequestMapping(value="/testRole",method=RequestMethod.GET)
        @ResponseBody
        public String testRole() {
        	return "testRole success";
        }
        @RequestMapping(value="/testRole1",method=RequestMethod.GET)
        @ResponseBody
        public String testRole1() {
        	return "testRole1 success";
        }
}  