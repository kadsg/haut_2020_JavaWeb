package controller.player;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.User;
import controller.item.QueryItemServlet;
import service.EventPlayerService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventPlayerService service = new EventPlayerService();
        String id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");
        EventPlayer eventPlayer = new EventPlayer(user.getAccount(), id, 0, false);

        service.insert(eventPlayer);

        request.getRequestDispatcher("/SignUpViewServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
