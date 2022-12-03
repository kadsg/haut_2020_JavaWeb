package controller.user.volunteer.signup;

import bean.EventVolunteer;
import bean.user.User;
import service.EventVolunteerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VolunteerSignUpServlet", value = "/VolunteerSignUpServlet")
public class VolunteerSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventVolunteerService service = new EventVolunteerService();
        String id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");
        EventVolunteer eventVolunteer = new EventVolunteer(id, user.getAccount());

        service.insert(eventVolunteer);

        request.getRequestDispatcher("/VolunteerSignUpViewServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
