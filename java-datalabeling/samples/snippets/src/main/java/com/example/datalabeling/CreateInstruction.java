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

// [START datalabeling_create_instruction_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionMetadata;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceSettings;
import com.google.cloud.datalabeling.v1beta1.DataType;
import com.google.cloud.datalabeling.v1beta1.Instruction;
import com.google.cloud.datalabeling.v1beta1.PdfInstruction;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class CreateInstruction {

  // Create a instruction for a dataset.
  static void createInstruction(String projectId, String pdfUri) throws IOException {
    // String projectId = "YOUR_PROJECT_ID";
    // String pdfUri = "gs://YOUR_BUCKET_ID/path_to_pdf_or_csv";

    // [END datalabeling_create_instruction_beta]
    String endpoint = System.getenv("DATALABELING_ENDPOINT");
    if (endpoint == null) {
      endpoint = DataLabelingServiceSettings.getDefaultEndpoint();
    }
    // [START datalabeling_create_instruction_beta]

    DataLabelingServiceSettings settings = DataLabelingServiceSettings
        .newBuilder()
        // [END datalabeling_create_instruction_beta]
        .setEndpoint(endpoint)
        // [START datalabeling_create_instruction_beta]
        .build();
    try (DataLabelingServiceClient dataLabelingServiceClient =
             DataLabelingServiceClient.create(settings)) {
      ProjectName projectName = ProjectName.of(projectId);

      // There are two types of instructions: CSV (CsvInstruction) or PDF (PdfInstruction)
      PdfInstruction pdfInstruction = PdfInstruction.newBuilder()
          .setGcsFileUri(pdfUri)
          .build();

      Instruction instruction = Instruction.newBuilder()
          .setDisplayName("YOUR_INSTRUCTION_DISPLAY_NAME")
          .setDescription("YOUR_DESCRIPTION")
          .setDataType(DataType.IMAGE) // DataTypes: AUDIO, IMAGE, VIDEO, TEXT
          .setPdfInstruction(pdfInstruction)  // .setCsvInstruction() or .setPdfInstruction()
          .build();

      CreateInstructionRequest createInstructionRequest = CreateInstructionRequest.newBuilder()
          .setInstruction(instruction)
          .setParent(projectName.toString())
          .build();

      OperationFuture<Instruction, CreateInstructionMetadata> operation =
          dataLabelingServiceClient.createInstructionAsync(createInstructionRequest);

      Instruction result = operation.get();

      System.out.format("Name: %s\n", result.getName());
      System.out.format("DisplayName: %s\n", result.getDisplayName());
      System.out.format("Description: %s\n", result.getDescription());
      System.out.format("GCS SOURCE URI: %s\n", result.getPdfInstruction().getGcsFileUri());
    } catch (IOException | InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
// [END datalabeling_create_instruction_beta]
