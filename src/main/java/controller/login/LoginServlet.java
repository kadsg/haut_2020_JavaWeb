package controller.login;

import bean.user.User;
import service.login.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService service = new LoginService();

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String identity = request.getParameter("identity");

        User user = null;

        switch (identity) {
            case "administrator":
                user = service.getAdministrator(account);
                break;
            case "referee":
                user = service.getReferee(account);
                break;
            case "player":
                user = service.getPlayer(account);
                break;
            case "volunteer":
                user = service.getVolunteer(account);
                break;
        }

        // 假定输入账号存在且正确
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        request.getRequestDispatcher("/JumpServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
