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

class GcpMetricsConstants {
  public static String POOL_INDEX_LABEL = "pool_index";
  public static String POOL_INDEX_DESC = "gRPC GCP channel pool index.";

  public static String METRIC_NUM_CHANNELS = "num_channels";
  public static String METRIC_MAX_ALLOWED_CHANNELS = "max_allowed_channels";
  public static String METRIC_MIN_ACTIVE_STREAMS = "min_active_streams";
  public static String METRIC_MAX_ACTIVE_STREAMS = "max_active_streams";
  public static String METRIC_NUM_TOTAL_ACTIVE_STREAMS = "num_total_active_streams";
}
