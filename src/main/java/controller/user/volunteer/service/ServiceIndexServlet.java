package controller.user.volunteer.service;

import bean.item.Item;
import bean.user.User;
import service.user.volunteer.VolunteerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceIndexServlet", value = "/ServiceIndexServlet")
public class ServiceIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Item> itemList = new VolunteerService().querySignUpListOnGoing(user);

        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("/view/user/volunteer/service/serviceIndex.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
