package projeto.engenharia.software.controle.estoque.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sueny
 */
public class CORSFilterServlet implements Filter {

    public CORSFilterServlet() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        ((HttpServletResponse) response).addHeader(
                "Access-Control-Allow-Origin", "*"
        );
        chain.doFilter(request, response);
    }

}
