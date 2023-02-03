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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.RuleSetServiceClient.ListRuleSetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
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
public class RuleSetServiceClientTest {
  private static MockRuleSetService mockRuleSetService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RuleSetServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRuleSetService = new MockRuleSetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRuleSetService));
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
    RuleSetServiceSettings settings =
        RuleSetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RuleSetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createRuleSetTest() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RuleSet ruleSet = RuleSet.newBuilder().build();

    RuleSet actualResponse = client.createRuleSet(parent, ruleSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleSetRequest actualRequest = ((CreateRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ruleSet, actualRequest.getRuleSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RuleSet ruleSet = RuleSet.newBuilder().build();
      client.createRuleSet(parent, ruleSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuleSetTest2() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    RuleSet ruleSet = RuleSet.newBuilder().build();

    RuleSet actualResponse = client.createRuleSet(parent, ruleSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleSetRequest actualRequest = ((CreateRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ruleSet, actualRequest.getRuleSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      String parent = "parent-995424086";
      RuleSet ruleSet = RuleSet.newBuilder().build();
      client.createRuleSet(parent, ruleSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleSetTest() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");

    RuleSet actualResponse = client.getRuleSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleSetRequest actualRequest = ((GetRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
      client.getRuleSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleSetTest2() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    String name = "name3373707";

    RuleSet actualResponse = client.getRuleSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleSetRequest actualRequest = ((GetRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      String name = "name3373707";
      client.getRuleSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRuleSetTest() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
    RuleSet ruleSet = RuleSet.newBuilder().build();

    RuleSet actualResponse = client.updateRuleSet(name, ruleSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuleSetRequest actualRequest = ((UpdateRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(ruleSet, actualRequest.getRuleSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuleSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
      RuleSet ruleSet = RuleSet.newBuilder().build();
      client.updateRuleSet(name, ruleSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRuleSetTest2() throws Exception {
    RuleSet expectedResponse =
        RuleSet.newBuilder()
            .setName(RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]").toString())
            .setDescription("description-1724546052")
            .setSource("source-896505829")
            .addAllRules(new ArrayList<Rule>())
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    String name = "name3373707";
    RuleSet ruleSet = RuleSet.newBuilder().build();

    RuleSet actualResponse = client.updateRuleSet(name, ruleSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuleSetRequest actualRequest = ((UpdateRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(ruleSet, actualRequest.getRuleSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuleSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      String name = "name3373707";
      RuleSet ruleSet = RuleSet.newBuilder().build();
      client.updateRuleSet(name, ruleSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuleSetService.addResponse(expectedResponse);

    RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");

    client.deleteRuleSet(name);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleSetRequest actualRequest = ((DeleteRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      RuleSetName name = RuleSetName.of("[PROJECT]", "[LOCATION]", "[RULE_SET]");
      client.deleteRuleSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuleSetService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRuleSet(name);

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleSetRequest actualRequest = ((DeleteRuleSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRuleSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleSetsTest() throws Exception {
    RuleSet responsesElement = RuleSet.newBuilder().build();
    ListRuleSetsResponse expectedResponse =
        ListRuleSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleSets(Arrays.asList(responsesElement))
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRuleSetsPagedResponse pagedListResponse = client.listRuleSets(parent);

    List<RuleSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleSetsRequest actualRequest = ((ListRuleSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRuleSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleSetsTest2() throws Exception {
    RuleSet responsesElement = RuleSet.newBuilder().build();
    ListRuleSetsResponse expectedResponse =
        ListRuleSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleSets(Arrays.asList(responsesElement))
            .build();
    mockRuleSetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuleSetsPagedResponse pagedListResponse = client.listRuleSets(parent);

    List<RuleSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleSetsRequest actualRequest = ((ListRuleSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleSetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuleSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
