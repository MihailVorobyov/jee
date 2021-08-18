package com.vorobyov.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "OutputProductServlet", urlPatterns = "/products")
public class OutputProductServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(OutputProductServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		logger.info("Log: GET");
		System.out.println("Output 10 products");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().printf("<head><meta charset=\"utf-8\"></head><body>%s</body>", showProducts());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		logger.debug("Log: POST");
		System.out.println("Output 10 products");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().printf("<head><meta charset=\"utf-8\"></head><body>%s</body>", showProducts());
	}
	
	public String showProducts() {
		StringBuilder products = new StringBuilder(
				"<table>" +
				"<tr><th>id</th><th>Наименование</th><th>Цена</th></tr>");
		
		for (int i = 1; i < 11; i++) {
			Product product = new Product(i, "Product_" + i, i * 10.5f);
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
