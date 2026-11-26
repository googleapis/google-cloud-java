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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.EndpointContext;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.storage.v2.StorageSettings;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Test;

public final class GrpcStorageUniverseDomainTest {

  private static final String CUSTOM_UNIVERSE = "custom.example.com";

  @After
  public void tearDown() {
    StorageOptions.resetEnvResolverForTesting();
  }

  @Test
  public void resolvesDefaultHostAndChannelSettingsFromConfiguredUniverseDomain() throws Exception {
    Map<String, String> env = new HashMap<>();
    env.put(EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN, CUSTOM_UNIVERSE);
    StorageOptions.setEnvResolverForTesting(env::get);

    Credentials customCreds =
        GoogleCredentials.newBuilder()
            .setAccessToken(new AccessToken("test-token", null))
            .setUniverseDomain(CUSTOM_UNIVERSE)
            .build();
    GrpcStorageOptions grpcOptions =
        StorageOptions.grpc()
            .setProjectId("test-proj")
            .setCredentials(customCreds)
            .setEnableGrpcClientMetrics(false)
            .build();
    assertThat(grpcOptions.getUniverseDomain()).isNull();
    assertThat(grpcOptions.getHost()).isEqualTo("https://storage.custom.example.com");

    StorageSettings settings = grpcOptions.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage.custom.example.com:443");
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE);
  }

  @Test
  public void hostResolutionWithExplicitUniverseDomain() {
    GrpcStorageOptions customHostGrpc =
        StorageOptions.grpc()
            .setProjectId("test-proj")
            .setHost("http://localhost:8080")
            .setUniverseDomain("explicit.example.com")
            .build();
    assertThat(customHostGrpc.getHost()).isEqualTo("http://localhost:8080");

    GrpcStorageOptions defaultHostGrpc =
        StorageOptions.grpc()
            .setProjectId("test-proj")
            .setHost("https://storage.googleapis.com")
            .setUniverseDomain("explicit.example.com")
            .build();
    assertThat(defaultHostGrpc.getHost()).isEqualTo("https://storage.explicit.example.com");

    GrpcStorageOptions rebuiltGrpc =
        StorageOptions.grpc()
            .setProjectId("test-proj")
            .setUniverseDomain("first.example.com")
            .build()
            .toBuilder()
            .setUniverseDomain("explicit.example.com")
            .build();
    assertThat(rebuiltGrpc.getHost()).isEqualTo("https://storage.explicit.example.com");
  }
}
