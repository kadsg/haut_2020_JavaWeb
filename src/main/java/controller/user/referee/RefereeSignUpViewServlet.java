package controller.user.referee;

import bean.EventPlayer;
import bean.EventReferee;
import bean.item.Item;
import bean.user.User;
import service.EventPlayerService;
import service.EventRefereeService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RefereeSignUpViewServlet", value = "/RefereeSignUpViewServlet")
public class RefereeSignUpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取可报名表
        ItemService itemService = new ItemService();
        List<Item> itemList = null;
        List<Item> tempList = itemService.queryAllItem();
        User user = (User) request.getSession().getAttribute("user");

        if (tempList != null) {
            for (Item item : tempList) {
                if (!item.isIs_over()) {
                    if (itemList == null) {
                        itemList = new ArrayList<>();
                    }
                    itemList.add(item);
                }
            }
        }
        // 获取裁判员referee的参赛表
        EventRefereeService eventRefereeService = new EventRefereeService();
        List<EventReferee> signUpList = eventRefereeService.getAllEventReferee(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/referee/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
