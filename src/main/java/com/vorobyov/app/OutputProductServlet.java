package com.vorobyov.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OutputProductServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(OutputProductServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		logger.info("Log: GET");
		System.out.println("Output 10 products");
		
		String products = fillProducts();
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().printf("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>%s</body></html>", products);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		logger.debug("Log: POST");
		System.out.println("Output 10 products");
		
		String products = fillProducts();
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().printf("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>%s</body></html>", products);
	}
	
	public String fillProducts () {
		StringBuilder products = new StringBuilder(
			"<table>" +
				"<tr><th>id</th><th>Наименование</th><th>Цена</th></tr>");
		
		for (int i = 0; i < 10; i++) {
			Product product = new Product(i, "Product_" + i, (i + 1) * 10.5f);
			String str = String.format("<tr><th>%d</th><th>%s</th><th>%.2f</th></tr>", product.id, product.title, product.cost);
			products.append(str);
		}
		
		products.append("</table>");
		return products.toString();
	}
	
	@Override
	public void destroy() {
		logger.debug("Destroy");
	}
	
	@Override
	public void init() {
		logger.debug("Init");
	}
}
