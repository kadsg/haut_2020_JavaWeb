package controller.user.player.entry;

import bean.EventPlayer;
import service.EventPlayerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EntryServlet", value = "/EntryServlet")
public class EntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventPlayerService service = new EventPlayerService();
        String id_player = request.getParameter("id_player");
        String id_item = request.getParameter("id_item");
        EventPlayer eventPlayer = service.getEventPlayer(id_player, id_item);

        service.updateJoin(eventPlayer);

        request.getRequestDispatcher("/EntryViewServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
