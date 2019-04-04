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

package com.example.datalabeling;

// [START datalabeling_label_text_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.AnnotatedDataset;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.HumanAnnotationConfig;
import com.google.cloud.datalabeling.v1beta1.LabelOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.LabelTextRequest;
import com.google.cloud.datalabeling.v1beta1.LabelTextRequest.Feature;
import com.google.cloud.datalabeling.v1beta1.SentimentConfig;
import com.google.cloud.datalabeling.v1beta1.TextClassificationConfig;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class LabelText {

  // Start a Text Labeling Task
  static void labelText(
      String formattedInstructionName,
      String formattedAnnotationSpecSetName,
      String formattedDatasetName) {
    // String formattedInstructionName = DataLabelingServiceClient.formatInstructionName(
    //      "YOUR_PROJECT_ID", "YOUR_INSTRUCTION_UUID");
    // String formattedAnnotationSpecSetName =
    //     DataLabelingServiceClient.formatAnnotationSpecSetName(
    //         "YOUR_PROJECT_ID", "YOUR_ANNOTATION_SPEC_SET_UUID");
    // String formattedDatasetName = DataLabelingServiceClient.formatDatasetName(
    //      "YOUR_PROJECT_ID", "YOUR_DATASET_UUID");

    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {

      HumanAnnotationConfig humanAnnotationConfig =
          HumanAnnotationConfig.newBuilder()
              .setAnnotatedDatasetDisplayName("annotated_displayname")
              .setAnnotatedDatasetDescription("annotated_description")
              .setLanguageCode("en-us")
              .setInstruction(formattedInstructionName)
              .build();

      SentimentConfig sentimentConfig =
          SentimentConfig.newBuilder().setEnableLabelSentimentSelection(false).build();

      TextClassificationConfig textClassificationConfig =
          TextClassificationConfig.newBuilder()
              .setAnnotationSpecSet(formattedAnnotationSpecSetName)
              .setSentimentConfig(sentimentConfig)
              .build();

      LabelTextRequest labelTextRequest =
          LabelTextRequest.newBuilder()
              .setParent(formattedDatasetName)
              .setBasicConfig(humanAnnotationConfig)
              .setTextClassificationConfig(textClassificationConfig)
              .setFeature(Feature.TEXT_CLASSIFICATION)
              .build();

      OperationFuture<AnnotatedDataset, LabelOperationMetadata> operation =
          dataLabelingServiceClient.labelTextAsync(labelTextRequest);

      // You'll want to save this for later to retrieve your completed operation.
      // System.out.format("Operation Name: %s\n", operation.getName());

      // Cancel the operation to avoid charges when testing.
      dataLabelingServiceClient.getOperationsClient().cancelOperation(operation.getName());

    } catch (IOException | InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
// [END datalabeling_label_text_beta]
