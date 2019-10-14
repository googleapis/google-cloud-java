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

package com.google.cloud.datalabeling.v1beta1.it;

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
  private static Dataset dataset;
  private static String projectId;
  private static String parent;
  private static String dataSetId;
  private static String annotationSpecSetId;

  private static final Logger LOGGER = Logger.getLogger(ITSystemTest.class.getName());
  private static final String DATASET_DISPLAY_NAME = "test_dataset_" + UUID.randomUUID();
  private static final String ANNOTATION_SPEC_SET = "test_annotationSpecSet_" + UUID.randomUUID();
  private static final String LABEL_1 = "label_1";
  private static final String LABEL_2 = "label_2";
  private static final String DESCRIPTION = "test_description";
  private static final String DESCRIPTION1 = "test_description_1";
  private static final String DESCRIPTION2 = "test_description_2";

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = DataLabelingServiceClient.create();
    projectId = ServiceOptions.getDefaultProjectId();
    parent = ProjectName.format(projectId);

    /** create Dataset */
    dataset =
        Dataset.newBuilder()
            .setDisplayName(DATASET_DISPLAY_NAME)
            .setDescription(DESCRIPTION)
            .build();
    Dataset dataSetResponse = client.createDataset(parent, dataset);
    dataSetId = dataSetResponse.getName().split("/")[3];
    LOGGER.info("dataset created successfully.");

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
    AnnotationSpecSet response = client.createAnnotationSpecSet(parent, annotationSpecSet);
    annotationSpecSetId = response.getName().split("/")[3];
    LOGGER.info("AnnotationSpecSet created successfully.");
  }

  @AfterClass
  public static void afterClass() {
    String annotationSpecSetName = AnnotationSpecSetName.format(projectId, annotationSpecSetId);
    client.deleteAnnotationSpecSet(annotationSpecSetName);
    LOGGER.info("annotationSpecSetName deleted successfully.");

    String dataSet = DatasetName.format(projectId, dataSetId);
    client.deleteDataset(dataSet);
    LOGGER.info("dataset deleted successfully.");

    client.close();
  }

  @Test
  public void getDatasetTest() throws Exception {
    String dataset = DatasetName.format(projectId, dataSetId);
    Dataset response = client.getDataset(dataset);
    assertEquals(DATASET_DISPLAY_NAME, response.getDisplayName());
    assertEquals(DESCRIPTION, response.getDescription());
  }

  @Test
  public void listDatasetsTest() {
    String filter = "";
    DataLabelingServiceClient.ListDatasetsPagedResponse pagedListResponse =
        client.listDatasets(parent, filter);
    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    assertEquals(1, resources.size());
  }

  @Test
  public void getAnnotationSpecSetTest() {
    String formattedName = AnnotationSpecSetName.format(projectId, annotationSpecSetId);
    AnnotationSpecSet response = client.getAnnotationSpecSet(formattedName);
    assertEquals(ANNOTATION_SPEC_SET, response.getDisplayName());
    assertEquals(DESCRIPTION, response.getDescription());
  }

  @Test
  public void listAnnotationSpecSetsTest() {
    String filter = "";
    DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse pagedListResponse =
        client.listAnnotationSpecSets(parent, filter);
    List<AnnotationSpecSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    assertEquals(1, resources.size());
  }
}
