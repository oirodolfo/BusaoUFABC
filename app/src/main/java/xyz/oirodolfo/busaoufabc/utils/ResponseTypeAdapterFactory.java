package xyz.oirodolfo.busaoufabc.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

@SuppressWarnings("unused")
public class ResponseTypeAdapterFactory implements TypeAdapterFactory {

    private static final String STATUS = "status";
    private static final String SUCCESS = "success";
    private static final String DATA = "data";

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> jsonElementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegateAdapter.write(out, value);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                // Ignore extraneous data and read in only the response data when the response is a success
                JsonElement jsonElement = jsonElementAdapter.read(in);
                Log.i("TAG", jsonElement.toString());
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has(STATUS)) {
                        if (jsonObject.get(STATUS).getAsString().equals(SUCCESS)) {
                            if (jsonObject.has(DATA) && jsonObject.get(DATA).isJsonObject()) {
                                jsonElement = jsonObject.get(DATA);
                            }
                        }
                    }
                }
                return delegateAdapter.fromJsonTree(jsonElement);
            }
        }.nullSafe();
    }
}