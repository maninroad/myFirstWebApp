package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.PersonSportsInfo.PersonSportsInfoDAO;
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

@WebServlet(name = "DeletePersonSportsInfoServlet")
public class DeletePersonSportsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            String sNo = request.getParameter("SNo").trim();
            //密码验证结果
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            int myId=Integer.valueOf(sNo);
            boolean personalInfo = PersonSportsInfoDAO.DeletePersonSportsInfo( myId);
            if (personalInfo) {
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
