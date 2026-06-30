/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.spanner;

import com.google.common.collect.ImmutableList;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;

/** A helper class that holds OpenCensus's related constants. */
class MetricRegistryConstants {

  // The label keys are used to uniquely identify timeseries.
  private static final LabelKey CLIENT_ID =
      LabelKey.create("client_id", "User defined database client id");
  private static final LabelKey DATABASE = LabelKey.create("database", "Target database");
  private static final LabelKey INSTANCE_ID =
      LabelKey.create("instance_id", "Name of the instance");
  private static final LabelKey LIBRARY_VERSION =
      LabelKey.create("library_version", "Library version");
  static final LabelKey IS_MULTIPLEXED_KEY =
      LabelKey.create("is_multiplexed", "Multiplexed Session");

  private static final LabelKey SESSION_TYPE = LabelKey.create("Type", "Type of the Sessions");

  /** The label value is used to represent missing value. */
  private static final LabelValue UNSET_LABEL = LabelValue.create(null);

  static final LabelValue NUM_IN_USE_SESSIONS = LabelValue.create("num_in_use_sessions");

  /**
   * The session pool no longer prepares a fraction of the sessions with a read/write transaction.
   * This metric will therefore always be zero and may be removed in the future.
   */
  @Deprecated
  static final LabelValue NUM_SESSIONS_BEING_PREPARED =
      LabelValue.create("num_sessions_being_prepared");

  static final LabelValue NUM_READ_SESSIONS = LabelValue.create("num_read_sessions");

  /**
   * The session pool no longer prepares a fraction of the sessions with a read/write transaction.
   * This metric will therefore always be zero and may be removed in the future.
   */
  @Deprecated
  static final LabelValue NUM_WRITE_SESSIONS = LabelValue.create("num_write_prepared_sessions");

  static final ImmutableList<LabelKey> SPANNER_LABEL_KEYS =
      ImmutableList.of(CLIENT_ID, DATABASE, INSTANCE_ID, LIBRARY_VERSION);
  static final ImmutableList<LabelKey> SPANNER_LABEL_KEYS_WITH_TYPE =
      ImmutableList.of(CLIENT_ID, DATABASE, INSTANCE_ID, LIBRARY_VERSION, SESSION_TYPE);

  static final ImmutableList<LabelValue> SPANNER_DEFAULT_LABEL_VALUES =
      ImmutableList.of(UNSET_LABEL, UNSET_LABEL, UNSET_LABEL, UNSET_LABEL);

  static final ImmutableList<LabelKey> SPANNER_LABEL_KEYS_WITH_MULTIPLEXED_SESSIONS =
      ImmutableList.of(CLIENT_ID, DATABASE, INSTANCE_ID, LIBRARY_VERSION, IS_MULTIPLEXED_KEY);

  /** Unit to represent counts. */
  static final String COUNT = "1";

  static final String INSTRUMENTATION_SCOPE = "cloud.google.com/java";

  static final String METRIC_PREFIX = "cloud.google.com/java/";

  // The Metric name and description
  static final String MAX_IN_USE_SESSIONS = "spanner/max_in_use_sessions";
  static final String MAX_ALLOWED_SESSIONS = "spanner/max_allowed_sessions";
  static final String GET_SESSION_TIMEOUTS = "spanner/get_session_timeouts";
  static final String NUM_ACQUIRED_SESSIONS = "spanner/num_acquired_sessions";
  static final String NUM_RELEASED_SESSIONS = "spanner/num_released_sessions";
  static final String NUM_SESSIONS_IN_POOL = "spanner/num_sessions_in_pool";
  static final String NUM_SESSIONS_IN_USE = "spanner/num_in_use_sessions";
  static final String NUM_SESSIONS_AVAILABLE = "spanner/num_available_sessions";
  static final String SESSIONS_TYPE = "session_type";
  static final String IS_MULTIPLEXED = "is_multiplexed";
  static final String MAX_IN_USE_SESSIONS_DESCRIPTION =
      "The maximum number of sessions in use during the last 10 minute interval.";
  static final String MAX_ALLOWED_SESSIONS_DESCRIPTION =
      "The maximum number of sessions allowed. Configurable by the user.";
  static final String SESSIONS_TIMEOUTS_DESCRIPTION =
      "The number of get sessions timeouts due to pool exhaustion";
  static final String NUM_ACQUIRED_SESSIONS_DESCRIPTION =
      "The number of sessions acquired from the session pool.";
  static final String NUM_RELEASED_SESSIONS_DESCRIPTION =
      "The number of sessions released by the user and pool maintainer.";
  static final String NUM_SESSIONS_IN_POOL_DESCRIPTION = "The number of sessions in the pool.";

  static final String SPANNER_GFE_LATENCY = "spanner/gfe_latency";
  static final String SPANNER_GFE_LATENCY_DESCRIPTION =
      "Latency between Google's network receiving an RPC and reading back the first byte of the"
          + " response";
  static final String SPANNER_GFE_HEADER_MISSING_COUNT = "spanner/gfe_header_missing_count";
  static final String SPANNER_GFE_HEADER_MISSING_COUNT_DESCRIPTION =
      "Number of RPC responses received without the server-timing header, most likely means that"
          + " the RPC never reached Google's network";
}
