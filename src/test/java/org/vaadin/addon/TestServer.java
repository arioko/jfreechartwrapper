package org.vaadin.addon;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.vaadin.terminal.gwt.server.ApplicationServlet;

public class TestServer {
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		ServletHolder servletHolder = new ServletHolder(
				ApplicationServlet.class);
		servletHolder.setInitParameter("application",
				JFreeChartWithVaadin.class.getName());
		context.addServlet(servletHolder, "/*");

		server.start();
		server.join();
	}
}
