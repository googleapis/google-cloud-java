/*
 * Copyright 2022 Google LLC
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

package com.google.appengine.v1;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class FirewallClientTest {
  private static MockFirewall mockFirewall;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private FirewallClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockFirewall = new MockFirewall();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockFirewall));
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
    FirewallSettings settings =
        FirewallSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = FirewallClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listIngressRulesTest() throws Exception {
    FirewallRule responsesElement = FirewallRule.newBuilder().build();
    ListIngressRulesResponse expectedResponse =
        ListIngressRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIngressRules(Arrays.asList(responsesElement))
            .build();
    mockFirewall.addResponse(expectedResponse);

    ListIngressRulesRequest request =
        ListIngressRulesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setMatchingAddress("matchingAddress861962551")
            .build();

    ListIngressRulesPagedResponse pagedListResponse = client.listIngressRules(request);

    List<FirewallRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIngressRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIngressRulesRequest actualRequest = ((ListIngressRulesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getMatchingAddress(), actualRequest.getMatchingAddress());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIngressRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      ListIngressRulesRequest request =
          ListIngressRulesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMatchingAddress("matchingAddress861962551")
              .build();
      client.listIngressRules(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateIngressRulesTest() throws Exception {
    BatchUpdateIngressRulesResponse expectedResponse =
        BatchUpdateIngressRulesResponse.newBuilder()
            .addAllIngressRules(new ArrayList<FirewallRule>())
            .build();
    mockFirewall.addResponse(expectedResponse);

    BatchUpdateIngressRulesRequest request =
        BatchUpdateIngressRulesRequest.newBuilder()
            .setName("name3373707")
            .addAllIngressRules(new ArrayList<FirewallRule>())
            .build();

    BatchUpdateIngressRulesResponse actualResponse = client.batchUpdateIngressRules(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateIngressRulesRequest actualRequest =
        ((BatchUpdateIngressRulesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getIngressRulesList(), actualRequest.getIngressRulesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateIngressRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      BatchUpdateIngressRulesRequest request =
          BatchUpdateIngressRulesRequest.newBuilder()
              .setName("name3373707")
              .addAllIngressRules(new ArrayList<FirewallRule>())
              .build();
      client.batchUpdateIngressRules(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockFirewall.addResponse(expectedResponse);

    CreateIngressRuleRequest request =
        CreateIngressRuleRequest.newBuilder()
            .setParent("parent-995424086")
            .setRule(FirewallRule.newBuilder().build())
            .build();

    FirewallRule actualResponse = client.createIngressRule(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIngressRuleRequest actualRequest = ((CreateIngressRuleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRule(), actualRequest.getRule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIngressRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      CreateIngressRuleRequest request =
          CreateIngressRuleRequest.newBuilder()
              .setParent("parent-995424086")
              .setRule(FirewallRule.newBuilder().build())
              .build();
      client.createIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockFirewall.addResponse(expectedResponse);

    GetIngressRuleRequest request =
        GetIngressRuleRequest.newBuilder().setName("name3373707").build();

    FirewallRule actualResponse = client.getIngressRule(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIngressRuleRequest actualRequest = ((GetIngressRuleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIngressRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      GetIngressRuleRequest request =
          GetIngressRuleRequest.newBuilder().setName("name3373707").build();
      client.getIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIngressRuleTest() throws Exception {
    FirewallRule expectedResponse =
        FirewallRule.newBuilder()
            .setPriority(-1165461084)
            .setSourceRange("sourceRange-97207838")
            .setDescription("description-1724546052")
            .build();
    mockFirewall.addResponse(expectedResponse);

    UpdateIngressRuleRequest request =
        UpdateIngressRuleRequest.newBuilder()
            .setName("name3373707")
            .setRule(FirewallRule.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    FirewallRule actualResponse = client.updateIngressRule(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIngressRuleRequest actualRequest = ((UpdateIngressRuleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getRule(), actualRequest.getRule());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIngressRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      UpdateIngressRuleRequest request =
          UpdateIngressRuleRequest.newBuilder()
              .setName("name3373707")
              .setRule(FirewallRule.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIngressRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockFirewall.addResponse(expectedResponse);

    DeleteIngressRuleRequest request =
        DeleteIngressRuleRequest.newBuilder().setName("name3373707").build();

    client.deleteIngressRule(request);

    List<AbstractMessage> actualRequests = mockFirewall.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIngressRuleRequest actualRequest = ((DeleteIngressRuleRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIngressRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockFirewall.addException(exception);

    try {
      DeleteIngressRuleRequest request =
          DeleteIngressRuleRequest.newBuilder().setName("name3373707").build();
      client.deleteIngressRule(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
