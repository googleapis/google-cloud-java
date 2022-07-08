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
*
* This sample creates a Dataproc cluster with an autoscaling policy enabled.
* The policy we will be creating mirrors the following YAML representation:
*
   workerConfig:
     minInstances: 2
     maxInstances: 100
     weight: 1
   secondaryWorkerConfig:
     minInstances: 0
     maxInstances: 100
     weight: 1
   basicAlgorithm:
     cooldownPeriod: 4m
     yarnConfig:
       scaleUpFactor: 0.05
       scaleDownFactor: 1.0
       scaleUpMinWorkerFraction: 0.0
       scaleDownMinWorkerFraction: 0.0
       gracefulDecommissionTimeout: 1h
*/

// [START dataproc_create_autoscaling_cluster]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataproc.v1.AutoscalingConfig;
import com.google.cloud.dataproc.v1.AutoscalingPolicy;
import com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient;
import com.google.cloud.dataproc.v1.AutoscalingPolicyServiceSettings;
import com.google.cloud.dataproc.v1.BasicAutoscalingAlgorithm;
import com.google.cloud.dataproc.v1.BasicYarnAutoscalingConfig;
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterConfig;
import com.google.cloud.dataproc.v1.ClusterControllerClient;
import com.google.cloud.dataproc.v1.ClusterControllerSettings;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.InstanceGroupAutoscalingPolicyConfig;
import com.google.cloud.dataproc.v1.InstanceGroupConfig;
import com.google.cloud.dataproc.v1.RegionName;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class CreateClusterWithAutoscaling {

  public static void createClusterwithAutoscaling() throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String region = "your-project-region";
    String clusterName = "your-cluster-name";
    String autoscalingPolicyName = "your-autoscaling-policy";
    createClusterwithAutoscaling(projectId, region, clusterName, autoscalingPolicyName);
  }

  public static void createClusterwithAutoscaling(
      String projectId, String region, String clusterName, String autoscalingPolicyName)
      throws IOException, InterruptedException {
    String myEndpoint = String.format("%s-dataproc.googleapis.com:443", region);

    // Configure the settings for the cluster controller client.
    ClusterControllerSettings clusterControllerSettings =
        ClusterControllerSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Configure the settings for the autoscaling policy service client.
    AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
        AutoscalingPolicyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();

    // Create a cluster controller client and an autoscaling controller client with the configured
    // settings. The clients only need to be created once and can be reused for multiple requests.
    // Using a
    // try-with-resources closes the client, but this can also be done manually with the .close()
    // method.
    try (ClusterControllerClient clusterControllerClient =
            ClusterControllerClient.create(clusterControllerSettings);
        AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
            AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings)) {

      // Create the Autoscaling policy.
      InstanceGroupAutoscalingPolicyConfig workerInstanceGroupAutoscalingPolicyConfig =
          InstanceGroupAutoscalingPolicyConfig.newBuilder()
              .setMinInstances(2)
              .setMaxInstances(100)
              .setWeight(1)
              .build();
      InstanceGroupAutoscalingPolicyConfig secondaryWorkerInstanceGroupAutoscalingPolicyConfig =
          InstanceGroupAutoscalingPolicyConfig.newBuilder()
              .setMinInstances(0)
              .setMaxInstances(100)
              .setWeight(1)
              .build();
      BasicYarnAutoscalingConfig basicYarnApplicationConfig =
          BasicYarnAutoscalingConfig.newBuilder()
              .setScaleUpFactor(0.05)
              .setScaleDownFactor(1.0)
              .setScaleUpMinWorkerFraction(0.0)
              .setScaleUpMinWorkerFraction(0.0)
              .setGracefulDecommissionTimeout(Duration.newBuilder().setSeconds(3600).build())
              .build();
      BasicAutoscalingAlgorithm basicAutoscalingAlgorithm =
          BasicAutoscalingAlgorithm.newBuilder()
              .setCooldownPeriod(Duration.newBuilder().setSeconds(240).build())
              .setYarnConfig(basicYarnApplicationConfig)
              .build();
      AutoscalingPolicy autoscalingPolicy =
          AutoscalingPolicy.newBuilder()
              .setId(autoscalingPolicyName)
              .setWorkerConfig(workerInstanceGroupAutoscalingPolicyConfig)
              .setSecondaryWorkerConfig(secondaryWorkerInstanceGroupAutoscalingPolicyConfig)
              .setBasicAlgorithm(basicAutoscalingAlgorithm)
              .build();
      RegionName parent = RegionName.of(projectId, region);

      // Policy is uploaded here.
      autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, autoscalingPolicy);

      // Now the policy can be referenced when creating a cluster.
      String autoscalingPolicyUri =
          String.format(
              "projects/%s/locations/%s/autoscalingPolicies/%s",
              projectId, region, autoscalingPolicyName);
      AutoscalingConfig autoscalingConfig =
          AutoscalingConfig.newBuilder().setPolicyUri(autoscalingPolicyUri).build();

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
              .setAutoscalingConfig(autoscalingConfig)
              .build();

      // Create the cluster object with the desired cluster config.
      Cluster cluster =
          Cluster.newBuilder().setClusterName(clusterName).setConfig(clusterConfig).build();

      // Create the Dataproc cluster.
      OperationFuture<Cluster, ClusterOperationMetadata> createClusterAsyncRequest =
          clusterControllerClient.createClusterAsync(projectId, region, cluster);
      Cluster response = createClusterAsyncRequest.get();

      // Print out a success message.
      System.out.printf("Cluster created successfully: %s", response.getClusterName());

    } catch (ExecutionException e) {
      // If cluster creation does not complete successfully, print the error message.
      System.err.println(String.format("createClusterWithAutoscaling: %s ", e.getMessage()));
    }
  }
}
// [END dataproc_create_autoscaling_cluster]
