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

import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDatasetsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListInstructionsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.DataType;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.GcsSource;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ImportDataRequest;
import com.google.cloud.datalabeling.v1beta1.InputConfig;
import com.google.cloud.datalabeling.v1beta1.Instruction;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link LabelText}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class LabelTextIT {
  private static String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  private static String DATASET_GCS_SOURCE_URI =
      "gs://cloud-samples-data/datalabeling/text/text_dataset.csv";
  private static String INSTRUCTION_GCS_SOURCE_URI =
      "gs://cloud-samples-data/datalabeling/instruction/test.pdf";
  private static String datasetName = "LABEL_TEXT_DATASET_NAME";
  private Dataset dataset;
  private Instruction instruction;
  private AnnotationSpecSet annotationSpecSet;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));

    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      // Create the dataset
      CreateDataset.createDataset(PROJECT_ID, datasetName);
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      // Get the Dataset
      ListDatasetsRequest datasetsRequest =
          ListDatasetsRequest.newBuilder().setParent(projectName.toString()).build();
      ListDatasetsPagedResponse datasetsResponse =
          dataLabelingServiceClient.listDatasets(datasetsRequest);
      for (Dataset returnedDataset : datasetsResponse.getPage().iterateAll()) {
        if (returnedDataset.getDisplayName().equals("LABEL_TEXT_DATASET_NAME")) {
          dataset = returnedDataset;
        }
      }

      // Import the texts
      GcsSource gcsSource =
          GcsSource.newBuilder()
              .setInputUri(DATASET_GCS_SOURCE_URI)
              .setMimeType("text/csv")
              .build();

      InputConfig inputConfig =
          InputConfig.newBuilder()
              .setDataType(DataType.TEXT) // DataTypes: AUDIO, IMAGE, VIDEO, TEXT
              .setGcsSource(gcsSource)
              .build();

      ImportDataRequest importDataRequest =
          ImportDataRequest.newBuilder()
              .setName(dataset.getName())
              .setInputConfig(inputConfig)
              .build();

      ImportDataOperationResponse response =
          dataLabelingServiceClient.importDataAsync(importDataRequest).get();
      System.out.format("Imported items: %d\n", response.getImportCount());

      // Create the instruction
      CreateInstruction.createInstruction(PROJECT_ID, INSTRUCTION_GCS_SOURCE_URI);

      // Create the annotation spec set
      CreateAnnotationSpecSet.createAnnotationSpecSet(PROJECT_ID);

      // Get the instruction
      ListInstructionsRequest instructionsRequest =
          ListInstructionsRequest.newBuilder().setParent(projectName.toString()).build();
      ListInstructionsPagedResponse instructionsResponse =
          dataLabelingServiceClient.listInstructions(instructionsRequest);
      for (Instruction returnedInstruction : instructionsResponse.getPage().iterateAll()) {
        if (returnedInstruction.getDisplayName().equals("YOUR_INSTRUCTION_DISPLAY_NAME")) {
          instruction = returnedInstruction;
        }
      }

      // Get the annotation spec set
      ListAnnotationSpecSetsRequest annotationRequest =
          ListAnnotationSpecSetsRequest.newBuilder().setParent(projectName.toString()).build();
      ListAnnotationSpecSetsPagedResponse annotationsResponse =
          dataLabelingServiceClient.listAnnotationSpecSets(annotationRequest);
      for (AnnotationSpecSet returnedAnnotation : annotationsResponse.getPage().iterateAll()) {
        if (returnedAnnotation.getDisplayName().equals("YOUR_ANNOTATION_SPEC_SET_DISPLAY_NAME")) {
          annotationSpecSet = returnedAnnotation;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @After
  public void tearDown() {
    System.setOut(null);

    // Delete the created dataset.
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      dataLabelingServiceClient.deleteDataset(dataset.getName());
      dataLabelingServiceClient.deleteInstruction(instruction.getName());
      dataLabelingServiceClient.deleteAnnotationSpecSet(annotationSpecSet.getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testLabelText() {
    // Start the labeling task
    LabelText.labelText(instruction.getName(), annotationSpecSet.getName(), dataset.getName());
  }
}
