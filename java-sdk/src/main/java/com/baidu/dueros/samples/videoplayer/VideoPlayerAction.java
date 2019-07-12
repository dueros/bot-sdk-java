package com.baidu.dueros.samples.videoplayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class VideoPlayerAction
 */
@WebServlet("/video")
public class VideoPlayerAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(VideoPlayerAction.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoPlayerAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 实例化一个VideoPlayerBot对象
        VideoPlayerBot videoPlayerBot = new VideoPlayerBot(request);
        logger.info(videoPlayerBot.getStrRequest());
        try {
            // 调用run方法
            String responseJson = videoPlayerBot.run();
            logger.info(responseJson);
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            // 返回response
            response.getWriter().append(responseJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
