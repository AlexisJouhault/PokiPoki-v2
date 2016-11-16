package pokemeows.pokipoki.apis;

import pokemeows.pokipoki.models.responses.CardsResponse;
import pokemeows.pokipoki.models.responses.SetsResponse;
import pokemeows.pokipoki.models.responses.SingleCardResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by alexisjouhault on 7/10/16.
 *
 */
public interface PokemonTCGService {

    @GET("cards")
    Observable<CardsResponse> getAllCards();

    @GET("cards")
    Observable<CardsResponse> getSetCards(
            @Query("setCode") String setId,
            @Query("pageSize") String pageSize);

    @GET("cards/{cardId}")
    Observable<SingleCardResponse> getCard(@Path("cardId") String cardId);

    @GET("sets")
    Observable<SetsResponse> getAllSets();
}
