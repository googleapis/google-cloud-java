package com.google.cloud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/** Representation of a gcloud component */
public class Component {
  private final String id;
  private final String checksum;
  private final URL source;
  private final String fileType;

  static Component fromJson(URL baseUrl, JsonObject componentObj) throws IOException {
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

  static Component create(String id, String checksum, URL source, String fileType) {
    return new Component(id, checksum, source, fileType);
  }

  private Component(String id, String checksum, URL source, String fileType) {
    this.id = id;
    this.checksum = checksum;
    this.source = source;
    this.fileType = fileType;
  }

  String getId() {
    return id;
  }

  String getChecksum() {
    return checksum;
  }

  URL getSource() {
    return source;
  }

  String getFileType() {
    return fileType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Component component = (Component) o;
    return Objects.equals(id, component.id) &&
        Objects.equals(checksum, component.checksum) &&
        Objects.equals(source, component.source) &&
        Objects.equals(fileType, component.fileType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, checksum, source, fileType);
  }
}
