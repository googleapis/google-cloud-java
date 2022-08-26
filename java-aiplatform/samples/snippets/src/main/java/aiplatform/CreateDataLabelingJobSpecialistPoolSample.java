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

// [START aiplatform_create_data_labeling_job_specialist_pool_sample]
import com.google.cloud.aiplatform.v1.DataLabelingJob;
import com.google.cloud.aiplatform.v1.DatasetName;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.SpecialistPoolName;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;

public class CreateDataLabelingJobSpecialistPoolSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String dataset = "DATASET";
    String specialistPool = "SPECIALIST_POOL";
    String instructionUri = "INSTRUCTION_URI";
    String inputsSchemaUri = "INPUTS_SCHEMA_URI";
    String annotationSpec = "ANNOTATION_SPEC";
    createDataLabelingJobSpecialistPoolSample(
        project,
        displayName,
        dataset,
        specialistPool,
        instructionUri,
        inputsSchemaUri,
        annotationSpec);
  }

  static void createDataLabelingJobSpecialistPoolSample(
      String project,
      String displayName,
      String dataset,
      String specialistPool,
      String instructionUri,
      String inputsSchemaUri,
      String annotationSpec)
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
      JsonArray jsonAnnotationSpecs = new JsonArray();
      jsonAnnotationSpecs.add(annotationSpec);
      JsonObject jsonInputs = new JsonObject();
      jsonInputs.add("annotation_specs", jsonAnnotationSpecs);
      Value.Builder inputsBuilder = Value.newBuilder();
      JsonFormat.parser().merge(jsonInputs.toString(), inputsBuilder);
      Value inputs = inputsBuilder.build();

      String datasetName = DatasetName.of(project, location, dataset).toString();
      String specialistPoolName =
          SpecialistPoolName.of(project, location, specialistPool).toString();

      DataLabelingJob dataLabelingJob =
          DataLabelingJob.newBuilder()
              .setDisplayName(displayName)
              .addDatasets(datasetName)
              .setLabelerCount(1)
              .setInstructionUri(instructionUri)
              .setInputsSchemaUri(inputsSchemaUri)
              .setInputs(inputs)
              .putAnnotationLabels(
                  "aiplatform.googleapis.com/annotation_set_name",
                  "data_labeling_job_specialist_pool")
              .addSpecialistPools(specialistPoolName)
              .build();
      LocationName parent = LocationName.of(project, location);
      DataLabelingJob response = client.createDataLabelingJob(parent, dataLabelingJob);
      System.out.format("response: %s\n", response);
    }
  }
}

// [END aiplatform_create_data_labeling_job_specialist_pool_sample]
