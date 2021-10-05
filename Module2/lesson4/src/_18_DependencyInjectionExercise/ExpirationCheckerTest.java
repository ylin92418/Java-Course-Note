package _18_DependencyInjectionExercise;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExpirationCheckerTest {
    public static void main(String[] args) {

        FakeClock fakeClock = new FakeClock();
        Map<Path, Instant> fakeModifiedTimes = new HashMap<>();
        FakeMetadataFetcher fakeMetadataFetcher = new FakeMetadataFetcher(fakeModifiedTimes);

        Path expired = Path.of("/test/expired");
        Path notExpired = Path.of("/test/not-expired");
        fakeModifiedTimes.put(expired, fakeClock.instant().minus(Duration.ofDays(31)));
        fakeModifiedTimes.put(notExpired, fakeClock.instant().minus(Duration.ofDays(27)));


        Injector injector = Guice.createInjector(
                b -> b.bind(Clock.class).toInstance(fakeClock),
                b -> b.bind(MetadataFetcher.class).toInstance(fakeMetadataFetcher)
        );

        // TODO: Change this code to create an ExpirationChecker using the FakeClock and
        //       FakeMetadataFetcher.
        ExpirationChecker checker = injector.getInstance(ExpirationChecker.class);

        // ExpirationChecker checker = new ExpirationChecker(new FakeClock(), new FakeMetadataFetcher());

        List<Path> expiredFiles =
                checker.getExpiredFiles(List.of(expired, notExpired), Duration.ofDays(28));

        assert expiredFiles.equals(List.of(expired));
    }
}
