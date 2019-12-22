package net.implementist.myFirstWebApp;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import net.implementist.myFirstWebApp.User.User;
import net.implementist.myFirstWebApp.User.UserDAO;
import net.sf.json.JSONObject;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            //获得请求中传来的用户名和密码
            String accountNumber = request.getParameter("AccountNumber").trim();
            String password = request.getParameter("Password").trim();
            //密码验证结果
            int verifyResult = verifyLogin(accountNumber, password,out);
            Map<String, String> params = new HashMap<>();
            JSONObject jsonObject = new JSONObject();

            if (verifyResult!=0) {
                params.put("Result", "success");
                params.put("userId",String.valueOf(verifyResult));
            } else {
                params.put("Result", "failed");
            }

            jsonObject.put("params", params);
            out.write(jsonObject.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 验证用户名密码是否正确
     *
     * @param userName
     * @param password
     */
    private int verifyLogin(String userName, String password,PrintWriter myout) {
        User user = UserDAO.queryUser(userName,myout);

        //账户密码验证
        if(user!=null && password.equals(user.getPassword())){
            return user.getUserId();
        }
        else{
            return 0;
        }
    }
}
