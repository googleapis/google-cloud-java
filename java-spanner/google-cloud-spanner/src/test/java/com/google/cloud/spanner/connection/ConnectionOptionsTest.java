/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionOptions.Builder.EXTERNAL_HOST_PATTERN;
import static com.google.cloud.spanner.connection.ConnectionOptions.Builder.SPANNER_URI_PATTERN;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENDPOINT;
import static com.google.cloud.spanner.connection.ConnectionOptions.determineHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionOptionsTest {
  private static final String FILE_TEST_PATH =
      Objects.requireNonNull(ConnectionOptionsTest.class.getResource("test-key.json")).getFile();
  private static final String DEFAULT_HOST = null;
  private static final String TEST_PROJECT = "test-project-123";
  private static final String TEST_INSTANCE = "test-instance-123";
  private static final String TEST_DATABASE = "test-database-123";

  @Test
  public void testBuildWithURIWithDots() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/some-company.com:test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo(DEFAULT_HOST);
    assertThat(options.getProjectId()).isEqualTo("some-company.com:test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(ConnectionOptions.DEFAULT_AUTOCOMMIT);
    assertThat(options.isReadOnly()).isEqualTo(ConnectionOptions.DEFAULT_READONLY);
  }

  @Test
  public void testBuildWithValidURIAndCredentialsFileURL() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo(DEFAULT_HOST);
    assertThat(options.getProjectId()).isEqualTo("test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(ConnectionOptions.DEFAULT_AUTOCOMMIT);
    assertThat(options.isReadOnly()).isEqualTo(ConnectionOptions.DEFAULT_READONLY);
  }

  @Test
  public void testBuildWithValidURIAndProperties() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autocommit=false;readonly=true");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo(DEFAULT_HOST);
    assertThat(options.getProjectId()).isEqualTo("test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(false);
    assertThat(options.isReadOnly()).isEqualTo(true);
  }

  @Test
  public void testBuildWithHostAndValidURI() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner://test-spanner.googleapis.com/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo("https://test-spanner.googleapis.com");
    assertThat(options.getProjectId()).isEqualTo("test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(ConnectionOptions.DEFAULT_AUTOCOMMIT);
    assertThat(options.isReadOnly()).isEqualTo(ConnectionOptions.DEFAULT_READONLY);
  }

  @Test
  public void testBuildWithLocalhostPortAndValidURI() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner://localhost:8443/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo("https://localhost:8443");
    assertThat(options.getProjectId()).isEqualTo("test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(ConnectionOptions.DEFAULT_AUTOCOMMIT);
    assertThat(options.isReadOnly()).isEqualTo(ConnectionOptions.DEFAULT_READONLY);
  }

  @Test
  public void testBuildWithAutoConfigEmulator() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autoConfigEmulator=true");
    ConnectionOptions options = builder.build();
    assertEquals("http://localhost:9010", options.getHost());
    assertEquals("test-project-123", options.getProjectId());
    assertEquals("test-instance-123", options.getInstanceId());
    assertEquals("test-database-123", options.getDatabaseName());
    assertEquals(NoCredentials.getInstance(), options.getCredentials());
    assertTrue(options.isUsePlainText());
  }

  @Test
  public void testDetermineHost() {
    final String uriWithoutHost =
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123";
    Matcher matcherWithoutHost = SPANNER_URI_PATTERN.matcher(uriWithoutHost);
    assertTrue(matcherWithoutHost.find());
    final String uriWithHost =
        "cloudspanner://custom.host.domain:1234/projects/test-project-123/instances/test-instance-123/databases/test-database-123";
    Matcher matcherWithHost = SPANNER_URI_PATTERN.matcher(uriWithHost);
    assertTrue(matcherWithHost.find());

    assertEquals(
        DEFAULT_HOST,
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ false,
            ImmutableMap.of()));
    assertEquals(
        DEFAULT_HOST,
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ false,
            ImmutableMap.of("FOO", "bar")));
    assertEquals(
        "http://localhost:9010",
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ false,
            ImmutableMap.of()));
    assertEquals(
        "http://localhost:9011",
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ false,
            ImmutableMap.of("SPANNER_EMULATOR_HOST", "localhost:9011")));
    assertEquals(
        "http://localhost:9010",
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ true,
            ImmutableMap.of()));
    assertEquals(
        "http://localhost:9011",
        determineHost(
            matcherWithoutHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ true,
            ImmutableMap.of("SPANNER_EMULATOR_HOST", "localhost:9011")));

    // A host in the connection string has precedence over all other options.
    assertEquals(
        "https://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ false,
            ImmutableMap.of()));
    assertEquals(
        "http://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ true,
            ImmutableMap.of()));
    assertEquals(
        "http://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ true,
            ImmutableMap.of()));
    assertEquals(
        "https://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ false,
            ImmutableMap.of()));
    assertEquals(
        "http://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ true,
            ImmutableMap.of("SPANNER_EMULATOR_HOST", "localhost:9011")));
    assertEquals(
        "https://custom.host.domain:1234",
        determineHost(
            matcherWithHost,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ false,
            ImmutableMap.of("SPANNER_EMULATOR_HOST", "localhost:9011")));

    // The 'endpoint' connection URL property can also be used to connect to the emulator.
    // Using this property is sometimes easier than adding the URL to the host part of the
    // connection string, for example because it can be added to the Properties object that
    // is used by JDBC.
    assertEquals(
        "http://localhost:9010",
        determineHost(
            matcherWithoutHost,
            "localhost:9010",
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ true,
            ImmutableMap.of()));
    // A value for the 'endpoint' connection property overrides any value in the host group.
    assertEquals(
        "https://my.endpoint:1234",
        determineHost(
            matcherWithHost,
            "my.endpoint:1234",
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ false,
            ImmutableMap.of("SPANNER_EMULATOR_HOST", "localhost:9011")));
    assertEquals(
        "http://my.endpoint.local:1234",
        determineHost(
            matcherWithHost,
            "my.endpoint.local:1234",
            /* autoConfigEmulator= */ false,
            /* usePlainText= */ true,
            ImmutableMap.of()));
  }

  @Test
  public void testBuildWithRouteToLeader() {
    final String BASE_URI =
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123";
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(BASE_URI + "?routeToLeader=false");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertEquals(options.getHost(), DEFAULT_HOST);
    assertEquals(options.getProjectId(), TEST_PROJECT);
    assertEquals(options.getInstanceId(), TEST_INSTANCE);
    assertEquals(options.getDatabaseName(), TEST_DATABASE);
    assertFalse(options.isRouteToLeader());

    // Test for default behavior for routeToLeader property.
    builder = ConnectionOptions.newBuilder().setUri(BASE_URI);
    builder.setCredentialsUrl(FILE_TEST_PATH);
    options = builder.build();
    assertTrue(options.isRouteToLeader());
  }

  @Test
  public void testBuildWithEndToEndTracingEnabled() {
    final String BASE_URI =
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123";
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(BASE_URI + "?enableEndToEndTracing=true");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertEquals(options.getHost(), DEFAULT_HOST);
    assertEquals(options.getProjectId(), TEST_PROJECT);
    assertEquals(options.getInstanceId(), TEST_INSTANCE);
    assertEquals(options.getDatabaseName(), TEST_DATABASE);
    assertTrue(options.isEndToEndTracingEnabled());

    // Test for default behavior for enableEndToEndTracing property.
    builder = ConnectionOptions.newBuilder().setUri(BASE_URI);
    builder.setCredentialsUrl(FILE_TEST_PATH);
    options = builder.build();
    assertFalse(options.isEndToEndTracingEnabled());
  }

  @Test
  public void testBuildWithAutoConfigEmulatorAndHost() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner://central-emulator.local:8080/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autoConfigEmulator=true");
    ConnectionOptions options = builder.build();
    assertEquals("http://central-emulator.local:8080", options.getHost());
    assertEquals("test-project-123", options.getProjectId());
    assertEquals("test-instance-123", options.getInstanceId());
    assertEquals("test-database-123", options.getDatabaseName());
    assertEquals(NoCredentials.getInstance(), options.getCredentials());
    assertTrue(options.isUsePlainText());
  }

  @Test
  public void testBuildWithAutoConfigEmulatorAndEndpoint() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autoConfigEmulator=true;endpoint=central-emulator.local:8080");
    ConnectionOptions options = builder.build();
    assertEquals("http://central-emulator.local:8080", options.getHost());
    assertEquals("test-project-123", options.getProjectId());
    assertEquals("test-instance-123", options.getInstanceId());
    assertEquals("test-database-123", options.getDatabaseName());
    assertEquals(NoCredentials.getInstance(), options.getCredentials());
    assertTrue(options.isUsePlainText());
  }

  @Test
  public void testBuildWithDefaultProjectPlaceholder() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/default_project_id/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo(DEFAULT_HOST);
    String projectId = SpannerOptions.getDefaultProjectId();
    if (projectId == null) {
      projectId =
          ((ServiceAccountCredentials) new CredentialsService().createCredentials(FILE_TEST_PATH))
              .getProjectId();
    }
    assertThat(options.getProjectId()).isEqualTo(projectId);
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(ConnectionOptions.DEFAULT_AUTOCOMMIT);
    assertThat(options.isReadOnly()).isEqualTo(ConnectionOptions.DEFAULT_READONLY);
  }

  @Test
  public void testBuilderSetUri() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();

    // set valid uri's
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database");
    builder.setUri("cloudspanner:/projects/test-project-123/instances/test-instance");
    builder.setUri("cloudspanner:/projects/test-project-123");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance/databases/test-database");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance");
    builder.setUri("cloudspanner://spanner.googleapis.com/projects/test-project-123");

    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?autocommit=true");
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance?autocommit=true");
    builder.setUri("cloudspanner:/projects/test-project-123?autocommit=true");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance/databases/test-database?autocommit=true");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance?autocommit=true");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123?autocommit=true");

    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?autocommit=true;readonly=false");
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance?autocommit=true;readonly=false");
    builder.setUri("cloudspanner:/projects/test-project-123?autocommit=true;readonly=false");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance/databases/test-database?autocommit=true;readonly=false");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/instances/test-instance?autocommit=true;readonly=false");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123?autocommit=true;readonly=false");
    builder.setUri(
        "cloudspanner://spanner.googleapis.com/projects/test-project-123?statement_timeout='10s';transaction_timeout='60s'");

    // set invalid uri's
    setInvalidUri(
        builder, "/projects/test-project-123/instances/test-instance/databases/test-database");
    setInvalidUri(builder, "cloudspanner:/test-project-123/test-instance/test-database");
    setInvalidUri(
        builder,
        "cloudspanner:spanner.googleapis.com/projects/test-project-123/instances/test-instance/databases/test-database");
    setInvalidUri(
        builder,
        "cloudspanner://spanner.googleapis.com/projects/test-project-$$$/instances/test-instance/databases/test-database");
    setInvalidUri(
        builder,
        "cloudspanner://spanner.googleapis.com/projects/test-project-123/databases/test-database");
    setInvalidUri(
        builder,
        "cloudspanner:/projects/test_project_123/instances/test-instance/databases/test-database");

    // Set URI's that are valid, but that contain unknown properties.
    setInvalidProperty(
        builder,
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?read=false",
        "read");
    setInvalidProperty(
        builder,
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?read=false;autocommit=true",
        "read");
    setInvalidProperty(
        builder,
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?read=false;auto=true",
        "read, auto");
  }

  private void setInvalidUri(ConnectionOptions.Builder builder, String uri) {
    assertThrows(IllegalArgumentException.class, () -> builder.setUri(uri));
  }

  private void setInvalidProperty(
      ConnectionOptions.Builder builder, String uri, String expectedInvalidProperties) {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> builder.setUri(uri));
    assertTrue(exception.getMessage(), exception.getMessage().contains(expectedInvalidProperties));
  }

  @Test
  public void testParseUriProperty() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

    assertThat(ConnectionOptions.parseUriProperty(baseUri, "autocommit")).isNull();
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?autocommit=true", "autocommit"))
        .isEqualTo("true");
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?autocommit=false", "autocommit"))
        .isEqualTo("false");
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?autocommit=true;", "autocommit"))
        .isEqualTo("true");
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?autocommit=false;", "autocommit"))
        .isEqualTo("false");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?autocommit=true;readOnly=false", "autocommit"))
        .isEqualTo("true");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?autocommit=false;readOnly=false", "autocommit"))
        .isEqualTo("false");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?readOnly=false;autocommit=true", "autocommit"))
        .isEqualTo("true");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?readOnly=false;autocommit=false", "autocommit"))
        .isEqualTo("false");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?readOnly=false;autocommit=true;foo=bar", "autocommit"))
        .isEqualTo("true");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?readOnly=false;autocommit=false;foo=bar", "autocommit"))
        .isEqualTo("false");

    // case insensitive
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?AutoCommit=true", "autocommit"))
        .isEqualTo("true");
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?AutoCommit=false", "autocommit"))
        .isEqualTo("false");

    // ; instead of ? before the properties is ok
    assertThat(ConnectionOptions.parseUriProperty(baseUri + ";autocommit=true", "autocommit"))
        .isEqualTo("true");

    // forgot the ? or ; before the properties
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "autocommit=true", "autocommit"))
        .isNull();
    // substring is not ok
    assertThat(ConnectionOptions.parseUriProperty(baseUri + "?isautocommit=true", "autocommit"))
        .isNull();
  }

  @Test
  public void testParseProperties() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    assertThat(ConnectionOptions.parseProperties(baseUri + "?autocommit=true"))
        .isEqualTo(Collections.singletonList("autocommit"));
    assertThat(ConnectionOptions.parseProperties(baseUri + "?autocommit=true;readonly=false"))
        .isEqualTo(Arrays.asList("autocommit", "readonly"));
    assertThat(ConnectionOptions.parseProperties(baseUri + "?autocommit=true;READONLY=false"))
        .isEqualTo(Arrays.asList("autocommit", "READONLY"));
    assertThat(ConnectionOptions.parseProperties(baseUri + ";autocommit=true;readonly=false"))
        .isEqualTo(Arrays.asList("autocommit", "readonly"));
    assertThat(ConnectionOptions.parseProperties(baseUri + ";autocommit=true;readonly=false;"))
        .isEqualTo(Arrays.asList("autocommit", "readonly"));
  }

  @Test
  public void testParsePropertiesSpecifiedMultipleTimes() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?autocommit=true;autocommit=false", "autocommit"))
        .isEqualTo("true");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + "?autocommit=false;autocommit=true", "autocommit"))
        .isEqualTo("false");
    assertThat(
            ConnectionOptions.parseUriProperty(
                baseUri + ";autocommit=false;readonly=false;autocommit=true", "autocommit"))
        .isEqualTo("false");
    ConnectionOptions.newBuilder()
        .setUri(
            "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                + ";autocommit=false;readonly=false;autocommit=true");
  }

  @Test
  public void testParseOAuthToken() {
    assertThat(
            ConnectionOptions.parseUriProperty(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?oauthtoken=RsT5OjbzRn430zqMLgV3Ia",
                "OAuthToken"))
        .isEqualTo("RsT5OjbzRn430zqMLgV3Ia");
    // Try to use both credentials and an OAuth token. That should fail.
    ConnectionOptions.Builder builder =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?OAuthToken=RsT5OjbzRn430zqMLgV3Ia;credentials=/path/to/credentials.json");
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, builder::build);
    assertTrue(
        exception.getMessage(),
        exception
            .getMessage()
            .contains(
                "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider and"
                    + " OAuth token"));

    // Now try to use only an OAuth token.
    builder =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?OAuthToken=RsT5OjbzRn430zqMLgV3Ia");
    ConnectionOptions options = builder.build();
    assertThat(options.getCredentials()).isInstanceOf(GoogleCredentials.class);
    GoogleCredentials credentials = (GoogleCredentials) options.getCredentials();
    assertThat(credentials.getAccessToken().getTokenValue()).isEqualTo("RsT5OjbzRn430zqMLgV3Ia");
  }

  @Test
  public void testSetOAuthToken() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setOAuthToken("RsT5OjbzRn430zqMLgV3Ia")
            .build();
    assertThat(options.getCredentials()).isInstanceOf(GoogleCredentials.class);
    GoogleCredentials credentials = (GoogleCredentials) options.getCredentials();
    assertThat(credentials.getAccessToken()).isNotNull();
    assertThat(credentials.getAccessToken().getTokenValue()).isEqualTo("RsT5OjbzRn430zqMLgV3Ia");
  }

  @Test
  public void testSetOAuthTokenAndCredentials() {
    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setUri(
                        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
                    .setOAuthToken("RsT5OjbzRn430zqMLgV3Ia")
                    .setCredentialsUrl(FILE_TEST_PATH)
                    .build());
    assertTrue(
        exception.getMessage(),
        exception
            .getMessage()
            .contains(
                "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider and"
                    + " OAuth token"));
  }

  @Test
  public void testLenient() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?lenient=true;foo=bar")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertThat(options.getWarnings()).isNotNull();
    assertThat(options.getWarnings()).contains("foo");
    assertThat(options.getWarnings()).doesNotContain("lenient");

    options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?bar=foo;lenient=true")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertThat(options.getWarnings()).isNotNull();
    assertThat(options.getWarnings()).contains("bar");
    assertThat(options.getWarnings()).doesNotContain("lenient");

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setUri(
                        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?bar=foo")
                    .setCredentialsUrl(FILE_TEST_PATH)
                    .build());
    assertTrue(exception.getMessage(), exception.getMessage().contains("bar"));
  }

  @Test
  public void testMinSessions() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?minSessions=400")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertThat(options.getMinSessions()).isEqualTo(400);
    assertThat(options.getSessionPoolOptions().getMinSessions()).isEqualTo(400);
  }

  @Test
  public void testMaxSessions() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxSessions=4000")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertThat(options.getMaxSessions()).isEqualTo(4000);
    assertThat(options.getSessionPoolOptions().getMaxSessions()).isEqualTo(4000);
  }

  @Test
  public void testTrackSessionLeaks() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?trackSessionLeaks=false")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertFalse(options.getSessionPoolOptions().isTrackStackTraceOfSessionCheckout());
  }

  @Test
  public void testTrackSessionLeaksDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertTrue(options.getSessionPoolOptions().isTrackStackTraceOfSessionCheckout());
  }

  @Test
  public void testTrackConnectionLeaks() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?trackConnectionLeaks=false")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertFalse(options.isTrackConnectionLeaks());
  }

  @Test
  public void testTrackConnectionLeaksDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertTrue(options.isTrackConnectionLeaks());
  }

  @Test
  public void testDataBoostEnabled() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?dataBoostEnabled=true")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertTrue(options.isDataBoostEnabled());
  }

  @Test
  public void testDataBoostEnabledDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertFalse(options.isDataBoostEnabled());
  }

  @Test
  public void testAutoPartitionMode() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?autoPartitionMode=true")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertTrue(options.isAutoPartitionMode());
  }

  @Test
  public void testAutoPartitionModeDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertFalse(options.isAutoPartitionMode());
  }

  @Test
  public void testMaxPartitions() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitions=4")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertEquals(4, options.getMaxPartitions());
  }

  @Test
  public void testMaxPartitionsDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertEquals(0, options.getMaxPartitions());
  }

  @Test
  public void testMaxPartitionsInvalidValue() {
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitions=-1")
                .setCredentialsUrl(FILE_TEST_PATH)
                .build());
  }

  @Test
  public void testMaxPartitionsNonNumeric() {
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitions=four")
                .setCredentialsUrl(FILE_TEST_PATH)
                .build());
  }

  @Test
  public void testMaxPartitionedParallelism() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitionedParallelism=4")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertEquals(4, options.getMaxPartitionedParallelism());
  }

  @Test
  public void testMaxPartitionedParallelismDefault() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertEquals(1, options.getMaxPartitionedParallelism());
  }

  @Test
  public void testMaxPartitionedParallelismInvalidValue() {
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitionedParallelism=-1")
                .setCredentialsUrl(FILE_TEST_PATH)
                .build());
  }

  @Test
  public void testMaxPartitionedParallelismNonNumeric() {
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxPartitionedParallelism=four")
                .setCredentialsUrl(FILE_TEST_PATH)
                .build());
  }

  @Test
  public void testLocalConnectionError() {
    String uri =
        "cloudspanner://localhost:1/projects/test-project/instances/test-instance/databases/test-database?usePlainText=true";
    ConnectionOptions options = ConnectionOptions.newBuilder().setUri(uri).build();
    SpannerException exception = assertThrows(SpannerException.class, options::getConnection);
    assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());
    assertTrue(
        exception.getMessage(),
        exception
            .getMessage()
            .contains(
                String.format(
                    "The connection string '%s' contains host 'localhost:1', but no running",
                    uri)));
  }

  @Test
  public void testInvalidCredentials() {
    String uri =
        "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentials=/some/non/existing/path";
    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    assertTrue(
        exception.getMessage(),
        exception
            .getMessage()
            .contains("Invalid credentials path specified: /some/non/existing/path"));
  }

  @Test
  public void testNonBase64EncodedCredentials() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
          String uri =
              "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials=not-a-base64-string/";
          SpannerException e =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
          assertThat(e.getMessage())
              .contains("The encoded credentials could not be decoded as a base64 string.");
        });
  }

  @Test
  public void testInvalidEncodedCredentials() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials=%s",
                  BaseEncoding.base64Url()
                      .encode("not-a-credentials-JSON-string".getBytes(StandardCharsets.UTF_8)));
          SpannerException e =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
          assertThat(e.getMessage())
              .contains(
                  "The encoded credentials do not contain a valid Google Cloud credentials JSON"
                      + " string.");
        });
  }

  @Test
  public void testValidEncodedCredentials() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
          String encoded =
              BaseEncoding.base64Url().encode(Files.asByteSource(new File(FILE_TEST_PATH)).read());
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials=%s",
                  encoded);

          ConnectionOptions options = ConnectionOptions.newBuilder().setUri(uri).build();
          assertEquals(
              new CredentialsService().createCredentials(FILE_TEST_PATH), options.getCredentials());
        });
  }

  @Test
  public void testValidEncodedCredentials_WithoutEnablingProperty() throws Throwable {
    String encoded =
        BaseEncoding.base64Url().encode(Files.asByteSource(new File(FILE_TEST_PATH)).read());
    String uri =
        String.format(
            "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?encodedCredentials=%s",
            encoded);

    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testSetCredentialsAndEncodedCredentials() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
          String encoded =
              BaseEncoding.base64Url().encode(Files.asByteSource(new File(FILE_TEST_PATH)).read());
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentials=%s;encodedCredentials=%s",
                  FILE_TEST_PATH, encoded);

          IllegalArgumentException e =
              assertThrows(
                  IllegalArgumentException.class,
                  () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertTrue(
              e.getMessage(),
              e.getMessage()
                  .contains(
                      "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider"
                          + " and OAuth token"));
        });
  }

  public static class TestCredentialsProvider implements CredentialsProvider {
    @Override
    public Credentials getCredentials() {
      return NoCredentials.getInstance();
    }
  }

  static void runWithSystemPropertyEnabled(String systemPropertyName, ThrowingRunnable runnable)
      throws Throwable {
    String originalValue = System.getProperty(systemPropertyName);
    System.setProperty(systemPropertyName, "true");
    try {
      runnable.run();
    } finally {
      if (originalValue == null) {
        System.clearProperty(systemPropertyName);
      } else {
        System.setProperty(systemPropertyName, originalValue);
      }
    }
  }

  @Test
  public void testValidCredentialsProvider() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  TestCredentialsProvider.class.getName());

          ConnectionOptions options = ConnectionOptions.newBuilder().setUri(uri).build();
          assertEquals(NoCredentials.getInstance(), options.getCredentials());
        });
  }

  @Test
  public void testValidCredentialsProvider_WithoutEnablingSystemProperty() {
    String uri =
        String.format(
            "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
            TestCredentialsProvider.class.getName());
    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
    assertEquals(
        "FAILED_PRECONDITION: credentialsProvider can only be used if the system property"
            + " ENABLE_CREDENTIALS_PROVIDER has been set to true. Start the application with the"
            + " JVM command line option -DENABLE_CREDENTIALS_PROVIDER=true",
        exception.getMessage());
  }

  @Test
  public void testSetCredentialsAndCredentialsProvider() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentials=%s;credentialsProvider=%s",
                  FILE_TEST_PATH, NoCredentialsProvider.class.getName());

          IllegalArgumentException e =
              assertThrows(
                  IllegalArgumentException.class,
                  () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertTrue(
              e.getMessage(),
              e.getMessage()
                  .contains(
                      "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider"
                          + " and OAuth token"));
        });
  }

  @Test
  public void testExternalChannelProvider() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .build();

          TransportChannelProvider provider = options.getChannelProvider();
          assertTrue(provider instanceof InstantiatingGrpcChannelProvider);
        });
  }

  @Test
  public void testExternalChannelProvider_WithoutEnablingProperty() throws Throwable {
    String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    SpannerException exception =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setUri(
                        baseUri
                            + "?channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                    .setCredentials(NoCredentials.getInstance())
                    .build());
    assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
  }

  @Test
  public void testUseVirtualThreads() {
    assertTrue(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?useVirtualThreads=true")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualThreads());
    assertFalse(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?useVirtualThreads=false")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualThreads());
    assertEquals(
        ConnectionOptions.DEFAULT_USE_VIRTUAL_THREADS,
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualThreads());
  }

  @Test
  public void testUseVirtualGrpcTransportThreads() {
    assertTrue(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?useVirtualGrpcTransportThreads=true")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualGrpcTransportThreads());
    assertFalse(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?useVirtualGrpcTransportThreads=false")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualGrpcTransportThreads());
    assertEquals(
        ConnectionOptions.DEFAULT_USE_VIRTUAL_GRPC_TRANSPORT_THREADS,
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isUseVirtualThreads());
  }

  @Test
  public void testMaxCommitDelay() {
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getMaxCommitDelay());
    assertEquals(
        Duration.ofMillis(10L),
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?maxCommitDelay=10")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getMaxCommitDelay());
  }

  @Test
  public void testEnableApiTracing() {
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableApiTracing());
    assertTrue(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?enableApiTracing=true")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableApiTracing());
    assertFalse(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?enableApiTracing=false")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableApiTracing());
  }

  @Test
  public void testExternalHostPatterns() {
    Matcher matcherWithoutInstance =
        EXTERNAL_HOST_PATTERN.matcher("cloudspanner://localhost:15000/databases/test-db");
    assertTrue(matcherWithoutInstance.matches());
    assertNull(matcherWithoutInstance.group("INSTANCEGROUP"));
    assertEquals("test-db", matcherWithoutInstance.group("DATABASEGROUP"));
    Matcher matcherWithProperty =
        EXTERNAL_HOST_PATTERN.matcher(
            "cloudspanner://localhost:15000/instances/default/databases/singers-db?usePlainText=true");
    assertTrue(matcherWithProperty.matches());
    assertEquals("default", matcherWithProperty.group("INSTANCEGROUP"));
    assertEquals("singers-db", matcherWithProperty.group("DATABASEGROUP"));
    Matcher matcherWithoutPort =
        EXTERNAL_HOST_PATTERN.matcher(
            "cloudspanner://localhost/instances/default/databases/test-db");
    assertTrue(matcherWithoutPort.matches());
    assertEquals("default", matcherWithoutPort.group("INSTANCEGROUP"));
    assertEquals("test-db", matcherWithoutPort.group("DATABASEGROUP"));
    assertEquals(
        "http://localhost:15000",
        determineHost(
            matcherWithoutPort,
            DEFAULT_ENDPOINT,
            /* autoConfigEmulator= */ true,
            /* usePlainText= */ true,
            ImmutableMap.of()));
    Matcher matcherWithProject =
        EXTERNAL_HOST_PATTERN.matcher(
            "cloudspanner://localhost:15000/projects/default/instances/default/databases/singers-db");
    assertFalse(matcherWithProject.matches());
    Matcher matcherWithoutHost =
        EXTERNAL_HOST_PATTERN.matcher("cloudspanner:/instances/default/databases/singers-db");
    assertFalse(matcherWithoutHost.matches());
    Matcher matcherWithPrefixSpanner =
        EXTERNAL_HOST_PATTERN.matcher("spanner://localhost:15000/databases/test-db");
    assertTrue(matcherWithPrefixSpanner.matches());
    assertNull(matcherWithPrefixSpanner.group("INSTANCEGROUP"));
    assertEquals("test-db", matcherWithPrefixSpanner.group("DATABASEGROUP"));
  }

  @Test
  public void testBuildWithValidURIWithPrefixSpanner() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "spanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autocommit=false;readonly=true");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost()).isEqualTo(DEFAULT_HOST);
    assertThat(options.getProjectId()).isEqualTo("test-project-123");
    assertThat(options.getInstanceId()).isEqualTo("test-instance-123");
    assertThat(options.getDatabaseName()).isEqualTo("test-database-123");
    assertThat(options.getCredentials())
        .isEqualTo(new CredentialsService().createCredentials(FILE_TEST_PATH));
    assertThat(options.isAutocommit()).isEqualTo(false);
    assertThat(options.isReadOnly()).isEqualTo(true);
  }

  @Test
  public void testExperimentalHost() {
    ConnectionOptions.Builder builderWithoutExperimentalHostParam = ConnectionOptions.newBuilder();
    builderWithoutExperimentalHostParam.setUri(
        "spanner://localhost:15000/instances/default/databases/singers-db;usePlainText=true");
    ConnectionOptions optionsWithoutExperimentalHostParam =
        builderWithoutExperimentalHostParam.build();
    assertFalse(optionsWithoutExperimentalHostParam.isExperimentalHost());
    assertEquals(0, optionsWithoutExperimentalHostParam.getSessionPoolOptions().getMinSessions());
    assertTrue(
        optionsWithoutExperimentalHostParam.getSessionPoolOptions().getUseMultiplexedSession());
    assertTrue(
        optionsWithoutExperimentalHostParam
            .getSessionPoolOptions()
            .getUseMultiplexedSessionForRW());
    assertTrue(
        optionsWithoutExperimentalHostParam
            .getSessionPoolOptions()
            .getUseMultiplexedSessionPartitionedOps());

    ConnectionOptions.Builder builderWithExperimentalHostParam = ConnectionOptions.newBuilder();
    builderWithExperimentalHostParam.setUri(
        "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;isExperimentalHost=true");
    ConnectionOptions optionsWithExperimentalHostParam = builderWithExperimentalHostParam.build();
    assertTrue(optionsWithExperimentalHostParam.isExperimentalHost());
    assertEquals(0, optionsWithExperimentalHostParam.getSessionPoolOptions().getMinSessions());
    assertTrue(optionsWithExperimentalHostParam.getSessionPoolOptions().getUseMultiplexedSession());
    assertTrue(
        optionsWithExperimentalHostParam.getSessionPoolOptions().getUseMultiplexedSessionForRW());
    assertTrue(
        optionsWithExperimentalHostParam
            .getSessionPoolOptions()
            .getUseMultiplexedSessionPartitionedOps());
  }

  @Test
  public void testEnableDirectAccess() {
    ConnectionOptions.Builder builderWithoutDirectPathParam = ConnectionOptions.newBuilder();
    builderWithoutDirectPathParam.setUri(
        "spanner://localhost:15000/instances/default/databases/singers-db;usePlainText=true");
    assertNull(builderWithoutDirectPathParam.build().isEnableDirectAccess());

    ConnectionOptions.Builder builderWithDirectPathParamFalse = ConnectionOptions.newBuilder();
    builderWithDirectPathParamFalse.setUri(
        "spanner://localhost:15000/instances/default/databases/singers-db;usePlainText=true;enableDirectAccess=false");
    assertFalse(builderWithDirectPathParamFalse.build().isEnableDirectAccess());

    ConnectionOptions.Builder builderWithDirectPathParam = ConnectionOptions.newBuilder();
    builderWithDirectPathParam.setUri(
        "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;enableDirectAccess=true");
    assertTrue(builderWithDirectPathParam.build().isEnableDirectAccess());
  }

  @Test
  public void testUniverseDomain() {
    ConnectionImpl connection = mock(ConnectionImpl.class);

    // No universeDomain
    AtomicBoolean executedConfigurator = new AtomicBoolean(false);
    ConnectionOptions optionsWithNoUniverseDomainParam =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/default/instances/default/databases/singers-db?usePlainText=true")
            .setConfigurator(
                optionsBuilder -> {
                  executedConfigurator.set(true);
                  SpannerOptions spannerOptions = optionsBuilder.build();
                  assertEquals("googleapis.com", spannerOptions.getUniverseDomain());
                  assertEquals("https://spanner.googleapis.com", spannerOptions.getHost());
                })
            .build();
    Spanner spanner = SpannerPool.INSTANCE.getSpanner(optionsWithNoUniverseDomainParam, connection);
    spanner.close();
    SpannerPool.INSTANCE.removeConnection(optionsWithNoUniverseDomainParam, connection);
    assertTrue(executedConfigurator.get());

    // only configuring universal domain
    executedConfigurator.set(false);
    ConnectionOptions optionsWithUniverseDomainParam =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/default/instances/default/databases/singers-db;universeDomain=abc.goog;usePlainText=true")
            .setConfigurator(
                optionsBuilder -> {
                  executedConfigurator.set(true);
                  SpannerOptions spannerOptions = optionsBuilder.build();
                  assertEquals("abc.goog", spannerOptions.getUniverseDomain());
                  assertEquals("https://spanner.abc.goog", spannerOptions.getHost());
                })
            .build();
    spanner = SpannerPool.INSTANCE.getSpanner(optionsWithUniverseDomainParam, connection);
    spanner.close();
    SpannerPool.INSTANCE.removeConnection(optionsWithUniverseDomainParam, connection);
    assertTrue(executedConfigurator.get());

    // configuring both universal domain and host
    executedConfigurator.set(false);
    ConnectionOptions optionsWithHostAndUniverseDomainParam =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner://spanner.abc.goog/projects/default/instances/default/databases/singers-db;universeDomain=abc.goog;usePlainText=true")
            .setConfigurator(
                optionsBuilder -> {
                  executedConfigurator.set(true);
                  SpannerOptions spannerOptions = optionsBuilder.build();
                  assertEquals("abc.goog", spannerOptions.getUniverseDomain());
                  assertEquals("http://spanner.abc.goog", spannerOptions.getHost());
                })
            .build();
    spanner = SpannerPool.INSTANCE.getSpanner(optionsWithHostAndUniverseDomainParam, connection);
    spanner.close();
    SpannerPool.INSTANCE.removeConnection(optionsWithHostAndUniverseDomainParam, connection);
    assertTrue(executedConfigurator.get());

    // configuring both universal domain and host(localhost)
    executedConfigurator.set(false);
    ConnectionOptions optionsWithLocalHostAndUniverseDomainParam =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;universeDomain=abc.goog")
            .setConfigurator(
                optionsBuilder -> {
                  executedConfigurator.set(true);
                  SpannerOptions spannerOptions = optionsBuilder.build();
                  assertEquals("abc.goog", spannerOptions.getUniverseDomain());
                  assertEquals("http://localhost:15000", spannerOptions.getHost());
                })
            .build();
    spanner =
        SpannerPool.INSTANCE.getSpanner(optionsWithLocalHostAndUniverseDomainParam, connection);
    spanner.close();
    SpannerPool.INSTANCE.removeConnection(optionsWithLocalHostAndUniverseDomainParam, connection);
    assertTrue(executedConfigurator.get());

    connection.close();
  }

  @Test
  public void testEnableDynamicChannelPool() {
    // Default value
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableDynamicChannelPool());
    // Enabled
    assertTrue(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?enableDynamicChannelPool=true")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableDynamicChannelPool());
  }

  @Test
  public void testDisableDynamicChannelPool() {
    assertFalse(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?enableDynamicChannelPool=false")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .isEnableDynamicChannelPool());
  }

  @Test
  public void testDcpMinChannels() {
    // Default value
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpMinChannels());
    // Custom value
    assertEquals(
        Integer.valueOf(3),
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?dcpMinChannels=3")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpMinChannels());
  }

  @Test
  public void testDcpMaxChannels() {
    // Default value
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpMaxChannels());
    // Custom value
    assertEquals(
        Integer.valueOf(15),
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?dcpMaxChannels=15")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpMaxChannels());
  }

  @Test
  public void testDcpInitialChannels() {
    // Default value
    assertNull(
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpInitialChannels());
    // Custom value
    assertEquals(
        Integer.valueOf(5),
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?dcpInitialChannels=5")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getDcpInitialChannels());
  }

  @Test
  public void testDcpWithAllOptions() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?enableDynamicChannelPool=true;dcpMinChannels=3;dcpMaxChannels=15;dcpInitialChannels=5")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertTrue(options.isEnableDynamicChannelPool());
    assertEquals(Integer.valueOf(3), options.getDcpMinChannels());
    assertEquals(Integer.valueOf(15), options.getDcpMaxChannels());
    assertEquals(Integer.valueOf(5), options.getDcpInitialChannels());
  }
}
