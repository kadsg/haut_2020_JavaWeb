package controller.user.volunteer.signup;

import bean.EventReferee;
import bean.EventVolunteer;
import bean.item.Item;
import bean.user.User;
import service.EventRefereeService;
import service.EventVolunteerService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VolunteerSignUpViewServlet", value = "/VolunteerSignUpViewServlet")
public class VolunteerSignUpViewServlet extends HttpServlet {
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
        // 获取该志愿者的参赛表
        EventVolunteerService eventVolunteerService = new EventVolunteerService();
        List<EventVolunteer> signUpList = eventVolunteerService.getAllEventVolunteer(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/volunteer/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
