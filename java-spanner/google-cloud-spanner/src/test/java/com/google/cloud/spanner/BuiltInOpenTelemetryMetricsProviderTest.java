/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInOpenTelemetryMetricsProviderTest {

  @Before
  public void setUp() {
    BuiltInMetricsProvider.INSTANCE.reset();
  }

  @After
  public void tearDown() {
    BuiltInMetricsProvider.INSTANCE.reset();
  }

  @Test
  public void testGenerateClientHashWithSimpleUid() {
    String clientUid = "testClient";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithEmptyUid() {
    String clientUid = "";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithNullUid() {
    String clientUid = null;
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithLongUid() {
    String clientUid = "aVeryLongUniqueClientIdentifierThatIsUnusuallyLong";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithSpecialCharacters() {
    String clientUid = "273d60f2-5604-42f1-b687-f5f1b975fd07@2316645@test#";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testApiTracerFactoryDoesNotSetBuiltInMetricsProject() {
    SpannerOptions options = newTestOptions();

    options.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);

    assertNull(BuiltInMetricsProvider.INSTANCE.getProjectId());
  }

  @Test
  public void testBuiltInOpenTelemetryDoesNotSetMetricsProject() {
    SpannerOptions options = newTestOptions();

    options.getBuiltInOpenTelemetry();

    assertNull(BuiltInMetricsProvider.INSTANCE.getProjectId());
  }

  @Test
  public void testInitializeBuiltInMetricsUsesDatabaseProject() {
    SpannerOptions options = newTestOptions();

    options.initializeBuiltInMetrics(DatabaseId.of("database-project", "i", "d"));
    options.initializeBuiltInMetrics(DatabaseId.of("other-project", "i", "d"));

    assertEquals("database-project", BuiltInMetricsProvider.INSTANCE.getProjectId());
  }

  private void verifyHash(String hash) {
    // Check if the hash length is 6
    assertEquals(hash.length(), 6);
    // Check if the hash is in the range [000000, 0003ff]
    long hashValue = Long.parseLong(hash, 16); // Convert hash from hex to decimal
    assertTrue(hashValue >= 0 && hashValue <= 0x3FF);
  }

  private SpannerOptions newTestOptions() {
    return SpannerOptions.newBuilder()
        .setProjectId("host-project")
        .setCredentials(
            OAuth2Credentials.create(new AccessToken("test-token", new Date(Long.MAX_VALUE))))
        .build();
  }
}
