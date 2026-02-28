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
package com.google.cloud.bigtable.data.v2.internal.csm.exporter;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.export.MemoryMode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector;
import io.opentelemetry.sdk.metrics.export.CollectionRegistration;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Wrapper around a {@link PeriodicMetricReader} that will notify the exporter when it's shutting
 * down. This is necessary to filter out noisy error logs on shutdown.
 */
public class BigtablePeriodicReader implements MetricReader {
  private final MetricReader delegate;
  private final BigtableCloudMonitoringExporter exporter;

  public BigtablePeriodicReader(
      BigtableCloudMonitoringExporter exporter, ScheduledExecutorService executor) {
    delegate = PeriodicMetricReader.builder(exporter).setExecutor(executor).build();
    this.exporter = exporter;
  }

  @Override
  public void register(CollectionRegistration registration) {
    delegate.register(registration);
  }

  @Override
  public Aggregation getDefaultAggregation(InstrumentType instrumentType) {
    return delegate.getDefaultAggregation(instrumentType);
  }

  @Override
  public MemoryMode getMemoryMode() {
    return delegate.getMemoryMode();
  }

  @Override
  public CompletableResultCode forceFlush() {
    return delegate.forceFlush();
  }

  @Override
  public CompletableResultCode shutdown() {
    return delegate.shutdown();
  }

  @Override
  public void close() throws IOException {
    exporter.prepareForShutdown();
    delegate.close();
  }

  public static AggregationTemporalitySelector alwaysCumulative() {
    return AggregationTemporalitySelector.alwaysCumulative();
  }

  public static AggregationTemporalitySelector deltaPreferred() {
    return AggregationTemporalitySelector.deltaPreferred();
  }

  public static AggregationTemporalitySelector lowMemory() {
    return AggregationTemporalitySelector.lowMemory();
  }

  @Override
  public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
    return delegate.getAggregationTemporality(instrumentType);
  }

  public static String asString(AggregationTemporalitySelector selector) {
    return AggregationTemporalitySelector.asString(selector);
  }

  public static DefaultAggregationSelector getDefault() {
    return DefaultAggregationSelector.getDefault();
  }

  @Override
  public DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
    return delegate.with(instrumentType, aggregation);
  }

  public static String asString(DefaultAggregationSelector selector) {
    return DefaultAggregationSelector.asString(selector);
  }
}
