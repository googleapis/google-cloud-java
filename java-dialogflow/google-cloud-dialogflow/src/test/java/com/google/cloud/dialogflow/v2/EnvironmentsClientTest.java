/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.EnvironmentsClient.ListEnvironmentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class EnvironmentsClientTest {
  private static MockAgents mockAgents;
  private static MockContexts mockContexts;
  private static MockEntityTypes mockEntityTypes;
  private static MockEnvironments mockEnvironments;
  private static MockIntents mockIntents;
  private static MockSessionEntityTypes mockSessionEntityTypes;
  private static MockSessions mockSessions;
  private static MockServiceHelper serviceHelper;
  private EnvironmentsClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockAgents = new MockAgents();
    mockContexts = new MockContexts();
    mockEntityTypes = new MockEntityTypes();
    mockEnvironments = new MockEnvironments();
    mockIntents = new MockIntents();
    mockSessionEntityTypes = new MockSessionEntityTypes();
    mockSessions = new MockSessions();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockAgents,
                mockContexts,
                mockEntityTypes,
                mockEnvironments,
                mockIntents,
                mockSessionEntityTypes,
                mockSessions));
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
    EnvironmentsSettings settings =
        EnvironmentsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EnvironmentsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listEnvironmentsTest() {
    String nextPageToken = "";
    Environment environmentsElement = Environment.newBuilder().build();
    List<Environment> environments = Arrays.asList(environmentsElement);
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllEnvironments(environments)
            .build();
    mockEnvironments.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]");
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(parent.toString()).build();

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(request);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEnvironments.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = (ListEnvironmentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, AgentName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listEnvironmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockEnvironments.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]");
      ListEnvironmentsRequest request =
          ListEnvironmentsRequest.newBuilder().setParent(parent.toString()).build();

      client.listEnvironments(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
