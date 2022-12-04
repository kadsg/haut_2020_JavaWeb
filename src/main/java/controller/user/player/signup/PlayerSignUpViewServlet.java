package controller.user.player.signup;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.User;
import service.ItemService;
import service.user.player.PlayerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 转发报名表
 */
@WebServlet(name = "PlayerSignUpViewServlet", value = "/PlayerSignUpViewServlet")
public class PlayerSignUpViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 获取可参赛表
//        ItemService itemService = new ItemService();
//        List<Item> itemList = null;
//        List<Item> tempList = itemService.queryAllItem();
//
//        if (tempList != null) {
//            for (Item item : tempList) {
//                if (!item.isIs_over()) {
//                    if (itemList == null) {
//                        itemList = new ArrayList<>();
//                    }
//                    itemList.add(item);
//                }
//            }
//        }
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.queryAllItemOnGoing();

        // 获取运动员player的参赛表
//        EventPlayerService eventPlayerService = new EventPlayerService();
//        List<EventPlayer> signUpList = eventPlayerService.queryAllEventOfPlayer(user);
        PlayerService playerService = new PlayerService();
        List<EventPlayer> signUpList = playerService.querySignUpList(user);

        request.setAttribute("itemList", itemList);
        request.setAttribute("signUpList", signUpList);

        request.getRequestDispatcher("/view/user/player/signUp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
