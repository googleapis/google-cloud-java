/*
 * Copyright 2017 Google LLC
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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceConfig;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.InstanceInfo;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.Iterators;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for VPC */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITVPCTest {
  private static final boolean IS_VPC_TEST = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") != null
    && System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC").equalsIgnoreCase("true");
  private static final String OUTSIDE_VPC_PROJECT = "";

  private static final Logger logger = Logger.getLogger(ITVPCTest.class.getName());

  @Rule public ExpectedException expectedException = ExpectedException.none();

  InstanceAdminClient instanceAdminClient;

  // TODO(qlong): make static
  @Before
  public void setUp() {
    logger.log(Level.INFO, "IS_VPC_TEST: " + IS_VPC_TEST);
    assumeTrue(IS_VPC_TEST);
    // TODO(qlong): pass this in as an environment variable
    InstanceId instanceId = InstanceId.of("projects/vpc-test-227005/instances/qlong-test");
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId(instanceId.getProject()).build();
    Spanner spanner = options.getService();
    instanceAdminClient = spanner.getInstanceAdminClient();
  }

  @Test
  public void deniedListInstanceConfigs() {
    expectedException.expect(isSpannerException(ErrorCode.PERMISSION_DENIED));
    expectedException.expectMessage("Request is prohibited by organization's policy");

    instanceAdminClient.listInstanceConfigs();

  }

  @Test
  public void deniedGetInstanceConfig() {

  }

  @Test
  public void deniedListInstances() {

  }

  @Test
  public void deniedGetInstance() {

  }

  @Test
  public void deniedListDatabases() {
  }

  @Test
  public void deniedGetDatabase() {

  }

}
