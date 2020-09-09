package club.yanfeng.controller;

import club.yanfeng.entity.User;
import club.yanfeng.entity.UserHistory;
import club.yanfeng.entity.UserIndex;
import club.yanfeng.service.CommonService;
import club.yanfeng.service.UpdateService;
import club.yanfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserLoginController {

    @Autowired()
    private UserService userService;

    @Autowired()
    private CommonService commonService;

    Integer dataPrePage = CommonService.LIMIT;

    @RequestMapping(value="/loginVerify", method = RequestMethod.POST)
    private String validate(HttpServletRequest req, HttpServletResponse resp){   //(HttpServletRequest req,HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = userService.validateUser(username,password);
        if(user != null){
            session.setAttribute("user",user);
            return "redirect:/user/index?page=1";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value="/index", method = RequestMethod.GET, params = {"page"})
    private String index(HttpServletRequest req, HttpSession session,@RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        Integer pages = commonService.getBookPages(dataPrePage);
        List<UserIndex> userIndexList = userService.queryUserIndex(currentPage, dataPrePage);
        req.setAttribute("userIndexList", userIndexList);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/User/index";
    }

    @RequestMapping(value="/history", method = RequestMethod.GET, params = {"page"})
    private String history(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        Integer pages = userService.getHistoryPages(dataPrePage, user.getId());
        List<UserHistory> userHistoryList = userService.queryUserHistory(currentPage, dataPrePage, user.getId());
        req.setAttribute("resultList", userHistoryList);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/User/history";
    }

    @RequestMapping(value="/approval")
    private String approval(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        Integer pages = userService.getApprovalPages(dataPrePage, user.getId());
        List<UserHistory> userApprovalList = userService.queryUserApproval(currentPage, dataPrePage, user.getId());
        req.setAttribute("resultList", userApprovalList);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/User/approval";
    }

    @RequestMapping(value="/reading")
    private String reading(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        Integer pages = userService.getReadingPages(dataPrePage, user.getId());
        List<UserHistory> userReadingList = userService.queryUserReading(currentPage, dataPrePage, user.getId());
        req.setAttribute("resultList", userReadingList);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/User/reading";
    }

    @RequestMapping(value="/accomplish")
    private String accomplish(HttpServletRequest req, HttpSession session, @RequestParam("page") Integer currentPage){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        Integer pages = userService.getAccomplishPages(dataPrePage, user.getId());
        List<UserHistory> userAccomplishList = userService.queryUserAccomplish(currentPage, dataPrePage, user.getId());
        req.setAttribute("resultList", userAccomplishList);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("dataPrePage", dataPrePage);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pages", pages);
        return "/User/accomplish";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session)  {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
