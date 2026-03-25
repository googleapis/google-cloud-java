package com.google.cloud.external;

import com.google.cloud.model.Advisory;
import com.google.cloud.model.DependencyResponse;
import com.google.cloud.model.Node;
import com.google.cloud.model.QueryResult;
import com.google.cloud.model.Relation;
import com.google.cloud.model.VersionKey;
import com.google.errorprone.annotations.RestrictedApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DepsDevClient is a class that sends HTTP requests to the Deps.dev RESTful API.
 *
 * <p>This class simplifies the process of making API calls by handling authentication, request
 * construction, and response parsing. It uses the {@link java.net.http.HttpClient} for sending
 * requests and {@link com.google.gson.Gson} for handling JSON serialization/deserialization.
 */
public class DepsDevClient {

  private final HttpClient client;
  private final Gson gson;
  private final static String ADVISORY_URL_BASE = "https://api.deps.dev/v3/advisories/%s";

  private final static String DEPENDENCY_URLBASE =
      "https://api.deps.dev/v3/systems/%s/packages/%s/versions/%s:dependencies";

  public final static String QUERY_URL_BASE =
      "https://api.deps.dev/v3/query?versionKey.system=%s&versionKey.name=%s&versionKey.version=%s";

  public DepsDevClient(HttpClient client) {
    this.client = client;
    this.gson = new GsonBuilder()
        .registerTypeAdapter(VersionKey.class, new VersionKeyDeserializer())
        .create();
  }

  public List<VersionKey> getDirectDependencies(VersionKey versionKey)
      throws URISyntaxException, IOException, InterruptedException {
    HttpResponse<String> response = getResponse(
        getDependencyUrl(
            versionKey.pkgManagement().toString(),
            versionKey.name(),
            versionKey.version()
        )
    );
    DependencyResponse dependencyResponse = gson.fromJson(response.body(),
        DependencyResponse.class);
    return dependencyResponse
        .nodes()
        .stream()
        .filter(node -> Relation.DIRECT.equals(node.relation()))
        .map(Node::versionKey)
        .collect(Collectors.toList());
  }

  public QueryResult getQueryResult(VersionKey versionKey)
      throws URISyntaxException, IOException, InterruptedException {
    HttpResponse<String> response = getResponse(
        getQueryUrl(
            versionKey.pkgManagement().toString(),
            versionKey.name(),
            versionKey.version()
        )
    );
    return gson.fromJson(response.body(), QueryResult.class);
  }

  public Advisory getAdvisory(String advisoryId)
      throws URISyntaxException, IOException, InterruptedException {
    HttpResponse<String> response = getResponse(getAdvisoryUrl(advisoryId));
    return gson.fromJson(response.body(), Advisory.class);
  }

  private String getAdvisoryUrl(String advisoryId) {
    return String.format(ADVISORY_URL_BASE, advisoryId);
  }

  @RestrictedApi(
      explanation = "This method is for internal use only.",
      allowedOnPath = "test/java/com/google/cloud/external")
  public String getQueryUrl(String system, String name, String version) {
    return String.format(QUERY_URL_BASE, system, name, encode(version));
  }

  @RestrictedApi(
      explanation = "This method is for internal use only.",
      allowedOnPath = "test/java/com/google/cloud/external")
  public String getDependencyUrl(String system, String name, String version) {
    return String.format(DEPENDENCY_URLBASE, system, name, encode(version));
  }

  private String encode(String str) {
    return URLEncoder.encode(str, StandardCharsets.UTF_8);
  }

  private HttpResponse<String> getResponse(String endpoint)
      throws URISyntaxException, IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder().uri(new URI(endpoint)).GET().build();
    return client.send(request, BodyHandlers.ofString());
  }

  static class VersionKeyDeserializer implements JsonDeserializer<VersionKey> {

    @Override
    public VersionKey deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException {
      String system = context.deserialize(json.getAsJsonObject().get("system"), String.class);
      String name = context.deserialize(json.getAsJsonObject().get("name"), String.class);
      String version = context.deserialize(json.getAsJsonObject().get("version"), String.class);
      return VersionKey.from(system, name, version);
    }
  }
}
