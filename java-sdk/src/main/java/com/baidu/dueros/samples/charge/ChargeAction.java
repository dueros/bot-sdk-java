package com.baidu.dueros.samples.charge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChargeAction
 */
@WebServlet("/ChargeAction")
public class ChargeAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doHead(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doHead(HttpServletRequest requestm, HttpServletResponse response) {
        response.setStatus(204);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest requestm, HttpServletResponse response) {
        response.setStatus(204);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ChargeBot chargeBot = new ChargeBot(request);
        chargeBot.disableVerify();

        try {
            String responseJson = chargeBot.run();
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            // 返回response
            response.getWriter().append(responseJson);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.getWriter().append(e.toString());
        }
    }

}
