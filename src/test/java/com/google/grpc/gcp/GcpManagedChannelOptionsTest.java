/*
 * Copyright 2021 Google LLC
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

package com.google.grpc.gcp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.grpc.gcp.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.grpc.gcp.GcpManagedChannelOptions.GcpResiliencyOptions;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.MetricRegistry;
import io.opencensus.metrics.Metrics;
import java.util.Collections;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for GcpManagedChannel. */
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
}
