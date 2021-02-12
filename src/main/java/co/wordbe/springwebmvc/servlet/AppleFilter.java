package co.wordbe.springwebmvc.servlet;

import javax.servlet.*;
import java.io.IOException;

public class AppleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("Filter init (Apple)");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Filter doFilter (Apple)");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
//        System.out.println("Filter destroy (Apple)");
    }
}
