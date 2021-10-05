package _18_DependencyInjectionExercise;

import com.google.inject.AbstractModule;

import java.time.Clock;

public final class ExpirationCheckerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Clock.class).toInstance(Clock.systemUTC());
        bind(MetadataFetcher.class).to(MetadataFetcherImpl.class);

        // TODO: Fill this module in:
        //       1. Bind the Clock interface to Clock.systemUTC()
        //       2. Bind the MetadataFetcher interface to MetadataFetcherImpl
    }
}
