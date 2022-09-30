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
/* This quickstart sample walks a user through creating a Cloud Dataproc
 * cluster, submitting a PySpark job from Google Cloud Storage to the
 * cluster, reading the output of the job and deleting the cluster, all
 * using the Java client library.
 *
 * Usage:
 *     mvn clean package -DskipTests
 *
 *     mvn exec:java -Dexec.args="<PROJECT_ID> <REGION> <CLUSTER_NAME> <GCS_JOB_FILE_PATH>"
 *
 *     You can also set these arguments in the main function instead of providing them via the CLI.
 */

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
import com.google.cloud.dataproc.v1.JobMetadata;
import com.google.cloud.dataproc.v1.JobPlacement;
import com.google.cloud.dataproc.v1.PySparkJob;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quickstart {

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

    // Create both a cluster controller client and job controller client with the
    // configured settings. The client only needs to be created once and can be reused for
    // multiple requests. Using a try-with-resources closes the client, but this can also be done
    // manually with the .close() method.
    try (ClusterControllerClient clusterControllerClient =
            ClusterControllerClient.create(clusterControllerSettings);
        JobControllerClient jobControllerClient =
            JobControllerClient.create(jobControllerSettings)) {
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
      Cluster clusterResponse = createClusterAsyncRequest.get();
      System.out.println(
          String.format("Cluster created successfully: %s", clusterResponse.getClusterName()));

      // Configure the settings for our job.
      JobPlacement jobPlacement = JobPlacement.newBuilder().setClusterName(clusterName).build();
      PySparkJob pySparkJob = PySparkJob.newBuilder().setMainPythonFileUri(jobFilePath).build();
      Job job = Job.newBuilder().setPlacement(jobPlacement).setPysparkJob(pySparkJob).build();

      // Submit an asynchronous request to execute the job.
      OperationFuture<Job, JobMetadata> submitJobAsOperationAsyncRequest =
          jobControllerClient.submitJobAsOperationAsync(projectId, region, job);
      Job jobResponse = submitJobAsOperationAsyncRequest.get();

      // Print output from Google Cloud Storage.
      Matcher matches =
          Pattern.compile("gs://(.*?)/(.*)").matcher(jobResponse.getDriverOutputResourceUri());
      matches.matches();

      Storage storage = StorageOptions.getDefaultInstance().getService();
      Blob blob = storage.get(matches.group(1), String.format("%s.000000000", matches.group(2)));

      System.out.println(
          String.format("Job finished successfully: %s", new String(blob.getContent())));

      // Delete the cluster.
      OperationFuture<Empty, ClusterOperationMetadata> deleteClusterAsyncRequest =
          clusterControllerClient.deleteClusterAsync(projectId, region, clusterName);
      deleteClusterAsyncRequest.get();
      System.out.println(String.format("Cluster \"%s\" successfully deleted.", clusterName));

    } catch (ExecutionException e) {
      System.err.println(String.format("quickstart: %s ", e.getMessage()));
    }
  }

  public static void main(String... args) throws IOException, InterruptedException {
    if (args.length != 4) {
      System.err.println(
          "Insufficient number of parameters provided. Please make sure a "
              + "PROJECT_ID, REGION, CLUSTER_NAME and JOB_FILE_PATH are provided, in this order.");
      return;
    }

    String projectId = args[0]; // project-id of project to create the cluster in
    String region = args[1]; // region to create the cluster
    String clusterName = args[2]; // name of the cluster
    String jobFilePath = args[3]; // location in GCS of the PySpark job

    quickstart(projectId, region, clusterName, jobFilePath);
  }
}
// [END dataproc_quickstart]
