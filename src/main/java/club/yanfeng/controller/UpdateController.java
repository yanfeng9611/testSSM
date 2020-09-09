package club.yanfeng.controller;

import club.yanfeng.entity.User;
import club.yanfeng.entity.UserHistory;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "update")
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @RequestMapping(value="/borrow",method = RequestMethod.GET, params = {"bookId"})
    private String borrow(HttpServletRequest req, HttpSession session, @RequestParam("bookId") Integer bookId){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String borrowTime = sdf.format(new Date());
        updateService.borrowOperate(bookId, user.getId(), borrowTime);
        updateService.reduceBookAvailableNum(bookId);
        req.setAttribute("username", user.getUsername());
        return "forward:/user/index";
    }

    @RequestMapping(value="/restore", method = RequestMethod.GET, params = {"bookId", "borrowId"})
    private String restore(HttpServletRequest req, HttpSession session, @RequestParam("bookId") Integer bookId, @RequestParam("borrowId") Integer borrowId){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String returnTime = sdf.format(new Date());
        updateService.retoreOperate(borrowId, returnTime);
        updateService.addBookAvailableNum(bookId);
        req.setAttribute("username", user.getUsername());
        return "redirect:/user/reading";
    }

    @RequestMapping(value="/repeal",method = RequestMethod.GET, params = {"bookId","borrowId"})
    private String repeal(HttpServletRequest req, HttpSession session, @RequestParam("bookId") Integer bookId, @RequestParam("borrowId") Integer borrowId){   //(HttpServletRequest req,HttpServletResponse resp){
        User user = (User) session.getAttribute("user");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String returnTime = sdf.format(new Date());
        updateService.repealOperate(borrowId, returnTime);
        updateService.addBookAvailableNum(bookId);
        req.setAttribute("username", user.getUsername());
        return "forward:/user/approval";
    }
}
