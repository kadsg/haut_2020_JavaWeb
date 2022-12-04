package controller.user.administrator.announce;

import bean.item.Item;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnnounceViewServlet", value = "/AnnounceViewServlet")
public class AnnounceViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService itemService = new ItemService();
        // 获取正在进行的赛事
        List<Item> itemOnGoingList = itemService.queryAllItemOnGoing();
        // 获取已经结束的赛事
        List<Item> itemHasOverList = itemService.queryAllItemHasOver();

        request.setAttribute("itemOnGoingList", itemOnGoingList);
        request.setAttribute("itemHasOverList", itemHasOverList);

        request.getRequestDispatcher("view/user/administrator/announceItem/announceItemIndex.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
