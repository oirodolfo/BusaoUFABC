package xyz.oirodolfo.busaoufabc.API;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import xyz.oirodolfo.busaoufabc.domain.Place;


public interface BusAPI {
/*
    @GET("place/{placeId}")
    Call<Route> getRoute ( @Path("placeId") int placeId);
*/

    @GET("places")
    Call<List<Place>> getRoutes();

}
