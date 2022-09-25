/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yuri9
 */
@WebFilter(urlPatterns="/*")
public class UsuarioSesionFilter implements Filter {

    private static final Set<String> NOT_ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
        Arrays.asList("/ReservaTuEspacioApp/", "/ReservaTuEspacioApp/index.html", "/ReservaTuEspacioApp/crearreserva.html",
                "/ReservaTuEspacioApp/modificarreserva.html", "/ReservaTuEspacioApp/register.html",
                "/ReservaTuEspacioApp/historialdereservas.html")));
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login.html";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean allowedPath = NOT_ALLOWED_PATHS.contains(request.getRequestURI());

        if (!loggedIn && allowedPath) {
            response.sendRedirect(loginURI);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}