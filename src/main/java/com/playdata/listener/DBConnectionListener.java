package com.playdata.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener

public class DBConnectionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // web xml에서 param으로 지정한 값을 불러오기
        String dbUrl = sce.getServletContext().getInitParameter("DB_URL");
        String dbUser = sce.getServletContext().getInitParameter("DB_USER");
        String dbPassword = sce.getServletContext().getInitParameter("DB_PASSWORD");


        try {
            // driver를 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // connection 객체 생성(생성이 됐다면 db와 연결된 것)
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // 생성된 connection 객체를 ServletContext에 Attribute로 저장
            sce.getServletContext().setAttribute("conn", conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // ServletContext가 종료(was: tomcat 종료) 될 때 Connection 객체를 clase --> 메모리 누수를 방지
        Connection conn = (Connection) sce.getServletContext().getAttribute("conn");
        try {
            //DB Connection 객체를 닫습니다.
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
