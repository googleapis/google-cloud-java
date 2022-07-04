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

package com.example.bigquerydatatransfer;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CopyDatasetIT {

  private static final Logger LOG = Logger.getLogger(CopyDatasetIT.class.getName());
  private BigQuery bigquery;
  private ByteArrayOutputStream bout;
  private String name;
  private String displayName;
  private String datasetName;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    displayName = "MY_COPY_DATASET_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    datasetName = "MY_DATASET_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    // create a temporary dataset
    bigquery = BigQueryOptions.getDefaultInstance().getService();
    bigquery.create(DatasetInfo.of(datasetName));

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() throws IOException {
    // TODO(pmakani) replace DeleteTransferConfig once PR merged.
    // Clean up
    DeleteScheduledQuery.deleteScheduledQuery(name);
    // delete a temporary dataset
    bigquery.delete(datasetName, BigQuery.DatasetDeleteOption.deleteContents());
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    LOG.log(Level.INFO, bout.toString());
  }

  @Test
  public void testCopyDataset() throws IOException {
    Map<String, Value> params = new HashMap<>();
    params.put(
        "source_project_id", Value.newBuilder().setStringValue("bigquery-public-data").build());
    params.put("source_dataset_id", Value.newBuilder().setStringValue("usa_names").build());
    TransferConfig transferConfig =
        TransferConfig.newBuilder()
            .setDestinationDatasetId(datasetName)
            .setDisplayName(displayName)
            .setDataSourceId("cross_region_copy")
            .setParams(Struct.newBuilder().putAllFields(params).build())
            .setSchedule("every 24 hours")
            .build();
    CopyDataset.copyDataset(PROJECT_ID, transferConfig);
    String result = bout.toString();
    name = result.substring(result.indexOf(":") + 1, result.length() - 1);
    assertThat(result).contains("Copy dataset created successfully :");
  }
}
