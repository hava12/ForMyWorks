package config.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;

public class Initializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        System.out.println("Initializer.onStartup");

    }
}
