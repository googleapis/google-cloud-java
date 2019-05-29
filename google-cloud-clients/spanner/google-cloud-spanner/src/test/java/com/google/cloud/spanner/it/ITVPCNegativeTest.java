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

package com.google.cloud.spanner.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for VPC-SC */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITVPCNegativeTest {
  private static final String IN_VPCSC_TEST = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");
  private static final String OUTSIDE_VPC_PROJECT =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");

  private Spanner spanner;
  private InstanceAdminClient instanceAdminClient;
  private DatabaseAdminClient databaseAdminClient;
  private DatabaseClient databaseClient;

  @BeforeClass
  public static void setUpClass() {
    assumeTrue(
        "To run tests, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to True",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));
    assertTrue(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs "
            + "to be set to a GCP project that is outside the VPC perimeter",
        OUTSIDE_VPC_PROJECT != null && OUTSIDE_VPC_PROJECT != "");
  }

  @Before
  public void setUp() {
    InstanceId instanceId = InstanceId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance");
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId(instanceId.getProject())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder()
                    // Do not eagerly create sessions since they will fail outside the VPC.
                    .setMinSessions(0)
                    // Client shouldn't block if sessions cannot be created
                    .setFailIfPoolExhausted()
                    .build())
            .build();
    spanner = options.getService();
    instanceAdminClient = spanner.getInstanceAdminClient();
    databaseAdminClient = spanner.getDatabaseAdminClient();
    databaseClient =
        spanner.getDatabaseClient(
            DatabaseId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance", "nonexistent-database"));
  }

  @After
  public void tearDown() {
    spanner.close();
  }

  private void checkExceptionForVPCError(SpannerException e) {
    assertEquals(ErrorCode.PERMISSION_DENIED, e.getErrorCode());
    assertThat(e.getMessage()).contains("Request is prohibited by organization's policy");
  }

  @Test
  public void deniedListInstanceConfigs() {
    try {
      instanceAdminClient.listInstanceConfigs();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetInstanceConfig() {
    try {
      instanceAdminClient.getInstanceConfig("nonexistent-configs");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListInstances() {
    try {
      instanceAdminClient.listInstances();
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetInstance() {
    try {
      instanceAdminClient.getInstance("non-existent");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedListDatabases() {
    try {
      databaseAdminClient.listDatabases("nonexistent-instance", Options.pageSize(1));
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedGetDatabase() {
    try {
      databaseAdminClient.getDatabase("nonexistent-instance", "nonexistent-database");
      fail("Expected PERMISSION_DENIED SpannerException");
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }

  @Test
  public void deniedRead() {
    try {
      // Tests that the initial create session request returns a permission denied.
      databaseClient
          .singleUse()
          .read("nonexistent-table", KeySet.all(), Arrays.asList("nonexistent-col"));
    } catch (SpannerException e) {
      checkExceptionForVPCError(e);
    }
  }
}
