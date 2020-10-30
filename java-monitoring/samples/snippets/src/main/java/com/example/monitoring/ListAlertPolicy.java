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

// [START monitoring_list_alert_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ProjectName;
import java.io.IOException;

// Sample to list an alert policy
public class ListAlertPolicy {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listAlertPolicy(projectId);
  }

  public static void listAlertPolicy(String projectId) throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (AlertPolicyServiceClient alertPolicyServiceClient = AlertPolicyServiceClient.create()) {
      // Lists the existing alerting policies for the project.
      ListAlertPoliciesRequest listAlertPoliciesRequest =
          ListAlertPoliciesRequest.newBuilder()
              .setName(ProjectName.of(projectId).toString())
              .build();

      // process response
      AlertPolicyServiceClient.ListAlertPoliciesPagedResponse response =
          alertPolicyServiceClient.listAlertPolicies(listAlertPoliciesRequest);

      // List all the policy.
      response
          .iterateAll()
          .forEach(
              alertPolicy ->
                  System.out.format(
                      "success! alert policy %s is policyId %s%n",
                      alertPolicy.getDisplayName(), alertPolicy.getName()));
    }
  }
}
// [END monitoring_list_alert_policy]
