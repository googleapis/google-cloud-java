/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcUrlUtilityTest extends BigQueryJdbcLoggingBaseTest {

  private static final String BASE_URL =
      "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;";

  @Test
  public void testParsePropertyWithNoDefault() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isNull();
  }

  @Test
  public void testParseUrlWithUnknownProperty_no_exception() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;UnknownProperty=SomeValue";

    BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(assertLogContains("Wrong value or unknown setting")).isTrue();
  }

  @Test
  public void testParseUrlWithTypo_no_exception() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;ProjeectId=TypoValue";

    assertDoesNotThrow(() -> BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId"));
    assertThat(assertLogContains("Wrong value or unknown setting")).isTrue();
  }

  @Test
  public void testParsePropertyWithDefault() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isNull();
  }

  @Test
  public void testParsePropertyWithValue() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testParsePropertyWithValueCaseInsensitive() {
    String url = BASE_URL + "PROJECTID=MyBigQueryProject;OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testAppendPropertiesToURL() {
    String url = BASE_URL + "ProjectId=MyBigQueryProject;OAuthAccessToken=RedactedToken";
    Properties properties = new Properties();
    properties.setProperty("OAuthType", "3");

    String updatedUrl = BigQueryJdbcUrlUtility.appendPropertiesToURL(url, null, properties);
    assertThat(updatedUrl.contains("OAuthType=3"));
  }

  @Test
  public void testConnectionPropertiesFromURI() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;OAUTHTYPE=3;DEFAULTDATASET=testDataset;LOCATION=us-central1";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "OAUTHTYPE")).isEqualTo("3");
    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "LOCATION"))
        .isEqualTo("us-central1");
  }

  @Test
  public void testConnectionPropertiesFromURIMultiline() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthPvtKey=value1\nvalue2\n;";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "OAuthPvtKey"))
        .isEqualTo("value1\nvalue2\n");
  }

  @Test
  public void testConnectionPropertiesFromURIMultilineNoSemicolon() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthPvtKey=value1\nvalue2";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "OAuthPvtKey"))
        .isEqualTo("value1\nvalue2");
  }

  @Test
  public void testParseUrl_longUnknownProperty_sanitized() {
    String longKey = String.join("", Collections.nCopies(50, "a"));
    String url = BASE_URL + longKey + "=value";

    assertDoesNotThrow(() -> BigQueryJdbcUrlUtility.parseUrl(url));
    String message = capturedLogs.get(0).getMessage();
    assertThat(message).contains("Wrong value or unknown setting: ");
    assertThat(message).contains("...");
    assertThat(message).doesNotContain(longKey);
    assertThat(message.length()).isLessThan(100);
  }

  @Test
  public void testParsePartnerTokenProperty() {
    // Case with partner name and environment
    String url = BASE_URL + "PartnerToken=(GPN:partner_company; dev);ProjectId=MyBigQueryProject;";
    String expected = " (GPN:partner_company; dev)";
    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);

    // Case with only partner name
    url = BASE_URL + "PartnerToken=(GPN:another_partner);ProjectId=MyBigQueryProject;";
    expected = " (GPN:another_partner)";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);

    // Case when PartnerToken property is not present
    url = BASE_URL + "ProjectId=MyBigQueryProject;";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case when PartnerToken property is present but empty
    url = BASE_URL + "PartnerToken=();";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case when PartnerToken property is present but without partner name
    url = BASE_URL + "PartnerToken=(env);";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case with extra spaces around the values
    url = BASE_URL + "PartnerToken= ( GPN: partner_name ; test_env ) ;";
    expected = " (GPN: partner_name ; test_env)";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testAppendPropertiesToURL_propertyWithSemicolon_isEscaped() throws Exception {
    String url = BASE_URL;
    Properties properties = new Properties();
    String complexValue = "value;ExtraProperty=injection";
    properties.setProperty("ProjectId", complexValue);

    String updatedUrl = BigQueryJdbcUrlUtility.appendPropertiesToURL(url, null, properties);

    Map<String, String> parsedProperties = BigQueryJdbcUrlUtility.parseUrl(updatedUrl);

    assertThat(parsedProperties.get("ProjectId")).isEqualTo(complexValue);
    assertFalse(parsedProperties.containsKey("ExtraProperty"));
  }

  @Test
  public void testInvalidConnectionProperties() {
    String url = "jdbc:bigquery://;MaxResults=-1";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url));

    String url2 = "jdbc:bigquery://;ConnectionPoolSize=-2";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url2));

    String url3 = "jdbc:bigquery://;Timeout=-1";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url3));

    String url4 = "jdbc:bigquery://;JobTimeout=-1";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url4));

    String url5 = "jdbc:bigquery://;RetryInitialDelay=-1";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url5));

    String url6 = "jdbc:bigquery://;RetryMaxDelay=-1";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url6));

    String url7 = "jdbc:bigquery://;MaxResults=0";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url7));
  }

  @Test
  public void testInvalidSetterValues() {
    DataSource ds = new DataSource();
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setMaxResults(-1L));
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setMaxResults(0L));
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setTimeout(-1));
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setJobTimeout(-1));
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setRetryInitialDelay(-1));
    assertThrows(BigQueryJdbcRuntimeException.class, () -> ds.setRetryMaxDelay(-1));
  }

  @Test
  public void testNonNumericConnectionProperties() {
    String url = "jdbc:bigquery://;MaxResults=abc";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url));
  }

  @Test
  public void testUnrecognizedConnectionProperties() {
    // Unrecognized key-value pair should be ignored (log warning, no exception)
    String url = "jdbc:bigquery://;UnknownProperty=value";
    assertDoesNotThrow(() -> DataSource.fromUrl(url));

    // Malformed property (not key-value) should throw exception
    String url2 = "jdbc:bigquery://;MalformedProperty";
    assertThrows(BigQueryJdbcRuntimeException.class, () -> DataSource.fromUrl(url2));
  }

  @Test
  public void testParseAuthorityEndpointOverride() {
    String url = "jdbc:bigquery://https://custom-endpoint.com:443;ProjectId=MyProject";
    String endpointOverride = BigQueryJdbcUrlUtility.parseUriProperty(url, "EndpointOverrides");
    assertThat(endpointOverride).isEqualTo("BIGQUERY=https://custom-endpoint.com:443");
  }

  @Test
  public void testParseAuthorityEndpointOverrideNoSemicolon() {
    String url = "jdbc:bigquery://https://custom-endpoint.com:443";
    String endpointOverride = BigQueryJdbcUrlUtility.parseUriProperty(url, "EndpointOverrides");
    assertThat(endpointOverride).isEqualTo("BIGQUERY=https://custom-endpoint.com:443");
  }

  @Test
  public void testParseAuthorityProxy() {
    String url = "jdbc:bigquery://proxy.example.com:8080;ProjectId=MyProject";
    String proxyHost = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProxyHost");
    String proxyPort = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProxyPort");
    assertThat(proxyHost).isEqualTo("proxy.example.com");
    assertThat(proxyPort).isEqualTo("8080");
  }

  @Test
  public void testParseAuthorityProxyNoPort() {
    String url = "jdbc:bigquery://proxy.example.com;ProjectId=MyProject";
    String proxyHost = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProxyHost");
    String proxyPort = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProxyPort");
    assertThat(proxyHost).isEqualTo("proxy.example.com");
    assertThat(proxyPort).isNull();
  }

  @Test
  public void testParseAuthorityAndMergeEndpointOverrides() {
    String url =
        BASE_URL
            + "EndpointOverrides=READ_API=https://storage-endpoint.com:443;ProjectId=MyProject";
    String endpointOverride = BigQueryJdbcUrlUtility.parseUriProperty(url, "EndpointOverrides");
    assertThat(endpointOverride)
        .isEqualTo(
            "BIGQUERY=https://www.googleapis.com/bigquery/v2:443,READ_API=https://storage-endpoint.com:443");
  }

  @Test
  public void testParseAuthorityAndOverwriteEndpointOverrides() {
    String url =
        BASE_URL
            + "EndpointOverrides=BIGQUERY=https://another-endpoint.com:443,READ_API=https://storage-endpoint.com:443;ProjectId=MyProject";
    String endpointOverride = BigQueryJdbcUrlUtility.parseUriProperty(url, "EndpointOverrides");
    assertThat(endpointOverride)
        .isEqualTo(
            "BIGQUERY=https://another-endpoint.com:443,READ_API=https://storage-endpoint.com:443");
  }

  @Test
  public void testDataSourceFromUrlAuthorityEndpoint() {
    String url = BASE_URL + "ProjectId=MyProject";
    DataSource ds = DataSource.fromUrl(url);
    assertThat(ds.getProjectId()).isEqualTo("MyProject");
    assertThat(ds.getOverrideProperties().get("BIGQUERY"))
        .isEqualTo("https://www.googleapis.com/bigquery/v2:443");
  }

  @Test
  public void testDataSourceFromUrlAuthorityProxy() {
    String url = "jdbc:bigquery://proxy.example.com:8080;ProjectId=MyProject";
    DataSource ds = DataSource.fromUrl(url);
    assertThat(ds.getProxyHost()).isEqualTo("proxy.example.com");
    assertThat(ds.getProxyPort()).isEqualTo("8080");
  }
}
