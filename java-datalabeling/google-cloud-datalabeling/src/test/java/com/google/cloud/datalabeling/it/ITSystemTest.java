/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datalabeling.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpec;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSetName;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.DatasetName;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static DataLabelingServiceClient client;
  private static String dataSetId;
  private static String annotationSpecSetId;

  private static final Logger LOGGER = Logger.getLogger(ITSystemTest.class.getName());
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String DATASET_DISPLAY_NAME = "test_dataset_" + UUID.randomUUID();
  private static final String ANNOTATION_SPEC_SET = "test_annotationSpecSet_" + UUID.randomUUID();
  private static final String LABEL_1 = "label_1";
  private static final String LABEL_2 = "label_2";
  private static final String DESCRIPTION = "test_description";
  private static final String DESCRIPTION1 = "test_description_1";
  private static final String DESCRIPTION2 = "test_description_2";

  private static final String PARENT = ProjectName.format(PROJECT_ID);
  private static final Dataset DATASET =
      Dataset.newBuilder().setDisplayName(DATASET_DISPLAY_NAME).setDescription(DESCRIPTION).build();

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = DataLabelingServiceClient.create();

    /** create Dataset */
    Dataset dataSetResponse = client.createDataset(PARENT, DATASET);
    dataSetId = dataSetResponse.getName().split("/")[3];
    LOGGER.info("Dataset created successfully.");

    /** create AnnotationSpecSet */
    Map<String, String> annotationLabels = new HashMap<>();
    annotationLabels.put(LABEL_1, DESCRIPTION1);
    annotationLabels.put(LABEL_2, DESCRIPTION2);

    List<AnnotationSpec> annotationSpecs = new ArrayList<>();
    for (Map.Entry<String, String> entry : annotationLabels.entrySet()) {
      AnnotationSpec annotationSpec =
          AnnotationSpec.newBuilder()
              .setDisplayName(entry.getKey())
              .setDescription(entry.getValue())
              .build();
      annotationSpecs.add(annotationSpec);
    }
    AnnotationSpecSet annotationSpecSet =
        AnnotationSpecSet.newBuilder()
            .setDisplayName(ANNOTATION_SPEC_SET)
            .setDescription(DESCRIPTION)
            .addAllAnnotationSpecs(annotationSpecs)
            .build();
    AnnotationSpecSet response = client.createAnnotationSpecSet(PARENT, annotationSpecSet);
    annotationSpecSetId = response.getName().split("/")[3];
    LOGGER.info("AnnotationSpecSet created successfully.");
  }

  @AfterClass
  public static void afterClass() {
    if (annotationSpecSetId != null) {
      String annotationSpecSetName = AnnotationSpecSetName.format(PROJECT_ID, annotationSpecSetId);
      client.deleteAnnotationSpecSet(annotationSpecSetName);
      LOGGER.info("AnnotationSpecSet deleted successfully.");
    }
    if (dataSetId != null) {
      String dataSet = DatasetName.format(PROJECT_ID, dataSetId);
      client.deleteDataset(dataSet);
      LOGGER.info("Dataset deleted successfully.");
    }
    client.close();
  }

  @Test
  public void getDatasetTest() {
    String dataset = DatasetName.format(PROJECT_ID, dataSetId);
    Dataset response = client.getDataset(dataset);
    assertEquals(DATASET_DISPLAY_NAME, response.getDisplayName());
    assertEquals(DESCRIPTION, response.getDescription());
  }

  @Test
  public void listDatasetsTest() {
    String filter = "";
    DataLabelingServiceClient.ListDatasetsPagedResponse pagedListResponse =
        client.listDatasets(PARENT, filter);
    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    // This removal ensures that other integration tests on the same GCP project do not interfere.
    resources.removeIf(dataset -> !dataset.getName().split("/")[3].equals(dataSetId));

    assertEquals(1, resources.size());
  }

  @Test
  public void getAnnotationSpecSetTest() {
    String formattedName = AnnotationSpecSetName.format(PROJECT_ID, annotationSpecSetId);
    AnnotationSpecSet response = client.getAnnotationSpecSet(formattedName);
    assertEquals(ANNOTATION_SPEC_SET, response.getDisplayName());
    assertEquals(DESCRIPTION, response.getDescription());
  }

  @Test
  public void listAnnotationSpecSetsTest() {
    String filter = "";
    DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse pagedListResponse =
        client.listAnnotationSpecSets(PARENT, filter);
    List<AnnotationSpecSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    // This removal ensures that other integration tests on the same GCP project do not interfere.
    resources.removeIf(
        annotationSpecSet ->
            !annotationSpecSet.getName().split("/")[3].equals(annotationSpecSetId));

    assertEquals(1, resources.size());
  }
}
