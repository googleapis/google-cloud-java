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
    com.google.auth.Credentials mockCreds = com.google.cloud.NoCredentials.getInstance();
    GrpcStorageOptions options =
        GrpcStorageOptions.grpc()
            .setCredentials(mockCreds)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .build();

    GrpcStorageOptions rebuilt = options.toBuilder().build();
    assertAll(
        () -> assertThat(rebuilt).isEqualTo(options),
        () -> assertThat(rebuilt.hashCode()).isEqualTo(options.hashCode()));

    com.google.storage.v2.StorageSettings settings = options.getStorageSettings();
    assertThat(settings.getEndpoint()).isEqualTo("storage-direct.googleapis.com:443");

    com.google.api.gax.rpc.TransportChannelProvider tcp = settings.getTransportChannelProvider();
    assertThat(tcp).isInstanceOf(com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.class);
    com.google.api.gax.grpc.InstantiatingGrpcChannelProvider provider =
        (com.google.api.gax.grpc.InstantiatingGrpcChannelProvider) tcp;

    assertThat(provider.isAttemptDirectPathXdsOverInterconnect()).isTrue();
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
