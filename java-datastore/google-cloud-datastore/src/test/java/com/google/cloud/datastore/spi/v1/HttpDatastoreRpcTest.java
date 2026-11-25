/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.datastore.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.datastore.v1.LookupRequest;
import com.google.rpc.Code;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class HttpDatastoreRpcTest {

  private static final String PROJECT_ID = "test-project";
  private static final String CUSTOM_UNIVERSE_DOMAIN = "s3nsapis.fr";

  /** Minimal Credentials implementation with a configurable universe domain for unit testing. */
  private static class FakeUniverseCredentials extends Credentials {
    private final String universeDomain;

    private FakeUniverseCredentials(String universeDomain) {
      this.universeDomain = universeDomain;
    }

    @Override
    public String getAuthenticationType() {
      return "Fake";
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) {
      return Collections.emptyMap();
    }

    @Override
    public boolean hasRequestMetadata() {
      return false;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return true;
    }

    @Override
    public void refresh() {}

    @Override
    public String getUniverseDomain() {
      return universeDomain;
    }
  }

  private static DatastoreOptions.Builder httpOptionsBuilder() {
    return DatastoreOptions.newBuilder()
        .setProjectId(PROJECT_ID)
        .setTransportOptions(HttpTransportOptions.newBuilder().build())
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void testResolveUniverseDomain_explicitOverridesEnvAndDefault() {
    DatastoreOptions options =
        httpOptionsBuilder().setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN).build();
    assertEquals(
        CUSTOM_UNIVERSE_DOMAIN,
        HttpDatastoreRpc.resolveUniverseDomain(options, "other-universe.example.com"));
  }

  @Test
  public void testResolveUniverseDomain_fallsBackToEnvVar() {
    DatastoreOptions options = httpOptionsBuilder().build();
    assertEquals(
        CUSTOM_UNIVERSE_DOMAIN,
        HttpDatastoreRpc.resolveUniverseDomain(options, CUSTOM_UNIVERSE_DOMAIN));
  }

  @Test
  public void testResolveUniverseDomain_defaultsToGoogleapis() {
    DatastoreOptions options = httpOptionsBuilder().build();
    assertEquals(
        Credentials.GOOGLE_DEFAULT_UNIVERSE, HttpDatastoreRpc.resolveUniverseDomain(options, null));
  }

  @Test
  public void testResolveUniverseDomain_emptyThrows() {
    DatastoreOptions options = httpOptionsBuilder().setUniverseDomain("").build();
    assertThrows(
        IllegalArgumentException.class,
        () -> HttpDatastoreRpc.resolveUniverseDomain(options, null));
  }

  @Test
  public void testCreateClientOptionsBuilder_customUniverseDomainSetsHost() {
    DatastoreOptions options =
        httpOptionsBuilder().setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN).build();
    HttpRequestInitializer initializer = request -> {};
    com.google.datastore.v1.client.DatastoreOptions clientOptions =
        HttpDatastoreRpc.createClientOptionsBuilder(
                options, initializer, new MockHttpTransport(), CUSTOM_UNIVERSE_DOMAIN)
            .build();
    assertEquals("datastore." + CUSTOM_UNIVERSE_DOMAIN, clientOptions.getHost());
  }

  @Test
  public void testCreateClientOptionsBuilder_defaultUniverseDomainLeavesHostUnset() {
    DatastoreOptions options = httpOptionsBuilder().build();
    HttpRequestInitializer initializer = request -> {};
    com.google.datastore.v1.client.DatastoreOptions clientOptions =
        HttpDatastoreRpc.createClientOptionsBuilder(
                options, initializer, new MockHttpTransport(), Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .build();
    assertNull(clientOptions.getHost());
  }

  @Test
  public void testCreateClientOptionsBuilder_customHostPreserved() {
    DatastoreOptions options =
        httpOptionsBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setHost("https://custom-datastore.example.com")
            .build();
    HttpRequestInitializer initializer = request -> {};
    com.google.datastore.v1.client.DatastoreOptions clientOptions =
        HttpDatastoreRpc.createClientOptionsBuilder(
                options, initializer, new MockHttpTransport(), CUSTOM_UNIVERSE_DOMAIN)
            .build();
    assertEquals("custom-datastore.example.com", clientOptions.getHost());
  }

  @Test
  public void testValidateUniverseDomain_mismatchedCredentialsThrowsOnRpc() {
    DatastoreOptions options =
        httpOptionsBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setCredentials(new FakeUniverseCredentials(Credentials.GOOGLE_DEFAULT_UNIVERSE))
            .build();
    HttpDatastoreRpc rpc = new HttpDatastoreRpc(options, null);

    DatastoreException exception =
        assertThrows(
            DatastoreException.class, () -> rpc.lookup(LookupRequest.getDefaultInstance()));
    assertEquals(Code.UNAUTHENTICATED.getNumber(), exception.getCode());
    assertEquals(Code.UNAUTHENTICATED.name(), exception.getReason());
    assertTrue(exception.getMessage().contains(CUSTOM_UNIVERSE_DOMAIN));
  }

  @Test
  public void testValidateUniverseDomain_matchingCredentialsSucceeds() {
    DatastoreOptions options =
        httpOptionsBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .build();
    HttpDatastoreRpc rpc = new HttpDatastoreRpc(options, null);
    rpc.validateUniverseDomain();
  }

  @Test
  public void testValidateUniverseDomain_apiKeyCredentialsSkipsValidation() {
    DatastoreOptions options =
        httpOptionsBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setCredentials(ApiKeyCredentials.create("test-api-key"))
            .build();
    HttpDatastoreRpc rpc = new HttpDatastoreRpc(options, null);
    rpc.validateUniverseDomain();
  }
}
