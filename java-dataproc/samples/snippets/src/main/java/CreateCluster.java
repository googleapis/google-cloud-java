/*
 * Copyright 2019 Google LLC
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

// [START dataproc_create_cluster]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.InstanceGroupConfig;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateCluster {

  public static void createCluster() throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String region = "your-project-region";
    String clusterName = "your-cluster-name";
    createCluster(projectId, region, clusterName);
  }

  public static void createCluster(String projectId, String region, String clusterName)
      throws IOException, InterruptedException {
    String myEndpoint = String.format("%s-dataproc.googleapis.com:443", region);

    // Configure the settings for the cluster controller client.
    ClusterControllerSettings clusterControllerSettings =
        ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Create a cluster controller client with the configured settings. The client only needs to be
    // created once and can be reused for multiple requests. Using a try-with-resources
    // closes the client, but this can also be done manually with the .close() method.
    try (ClusterControllerClient clusterControllerClient =
        ClusterControllerClient.create(clusterControllerSettings)) {
      // Configure the settings for our cluster.
      InstanceGroupConfig masterConfig =
          InstanceGroupConfig.newBuilder()
              .setMachineTypeUri("n1-standard-2")
              .setNumInstances(1)
              .build();
      InstanceGroupConfig workerConfig =
          InstanceGroupConfig.newBuilder()
              .setMachineTypeUri("n1-standard-2")
              .setNumInstances(2)
              .build();
      ClusterConfig clusterConfig =
          ClusterConfig.newBuilder()
              .setMasterConfig(masterConfig)
              .setWorkerConfig(workerConfig)
              .build();
      // Create the cluster object with the desired cluster config.
      Cluster cluster =
          Cluster.newBuilder().setClusterName(clusterName).setConfig(clusterConfig).build();

      // Create the Cloud Dataproc cluster.
      OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsyncRequest =
          clusterControllerClient.createClusterAsync(projectId, region, cluster);
      Cluster response = createClusterAsyncRequest.get();

      // Print out a success message.
      System.out.printf("Cluster created successfully: %s", response.getClusterName());

    } catch (ExecutionException e) {
      System.err.println(String.format("Error executing createCluster: %s ", e.getMessage()));
    }
  }
}
// [END dataproc_create_cluster]
