/*
 * Copyright 2016 Google Inc.
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

package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for quickstart sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartSampleIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final void deleteMyNewDataset() {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String datasetName = "my_new_dataset";
    DatasetId datasetId = DatasetId.of(datasetName);
    DatasetDeleteOption deleteContents = DatasetDeleteOption.deleteContents();
    bigquery.delete(datasetId, deleteContents);
  }

  @Before
  public void setUp() {
    deleteMyNewDataset();

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
    deleteMyNewDataset();
  }

  @Test
  public void testQuickstart() throws Exception {
    QuickstartSample.main();
    String got = bout.toString();
    assertThat(got).contains("Dataset my_new_dataset created.");
  }
}
