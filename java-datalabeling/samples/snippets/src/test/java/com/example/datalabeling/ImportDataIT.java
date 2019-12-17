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
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDatasetsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest;
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

/**
 * Integration (system) tests for {@link ImportData}.
 */
@RunWith(JUnit4.class)
@Ignore("b/146064330")
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ImportDataIT {

  private ByteArrayOutputStream bout;

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String GCS_SOURCE_URI =
      "gs://cloud-samples-data/datalabeling/image/image_dataset.csv";
  private static String datasetName = "IMPORT_DATASET_NAME";

  private static Dataset dataset;

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));

    CreateDataset.createDataset(PROJECT_ID,datasetName);

    // Get the Dataset
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      ListDatasetsRequest listRequest = ListDatasetsRequest.newBuilder()
          .setParent(projectName.toString())
          .build();

      ListDatasetsPagedResponse response = dataLabelingServiceClient
          .listDatasets(listRequest);

      for (Dataset returnedDataset : response.getPage().iterateAll()) {
        if (returnedDataset.getDisplayName().equals("IMPORT_DATASET_NAME")) {
          dataset = returnedDataset;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();

    // Delete the Dataset
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      ListDatasetsRequest listRequest = ListDatasetsRequest.newBuilder()
          .setParent(projectName.toString())
          .build();

      ListDatasetsPagedResponse response = dataLabelingServiceClient
          .listDatasets(listRequest);

      for (Dataset returnedDataset : response.getPage().iterateAll()) {
        if (returnedDataset.getDisplayName().equals("IMPORT_DATASET_NAME")) {
          dataLabelingServiceClient.deleteDataset(returnedDataset.getName());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testImportDataset() throws IOException {
    ImportData.importData(dataset.getName(), GCS_SOURCE_URI);

    String output = bout.toString();

    assertThat(output, CoreMatchers.containsString("Imported items: 3"));
  }
}
