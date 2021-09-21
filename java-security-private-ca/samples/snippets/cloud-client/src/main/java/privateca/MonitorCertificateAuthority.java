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
package privateca;

// [START privateca_monitor_ca_expiry]

import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.AlertPolicy.Condition;
import com.google.monitoring.v3.AlertPolicy.Condition.MonitoringQueryLanguageCondition;
import com.google.monitoring.v3.AlertPolicy.ConditionCombinerType;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.ProjectName;
import java.io.IOException;

public class MonitorCertificateAuthority {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "your-project-id";
    createCaMonitoringPolicy(project);
  }

  // Creates a monitoring policy that notifies you 30 days before a managed CA expires.
  public static void createCaMonitoringPolicy(String project) throws IOException {
    /* Initialize client that will be used to send requests. This client only needs to be created
    once, and can be reused for multiple requests. After completing all of your requests, call
    the `client.close()` method on the client to safely
    clean up any remaining background resources. */
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create();
        NotificationChannelServiceClient notificationClient =
            NotificationChannelServiceClient.create()) {

      String policyName = "policy-name";

      /* Query which indicates the resource to monitor and the constraints.
      Here, the alert policy notifies you 30 days before a managed CA expires.
      For more info on creating queries, see: https://cloud.google.com/monitoring/mql/alerts */
      String query =
          "fetch privateca.googleapis.com/CertificateAuthority"
              + "| metric 'privateca.googleapis.com/ca/cert_chain_expiration'"
              + "| group_by 5m,"
              + "[value_cert_chain_expiration_mean: mean(value.cert_chain_expiration)]"
              + "| every 5m"
              + "| condition val() < 2.592e+06 's'";

      // Create a notification channel.
      NotificationChannel notificationChannel =
          NotificationChannel.newBuilder()
              .setType("email")
              .putLabels("email_address", "java-docs-samples-testing@google.com")
              .build();
      NotificationChannel channel =
          notificationClient.createNotificationChannel(
              ProjectName.of(project), notificationChannel);

      // Set the query and notification channel.
      AlertPolicy alertPolicy =
          AlertPolicy.newBuilder()
              .setDisplayName(policyName)
              .addConditions(
                  Condition.newBuilder()
                      .setDisplayName("ca-cert-chain-expiration")
                      .setConditionMonitoringQueryLanguage(
                          MonitoringQueryLanguageCondition.newBuilder().setQuery(query).build())
                      .build())
              .setCombiner(ConditionCombinerType.AND)
              .addNotificationChannels(channel.getName())
              .build();

      AlertPolicy policy = client.createAlertPolicy(ProjectName.of(project), alertPolicy);

      System.out.println("Monitoring policy successfully created !" + policy.getName());
    }
  }
}
// [END privateca_monitor_ca_expiry]
