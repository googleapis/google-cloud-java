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

// [START bigtable_list_clusters]

import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClientV2;
import java.io.IOException;

public class ListClusters {

  /** Lists all clusters in the specified Cloud Bigtable instance. */
  public static void listClusters(String projectId, String instanceId) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";

    try (BigtableInstanceAdminClientV2 adminClient = BigtableInstanceAdminClientV2.create()) {
      String parent = "projects/" + projectId + "/instances/" + instanceId;
      ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
      ListClustersResponse response = adminClient.listClusters(request);
      for (Cluster cluster : response.getClustersList()) {
        System.out.println(cluster.getName());
      }
    }
  }
}
// [END bigtable_list_clusters]
