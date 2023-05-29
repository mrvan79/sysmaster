package kk.soft.co.jp.sys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kk.soft.co.jp.sys.model.UserModel;
import kk.soft.co.jp.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MainController {

	@Resource
	//    private 
	UserService userService;

	@GetMapping("/Useraccount")
	public String Useraccount(Model model) {
		return "Useraccount";
	}

	@GetMapping
	public String login1(Model model) {

		return "login";
	}

	
	@GetMapping("/login")
	public String login(Model model) {

		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}
	@GetMapping("/userdata/{id}")
	public String Useraccountt(@PathVariable ("id") int id) {
		
		return "delete";
	}
	@PostMapping("/signup")
	public String signup1(UserModel userModel, Model model) {
		UserModel checkID = userService.checkAccount(userModel);
		log.info("{}", userModel);
		if (userModel.getName() == "" || userModel.getTelefone() == ""
				|| userModel.getPassword() == "" || userModel.getSex() == ""
				|| userModel.getDate() == "" || userModel.getMaried() == "") {

			model.addAttribute("msg", "全部入力してください");
			return null;
		} else if (checkID != null) {
			model.addAttribute("msg", "アカウントが存在しました");
			return null;
		} else {
			userService.insert(userModel);
			model.addAttribute("msg", "作成できました");
			return "login";
		}

	}
	@GetMapping("/userdata")
			public ResponseEntity<List<UserModel>> log1in( UserModel userModel, Model model) {
				log.info("{}", userModel);
				List<UserModel> a = userService.takeAll(userModel);
				
				model.addAttribute("a", a);

				return ResponseEntity.ok(a);
			}
	@PostMapping("/userdata")
	public String userdata( UserModel userModel, Model model) {
		log.info("{}", userModel);
		List<UserModel> a = userService.takeAll(userModel);
		userService.insert(userModel);
		model.addAttribute("a", a);

		return "userdata";
	}

	@PostMapping("/Useraccount")
	public String Useraccount(UserModel userModel, Model model,HttpServletRequest request) {
		UserModel newUser = userService.selectAll(userModel);
		log.info("{}", userModel);
		if (newUser == null) {
			model.addAttribute("msg", "" + "再入力してください");
			return "login";
		} else {
			model.addAttribute("user", newUser);
			model.addAttribute("msg", "" + newUser.getName() + "よこそう");
			model.addAttribute("name", "" + newUser.getName());
			model.addAttribute("telefone", "" + newUser.getTelefone());
			model.addAttribute("password", "" + newUser.getPassword());
			model.addAttribute("sex", "" + newUser.getSex());
			model.addAttribute("date", "" + newUser.getDate());
			model.addAttribute("maried", "" + newUser.getMaried());
			HttpSession session = request.getSession();
			session.setAttribute("userlogin",newUser.getName());
			return "Useraccount";
		}
	}
	
	@PostMapping("/passchange")
	public String passchange(HttpServletRequest request, UserModel userModel, Model model) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userlogin");
		userModel.setName(user);
//		List<UserModel> passchange = userService.selectuser(userModel);
		userService.checkpass(userModel);
		log.info("{}",userModel);
		UserModel newUser = userService.checkAccount(userModel);
		model.addAttribute("msg", "" + newUser.getName() + "よこそう");
		model.addAttribute("name", "" + newUser.getName());
		model.addAttribute("telefone", "" + newUser.getTelefone());
		model.addAttribute("password", "" + newUser.getPassword());
		model.addAttribute("sex", "" + newUser.getSex());
		model.addAttribute("date", "" + newUser.getDate());
		model.addAttribute("maried", "" + newUser.getMaried());
//		System.out.println(passchange.toString());
//		if (Userlogin != null) {
//			log.info("{}", userModel);
//
//			userModel.setPassword(userModel.getPassword());
//			userService.checkpass(userModel);
//			model.addAttribute("msg", "パスワード変更できました");
//
//		}	

		return "Useraccount";
	}
	//    public boolean iscorrect(UserModel userModel, Model model) {
	//    	boolean isCheckBox = true;
	//		boolean isAllInput = true;
	//		boolean isAccountCorrect = true;
	//		boolean isPassCorrect = true;
	//		UserModel ul = userService.selectAll(userModel);	
	//		if (ul == null) {
	//			model.addAttribute("msg", "もう一度やり直してください");
	//			return isAllInput false;
	//		}
	//		return false;4
	//    	
	//    }

}
