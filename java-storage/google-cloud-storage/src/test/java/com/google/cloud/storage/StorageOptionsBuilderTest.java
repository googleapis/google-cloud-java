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

import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
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
    com.google.auth.Credentials credentials =
        com.google.auth.oauth2.GoogleCredentials.create(
            new com.google.auth.oauth2.AccessToken("token", null));
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setCredentials(credentials)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .build();

    GrpcStorageOptions rebuilt = options.toBuilder().build();
    assertAll(
        () -> assertThat(rebuilt).isEqualTo(options),
        () -> assertThat(rebuilt.hashCode()).isEqualTo(options.hashCode()));

    com.google.storage.v2.StorageSettings settings = options.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage.googleapis.com:443");

    com.google.api.gax.rpc.TransportChannelProvider tcp = settings.getTransportChannelProvider();
    assertThat(tcp).isInstanceOf(com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.class);
    // ClientContext attaches the settings' credentials to the channel provider when the client is
    // created; DirectPath over Interconnect requires them.
    com.google.api.gax.grpc.InstantiatingGrpcChannelProvider provider =
        (com.google.api.gax.grpc.InstantiatingGrpcChannelProvider)
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
            .setCredentials(com.google.cloud.NoCredentials.getInstance())
            .setAttemptDirectPathXdsOverInterconnect(true)
            .build();
    com.google.storage.v2.StorageSettings settings = options.getStorageSettings();

    // NoCredentials resolves to no credentials, so ClientContext leaves the channel provider
    // without any, and the channel uses CloudPath.
    assertThat(settings.getCredentialsProvider().getCredentials()).isNull();
    com.google.api.gax.grpc.InstantiatingGrpcChannelProvider provider =
        (com.google.api.gax.grpc.InstantiatingGrpcChannelProvider)
            settings.getTransportChannelProvider();
    assertThat(provider.isDirectPathXdsEnabled()).isTrue();
    assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void grpc_fallbackFromDirectPathXdsOverInterconnect_nonGduUniverse() throws Exception {
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setHost("https://storage.my-universe.com")
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(com.google.cloud.NoCredentials.getInstance())
            .build();
    com.google.storage.v2.StorageSettings settings = options.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage.my-universe.com:443");

    com.google.api.gax.grpc.InstantiatingGrpcChannelProvider provider =
        (com.google.api.gax.grpc.InstantiatingGrpcChannelProvider)
            settings.getTransportChannelProvider();
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
