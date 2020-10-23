/*
 * Copyright 2018 Google LLC
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

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.auth.Credentials;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class EnhancedBigtableStubSettingsTest {
  @Test
  public void instanceNameIsRequiredTest() {
    EnhancedBigtableStubSettings.Builder builder = EnhancedBigtableStubSettings.newBuilder();

    Throwable error = null;
    try {
      builder.build();
    } catch (Throwable t) {
      error = t;
    }

    assertThat(error).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void settingsAreNotLostTest() {
    String projectId = "my-project";
    String instanceId = "my-instance";
    String appProfileId = "my-app-profile-id";
    boolean isRefreshingChannel = false;
    String endpoint = "some.other.host:123";
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);
    WatchdogProvider watchdogProvider = Mockito.mock(WatchdogProvider.class);
    Duration watchdogInterval = Duration.ofSeconds(12);

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .setAppProfileId(appProfileId)
            .setRefreshingChannel(isRefreshingChannel)
            .setEndpoint(endpoint)
            .setCredentialsProvider(credentialsProvider)
            .setStreamWatchdogProvider(watchdogProvider)
            .setStreamWatchdogCheckInterval(watchdogInterval);

    verifyBuilder(
        builder,
        projectId,
        instanceId,
        appProfileId,
        isRefreshingChannel,
        endpoint,
        credentialsProvider,
        watchdogProvider,
        watchdogInterval);
    verifySettings(
        builder.build(),
        projectId,
        instanceId,
        appProfileId,
        isRefreshingChannel,
        endpoint,
        credentialsProvider,
        watchdogProvider,
        watchdogInterval);
    verifyBuilder(
        builder.build().toBuilder(),
        projectId,
        instanceId,
        appProfileId,
        isRefreshingChannel,
        endpoint,
        credentialsProvider,
        watchdogProvider,
        watchdogInterval);
  }

  private void verifyBuilder(
      EnhancedBigtableStubSettings.Builder builder,
      String projectId,
      String instanceId,
      String appProfileId,
      boolean isRefreshingChannel,
      String endpoint,
      CredentialsProvider credentialsProvider,
      WatchdogProvider watchdogProvider,
      Duration watchdogInterval) {
    assertThat(builder.getProjectId()).isEqualTo(projectId);
    assertThat(builder.getInstanceId()).isEqualTo(instanceId);
    assertThat(builder.getAppProfileId()).isEqualTo(appProfileId);
    assertThat(builder.isRefreshingChannel()).isEqualTo(isRefreshingChannel);
    assertThat(builder.getEndpoint()).isEqualTo(endpoint);
    assertThat(builder.getCredentialsProvider()).isEqualTo(credentialsProvider);
    assertThat(builder.getStreamWatchdogProvider()).isSameInstanceAs(watchdogProvider);
    assertThat(builder.getStreamWatchdogCheckInterval()).isEqualTo(watchdogInterval);
  }

  private void verifySettings(
      EnhancedBigtableStubSettings settings,
      String projectId,
      String instanceId,
      String appProfileId,
      boolean isRefreshingChannel,
      String endpoint,
      CredentialsProvider credentialsProvider,
      WatchdogProvider watchdogProvider,
      Duration watchdogInterval) {
    assertThat(settings.getProjectId()).isEqualTo(projectId);
    assertThat(settings.getInstanceId()).isEqualTo(instanceId);
    assertThat(settings.getAppProfileId()).isEqualTo(appProfileId);
    assertThat(settings.isRefreshingChannel()).isEqualTo(isRefreshingChannel);
    assertThat(settings.getEndpoint()).isEqualTo(endpoint);
    assertThat(settings.getCredentialsProvider()).isEqualTo(credentialsProvider);
    assertThat(settings.getStreamWatchdogProvider()).isSameInstanceAs(watchdogProvider);
    assertThat(settings.getStreamWatchdogCheckInterval()).isEqualTo(watchdogInterval);
  }

  @Test
  public void multipleChannelsByDefaultTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider();

    assertThat(provider.toBuilder().getPoolSize()).isGreaterThan(1);
  }

  @Test
  public void readRowsIsNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    builder
        .readRowsSettings()
        .setIdleTimeout(Duration.ofMinutes(5))
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .build();

    // Point readRow & bulk read settings must match streaming settings
    builder.readRowSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    builder.bulkReadRowsSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);

    assertThat(builder.readRowsSettings().getIdleTimeout()).isEqualTo(Duration.ofMinutes(5));
    assertThat(builder.readRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.readRowsSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().readRowsSettings().getIdleTimeout())
        .isEqualTo(Duration.ofMinutes(5));
    assertThat(builder.build().readRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().readRowsSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().toBuilder().readRowsSettings().getIdleTimeout())
        .isEqualTo(Duration.ofMinutes(5));
    assertThat(builder.build().toBuilder().readRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().readRowsSettings().getRetrySettings())
        .isEqualTo(retrySettings);
  }

  @Test
  public void readRowsHasSaneDefaultsTest() {
    ServerStreamingCallSettings.Builder<Query, Row> builder =
        EnhancedBigtableStubSettings.newBuilder().readRowsSettings();

    verifyRetrySettingAreSane(builder.getRetryableCodes(), builder.getRetrySettings());
    assertThat(builder.getRetryableCodes())
        .containsExactlyElementsIn(
            ImmutableSet.of(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.ABORTED));
  }

  @Test
  public void readRowIsNotLostTest() {
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance");

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    builder
        .readRowSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .build();

    // Streaming readRows & bulk read settings must match point lookup settings.
    builder.readRowsSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    builder.bulkReadRowsSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);

    assertThat(builder.readRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.readRowSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().readRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().readRowSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().toBuilder().readRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().readRowSettings().getRetrySettings())
        .isEqualTo(retrySettings);
  }

  @Test
  public void readRowHasSaneDefaultsTest() {
    UnaryCallSettings.Builder<Query, Row> builder =
        EnhancedBigtableStubSettings.newBuilder().readRowSettings();

    verifyRetrySettingAreSane(builder.getRetryableCodes(), builder.getRetrySettings());
    assertThat(builder.getRetryableCodes())
        .containsExactlyElementsIn(
            ImmutableSet.of(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE, Code.ABORTED));
  }

  @Test
  public void readRowRetryCodesMustMatch() {
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance");

    builder.readRowsSettings().setRetryableCodes(Code.DEADLINE_EXCEEDED);

    builder.readRowSettings().setRetryableCodes(Code.ABORTED);

    Exception actualError = null;
    try {
      builder.build();
    } catch (Exception e) {
      actualError = e;
    }
    assertThat(actualError).isNotNull();

    builder.readRowSettings().setRetryableCodes(Code.DEADLINE_EXCEEDED);
    builder.bulkReadRowsSettings().setRetryableCodes(Code.DEADLINE_EXCEEDED);

    actualError = null;
    try {
      builder.build();
    } catch (Exception e) {
      actualError = e;
    }
    assertThat(actualError).isNull();
  }

  @Test
  public void sampleRowKeysSettingsAreNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    builder
        .sampleRowKeysSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .build();

    assertThat(builder.sampleRowKeysSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.sampleRowKeysSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().sampleRowKeysSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().sampleRowKeysSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().toBuilder().sampleRowKeysSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().sampleRowKeysSettings().getRetrySettings())
        .isEqualTo(retrySettings);
  }

  @Test
  public void sampleRowKeysHasSaneDefaultsTest() {
    UnaryCallSettings.Builder<String, List<KeyOffset>> builder =
        EnhancedBigtableStubSettings.newBuilder().sampleRowKeysSettings();
    verifyRetrySettingAreSane(builder.getRetryableCodes(), builder.getRetrySettings());
  }

  @Test
  public void mutateRowSettingsAreNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    builder
        .mutateRowSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .build();

    assertThat(builder.mutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.mutateRowSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().mutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().mutateRowSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().toBuilder().mutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().mutateRowSettings().getRetrySettings())
        .isEqualTo(retrySettings);
  }

  @Test
  public void mutateRowHasSaneDefaultsTest() {
    UnaryCallSettings.Builder<RowMutation, Void> builder =
        EnhancedBigtableStubSettings.newBuilder().mutateRowSettings();
    verifyRetrySettingAreSane(builder.getRetryableCodes(), builder.getRetrySettings());
  }

  @Test
  public void bulkMutateRowsSettingsAreNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    BatchingSettings batchingSettings = BatchingSettings.newBuilder().build();

    builder
        .bulkMutateRowsSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .setBatchingSettings(batchingSettings)
        .build();

    assertThat(builder.bulkMutateRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.bulkMutateRowsSettings().getRetrySettings()).isEqualTo(retrySettings);
    assertThat(builder.bulkMutateRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);

    assertThat(builder.build().bulkMutateRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().bulkMutateRowsSettings().getRetrySettings())
        .isEqualTo(retrySettings);
    assertThat(builder.build().bulkMutateRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);

    assertThat(builder.build().toBuilder().bulkMutateRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().bulkMutateRowsSettings().getRetrySettings())
        .isEqualTo(retrySettings);
    assertThat(builder.build().toBuilder().bulkMutateRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);
  }

  @Test
  public void bulkReadRowsSettingsAreNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setMaxAttempts(10)
            .setTotalTimeout(Duration.ofHours(1))
            .setInitialRpcTimeout(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(1)
            .setMaxRpcTimeout(Duration.ofSeconds(10))
            .setJittered(true)
            .build();

    BatchingSettings batchingSettings = BatchingSettings.newBuilder().build();

    builder
        .bulkReadRowsSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .setBatchingSettings(batchingSettings)
        .build();

    // Point read & streaming readRows settings must match point lookup settings.
    builder.readRowSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    builder.readRowsSettings().setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED);

    assertThat(builder.bulkReadRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.bulkReadRowsSettings().getRetrySettings()).isEqualTo(retrySettings);
    assertThat(builder.bulkReadRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);

    assertThat(builder.build().bulkReadRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().bulkReadRowsSettings().getRetrySettings()).isEqualTo(retrySettings);
    assertThat(builder.build().bulkReadRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);

    assertThat(builder.build().toBuilder().bulkReadRowsSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().bulkReadRowsSettings().getRetrySettings())
        .isEqualTo(retrySettings);
    assertThat(builder.build().toBuilder().bulkReadRowsSettings().getBatchingSettings())
        .isSameInstanceAs(batchingSettings);
  }

  @Test
  public void mutateRowsHasSaneDefaultsTest() {
    BigtableBatchingCallSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder().bulkMutateRowsSettings();

    verifyRetrySettingAreSane(builder.getRetryableCodes(), builder.getRetrySettings());

    assertThat(builder.getBatchingSettings().getDelayThreshold())
        .isIn(Range.open(Duration.ZERO, Duration.ofMinutes(1)));
    assertThat(builder.getBatchingSettings().getElementCountThreshold())
        .isIn(Range.open(0L, 1_000L));
    assertThat(builder.getBatchingSettings().getIsEnabled()).isTrue();
    assertThat(builder.getBatchingSettings().getRequestByteThreshold())
        .isLessThan(256L * 1024 * 1024);
    assertThat(
            builder.getBatchingSettings().getFlowControlSettings().getMaxOutstandingElementCount())
        .isAtMost(20_000L);
    assertThat(
            builder.getBatchingSettings().getFlowControlSettings().getMaxOutstandingRequestBytes())
        .isLessThan(512L * 1024 * 1024);
  }

  @Test
  public void checkAndMutateRowSettingsAreNotLostTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";

    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);

    RetrySettings retrySettings = RetrySettings.newBuilder().build();
    builder
        .checkAndMutateRowSettings()
        .setRetryableCodes(Code.ABORTED, Code.DEADLINE_EXCEEDED)
        .setRetrySettings(retrySettings)
        .build();

    assertThat(builder.checkAndMutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.checkAndMutateRowSettings().getRetrySettings()).isEqualTo(retrySettings);

    assertThat(builder.build().checkAndMutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().checkAndMutateRowSettings().getRetrySettings())
        .isEqualTo(retrySettings);

    assertThat(builder.build().toBuilder().checkAndMutateRowSettings().getRetryableCodes())
        .containsAtLeast(Code.ABORTED, Code.DEADLINE_EXCEEDED);
    assertThat(builder.build().toBuilder().checkAndMutateRowSettings().getRetrySettings())
        .isEqualTo(retrySettings);
  }

  @Test
  public void checkAndMutateRowSettingsAreSane() {
    UnaryCallSettings.Builder<ConditionalRowMutation, Boolean> builder =
        EnhancedBigtableStubSettings.newBuilder().checkAndMutateRowSettings();

    // CheckAndMutateRow is not retryable in the case of toggle mutations. So it's disabled by
    // default.
    assertThat(builder.getRetrySettings().getMaxAttempts()).isAtMost(1);
    assertThat(builder.getRetryableCodes()).isEmpty();
  }

  private void verifyRetrySettingAreSane(Set<Code> retryCodes, RetrySettings retrySettings) {
    assertThat(retryCodes).containsAtLeast(Code.DEADLINE_EXCEEDED, Code.UNAVAILABLE);

    assertThat(retrySettings.getTotalTimeout()).isGreaterThan(Duration.ZERO);

    assertThat(retrySettings.getInitialRetryDelay()).isGreaterThan(Duration.ZERO);
    assertThat(retrySettings.getRetryDelayMultiplier()).isAtLeast(1.0);
    assertThat(retrySettings.getMaxRetryDelay()).isGreaterThan(Duration.ZERO);

    assertThat(retrySettings.getInitialRpcTimeout()).isGreaterThan(Duration.ZERO);
    assertThat(retrySettings.getRpcTimeoutMultiplier()).isAtLeast(1.0);
    assertThat(retrySettings.getMaxRpcTimeout()).isGreaterThan(Duration.ZERO);
  }

  @Test
  public void isRefreshingChannelDefaultValueTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId);
    assertThat(builder.isRefreshingChannel()).isFalse();
    assertThat(builder.build().isRefreshingChannel()).isFalse();
    assertThat(builder.build().toBuilder().isRefreshingChannel()).isFalse();
  }

  @Test
  public void isRefreshingChannelFalseValueTest() {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId)
            .setRefreshingChannel(false);
    assertThat(builder.isRefreshingChannel()).isFalse();
    assertThat(builder.build().isRefreshingChannel()).isFalse();
    assertThat(builder.build().toBuilder().isRefreshingChannel()).isFalse();
  }

  static final String[] SETTINGS_LIST = {
    "projectId",
    "instanceId",
    "appProfileId",
    "isRefreshingChannel",
    "primedTableIds",
    "readRowsSettings",
    "readRowSettings",
    "sampleRowKeysSettings",
    "mutateRowSettings",
    "bulkMutateRowsSettings",
    "bulkReadRowsSettings",
    "checkAndMutateRowSettings",
    "readModifyWriteRowSettings",
  };

  @Test
  public void testToString() {
    EnhancedBigtableStubSettings defaultSettings =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId("our-project-85")
            .setInstanceId("our-instance-06")
            .setAppProfileId("our-appProfile-06")
            .build();

    checkToString(defaultSettings);
    assertThat(defaultSettings.toString()).contains("primedTableIds=[]");

    EnhancedBigtableStubSettings settings =
        defaultSettings
            .toBuilder()
            .setPrimedTableIds("2", "12", "85", "06")
            .setEndpoint("example.com:1234")
            .build();

    checkToString(settings);
    assertThat(settings.toString()).contains("endpoint=example.com:1234");
    assertThat(settings.toString()).contains("primedTableIds=[2, 12, 85, 06]");

    int nonStaticFields = 0;
    for (Field field : EnhancedBigtableStubSettings.class.getDeclaredFields()) {
      if (!Modifier.isStatic(field.getModifiers())) {
        nonStaticFields++;
      }
    }
    // failure will signal about adding a new settings property
    assertThat(SETTINGS_LIST.length).isEqualTo(nonStaticFields);
  }

  void checkToString(EnhancedBigtableStubSettings settings) {
    String projectId = settings.getProjectId();
    String instanceId = settings.getInstanceId();
    String appProfileId = settings.getAppProfileId();
    String isRefreshingChannel = "" + settings.isRefreshingChannel();
    String toString = settings.toString();
    assertThat(toString).isEqualTo(settings.toString()); // no variety
    assertThat(toString)
        .startsWith(
            "EnhancedBigtableStubSettings{projectId="
                + projectId
                + ", instanceId="
                + instanceId
                + ", appProfileId="
                + appProfileId
                + ", isRefreshingChannel="
                + isRefreshingChannel);
    for (String subSettings : SETTINGS_LIST) {
      assertThat(toString).contains(subSettings + "=");
    }
  }

  @Test
  public void refreshingChannelSetFixedCredentialProvider() throws Exception {
    String dummyProjectId = "my-project";
    String dummyInstanceId = "my-instance";
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);
    FakeCredentials expectedCredentials = new FakeCredentials();
    Mockito.when(credentialsProvider.getCredentials())
        .thenReturn(expectedCredentials, new FakeCredentials(), new FakeCredentials());
    EnhancedBigtableStubSettings.Builder builder =
        EnhancedBigtableStubSettings.newBuilder()
            .setProjectId(dummyProjectId)
            .setInstanceId(dummyInstanceId)
            .setRefreshingChannel(true)
            .setCredentialsProvider(credentialsProvider);
    assertThat(builder.isRefreshingChannel()).isTrue();
    // Verify that isRefreshing setting is not lost and stubSettings will always return the same
    // credential
    EnhancedBigtableStubSettings stubSettings = builder.build();
    assertThat(stubSettings.isRefreshingChannel()).isTrue();
    assertThat(stubSettings.getCredentialsProvider()).isInstanceOf(FixedCredentialsProvider.class);
    assertThat(stubSettings.getCredentialsProvider().getCredentials())
        .isEqualTo(expectedCredentials);
    assertThat(stubSettings.toBuilder().isRefreshingChannel()).isTrue();
    assertThat(stubSettings.toBuilder().getCredentialsProvider().getCredentials())
        .isEqualTo(expectedCredentials);
  }

  private static class FakeCredentials extends Credentials {
    @Override
    public String getAuthenticationType() {
      return "fake";
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
      return ImmutableMap.of("my-header", Arrays.asList("fake-credential"));
    }

    @Override
    public boolean hasRequestMetadata() {
      return true;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return true;
    }

    @Override
    public void refresh() throws IOException {}
  }
}
