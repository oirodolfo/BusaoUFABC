package xyz.oirodolfo.busaoufabc.utils;

/**
 * Created by Rod on 26/10/2015.
 */

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import xyz.oirodolfo.busaoufabc.domain.Place;

/**
 * Created by viniciusthiengo on 10/12/15.
 */
    public class BusDes implements JsonDeserializer<Object> {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement place = json.getAsJsonArray();

        return ( new Gson().fromJson( place, Place.class ));
    }
}