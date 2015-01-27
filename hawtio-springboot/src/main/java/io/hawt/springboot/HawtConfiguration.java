package io.hawt.springboot;

import io.hawt.web.LoginServlet;
import io.hawt.web.LogoutServlet;
import io.hawt.web.PluginServlet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@Controller
public class HawtConfiguration {

	@Bean
	public ServletRegistrationBean pluginServletRegistrationBean() {
		return new ServletRegistrationBean(new PluginServlet(),
				"/hawtio/plugin/*");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hawtio/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/hawtio/refresh")
	public @ResponseBody String refresh() {
		return "ok";
	}

	/*
	 * @Bean public ServletRegistrationBean userServletRegistrationBean() {
	 * return new ServletRegistrationBean(new UserServlet(), "/hawtio/user/*");
	 * }
	 */
	@Bean
	public ServletRegistrationBean loginServletRegistrationBean() {
		return new ServletRegistrationBean(new LoginServlet(),
				"/hawtio/auth/login/*");
	}

	@Bean
	public ServletRegistrationBean logoutServletRegistrationBean() {
		return new ServletRegistrationBean(new LogoutServlet(),
				"/hawtio/auth/logout/*");
	}

}
