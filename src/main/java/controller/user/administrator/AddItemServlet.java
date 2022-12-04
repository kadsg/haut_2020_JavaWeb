package controller.user.administrator;

import bean.item.Item;
import service.ItemService;
import service.user.administrator.AdministratorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddItemServlet", value = "/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministratorService service = new AdministratorService();

        String name = request.getParameter("name");
        String temp_time = request.getParameter("time");
        String rule = request.getParameter("rule");
        String place = request.getParameter("place");
        String time = temp_time.substring(0, 10) + " " + temp_time.substring(10 + 1);

        Item item = new Item(name, rule, place, time);
        service.addItem(item);

        List<Item> itemList = new ItemService().queryAllItem();
        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("/view/user/administrator/queryItem/queryItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
