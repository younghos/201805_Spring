package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

// 9*9단 출력 custom view
// spring customView를 만들기 위해서는 View interface를 구현할 필요가 있음
public class TimesTablesView implements View {

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>timesTables.html</title>");
		pw.println("		<style type=\"text/css\">");
		pw.println("			td {");
		pw.println("				border : 1px solid pink;");
		pw.println("			}");
		pw.println("		</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table>");
		int j = 1;
		while (j < 10) {
			pw.println("			<tr>");
			int i = (int) model.get("table");
			while (i < 10) {
				pw.println("				<td>" + i + "*" + j + "=" + i * j + "</td>");
				i++;
			}
			pw.println("			</tr>");
			j++;
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");

		pw.flush();
		pw.close();
	}

}
