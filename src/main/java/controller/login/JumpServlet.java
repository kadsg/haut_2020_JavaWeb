package controller.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JumpServlet", value = "/JumpServlet")
public class JumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity = request.getParameter("identity");
        String path = "/view/" + "user/" + identity + "/index.jsp";
        response.sendRedirect(path);
    }
}
