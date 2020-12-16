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

// [START aiplatform_create_hyperparameter_tuning_job_python_package_sample]
import com.google.cloud.aiplatform.v1beta1.AcceleratorType;
import com.google.cloud.aiplatform.v1beta1.CustomJobSpec;
import com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob;
import com.google.cloud.aiplatform.v1beta1.JobServiceClient;
import com.google.cloud.aiplatform.v1beta1.JobServiceSettings;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.MachineSpec;
import com.google.cloud.aiplatform.v1beta1.PythonPackageSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.MetricSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.MetricSpec.GoalType;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec.ConditionalParameterSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec.ConditionalParameterSpec.DiscreteValueCondition;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec.DiscreteValueSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec.DoubleValueSpec;
import com.google.cloud.aiplatform.v1beta1.StudySpec.ParameterSpec.ScaleType;
import com.google.cloud.aiplatform.v1beta1.WorkerPoolSpec;
import java.io.IOException;
import java.util.Arrays;

public class CreateHyperparameterTuningJobPythonPackageSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String executorImageUri = "EXECUTOR_IMAGE_URI";
    String packageUri = "PACKAGE_URI";
    String pythonModule = "PYTHON_MODULE";
    createHyperparameterTuningJobPythonPackageSample(
        project, displayName, executorImageUri, packageUri, pythonModule);
  }

  static void createHyperparameterTuningJobPythonPackageSample(
      String project,
      String displayName,
      String executorImageUri,
      String packageUri,
      String pythonModule)
      throws IOException {
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient client = JobServiceClient.create(settings)) {
      // study spec
      MetricSpec metric =
          MetricSpec.newBuilder().setMetricId("val_rmse").setGoal(GoalType.MINIMIZE).build();

      // decay
      DoubleValueSpec doubleValueSpec =
          DoubleValueSpec.newBuilder().setMinValue(1e-07).setMaxValue(1).build();
      ParameterSpec parameterDecaySpec =
          ParameterSpec.newBuilder()
              .setParameterId("decay")
              .setDoubleValueSpec(doubleValueSpec)
              .setScaleType(ScaleType.UNIT_LINEAR_SCALE)
              .build();
      Double[] decayValues = {32.0, 64.0};
      DiscreteValueCondition discreteValueDecay =
          DiscreteValueCondition.newBuilder().addAllValues(Arrays.asList(decayValues)).build();
      ConditionalParameterSpec conditionalParameterDecay =
          ConditionalParameterSpec.newBuilder()
              .setParameterSpec(parameterDecaySpec)
              .setParentDiscreteValues(discreteValueDecay)
              .build();

      // learning rate
      ParameterSpec parameterLearningSpec =
          ParameterSpec.newBuilder()
              .setParameterId("learning_rate")
              .setDoubleValueSpec(doubleValueSpec) // Use the same min/max as for decay
              .setScaleType(ScaleType.UNIT_LINEAR_SCALE)
              .build();

      Double[] learningRateValues = {4.0, 8.0, 16.0};
      DiscreteValueCondition discreteValueLearning =
          DiscreteValueCondition.newBuilder()
              .addAllValues(Arrays.asList(learningRateValues))
              .build();
      ConditionalParameterSpec conditionalParameterLearning =
          ConditionalParameterSpec.newBuilder()
              .setParameterSpec(parameterLearningSpec)
              .setParentDiscreteValues(discreteValueLearning)
              .build();

      // batch size
      Double[] batchSizeValues = {4.0, 8.0, 16.0, 32.0, 64.0, 128.0};

      DiscreteValueSpec discreteValueSpec =
          DiscreteValueSpec.newBuilder().addAllValues(Arrays.asList(batchSizeValues)).build();
      ParameterSpec parameter =
          ParameterSpec.newBuilder()
              .setParameterId("batch_size")
              .setDiscreteValueSpec(discreteValueSpec)
              .setScaleType(ScaleType.UNIT_LINEAR_SCALE)
              .addConditionalParameterSpecs(conditionalParameterDecay)
              .addConditionalParameterSpecs(conditionalParameterLearning)
              .build();

      // trial_job_spec
      MachineSpec machineSpec =
          MachineSpec.newBuilder()
              .setMachineType("n1-standard-4")
              .setAcceleratorType(AcceleratorType.NVIDIA_TESLA_K80)
              .setAcceleratorCount(1)
              .build();

      PythonPackageSpec pythonPackageSpec =
          PythonPackageSpec.newBuilder()
              .setExecutorImageUri(executorImageUri)
              .addPackageUris(packageUri)
              .setPythonModule(pythonModule)
              .build();

      WorkerPoolSpec workerPoolSpec =
          WorkerPoolSpec.newBuilder()
              .setMachineSpec(machineSpec)
              .setReplicaCount(1)
              .setPythonPackageSpec(pythonPackageSpec)
              .build();

      StudySpec studySpec =
          StudySpec.newBuilder()
              .addMetrics(metric)
              .addParameters(parameter)
              .setAlgorithm(StudySpec.Algorithm.RANDOM_SEARCH)
              .build();
      CustomJobSpec trialJobSpec =
          CustomJobSpec.newBuilder().addWorkerPoolSpecs(workerPoolSpec).build();
      // hyperparameter_tuning_job
      HyperparameterTuningJob hyperparameterTuningJob =
          HyperparameterTuningJob.newBuilder()
              .setDisplayName(displayName)
              .setMaxTrialCount(4)
              .setParallelTrialCount(2)
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

// [END aiplatform_create_hyperparameter_tuning_job_python_package_sample]
