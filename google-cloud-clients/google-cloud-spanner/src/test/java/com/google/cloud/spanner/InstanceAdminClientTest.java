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
import com.google.cloud.Identity;
import com.google.cloud.NoCredentials;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InstanceAdminClientTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";

  private static MockInstanceAdminServiceImpl mockInstanceAdmin;
  private static MockServiceHelper serviceHelper;
  private LocalChannelProvider channelProvider;
  private Spanner spanner;
  private InstanceAdminClient client;
  @Rule public ExpectedException exception = ExpectedException.none();

  @BeforeClass
  public static void startStaticServer() {
    mockInstanceAdmin = new MockInstanceAdminServiceImpl();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockInstanceAdmin));
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
    spanner =
        SpannerOptions.newBuilder()
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setProjectId(PROJECT_ID)
            .build()
            .getService();
    client = spanner.getInstanceAdminClient();
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
  }

  @Test
  public void getAndSetIAMPolicy() {
    Policy policy = client.getInstanceIAMPolicy(INSTANCE_ID);
    assertThat(policy).isEqualTo(Policy.newBuilder().build());
    Policy newPolicy =
        Policy.newBuilder().addIdentity(Role.viewer(), Identity.user("joe@example.com")).build();
    Policy returnedPolicy = client.setInstanceIAMPolicy(INSTANCE_ID, newPolicy);
    assertThat(returnedPolicy).isEqualTo(newPolicy);
    assertThat(client.getInstanceIAMPolicy(INSTANCE_ID)).isEqualTo(newPolicy);
  }

  @Test
  public void testIAMPermissions() {
    Iterable<String> permissions =
        client.testInstanceIAMPermissions(INSTANCE_ID, Arrays.asList("spanner.instances.list"));
    assertThat(permissions).containsExactly("spanner.instances.list");
  }
}
