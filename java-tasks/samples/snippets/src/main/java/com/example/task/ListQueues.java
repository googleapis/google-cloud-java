// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example.task;

// [START cloud_tasks_list_queues]
import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.LocationName;
import com.google.cloud.tasks.v2.Queue;
import java.io.IOException;

public class ListQueues {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String locationId = "us-central1";
    listQueues(projectId, locationId);
  }

  // List queues using the Cloud Tasks client.
  public static void listQueues(String projectId, String locationId)
      throws IOException {

    // Instantiates a client.
    try (CloudTasksClient client = CloudTasksClient.create()) {

      // Construct the fully qualified location path.
      String parent = LocationName.of(projectId, locationId).toString();

      // Send list queues request.
      CloudTasksClient.ListQueuesPagedResponse response = client.listQueues(parent);

      // Iterate over results and print queue names
      int total = 0;
      for (Queue queue : response.iterateAll()) {
        System.out.println(queue.getName());
        total++;
      }

      if (total == 0) {
        System.out.println("No queues found!");
      }
    }
  }
}
// [END cloud_tasks_list_queues]
