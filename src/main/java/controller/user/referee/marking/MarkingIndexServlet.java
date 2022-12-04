package controller.user.referee.marking;

import bean.item.Item;
import bean.user.User;

import service.user.referee.RefereeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MarkingIndexServlet", value = "/MarkingIndexServlet")
public class MarkingIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 获取报名表
//        EventRefereeService eventRefereeService = new EventRefereeService();
//        List<EventReferee> eventRefereeList = eventRefereeService.getAllEventReferee(user);
//        ItemService itemService = new ItemService();
//        Item item;
//        List<Item> itemList = null;
//        if (eventRefereeList != null) {
//            for (EventReferee eventReferee : eventRefereeList) {
//                if (itemList == null)
//                    itemList = new ArrayList<>();
//                item = itemService.queryItemById(eventReferee.getId_item());
//                itemList.add(item);
//            }
//        }
        List<Item> itemList = new RefereeService().querySignUpItemList(user);

        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("view/user/referee/markingIndex.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
