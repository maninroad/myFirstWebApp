package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.PersonSportsInfo.PersonSportsInfo;
import net.implementist.myFirstWebApp.PersonSportsInfo.PersonSportsInfoDAO;
import net.implementist.myFirstWebApp.Step.StepDAO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "InsertPersonSportsInfoServlet")
public class InsertPersonSportsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            //获得请求中传来的用户名和密码
            String id = request.getParameter("Id").trim();
            String time=request.getParameter("Date".trim());
            String calorie=request.getParameter("Calorie".trim());
            String type=request.getParameter("Type".trim());
            String duration=request.getParameter("Duration".trim());

            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            int myId=Integer.valueOf(id);
            int durations=Integer.valueOf(duration);
            double calories=Double.valueOf(calorie);
            boolean step = PersonSportsInfoDAO.InsertPersonSportsInfo(myId,time,calories,type,durations);
            if (step) {
                params.put("Result", "success");
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
