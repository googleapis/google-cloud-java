/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

// [START aiplatform_create_data_labeling_job_image_sample]

import com.google.cloud.aiplatform.v1beta1.DataLabelingJob;
import com.google.cloud.aiplatform.v1beta1.DatasetName;
import com.google.cloud.aiplatform.v1beta1.JobServiceClient;
import com.google.cloud.aiplatform.v1beta1.JobServiceSettings;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import com.google.type.Money;
import java.io.IOException;
import java.util.Map;

public class CreateDataLabelingJobImageSample {
  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String displayName = "YOUR_DATA_LABELING_DISPLAY_NAME";
    String datasetId = "YOUR_DATASET_ID";
    String instructionUri =
        "gs://YOUR_GCS_SOURCE_BUCKET/path_to_your_data_labeling_source/file.pdf";
    String annotationSpec = "YOUR_ANNOTATION_SPEC";
    createDataLabelingJobImage(project, displayName, datasetId, instructionUri, annotationSpec);
  }

  static void createDataLabelingJobImage(
      String project,
      String displayName,
      String datasetId,
      String instructionUri,
      String annotationSpec)
      throws IOException {
    JobServiceSettings jobServiceSettings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient jobServiceClient = JobServiceClient.create(jobServiceSettings)) {
      String location = "us-central1";
      LocationName locationName = LocationName.of(project, location);

      String jsonString = "{\"annotation_specs\": [ " + annotationSpec + "]}";
      Value.Builder annotationSpecValue = Value.newBuilder();
      JsonFormat.parser().merge(jsonString, annotationSpecValue);

      DatasetName datasetName = DatasetName.of(project, location, datasetId);
      DataLabelingJob dataLabelingJob =
          DataLabelingJob.newBuilder()
              .setDisplayName(displayName)
              .setLabelerCount(1)
              .setInstructionUri(instructionUri)
              .setInputsSchemaUri(
                  "gs://google-cloud-aiplatform/schema/datalabelingjob/inputs/"
                      + "image_classification.yaml")
              .addDatasets(datasetName.toString())
              .setInputs(annotationSpecValue)
              .putAnnotationLabels(
                  "aiplatform.googleapis.com/annotation_set_name", "my_test_saved_query")
              .build();

      DataLabelingJob dataLabelingJobResponse =
          jobServiceClient.createDataLabelingJob(locationName, dataLabelingJob);

      System.out.println("Create Data Labeling Job Image Response");
      System.out.format("\tName: %s\n", dataLabelingJobResponse.getName());
      System.out.format("\tDisplay Name: %s\n", dataLabelingJobResponse.getDisplayName());
      System.out.format("\tDatasets: %s\n", dataLabelingJobResponse.getDatasetsList());
      System.out.format("\tLabeler Count: %s\n", dataLabelingJobResponse.getLabelerCount());
      System.out.format("\tInstruction Uri: %s\n", dataLabelingJobResponse.getInstructionUri());
      System.out.format("\tInputs Schema Uri: %s\n", dataLabelingJobResponse.getInputsSchemaUri());
      System.out.format("\tInputs: %s\n", dataLabelingJobResponse.getInputs());
      System.out.format("\tState: %s\n", dataLabelingJobResponse.getState());
      System.out.format("\tLabeling Progress: %s\n", dataLabelingJobResponse.getLabelingProgress());
      System.out.format("\tCreate Time: %s\n", dataLabelingJobResponse.getCreateTime());
      System.out.format("\tUpdate Time: %s\n", dataLabelingJobResponse.getUpdateTime());
      System.out.format("\tLabels: %s\n", dataLabelingJobResponse.getLabelsMap());
      System.out.format(
          "\tSpecialist Pools: %s\n", dataLabelingJobResponse.getSpecialistPoolsList());
      for (Map.Entry<String, String> annotationLabelMap :
          dataLabelingJobResponse.getAnnotationLabelsMap().entrySet()) {
        System.out.println("\tAnnotation Level");
        System.out.format("\t\tkey: %s\n", annotationLabelMap.getKey());
        System.out.format("\t\tvalue: %s\n", annotationLabelMap.getValue());
      }
      Money money = dataLabelingJobResponse.getCurrentSpend();

      System.out.println("\tCurrent Spend");
      System.out.format("\t\tCurrency Code: %s\n", money.getCurrencyCode());
      System.out.format("\t\tUnits: %s\n", money.getUnits());
      System.out.format("\t\tNanos: %s\n", money.getNanos());
    }
  }
}
// [END aiplatform_create_data_labeling_job_image_sample]
