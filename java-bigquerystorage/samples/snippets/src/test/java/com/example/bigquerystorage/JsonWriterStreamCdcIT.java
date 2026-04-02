/*
 * Copyright 2023 Google LLC
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

package com.example.bigquerystorage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JsonWriterStreamCdcIT {

  private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private BigQuery bigquery;
  private String datasetName;

  @BeforeClass
  public static void beforeClass() {}

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    bigquery = BigQueryOptions.getDefaultInstance().getService();

    // Create a new dataset for each test.
    datasetName = "JAVA_WRITER_STREAM_CDC_TEST" + UUID.randomUUID().toString().substring(0, 8);
    bigquery.create(DatasetInfo.newBuilder(datasetName).build());
  }

  @Test
  public void testJsonWriterStreamCdc() throws Exception {
    Path newCustomersDataFilePath =
        FileSystems.getDefault().getPath("../snippets/src/test/resources", "NewCustomers.json");
    Path modifiedCustomersDataFilePath =
        FileSystems.getDefault()
            .getPath("../snippets/src/test/resources", "ModifiedCustomers.json");
    String[] args = {
      GOOGLE_CLOUD_PROJECT,
      datasetName,
      "customers",
      newCustomersDataFilePath.toAbsolutePath().toString(),
      modifiedCustomersDataFilePath.toAbsolutePath().toString()
    };

    JsonWriterStreamCdc.main(args);
    assertThat(bout.toString()).contains("Wrote batch");
  }

  @After
  public void tearDown() {
    bigquery.delete(
        DatasetId.of(GOOGLE_CLOUD_PROJECT, datasetName), DatasetDeleteOption.deleteContents());
    System.setOut(null);
  }
}
