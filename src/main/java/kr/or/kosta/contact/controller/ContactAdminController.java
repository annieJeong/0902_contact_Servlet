package kr.or.kosta.contact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kosta.contact.model.Contact;

@Controller
public class ContactAdminController {
	
	@RequestMapping("/hello")
	public @ResponseBody List<String> hello(){
		System.out.println("hello");
		
		List<String> list = new ArrayList<String>();
		list.add("kim");
		list.add("lee");
		list.add("Jeong");
		
		return list;
	}
	@RequestMapping(value="/result")
	public @ResponseBody Map<String, String> result(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "kim");
		map.put("addr", "newyork");
		map.put("age","20");
		
		return map;
	}
	
	@RequestMapping(value="/search")
	public @ResponseBody Contact search(){
		Contact con = new Contact();
		con.setId(1);
		con.setName("kim");
		con.setEmail("kim@a.a");
		con.setAge(30);
		con.setAddr("seoul");
		
		return con;
	}
	
	@RequestMapping(value="/")
	public String index(){
		return "index";	//WEB-INF/views/index.jsp
	}
	
	@RequestMapping(value="/regist")
	public ModelAndView regist(){
		//view이름을 지정하여 실행가능. 위와결과는 같다.
		ModelAndView mav = new ModelAndView();
		//Model = controller -> jsp 뷰. 넘겨준다.
		mav.addObject("name","정인우");
		mav.addObject("greet","Hi");
		mav.setViewName("regist");
		return mav;
	}
	
	@RequestMapping(value="/doCalc")
	public ModelAndView doCalc(HttpServletRequest request){
		int numOne = Integer.parseInt(request.getParameter("numOne"));
		int numTwo = Integer.parseInt(request.getParameter("numTwo"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",numOne+numTwo);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value="/flightFee")
	public ModelAndView flightFee(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("flightFee");
		
		return mav;
	}
	
	@RequestMapping(value="flightFeeCalc")
	public ModelAndView flightFeeCalc(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		try{
			int numOfAdult = Integer.parseInt(request.getParameter("numOfAdult"));
			int numOfChild = Integer.parseInt(request.getParameter("numOfChild"));
			int numOfKids = Integer.parseInt(request.getParameter("numOfKids"));
			
			String dest = request.getParameter("dest");
	
			int fee = check(dest);
			
			int total = totalFee(numOfAdult, numOfChild, numOfKids, fee);
			
			mav.addObject("total",total);
			mav.setViewName("flightFeeCalc");
			return mav;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	int check(String dest){
		int fee =0;
		if(dest.equals("newyork") ){
			fee = 1200000;
		}else if(dest.equals("bangkok")){
			fee = 400000;
		}else if(dest.equals("sydney")){
			fee = 1000000;
		}
		return fee;
	}
	
	int totalFee(int adult, int child, int kids, int fee){
		int total=0;
		
		total = (int)((((adult + child)*fee )+ (kids * fee) * 0.2)* 1.005);
		
		return total;
	}
}
