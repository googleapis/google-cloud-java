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

package com.google.cloud.grpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpResiliencyOptions;
import com.google.common.util.concurrent.Futures;
import io.grpc.ManagedChannel;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricRegistry;
import io.opencensus.metrics.Metrics;
import java.time.Duration;
import java.util.Collections;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for GcpManagedChannelOptionsTest. */
@RunWith(JUnit4.class)
public final class GcpManagedChannelOptionsTest {
  private static final String namePrefix = "name-prefix";
  private static final String labelName = "label_name";
  private static final String labelDescription = "Label description";
  private static final String labelValue = "label-value";
  private static final MetricRegistry metricRegistry = Metrics.getMetricRegistry();
  private static final int unresponsiveMs = 100;
  private static final int unresponsiveDroppedCount = 3;

  @Rule public ExpectedException exceptionRule = ExpectedException.none();

  private GcpManagedChannelOptions buildOptions() {
    return GcpManagedChannelOptions.newBuilder()
        .withMetricsOptions(
            GcpMetricsOptions.newBuilder()
                .withNamePrefix(namePrefix)
                .withLabels(
                    Collections.singletonList(LabelKey.create(labelName, labelDescription)),
                    Collections.singletonList(LabelValue.create(labelValue)))
                .withMetricRegistry(metricRegistry)
                .build())
        .withResiliencyOptions(
            GcpResiliencyOptions.newBuilder()
                .setNotReadyFallback(true)
                .withUnresponsiveConnectionDetection(unresponsiveMs, unresponsiveDroppedCount)
                .build())
        .build();
  }

  @Test
  public void testOptionsBuilders() {
    final GcpManagedChannelOptions opts = buildOptions();

    assertNotNull(opts.getMetricsOptions());
    assertNotNull(opts.getResiliencyOptions());
    GcpMetricsOptions metricsOpts = opts.getMetricsOptions();
    GcpResiliencyOptions resOpts = opts.getResiliencyOptions();
    assertEquals(metricRegistry, metricsOpts.getMetricRegistry());
    assertEquals(namePrefix, metricsOpts.getNamePrefix());
    assertEquals(1, metricsOpts.getLabelKeys().size());
    assertEquals(1, metricsOpts.getLabelValues().size());
    assertEquals(labelName, metricsOpts.getLabelKeys().get(0).getKey());
    assertEquals(labelDescription, metricsOpts.getLabelKeys().get(0).getDescription());
    assertEquals(labelValue, metricsOpts.getLabelValues().get(0).getValue());
    assertTrue(resOpts.isNotReadyFallbackEnabled());
    assertTrue(resOpts.isUnresponsiveDetectionEnabled());
    assertEquals(unresponsiveMs, resOpts.getUnresponsiveDetectionMs());
    assertEquals(unresponsiveDroppedCount, resOpts.getUnresponsiveDetectionDroppedCount());
  }

  @Test
  public void testUnresponsiveDetectionMsPreconditions() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("ms should be > 0, got 0");

    GcpManagedChannelOptions opts =
        GcpManagedChannelOptions.newBuilder()
            .withResiliencyOptions(
                GcpResiliencyOptions.newBuilder().withUnresponsiveConnectionDetection(0, 0).build())
            .build();
  }

  @Test
  public void testUnresponsiveDetectionDroppedCountPreconditions() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("numDroppedRequests should be > 0, got -1");

    GcpManagedChannelOptions opts =
        GcpManagedChannelOptions.newBuilder()
            .withResiliencyOptions(
                GcpResiliencyOptions.newBuilder()
                    .withUnresponsiveConnectionDetection(100, -1)
                    .build())
            .build();
  }

  @Test
  public void testOptionsReBuild() {
    final GcpManagedChannelOptions opts = buildOptions();

    final String updatedLabelValue = "updated-label-value";

    GcpManagedChannelOptions updatedOptions =
        GcpManagedChannelOptions.newBuilder(opts)
            .withMetricsOptions(
                GcpMetricsOptions.newBuilder(opts.getMetricsOptions())
                    .withLabels(
                        Collections.singletonList(LabelKey.create(labelName, labelDescription)),
                        Collections.singletonList(LabelValue.create(updatedLabelValue)))
                    .build())
            .build();

    assertNotNull(updatedOptions.getMetricsOptions());
    assertNotNull(updatedOptions.getResiliencyOptions());
    GcpMetricsOptions metricsOpts = updatedOptions.getMetricsOptions();
    GcpResiliencyOptions resOpts = updatedOptions.getResiliencyOptions();
    assertEquals(metricRegistry, metricsOpts.getMetricRegistry());
    assertEquals(namePrefix, metricsOpts.getNamePrefix());
    assertEquals(1, metricsOpts.getLabelKeys().size());
    assertEquals(1, metricsOpts.getLabelValues().size());
    assertEquals(labelName, metricsOpts.getLabelKeys().get(0).getKey());
    assertEquals(labelDescription, metricsOpts.getLabelKeys().get(0).getDescription());
    assertEquals(updatedLabelValue, metricsOpts.getLabelValues().get(0).getValue());
    assertTrue(resOpts.isNotReadyFallbackEnabled());
    assertTrue(resOpts.isUnresponsiveDetectionEnabled());
    assertEquals(unresponsiveMs, resOpts.getUnresponsiveDetectionMs());
    assertEquals(unresponsiveDroppedCount, resOpts.getUnresponsiveDetectionDroppedCount());

    updatedOptions =
        GcpManagedChannelOptions.newBuilder(opts)
            .withResiliencyOptions(
                GcpResiliencyOptions.newBuilder(opts.getResiliencyOptions())
                    .setNotReadyFallback(false)
                    .build())
            .build();

    assertNotNull(updatedOptions.getMetricsOptions());
    assertNotNull(updatedOptions.getResiliencyOptions());
    metricsOpts = updatedOptions.getMetricsOptions();
    resOpts = updatedOptions.getResiliencyOptions();
    assertEquals(metricRegistry, metricsOpts.getMetricRegistry());
    assertEquals(namePrefix, metricsOpts.getNamePrefix());
    assertEquals(1, metricsOpts.getLabelKeys().size());
    assertEquals(1, metricsOpts.getLabelValues().size());
    assertEquals(labelName, metricsOpts.getLabelKeys().get(0).getKey());
    assertEquals(labelDescription, metricsOpts.getLabelKeys().get(0).getDescription());
    assertEquals(labelValue, metricsOpts.getLabelValues().get(0).getValue());
    assertFalse(resOpts.isNotReadyFallbackEnabled());
    assertTrue(resOpts.isUnresponsiveDetectionEnabled());
    assertEquals(unresponsiveMs, resOpts.getUnresponsiveDetectionMs());
    assertEquals(unresponsiveDroppedCount, resOpts.getUnresponsiveDetectionDroppedCount());
  }

  @Test
  public void testPoolOptions() {
    final GcpManagedChannelOptions opts =
        GcpManagedChannelOptions.newBuilder()
            .withChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setMaxSize(5)
                    .setMinSize(2)
                    .setConcurrentStreamsLowWatermark(10)
                    .setUseRoundRobinOnBind(true)
                    .setAffinityKeyLifetime(Duration.ofSeconds(3600))
                    .setCleanupInterval(Duration.ofSeconds(30))
                    .build())
            .build();

    GcpChannelPoolOptions channelPoolOptions = opts.getChannelPoolOptions();
    assertThat(channelPoolOptions).isNotNull();
    assertThat(channelPoolOptions.getMaxSize()).isEqualTo(5);
    assertThat(channelPoolOptions.getMinSize()).isEqualTo(2);
    assertThat(channelPoolOptions.getConcurrentStreamsLowWatermark()).isEqualTo(10);
    assertThat(channelPoolOptions.isUseRoundRobinOnBind()).isTrue();
    assertThat(channelPoolOptions.getAffinityKeyLifetime()).isEqualTo(Duration.ofSeconds(3600));
    assertThat(channelPoolOptions.getCleanupInterval()).isEqualTo(Duration.ofSeconds(30));
  }

  @Test
  public void testAffinityKeysCleanupZeroByDefault() {
    final GcpManagedChannelOptions opts =
        GcpManagedChannelOptions.newBuilder()
            .withChannelPoolOptions(GcpChannelPoolOptions.newBuilder().build())
            .build();
    final GcpChannelPoolOptions channelPoolOptions = opts.getChannelPoolOptions();
    assertThat(channelPoolOptions.getAffinityKeyLifetime()).isEqualTo(Duration.ZERO);
    assertThat(channelPoolOptions.getCleanupInterval()).isEqualTo(Duration.ZERO);
  }

  @Test
  public void testDynamicScalingKnobsHaveGoDefaultsAndSurviveCopy() {
    GcpChannelPoolOptions defaults = GcpChannelPoolOptions.newBuilder().build();

    assertThat(defaults.getScaleUpCooldown()).isEqualTo(Duration.ofSeconds(10));
    assertThat(defaults.getScaleDownConsecutiveLowLoadChecks()).isEqualTo(3);
    assertThat(defaults.getMaxScaleUpPercent()).isEqualTo(30);
    assertThat(defaults.getMaxScaleDownChannels()).isEqualTo(2);
    assertThat(defaults.getDrainIdleGrace()).isEqualTo(Duration.ofMinutes(1));
    assertThat(defaults.getErrorPenaltyStep()).isEqualTo(5);
    assertThat(defaults.getErrorPenaltyDuration()).isEqualTo(Duration.ofSeconds(5));
    assertThat(defaults.getChannelPrimer()).isNull();
    assertThat(defaults.getChannelPrimeTimeout()).isEqualTo(Duration.ofSeconds(10));
    assertThat(defaults.getChannelPrimeMaxAttempts()).isEqualTo(3);

    GcpChannelPoolOptions zeroValues =
        GcpChannelPoolOptions.newBuilder()
            .setScaleUpCooldown(Duration.ZERO)
            .setErrorPenaltyStep(0)
            .setChannelPrimeTimeout(Duration.ZERO)
            .setChannelPrimeMaxAttempts(0)
            .build();
    assertThat(zeroValues.getScaleUpCooldown()).isEqualTo(Duration.ofSeconds(10));
    assertThat(zeroValues.getErrorPenaltyStep()).isEqualTo(5);
    assertThat(zeroValues.getChannelPrimeTimeout()).isEqualTo(Duration.ofSeconds(10));
    assertThat(zeroValues.getChannelPrimeMaxAttempts()).isEqualTo(3);
    GcpChannelPoolOptions copiedZeroValues = GcpChannelPoolOptions.newBuilder(zeroValues).build();
    assertThat(copiedZeroValues.getScaleUpCooldown()).isEqualTo(Duration.ofSeconds(10));
    assertThat(copiedZeroValues.getErrorPenaltyStep()).isEqualTo(5);
    assertThat(copiedZeroValues.getChannelPrimeTimeout()).isEqualTo(Duration.ofSeconds(10));
    assertThat(copiedZeroValues.getChannelPrimeMaxAttempts()).isEqualTo(3);
    assertThat(copiedZeroValues.toString()).contains("scaleUpCooldown: PT10S");
    assertThat(copiedZeroValues.toString()).contains("errorPenaltyStep: 5");
    assertThat(copiedZeroValues.toString()).contains("channelPrimeTimeout: PT10S");
    assertThat(copiedZeroValues.toString()).contains("channelPrimeMaxAttempts: 3");

    GcpChannelPoolOptions configured =
        GcpChannelPoolOptions.newBuilder(defaults)
            .setScaleUpCooldown(Duration.ofSeconds(1))
            .setScaleDownConsecutiveLowLoadChecks(4)
            .setMaxScaleUpPercent(40)
            .setMaxScaleDownChannels(3)
            .setDrainIdleGrace(Duration.ofSeconds(2))
            .setErrorPenaltyStep(2)
            .setErrorPenaltyDuration(Duration.ofSeconds(3))
            .build();
    GcpChannelPoolOptions copied = GcpChannelPoolOptions.newBuilder(configured).build();

    assertThat(copied.getScaleUpCooldown()).isEqualTo(Duration.ofSeconds(1));
    assertThat(copied.getScaleDownConsecutiveLowLoadChecks()).isEqualTo(4);
    assertThat(copied.getMaxScaleUpPercent()).isEqualTo(40);
    assertThat(copied.getMaxScaleDownChannels()).isEqualTo(3);
    assertThat(copied.getDrainIdleGrace()).isEqualTo(Duration.ofSeconds(2));
    assertThat(copied.getErrorPenaltyStep()).isEqualTo(2);
    assertThat(copied.getErrorPenaltyDuration()).isEqualTo(Duration.ofSeconds(3));
  }

  @Test
  public void dynamicScalingGoDefaultKnobsRejectNegativeValues() {
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setScaleUpCooldown(Duration.ofNanos(-1)));
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setErrorPenaltyStep(-1));
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setChannelPrimeTimeout(Duration.ofNanos(-1)));
    assertThrows(
        IllegalArgumentException.class,
        () -> GcpChannelPoolOptions.newBuilder().setChannelPrimeMaxAttempts(-1));
  }

  @Test
  public void dynamicScalingAllowsEqualLoadBounds() {
    GcpChannelPoolOptions options =
        GcpChannelPoolOptions.newBuilder().setDynamicScaling(10, 10, Duration.ofSeconds(1)).build();

    assertThat(options.getMinRpcPerChannel()).isEqualTo(10);
    assertThat(options.getMaxRpcPerChannel()).isEqualTo(10);
  }

  @Test
  public void channelPoolOptionsToStringIncludesEveryKnob() {
    String options = GcpChannelPoolOptions.newBuilder().build().toString();

    assertThat(options).contains("maxSize:");
    assertThat(options).contains("minSize:");
    assertThat(options).contains("initSize:");
    assertThat(options).contains("minRpcPerChannel:");
    assertThat(options).contains("maxRpcPerChannel:");
    assertThat(options).contains("scaleDownInterval:");
    assertThat(options).contains("scaleUpCooldown:");
    assertThat(options).contains("scaleDownConsecutiveLowLoadChecks:");
    assertThat(options).contains("maxScaleUpPercent:");
    assertThat(options).contains("maxScaleDownChannels:");
    assertThat(options).contains("drainIdleGrace:");
    assertThat(options).contains("errorPenaltyStep:");
    assertThat(options).contains("errorPenaltyDuration:");
    assertThat(options).contains("concurrentStreamsLowWatermark:");
    assertThat(options).contains("useRoundRobinOnBind:");
    assertThat(options).contains("affinityKeyLifetime:");
    assertThat(options).contains("cleanupInterval:");
    assertThat(options).contains("channelPickStrategy:");
    assertThat(options).contains("channelPrimer:");
    assertThat(options).contains("channelPrimeTimeout:");
    assertThat(options).contains("channelPrimeMaxAttempts:");
  }

  @Test
  public void channelPrimerOptionsSurviveCopy() {
    GcpChannelPrimer primer = (ManagedChannel channel) -> Futures.immediateVoidFuture();
    GcpChannelPoolOptions configured =
        GcpChannelPoolOptions.newBuilder()
            .setChannelPrimer(primer)
            .setChannelPrimeTimeout(Duration.ofSeconds(7))
            .setChannelPrimeMaxAttempts(2)
            .build();

    GcpChannelPoolOptions copied = GcpChannelPoolOptions.newBuilder(configured).build();

    assertThat(copied.getChannelPrimer()).isSameInstanceAs(primer);
    assertThat(copied.getChannelPrimeTimeout()).isEqualTo(Duration.ofSeconds(7));
    assertThat(copied.getChannelPrimeMaxAttempts()).isEqualTo(2);
    assertThat(copied.toString()).contains("channelPrimeTimeout: PT7S");
    assertThat(copied.toString()).contains("channelPrimeMaxAttempts: 2");
  }

  @Test
  public void testCleanupDefault() {
    GcpManagedChannelOptions opts =
        GcpManagedChannelOptions.newBuilder()
            .withChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setAffinityKeyLifetime(Duration.ofSeconds(3600))
                    .build())
            .build();
    GcpChannelPoolOptions channelPoolOptions = opts.getChannelPoolOptions();
    assertThat(channelPoolOptions.getAffinityKeyLifetime()).isEqualTo(Duration.ofSeconds(3600));
    assertThat(channelPoolOptions.getCleanupInterval()).isEqualTo(Duration.ofSeconds(360));

    opts =
        GcpManagedChannelOptions.newBuilder()
            .withChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setCleanupInterval(Duration.ZERO)
                    .setAffinityKeyLifetime(Duration.ofSeconds(3600))
                    .build())
            .build();
    channelPoolOptions = opts.getChannelPoolOptions();
    assertThat(channelPoolOptions.getAffinityKeyLifetime()).isEqualTo(Duration.ofSeconds(3600));
    assertThat(channelPoolOptions.getCleanupInterval()).isEqualTo(Duration.ofSeconds(360));
  }

  @Test
  public void testCleanupMustNotBeZero() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(
        "Cleanup interval must not be zero when affinity key interval is above zero.");

    GcpManagedChannelOptions.newBuilder()
        .withChannelPoolOptions(
            GcpChannelPoolOptions.newBuilder()
                .setAffinityKeyLifetime(Duration.ofSeconds(3600))
                .setCleanupInterval(Duration.ZERO)
                .build())
        .build();
  }
}
