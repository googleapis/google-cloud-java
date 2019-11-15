/*
 * Copyright 2019 Google Inc.
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

// [START create_cluster]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.InstanceGroupConfig;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;

public class CreateCluster {

  public static void createCluster(String projectId, String region, String clusterName)
      throws IOException, InterruptedException {
    String myEndpoint = String.format("%s-dataproc.googleapis.com:443", region);

    // Configure the settings for the cluster controller client
    ClusterControllerSettings clusterControllerSettings =
        ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Create a cluster controller client with the configured settings. We only need to create
    // the client once, and can be reused for multiple requests. Using a try-with-resources
    // will close the client for us, but this can also be done manually with the .close() method.
    try (ClusterControllerClient clusterControllerClient = ClusterControllerClient
        .create(clusterControllerSettings)) {
      // Configure the settings for our cluster
      InstanceGroupConfig masterConfig = InstanceGroupConfig.newBuilder()
          .setMachineTypeUri("n1-standard-1")
          .setNumInstances(1)
          .build();
      InstanceGroupConfig workerConfig = InstanceGroupConfig.newBuilder()
          .setMachineTypeUri("n1-standard-1")
          .setNumInstances(2)
          .build();
      ClusterConfig clusterConfig = ClusterConfig.newBuilder()
          .setMasterConfig(masterConfig)
          .setWorkerConfig(workerConfig)
          .build();
      // Create the cluster object with the desired cluster config
      Cluster cluster = Cluster.newBuilder()
          .setClusterName(clusterName)
          .setConfig(clusterConfig)
          .build();

      // Send a request to create a Dataproc cluster.
      OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsyncRequest =
          clusterControllerClient.createClusterAsync(projectId, region, cluster);
      Cluster response = createClusterAsyncRequest.get();

      // Print out the response
      System.out.println(
          String.format("Cluster created successfully: %s", response.getClusterName())
      );

    } catch (IOException e) {
      // Likely this would occur due to issues authenticating with GCP. Make sure the environment
      // variable GOOGLE_APPLICATION_CREDENTIALS is configured.
      System.out.println("Error creating the cluster controller client: \n" + e.toString());
    } catch (ExecutionException e) {
      // Common issues for this include needing to increase compute engine quotas or a cluster of
      // the same name already exists.
      System.out.println("Error during cluster creation request: \n" + e.toString());
    }
  }
}
// [END create_cluster]