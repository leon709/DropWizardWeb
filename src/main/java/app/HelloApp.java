package app;

import config.HelloConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.HelloResource;

public class HelloApp extends Application<HelloConfiguration> {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new HelloApp().run(args);
	}

	@Override
	public String getName() {
		return "helloworld";
	}

	@Override
	public void initialize(Bootstrap<HelloConfiguration> bootstrap) {
		// nothing to do yet
		System.out.println("init App.....");
	}

	@Override
	public void run(HelloConfiguration configuration, Environment environment) {
		// nothing to do yet
		System.out.println("run App--------");
		final HelloResource resource = new HelloResource(
	            configuration.getTemplate(),
	            configuration.getDefaultName()
	    );
	    environment.jersey().register(resource);
	}
}
