package controller.user.referee.marking;

import bean.Marking;
import bean.item.Item;
import bean.user.Player;
import service.EventPlayerService;
import service.ItemService;
import service.MarkingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MarkingServlet", value = "/MarkingServlet")
public class MarkingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得打分表
        // 获取该项目下的运动员列表
        String id_item = request.getParameter("id");
        Item item = new ItemService().queryItemById(id_item);
        List<Player> playerList = new EventPlayerService().queryAllPlayerOfItem(item);
        // 同时获取对应的打分表，下标对齐
        MarkingService markingService = new MarkingService();
        List<Marking> markingList = null;
        if (playerList!=null) {
            if (markingList == null)
                markingList = new ArrayList<>();
            for (Player player : playerList) {
                Marking marking = markingService.search(id_item, player.getAccount());
                markingList.add(marking);
            }
        }
        // 更新打分情况，下标对齐
        for (Marking marking : markingList) {
            double grade = Double.parseDouble(request.getParameter("gradeOf" + marking.getId_player()));
            marking.setGrade(grade);
            markingService.update(marking);
        }

        request.setAttribute("item", item);
        request.setAttribute("playerList", playerList);
        request.setAttribute("markingList", markingList);
        request.getRequestDispatcher("/view/user/referee/markingPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
