/*
 * Copyright 2018 Google LLC
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

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
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

/** Tests for quickstart sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickStartIT {
  private static final String bucketName = "java-docs-samples-testing";
  private static final String path = UUID.randomUUID().toString();
  private static final String datasetName = RemoteBigQueryHelper.generateDatasetName();
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private BigQuery bigquery;

  private static final void deleteObjects() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    for (BlobInfo info :
        storage
            .list(
                bucketName,
                BlobListOption.versions(true),
                BlobListOption.currentDirectory(),
                BlobListOption.prefix(path + "/"))
            .getValues()) {
      storage.delete(info.getBlobId());
    }
  }

  @Before
  public void setUp() {
    bigquery = BigQueryOptions.getDefaultInstance().getService();
    if (bigquery.getDataset(datasetName) == null) {
      Dataset dataset = bigquery.create(DatasetInfo.newBuilder(datasetName).build());
    }
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
    deleteObjects();
    DatasetId datasetId = DatasetId.of(bigquery.getOptions().getProjectId(), datasetName);
    bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testExportAssetExample() throws Exception {
    String assetDumpPath = String.format("gs://%s/%s/my-assets-dump.txt", bucketName, path);
    ExportAssetsExample.main(assetDumpPath);
    String got = bout.toString();
    assertThat(got).contains(String.format("uri: \"%s\"", assetDumpPath));
  }

  @Test
  public void testExportAssetBigqueryExample() throws Exception {
    String dataset =
        String.format("projects/%s/datasets/%s", ServiceOptions.getDefaultProjectId(), datasetName);
    String table = "java_test";
    ExportAssetsBigqueryExample.exportBigQuery(dataset, table);
    String got = bout.toString();
    assertThat(got).contains(String.format("dataset: \"%s\"", dataset));
  }

  @Test
  public void testBatchGetAssetsHistory() throws Exception {
    // Wait 10 seconds to let bucket creation event go to CAI
    Thread.sleep(10000);
    String bucketAssetName = String.format("//storage.googleapis.com/%s", bucketName);
    BatchGetAssetsHistoryExample.main(bucketAssetName);
    String got = bout.toString();
    if (!got.isEmpty()) {
      assertThat(got).contains(bucketAssetName);
    }
  }
}
