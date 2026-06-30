package com.google.cloud.external;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.model.AdvisoryKey;
import com.google.cloud.model.QueryResult;
import com.google.cloud.model.Version;
import com.google.cloud.model.VersionKey;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DepsDevClientTest {

  private HttpResponse<String> response;
  private DepsDevClient client;

  @Before
  public void setUp() throws IOException, InterruptedException {
    HttpClient httpClient = mock(HttpClient.class);
    client = new DepsDevClient(httpClient);
    response = mock(HttpResponse.class);
    when(httpClient.send(any(HttpRequest.class), any(BodyHandler.class)))
        .thenReturn(response);
  }

  @Test
  public void testGetQueryUrlReturnsEncodedUrl() {
    assertEquals(
        "https://api.deps.dev/v3/query?versionKey.system=MAVEN&versionKey.name=com.google.errorprone:javac-shaded&versionKey.version=9%2B181-r4173-1",
        client.getQueryUrl("MAVEN", "com.google.errorprone:javac-shaded", "9+181-r4173-1"));
  }

  @Test
  public void testGetDependenciesReturnsEncodedUrl() {
    assertEquals(
        "https://api.deps.dev/v3/systems/MAVEN/packages/com.google.errorprone:javac-shaded/versions/9%2B181-r4173-1:dependencies",
        client.getDependencyUrl("MAVEN", "com.google.errorprone:javac-shaded", "9+181-r4173-1"));
  }

  @Test
  public void testGetDirectDependenciesOnlyReturnsDirectDeps()
      throws IOException, InterruptedException, URISyntaxException, IllegalArgumentException {
    String responseBody = "{\"nodes\":[{\"versionKey\":{\"system\":\"MAVEN\", \"name\":\"com.example:example\", \"version\":\"1.2.3\"}, \"bundled\":false, \"relation\":\"SELF\", \"errors\":[]}, {\"versionKey\":{\"system\":\"MAVEN\", \"name\":\"com.example:indirect-dep\", \"version\":\"4.0.0\"}, \"bundled\":false, \"relation\":\"INDIRECT\", \"errors\":[]}, {\"versionKey\":{\"system\":\"MAVEN\", \"name\":\"com.example:direct-dep\", \"version\":\"1.4.0\"}, \"bundled\":false, \"relation\":\"DIRECT\", \"errors\":[]}], \"edges\":[{\"fromNode\":0, \"toNode\":2, \"requirement\":\"^1.1.0\"}, {\"fromNode\":2, \"toNode\":1, \"requirement\":\"^3.0.0 || ^4.0.0\"}], \"error\":\"\"}";
    when(response.body()).thenReturn(responseBody);
    VersionKey example = VersionKey.from("maven", "com.example:example", "1.2.3");
    VersionKey direct = VersionKey.from("maven", "com.example:direct-dep", "1.4.0");
    List<VersionKey> coordinates = client.getDirectDependencies(example);
    assertThat(coordinates).containsExactlyElementsIn(List.of(direct));
  }

  @Test
  public void testGetQueryResultSucceed()
      throws URISyntaxException, IOException, InterruptedException, IllegalArgumentException {
    String responseBody = "{\"results\":[{\"version\":{\"versionKey\":{\"system\":\"MAVEN\",\"name\":\"org.apache.logging.log4j:log4j-core\",\"version\":\"2.17.0\"},\"publishedAt\":\"2021-12-18T01:58:10Z\",\"isDefault\":false,\"licenses\":[\"Apache-2.0\"],\"advisoryKeys\":[{\"id\":\"GHSA-8489-44mv-ggj8\"}],\"links\":[{\"label\":\"SOURCE_REPO\",\"url\":\"https://gitbox.apache.org/repos/asf?p=logging-log4j2.git\"},{\"label\":\"ISSUE_TRACKER\",\"url\":\"https://issues.apache.org/jira/browse/LOG4J2\"},{\"label\":\"HOMEPAGE\",\"url\":\"https://logging.apache.org/log4j/2.x/\"}],\"slsaProvenances\":[],\"registries\":[\"https://repo.maven.apache.org/maven2/\"],\"relatedProjects\":[{\"projectKey\":{\"id\":\"\"},\"relationProvenance\":\"UNVERIFIED_METADATA\",\"relationType\":\"ISSUE_TRACKER\"}]}}]}";
    when(response.body()).thenReturn(responseBody);
    VersionKey log4jCore =
        VersionKey.from("maven", "org.apache.logging.log4j:log4j-core", "2.17.0");
    QueryResult queryResult = client.getQueryResult(log4jCore);
    assertThat(queryResult.results()).hasSize(1);
    Version version = queryResult.results().get(0).version();
    assertThat(version.advisoryKeys()).isEqualTo(List.of(new AdvisoryKey("GHSA-8489-44mv-ggj8")));
    assertThat(version.licenses()).isEqualTo(List.of("Apache-2.0"));
    assertThat(version.versionKey()).isEqualTo(log4jCore);
  }
}
