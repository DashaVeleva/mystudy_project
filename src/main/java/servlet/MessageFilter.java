package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "MessageFilter")
public class MessageFilter extends GenericFilter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
