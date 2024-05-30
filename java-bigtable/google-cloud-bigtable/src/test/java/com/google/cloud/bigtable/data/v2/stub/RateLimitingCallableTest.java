/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.RateLimitInfo;
import com.google.cloud.bigtable.gaxx.testing.FakeStatusCode;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.rpc.Code;
import com.google.rpc.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class RateLimitingCallableTest {

  private final MutateRowsRequest request =
      MutateRowsRequest.newBuilder().getDefaultInstanceForType();
  private final ResponseObserver<MutateRowsResponse> responseObserver =
      Mockito.mock(ResponseObserver.class);
  private final ApiCallContext context = GrpcCallContext.createDefault();
  private MockCallable innerCallable;
  RateLimitingServerStreamingCallable callableToTest;

  @Before
  public void setup() throws Exception {
    innerCallable = new MockCallable();
    callableToTest = new RateLimitingServerStreamingCallable(innerCallable);
  }

  @Test
  public void testDefaultSettingOnInitiate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    assertFalse(callableToTest.getLimiterEnabled());
    assertThat(callableToTest.getCurrentRate()).isEqualTo(10);
  }

  @Test
  public void testUpdateRate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // Make sure rate will be updated.
    callableToTest.getNextRateUpdateTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    double factor = 0.8;
    int periodSeconds = 10;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(periodSeconds).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread some time to update the rate.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isWithin(0.01).of(oldQps * factor);

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testNoRateLimitInfoDoesNotUpdateRate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // Make sure rate will be updated.
    callableToTest.getNextRateUpdateTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    // A response without RateLimitInfo.
    MutateRowsResponse response = MutateRowsResponse.newBuilder().build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread some time to update the rate.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change
    assertFalse(callableToTest.getLimiterEnabled()); // Rate limiter is also disabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testInvalidRateLimitInfoDoesNotUpdateRate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // make sure QPS will be updated
    callableToTest.getNextRateUpdateTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    // A response with invalid RateLimitInfo.
    double factor = 0; // Invalid factor
    int periodSeconds = 10;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(periodSeconds).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread sometime to update the QPS
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change
    assertFalse(callableToTest.getLimiterEnabled()); // Rate limiter is also disabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testMissingRateLimitInfoFactorDoesNotUpdateRate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // Make sure rate can be updated.
    callableToTest.getNextRateUpdateTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    // A response with invalid RateLimitInfo.
    // Missing factor is equivalent to 0.
    int periodSeconds = 10;
    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setPeriod(Duration.newBuilder().setSeconds(periodSeconds).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread some time to update the rate.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change
    assertFalse(callableToTest.getLimiterEnabled()); // Rate limiter is also disabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testNoUpdateBeforeAllowedTime() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant later = Instant.now().plus(org.threeten.bp.Duration.ofHours(1));
    // Make sure rate will not be updated.
    callableToTest.getNextRateUpdateTime().set(later);
    double oldQps = callableToTest.getCurrentRate();

    double factor = 0.3;
    int periodSeconds = 10;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(periodSeconds).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread some time to update the rate.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change.
    assertTrue(callableToTest.getLimiterEnabled()); // Still enabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testDoesNotDisableBeforeAllowedTime() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setLimiterEnabled(true);

    Instant later = Instant.now().plus(org.threeten.bp.Duration.ofHours(1));
    // Make sure limiter will not be disabled.
    callableToTest.getNextRateUpdateTime().set(later);
    double oldQps = callableToTest.getCurrentRate();

    // Missing RateLimitInfo disables rate limiting.
    MutateRowsResponse response = MutateRowsResponse.newBuilder().build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread sometime to disable the rate limiter.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change on QPS.
    assertTrue(callableToTest.getLimiterEnabled()); // Still enabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testEnableWithinPeriodDoesNotUpdateRate() throws Exception {
    callableToTest.call(request, responseObserver, context);
    callableToTest.setRate(1.5);

    Instant later = Instant.now().plus(org.threeten.bp.Duration.ofHours(1));
    // Even though the rate update time is far in the future, enable is always allowed.
    callableToTest.getNextRateUpdateTime().set(later);
    double oldQps = callableToTest.getCurrentRate();

    double factor = 0.3;
    int periodSeconds = 600;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(periodSeconds).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread some time to enable the rate limiter.
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps); // No change on QPS due to QPS update time.
    assertTrue(callableToTest.getLimiterEnabled()); // Rate limiting is enabled.

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testErrorInfoLowerQPS() throws Exception {
    callableToTest.call(request, responseObserver, context);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // make sure QPS will be updated
    callableToTest.getNextRateUpdateTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    innerCallable
        .getObserver()
        .onError(
            new DeadlineExceededException(
                new Throwable(), new FakeStatusCode(StatusCode.Code.DEADLINE_EXCEEDED), false));

    // Give the thread sometime to update the QPS
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isWithin(0.1).of(oldQps * RateLimitingServerStreamingCallable.MIN_FACTOR);
  }

  @Test
  public void testResponseIsPropagated() {
    MutateRowsResponse expectedResponse =
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(0)
                    .setStatus(Status.newBuilder().setCode(Code.PERMISSION_DENIED_VALUE)))
            .build();
    innerCallable =
        new MockCallable() {
          @Override
          public void call(
              MutateRowsRequest mutateRowsRequest,
              ResponseObserver<MutateRowsResponse> responseObserver,
              ApiCallContext apiCallContext) {
            responseObserver.onResponse(expectedResponse);
            responseObserver.onComplete();
          }
        };

    callableToTest = new RateLimitingServerStreamingCallable(innerCallable);

    ResponseObserver<MutateRowsResponse> mockObserver = Mockito.mock(ResponseObserver.class);

    MutateRowsRequest req =
        MutateRowsRequest.newBuilder()
            .addEntries(
                MutateRowsRequest.Entry.newBuilder()
                    .setRowKey(ByteString.copyFromUtf8("k1"))
                    .addMutations(
                        Mutation.newBuilder()
                            .setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance())))
            .build();

    callableToTest.call(req, mockObserver, context);

    Mockito.verify(mockObserver, Mockito.times(1)).onResponse(Mockito.eq(expectedResponse));
  }

  private static class MockResponseObserver implements ResponseObserver<MutateRowsResponse> {

    private ResponseObserver<MutateRowsResponse> observer;

    MockResponseObserver(ResponseObserver<MutateRowsResponse> responseObserver) {
      this.observer = responseObserver;
    }

    @Override
    public void onStart(StreamController streamController) {
      observer.onStart(streamController);
    }

    @Override
    public void onResponse(MutateRowsResponse o) {
      observer.onResponse(o);
    }

    @Override
    public void onError(Throwable throwable) {
      observer.onError(throwable);
    }

    @Override
    public void onComplete() {
      observer.onComplete();
    }
  }

  private static class MockCallable
      extends ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> {

    private ResponseObserver<MutateRowsResponse> observer;

    @Override
    public void call(
        MutateRowsRequest mutateRowsRequest,
        ResponseObserver<MutateRowsResponse> responseObserver,
        ApiCallContext apiCallContext) {
      observer = new MockResponseObserver(responseObserver);
    }

    ResponseObserver<MutateRowsResponse> getObserver() {
      return observer;
    }
  }
}
