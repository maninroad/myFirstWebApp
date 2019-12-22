package net.implementist.myFirstWebApp;

import net.implementist.myFirstWebApp.PersonalInfo.PersonalInfoDAO;
import net.implementist.myFirstWebApp.User.User;
import net.implementist.myFirstWebApp.User.UserDAO;
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

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            //获得请求中传来的用户名和密码
            String accountNumber = request.getParameter("AccountNumber").trim();
            String password = request.getParameter("Password").trim();
            //密码验证结果
            Boolean verifyResult = verifyRegister(accountNumber, password);
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if (verifyResult) {
                User user=UserDAO.queryUser(accountNumber);
                boolean createInfo= PersonalInfoDAO.InsertPersonalInfo(user.getUserId(),0.0,0.0,0,0,0,0,10,1,0);
                if(createInfo){
                    params.put("Result", "success");
                }
                else{
                    params.put("Result", "failed1");
                }
            } else {
                params.put("Result", "failed2");
            }

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean verifyRegister(String userName, String password) {
        boolean user = UserDAO.insertUser(userName,password);
        return user;
    }
}
