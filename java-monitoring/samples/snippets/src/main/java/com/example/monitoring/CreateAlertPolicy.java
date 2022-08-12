/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.monitoring;

// [START monitoring_create_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.monitoring.v3.Aggregation;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.ComparisonType;
import com.google.monitoring.v3.ProjectName;
import com.google.protobuf.Duration;
import java.io.IOException;

// Sample to create an alert policy
public class CreateAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String alertPolicyName = "your-policy-name";
    createAlertPolicy(projectId, alertPolicyName);
  }

  public static void createAlertPolicy(String projectId, String alertPolicyName)
      throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
      ProjectName name = ProjectName.of(projectId);
      String metricType = "compute.googleapis.com/instance/cpu/utilization";
      String resourceType = "gce_instance";

      // A Filter that identifies which time series should be compared with the threshold
      String metricFilter =
          "metric.type="
              + '"'
              + metricType
              + '"'
              + " AND "
              + "resource.type="
              + '"'
              + resourceType
              + '"';

      // Build Duration
      Duration aggregationDuration = Duration.newBuilder().setSeconds(60).build();

      // Build Aggregation
      Aggregation aggregation =
          Aggregation.newBuilder()
              .setAlignmentPeriod(aggregationDuration)
              .setCrossSeriesReducer(Aggregation.Reducer.REDUCE_MEAN)
              .setPerSeriesAligner(Aggregation.Aligner.ALIGN_MAX)
              .build();

      // Build MetricThreshold
      AlertPolicy.Condition.MetricThreshold metricThreshold =
          AlertPolicy.Condition.MetricThreshold.newBuilder()
              .setComparison(ComparisonType.COMPARISON_GT)
              .addAggregations(aggregation)
              .setFilter(metricFilter)
              .setDuration(aggregationDuration)
              .build();

      // Construct Condition object
      AlertPolicy.Condition alertPolicyCondition =
          AlertPolicy.Condition.newBuilder()
              .setDisplayName(alertPolicyName)
              .setConditionThreshold(metricThreshold)
              .build();

      // Build an alert policy
      AlertPolicy alertPolicy =
          AlertPolicy.newBuilder()
              .setDisplayName(alertPolicyName)
              .addConditions(alertPolicyCondition)
              .setCombiner(AlertPolicy.ConditionCombinerType.AND)
              .build();

      // Create an alert policy
      AlertPolicy actualAlertPolicy = alertPolicyServiceClient.createAlertPolicy(name, alertPolicy);
      System.out.format("alert policy created:%s", actualAlertPolicy.getName());
    }
  }
}
// [END monitoring_create_alert_policy]
