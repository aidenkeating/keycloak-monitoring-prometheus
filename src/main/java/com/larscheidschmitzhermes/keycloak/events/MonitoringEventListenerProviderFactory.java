package com.larscheidschmitzhermes.keycloak.events;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class MonitoringEventListenerProviderFactory implements EventListenerProviderFactory {
    private String eventsDirectory;
    private String eventsDirectoryEnvName;


    @Override
    public EventListenerProvider create(KeycloakSession session) {
        return new MonitoringEventListenerProvider(eventsDirectory, eventsDirectoryEnvName);
    }

    @Override
    public void init(Config.Scope config) {
        this.eventsDirectory = config.get("eventsDirectory");
        this.eventsDirectoryEnvName = config.get("eventsDirectoryEnvName");
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        //nothing to do
    }

    @Override
    public void close() {
        //nothing to do
    }

    @Override
    public String getId() {
        return "com.larscheidschmitzhermes:keycloak-monitoring-prometheus";
    }
}
