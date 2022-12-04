package controller.item;

import bean.item.Item;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisplayScoreIndexServlet", value = "/DisplayScoreIndexServlet")
public class DisplayScoreIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取已结束的赛事表
        ItemService service = new ItemService();
        List<Item> itemList = service.queryAllItemHasOver();

        request.setAttribute("itemList", itemList);

        String identity = request.getParameter("identity");
        String path = "/view/user/" + identity + "/displayScore/displayScoreIndex.jsp";

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
