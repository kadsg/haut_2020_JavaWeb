package controller.user.referee.marking;

import bean.EventReferee;
import bean.item.Item;
import bean.user.User;
import service.EventRefereeService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MarkingIndexServlet", value = "/MarkingIndexServlet")
public class MarkingIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取报名表
        EventRefereeService eventRefereeService = new EventRefereeService();
        User user = (User) request.getSession().getAttribute("user");
        List<EventReferee> eventRefereeList = eventRefereeService.getAllEventReferee(user);
        ItemService itemService = new ItemService();
        Item item;
        List<Item> itemList = null;
        if (eventRefereeList != null) {
            for (EventReferee eventReferee : eventRefereeList) {
                if (itemList == null)
                    itemList = new ArrayList<>();
                item = itemService.queryItemById(eventReferee.getId_item());
                itemList.add(item);
            }
        }
        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("view/user/referee/markingIndex.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
