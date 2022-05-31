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

// [START monitoring_enable_disable_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.monitoring.v3.Aggregation;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.ComparisonType;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Duration;
import java.io.IOException;

// Sample to enable disable an alert policy
public class EnableDisableAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String displayName = "alert-policy-display-name";
    String alertPolicyId = "alert-policy-id";
    // i.e projects/[PROJECT_ID_OR_NUMBER]/alertPolicies/[ALERT_POLICY_ID]
    enableDisableAlertPolicy(alertPolicyId, false, displayName);
  }

  public static void enableDisableAlertPolicy(
      String alertPolicyId, boolean status, String displayName) throws ApiException, IOException {
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

      // Construct condition
      AlertPolicy.Condition condition =
          AlertPolicy.Condition.newBuilder()
              .setDisplayName(displayName)
              .setConditionThreshold(metricThreshold)
              .build();

      // Create alert policy for update
      AlertPolicy alertPolicy =
          AlertPolicy.newBuilder()
              .setName(alertPolicyId)
              .setDisplayName(displayName)
              .addConditions(condition)
              .setCombiner(AlertPolicy.ConditionCombinerType.AND)
              .setEnabled(
                  BoolValue.newBuilder()
                      .setValue((status == true) ? Boolean.TRUE : Boolean.FALSE)
                      .build())
              .build();

      // Create update alert policy request
      UpdateAlertPolicyRequest updateAlertPolicyRequest =
          UpdateAlertPolicyRequest.newBuilder().setAlertPolicy(alertPolicy).build();

      // Process update policy request
      AlertPolicy updatedAlertPolicy =
          alertPolicyServiceClient.updateAlertPolicy(updateAlertPolicyRequest);
      System.out.format("alert policy enable disable status:%s%n", updatedAlertPolicy.getEnabled());
    }
  }
}
// [END monitoring_enable_disable_alert_policy]
