package pokemeows.pokipoki.presenters;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Toshiba on 7/11/2016.
 */

public interface Presenter<T> {
//    public void onTakeView(T view);
    public void publish();
    public void onDestroy();
}
