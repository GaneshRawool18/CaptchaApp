import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/VerifyCaptchaServlet")
public class VerifyCaptchaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userCaptcha = request.getParameter("userCaptcha");
        String generatedCaptcha = request.getParameter("generatedCaptcha");

        HttpSession session = request.getSession();

        if (userCaptcha != null && userCaptcha.equals(generatedCaptcha)) {
            session.setAttribute("message", "✔ CAPTCHA Matched! Welcome, " + username + "!");
        } else {
            session.setAttribute("message", "❌ Incorrect CAPTCHA! Try Again.");
        }

        session.setAttribute("captcha", CaptchaGenerator.generateCaptcha());
        response.sendRedirect("index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write(CaptchaGenerator.generateCaptcha());
    }
}
