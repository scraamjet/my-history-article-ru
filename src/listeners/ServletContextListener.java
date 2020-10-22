package listeners;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import singletons.ConnectionProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setServletContextForTemplateLoading(servletContext, "/WEB-INF/templates");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        servletContext.setAttribute("configuration", configuration);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
