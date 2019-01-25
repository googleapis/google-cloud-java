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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for VPC-SC */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITVPCTest {
  private static final String IN_VPCSC_TEST = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");
  private static final String OUTSIDE_VPC_PROJECT =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");

  @Rule public ExpectedException expectedException = ExpectedException.none();

  private Spanner spanner;
  private InstanceAdminClient instanceAdminClient;
  private DatabaseAdminClient databaseAdminClient;

  @BeforeClass
  public static void setUpClass() {
    assumeTrue(
        "To run tests,, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to True",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));
    assertTrue(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs " +
        "to be set to a GCP project that is outside the VPC perimeter",
        OUTSIDE_VPC_PROJECT != null && OUTSIDE_VPC_PROJECT != "");
  }

  @Before
  public void setUp() {
    InstanceId instanceId = InstanceId.of(OUTSIDE_VPC_PROJECT, "nonexistent-instance");
    SpannerOptions options =
        SpannerOptions.newBuilder().setProjectId(instanceId.getProject()).build();
    spanner = options.getService();
    instanceAdminClient = spanner.getInstanceAdminClient();
    databaseAdminClient = spanner.getDatabaseAdminClient();
  }

  @After
  public void tearDown() {
    spanner.close();
  }

  @Test
  public void deniedListInstanceConfigs() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    instanceAdminClient.listInstanceConfigs();
  }

  @Test
  public void deniedGetInstanceConfig() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    instanceAdminClient.getInstanceConfig("nonexistent-configs");
  }

  @Test
  public void deniedListInstances() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    instanceAdminClient.listInstances();
  }

  @Test
  public void deniedGetInstance() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    instanceAdminClient.getInstance("non-existent");
  }

  @Test
  public void deniedListDatabases() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    databaseAdminClient.listDatabases("nonexistent-instance", Options.pageSize(1));
  }

  @Test
  public void deniedGetDatabase() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    databaseAdminClient.getDatabase("nonexistent-instance", "nonexistent-database");
  }
}
