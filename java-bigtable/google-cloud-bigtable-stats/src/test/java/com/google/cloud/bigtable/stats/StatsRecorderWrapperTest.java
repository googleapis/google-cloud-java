/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.stats;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.common.collect.ImmutableMap;
import io.opencensus.impl.stats.StatsComponentImpl;
import io.opencensus.stats.AggregationData;
import io.opencensus.stats.StatsComponent;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewData;
import io.opencensus.stats.ViewManager;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class StatsRecorderWrapperTest {

  private final String PROJECT_ID = "fake-project";
  private final String INSTANCE_ID = "fake-instance";
  private final String APP_PROFILE_ID = "fake-app-profile";

  private final String TABLE_ID = "fake-table-id";
  private final String ZONE = "fake-zone";
  private final String CLUSTER = "fake-cluster";

  private final StatsComponent statsComponent = new StatsComponentImpl();

  @Before
  public void setup() {
    BuiltinViews views = new BuiltinViews();
    views.registerPrivateViews(statsComponent.getViewManager());
  }

  @Test
  public void testStreamingOperation() throws InterruptedException {
    StatsRecorderWrapper recorderWrapper =
        new StatsRecorderWrapper(
            ApiTracerFactory.OperationType.ServerStreaming,
            SpanName.of("Bigtable", "ReadRows"),
            ImmutableMap.of(
                BuiltinMeasureConstants.PROJECT_ID.getName(),
                PROJECT_ID,
                BuiltinMeasureConstants.INSTANCE_ID.getName(),
                INSTANCE_ID,
                BuiltinMeasureConstants.APP_PROFILE.getName(),
                APP_PROFILE_ID),
            statsComponent.getStatsRecorder());

    long operationLatency = 1234;
    int attemptCount = 2;
    long attemptLatency = 56;
    long serverLatency = 78;
    long applicationLatency = 901;
    long connectivityErrorCount = 15;
    long throttlingLatency = 50;
    long firstResponseLatency = 90;

    recorderWrapper.putOperationLatencies(operationLatency);
    recorderWrapper.putRetryCount(attemptCount);
    recorderWrapper.putAttemptLatencies(attemptLatency);
    recorderWrapper.putApplicationLatencies(applicationLatency);
    recorderWrapper.putGfeLatencies(serverLatency);
    recorderWrapper.putGfeMissingHeaders(connectivityErrorCount);
    recorderWrapper.putFirstResponseLatencies(firstResponseLatency);
    recorderWrapper.putBatchRequestThrottled(throttlingLatency);

    recorderWrapper.record("OK", TABLE_ID, ZONE, CLUSTER);

    Thread.sleep(100);

    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.OPERATION_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD, "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS, "OK",
                    BuiltinMeasureConstants.TABLE, TABLE_ID,
                    BuiltinMeasureConstants.ZONE, ZONE,
                    BuiltinMeasureConstants.CLUSTER, CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME, "bigtable-java",
                    BuiltinMeasureConstants.STREAMING, "true"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(operationLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.ATTEMPT_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "true"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(attemptLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.RETRY_COUNT_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(attemptCount);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.SERVER_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "true",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(serverLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.APPLICATION_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "true"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(applicationLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.CONNECTIVITY_ERROR_COUNT_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(connectivityErrorCount);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.THROTTLING_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD, "Bigtable.ReadRows",
                    BuiltinMeasureConstants.TABLE, TABLE_ID,
                    BuiltinMeasureConstants.ZONE, ZONE,
                    BuiltinMeasureConstants.CLUSTER, CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME, "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(throttlingLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.FIRST_RESPONSE_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.ReadRows",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.STATUS,
                    "OK",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(firstResponseLatency);
  }

  @Test
  public void testUnaryOperations() throws InterruptedException {
    StatsRecorderWrapper recorderWrapper =
        new StatsRecorderWrapper(
            ApiTracerFactory.OperationType.Unary,
            SpanName.of("Bigtable", "MutateRow"),
            ImmutableMap.of(
                BuiltinMeasureConstants.PROJECT_ID.getName(), PROJECT_ID,
                BuiltinMeasureConstants.INSTANCE_ID.getName(), INSTANCE_ID,
                BuiltinMeasureConstants.APP_PROFILE.getName(), APP_PROFILE_ID),
            statsComponent.getStatsRecorder());

    long operationLatency = 1234;
    int attemptCount = 2;
    long attemptLatency = 56;
    long serverLatency = 78;
    long applicationLatency = 901;
    long connectivityErrorCount = 15;
    long throttlingLatency = 50;
    long firstResponseLatency = 90;

    recorderWrapper.putOperationLatencies(operationLatency);
    recorderWrapper.putRetryCount(attemptCount);
    recorderWrapper.putAttemptLatencies(attemptLatency);
    recorderWrapper.putApplicationLatencies(applicationLatency);
    recorderWrapper.putGfeLatencies(serverLatency);
    recorderWrapper.putGfeMissingHeaders(connectivityErrorCount);
    recorderWrapper.putFirstResponseLatencies(firstResponseLatency);
    recorderWrapper.putBatchRequestThrottled(throttlingLatency);

    recorderWrapper.record("UNAVAILABLE", TABLE_ID, ZONE, CLUSTER);

    Thread.sleep(100);

    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.OPERATION_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "false"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(operationLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.ATTEMPT_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "false"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(attemptLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.RETRY_COUNT_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(attemptCount);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.SERVER_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "false",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(serverLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.APPLICATION_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.STREAMING,
                    "false"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(applicationLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.CONNECTIVITY_ERROR_COUNT_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(connectivityErrorCount);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.THROTTLING_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD, "Bigtable.MutateRow",
                    BuiltinMeasureConstants.TABLE, TABLE_ID,
                    BuiltinMeasureConstants.ZONE, ZONE,
                    BuiltinMeasureConstants.CLUSTER, CLUSTER,
                    BuiltinMeasureConstants.CLIENT_NAME, "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(throttlingLatency);
    assertThat(
            getAggregationValueAsLong(
                BuiltinViewConstants.FIRST_RESPONSE_LATENCIES_VIEW,
                ImmutableMap.of(
                    BuiltinMeasureConstants.METHOD,
                    "Bigtable.MutateRow",
                    BuiltinMeasureConstants.TABLE,
                    TABLE_ID,
                    BuiltinMeasureConstants.ZONE,
                    ZONE,
                    BuiltinMeasureConstants.CLUSTER,
                    CLUSTER,
                    BuiltinMeasureConstants.STATUS,
                    "UNAVAILABLE",
                    BuiltinMeasureConstants.CLIENT_NAME,
                    "bigtable-java"),
                PROJECT_ID,
                INSTANCE_ID,
                APP_PROFILE_ID,
                statsComponent.getViewManager()))
        .isEqualTo(firstResponseLatency);
  }

  long getAggregationValueAsLong(
      View view,
      ImmutableMap<TagKey, String> tags,
      String projectId,
      String instanceId,
      String appProfileId,
      ViewManager viewManager) {
    ViewData viewData = viewManager.getView(view.getName());
    Map<List<TagValue>, AggregationData> aggregationMap =
        Objects.requireNonNull(viewData).getAggregationMap();

    List<TagValue> tagValues = new ArrayList<>();

    for (TagKey column : view.getColumns()) {
      if (BuiltinMeasureConstants.PROJECT_ID == column) {
        tagValues.add(TagValue.create(projectId));
      } else if (BuiltinMeasureConstants.INSTANCE_ID == column) {
        tagValues.add(TagValue.create(instanceId));
      } else if (BuiltinMeasureConstants.APP_PROFILE == column) {
        tagValues.add(TagValue.create(appProfileId));
      } else {
        tagValues.add(TagValue.create(tags.get(column)));
      }
    }

    AggregationData aggregationData = aggregationMap.get(tagValues);

    return aggregationData.match(
        arg -> (long) arg.getSum(),
        AggregationData.SumDataLong::getSum,
        arg -> arg.getCount(),
        arg -> (long) arg.getMean(),
        arg -> (long) arg.getLastValue(),
        AggregationData.LastValueDataLong::getLastValue,
        arg -> {
          throw new UnsupportedOperationException();
        });
  }
}
