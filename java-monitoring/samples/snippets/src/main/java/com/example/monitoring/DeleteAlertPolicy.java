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

// [START monitoring_delete_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import java.io.IOException;

// Sample to delete an alert policy
public class DeleteAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String alertPolicyId = "alert-policy-id";
    // i.e projects/[PROJECT_ID_OR_NUMBER]/alertPolicies/[ALERT_POLICY_ID]
    deleteAlertPolicy(alertPolicyId);
  }

  public static void deleteAlertPolicy(String alertPolicyId) throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
      // Deletes an alerting policy
      alertPolicyServiceClient.deleteAlertPolicy(alertPolicyId);
      System.out.format("alert policy deleted successfully:%s", alertPolicyId);
    }
  }
}
// [END monitoring_delete_alert_policy]
