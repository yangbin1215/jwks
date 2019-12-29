package com.yb.handler;

        import org.springframework.security.core.AuthenticationException;
        import org.springframework.security.web.authentication.AuthenticationFailureHandler;
        import org.springframework.stereotype.Component;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * @author Yangbin
 * @date 2019/12/20 -11:33
 */

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        request.getRequestDispatcher("/").forward(request, response);
    }
}
