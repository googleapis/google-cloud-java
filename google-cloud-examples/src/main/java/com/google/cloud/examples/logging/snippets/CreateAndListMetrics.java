/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.logging.snippets;

import com.google.api.gax.paging.Page;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.MetricInfo;

/**
 * A snippet for Stackdriver Logging showing how to create a metric. The snippet also shows how to
 * list all metrics.
 *
 * @see <a href="https://cloud.google.com/logging/docs/view/logs_based_metrics">Log-based metrics
 *     </a>
 */
public class CreateAndListMetrics {

  public static void main(String... args) throws Exception {
    // Create a service object
    // Credentials are inferred from the environment
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

      // Create a metric
      MetricInfo metricInfo =
          MetricInfo.newBuilder("test-metric", "severity >= ERROR")
              .setDescription("Log entries with severity higher or equal to ERROR")
              .build();
      logging.create(metricInfo);

      // List metrics
      Page<Metric> metrics = logging.listMetrics();
      for (Metric metric : metrics.iterateAll()) {
        System.out.println(metric);
      }
    }
  }
}
