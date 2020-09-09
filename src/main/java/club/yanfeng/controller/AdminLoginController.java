package club.yanfeng.controller;

import club.yanfeng.entity.Admin;
import club.yanfeng.entity.AdminHistory;
import club.yanfeng.entity.AdminIndex;
import club.yanfeng.service.AdminService;
import club.yanfeng.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminLoginController {
    @Autowired()
    private AdminService adminService;

    @Autowired()
    private CommonService commonService;

    Integer dataPrePage = CommonService.LIMIT;

    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
    private String validate(HttpServletRequest req, HttpServletResponse resp){   //(HttpServletRequest req,HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = adminService.validateAdm(username,password);
        HttpSession session = req.getSession();
        if(admin != null){
            session.setAttribute("admin", admin);
            return "redirect:/admin/index?page=1";
        }else{
            return "redirect:/adminLogin";
        }
    }

    @RequestMapping(value="/index", method = RequestMethod.GET, params = {"page"})
    private String index(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer pages = commonService.getBookPages(dataPrePage);
        List<AdminIndex> adminIndexList = adminService.queryAdminIndex(currentPage, dataPrePage);
        req.setAttribute("adminIndexList", adminIndexList);
        req.setAttribute("username", admin.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/Admin/index";
    }

    @RequestMapping(value="/history", method = RequestMethod.GET, params = {"page"})
    private String borrow(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer pages = adminService.getHistoryPages(dataPrePage, admin.getId());
        List<AdminHistory> adminHistoryList = adminService .queryAdminHistory(currentPage, dataPrePage, admin.getId());
        req.setAttribute("adminHistoryList", adminHistoryList);
        req.setAttribute("username", admin.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/Admin/history";
    }

    @RequestMapping(value="/apply", method = RequestMethod.GET, params = {"page"})
    private String apply(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer pages = adminService.getApplyPages(dataPrePage);
        List<AdminHistory> applyList = adminService.queryApply(currentPage, dataPrePage);
        req.setAttribute("applyList", applyList);
        req.setAttribute("username", admin.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/Admin/apply";
    }

    @RequestMapping(value="/approval",method = RequestMethod.GET, params = {"borrowId"})
    private String approval(HttpServletRequest req, HttpSession session, @RequestParam("borrowId") Integer borrowId){   //(HttpServletRequest req,HttpServletResponse resp){
        Admin admin = (Admin) session.getAttribute("admin");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String approvalTime = sdf.format(new Date());
        adminService.queryApproval(borrowId, admin.getId(), approvalTime);
        req.setAttribute("username", admin.getUsername());
        return "forward:/admin/apply?page=1";
    }

    @RequestMapping(value="/refuse", method = RequestMethod.GET, params = {"borrowId"})
    private String refuse(HttpServletRequest req, HttpSession session, @RequestParam("borrowId") Integer borrowId){   //(HttpServletRequest req,HttpServletResponse resp){
        Admin admin = (Admin) session.getAttribute("admin");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String approvalTime = sdf.format(new Date());
        adminService.queryRefuse(borrowId, admin.getId(), approvalTime);
        req.setAttribute("username", admin.getUsername());
        return "forward:/admin/apply?page=1";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session)  {
        session.removeAttribute("admin");
        session.invalidate();
        return "redirect:/adminLogin";
    }
}
