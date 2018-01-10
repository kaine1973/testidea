import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
//测试冲突
    protected void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("GBK");
        String abc = request.getParameter("abc");
        abc = new String(abc.getBytes("iso-8859-1"),"GBK");

        try {
            response.getWriter().write(abc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
