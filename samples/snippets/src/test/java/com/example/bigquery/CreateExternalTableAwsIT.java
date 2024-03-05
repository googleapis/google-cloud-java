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

package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.CsvOptions;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CreateExternalTableAwsIT {

  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String tableName;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String OMNI_PROJECT_ID = requireEnvVar("OMNI_PROJECT_ID");
  private static final String OMNI_DATASET_NAME = requireEnvVar("OMNI_DATASET_NAME");
  private static final String AWS_READ_CONNECTION_ID = requireEnvVar("AWS_READ_CONNECTION_ID");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("OMNI_PROJECT_ID");
    requireEnvVar("OMNI_DATASET_NAME");
    requireEnvVar("AWS_READ_CONNECTION_ID");
  }

  @Before
  public void setUp() {
    tableName = "CREATE_EXTERNAL_TABLE_AWS_TEST_" + ID;
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
    log.log(Level.INFO, bout.toString());
  }

  @Test
  public void testCreateExternalTableAws() {
    String sourceUri = "s3://omni-samples-test-bucket/us-states.csv";
    Schema schema =
        Schema.of(
            Field.of("name", StandardSQLTypeName.STRING),
            Field.of("post_abbr", StandardSQLTypeName.STRING));
    CsvOptions options = CsvOptions.newBuilder().setSkipLeadingRows(1).build();
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.newBuilder(sourceUri, options)
            .setConnectionId(AWS_READ_CONNECTION_ID)
            .setSchema(schema)
            .build();
    CreateExternalTableAws.createExternalTableAws(
        OMNI_PROJECT_ID, OMNI_DATASET_NAME, tableName, externalTableDefinition);
    assertThat(bout.toString()).contains("Aws external table created successfully");
  }
}
