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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.spanner.SpannerOptions;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionOptionsTest {
  private static final String FILE_TEST_PATH =
      ConnectionOptionsTest.class.getResource("test-key.json").getFile();
  private static final String DEFAULT_HOST = "https://spanner.googleapis.com";

  @Test
  public void testBuildWithValidURIAndCredentialsFileURL() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost(), is(equalTo(DEFAULT_HOST)));
    assertThat(options.getProjectId(), is(equalTo("test-project-123")));
    assertThat(options.getInstanceId(), is(equalTo("test-instance-123")));
    assertThat(options.getDatabaseName(), is(equalTo("test-database-123")));
    assertThat(
        (GoogleCredentials) options.getCredentials(),
        is(equalTo(new CredentialsService().createCredentials(FILE_TEST_PATH))));
    assertThat(options.isAutocommit(), is(equalTo(ConnectionOptions.DEFAULT_AUTOCOMMIT)));
    assertThat(options.isReadOnly(), is(equalTo(ConnectionOptions.DEFAULT_READONLY)));
  }

  @Test
  public void testBuildWithValidURIAndProperties() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/test-project-123/instances/test-instance-123/databases/test-database-123?autocommit=false;readonly=true");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost(), is(equalTo(DEFAULT_HOST)));
    assertThat(options.getProjectId(), is(equalTo("test-project-123")));
    assertThat(options.getInstanceId(), is(equalTo("test-instance-123")));
    assertThat(options.getDatabaseName(), is(equalTo("test-database-123")));
    assertThat(
        (GoogleCredentials) options.getCredentials(),
        is(equalTo(new CredentialsService().createCredentials(FILE_TEST_PATH))));
    assertThat(options.isAutocommit(), is(equalTo(false)));
    assertThat(options.isReadOnly(), is(equalTo(true)));
  }

  @Test
  public void testBuildWithHostAndValidURI() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner://test-spanner.googleapis.com/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost(), is(equalTo("https://test-spanner.googleapis.com")));
    assertThat(options.getProjectId(), is(equalTo("test-project-123")));
    assertThat(options.getInstanceId(), is(equalTo("test-instance-123")));
    assertThat(options.getDatabaseName(), is(equalTo("test-database-123")));
    assertThat(
        (GoogleCredentials) options.getCredentials(),
        is(equalTo(new CredentialsService().createCredentials(FILE_TEST_PATH))));
    assertThat(options.isAutocommit(), is(equalTo(ConnectionOptions.DEFAULT_AUTOCOMMIT)));
    assertThat(options.isReadOnly(), is(equalTo(ConnectionOptions.DEFAULT_READONLY)));
  }

  @Test
  public void testBuildWithLocalhostPortAndValidURI() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner://localhost:8443/projects/test-project-123/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost(), is(equalTo("https://localhost:8443")));
    assertThat(options.getProjectId(), is(equalTo("test-project-123")));
    assertThat(options.getInstanceId(), is(equalTo("test-instance-123")));
    assertThat(options.getDatabaseName(), is(equalTo("test-database-123")));
    assertThat(
        (GoogleCredentials) options.getCredentials(),
        is(equalTo(new CredentialsService().createCredentials(FILE_TEST_PATH))));
    assertThat(options.isAutocommit(), is(equalTo(ConnectionOptions.DEFAULT_AUTOCOMMIT)));
    assertThat(options.isReadOnly(), is(equalTo(ConnectionOptions.DEFAULT_READONLY)));
  }

  @Test
  public void testBuildWithDefaultProjectPlaceholder() {
    ConnectionOptions.Builder builder = ConnectionOptions.newBuilder();
    builder.setUri(
        "cloudspanner:/projects/default_project_id/instances/test-instance-123/databases/test-database-123");
    builder.setCredentialsUrl(FILE_TEST_PATH);
    ConnectionOptions options = builder.build();
    assertThat(options.getHost(), is(equalTo(DEFAULT_HOST)));
    String projectId = SpannerOptions.getDefaultProjectId();
    if (projectId == null) {
      projectId =
          ((ServiceAccountCredentials) new CredentialsService().createCredentials(FILE_TEST_PATH))
              .getProjectId();
    }
    assertThat(options.getProjectId(), is(equalTo(projectId)));
    assertThat(options.getInstanceId(), is(equalTo("test-instance-123")));
    assertThat(options.getDatabaseName(), is(equalTo("test-database-123")));
    assertThat(
        (GoogleCredentials) options.getCredentials(),
        is(equalTo(new CredentialsService().createCredentials(FILE_TEST_PATH))));
    assertThat(options.isAutocommit(), is(equalTo(ConnectionOptions.DEFAULT_AUTOCOMMIT)));
    assertThat(options.isReadOnly(), is(equalTo(ConnectionOptions.DEFAULT_READONLY)));
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
    boolean invalid = false;
    try {
      builder.setUri(uri);
    } catch (IllegalArgumentException e) {
      invalid = true;
    }
    assertThat(uri + " should be considered an invalid uri", invalid, is(true));
  }

  private void setInvalidProperty(
      ConnectionOptions.Builder builder, String uri, String expectedInvalidProperties) {
    boolean invalid = false;
    try {
      builder.setUri(uri);
    } catch (IllegalArgumentException e) {
      invalid = e.getMessage().contains(expectedInvalidProperties);
    }
    assertThat(uri + " should contain invalid properties", invalid, is(true));
  }

  @Test
  public void testParseUriProperty() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

    assertThat(ConnectionOptions.parseUriProperty(baseUri, "autocommit"), is(nullValue()));
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?autocommit=true", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?autocommit=false", "autocommit"),
        is(equalTo("false")));
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?autocommit=true;", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?autocommit=false;", "autocommit"),
        is(equalTo("false")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?autocommit=true;readOnly=false", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?autocommit=false;readOnly=false", "autocommit"),
        is(equalTo("false")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?readOnly=false;autocommit=true", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?readOnly=false;autocommit=false", "autocommit"),
        is(equalTo("false")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?readOnly=false;autocommit=true;foo=bar", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?readOnly=false;autocommit=false;foo=bar", "autocommit"),
        is(equalTo("false")));

    // case insensitive
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?AutoCommit=true", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?AutoCommit=false", "autocommit"),
        is(equalTo("false")));

    // ; instead of ? before the properties is ok
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + ";autocommit=true", "autocommit"),
        is(equalTo("true")));

    // forgot the ? or ; before the properties
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "autocommit=true", "autocommit"),
        is(nullValue()));
    // substring is not ok
    assertThat(
        ConnectionOptions.parseUriProperty(baseUri + "?isautocommit=true", "autocommit"),
        is(nullValue()));
  }

  @Test
  public void testParseProperties() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    assertThat(
        ConnectionOptions.parseProperties(baseUri + "?autocommit=true"),
        is(equalTo(Arrays.asList("autocommit"))));
    assertThat(
        ConnectionOptions.parseProperties(baseUri + "?autocommit=true;readonly=false"),
        is(equalTo(Arrays.asList("autocommit", "readonly"))));
    assertThat(
        ConnectionOptions.parseProperties(baseUri + "?autocommit=true;READONLY=false"),
        is(equalTo(Arrays.asList("autocommit", "READONLY"))));
    assertThat(
        ConnectionOptions.parseProperties(baseUri + ";autocommit=true;readonly=false"),
        is(equalTo(Arrays.asList("autocommit", "readonly"))));
    assertThat(
        ConnectionOptions.parseProperties(baseUri + ";autocommit=true;readonly=false;"),
        is(equalTo(Arrays.asList("autocommit", "readonly"))));
  }

  @Test
  public void testParsePropertiesSpecifiedMultipleTimes() {
    final String baseUri =
        "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?autocommit=true;autocommit=false", "autocommit"),
        is(equalTo("true")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + "?autocommit=false;autocommit=true", "autocommit"),
        is(equalTo("false")));
    assertThat(
        ConnectionOptions.parseUriProperty(
            baseUri + ";autocommit=false;readonly=false;autocommit=true", "autocommit"),
        is(equalTo("false")));
    ConnectionOptions.newBuilder()
        .setUri(
            "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database"
                + ";autocommit=false;readonly=false;autocommit=true");
  }
}
