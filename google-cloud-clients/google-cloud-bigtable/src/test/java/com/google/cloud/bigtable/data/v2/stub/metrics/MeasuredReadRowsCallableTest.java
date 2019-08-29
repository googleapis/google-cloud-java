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

import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.FakeStatsRecorder;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.FakeTagger;
import com.google.cloud.bigtable.data.v2.stub.metrics.StatsTestUtils.MetricsRecord;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import io.grpc.Status.Code;
import io.opencensus.tags.TagValue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class MeasuredReadRowsCallableTest {
  @Rule public final MockitoRule rule = MockitoJUnit.rule();

  private FakeTagger tagger;

  private FakeStatsRecorder statsRecorder;

  private FakeApiClock clock;

  private MockServerStreamingCallable<Query, String> innerCallable;

  private MeasuredReadRowsCallable<String> callable;

  @Before
  public void setUp() {
    innerCallable = new MockServerStreamingCallable<>();

    tagger = new FakeTagger();
    statsRecorder = new FakeStatsRecorder();
    clock = new FakeApiClock(0);

    callable =
        new MeasuredReadRowsCallable<>(
            innerCallable, "Bigtable.ReadRows", tagger, statsRecorder, clock);
  }

  @Test
  public void testOk() {
    new Thread() {
      @Override
      public void run() {
        MockServerStreamingCall<Query, String> lastCall = null;

        for (int i = 0; i < 10 && lastCall == null; i++) {
          lastCall = innerCallable.popLastCall();
        }
        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
        lastCall.getController().popLastPull();
        lastCall.getController().getObserver().onResponse("row0");

        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(3));
        lastCall.getController().popLastPull();
        lastCall.getController().getObserver().onResponse("row1");
        lastCall.getController().getObserver().onComplete();
      }
    }.start();

    List<String> results = callable.all().call(Query.create("fake-table"));

    assertThat(results).containsExactly("row0", "row1");

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 5.0);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY, 2.0);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, 2L);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK"));
  }

  @Test
  public void testEmpty() {
    new Thread() {
      @Override
      public void run() {
        MockServerStreamingCall<Query, String> lastCall = null;

        for (int i = 0; i < 10 && lastCall == null; i++) {
          lastCall = innerCallable.popLastCall();
        }
        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
        lastCall.getController().getObserver().onComplete();
      }
    }.start();

    List<String> results = callable.all().call(Query.create("fake-table"));

    assertThat(results).isEmpty();

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 2.0);
    assertThat(metricsRecord.metrics)
        .doesNotContainKey(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, 0L);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("OK"));
  }

  @Test
  public void testFailure() {
    new Thread() {
      @Override
      public void run() {
        MockServerStreamingCall<Query, String> lastCall = null;

        for (int i = 0; i < 10 && lastCall == null; i++) {
          lastCall = innerCallable.popLastCall();
        }
        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
        lastCall
            .getController()
            .getObserver()
            .onError(
                new DeadlineExceededException(
                    "timeout!", null, GrpcStatusCode.of(Code.DEADLINE_EXCEEDED), true));
      }
    }.start();

    Throwable actualError = null;
    try {
      callable.all().call(Query.create("fake-table"));
    } catch (Throwable e) {
      actualError = e;
    }

    assertThat(actualError).isInstanceOf(DeadlineExceededException.class);

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 2.0);
    assertThat(metricsRecord.metrics)
        .doesNotContainKey(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, 0L);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("DEADLINE_EXCEEDED"));
  }

  @Test
  public void testFailureAfterData() {
    new Thread() {
      @Override
      public void run() {
        MockServerStreamingCall<Query, String> lastCall = null;

        for (int i = 0; i < 10 && lastCall == null; i++) {
          lastCall = innerCallable.popLastCall();
        }
        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(2));
        lastCall.getController().popLastPull();
        lastCall.getController().getObserver().onResponse("row0");

        clock.incrementNanoTime(TimeUnit.MILLISECONDS.toNanos(3));
        lastCall
            .getController()
            .getObserver()
            .onError(
                new DeadlineExceededException(
                    "timeout!", null, GrpcStatusCode.of(Code.DEADLINE_EXCEEDED), true));
      }
    }.start();

    Throwable actualError = null;
    try {
      callable.all().call(Query.create("fake-table"));
    } catch (Throwable e) {
      actualError = e;
    }

    assertThat(actualError).isInstanceOf(DeadlineExceededException.class);

    MetricsRecord metricsRecord = statsRecorder.pollRecord();

    assertThat(metricsRecord.metrics).containsEntry(RpcMeasureConstants.BIGTABLE_OP_LATENCY, 5.0);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_READ_ROWS_FIRST_ROW_LATENCY, 2.0);
    assertThat(metricsRecord.metrics)
        .containsEntry(RpcMeasureConstants.BIGTABLE_ROWS_READ_PER_OP, 1L);
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_OP, TagValue.create("Bigtable.ReadRows"));
    assertThat(metricsRecord.tags)
        .containsEntry(RpcMeasureConstants.BIGTABLE_STATUS, TagValue.create("DEADLINE_EXCEEDED"));
  }
}
