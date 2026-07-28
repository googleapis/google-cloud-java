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

// [START pubsub_test_topic_permissions]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.pubsub.v1.ProjectTopicName;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestTopicPermissionsExample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    testTopicPermissionsExample(projectId, topicId);
  }

  public static void testTopicPermissionsExample(String projectId, String topicId)
      throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);

      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.topics.attachSubscription");
      permissions.add("pubsub.topics.publish");
      permissions.add("pubsub.topics.update");

      TestIamPermissionsRequest testIamPermissionsRequest =
          TestIamPermissionsRequest.newBuilder()
              .setResource(topicName.toString())
              .addAllPermissions(permissions)
              .build();

      TestIamPermissionsResponse testedPermissionsResponse =
          topicAdminClient.testIamPermissions(testIamPermissionsRequest);

      System.out.println("Tested:\n" + testedPermissionsResponse);
    }
  }
}
// [END pubsub_test_topic_permissions]
