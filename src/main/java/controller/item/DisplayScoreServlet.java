package controller.item;

import bean.Score;
import bean.item.Item;
import bean.user.Player;
import service.ItemService;
import service.ScoreService;
import service.user.player.PlayerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayScoreServlet", value = "/DisplayScoreServlet")
public class DisplayScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_item = request.getParameter("id_item");
        Item item = new ItemService().queryItemById(id_item);

        // 获取赛事成绩单
        List<Score> scoreList = new ScoreService().queryScoreListOfItem(id_item);
        // 获取选手信息
        List<Player> playerList = null;
        if (scoreList != null) {
            if (playerList == null)
                playerList = new ArrayList<>();
            for (Score score : scoreList) {
                Player player = new PlayerService().search(score.getId_player());
                playerList.add(player);
            }
        }

        request.setAttribute("item", item);
        request.setAttribute("scoreList", scoreList);
        request.setAttribute("playerList", playerList);

        String identity = request.getParameter("identity");
        String path = "/view/user/" + identity + "/displayScore/displayScore.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
