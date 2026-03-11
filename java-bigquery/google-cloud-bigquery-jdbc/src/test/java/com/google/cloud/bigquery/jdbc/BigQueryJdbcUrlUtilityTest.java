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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import org.junit.Test;

public class BigQueryJdbcUrlUtilityTest {

  @Test
  public void testParsePropertyWithNoDefault() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isNull();
  }

  @Test
  public void testParseUrlWithUnknownProperty_throwsException() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "UnknownProperty=SomeValue";

    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId"));
  }

  @Test
  public void testParseUrlWithTypo_throwsException() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "ProjeectId=TypoValue";

    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId"));
  }

  @Test
  public void testParsePropertyWithDefault() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isEqualTo(null);
  }

  @Test
  public void testParsePropertyWithValue() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testParsePropertyWithValueCaseInsensitive() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PROJECTID=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testAppendPropertiesToURL() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";
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
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;" + longKey + "=value";

    BigQueryJdbcRuntimeException e =
        assertThrows(
            BigQueryJdbcRuntimeException.class, () -> BigQueryJdbcUrlUtility.parseUrl(url));

    assertThat(e.getMessage()).contains("Wrong value or unknown setting: ");
    assertThat(e.getMessage()).contains("...");
    assertThat(e.getMessage()).doesNotContain(longKey);
    assertThat(e.getMessage().length()).isLessThan(100);
  }

  @Test
  public void testParsePartnerTokenProperty() {
    // Case with partner name and environment
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken=(GPN:partner_company; dev);ProjectId=MyBigQueryProject;";
    String expected = " (GPN:partner_company; dev)";
    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);

    // Case with only partner name
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken=(GPN:another_partner);ProjectId=MyBigQueryProject;";
    expected = " (GPN:another_partner)";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);

    // Case when PartnerToken property is not present
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case when PartnerToken property is present but empty
    url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PartnerToken=();";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case when PartnerToken property is present but without partner name
    url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PartnerToken=(env);";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertNull(result);

    // Case with extra spaces around the values
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken= ( GPN: partner_name ; test_env ) ;";
    expected = " (GPN: partner_name ; test_env)";
    result = BigQueryJdbcUrlUtility.parseUriProperty(url, "PartnerToken");
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testAppendPropertiesToURL_propertyWithSemicolon_isEscaped() throws Exception {
    String url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;";
    Properties properties = new Properties();
    String complexValue = "value;ExtraProperty=injection";
    properties.setProperty("ProjectId", complexValue);

    String updatedUrl = BigQueryJdbcUrlUtility.appendPropertiesToURL(url, null, properties);

    Map<String, String> parsedProperties = BigQueryJdbcUrlUtility.parseUrl(updatedUrl);

    assertThat(parsedProperties.get("ProjectId")).isEqualTo(complexValue);
    assertFalse(parsedProperties.containsKey("ExtraProperty"));
  }
}
