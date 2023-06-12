package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test1", loadOnStartup = 2) //need to give instruction to WC: WC reads this only once when web appln deplymnet time
//WC creates an empty map n then populates URL map
//key: /test  value: pages.servlet1
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-Get by " +Thread.currentThread());
		//set response content type (setting a resp headr content type: text/html)
		resp.setContentType("text/html");
		//get PW to send char, buff data (resp) to client
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h4> Welcome to servel: "+getClass()+" TS "+LocalDateTime.now()+"</h4>");
		}//WC calls : pw.flush()--> buff contents are sent --> pw.close
	}

	@Override
	public void destroy() {
		System.out.println("in destroy by " +Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init by " +Thread.currentThread());
	}

}
