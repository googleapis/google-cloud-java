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

package aiplatform;

// [START aiplatform_create_hyperparameter_tuning_job_sample]
import com.google.cloud.aiplatform.v1.AcceleratorType;
import com.google.cloud.aiplatform.v1.ContainerSpec;
import com.google.cloud.aiplatform.v1.CustomJobSpec;
import com.google.cloud.aiplatform.v1.HyperparameterTuningJob;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.MachineSpec;
import com.google.cloud.aiplatform.v1.StudySpec;
import com.google.cloud.aiplatform.v1.WorkerPoolSpec;
import java.io.IOException;

public class CreateHyperparameterTuningJobSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String containerImageUri = "CONTAINER_IMAGE_URI";
    createHyperparameterTuningJobSample(project, displayName, containerImageUri);
  }

  static void createHyperparameterTuningJobSample(
      String project, String displayName, String containerImageUri) throws IOException {
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient client = JobServiceClient.create(settings)) {
      StudySpec.MetricSpec metric0 =
          StudySpec.MetricSpec.newBuilder()
              .setMetricId("accuracy")
              .setGoal(StudySpec.MetricSpec.GoalType.MAXIMIZE)
              .build();
      StudySpec.ParameterSpec.DoubleValueSpec doubleValueSpec =
          StudySpec.ParameterSpec.DoubleValueSpec.newBuilder()
              .setMinValue(0.001)
              .setMaxValue(0.1)
              .build();
      StudySpec.ParameterSpec parameter0 =
          StudySpec.ParameterSpec.newBuilder()
              // Learning rate.
              .setParameterId("lr")
              .setDoubleValueSpec(doubleValueSpec)
              .build();
      StudySpec studySpec =
          StudySpec.newBuilder().addMetrics(metric0).addParameters(parameter0).build();
      MachineSpec machineSpec =
          MachineSpec.newBuilder()
              .setMachineType("n1-standard-4")
              .setAcceleratorType(AcceleratorType.NVIDIA_TESLA_K80)
              .setAcceleratorCount(1)
              .build();
      ContainerSpec containerSpec =
          ContainerSpec.newBuilder().setImageUri(containerImageUri).build();
      WorkerPoolSpec workerPoolSpec0 =
          WorkerPoolSpec.newBuilder()
              .setMachineSpec(machineSpec)
              .setReplicaCount(1)
              .setContainerSpec(containerSpec)
              .build();
      CustomJobSpec trialJobSpec =
          CustomJobSpec.newBuilder().addWorkerPoolSpecs(workerPoolSpec0).build();
      HyperparameterTuningJob hyperparameterTuningJob =
          HyperparameterTuningJob.newBuilder()
              .setDisplayName(displayName)
              .setMaxTrialCount(2)
              .setParallelTrialCount(1)
              .setMaxFailedTrialCount(1)
              .setStudySpec(studySpec)
              .setTrialJobSpec(trialJobSpec)
              .build();
      LocationName parent = LocationName.of(project, location);
      HyperparameterTuningJob response =
          client.createHyperparameterTuningJob(parent, hyperparameterTuningJob);
      System.out.format("response: %s\n", response);
      System.out.format("Name: %s\n", response.getName());
    }
  }
}

// [END aiplatform_create_hyperparameter_tuning_job_sample]
