/*
 * Copyright 2016 Google LLC
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

package pubsub;

// [START pubsub_test_subscription_permissions]

import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.pubsub.v1.ProjectSubscriptionName;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestSubscriptionPermissionsExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String subscriptionId = "your-subscription-id";

    testSubscriptionPermissionsExample(projectId, subscriptionId);
  }

  public static void testSubscriptionPermissionsExample(String projectId, String subscriptionId)
      throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.subscriptions.consume");
      permissions.add("pubsub.subscriptions.update");

      TestIamPermissionsRequest testIamPermissionsRequest =
          TestIamPermissionsRequest.newBuilder()
              .setResource(subscriptionName.toString())
              .addAllPermissions(permissions)
              .build();

      TestIamPermissionsResponse testedPermissionsResponse =
          subscriptionAdminClient.testIamPermissions(testIamPermissionsRequest);

      System.out.println("Tested:\n" + testedPermissionsResponse);
    }
  }
}
// [END pubsub_test_subscription_permissions]
