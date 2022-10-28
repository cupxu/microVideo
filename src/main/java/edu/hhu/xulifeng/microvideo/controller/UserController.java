package edu.hhu.xulifeng.microvideo.controller;

import edu.hhu.xulifeng.microvideo.pojo.User;
import edu.hhu.xulifeng.microvideo.service.impl.UserServiceImpl;
import edu.hhu.xulifeng.microvideo.util.ResponseResult;
import edu.hhu.xulifeng.microvideo.util.StringToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 普通用户表 前端控制器
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    User user;

    @GetMapping("/userLoginPage")
    public String loadLoginPage() {
        return "user/user_login";
    }
    @GetMapping("/userRegisterPage")
    public String loadRegisterPage() {
        return "user/user_register";
    }
    @GetMapping("/userIndexPage")
    public String loadUserIndexPage() {
        return "user/user_index";
    }

    @PostMapping("/register")
    @ResponseBody
    public int userRegister(@RequestBody Map<String,String> userRegisterInfo) {
        user.setNickName(userRegisterInfo.get("nick_name"));
        user.setAccount(userRegisterInfo.get("account"));
        user.setPassword(userRegisterInfo.get("password"));
        user.setGender((userRegisterInfo.get("gender)") == "男" ? true : false));
        user.setBirthday(StringToDate.stringToDate(userRegisterInfo.get("birthday")));
        user.setPhone(userRegisterInfo.get("phone"));
        user.setEmail(userRegisterInfo.get("email"));
        user.setDescription(userRegisterInfo.get("description"));
        System.out.println(user);
        return userService.userRegister(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult userLogin(HttpServletRequest request, @RequestBody Map<String, String> userLoginInfo) {
        String account = userLoginInfo.get("account");
        String password = userLoginInfo.get("password");
        boolean isExists = userService.isExists(account, password);
        if (isExists) {
            request.setAttribute("userAccount",account);
            return ResponseResult.success();
        }
        return ResponseResult.error("300");
    }

    @GetMapping("/loadAllUsers")
    @ResponseBody
    public ResponseResult loadAllUsers() {
        return ResponseResult.success(userService.selectAllUsers());
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseResult delete(@RequestBody Map<String, String> data){
        userService.deleteById(data.get("id"));
        return ResponseResult.success("200","删除成功");
    }
}
