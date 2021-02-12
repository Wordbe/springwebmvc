package co.wordbe.springwebmvc.servlet;

import co.wordbe.springwebmvc.spring.MangoService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MangoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
//        System.out.println("mango servlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("mango servlet doGet");

        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        MangoService mangoService = context.getBean(MangoService.class);

        resp.getWriter().println("<html><head></head><body>");
        resp.getWriter().println("<h1>Welcome Mango</h1>");
//        resp.getWriter().println("<p>" + getServletContext().getAttribute("name") + "</p>");
        resp.getWriter().println("<p>" + mangoService.getName() + "</p>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    public void destroy() {
//        System.out.println("mango servlet destroy");
    }
}
