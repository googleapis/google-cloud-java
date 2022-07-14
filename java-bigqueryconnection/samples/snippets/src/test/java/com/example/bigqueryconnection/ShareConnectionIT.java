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

package com.example.bigqueryconnection;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.connection.v1.CloudSqlCredential;
import com.google.cloud.bigquery.connection.v1.CloudSqlProperties;
import com.google.cloud.bigquery.connection.v1.Connection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShareConnectionIT {

  private static final Logger LOG = Logger.getLogger(ShareConnectionIT.class.getName());
  private static final String LOCATION = "US";
  private static final String REGION = "us-central1";
  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");
  private static final String MY_SQL_DATABASE = requireEnvVar("MY_SQL_DATABASE");
  private static final String MY_SQL_INSTANCE = requireEnvVar("MY_SQL_INSTANCE");
  private static final String DB_USER = requireEnvVar("DB_USER");
  private static final String DB_PWD = requireEnvVar("DB_PWD");

  private String connectionId;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

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
    requireEnvVar("MY_SQL_DATABASE");
    requireEnvVar("MY_SQL_INSTANCE");
    requireEnvVar("DB_USER");
    requireEnvVar("DB_PWD");
  }

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
    // create a temporary connection
    connectionId = "SHARE_CONNECTION_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    String instanceId = String.format("%s:%s:%s", PROJECT_ID, REGION, MY_SQL_INSTANCE);
    CloudSqlCredential cloudSqlCredential =
        CloudSqlCredential.newBuilder().setUsername(DB_USER).setPassword(DB_PWD).build();
    CloudSqlProperties cloudSqlProperties =
        CloudSqlProperties.newBuilder()
            .setType(CloudSqlProperties.DatabaseType.MYSQL)
            .setDatabase(MY_SQL_DATABASE)
            .setInstanceId(instanceId)
            .setCredential(cloudSqlCredential)
            .build();
    Connection connection = Connection.newBuilder().setCloudSql(cloudSqlProperties).build();
    CreateConnection.createConnection(PROJECT_ID, LOCATION, connectionId, connection);
  }

  @After
  public void tearDown() throws IOException {
    // Clean up
    DeleteConnection.deleteConnection(PROJECT_ID, LOCATION, connectionId);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    LOG.log(Level.INFO, bout.toString());
  }

  @Test
  public void testShareConnection() throws IOException {
    ShareConnection.shareConnection(PROJECT_ID, LOCATION, connectionId);
    assertThat(bout.toString()).contains("Connection shared successfully");
  }
}
