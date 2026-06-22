/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.RuleExecutionErrorServiceClient.ListRuleExecutionErrorsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class RuleExecutionErrorServiceClientTest {
  private static MockRuleExecutionErrorService mockRuleExecutionErrorService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RuleExecutionErrorServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRuleExecutionErrorService = new MockRuleExecutionErrorService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRuleExecutionErrorService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    RuleExecutionErrorServiceSettings settings =
        RuleExecutionErrorServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RuleExecutionErrorServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listRuleExecutionErrorsTest() throws Exception {
    RuleExecutionError responsesElement = RuleExecutionError.newBuilder().build();
    ListRuleExecutionErrorsResponse expectedResponse =
        ListRuleExecutionErrorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleExecutionErrors(Arrays.asList(responsesElement))
            .build();
    mockRuleExecutionErrorService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListRuleExecutionErrorsPagedResponse pagedListResponse = client.listRuleExecutionErrors(parent);

    List<RuleExecutionError> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleExecutionErrorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleExecutionErrorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleExecutionErrorsRequest actualRequest =
        ((ListRuleExecutionErrorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleExecutionErrorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleExecutionErrorService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listRuleExecutionErrors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleExecutionErrorsTest2() throws Exception {
    RuleExecutionError responsesElement = RuleExecutionError.newBuilder().build();
    ListRuleExecutionErrorsResponse expectedResponse =
        ListRuleExecutionErrorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleExecutionErrors(Arrays.asList(responsesElement))
            .build();
    mockRuleExecutionErrorService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuleExecutionErrorsPagedResponse pagedListResponse = client.listRuleExecutionErrors(parent);

    List<RuleExecutionError> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleExecutionErrorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleExecutionErrorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleExecutionErrorsRequest actualRequest =
        ((ListRuleExecutionErrorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleExecutionErrorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleExecutionErrorService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuleExecutionErrors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
