/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storage.TestUtils.apiException;
import static com.google.cloud.storage.TestUtils.getChecksummedData;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ContentRange;
import com.google.storage.v2.Object;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import com.google.storage.v2.StorageClient;
import com.google.storage.v2.StorageGrpc;
import com.google.storage.v2.StorageSettings;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * ReadObject leverages gRPC ServerStream to read a stream of ReadObjectResponse messages spanning
 * the size of the object. If a large object is downloaded and it would take longer than the
 * totalTimeout from {@link StorageOptions#getRetrySettings()}{@link RetrySettings#getTotalTimeout()
 * #getTotalTimeout()}, gax will interrupt the stream with a DEADLINE_EXCEEDED error.
 *
 * <p>Instead of relying on total stream timeout, we rely on idleTimeout for the stream via {@link
 * com.google.api.gax.rpc.ServerStreamingCallSettings.Builder#setIdleTimeoutDuration(Duration)}.
 *
 * <p>These tests force specific timeout scenarios to happen against an in-process grpc server to
 * ensure our configuration of the StorageClient properly translates to the behavior we want.
 *
 * <p><i>NOTE:</i>Unfortunately, these tests are slow as they are waiting on wall clock time in
 * several circumstances.
 */
public final class ITGapicReadTimeoutTest {

  private final String objectName = "name";
  private final Object expectedResult =
      Object.newBuilder()
          .setName(objectName)
          .setGeneration(3L)
          .setContentType("application/octet-stream")
          .build();

  @Test
  public void readObjectStreamTimeoutIsLongerThanDefaultTotalTimeout()
      throws IOException, InterruptedException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(40);
    ByteString data1 = ByteString.copyFrom(bytes, 0, 20);
    ByteString data2 = ByteString.copyFrom(bytes, 20, 20);

    ReadObjectRequest req1 =
        ReadObjectRequest.newBuilder().setObject(objectName).setReadOffset(0).build();
    ReadObjectResponse resp1 =
        ReadObjectResponse.newBuilder()
            .setMetadata(expectedResult)
            .setContentRange(ContentRange.newBuilder().setStart(0).build())
            .setChecksummedData(getChecksummedData(data1))
            .build();
    ReadObjectResponse resp2 =
        ReadObjectResponse.newBuilder()
            .setContentRange(ContentRange.newBuilder().setStart(20).build())
            .setChecksummedData(getChecksummedData(data2))
            .build();

    int totalTimeoutMillis = 10_000;
    int sleepDurationMillis = totalTimeoutMillis + 5_000;
    StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> out) {
            if (request.equals(req1)) {
              out.onNext(resp1);
              out.onNext(resp2);
              try {
                Thread.sleep(sleepDurationMillis);
              } catch (InterruptedException e) {
                out.onError(e);
              }
              out.onCompleted();
            } else {
              out.onError(apiException(Code.PERMISSION_DENIED));
            }
          }
        };

    try (FakeServer server = FakeServer.of(fakeStorage)) {
      StorageSettings settings =
          server.getGrpcStorageOptions().toBuilder()
              .setRetrySettings(
                  RetrySettings.newBuilder()
                      .setMaxAttempts(3)
                      .setTotalTimeoutDuration(Duration.ofMillis(totalTimeoutMillis))
                      .build())
              .build()
              .getStorageSettings();
      try (StorageClient sc = StorageClient.create(settings)) {
        ServerStream<ReadObjectResponse> ss = sc.readObjectCallable().call(req1);
        Iterator<ReadObjectResponse> iter = ss.iterator();

        Stopwatch started = Stopwatch.createStarted();
        ReadObjectResponse actualResponse1 = iter.next();
        ReadObjectResponse actualResponse2 = iter.next();
        boolean hasNext = iter.hasNext();
        Stopwatch stop = started.stop();
        // reduce our expectation by 1% to allow for the fact that sleep can sometimes be slightly
        // less than the stated amount.
        long minimumElapsedTime = sleepDurationMillis - (long) (sleepDurationMillis * 0.01);
        assertThat(stop.elapsed(TimeUnit.MILLISECONDS)).isAtLeast(minimumElapsedTime);
        assertThat(actualResponse1).isEqualTo(resp1);
        assertThat(actualResponse2).isEqualTo(resp2);
        assertThat(hasNext).isFalse();
      }
    }
  }

  @Test
  public void ifTheStreamIsIdleItWillBeCanceled() throws IOException, InterruptedException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(40);
    ReadObjectRequest req1 =
        ReadObjectRequest.newBuilder().setObject(objectName).setReadOffset(0).build();
    ReadObjectResponse resp1 =
        ReadObjectResponse.newBuilder()
            .setMetadata(expectedResult)
            .setContentRange(ContentRange.newBuilder().setStart(0).build())
            .setChecksummedData(getChecksummedData(ByteString.copyFrom(bytes, 0, 10)))
            .build();

    ReadObjectResponse resp2 =
        ReadObjectResponse.newBuilder()
            .setContentRange(ContentRange.newBuilder().setStart(10).build())
            .setChecksummedData(getChecksummedData(ByteString.copyFrom(bytes, 10, 10)))
            .build();
    ReadObjectResponse resp3 =
        ReadObjectResponse.newBuilder()
            .setContentRange(ContentRange.newBuilder().setStart(20).build())
            .setChecksummedData(getChecksummedData(ByteString.copyFrom(bytes, 20, 10)))
            .build();
    ReadObjectResponse resp4 =
        ReadObjectResponse.newBuilder()
            .setContentRange(ContentRange.newBuilder().setStart(30).build())
            .setChecksummedData(getChecksummedData(ByteString.copyFrom(bytes, 30, 10)))
            .build();

    int totalTimeoutMillis = 10_000;
    int sleepDurationMillis = totalTimeoutMillis + 5_000;
    StorageGrpc.StorageImplBase fakeStorage =
        new StorageGrpc.StorageImplBase() {
          @Override
          public void readObject(
              ReadObjectRequest request, StreamObserver<ReadObjectResponse> out) {
            if (request.equals(req1)) {
              out.onNext(resp1);
              out.onNext(resp2);
              out.onNext(resp3);
              out.onNext(resp4);
              out.onCompleted();
            } else {
              out.onError(apiException(Code.PERMISSION_DENIED));
            }
          }
        };

    try (FakeServer server = FakeServer.of(fakeStorage)) {
      StorageSettings settings =
          server.getGrpcStorageOptions().toBuilder()
              .setRetrySettings(
                  RetrySettings.newBuilder()
                      .setMaxAttempts(3)
                      .setTotalTimeoutDuration(Duration.ofMillis(totalTimeoutMillis))
                      .build())
              .build()
              .getStorageSettings();
      try (StorageClient sc = StorageClient.create(settings)) {
        ServerStream<ReadObjectResponse> ss = sc.readObjectCallable().call(req1);
        Iterator<ReadObjectResponse> iter = ss.iterator();

        Stopwatch started = Stopwatch.createStarted();
        assertThrows(
            WatchdogTimeoutException.class,
            () -> {
              iter.next();
              Thread.sleep(20_000);
              iter.next();
              iter.next();
              iter.next();
            });
        Stopwatch stop = started.stop();
        assertThat(stop.elapsed(TimeUnit.MILLISECONDS)).isAtLeast(sleepDurationMillis);
      }
    }
  }
}
