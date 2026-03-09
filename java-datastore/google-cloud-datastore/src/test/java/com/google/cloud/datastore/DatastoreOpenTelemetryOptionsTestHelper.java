/*
 * Copyright 2026 Google LLC
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

import io.opentelemetry.api.OpenTelemetry;

// TODO(lawrenceqiu): This is a temporary class used to enabled metrics while `setMetricsEnabled`
// is package private. This is to be removed later.
public class DatastoreOpenTelemetryOptionsTestHelper {
  public static DatastoreOpenTelemetryOptions withMetricsEnabled(OpenTelemetry openTelemetry) {
    return DatastoreOpenTelemetryOptions.newBuilder()
        .setMetricsEnabled(true)
        .setOpenTelemetry(openTelemetry)
        .build();
  }

  public static DatastoreOpenTelemetryOptions withMetricsEnabled() {
    return DatastoreOpenTelemetryOptions.newBuilder().setMetricsEnabled(true).build();
  }
}
