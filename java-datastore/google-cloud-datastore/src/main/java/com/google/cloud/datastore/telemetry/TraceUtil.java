/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore.telemetry;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.datastore.DatastoreOptions;
import io.grpc.ManagedChannelBuilder;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Utility interface to manage OpenTelemetry tracing instrumentation based on the configuration. */
@InternalExtensionOnly
public interface TraceUtil {
  static final String ATTRIBUTE_SERVICE_PREFIX = "gcp.datastore.";
  static final String ENABLE_TRACING_ENV_VAR = "DATASTORE_ENABLE_TRACING";
  static final String LIBRARY_NAME = "com.google.cloud.datastore";
  static final String SPAN_NAME_LOOKUP = "Lookup";
  static final String SPAN_NAME_ALLOCATE_IDS = "AllocateIds";
  static final String SPAN_NAME_RESERVE_IDS = "ReserveIds";
  static final String SPAN_NAME_COMMIT = "Commit";
  static final String SPAN_NAME_RUN_QUERY = "RunQuery";
  static final String SPAN_NAME_RUN_AGGREGATION_QUERY = "RunAggregationQuery";
  static final String SPAN_NAME_TRANSACTION_RUN = "Transaction.Run";
  static final String SPAN_NAME_BEGIN_TRANSACTION = "Transaction.Begin";
  static final String SPAN_NAME_TRANSACTION_LOOKUP = "Transaction.Lookup";
  static final String SPAN_NAME_TRANSACTION_COMMIT = "Transaction.Commit";
  static final String SPAN_NAME_TRANSACTION_RUN_QUERY = "Transaction.RunQuery";
  static final String SPAN_NAME_ROLLBACK = "Transaction.Rollback";
  static final String SPAN_NAME_TRANSACTION_RUN_AGGREGATION_QUERY =
      "Transaction.RunAggregationQuery";
  static final String ATTRIBUTES_KEY_DOCUMENT_COUNT = "doc_count";
  static final String ATTRIBUTES_KEY_TRANSACTIONAL = "transactional";
  static final String ATTRIBUTES_KEY_TRANSACTION_ID = "transaction_id";
  static final String ATTRIBUTES_KEY_READ_CONSISTENCY = "read_consistency";
  static final String ATTRIBUTES_KEY_RECEIVED = "Received";
  static final String ATTRIBUTES_KEY_MISSING = "Missing";
  static final String ATTRIBUTES_KEY_DEFERRED = "Deferred";
  static final String ATTRIBUTES_KEY_MORE_RESULTS = "mor_results";

  /**
   * Creates and returns an instance of the TraceUtil class.
   *
   * @param datastoreOptions The DatastoreOptions object that is requesting an instance of
   *     TraceUtil.
   * @return An instance of the TraceUtil class.
   */
  static TraceUtil getInstance(@Nonnull DatastoreOptions datastoreOptions) {
    boolean createEnabledInstance = datastoreOptions.getOpenTelemetryOptions().isEnabled();

    // The environment variable can override options to enable/disable telemetry collection.
    String enableTracingEnvVar = System.getenv(ENABLE_TRACING_ENV_VAR);
    if (enableTracingEnvVar != null) {
      if (enableTracingEnvVar.equalsIgnoreCase("true")
          || enableTracingEnvVar.equalsIgnoreCase("on")) {
        createEnabledInstance = true;
      }
      if (enableTracingEnvVar.equalsIgnoreCase("false")
          || enableTracingEnvVar.equalsIgnoreCase("off")) {
        createEnabledInstance = false;
      }
    }

    if (createEnabledInstance) {
      return new EnabledTraceUtil(datastoreOptions);
    } else {
      return new DisabledTraceUtil();
    }
  }

  /** Returns a channel configurator for gRPC, or {@code null} if tracing is disabled. */
  @Nullable
  ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> getChannelConfigurator();

  /** Represents a trace span. */
  interface Span {
    /** Adds the given event to this span. */
    Span addEvent(String name);

    /** Adds the given event with the given attributes to this span. */
    Span addEvent(String name, Map<String, Object> attributes);

    /** Adds the given attribute to this span. */
    Span setAttribute(String key, int value);

    /** Adds the given attribute to this span. */
    Span setAttribute(String key, String value);

    /** Adds the given attribute to this span. */
    Span setAttribute(String key, boolean value);

    io.opentelemetry.api.trace.Span getSpan();

    /** Marks this span as the current span. */
    Scope makeCurrent();

    /** Ends this span. */
    void end();

    /** Ends this span in an error. */
    void end(Throwable error);

    /**
     * If an operation ends in the future, its relevant span should end _after_ the future has been
     * completed. This method "appends" the span completion code at the completion of the given
     * future. In order for telemetry info to be recorded, the future returned by this method should
     * be completed.
     */
    <T> void endAtFuture(ApiFuture<T> futureValue);
  }

  /** Represents a trace context. */
  interface Context {
    /** Makes this context the current context. */
    Scope makeCurrent();
  }

  /** Represents a trace scope. */
  interface Scope extends AutoCloseable {
    /** Closes the current scope. */
    void close();
  }

  /** Starts a new span with the given name, sets it as the current span, and returns it. */
  Span startSpan(String spanName);

  /**
   * Starts a new span with the given name and the span represented by the parentSpan as its parent,
   * sets it as the current span and returns it.
   */
  Span startSpan(String spanName, Span parentSpan);

  /**
   * Adds common SpanAttributes to the current span, useful when hand-creating a new Span without
   * using the TraceUtil.Span interface.
   */
  SpanBuilder addSettingsAttributesToCurrentSpan(SpanBuilder spanBuilder);

  /** Returns the current span. */
  @Nonnull
  Span getCurrentSpan();

  /** Returns the current Context. */
  @Nonnull
  Context getCurrentContext();

  /** Returns the current OpenTelemetry Tracer when OpenTelemetry SDK is provided. */
  Tracer getTracer();
}
