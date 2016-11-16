package pokemeows.pokipoki.data.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pokemeows.pokipoki.contracts.EventsContract;

/**
 * Created by Toshiba on 10/11/2016.
 */

@Module
public class EventsModule {

    private final EventsContract.View mEventsView;

    public EventsModule(EventsContract.View mEventsView) {
        this.mEventsView = mEventsView;
    }

    @Singleton
    @Provides
    public EventsContract.View provideEventsView() {
        return mEventsView;
    }
}
