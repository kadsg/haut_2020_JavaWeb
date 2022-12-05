package controller.user.volunteer.service;

import bean.Log;
import bean.item.Item;
import bean.user.Player;
import bean.user.User;
import service.ItemService;
import service.user.player.PlayerService;
import service.user.volunteer.VolunteerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogViewServlet", value = "/LogViewServlet")
public class LogViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        // 获取日志
        List<Log> logList = new VolunteerService().queryAllLogByIdVolunteer(user.getAccount());
        // 获取日志对应的运动员
        PlayerService playerService = new PlayerService();
        List<Player> playerList = null;
        if (logList != null) {
            playerList = new ArrayList<>();
            for (Log log1 : logList)
                playerList.add(playerService.search(log1.getId_player()));
        }
        // 获取对应赛事
        ItemService itemService = new ItemService();
        List<Item> itemList = null;
        if (logList != null) {
            itemList = new ArrayList<>();
            for (Log log1 : logList)
                itemList.add(itemService.queryItemById(log1.getId_item()));
        }

        request.setAttribute("logList", logList);
        request.setAttribute("playerList", playerList);
        request.setAttribute("itemList", itemList);

        request.getRequestDispatcher("/view/user/volunteer/service/log.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
