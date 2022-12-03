package controller.login;

import bean.user.*;
import service.login.RegisterService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterService service = new RegisterService();
        User user;

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String identity = request.getParameter("identity");

        switch (identity) {
            case "administrator":
                user = new Administrator(account, password, name);
                service.registerAdministrator(user);
                request.getSession().setAttribute("user", user);
                break;
            case "referee":
                user = new Referee(account, password, name);
                service.registerReferee(user);
                request.getSession().setAttribute("user", user);
                break;
            case "player":
                user = new Player(account, password, name);
                service.registerPlayer(user);
                request.getSession().setAttribute("user", user);
                break;
            case "volunteer":
                user = new Volunteer(account, password, name);
                service.registerVolunteer(user);
                request.getSession().setAttribute("user", user);
                break;
        }

        request.getRequestDispatcher("/JumpServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
