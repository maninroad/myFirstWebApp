package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.Step.Step;
import net.implementist.myFirstWebApp.Step.StepDAO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SearchSomeStepServlet")
public class SearchSomeStepServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            //获得请求中传来的用户名和密码
            String id = request.getParameter("Id").trim();
            String date=request.getParameter("Date".trim());
            //密码验证结果
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            int myId=Integer.valueOf(id);
            Step step = StepDAO.querySomeDayStep(myId,date);
            if (step!=null) {
                params.put("Result", "success");
                params.put("Date",String.valueOf(step.getDate()));
                params.put("StepCount",String.valueOf(step.getStepCount()));
            } else {
                params.put("Result", "failed");
            }

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
