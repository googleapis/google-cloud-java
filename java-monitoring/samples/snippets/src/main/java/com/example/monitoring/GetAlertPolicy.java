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

// [START monitoring_get_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.monitoring.v3.AlertPolicy;
import java.io.IOException;

// Sample to get an alert policy
public class GetAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    String alertPolicyName = "alert-policy-id";
    // i.e projects/[PROJECT_ID_OR_NUMBER]/alertPolicies/[ALERT_POLICY_ID]
    getAlertPolicy(alertPolicyName);
  }

  public static void getAlertPolicy(String alertPolicyName) throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
      // Gets a single alerting policy
      AlertPolicy alertPolicy = alertPolicyServiceClient.getAlertPolicy(alertPolicyName);
      System.out.format("alert policy retrieved successfully:%s", alertPolicy.getName());
    }
  }
}
// [END monitoring_get_alert_policy]
