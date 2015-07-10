package example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by TTTALAKUS on 07.07.2015.
 */
@Configuration
public class WebMvc extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("/secure/index.xhtml?faces-redirect=true");
        registry.addViewController("/login").setViewName("login.xhtml");
        registry.addViewController("/login?error").setViewName("login_error.xhtml");
    }
}

