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

import static org.junit.Assert.assertThat;

import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListInstructionsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.Instruction;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreateInstruction}. */
@RunWith(JUnit4.class)
@Ignore("b/146064330")
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateInstructionIT {

  private ByteArrayOutputStream bout;

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String GCS_SOURCE_URI =
      "gs://cloud-samples-data/datalabeling/instruction/test.pdf";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();

    // Delete the Instruction
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      ListInstructionsRequest listRequest =
          ListInstructionsRequest.newBuilder().setParent(projectName.toString()).build();

      ListInstructionsPagedResponse response =
          dataLabelingServiceClient.listInstructions(listRequest);

      for (Instruction instruction : response.getPage().iterateAll()) {
        if (instruction.getDisplayName().equals("YOUR_INSTRUCTION_DISPLAY_NAME")) {
          dataLabelingServiceClient.deleteInstruction(instruction.getName());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCreateInstruction() throws IOException {
    CreateInstruction.createInstruction(PROJECT_ID, GCS_SOURCE_URI);

    String output = bout.toString();

    assertThat(output, CoreMatchers.containsString("DisplayName: YOUR_INSTRUCTION_DISPLAY_NAME"));
    assertThat(output, CoreMatchers.containsString("Description: YOUR_DESCRIPTION"));
    assertThat(
        output, CoreMatchers.containsString(String.format("GCS SOURCE URI: %s", GCS_SOURCE_URI)));
  }
}
