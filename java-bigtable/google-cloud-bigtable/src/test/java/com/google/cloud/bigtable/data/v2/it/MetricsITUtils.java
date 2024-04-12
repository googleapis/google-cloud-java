/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.it;

import com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants;
import com.google.common.truth.Correspondence;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.PointData;

public class MetricsITUtils {

  static final Correspondence<MetricData, String> METRIC_DATA_NAME_CONTAINS =
      Correspondence.from((md, s) -> md.getName().contains(s), "contains name");

  static final Correspondence<PointData, String> POINT_DATA_CLUSTER_ID_CONTAINS =
      Correspondence.from(
          (pd, s) -> pd.getAttributes().get(BuiltinMetricsConstants.CLUSTER_ID_KEY).contains(s),
          "contains attributes");

  static final Correspondence<PointData, String> POINT_DATA_ZONE_ID_CONTAINS =
      Correspondence.from(
          (pd, s) -> pd.getAttributes().get(BuiltinMetricsConstants.ZONE_ID_KEY).contains(s),
          "contains attributes");
}
