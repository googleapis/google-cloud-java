/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.NoCredentials;
import com.google.common.base.Throwables;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.StorageGrpc;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public final class GrpcResponseMetadataTest {

  @Test
  public void getAcceptsSmallResponseMetadata() throws Exception {
    assertThat(getWithResponseMetadata(1024).getGeneration()).isEqualTo(1L);
  }

  @Test
  public void getAcceptsResponseMetadataLargerThanGrpcDefault() throws Exception {
    assertThat(getWithResponseMetadata(18000).getGeneration()).isEqualTo(1L);
  }

  @Test
  public void getRejectsResponseMetadataAboveLimit() {
    StorageException exception =
        assertThrows(StorageException.class, () -> getWithResponseMetadata(96 * 1024));

    assertThat(Throwables.getStackTraceAsString(exception))
        .contains("Header size exceeded max allowed size");
  }

  private static Blob getWithResponseMetadata(int metadataSize) throws Exception {
    char[] value = new char[metadataSize];
    Arrays.fill(value, 'a');
    Metadata headers = new Metadata();
    headers.put(
        Metadata.Key.of("x-test-metadata", Metadata.ASCII_STRING_MARSHALLER), new String(value));
    StorageGrpc.StorageImplBase service =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void getObject(GetObjectRequest request, StreamObserver<Object> responseObserver) {
            responseObserver.onNext(
                Object.newBuilder()
                    .setBucket(request.getBucket())
                    .setName(request.getObject())
                    .setGeneration(1)
                    .build());
            responseObserver.onCompleted();
          }
        };
    Server server =
        NettyServerBuilder.forAddress(new InetSocketAddress("127.0.0.1", 0))
            .addService(service)
            .intercept(MetadataUtils.newAttachMetadataServerInterceptor(headers))
            .build()
            .start();
    try (Storage storage =
        StorageOptions.grpc()
            .setHost("http://127.0.0.1:" + server.getPort())
            .setProjectId("test-project")
            .setCredentials(NoCredentials.getInstance())
            .setAttemptDirectPath(false)
            .setEnableGrpcClientMetrics(false)
            .setRetrySettings(
                RetrySettings.newBuilder()
                    .setMaxAttempts(1)
                    .setTotalTimeoutDuration(Duration.ofSeconds(5))
                    .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
                    .setMaxRpcTimeoutDuration(Duration.ofSeconds(5))
                    .build())
            .build()
            .getService()) {
      return storage.get(BlobId.of("test-bucket", "test-object"));
    } finally {
      server.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
