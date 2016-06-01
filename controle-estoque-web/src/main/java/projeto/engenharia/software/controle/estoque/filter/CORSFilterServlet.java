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
        ((HttpServletResponse) response).addHeader(
                "Access-Control-Allow-Credentials", "true"
        );
        ((HttpServletResponse) response).addHeader(
                "Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS"
        );
        ((HttpServletResponse) response).addHeader(
                "Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"
        );
        
        chain.doFilter(request, response);
    }

}
