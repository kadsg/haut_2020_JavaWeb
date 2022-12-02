package controller.player;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.Player;
import bean.user.User;
import service.EventPlayerService;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 转发报名表
 */
@WebServlet(name = "SignUpViewServlet", value = "/SignUpViewServlet")
public class SignUpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取可参赛表
        ItemService itemService = new ItemService();
        List<Item> itemList = null;
        List<Item> tempList = itemService.queryAllItem();
        User user = (User) request.getSession().getAttribute("user");

        if (tempList != null) {
            for (Item item : tempList) {
                if (!item.isIs_over()) {
                    if (itemList == null) {
                        itemList = new ArrayList<>();
                    }
                    itemList.add(item);
                }
            }
        }
        // 获取运动员player的参赛表
        EventPlayerService eventPlayerService = new EventPlayerService();
        List<EventPlayer> signUpList = eventPlayerService.queryAllEventOfPlayer(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/player/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
