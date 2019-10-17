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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.Identity;
import com.google.cloud.NoCredentials;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class DatabaseAdminClientTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String DB_ID = "test-db";
  private static final List<String> INITIAL_STATEMENTS =
      Arrays.asList("CREATE TABLE FOO", "CREATE TABLE BAR");

  private static MockOperationsServiceImpl mockOperations;
  private static MockDatabaseAdminServiceImpl mockDatabaseAdmin;
  private static MockServiceHelper serviceHelper;
  private LocalChannelProvider channelProvider;
  private Spanner spanner;
  private DatabaseAdminClient client;
  @Rule public ExpectedException exception = ExpectedException.none();

  @BeforeClass
  public static void startStaticServer() {
    mockOperations = new MockOperationsServiceImpl();
    mockDatabaseAdmin = new MockDatabaseAdminServiceImpl(mockOperations);
    serviceHelper =
        new MockServiceHelper(
            "in-process-1", Arrays.<MockGrpcService>asList(mockOperations, mockDatabaseAdmin));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    SpannerOptions.Builder builder = SpannerOptions.newBuilder();
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .createDatabaseOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeout(Duration.ofMillis(20L))
                    .setInitialRetryDelay(Duration.ofMillis(10L))
                    .setMaxRetryDelay(Duration.ofMillis(150L))
                    .setMaxRpcTimeout(Duration.ofMillis(150L))
                    .setMaxAttempts(10)
                    .setTotalTimeout(Duration.ofMillis(5000L))
                    .setRetryDelayMultiplier(1.3)
                    .setRpcTimeoutMultiplier(1.3)
                    .build()));
    spanner =
        builder
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setProjectId(PROJECT_ID)
            .build()
            .getService();
    client = spanner.getDatabaseAdminClient();
    createTestDatabase();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  @Test
  public void getAndSetIAMPolicy() {
    Policy policy = client.getDatabaseIAMPolicy(INSTANCE_ID, DB_ID);
    assertThat(policy).isEqualTo(Policy.newBuilder().build());
    Policy newPolicy =
        Policy.newBuilder().addIdentity(Role.editor(), Identity.user("joe@example.com")).build();
    Policy returnedPolicy = client.setDatabaseIAMPolicy(INSTANCE_ID, DB_ID, newPolicy);
    assertThat(returnedPolicy).isEqualTo(newPolicy);
    assertThat(client.getDatabaseIAMPolicy(INSTANCE_ID, DB_ID)).isEqualTo(newPolicy);
  }

  @Test
  public void testDatabaseIAMPermissions() {
    Iterable<String> permissions =
        client.testDatabaseIAMPermissions(
            INSTANCE_ID, DB_ID, Arrays.asList("spanner.databases.select"));
    assertThat(permissions).containsExactly("spanner.databases.select");
  }

  private void createTestDatabase() {
    try {
      client.createDatabase(INSTANCE_ID, DB_ID, INITIAL_STATEMENTS).get();
    } catch (InterruptedException | ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }
}
