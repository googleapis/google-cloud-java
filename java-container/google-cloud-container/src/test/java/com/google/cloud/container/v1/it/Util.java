/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.container.v1.it;

import com.google.cloud.container.v1.ClusterManagerClient;
import com.google.container.v1.Cluster;
import com.google.container.v1.ListClustersResponse;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Util {

  // Cleans existing test resources if any.
  private static final int DELETION_THRESHOLD_TIME_HOURS = 24;

  /** tear down any clusters that are older than 24 hours * */
  public static void cleanUpExistingInstanceCluster(
      ClusterManagerClient client, String projectId, String zone, String prefix) {

    ListClustersResponse clustersResponse = client.listClusters(projectId, zone);
    List<Cluster> clusters = clustersResponse.getClustersList();

    for (Cluster cluster : clusters) {
      if (isCreatedBeforeThresholdTime(cluster.getCreateTime())
          && cluster.getName().startsWith(prefix)) {
        client.deleteCluster(projectId, zone, cluster.getName());
      }
    }
  }

  private static boolean isCreatedBeforeThresholdTime(String timestamp) {
    return OffsetDateTime.parse(timestamp)
        .toInstant()
        .isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }
}
