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

import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ClientContext;
import com.google.auth.Credentials;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GrpcDatastoreRpcTest {

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

  @Test
  public void testUniverseDomainResolvesEndpointViaGax() throws Exception {
    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .build();

    GrpcDatastoreRpc rpc = new GrpcDatastoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      assertEquals(CUSTOM_UNIVERSE_DOMAIN, clientContext.getUniverseDomain());
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertEquals("datastore.s3nsapis.fr:443", transportChannel.getChannel().authority());

      DatastoreStubSettings stubSettings =
          GrpcDatastoreRpc.createDatastoreStubSettings(options, clientContext);
      assertEquals(CUSTOM_UNIVERSE_DOMAIN, stubSettings.getUniverseDomain());
      assertEquals("datastore.s3nsapis.fr:443", stubSettings.getEndpoint());
    } finally {
      rpc.close();
    }
  }

  @Test
  public void testCustomHostOverridesDefaultEndpointWithUniverseDomain() throws Exception {
    String customHost = "datastore.googleapis.com:8443";
    DatastoreOptions options =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(new FakeUniverseCredentials(CUSTOM_UNIVERSE_DOMAIN))
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setHost(customHost)
            .build();

    GrpcDatastoreRpc rpc = new GrpcDatastoreRpc(options);
    try {
      ClientContext clientContext = rpc.getClientContext();
      assertEquals(CUSTOM_UNIVERSE_DOMAIN, clientContext.getUniverseDomain());
      GrpcTransportChannel transportChannel =
          (GrpcTransportChannel) clientContext.getTransportChannel();
      assertEquals(customHost, transportChannel.getChannel().authority());

      DatastoreStubSettings stubSettings =
          GrpcDatastoreRpc.createDatastoreStubSettings(options, clientContext);
      assertEquals(CUSTOM_UNIVERSE_DOMAIN, stubSettings.getUniverseDomain());
      assertEquals(customHost, stubSettings.getEndpoint());
    } finally {
      rpc.close();
    }
  }
}
