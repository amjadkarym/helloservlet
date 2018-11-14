import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("Name : <input type='text' name='name' /> <br>");
        out.print("Email address : <input type='text' name='email' /> <br>");
        out.print("Problem : <input type='text' name='problem' /> <br>");
        out.print("Description : <textarea name='desc' rows='10' cols='50'></textarea> <br>");
        out.print("<input type='submit' value='help'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();
        String supportEmail = sc.getInitParameter("support-email");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String problem = req.getParameter("problem");
        String desc = req.getParameter("desc");
        String supportTicketId = UUID.randomUUID().toString();
        out.print("<html><head><title>Response from server</title></head><body>");
        out.print("<p>Thank you! "+name+" for contacting us. We should receive reply from us with in 24 hrs in your email address "+email+". Let us know in our support email "+supportEmail+" if you don’t receive reply within 24 hrs. Please be sure to attach your reference "+supportTicketId+" in your email.</p>");
        out.print("</body></html>");
    }
}
