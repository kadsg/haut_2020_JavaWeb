package controller.user.player.entry;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.User;
import service.EventPlayerService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EntryViewServlet", value = "/EntryViewServlet")
public class EntryViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 获取报名表
        EventPlayerService eventPlayerService = new EventPlayerService();
        List<EventPlayer> eventPlayerList = eventPlayerService.queryAllEventOfPlayer(user);
        // 获取对应的项目表
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.queryAllItemOfEventPlayer(eventPlayerList);

        request.setAttribute("eventPlayerList", eventPlayerList);
        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("/view/user/player/entry.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
