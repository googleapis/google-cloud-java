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

// [START monitoring_update_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.monitoring.v3.Aggregation;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.ComparisonType;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.Duration;
import java.io.IOException;

// Sample to update an alert policy
public class UpdateAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String alertPolicyName = "your-alert-policy-displayname";
    String updatedAlertPolicyName = "your-updated-alert-policy-displayname";
    updateAlertPolicy(alertPolicyName, updatedAlertPolicyName);
  }

  public static void updateAlertPolicy(String alertPolicyName, String newPolicyName)
      throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
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

      // build Alert policy condition
      AlertPolicy.Condition alertPolicyCondition =
          AlertPolicy.Condition.newBuilder()
              .setDisplayName(alertPolicyName)
              .setConditionThreshold(metricThreshold)
              .build();

      // create alert policy for update
      AlertPolicy alertPolicy =
          AlertPolicy.newBuilder()
              .setName(alertPolicyName)
              .setDisplayName(newPolicyName)
              .addConditions(alertPolicyCondition)
              .setCombiner(AlertPolicy.ConditionCombinerType.AND)
              .build();

      // create update alert policy request
      UpdateAlertPolicyRequest updateAlertPolicyRequest =
          UpdateAlertPolicyRequest.newBuilder().setAlertPolicy(alertPolicy).build();

      // process update policy request
      AlertPolicy updatedAlertPolicy =
          alertPolicyServiceClient.updateAlertPolicy(updateAlertPolicyRequest);
      System.out.print("alert policy updated successfully:" + updatedAlertPolicy.getName());
    }
  }
}
// [END monitoring_update_alert_policy]
