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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.ws.rs.Encoded;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.imooc.pojo.Group;
import com.imooc.pojo.User;
import com.imooc.service.IUserService;
  
@Controller  
@RequestMapping("/user")  
// /user/**
public class UserController {  
     @Resource  
     private IUserService userService;     
    
 // /user/showUser2?id=1
    @RequestMapping(value="/showUser2")  
    @ResponseBody

    public String toIndex2(    int id ,float param){  
        User user = this.userService.getUserById(id);
        return user.toString();
    }  
    
    //文件上传
    @RequestMapping("/upload")
    public String showUploadPage(){
        return "file";
    }
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
        	System.out.println("fileName:   "+file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\temp/",System.currentTimeMillis()+file.getOriginalFilename()));
        return "success";
    }
    @RequestMapping("/test")
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
        @RequestMapping("/request")
        public String request(Map<String, Object> map){
           map.put("rr", "test");
            return "test";
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
}  