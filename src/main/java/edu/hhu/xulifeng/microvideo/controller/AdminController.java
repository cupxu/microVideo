package edu.hhu.xulifeng.microvideo.controller;

import edu.hhu.xulifeng.microvideo.service.impl.AdminServiceImpl;
import edu.hhu.xulifeng.microvideo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author xulifeng
 * @since 2022-10-24
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl adminService;

    @GetMapping("/adminLoginPage")
    public String adminLoginPage() {
        return "admin/admin_login";
    }

    @GetMapping("/adminIndexPage")
    public String adminIndex() {
        return "admin/video/list";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult adminLogin(HttpServletRequest request, @RequestBody Map<String, String> adminLoginInfo) {
        String account = adminLoginInfo.get("account");
        String password = adminLoginInfo.get("password");
        boolean isExists = adminService.isExists(account, password);
        if (isExists) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount",account);
            return ResponseResult.success("200","登录成功");
        }
        return ResponseResult.error("500","登录失败");
    }

    @GetMapping("/userManagement")
    public String userManagement(HttpServletResponse response) {
        return "admin/userManage";
    }
}
