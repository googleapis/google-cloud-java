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

// [START dataproc_quickstart]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.InstanceGroupConfig;
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.JobControllerClient;
import com.google.cloud.dataproc.v1.JobControllerSettings;
import com.google.cloud.dataproc.v1.JobPlacement;
import com.google.cloud.dataproc.v1.PySparkJob;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Quickstart {

  public static Job waitForJobCompletion(
      JobControllerClient jobControllerClient, String projectId, String region, String jobId) {
    while (true) {
      // Poll the service periodically until the Job is in a finished state.
      Job jobInfo = jobControllerClient.getJob(projectId, region, jobId);
      switch (jobInfo.getStatus().getState()) {
        case DONE:
        case CANCELLED:
        case ERROR:
          return jobInfo;
        default:
          try {
            // Wait a second in between polling attempts.
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
      }
    }
  }

  public static void quickstart() throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String region = "your-project-region";
    String clusterName = "your-cluster-name";
    String jobFilePath = "your-job-file-path";
    quickstart(projectId, region, clusterName, jobFilePath);
  }

  public static void quickstart(
      String projectId, String region, String clusterName, String jobFilePath)
      throws IOException, InterruptedException {
    String myEndpoint = String.format("%s-dataproc.googleapis.com:443", region);

    // Configure the settings for the cluster controller client.
    ClusterControllerSettings clusterControllerSettings =
        ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Configure the settings for the job controller client.
    JobControllerSettings jobControllerSettings =
        JobControllerSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Create both a cluster controller client and job controller client with the configured
    // settings. The client only needs to be created once and can be reused for multiple requests.
    // Using a try-with-resources closes the client, but this can also be done manually with
    // the .close() method.
    try (ClusterControllerClient clusterControllerClient =
            ClusterControllerClient.create(clusterControllerSettings);
        JobControllerClient jobControllerClient =
            JobControllerClient.create(jobControllerSettings)) {
      // Configure the settings for our cluster.
      InstanceGroupConfig masterConfig =
          InstanceGroupConfig.newBuilder()
              .setMachineTypeUri("n1-standard-1")
              .setNumInstances(1)
              .build();
      InstanceGroupConfig workerConfig =
          InstanceGroupConfig.newBuilder()
              .setMachineTypeUri("n1-standard-1")
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
      System.out.printf("Cluster created successfully: %s", response.getClusterName());

      // Configure the settings for our job.
      JobPlacement jobPlacement = JobPlacement.newBuilder().setClusterName(clusterName).build();
      PySparkJob pySparkJob = PySparkJob.newBuilder().setMainPythonFileUri(jobFilePath).build();
      Job job = Job.newBuilder().setPlacement(jobPlacement).setPysparkJob(pySparkJob).build();

      // Submit an asynchronous request to execute the job.
      Job request = jobControllerClient.submitJob(projectId, region, job);
      String jobId = request.getReference().getJobId();
      System.out.println(String.format("Submitted job \"%s\"", jobId));

      // Wait for the job to finish.
      CompletableFuture<Job> finishedJobFuture =
          CompletableFuture.supplyAsync(
              () -> waitForJobCompletion(jobControllerClient, projectId, region, jobId));
      int timeout = 10;
      try {
        Job jobInfo = finishedJobFuture.get(timeout, TimeUnit.MINUTES);
        System.out.printf("Job %s finished successfully.", jobId);

        // Cloud Dataproc job output gets saved to a GCS bucket allocated to it.
        Cluster clusterInfo = clusterControllerClient.getCluster(projectId, region, clusterName);
        Storage storage = StorageOptions.getDefaultInstance().getService();
        Blob blob =
            storage.get(
                clusterInfo.getConfig().getConfigBucket(),
                String.format(
                    "google-cloud-dataproc-metainfo/%s/jobs/%s/driveroutput.000000000",
                    clusterInfo.getClusterUuid(), jobId));
        System.out.println(
            String.format(
                "Job \"%s\" finished with state %s:\n%s",
                jobId, jobInfo.getStatus().getState(), new String(blob.getContent())));
      } catch (TimeoutException e) {
        System.err.println(
            String.format("Job timed out after %d minutes: %s", timeout, e.getMessage()));
      }

      // Delete the cluster.
      OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsyncRequest =
          clusterControllerClient.deleteClusterAsync(projectId, region, clusterName);
      deleteClusterAsyncRequest.get();
      System.out.println(String.format("Cluster \"%s\" successfully deleted.", clusterName));

    } catch (ExecutionException e) {
      System.err.println(String.format("Error executing quickstart: %s ", e.getMessage()));
    }
  }
}
// [END dataproc_quickstart]
