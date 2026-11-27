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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.storage.v2.StorageSettings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class StorageOptionsBuilderTest {

  private MyStorageRetryStrategy storageRetryStrategy;
  private BlobWriteSessionConfig bwsc;

  @Before
  public void setUp() throws Exception {
    storageRetryStrategy = new MyStorageRetryStrategy();
    bwsc =
        BlobWriteSessionConfigs.parallelCompositeUpload()
            .withBufferAllocationStrategy(BufferAllocationStrategy.simple(256 * 1024))
            .withPartNamingStrategy(PartNamingStrategy.prefix("blahblahblah"))
            .withExecutorSupplier(ExecutorSupplier.fixedPool(2));
  }

  @After
  public void tearDown() {
    ServiceOptions.setEnvResolverForTesting(null);
  }

  @Test
  public void http() throws Exception {
    HttpStorageOptions base =
        HttpStorageOptions.http()
            .setStorageRetryStrategy(storageRetryStrategy)
            .setBlobWriteSessionConfig(bwsc)
            .build();

    HttpStorageOptions rebuilt = base.toBuilder().build();
    assertAll(
        () -> assertThat(rebuilt).isEqualTo(base),
        () -> assertThat(rebuilt.hashCode()).isEqualTo(base.hashCode()));
  }

  @Test
  public void grpc() throws Exception {
    GrpcStorageOptions base =
        GrpcStorageOptions.grpc()
            .setStorageRetryStrategy(storageRetryStrategy)
            .setBlobWriteSessionConfig(bwsc)
            .build();

    GrpcStorageOptions rebuilt = base.toBuilder().build();
    assertAll(
        () -> assertThat(rebuilt).isEqualTo(base),
        () -> assertThat(rebuilt.hashCode()).isEqualTo(base.hashCode()));
  }

  @Test
  public void grpc_attemptDirectPathXdsOverInterconnect() throws Exception {
    Credentials credentials = GoogleCredentials.create(new AccessToken("token", null));
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setCredentials(credentials)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .build();

    GrpcStorageOptions rebuilt = options.toBuilder().build();
    assertAll(
        () -> assertThat(rebuilt).isEqualTo(options),
        () -> assertThat(rebuilt.hashCode()).isEqualTo(options.hashCode()));

    StorageSettings settings = options.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage.googleapis.com:443");

    TransportChannelProvider tcp = settings.getTransportChannelProvider();
    assertThat(tcp).isInstanceOf(InstantiatingGrpcChannelProvider.class);
    // ClientContext attaches the settings' credentials to the channel provider when the client is
    // created; DirectPath over Interconnect requires them.
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            tcp.withCredentials(settings.getCredentialsProvider().getCredentials());

    assertThat(provider.getEndpoint()).isEqualTo("storage.googleapis.com:443");
    assertThat(provider.isDirectPathXdsEnabled()).isTrue();
    if (Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DISABLE_DIRECT_PATH"))) {
      assertThat(provider.canUseDirectPath()).isFalse();
    } else {
      assertThat(provider.canUseDirectPath()).isTrue();
    }
  }

  @Test
  public void grpc_attemptDirectPathXdsOverInterconnect_noCredentials_fallsBackToCloudPath()
      throws Exception {
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setCredentials(NoCredentials.getInstance())
            .setAttemptDirectPathXdsOverInterconnect(true)
            .build();
    StorageSettings settings = options.getStorageSettings();

    // NoCredentials resolves to no credentials, so ClientContext leaves the channel provider
    // without any, and the channel uses CloudPath.
    assertThat(settings.getCredentialsProvider().getCredentials()).isNull();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider) settings.getTransportChannelProvider();
    assertThat(provider.isDirectPathXdsEnabled()).isTrue();
    assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void grpc_fallbackFromDirectPathXdsOverInterconnect_nonGduUniverse() throws Exception {
    // Valid credentials, so only the non-GDU endpoint keeps the channel off DirectPath.
    Credentials credentials = GoogleCredentials.create(new AccessToken("token", null));
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setHost("https://storage.my-universe.com")
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(credentials)
            .build();
    StorageSettings settings = options.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage.my-universe.com:443");

    TransportChannelProvider tcp = settings.getTransportChannelProvider();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            tcp.withCredentials(settings.getCredentialsProvider().getCredentials());
    assertThat(provider.getEndpoint()).isEqualTo("storage.my-universe.com:443");
    assertThat(provider.isDirectPathXdsEnabled()).isTrue();
    assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void useJwtAccessWithScope_defaultsToFalse() {
    HttpStorageOptions httpOptions = HttpStorageOptions.http().build();
    GrpcStorageOptions grpcOptions = GrpcStorageOptions.grpc().build();

    assertThat(httpOptions.getUseJwtAccessWithScope()).isFalse();
    assertThat(grpcOptions.getUseJwtAccessWithScope()).isFalse();
  }

  @Test
  public void http_universeDomainFromEnvironment_resolvesHost() {
    ServiceOptions.setEnvResolverForTesting(
        key -> EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN.equals(key) ? "example.com" : null);

    HttpStorageOptions envOptions = StorageOptions.http().build();
    assertThat(envOptions.getHost()).isEqualTo("https://storage.example.com/");
    assertThat(envOptions.getUniverseDomain()).isNull();
  }

  @Test
  public void grpc_universeDomainFromEnvironment_resolvesHostAndEndpoint() throws Exception {
    ServiceOptions.setEnvResolverForTesting(
        key -> EndpointContext.GOOGLE_CLOUD_UNIVERSE_DOMAIN.equals(key) ? "example.com" : null);

    GrpcStorageOptions envOptions =
        StorageOptions.grpc().setCredentials(NoCredentials.getInstance()).build();
    assertThat(envOptions.getHost()).isEqualTo("https://storage.example.com");
    assertThat(envOptions.getUniverseDomain()).isNull();
    assertThat(envOptions.getResolvedUniverseDomainForService()).isEqualTo("example.com");
    assertThat(envOptions.toBuilder().build().getHost()).isEqualTo("https://storage.example.com");
    StorageSettings envSettings = envOptions.getStorageSettings();
    assertThat(envSettings.getEndpoint()).isEqualTo("storage.example.com:443");
    InstantiatingGrpcChannelProvider envProvider =
        (InstantiatingGrpcChannelProvider) envSettings.getTransportChannelProvider();
    assertThat(envProvider.getEndpoint()).isEqualTo("storage.example.com:443");

    assertThat(envOptions.toBuilder().setUniverseDomain("explicit.example.com").build().getHost())
        .isEqualTo("https://storage.explicit.example.com");

    GrpcStorageOptions.Builder reusableBuilder =
        StorageOptions.grpc().setCredentials(NoCredentials.getInstance());
    assertThat(reusableBuilder.build().getHost()).isEqualTo("https://storage.example.com");
    assertThat(reusableBuilder.setUniverseDomain("explicit.example.com").build().getHost())
        .isEqualTo("https://storage.explicit.example.com");

    GrpcStorageOptions explicitHostAndUniverseOptions =
        StorageOptions.grpc()
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://custom.example.com")
            .setUniverseDomain("explicit.example.com")
            .build();
    assertThat(explicitHostAndUniverseOptions.getHost()).isEqualTo("https://custom.example.com");

    GrpcStorageOptions explicitHostOptions =
        StorageOptions.grpc()
            .setCredentials(NoCredentials.getInstance())
            .setHost("https://custom.example.com")
            .build();
    assertThat(explicitHostOptions.getHost()).isEqualTo("https://custom.example.com");
    assertThat(explicitHostOptions.getStorageSettings().getEndpoint())
        .isEqualTo("custom.example.com:443");
    assertThat(
            explicitHostOptions.toBuilder()
                .setUniverseDomain("explicit.example.com")
                .build()
                .getHost())
        .isEqualTo("https://custom.example.com");

    ServiceOptions.setEnvResolverForTesting(null);
    assertThat(
            GrpcStorageOptions.getDefaultInstance().toBuilder()
                .setUniverseDomain("explicit.example.com")
                .build()
                .getHost())
        .isEqualTo("https://storage.explicit.example.com");
  }

  private static class MyStorageRetryStrategy implements StorageRetryStrategy {

    @Override
    public ResultRetryAlgorithm<?> getIdempotentHandler() {
      return null;
    }

    @Override
    public ResultRetryAlgorithm<?> getNonidempotentHandler() {
      return null;
    }
  }
}
