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

// [START pubsub_list_topics]

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Topic;
import java.io.IOException;

public class ListTopicsExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";

    listTopicsExample(projectId);
  }

  public static void listTopicsExample(String projectId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      ProjectName projectName = ProjectName.of(projectId);
      for (Topic topic : topicAdminClient.listTopics(projectName).iterateAll()) {
        System.out.println(topic.getName());
      }
      System.out.println("Listed all topics.");
    }
  }
}
// [END pubsub_list_topics]
