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

package com.google.cloud.firestore.telemetry;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.FirestoreOptions;
import io.grpc.ManagedChannelBuilder;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A utility interface for trace collection. Classes that implement this interface may make their
 * own design choices for how they approach trace collection. For instance, they may be no-op, or
 * they may use a particular tracing framework such as OpenTelemetry.
 */
public interface TraceUtil {
  String ATTRIBUTE_SERVICE_PREFIX = "gcp.firestore.";
  String ATTRIBUTE_KEY_ATTEMPT = "attempt";
  String ATTRIBUTE_KEY_DOC_COUNT = "doc_count";
  String ATTRIBUTE_KEY_IS_TRANSACTIONAL = "transactional";
  String ATTRIBUTE_KEY_NUM_RESPONSES = "response_count";
  String ATTRIBUTE_KEY_IS_RETRY_WITH_CURSOR = "retry_query_with_cursor";
  String ATTRIBUTE_KEY_TRANSACTION_TYPE = "transaction_type";
  String ATTRIBUTE_KEY_ATTEMPTS_ALLOWED = "attempts_allowed";
  String ATTRIBUTE_KEY_ATTEMPTS_REMAINING = "attempts_remaining";

  String ENABLE_TRACING_ENV_VAR = "FIRESTORE_ENABLE_TRACING";
  String LIBRARY_NAME = "com.google.cloud.firestore";

  /**
   * Creates and returns an instance of the TraceUtil class.
   *
   * @param firestoreOptions The FirestoreOptions object that is requesting an instance of
   *     TraceUtil.
   * @return An instance of the TraceUtil class.
   */
  @InternalApi
  static TraceUtil getInstance(@Nonnull FirestoreOptions firestoreOptions) {
    boolean createEnabledInstance = true;

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
      return new EnabledTraceUtil(firestoreOptions);
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
   * Starts a new span with the given name and the given context as its parent, sets it as the
   * current span, and returns it.
   */
  Span startSpan(String spanName, Context parent);

  /** Returns the current span. */
  @Nonnull
  Span currentSpan();

  /** Returns the current Context. */
  @Nonnull
  Context currentContext();
}
