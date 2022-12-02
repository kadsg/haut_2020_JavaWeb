package controller.item;

import bean.item.Item;
import service.ItemService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryItemServlet", value = "/QueryItemServlet")
public class QueryItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemService service = new ItemService();
        List<Item> itemList = service.queryAllItem();
        request.setAttribute("itemList", itemList);

        String identity = request.getParameter("identity");
        String path = "/view/user/" + identity + "/queryItem.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
