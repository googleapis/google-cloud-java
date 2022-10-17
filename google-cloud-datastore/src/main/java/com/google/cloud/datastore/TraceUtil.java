/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datastore;

import com.google.cloud.datastore.spi.v1.HttpDatastoreRpc;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;

/**
 * Helper class for tracing utility. It is used for instrumenting {@link HttpDatastoreRpc} with
 * OpenCensus APIs.
 *
 * <p>TraceUtil instances are created by the {@link TraceUtil#getInstance()} method.
 */
public class TraceUtil {
  private final Tracer tracer = Tracing.getTracer();
  private static final TraceUtil traceUtil = new TraceUtil();
  static final String SPAN_NAME_ALLOCATEIDS = "CloudDatastoreOperation.allocateIds";
  static final String SPAN_NAME_TRANSACTION = "CloudDatastoreOperation.readWriteTransaction";
  static final String SPAN_NAME_BEGINTRANSACTION = "CloudDatastoreOperation.beginTransaction";
  static final String SPAN_NAME_COMMIT = "CloudDatastoreOperation.commit";
  static final String SPAN_NAME_LOOKUP = "CloudDatastoreOperation.lookup";
  static final String SPAN_NAME_RESERVEIDS = "CloudDatastoreOperation.reserveIds";
  static final String SPAN_NAME_ROLLBACK = "CloudDatastoreOperation.rollback";
  static final String SPAN_NAME_RUNQUERY = "CloudDatastoreOperation.runQuery";
  static final String SPAN_NAME_RUN_AGGREGATION_QUERY =
      "CloudDatastoreOperation.runAggregationQuery";
  static final EndSpanOptions END_SPAN_OPTIONS =
      EndSpanOptions.builder().setSampleToLocalSpanStore(true).build();

  /**
   * Starts a new span.
   *
   * @param spanName The name of the returned Span.
   * @return The newly created {@link Span}.
   */
  protected Span startSpan(String spanName) {
    return tracer.spanBuilder(spanName).startSpan();
  }

  /**
   * Return the global {@link Tracer}.
   *
   * @return The global {@link Tracer}.
   */
  public Tracer getTracer() {
    return tracer;
  }

  /**
   * Return TraceUtil Object.
   *
   * @return An instance of {@link TraceUtil}
   */
  public static TraceUtil getInstance() {
    return traceUtil;
  }

  private TraceUtil() {}
}
