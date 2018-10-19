package com.google.cloud;

import com.google.auto.value.AutoValue;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;

/** Representation of a gcloud component */
@AutoValue
public abstract class Component {
  public static Component create(String id, String checksum, URL source, String fileType) {
    return new AutoValue_Component(id, checksum, source, fileType);
  }

  public static Component fromJson(URL baseUrl, JsonObject componentObj) throws IOException {
    String id = componentObj.get("id").getAsString();

    JsonElement data = componentObj.get("data");
    if (data == null) {
      throw new NullPointerException("Component " + id + " is missing a data section");
    }

    return create(
        id,
        data.getAsJsonObject().get("checksum").getAsString(),
        new URL(baseUrl, data.getAsJsonObject().get("source").getAsString()),
        data.getAsJsonObject().get("type").getAsString()
    );
  }

  public abstract String getId();
  public abstract String getChecksum();
  public abstract URL getSource();
  public abstract String getFileType();
}
