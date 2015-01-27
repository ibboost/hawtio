package io.hawt.sample.spring.boot;

import io.hawt.config.ConfigFacade;
import io.hawt.springboot.HawtConfiguration;
import io.hawt.web.plugin.HawtioPlugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class SampleSpringBootService {

    public static void main(String[] args) {
        new SpringApplication(SampleSpringBootService.class,HawtConfiguration.class).run();
    }

	/**
	 * Loading an example plugin
	 * @return
	 */
	@Bean
	public HawtioPlugin samplePlugin() {
		HawtioPlugin plugin = new HawtioPlugin();
	    plugin.setName("sample-plugin");
	    plugin.setScripts(new String[] { "sample-plugin/js/sample-plugin.js" });
	    plugin.setContext("plugins");
	    plugin.setDomain("/hawtio/plugins");
	    plugin.init();
		return plugin;
	}
	
	/**
	 * Set things up to be in offline mode
	 * @return
	 * @throws Exception
	 */
	@Bean
	public ConfigFacade configFacade() throws Exception {
		ConfigFacade config = new ConfigFacade() {
			public boolean isOffline() {
				return true;
			}
		};
		config.init();
		return config;
	}
}
