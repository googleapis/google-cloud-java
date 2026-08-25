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

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpec;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSetName;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceSettings;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.DatasetName;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
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
  private static final String DATASET_PREFIX = "test_dataset_";
  private static final String ANNOTATION_SPEC_SET_PREFIX = "test_annotationSpecSet_";
  private static final String RUN_ID =
      System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8);
  private static final String DATASET_DISPLAY_NAME = DATASET_PREFIX + RUN_ID;
  private static final String ANNOTATION_SPEC_SET = ANNOTATION_SPEC_SET_PREFIX + RUN_ID;
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
    DataLabelingServiceSettings.Builder settingsBuilder = DataLabelingServiceSettings.newBuilder();

    // Resource creation RPCs (createDataset, createAnnotationSpecSet) are non-idempotent by default
    // and generated with no retryable codes under AIP-194. However, live integration tests running
    // against backend services occasionally encounter transient 502 Bad Gateway / UNAVAILABLE
    // proxy errors from GFE/Envoy during cold starts or backend resets. We configure custom
    // RetrySettings with backoff for test resilience, paired with unique display names and
    // comprehensive project sweeps in @AfterClass and @BeforeClass to avoid leaking resources.
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(2))
            .setRetryDelayMultiplier(1.5)
            .setMaxRetryDelayDuration(Duration.ofSeconds(10))
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(30))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
            .setTotalTimeoutDuration(Duration.ofMinutes(2))
            .build();
    Set<StatusCode.Code> retryableCodes =
        ImmutableSet.of(StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED);

    settingsBuilder
        .createDatasetSettings()
        .setRetryableCodes(retryableCodes)
        .setRetrySettings(retrySettings);

    settingsBuilder
        .createAnnotationSpecSetSettings()
        .setRetryableCodes(retryableCodes)
        .setRetrySettings(retrySettings);

    client = DataLabelingServiceClient.create(settingsBuilder.build());

    // Clean up any stale resources older than 24 hours from previous crashed or interrupted test
    // runs
    Instant cutoff = Instant.now().minus(Duration.ofHours(24));
    cleanUpDatasets(client, cutoff);
    cleanUpAnnotationSpecSets(client, cutoff);

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
  public static void afterClass() throws Exception {
    if (client != null) {
      // Clean up current run resources as well as any resources older than 24 hours
      Instant cutoff = Instant.now().minus(Duration.ofHours(24));
      cleanUpDatasets(client, cutoff);
      cleanUpAnnotationSpecSets(client, cutoff);

      client.close();
      client.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  /**
   * Sweeps datasets in the GCP project. Deletes resources created by the current test run (matching
   * {@code DATASET_DISPLAY_NAME}) as well as stale datasets older than the 24-hour cutoff (or
   * legacy datasets without valid creation timestamps) from previous crashed or aborted test runs.
   */
  private static void cleanUpDatasets(DataLabelingServiceClient client, Instant cutoff) {
    try {
      for (Dataset dataset : client.listDatasets(PARENT, "").iterateAll()) {
        boolean isCurrentRun = DATASET_DISPLAY_NAME.equals(dataset.getDisplayName());
        boolean isStale = false;
        if (dataset.getDisplayName().startsWith(DATASET_PREFIX)) {
          if (dataset.hasCreateTime()) {
            Instant createTime =
                Instant.ofEpochSecond(
                    dataset.getCreateTime().getSeconds(), dataset.getCreateTime().getNanos());
            isStale = createTime.isBefore(cutoff);
          } else {
            // If creation timestamp is missing, assume it is a legacy resource and mark for cleanup
            isStale = true;
          }
        }
        if (isCurrentRun || isStale) {
          try {
            client.deleteDataset(dataset.getName());
          } catch (Exception e) {
            LOGGER.warning("Failed to delete Dataset " + dataset.getName() + ": " + e.getMessage());
          }
        }
      }
    } catch (Exception e) {
      LOGGER.warning("Failed to sweep datasets: " + e.getMessage());
    }
  }

  /**
   * Sweeps annotation spec sets in the GCP project. Deletes resources created by the current test
   * run (matching {@code ANNOTATION_SPEC_SET}) as well as stale annotation spec sets older than the
   * 24-hour cutoff (or legacy sets that do not conform to the timestamped naming format) from
   * previous crashed or aborted test runs.
   */
  private static void cleanUpAnnotationSpecSets(DataLabelingServiceClient client, Instant cutoff) {
    try {
      for (AnnotationSpecSet specSet : client.listAnnotationSpecSets(PARENT, "").iterateAll()) {
        boolean isCurrentRun = ANNOTATION_SPEC_SET.equals(specSet.getDisplayName());
        boolean isStale = false;
        if (specSet.getDisplayName().startsWith(ANNOTATION_SPEC_SET_PREFIX)) {
          String[] parts = specSet.getDisplayName().split("_");
          // Format: test_annotationSpecSet_<timestamp>_<uuid>
          if (parts.length >= 3) {
            try {
              long timestamp = Long.parseLong(parts[2]);
              isStale = Instant.ofEpochMilli(timestamp).isBefore(cutoff);
            } catch (NumberFormatException e) {
              // If the timestamp part is non-numeric, assume legacy resource and mark for cleanup
              isStale = true;
            }
          } else {
            // If the name does not match the timestamped format, assume legacy resource and mark
            // for cleanup
            isStale = true;
          }
        }
        if (isCurrentRun || isStale) {
          try {
            client.deleteAnnotationSpecSet(specSet.getName());
          } catch (Exception e) {
            LOGGER.warning(
                "Failed to delete AnnotationSpecSet " + specSet.getName() + ": " + e.getMessage());
          }
        }
      }
    } catch (Exception e) {
      LOGGER.warning("Failed to sweep annotationSpecSets: " + e.getMessage());
    }
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
