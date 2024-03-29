package controller.user.player.signup;

import bean.EventPlayer;
import bean.user.User;
import service.EventPlayerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlayerSignUpServlet", value = "/PlayerSignUpServlet")
public class PlayerSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");

        new EventPlayerService().signUp(user, id);

        request.getRequestDispatcher("/PlayerSignUpViewServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
