package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.PersonalInfo.PersonalInfo;
import net.implementist.myFirstWebApp.PersonalInfo.PersonalInfoDAO;
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

@WebServlet(name = "UpdatePersonInfoServlet")
public class UpdatePersonInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            //获得请求中传来的用户名和密码
            String id = request.getParameter("Id").trim();
            String height=request.getParameter("Height").trim();
            String weight=request.getParameter("Weight").trim();
            String blood=request.getParameter("Blood").trim();
            String sitUpNumber=request.getParameter("SitupNumber").trim();
            String pushUpNumber=request.getParameter("PushupNumber").trim();
            String pullUp=request.getParameter("PullUp").trim();
            String age=request.getParameter("Age").trim();
            String gender=request.getParameter("Gender").trim();
            String heartBeat=request.getParameter("HeartBeat").trim();
            //密码验证结果
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();
            int myId=Integer.valueOf(id);
            boolean personalInfo = PersonalInfoDAO.updatePersonalInfo(myId,Double.valueOf(height),Double.valueOf(weight), Integer.valueOf(blood), Integer.valueOf(sitUpNumber), Integer.valueOf(pushUpNumber),Integer.valueOf(pullUp),Integer.valueOf(age),Integer.valueOf(gender),Integer.valueOf(heartBeat));
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
