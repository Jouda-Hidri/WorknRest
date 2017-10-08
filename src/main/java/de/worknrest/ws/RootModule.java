package de.worknrest.ws;

import com.google.inject.AbstractModule;

import de.worknrest.ws.jpa.JpaModule;
import de.worknrest.ws.rest.RestServiceModule;

public class RootModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new JpaModule());
		install(new RestServiceModule());

		bind(TestData.class).asEagerSingleton();
	}
}
