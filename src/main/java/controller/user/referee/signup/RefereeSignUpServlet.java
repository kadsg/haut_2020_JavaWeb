package controller.user.referee.signup;

import bean.EventPlayer;
import bean.EventReferee;
import bean.item.Item;
import bean.user.Player;
import bean.user.User;
import service.EventPlayerService;
import service.EventRefereeService;
import service.ItemService;
import service.MarkingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RefereeSignUpServlet", value = "/RefereeSignUpServlet")
public class RefereeSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventRefereeService eventRefereeService = new EventRefereeService();
        String id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");
        // 加入裁判组
        EventReferee eventReferee = new EventReferee(user.getAccount(), id);
        eventRefereeService.insert(eventReferee);
        // 取得项目
        Item item = new ItemService().queryItemById(id);
        // 取得并分配项目下的运动员
        EventPlayerService eventPlayerService = new EventPlayerService();
        List<Player> playerList = eventPlayerService.queryAllPlayerOfItem(item);
        // 分配
        MarkingService markingService = new MarkingService();
        markingService.insert(user.getAccount(), id, playerList);

        // 跳转
        request.getRequestDispatcher("/RefereeSignUpViewServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
