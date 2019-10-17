/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.FakeStatsRecorder;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.FakeTagger;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.MetricsRecord;
import io.grpc.Status.Code;
import io.opencensus.tags.TagValue;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class MeasuredUnaryCallableTest {
  private static final String FAKE_METHOD = "Bigtable.FakeMethod";

  @Rule public final MockitoRule rule = MockitoJUnit.rule();

  private FakeTagger tagger;

  private FakeStatsRecorder statsRecorder;

  private FakeApiClock clock;

  @Mock private UnaryCallable<String, String> innerCallable;

  private MeasuredUnaryCallable<String, String> callable;

  @Before
  public void setUp() {
    tagger = new FakeTagger();
    statsRecorder = new FakeStatsRecorder();
    clock = new FakeApiClock(0);

    callable =
        new MeasuredUnaryCallable<>(innerCallable, FAKE_METHOD, tagger, statsRecorder, clock);
  }

  @Test
  public void testOk() {
    Mockito.when(innerCallable.futureCall(Mockito.anyString(), Mockito.any(ApiCallContext.class)))
        .thenAnswer(
            new Answer<ApiFuture<String>>() {
              @Override
              public ApiFuture<String> answer(InvocationOnMock invocationOnMock) {
                clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
                return ApiFutures.immediateFuture("response");
              }
            });

    String response = callable.call("request");

    assertThat(response).isEqualTo("response");

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 2.0);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create(FAKE_METHOD));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK"));
  }

  @Test
  public void testFailure() {
    Mockito.when(innerCallable.futureCall(Mockito.anyString(), Mockito.any(ApiCallContext.class)))
        .thenAnswer(
            new Answer<ApiFuture<String>>() {
              @Override
              public ApiFuture<String> answer(InvocationOnMock invocationOnMock) {
                clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
                return ApiFutures.immediateFailedFuture(
                    new DeadlineExceededException(
                        "timeout!", null, GrpcStatusCode.of(Code.DEADLINE_EXCEEDED), true));
              }
            });

    Throwable actualError = null;
    try {
      callable.call("request");
    } catch (Throwable e) {
      actualError = e;
    }

    assertThat(actualError).isInstanceOf(DeadlineExceededException.class);

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 2.0);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create(FAKE_METHOD));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("DEADLINE_EXCEEDED"));
  }
}
