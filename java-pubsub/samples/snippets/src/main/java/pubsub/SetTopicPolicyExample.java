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

// [START pubsub_set_topic_policy]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;

public class SetTopicPolicyExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    setTopicPolicyExample(projectId, topicId);
  }

  public static void setTopicPolicyExample(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      GetIamPolicyRequest getIamPolicyRequest =
          GetIamPolicyRequest.newBuilder().setResource(topicName.toString()).build();
      Policy oldPolicy = topicAdminClient.getIamPolicy(getIamPolicyRequest);

      // Create new role -> members binding
      Binding binding =
          Binding.newBuilder()
              .setRole("roles/pubsub.editor")
              .addMembers("domain:google.com")
              .build();

      // Add new binding to updated policy
      Policy updatedPolicy = Policy.newBuilder(oldPolicy).addBindings(binding).build();

      SetIamPolicyRequest setIamPolicyRequest =
          SetIamPolicyRequest.newBuilder()
              .setResource(topicName.toString())
              .setPolicy(updatedPolicy)
              .build();
      Policy newPolicy = topicAdminClient.setIamPolicy(setIamPolicyRequest);
      System.out.println("New topic policy: " + newPolicy);
    }
  }
}
// [END pubsub_set_topic_policy]
