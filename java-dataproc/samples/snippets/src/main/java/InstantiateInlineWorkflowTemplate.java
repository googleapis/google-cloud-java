/*
 * Copyright 2020 Google LLC
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

// [START dataproc_instantiate_inline_workflow_template]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.GceClusterConfig;
import com.google.cloud.dataproc.v1.HadoopJob;
import com.google.cloud.dataproc.v1.ManagedCluster;
import com.google.cloud.dataproc.v1.OrderedJob;
import com.google.cloud.dataproc.v1.RegionName;
import com.google.cloud.dataproc.v1.WorkflowMetadata;
import com.google.cloud.dataproc.v1.WorkflowTemplate;
import com.google.cloud.dataproc.v1.WorkflowTemplatePlacement;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceClient;
import com.google.cloud.dataproc.v1.WorkflowTemplateServiceSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class InstantiateInlineWorkflowTemplate {

  public static void instantiateInlineWorkflowTemplate() throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String region = "your-project-region";
    instantiateInlineWorkflowTemplate(projectId, region);
  }

  public static void instantiateInlineWorkflowTemplate(String projectId, String region)
      throws IOException, InterruptedException {
    String myEndpoint = String.format("%s-dataproc.googleapis.com:443", region);

    // Configure the settings for the workflow template service client.
    WorkflowTemplateServiceSettings workflowTemplateServiceSettings =
        WorkflowTemplateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Create a workflow template service client with the configured settings. The client only
    // needs to be created once and can be reused for multiple requests. Using a try-with-resources
    // closes the client, but this can also be done manually with the .close() method.
    try (WorkflowTemplateServiceClient workflowTemplateServiceClient =
        WorkflowTemplateServiceClient.create(workflowTemplateServiceSettings)) {

      // Configure the jobs within the workflow.
      HadoopJob teragenHadoopJob =
          HadoopJob.newBuilder()
              .setMainJarFileUri("file:///usr/lib/hadoop-mapreduce/hadoop-mapreduce-examples.jar")
              .addArgs("teragen")
              .addArgs("1000")
              .addArgs("hdfs:///gen/")
              .build();
      OrderedJob teragen =
          OrderedJob.newBuilder().setHadoopJob(teragenHadoopJob).setStepId("teragen").build();

      HadoopJob terasortHadoopJob =
          HadoopJob.newBuilder()
              .setMainJarFileUri("file:///usr/lib/hadoop-mapreduce/hadoop-mapreduce-examples.jar")
              .addArgs("terasort")
              .addArgs("hdfs:///gen/")
              .addArgs("hdfs:///sort/")
              .build();
      OrderedJob terasort =
          OrderedJob.newBuilder()
              .setHadoopJob(terasortHadoopJob)
              .addPrerequisiteStepIds("teragen")
              .setStepId("terasort")
              .build();

      // Configure the cluster placement for the workflow.
      // Leave "ZoneUri" empty for "Auto Zone Placement".
      // GceClusterConfig gceClusterConfig =
      //     GceClusterConfig.newBuilder().setZoneUri("").build();
      GceClusterConfig gceClusterConfig =
          GceClusterConfig.newBuilder().setZoneUri("us-central1-a").build();
      ClusterConfig clusterConfig =
          ClusterConfig.newBuilder().setGceClusterConfig(gceClusterConfig).build();
      ManagedCluster managedCluster =
          ManagedCluster.newBuilder()
              .setClusterName("my-managed-cluster")
              .setConfig(clusterConfig)
              .build();
      WorkflowTemplatePlacement workflowTemplatePlacement =
          WorkflowTemplatePlacement.newBuilder().setManagedCluster(managedCluster).build();

      // Create the inline workflow template.
      WorkflowTemplate workflowTemplate =
          WorkflowTemplate.newBuilder()
              .addJobs(teragen)
              .addJobs(terasort)
              .setPlacement(workflowTemplatePlacement)
              .build();

      // Submit the instantiated inline workflow template request.
      String parent = RegionName.format(projectId, region);
      OperationFuture<Empty, WorkflowMetadata> instantiateInlineWorkflowTemplateAsync =
          workflowTemplateServiceClient.instantiateInlineWorkflowTemplateAsync(
              parent, workflowTemplate);
      instantiateInlineWorkflowTemplateAsync.get();

      // Print out a success message.
      System.out.printf("Workflow ran successfully.");

    } catch (ExecutionException e) {
      System.err.println(String.format("Error running workflow: %s ", e.getMessage()));
    }
  }
}
// [END dataproc_instantiate_inline_workflow_template]
