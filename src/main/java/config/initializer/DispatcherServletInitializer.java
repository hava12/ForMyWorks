package main.java.config.initializer;

import main.java.config.AppConfig;
import main.java.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("DispatcherServletInitializer.getRootConfigClasses");
        return new Class[]{
            AppConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("DispatcherServletInitializer.getServletConfigClasses");
        return new Class[]{
            WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("DispatcherServletInitializer.getServletMappings");
        return new String[]{
                "/*"
        };
    }
}
