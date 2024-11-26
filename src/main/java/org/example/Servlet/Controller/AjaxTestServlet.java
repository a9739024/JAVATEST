package org.example.Servlet.Controller;

import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/ajaxTest.do")
public class AjaxTestServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String[] interests = request.getParameterValues("interests");

        System.out.println("傳入用戶姓名:" + userName);

        List<String> interestList = new ArrayList<String>(Arrays.asList(interests));
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userName",userName);
        map.put("interestList",interestList);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        JSONObject jsonObject = new JSONObject(map);
        response.getWriter().println(jsonObject);
    }

}
