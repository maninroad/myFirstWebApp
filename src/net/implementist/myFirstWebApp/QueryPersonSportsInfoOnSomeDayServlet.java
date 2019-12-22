package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.PersonSportsInfo.PersonSportsInfo;
import net.implementist.myFirstWebApp.PersonSportsInfo.PersonSportsInfoDAO;
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

@WebServlet(name = "QueryPersonSportsInfoOnSomeDayServlet")
public class QueryPersonSportsInfoOnSomeDayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("Id").trim();
            String date=request.getParameter("Date").trim();
            //密码验证结果
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            int myId=Integer.valueOf(id);
            ArrayList<PersonSportsInfo> mySteps = PersonSportsInfoDAO.queryPersonSportsInfoOnSomeDay(myId,date);
            if (mySteps.size()!=0) {
                params.put("Result", "success");
                params.put("Number",String.valueOf(mySteps.size()));
                for(int i=0;i<mySteps.size();i++) {
                    params.put("Date"+ i, String.valueOf(mySteps.get(i).getTime()));
                    params.put("SNo"+i,String.valueOf(mySteps.get(i).getSNo()));
                    params.put("Duration"+i,String.valueOf(mySteps.get(i).getDuration()));
                    params.put("Calorie"+i,String.valueOf(mySteps.get(i).getCalorie()));
                    params.put("Type"+i,mySteps.get(i).getType());
                }
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
