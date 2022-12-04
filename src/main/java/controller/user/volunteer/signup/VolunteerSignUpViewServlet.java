package controller.user.volunteer.signup;

import bean.EventVolunteer;
import bean.item.Item;
import bean.user.User;

import service.ItemService;
import service.user.VolunteerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "VolunteerSignUpViewServlet", value = "/VolunteerSignUpViewServlet")
public class VolunteerSignUpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 获取可报名表
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
        // 获取该志愿者的参赛表
//        EventVolunteerService eventVolunteerService = new EventVolunteerService();
//        List<EventVolunteer> signUpList = eventVolunteerService.getAllEventVolunteer(user);
        List<EventVolunteer> signUpList = new VolunteerService().querySignUpList(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/volunteer/signUp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
