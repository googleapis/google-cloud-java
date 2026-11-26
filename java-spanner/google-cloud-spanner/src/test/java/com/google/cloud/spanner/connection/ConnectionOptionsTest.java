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

import static com.google.cloud.spanner.connection.ConnectionOptions.Builder.SPANNER_OMNI_PATTERN;
import static com.google.cloud.spanner.connection.ConnectionOptions.Builder.SPANNER_URI_PATTERN;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENDPOINT;
import static com.google.cloud.spanner.connection.ConnectionOptions.determineHost;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.connection.ConnectionOptions.StartupPropertyPolicy;
import com.google.cloud.spanner.omni.SpannerOmniCredentials;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    ConnectionOptions validLenientOptions =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?lenient=true")
            .setCredentialsUrl(FILE_TEST_PATH)
            .build();
    assertNull(validLenientOptions.getWarnings());
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
              "encoded:" + Hashing.sha256().hashString(encoded, StandardCharsets.UTF_8).toString(),
              options.getEncodedCredentialsHash());
          assertNull(
              options.getInitialConnectionPropertyValue(ConnectionProperties.ENCODED_CREDENTIALS));
          assertEquals(
              new CredentialsService().createCredentials(FILE_TEST_PATH), options.getCredentials());
        });
  }

  @Test
  public void testOAuthTokenCredentials() {
    String uri =
        "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?oauthToken=my-secret-token";
    ConnectionOptions options = ConnectionOptions.newBuilder().setUri(uri).build();
    assertEquals(
        "oauth:"
            + Hashing.sha256().hashString("my-secret-token", StandardCharsets.UTF_8).toString(),
        options.getOAuthTokenHash());
    assertNull(options.getInitialConnectionPropertyValue(ConnectionProperties.OAUTH_TOKEN));
    assertNotNull(options.getCredentials());
  }

  @Test
  public void testValidEncodedCredentials_WithoutEnablingProperty() throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        () -> {
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
        });
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

  public static class CredentialsProviderWithoutNoArgConstructor implements CredentialsProvider {
    public CredentialsProviderWithoutNoArgConstructor(String argument) {}

    @Override
    public Credentials getCredentials() {
      return NoCredentials.getInstance();
    }
  }

  public static class ChannelProviderWithoutNoArgConstructor
      implements ConnectionOptions.ExternalChannelProvider {
    public ChannelProviderWithoutNoArgConstructor(String argument) {}

    @Override
    public com.google.api.gax.rpc.TransportChannelProvider getChannelProvider(
        String host, int port) {
      return null;
    }
  }

  public static class ProviderWithFailingConstructor implements CredentialsProvider {
    public ProviderWithFailingConstructor() {
      throw new IllegalArgumentException("Simulated constructor failure");
    }

    @Override
    public Credentials getCredentials() {
      return NoCredentials.getInstance();
    }
  }

  public static class ProviderWithPrivateConstructor implements CredentialsProvider {
    private ProviderWithPrivateConstructor() {}

    @Override
    public Credentials getCredentials() {
      return NoCredentials.getInstance();
    }
  }

  public abstract static class AbstractTestCredentialsProvider implements CredentialsProvider {
    public AbstractTestCredentialsProvider() {}
  }

  public static class ProviderThrowingIOException implements CredentialsProvider {
    @Override
    public Credentials getCredentials() throws IOException {
      throw new IOException("Simulated IO failure");
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

  static void runWithSystemPropertyDisabled(String systemPropertyName, ThrowingRunnable runnable)
      throws Throwable {
    String originalValue = System.getProperty(systemPropertyName);
    System.clearProperty(systemPropertyName);
    try {
      runnable.run();
    } finally {
      if (originalValue != null) {
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
  public void testValidCredentialsProvider_WithoutEnablingSystemProperty() throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
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
                  + " ENABLE_CREDENTIALS_PROVIDER has been set to true. Start the application with"
                  + " the JVM command line option -DENABLE_CREDENTIALS_PROVIDER=true",
              exception.getMessage());
        });
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
  public void testCredentialsProvider_NotLoadedWithoutSystemProperty() throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=com.google.cloud.spanner.connection.NonExistentClass";

          // Setting the URI must NOT load the class. If it attempted reflection, it would throw
          // INVALID_ARGUMENT.
          ConnectionOptions.Builder builder = ConnectionOptions.newBuilder().setUri(uri);

          // Building options without the system property must fail with FAILED_PRECONDITION
          // (guarded property check), NOT INVALID_ARGUMENT (unknown class), proving that
          // the system property guard is checked before any class loading is attempted.
          SpannerException exception = assertThrows(SpannerException.class, builder::build);
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
          assertEquals(
              "FAILED_PRECONDITION: credentialsProvider can only be used if the system property"
                  + " ENABLE_CREDENTIALS_PROVIDER has been set to true. Start the application with"
                  + " the JVM command line option -DENABLE_CREDENTIALS_PROVIDER=true",
              exception.getMessage());
        });
  }

  @Test
  public void testCredentialsProvider_ClassDoesNotImplementCredentialsProvider() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  String.class.getName());

          ConnectionOptions.Builder builder = ConnectionOptions.newBuilder().setUri(uri);

          SpannerException exception = assertThrows(SpannerException.class, builder::build);
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertEquals(
              String.format(
                  "INVALID_ARGUMENT: Class %s does not implement %s",
                  String.class.getName(), CredentialsProvider.class.getName()),
              exception.getMessage());
        });
  }

  @Test
  public void testCredentialsProviderConverter_DirectCallWithoutSystemProperty() throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      ClientSideStatementValueConverters.CredentialsProviderConverter.INSTANCE
                          .convert(TestCredentialsProvider.class.getName()));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        });
  }

  @Test
  public void testCredentialsProvider_NonExistentClass() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=com.google.cloud.spanner.connection.NonExistentClass";
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "Unknown or invalid CredentialsProvider class name:"
                          + " com.google.cloud.spanner.connection.NonExistentClass"));
        });
  }

  @Test
  public void testCredentialsProvider_NoPublicNoArgConstructor() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  CredentialsProviderWithoutNoArgConstructor.class.getName());
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("does not have a public no-arg constructor"));
        });
  }

  @Test
  public void testCredentialsProvider_ConstructorThrowsException() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  ProviderWithFailingConstructor.class.getName());
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("Simulated constructor failure"));
        });
  }

  @Test
  public void testCredentialsProvider_PrivateNoArgConstructor() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  ProviderWithPrivateConstructor.class.getName());
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("does not have a public no-arg constructor"));
        });
  }

  @Test
  public void testCredentialsProvider_AbstractClass() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  AbstractTestCredentialsProvider.class.getName());
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("is abstract and cannot be instantiated"));
        });
  }

  @Test
  public void testCredentialsProvider_NullAndEmptyInput() {
    assertNull(
        ClientSideStatementValueConverters.CredentialsProviderConverter.INSTANCE.convert(null));
    assertNull(
        ClientSideStatementValueConverters.CredentialsProviderConverter.INSTANCE.convert(""));
    assertNull(
        ClientSideStatementValueConverters.ExternalChannelProviderConverter.INSTANCE.convert(null));
    assertNull(
        ClientSideStatementValueConverters.ExternalChannelProviderConverter.INSTANCE.convert(""));
    assertNull(
        ClientSideStatementValueConverters.GrpcInterceptorProviderConverter.INSTANCE.convert(null));
    assertNull(
        ClientSideStatementValueConverters.GrpcInterceptorProviderConverter.INSTANCE.convert(""));
  }

  @Test
  public void testCredentialsProvider_GetCredentialsThrowsIOException() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String uri =
              String.format(
                  "cloudspanner:/projects/test-project/instances/test-instance/databases/test-database?credentialsProvider=%s",
                  ProviderThrowingIOException.class.getName());
          SpannerException exception =
              assertThrows(
                  SpannerException.class, () -> ConnectionOptions.newBuilder().setUri(uri).build());
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "Failed to get credentials from CredentialsProvider: Simulated IO failure"));
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
          assertEquals(
              "spanner.googleapis.com:443",
              ((InstantiatingGrpcChannelProvider) provider).getEndpoint());
        });
  }

  @Test
  public void testExternalChannelProvider_WithUniverseDomain() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

          // Custom universeDomain without explicit host should use spanner.<universeDomain>.
          ConnectionOptions optionsWithUniverseDomain =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?universeDomain=abc.goog;channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          TransportChannelProvider providerWithUniverseDomain =
              optionsWithUniverseDomain.getChannelProvider();
          assertTrue(providerWithUniverseDomain instanceof InstantiatingGrpcChannelProvider);
          assertEquals(
              "spanner.abc.goog:443",
              ((InstantiatingGrpcChannelProvider) providerWithUniverseDomain).getEndpoint());

          // Empty universeDomain without explicit host should fall back to googleapis.com.
          ConnectionOptions optionsWithEmptyUniverseDomain =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?universeDomain=;channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          TransportChannelProvider providerWithEmptyUniverseDomain =
              optionsWithEmptyUniverseDomain.getChannelProvider();
          assertTrue(providerWithEmptyUniverseDomain instanceof InstantiatingGrpcChannelProvider);
          assertEquals(
              "spanner.googleapis.com:443",
              ((InstantiatingGrpcChannelProvider) providerWithEmptyUniverseDomain).getEndpoint());

          // Explicit URI host and port should take precedence over universeDomain.
          ConnectionOptions optionsWithHostAndUniverseDomain =
              ConnectionOptions.newBuilder()
                  .setUri(
                      "cloudspanner://custom.host.abc.goog:1234/projects/test-project-123/instances/test-instance/databases/test-database?universeDomain=abc.goog;channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          TransportChannelProvider providerWithHost =
              optionsWithHostAndUniverseDomain.getChannelProvider();
          assertTrue(providerWithHost instanceof InstantiatingGrpcChannelProvider);
          assertEquals(
              "custom.host.abc.goog:1234",
              ((InstantiatingGrpcChannelProvider) providerWithHost).getEndpoint());

          // Explicit endpoint property should take precedence over universeDomain.
          ConnectionOptions optionsWithEndpointAndUniverseDomain =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?endpoint=my.endpoint.abc.goog:5678;universeDomain=abc.goog;channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          TransportChannelProvider providerWithEndpoint =
              optionsWithEndpointAndUniverseDomain.getChannelProvider();
          assertTrue(providerWithEndpoint instanceof InstantiatingGrpcChannelProvider);
          assertEquals(
              "my.endpoint.abc.goog:5678",
              ((InstantiatingGrpcChannelProvider) providerWithEndpoint).getEndpoint());

          // Verify end-to-end SpannerPool propagates the universe-scoped channel provider.
          ConnectionImpl connection = mock(ConnectionImpl.class);
          AtomicBoolean executedConfigurator = new AtomicBoolean(false);
          ConnectionOptions poolOptions =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?universeDomain=abc.goog;usePlainText=true;channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                  .setCredentials(NoCredentials.getInstance())
                  .setConfigurator(
                      optionsBuilder -> {
                        executedConfigurator.set(true);
                        SpannerOptions spannerOptions = optionsBuilder.build();
                        assertEquals("abc.goog", spannerOptions.getUniverseDomain());
                        assertEquals("https://spanner.abc.goog", spannerOptions.getHost());
                        assertTrue(
                            spannerOptions.getChannelProvider()
                                instanceof InstantiatingGrpcChannelProvider);
                        assertEquals(
                            "spanner.abc.goog:443",
                            ((InstantiatingGrpcChannelProvider) spannerOptions.getChannelProvider())
                                .getEndpoint());
                      })
                  .build();
          Spanner spanner = SpannerPool.INSTANCE.getSpanner(poolOptions, connection);
          spanner.close();
          SpannerPool.INSTANCE.removeConnection(poolOptions, connection);
          assertTrue(executedConfigurator.get());
        });
  }

  @Test
  public void testExternalChannelProvider_WithValidUniverseDomains() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
          String maxLabel = Strings.repeat("a", 63);
          String maxLengthDomain =
              Strings.repeat("a", 60)
                  + "."
                  + Strings.repeat("b", 60)
                  + "."
                  + Strings.repeat("c", 60)
                  + "."
                  + Strings.repeat("d", 62);
          assertEquals(245, maxLengthDomain.length());

          for (String universeDomain :
              Arrays.asList(
                  "googleapis.com",
                  "abc.goog",
                  "a.b",
                  "a-1.b-2.example-3.goog",
                  "ABC.GOOG",
                  "localhost",
                  maxLabel + ".goog",
                  maxLengthDomain)) {
            ConnectionOptions options =
                ConnectionOptions.newBuilder()
                    .setUri(
                        baseUri
                            + "?universeDomain="
                            + universeDomain
                            + ";channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                    .setCredentials(NoCredentials.getInstance())
                    .build();
            TransportChannelProvider provider = options.getChannelProvider();
            assertTrue(provider instanceof InstantiatingGrpcChannelProvider);
            assertEquals(
                "spanner." + universeDomain + ":443",
                ((InstantiatingGrpcChannelProvider) provider).getEndpoint());
          }
        });
  }

  @Test
  public void testUniverseDomain_RejectsInvalidAndUrlInjectionValues() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
          String overlongLabel = Strings.repeat("a", 64) + ".goog";
          String overlongDomain =
              Strings.repeat("a", 60)
                  + "."
                  + Strings.repeat("b", 60)
                  + "."
                  + Strings.repeat("c", 60)
                  + "."
                  + Strings.repeat("d", 63);
          assertEquals(246, overlongDomain.length());

          // Test URL-injection and malformed domain payloads passed via connection URI.
          for (String invalidDomain :
              Arrays.asList(
                  "ignored@attacker.com:8443",
                  "ignored@attacker.com",
                  "abc.goog:8443",
                  "abc.goog:443",
                  "abc.goog/injected",
                  "abc.goog/",
                  "abc.goog#frag",
                  "abc.goog/injected#frag",
                  "https://attacker.com",
                  "abc.goog\\attacker.com",
                  "ignored%40attacker.com",
                  "abc%2egoog",
                  " abc.goog",
                  "abc.goog ",
                  "abc .goog",
                  "abc.goog\t",
                  "[::1]",
                  "abc_def.goog",
                  "abc$def.goog",
                  ".abc.goog",
                  "abc.goog.",
                  "abc..goog",
                  "-abc.goog",
                  "abc-.goog",
                  "abc.-goog",
                  "abc.goog-",
                  overlongLabel,
                  overlongDomain)) {
            IllegalArgumentException uriException =
                assertThrows(
                    "Expected URI with universeDomain=" + invalidDomain + " to be rejected",
                    IllegalArgumentException.class,
                    () ->
                        ConnectionOptions.newBuilder()
                            .setUri(
                                baseUri
                                    + "?universeDomain="
                                    + invalidDomain
                                    + ";channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                            .setCredentials(NoCredentials.getInstance())
                            .build());
            assertTrue(
                uriException.getMessage(),
                uriException.getMessage().contains("Invalid universe domain"));

            // Also verify rejection when set programmatically via setConnectionPropertyValue.
            IllegalArgumentException propException =
                assertThrows(
                    "Expected property universeDomain=" + invalidDomain + " to be rejected",
                    IllegalArgumentException.class,
                    () ->
                        ConnectionOptions.newBuilder()
                            .setUri(
                                baseUri
                                    + "?channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                            .setConnectionPropertyValue(
                                ConnectionProperties.UNIVERSE_DOMAIN, invalidDomain)
                            .setCredentials(NoCredentials.getInstance())
                            .build());
            assertTrue(
                propException.getMessage(),
                propException.getMessage().contains("Invalid universe domain"));
          }

          // Query/control-character smuggling via setConnectionPropertyValue (characters that
          // would otherwise be split by URI parsing).
          for (String smuggledDomain :
              Arrays.asList(
                  "abc.goog?foo=bar",
                  "abc.goog/injected?foo=bar#frag",
                  "abc.goog;evil=true",
                  "abc.goog\r\nHost: attacker.com")) {
            IllegalArgumentException exception =
                assertThrows(
                    "Expected smuggled universeDomain=" + smuggledDomain + " to be rejected",
                    IllegalArgumentException.class,
                    () ->
                        ConnectionOptions.newBuilder()
                            .setUri(
                                baseUri
                                    + "?channelProvider=com.google.cloud.spanner.connection.TestChannelProvider")
                            .setConnectionPropertyValue(
                                ConnectionProperties.UNIVERSE_DOMAIN, smuggledDomain)
                            .setCredentials(NoCredentials.getInstance())
                            .build());
            assertTrue(
                exception.getMessage(), exception.getMessage().contains("Invalid universe domain"));
          }

          // Rejection should apply even when an explicit host is configured.
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  ConnectionOptions.newBuilder()
                      .setUri(
                          "cloudspanner://custom.host:443/projects/test-project-123/instances/test-instance/databases/test-database?universeDomain=ignored@attacker.com:8443")
                      .setCredentials(NoCredentials.getInstance())
                      .build());
        });
  }

  @Test
  public void testExternalChannelProvider_WithoutEnablingProperty() throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
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
        });
  }

  @Test
  public void testExternalChannelProviderConverter_DirectCallWithoutSystemProperty()
      throws Throwable {
    runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      ClientSideStatementValueConverters.ExternalChannelProviderConverter.INSTANCE
                          .convert(TestChannelProvider.class.getName()));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        });
  }

  @Test
  public void testExternalChannelProvider_ClassDoesNotImplementInterface() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(baseUri + "?channelProvider=" + String.class.getName())
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          SpannerException exception =
              assertThrows(SpannerException.class, options::getChannelProvider);
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      String.format(
                          "Class %s does not implement %s",
                          String.class.getName(),
                          ConnectionOptions.ExternalChannelProvider.class.getName())));
        });
  }

  @Test
  public void testExternalChannelProvider_NonExistentClass() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?channelProvider=com.google.cloud.spanner.connection.NonExistentClass")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          SpannerException exception =
              assertThrows(SpannerException.class, options::getChannelProvider);
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "Unknown or invalid ExternalChannelProvider class name:"
                          + " com.google.cloud.spanner.connection.NonExistentClass"));
        });
  }

  @Test
  public void testExternalChannelProvider_NoPublicNoArgConstructor() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(
                      baseUri
                          + "?channelProvider="
                          + ChannelProviderWithoutNoArgConstructor.class.getName())
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          SpannerException exception =
              assertThrows(SpannerException.class, options::getChannelProvider);
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "ExternalChannelProvider "
                          + ChannelProviderWithoutNoArgConstructor.class.getName()
                          + " does not have a public no-arg constructor."));
        });
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
        SPANNER_OMNI_PATTERN.matcher("cloudspanner://localhost:15000/databases/test-db");
    assertTrue(matcherWithoutInstance.matches());
    assertNull(matcherWithoutInstance.group("INSTANCEGROUP"));
    assertEquals("test-db", matcherWithoutInstance.group("DATABASEGROUP"));
    Matcher matcherWithProperty =
        SPANNER_OMNI_PATTERN.matcher(
            "cloudspanner://localhost:15000/instances/default/databases/singers-db?usePlainText=true");
    assertTrue(matcherWithProperty.matches());
    assertEquals("default", matcherWithProperty.group("INSTANCEGROUP"));
    assertEquals("singers-db", matcherWithProperty.group("DATABASEGROUP"));
    Matcher matcherWithoutPort =
        SPANNER_OMNI_PATTERN.matcher(
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
        SPANNER_OMNI_PATTERN.matcher(
            "cloudspanner://localhost:15000/projects/default/instances/default/databases/singers-db");
    assertFalse(matcherWithProject.matches());
    Matcher matcherWithoutHost =
        SPANNER_OMNI_PATTERN.matcher("cloudspanner:/instances/default/databases/singers-db");
    assertFalse(matcherWithoutHost.matches());
    Matcher matcherWithPrefixSpanner =
        SPANNER_OMNI_PATTERN.matcher("spanner://localhost:15000/databases/test-db");
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
    assertFalse(optionsWithoutExperimentalHostParam.isSpannerOmni());
    assertEquals(
        SpannerOptions.InstanceType.CLOUD, optionsWithoutExperimentalHostParam.getInstanceType());
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
    assertTrue(optionsWithExperimentalHostParam.isSpannerOmni());
    assertEquals(
        SpannerOptions.InstanceType.OMNI, optionsWithExperimentalHostParam.getInstanceType());
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
  public void testInstanceType() {
    ConnectionOptions optionsWithCloudType =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;type=cloud")
            .build();
    assertEquals(SpannerOptions.InstanceType.CLOUD, optionsWithCloudType.getInstanceType());
    assertFalse(optionsWithCloudType.isSpannerOmni());

    ConnectionOptions optionsWithOmniType =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;type=omni")
            .build();
    assertEquals(SpannerOptions.InstanceType.OMNI, optionsWithOmniType.getInstanceType());
    assertTrue(optionsWithOmniType.isSpannerOmni());
    assertEquals(0, optionsWithOmniType.getSessionPoolOptions().getMinSessions());
    assertTrue(optionsWithOmniType.getSessionPoolOptions().getUseMultiplexedSession());
    assertTrue(optionsWithOmniType.getSessionPoolOptions().getUseMultiplexedSessionForRW());
    assertTrue(
        optionsWithOmniType.getSessionPoolOptions().getUseMultiplexedSessionPartitionedOps());
  }

  @Test
  public void testBuildWithOmniCredentialsProperties() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;type=omni;username=test_user;password=test_pass")
            .build();
    assertEquals(SpannerOptions.InstanceType.OMNI, options.getInstanceType());
    assertTrue(options.isSpannerOmni());
    assertTrue(options.getCredentials() instanceof SpannerOmniCredentials);
  }

  @Test
  public void testBuildWithOmniCredentialsPropertiesMissingPassword() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;usePlainText=true;type=omni;username=test_user")
            .build();
    assertEquals(SpannerOptions.InstanceType.OMNI, options.getInstanceType());
    assertTrue(options.isSpannerOmni());
  }

  @Test
  public void testInvalidInstanceType() {
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;type=unspecified")
                .build());
    assertThrows(
        SpannerException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(
                    "spanner://localhost:15000/projects/default/instances/default/databases/singers-db;type=invalid_type")
                .build());
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

  @Test
  public void testGrpcKeepAliveTimeOption() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?grpcKeepAliveTime='20s'")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(Duration.ofSeconds(20), options.getGrpcKeepAliveTime());

    ConnectionOptions defaultOptions =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertNull(defaultOptions.getGrpcKeepAliveTime());
  }

  @Test
  public void testGrpcKeepAliveTimeoutOption() {
    ConnectionOptions options =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?grpcKeepAliveTimeout='15s'")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(Duration.ofSeconds(15), options.getGrpcKeepAliveTimeout());

    ConnectionOptions defaultOptions =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertNull(defaultOptions.getGrpcKeepAliveTimeout());
  }

  @Test
  public void testCertificateAndTrustOptions() {
    ConnectionOptions optionsFromUri =
        ConnectionOptions.newBuilder()
            .setUri(
                "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                    + "?clientCertificate=/path/to/client.crt;clientKey=/path/to/client.key;caCertificate=/path/to/ca.crt")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("/path/to/client.crt", optionsFromUri.getClientCertificate());
    assertEquals("/path/to/client.key", optionsFromUri.getClientCertificateKey());
    assertEquals("/path/to/ca.crt", optionsFromUri.getCaCertificate());
  }

  @Test
  public void testProgrammaticPropertiesAllowedAndTrusted() throws Throwable {
    runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          String baseUri =
              "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                  + "?autocommit=true;endpoint=url-endpoint.example.com:443";

          ConnectionOptions options =
              ConnectionOptions.newBuilder()
                  .setUri(baseUri)
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.ENDPOINT, "trusted.example.com:443"))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.DIALECT, Dialect.POSTGRESQL))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.USER_AGENT, "pg-adapter"))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.USE_PLAIN_TEXT, true))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 8))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.GRPC_KEEPALIVE_TIME, Duration.ofSeconds(30)))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.GRPC_KEEPALIVE_TIMEOUT, Duration.ofSeconds(10)))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.MIN_SESSIONS, 10))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.MAX_SESSIONS, 20))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.DATABASE_ROLE, "trusted-role"))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.ENABLE_END_TO_END_TRACING, true))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.CHANNEL_PROVIDER,
                          TestChannelProvider.class.getName()))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.CREDENTIALS_URL, FILE_TEST_PATH))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.AUTOCOMMIT, false))
                  .build();
          assertEquals("http://trusted.example.com:443", options.getHost());
          assertEquals(Dialect.POSTGRESQL, options.getDialect());
          assertEquals("pg-adapter", options.getUserAgent());
          assertTrue(options.isUsePlainText());
          assertEquals(Integer.valueOf(8), options.getNumChannels());
          assertEquals(Duration.ofSeconds(30), options.getGrpcKeepAliveTime());
          assertEquals(Duration.ofSeconds(10), options.getGrpcKeepAliveTimeout());
          assertEquals(Integer.valueOf(10), options.getMinSessions());
          assertEquals(Integer.valueOf(20), options.getMaxSessions());
          assertEquals("trusted-role", options.getDatabaseRole());
          assertTrue(options.isEndToEndTracingEnabled());
          assertNotNull(options.getChannelProvider());
          assertEquals(FILE_TEST_PATH, options.getCredentialsUrl());
          assertFalse(options.isAutocommit());

          // Setting programmatic properties before setUri also overrides URI values.
          ConnectionOptions propsBeforeUri =
              ConnectionOptions.newBuilder()
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(
                          ConnectionProperties.ENDPOINT, "trusted.example.com:443"))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.AUTOCOMMIT, false))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 6))
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.DIALECT, Dialect.POSTGRESQL))
                  .setUri(baseUri)
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          assertEquals("https://trusted.example.com:443", propsBeforeUri.getHost());
          assertFalse(propsBeforeUri.isAutocommit());
          assertEquals(Integer.valueOf(6), propsBeforeUri.getNumChannels());
          assertEquals(Dialect.POSTGRESQL, propsBeforeUri.getDialect());

          assertThrows(
              NullPointerException.class,
              () -> ConnectionOptions.newBuilder().setConnectionPropertyValue(null));

          SpannerException nullPrimitiveException =
              assertThrows(
                  SpannerException.class,
                  () -> ConnectionPropertyValue.of(ConnectionProperties.AUTOCOMMIT, null));
          assertEquals(ErrorCode.INVALID_ARGUMENT, nullPrimitiveException.getErrorCode());

          // Programmatic lenient=true allows unknown URI properties before setUri and yields null
          // warnings when the URI has no unknown properties.
          ConnectionOptions lenientWithUnknownUriProp =
              ConnectionOptions.newBuilder()
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.LENIENT, true))
                  .setUri(
                      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?unknownProp=value")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          assertNotNull(lenientWithUnknownUriProp.getWarnings());
          assertTrue(lenientWithUnknownUriProp.getWarnings().contains("unknownProp"));

          ConnectionOptions lenientWithValidUri =
              ConnectionOptions.newBuilder()
                  .setConnectionPropertyValue(
                      ConnectionPropertyValue.of(ConnectionProperties.LENIENT, true))
                  .setUri(
                      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database")
                  .setCredentials(NoCredentials.getInstance())
                  .build();
          assertNull(lenientWithValidUri.getWarnings());
        });
  }

  @Test
  public void testProgrammaticPropertiesEdgeCasesAndUnhappyPaths() {
    String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

    // Programmatic lenient=false overrides URI lenient=true regardless of call order.
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(ConnectionProperties.LENIENT, false))
                .setUri(baseUri + "?lenient=true;unknownProp=bar")
                .setCredentials(NoCredentials.getInstance())
                .build());
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(baseUri + "?lenient=true;unknownProp=bar")
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(ConnectionProperties.LENIENT, false))
                .setCredentials(NoCredentials.getInstance())
                .build());

    // setUri validates unknown URI properties eagerly if programmatic LENIENT=true was not set
    // beforehand.
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectionOptions.newBuilder().setUri(baseUri + "?unknownProp=bar"));

    // Calling setConnectionPropertyValue twice for the same property keeps the latest value, and
    // reusing a Builder does not mutate previously built ConnectionOptions instances.
    ConnectionOptions.Builder reusedBuilder =
        ConnectionOptions.newBuilder()
            .setUri(baseUri + "?numChannels=4")
            .setCredentials(NoCredentials.getInstance())
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 6))
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 10));
    ConnectionOptions firstBuilt = reusedBuilder.build();
    reusedBuilder.setConnectionPropertyValue(
        ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 12));
    ConnectionOptions secondBuilt = reusedBuilder.build();
    assertEquals(Integer.valueOf(10), firstBuilt.getNumChannels());
    assertEquals(Integer.valueOf(12), secondBuilt.getNumChannels());

    // Guarded properties set via ConnectionPropertyValue still enforce system property guards.
    for (ConnectionProperty<String> guardedProperty :
        Arrays.asList(
            ConnectionProperties.CHANNEL_PROVIDER,
            ConnectionProperties.CREDENTIALS_PROVIDER,
            ConnectionProperties.ENCODED_CREDENTIALS,
            ConnectionProperties.GRPC_INTERCEPTOR_PROVIDER)) {
      SpannerException guardedException =
          assertThrows(
              "Expected guarded property " + guardedProperty.getKey() + " to fail without flag",
              SpannerException.class,
              () ->
                  ConnectionOptions.newBuilder()
                      .setUri(baseUri)
                      .setConnectionPropertyValue(
                          ConnectionPropertyValue.of(guardedProperty, "com.example.Test"))
                      .build());
      assertEquals(ErrorCode.FAILED_PRECONDITION, guardedException.getErrorCode());
    }

    // Conflicting credential properties set via ConnectionPropertyValue are rejected.
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setUri(baseUri)
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(
                        ConnectionProperties.CREDENTIALS_URL, FILE_TEST_PATH))
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(ConnectionProperties.OAUTH_TOKEN, "token"))
                .build());

    // Programmatic TYPE overrides URI TYPE and updates isSpannerOmni()/getInstanceType().
    ConnectionOptions cloudOverridingOmniUri =
        ConnectionOptions.newBuilder()
            .setUri(baseUri + "?type=omni")
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(
                    ConnectionProperties.TYPE, SpannerOptions.InstanceType.CLOUD))
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertFalse(cloudOverridingOmniUri.isSpannerOmni());
    assertEquals(SpannerOptions.InstanceType.CLOUD, cloudOverridingOmniUri.getInstanceType());

    // setTracingPrefix(null) and setType(null) fail fast with INVALID_ARGUMENT, while nullable
    // credentialsUrl/oauthToken continue to allow null.
    SpannerException nullTracingPrefix =
        assertThrows(
            SpannerException.class, () -> ConnectionOptions.newBuilder().setTracingPrefix(null));
    assertEquals(ErrorCode.INVALID_ARGUMENT, nullTracingPrefix.getErrorCode());
    SpannerException nullType =
        assertThrows(SpannerException.class, () -> ConnectionOptions.newBuilder().setType(null));
    assertEquals(ErrorCode.INVALID_ARGUMENT, nullType.getErrorCode());
    assertNull(
        ConnectionOptions.newBuilder()
            .setCredentialsUrl(null)
            .setOAuthToken(null)
            .setUri(baseUri)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getCredentialsUrl());

    // setUri validates property values eagerly.
    SpannerException eagerBadInt =
        assertThrows(
            SpannerException.class,
            () -> ConnectionOptions.newBuilder().setUri(baseUri + "?numChannels=notAnInt"));
    assertEquals(ErrorCode.INVALID_ARGUMENT, eagerBadInt.getErrorCode());

    // Malformed tokens without '=' or empty keys are flagged as invalid tokens (never ignored).
    for (String malformedSuffix : new String[] {"?bypass", "?autocommit", "?=value"}) {
      assertThrows(
          "Expected malformed token " + malformedSuffix + " to fail without lenient",
          IllegalArgumentException.class,
          () -> ConnectionOptions.newBuilder().setUri(baseUri + malformedSuffix));
      ConnectionOptions lenientMalformed =
          ConnectionOptions.newBuilder()
              .setUri(baseUri + malformedSuffix + ";lenient=true")
              .setCredentials(NoCredentials.getInstance())
              .build();
      assertNotNull(lenientMalformed.getWarnings());
    }
  }

  @Test
  public void testStartupPropertyPolicy() throws Throwable {
    String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    String spannerSchemeUri =
        "spanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    String omniUri =
        "cloudspanner://custom.host:443/instances/test-instance/databases/test-database";

    // Default policy is ALLOW.
    ConnectionOptions.Builder defaultBuilder = ConnectionOptions.newBuilder();
    assertEquals(StartupPropertyPolicy.ALLOW, defaultBuilder.getStartupPropertyPolicy());
    assertThrows(NullPointerException.class, () -> defaultBuilder.setStartupPropertyPolicy(null));

    // Toggle between REJECT and ALLOW on the same Builder restores URI startup property allowance.
    defaultBuilder.setStartupPropertyPolicy(StartupPropertyPolicy.REJECT);
    assertEquals(StartupPropertyPolicy.REJECT, defaultBuilder.getStartupPropertyPolicy());
    defaultBuilder.setStartupPropertyPolicy(StartupPropertyPolicy.ALLOW);
    assertEquals(StartupPropertyPolicy.ALLOW, defaultBuilder.getStartupPropertyPolicy());
    ConnectionOptions restoredAllowOptions =
        defaultBuilder
            .setUri(baseUri + "?endpoint=restored.example.com:443;usePlainText=true")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("http://restored.example.com:443", restoredAllowOptions.getHost());

    // Programmatic startup properties + USER URI properties succeed when policy is REJECT,
    // regardless of whether setUri is called before or after setting the policy.
    for (boolean setPolicyBeforeUri : new boolean[] {true, false}) {
      ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
      String userOnlyUri = baseUri + "?autocommit=false;readonly=true;maxPartitions=5";
      if (setPolicyBeforeUri) {
        builder.setStartupPropertyPolicy(StartupPropertyPolicy.REJECT).setUri(userOnlyUri);
      } else {
        builder.setUri(userOnlyUri).setStartupPropertyPolicy(StartupPropertyPolicy.REJECT);
      }
      ConnectionOptions options =
          builder
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.DIALECT, Dialect.POSTGRESQL))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.USER_AGENT, "pg-adapter"))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.USE_PLAIN_TEXT, true))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(
                      ConnectionProperties.ENDPOINT, "trusted-server.example.com:443"))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.CREDENTIALS_URL, FILE_TEST_PATH))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.DATABASE_ROLE, "server-role"))
              .setConnectionPropertyValue(
                  ConnectionPropertyValue.of(ConnectionProperties.NUM_CHANNELS, 6))
              .build();

      assertEquals("http://trusted-server.example.com:443", options.getHost());
      assertEquals(Dialect.POSTGRESQL, options.getDialect());
      assertEquals("pg-adapter", options.getUserAgent());
      assertTrue(options.isUsePlainText());
      assertEquals("server-role", options.getDatabaseRole());
      assertEquals(Integer.valueOf(6), options.getNumChannels());
      assertEquals(FILE_TEST_PATH, options.getCredentialsUrl());
      assertFalse(options.isAutocommit());
      assertTrue(options.isReadOnly());
      assertEquals(5, options.getMaxPartitions());
      assertNull(options.getWarnings());
    }

    // Any Context.STARTUP property in the URI is rejected under REJECT, regardless of call order,
    // casing, invalid startup values, parser smuggling prefixes, URI format, or programmatic
    // lenient=true.
    for (String startupParam :
        new String[] {
          "endpoint=evil.example.com:443",
          "Endpoint=evil.example.com:443",
          "dialect=postgresql",
          "numChannels=2",
          "numChannels=-1",
          "type=omni",
          "autoConfigEmulator=true",
          "lenient=true",
          "lenient=notabool",
          "lenient=true;unknownProp=foo",
          "autocommit=false;endpoint=evil.example.com:443",
          "unknownProp=foo;endpoint=evil.example.com:443",
          "bypass;minSessions=100",
          "bypass?endpoint=evil.example.com:443",
          "=val;minSessions=100",
        }) {
      for (String uriPrefix :
          new String[] {baseUri + "?", baseUri + ";", spannerSchemeUri + "?", omniUri + "?"}) {
        String rejectedUri = uriPrefix + startupParam;
        SpannerException beforeUriException =
            assertThrows(
                "Expected REJECT before setUri for " + rejectedUri,
                SpannerException.class,
                () ->
                    ConnectionOptions.newBuilder()
                        .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                        .setUri(rejectedUri)
                        .setCredentials(NoCredentials.getInstance())
                        .build());
        assertEquals(ErrorCode.INVALID_ARGUMENT, beforeUriException.getErrorCode());

        SpannerException programmaticLenientException =
            assertThrows(
                "Expected REJECT even with programmatic lenient=true for " + rejectedUri,
                SpannerException.class,
                () ->
                    ConnectionOptions.newBuilder()
                        .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                        .setConnectionPropertyValue(
                            ConnectionPropertyValue.of(ConnectionProperties.LENIENT, true))
                        .setUri(rejectedUri)
                        .setCredentials(NoCredentials.getInstance())
                        .build());
        assertEquals(ErrorCode.INVALID_ARGUMENT, programmaticLenientException.getErrorCode());
      }
    }

    // Eager USER property value validation still applies under REJECT.
    SpannerException badUserValueInSetUri =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(baseUri + "?maxPartitions=notAnInt"));
    assertEquals(ErrorCode.INVALID_ARGUMENT, badUserValueInSetUri.getErrorCode());

    // Valid startup property set in URI before REJECT still fails on build().
    for (String validStartupParam :
        new String[] {
          "endpoint=evil.example.com:443",
          "lenient=true;unknownProp=foo",
          "bypass;minSessions=100;lenient=true",
        }) {
      SpannerException afterUriException =
          assertThrows(
              "Expected REJECT after setUri for " + validStartupParam,
              SpannerException.class,
              () ->
                  ConnectionOptions.newBuilder()
                      .setUri(baseUri + "?" + validStartupParam)
                      .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                      .setCredentials(NoCredentials.getInstance())
                      .build());
      assertEquals(ErrorCode.INVALID_ARGUMENT, afterUriException.getErrorCode());
    }

    // Verify all Context.STARTUP properties in VALID_CONNECTION_PROPERTIES are rejected under
    // REJECT, and all Context.USER properties are accepted.
    Map<ConnectionProperty<?>, String> userPropertySamples = new HashMap<>();
    userPropertySamples.put(ConnectionProperties.AUTOCOMMIT, "false");
    userPropertySamples.put(ConnectionProperties.READONLY, "true");
    userPropertySamples.put(ConnectionProperties.DEFAULT_ISOLATION_LEVEL, "SERIALIZABLE");
    userPropertySamples.put(ConnectionProperties.READ_LOCK_MODE, "PESSIMISTIC");
    userPropertySamples.put(ConnectionProperties.STATEMENT_TIMEOUT, "'10s'");
    userPropertySamples.put(ConnectionProperties.TRANSACTION_TIMEOUT, "'10s'");
    userPropertySamples.put(ConnectionProperties.AUTOCOMMIT_DML_MODE, "PARTITIONED_NON_ATOMIC");
    userPropertySamples.put(ConnectionProperties.RETRY_ABORTS_INTERNALLY, "false");
    userPropertySamples.put(ConnectionProperties.RETURN_COMMIT_STATS, "true");
    userPropertySamples.put(ConnectionProperties.DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE, "true");
    userPropertySamples.put(ConnectionProperties.KEEP_TRANSACTION_ALIVE, "true");
    userPropertySamples.put(ConnectionProperties.READ_ONLY_STALENESS, "STRONG");
    userPropertySamples.put(ConnectionProperties.AUTO_PARTITION_MODE, "true");
    userPropertySamples.put(ConnectionProperties.DATA_BOOST_ENABLED, "true");
    userPropertySamples.put(ConnectionProperties.MAX_PARTITIONS, "5");
    userPropertySamples.put(ConnectionProperties.MAX_PARTITIONED_PARALLELISM, "2");
    userPropertySamples.put(
        ConnectionProperties.DIRECTED_READ,
        "{\"includeReplicas\":{\"replicaSelections\":[{\"location\":\"us-central1\",\"type\":\"READ_ONLY\"}]}}");
    userPropertySamples.put(ConnectionProperties.OPTIMIZER_VERSION, "1");
    userPropertySamples.put(ConnectionProperties.OPTIMIZER_STATISTICS_PACKAGE, "pkg");
    userPropertySamples.put(ConnectionProperties.RPC_PRIORITY, "LOW");
    userPropertySamples.put(ConnectionProperties.SAVEPOINT_SUPPORT, "ENABLED");
    userPropertySamples.put(
        ConnectionProperties.DDL_IN_TRANSACTION_MODE, "AUTO_COMMIT_TRANSACTION");
    userPropertySamples.put(ConnectionProperties.DEFAULT_SEQUENCE_KIND, "bit_reversed_positive");
    userPropertySamples.put(ConnectionProperties.MAX_COMMIT_DELAY, "'10ms'");
    userPropertySamples.put(ConnectionProperties.AUTO_BATCH_DML, "true");
    userPropertySamples.put(ConnectionProperties.AUTO_BATCH_DML_UPDATE_COUNT, "2");
    userPropertySamples.put(ConnectionProperties.AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION, "false");
    userPropertySamples.put(ConnectionProperties.BATCH_DML_UPDATE_COUNT, "2");
    userPropertySamples.put(ConnectionProperties.UNKNOWN_LENGTH, "100");

    for (ConnectionProperty<?> property : ConnectionProperties.VALID_CONNECTION_PROPERTIES) {
      if (property.getContext() == ConnectionProperty.Context.STARTUP) {
        SpannerException startupRejected =
            assertThrows(
                "Expected startup property " + property.getKey() + " to be rejected",
                SpannerException.class,
                () ->
                    ConnectionOptions.newBuilder()
                        .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                        .setUri(baseUri + "?" + property.getKey() + "=value")
                        .build());
        assertEquals(ErrorCode.INVALID_ARGUMENT, startupRejected.getErrorCode());
      } else {
        String sampleValue = userPropertySamples.get(property);
        assertNotNull("Missing sample value for USER property " + property.getKey(), sampleValue);
        ConnectionOptions userAllowed =
            ConnectionOptions.newBuilder()
                .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                .setUri(baseUri + "?" + property.getKey() + "=" + sampleValue)
                .setCredentials(NoCredentials.getInstance())
                .build();
        assertNull(userAllowed.getWarnings());
      }
    }

    // Multiple disallowed startup properties are all reported in the error message.
    SpannerException multiException =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(baseUri + "?endpoint=evil.example.com:443;dialect=postgresql")
                    .setCredentials(NoCredentials.getInstance())
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, multiException.getErrorCode());
    assertTrue(multiException.getMessage().contains("endpoint"));
    assertTrue(multiException.getMessage().contains("dialect"));

    // Unknown URI properties without startup properties fail unless programmatic lenient=true.
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                .setUri(baseUri + "?unknownProp=foo")
                .setCredentials(NoCredentials.getInstance())
                .build());
    ConnectionOptions lenientWithUnknown =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.LENIENT, true))
            .setUri(baseUri + "?unknownProp=foo;autocommit=false")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertFalse(lenientWithUnknown.isAutocommit());
    assertEquals(
        "Invalid properties found in connection URI: unknownProp",
        lenientWithUnknown.getWarnings());

    // URL attempting to set startupPropertyPolicy or allowStartupPropertiesInUrl cannot bypass
    // REJECT.
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                .setUri(baseUri + "?allowStartupPropertiesInUrl=true")
                .setCredentials(NoCredentials.getInstance())
                .build());
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                .setUri(baseUri + "?startupPropertyPolicy=ALLOW")
                .setCredentials(NoCredentials.getInstance())
                .build());
    SpannerException urlBypassAttemptWithStartup =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(baseUri + "?startupPropertyPolicy=ALLOW;endpoint=evil.example.com:443")
                    .setCredentials(NoCredentials.getInstance())
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, urlBypassAttemptWithStartup.getErrorCode());

    // Even with programmatic lenient=true, startupPropertyPolicy/allowStartupPropertiesInUrl in URI
    // are treated as unknown properties and never unlock startup properties.
    ConnectionOptions urlBypassWarning =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setConnectionPropertyValue(
                ConnectionPropertyValue.of(ConnectionProperties.LENIENT, true))
            .setUri(baseUri + "?allowStartupPropertiesInUrl=true;startupPropertyPolicy=ALLOW")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertNotNull(urlBypassWarning.getWarnings());
    assertTrue(urlBypassWarning.getWarnings().contains("allowStartupPropertiesInUrl"));
    assertTrue(urlBypassWarning.getWarnings().contains("startupPropertyPolicy"));

    // URI property tokenization edge cases: '=' in value, empty value, trailing '?' / ';', ';;',
    // duplicate startup keys, and '?' inside HOSTGROUP.
    assertEquals(
        "abc==",
        ConnectionOptions.parseUriProperty(
            baseUri + "?encodedCredentials=abc==", "encodedCredentials"));
    ConnectionOptions eqAndEmptyDelimiterOptions =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(baseUri + "?optimizerVersion=a=b;;maxPartitions=3;")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(
        "a=b",
        eqAndEmptyDelimiterOptions
            .getInitialConnectionPropertyValues()
            .get(ConnectionProperties.OPTIMIZER_VERSION.getKey())
            .getValue());
    assertEquals(3, eqAndEmptyDelimiterOptions.getMaxPartitions());

    ConnectionOptions emptyValueAndTrailingDelimiter =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(baseUri + "?optimizerVersion=")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals(
        "",
        emptyValueAndTrailingDelimiter
            .getInitialConnectionPropertyValues()
            .get(ConnectionProperties.OPTIMIZER_VERSION.getKey())
            .getValue());
    assertNull(
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(baseUri + "?")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getWarnings());
    assertNull(
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(baseUri + ";")
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getWarnings());

    SpannerException duplicateStartupRejected =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(baseUri + "?endpoint=a;endpoint=b")
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, duplicateStartupRejected.getErrorCode());

    // Duplicate Context.USER property in URI uses first-occurrence-wins semantics.
    ConnectionOptions duplicateUserFirstWins =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(baseUri + "?autocommit=true;autocommit=false;maxPartitions=5;maxPartitions=bad")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertTrue(duplicateUserFirstWins.isAutocommit());
    assertEquals(5, duplicateUserFirstWins.getMaxPartitions());

    // REJECT checks startup properties before validateValues runs on USER property values.
    SpannerException invalidUserAndStartup =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setUri(baseUri + "?maxPartitions=bad;minSessions=100")
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, invalidUserAndStartup.getErrorCode());
    assertTrue(
        invalidUserAndStartup.getMessage(),
        invalidUserAndStartup.getMessage().contains("minSessions"));

    // Setting the same STARTUP property programmatically does not exempt it in the URI.
    SpannerException programmaticAndUriStartup =
        assertThrows(
            SpannerException.class,
            () ->
                ConnectionOptions.newBuilder()
                    .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                    .setConnectionPropertyValue(
                        ConnectionPropertyValue.of(ConnectionProperties.MIN_SESSIONS, 50))
                    .setUri(baseUri + "?minSessions=100")
                    .build());
    assertEquals(ErrorCode.INVALID_ARGUMENT, programmaticAndUriStartup.getErrorCode());

    // Invalid SessionPoolOptions combination via ConnectionPropertyValue fails at build().
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ConnectionOptions.newBuilder()
                .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                .setUri(baseUri)
                .setCredentials(NoCredentials.getInstance())
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(ConnectionProperties.MIN_SESSIONS, 100))
                .setConnectionPropertyValue(
                    ConnectionPropertyValue.of(ConnectionProperties.MAX_SESSIONS, 10))
                .build());

    // Tightened HOSTGROUP rejects query/path/userinfo delimiters before /projects/, and
    // SPANNER_URI_FORMAT rejects '|' as a property delimiter.
    for (String invalidHostOrDelimiterUri :
        Arrays.asList(
            "cloudspanner://host?minSessions=100/projects/test-project-123/instances/test-instance/databases/test-database",
            "cloudspanner://user@host/projects/test-project-123/instances/test-instance/databases/test-database",
            "cloudspanner://host;minSessions=100/projects/test-project-123/instances/test-instance/databases/test-database",
            baseUri + "|minSessions=100",
            baseUri + "|autocommit=false")) {
      assertThrows(
          "Expected invalid URI " + invalidHostOrDelimiterUri + " to be rejected",
          IllegalArgumentException.class,
          () ->
              ConnectionOptions.newBuilder()
                  .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
                  .setUri(invalidHostOrDelimiterUri));
    }

    // Query parameter containing /projects/... cannot hijack HOSTGROUP or projectId.
    ConnectionOptions projectInQuerySafe =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(
                "cloudspanner://trusted.host:443/projects/trusted-proj/instances/test-instance/databases/test-database?optimizerVersion=1/projects/evil-proj/instances/evil-inst/databases/evil-db")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("https://trusted.host:443", projectInQuerySafe.getHost());
    assertEquals("trusted-proj", projectInQuerySafe.getProjectId());

    // IPv6 bracketed literal remains supported in HOSTGROUP.
    ConnectionOptions ipv6HostOptions =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(
                "cloudspanner://[::1]:9010/projects/test-project-123/instances/test-instance/databases/test-database")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("https://[::1]:9010", ipv6HostOptions.getHost());

    // Scoped contract: StartupPropertyPolicy.REJECT governs URI properties while still allowing
    // HOSTGROUP and Omni URI structure when only USER properties are in the query string.
    ConnectionOptions omniWithUserParam =
        ConnectionOptions.newBuilder()
            .setStartupPropertyPolicy(StartupPropertyPolicy.REJECT)
            .setUri(omniUri + "?autocommit=false")
            .setCredentials(NoCredentials.getInstance())
            .build();
    assertEquals("https://custom.host:443", omniWithUserParam.getHost());
    assertFalse(omniWithUserParam.isAutocommit());
  }
}
