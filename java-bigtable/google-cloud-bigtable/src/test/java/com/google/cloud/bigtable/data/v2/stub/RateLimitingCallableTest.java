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

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamController;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.RateLimitInfo;
import com.google.cloud.bigtable.gaxx.testing.FakeStatusCode;
import com.google.protobuf.Duration;
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
  public void testWithRateLimitInfo() throws Exception {
    callableToTest.call(request, responseObserver, context);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // make sure QPS will be updated
    callableToTest.getLastQpsChangeTime().set(earlier);
    double oldQps = callableToTest.getCurrentRate();

    double factor = 0.8;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(10).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread sometime to update the QPS
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isWithin(0.1).of(oldQps * factor);

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testNoUpdateWithinPeriod() throws Exception {
    callableToTest.call(request, responseObserver, context);

    Instant now = Instant.now();
    // make sure QPS will not be updated
    callableToTest.getLastQpsChangeTime().set(now);
    double oldQps = callableToTest.getCurrentRate();

    double factor = 0.3;

    RateLimitInfo info =
        RateLimitInfo.newBuilder()
            .setFactor(factor)
            .setPeriod(Duration.newBuilder().setSeconds(600).build())
            .build();

    MutateRowsResponse response = MutateRowsResponse.newBuilder().setRateLimitInfo(info).build();

    innerCallable.getObserver().onResponse(response);

    // Give the thread sometime to update the QPS
    Thread.sleep(100);
    double newQps = callableToTest.getCurrentRate();

    assertThat(newQps).isEqualTo(oldQps);

    innerCallable.getObserver().onComplete();
  }

  @Test
  public void testErrorInfoLowerQPS() throws Exception {
    callableToTest.call(request, responseObserver, context);

    Instant earlier = Instant.now().minus(org.threeten.bp.Duration.ofHours(1));

    // make sure QPS will be updated
    callableToTest.getLastQpsChangeTime().set(earlier);
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
