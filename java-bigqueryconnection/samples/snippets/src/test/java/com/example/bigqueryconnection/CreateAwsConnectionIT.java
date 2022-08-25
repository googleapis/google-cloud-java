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

import com.google.cloud.bigquery.connection.v1.AwsAccessRole;
import com.google.cloud.bigquery.connection.v1.AwsProperties;
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

public class CreateAwsConnectionIT {

  private static final Logger LOG = Logger.getLogger(CreateAwsConnectionIT.class.getName());
  private static final String LOCATION = "aws-us-east-1";
  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");
  private static final String AWS_ACCOUNT_ID = requireEnvVar("AWS_ACCOUNT_ID");
  private static final String AWS_ROLE_ID = requireEnvVar("AWS_ROLE_ID");

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
    requireEnvVar("AWS_ACCOUNT_ID");
    requireEnvVar("AWS_ROLE_ID");
  }

  @Before
  public void setUp() {
    connectionId = "CREATE_AWS_CONNECTION_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
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
  public void testCreateAwsConnection() throws IOException {
    String iamRoleId = String.format("arn:aws:iam::%s:role/%s", AWS_ACCOUNT_ID, AWS_ROLE_ID);
    AwsAccessRole awsRole = AwsAccessRole.newBuilder().setIamRoleId(iamRoleId).build();
    AwsProperties awsProperties = AwsProperties.newBuilder().setAccessRole(awsRole).build();
    Connection connection = Connection.newBuilder().setAws(awsProperties).build();
    CreateAwsConnection.createAwsConnection(PROJECT_ID, LOCATION, connectionId, connection);
    assertThat(bout.toString()).contains("Aws connection created successfully :");
  }
}
