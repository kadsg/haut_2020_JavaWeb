package controller.user.volunteer.service;

import bean.item.Item;
import bean.user.Player;
import service.EventPlayerService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServicePageServlet", value = "/ServicePageServlet")
public class ServicePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_item = request.getParameter("id_item");
        Item item = new ItemService().queryItemById(id_item);
        List<Player> playerList = new EventPlayerService().queryAllPlayerOfItem(item);

        request.setAttribute("item", item);
        request.setAttribute("playerList", playerList);

        request.getRequestDispatcher("/view/user/volunteer/service/servicePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
