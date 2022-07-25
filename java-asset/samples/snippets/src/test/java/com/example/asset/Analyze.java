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

package com.example.asset;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for search samples. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class Analyze {

  private static final String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String scope = "projects/" + projectId;
  private static final String fullResourceName =
      "//cloudresourcemanager.googleapis.com/projects/" + projectId;

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final void deleteObjects(String bucketName, String objectName) {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Iterable<Blob> blobs =
        storage
            .list(
                bucketName,
                BlobListOption.versions(true),
                BlobListOption.currentDirectory(),
                BlobListOption.prefix(objectName))
            .getValues();
    for (BlobInfo info : blobs) {
      storage.delete(info.getBlobId());
    }
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testAnalyzeIamPolicyExample() throws Exception {
    AnalyzeIamPolicyExample.analyzeIamPolicy(scope, fullResourceName);
    String got = bout.toString();
    assertThat(got).contains(fullResourceName);
  }

  @Test
  public void testAnalyzeIamPolicyLongrunningBigQueryExample() throws Exception {
    String datasetName = RemoteBigQueryHelper.generateDatasetName();
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    if (bigquery.getDataset(datasetName) == null) {
      bigquery.create(DatasetInfo.newBuilder(datasetName).build());
    }

    String dataset = "projects/" + projectId + "/datasets/" + datasetName;
    String tablePrefix = "client_library_table";
    AnalyzeIamPolicyLongrunningBigqueryExample.analyzeIamPolicyLongrunning(
        scope, fullResourceName, dataset, tablePrefix);
    String got = bout.toString();
    assertThat(got).contains("output_config");

    DatasetId datasetId = DatasetId.of(bigquery.getOptions().getProjectId(), datasetName);
    bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testAnalyzeIamPolicyLongrunningGcsExample() throws Exception {
    // The developer needs to have bucket create permission or use an exsiting bucket.
    String bucketName = "java-docs-samples-testing";
    String objectName = UUID.randomUUID().toString();

    String uri = "gs://" + bucketName + "/" + objectName;
    AnalyzeIamPolicyLongrunningGcsExample.analyzeIamPolicyLongrunning(scope, fullResourceName, uri);
    String got = bout.toString();
    assertThat(got).contains("output_config");

    deleteObjects(bucketName, objectName);
  }
}
