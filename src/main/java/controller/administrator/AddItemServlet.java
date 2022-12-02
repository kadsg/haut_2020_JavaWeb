package controller.administrator;

import bean.item.Item;
import service.user.AdministratorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddItemServlet", value = "/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministratorService service = new AdministratorService();

        String name = request.getParameter("name");
        String temp_time = request.getParameter("time");
        String rule = request.getParameter("rule");
        String place = request.getParameter("place");
        String time = temp_time.substring(0, 10) + "" + temp_time.substring(10 + 1);

        Item item = new Item(name, rule, place, time);
        service.addItem(item);
        // TODO 假定添加成功，跳转
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
