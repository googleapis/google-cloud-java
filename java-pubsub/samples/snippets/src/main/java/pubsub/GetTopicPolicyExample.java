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

// [START pubsub_get_topic_policy]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;

public class GetTopicPolicyExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String topicId = "your-topic-id";

    getTopicPolicyExample(projectId, topicId);
  }

  public static void getTopicPolicyExample(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      GetIamPolicyRequest getIamPolicyRequest =
          GetIamPolicyRequest.newBuilder().setResource(topicName.toString()).build();
      Policy policy = topicAdminClient.getIamPolicy(getIamPolicyRequest);
      System.out.println("Topic policy: " + policy);
    }
  }
}
// [END pubsub_get_topic_policy]
