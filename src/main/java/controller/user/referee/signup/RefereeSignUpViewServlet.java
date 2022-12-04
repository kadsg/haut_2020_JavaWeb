package controller.user.referee.signup;

import bean.EventReferee;
import bean.item.Item;
import bean.user.User;

import service.ItemService;
import service.user.referee.RefereeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RefereeSignUpViewServlet", value = "/RefereeSignUpViewServlet")
public class RefereeSignUpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

//        // 获取可报名表
//        ItemService itemService = new ItemService();
//        List<Item> itemList = null;
//        List<Item> tempList = itemService.queryAllItem();
//
//        if (tempList != null) {
//            for (Item item : tempList) {
//                if (!item.isIs_over()) {
//                    if (itemList == null) {
//                        itemList = new ArrayList<>();
//                    }
//                    itemList.add(item);
//                }
//            }
//        }
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.queryAllItemOnGoing();
        // 获取裁判员referee的参赛表
        RefereeService refereeService = new RefereeService();
        List<EventReferee> signUpList = refereeService.querySignUpList(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/referee/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
