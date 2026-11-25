/*
 * Copyright 2026 Google LLC
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

package com.example.bigtable;

// [START bigtable_list_instances]

import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClientV2;
import java.io.IOException;

public class ListInstances {

  /** Lists all Cloud Bigtable instances in the specified project. */
  public static void listInstances(String projectId) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // String projectId = "my-project-id";

    try (BigtableInstanceAdminClientV2 adminClient = BigtableInstanceAdminClientV2.create()) {
      String parent = "projects/" + projectId;
      ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
      ListInstancesResponse response = adminClient.listInstances(request);
      for (Instance instance : response.getInstancesList()) {
        System.out.println(instance.getName());
      }
    }
  }
}
// [END bigtable_list_instances]
