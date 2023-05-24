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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.SnoozeServiceClient.ListSnoozesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.SnoozeName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
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
public class SnoozeServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSnoozeService mockSnoozeService;
  private LocalChannelProvider channelProvider;
  private SnoozeServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSnoozeService = new MockSnoozeService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSnoozeService));
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
    SnoozeServiceSettings settings =
        SnoozeServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SnoozeServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSnoozeTest() throws Exception {
    Snooze expectedResponse =
        Snooze.newBuilder()
            .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
            .setCriteria(Snooze.Criteria.newBuilder().build())
            .setInterval(TimeInterval.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Snooze snooze = Snooze.newBuilder().build();

    Snooze actualResponse = client.createSnooze(parent, snooze);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnoozeRequest actualRequest = ((CreateSnoozeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(snooze, actualRequest.getSnooze());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnoozeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Snooze snooze = Snooze.newBuilder().build();
      client.createSnooze(parent, snooze);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSnoozeTest2() throws Exception {
    Snooze expectedResponse =
        Snooze.newBuilder()
            .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
            .setCriteria(Snooze.Criteria.newBuilder().build())
            .setInterval(TimeInterval.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Snooze snooze = Snooze.newBuilder().build();

    Snooze actualResponse = client.createSnooze(parent, snooze);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSnoozeRequest actualRequest = ((CreateSnoozeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(snooze, actualRequest.getSnooze());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSnoozeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      String parent = "parent-995424086";
      Snooze snooze = Snooze.newBuilder().build();
      client.createSnooze(parent, snooze);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnoozesTest() throws Exception {
    Snooze responsesElement = Snooze.newBuilder().build();
    ListSnoozesResponse expectedResponse =
        ListSnoozesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnoozes(Arrays.asList(responsesElement))
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSnoozesPagedResponse pagedListResponse = client.listSnoozes(parent);

    List<Snooze> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnoozesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnoozesRequest actualRequest = ((ListSnoozesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnoozesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSnoozes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSnoozesTest2() throws Exception {
    Snooze responsesElement = Snooze.newBuilder().build();
    ListSnoozesResponse expectedResponse =
        ListSnoozesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSnoozes(Arrays.asList(responsesElement))
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSnoozesPagedResponse pagedListResponse = client.listSnoozes(parent);

    List<Snooze> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSnoozesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSnoozesRequest actualRequest = ((ListSnoozesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSnoozesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSnoozes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnoozeTest() throws Exception {
    Snooze expectedResponse =
        Snooze.newBuilder()
            .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
            .setCriteria(Snooze.Criteria.newBuilder().build())
            .setInterval(TimeInterval.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    SnoozeName name = SnoozeName.of("[PROJECT]", "[SNOOZE]");

    Snooze actualResponse = client.getSnooze(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnoozeRequest actualRequest = ((GetSnoozeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnoozeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      SnoozeName name = SnoozeName.of("[PROJECT]", "[SNOOZE]");
      client.getSnooze(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSnoozeTest2() throws Exception {
    Snooze expectedResponse =
        Snooze.newBuilder()
            .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
            .setCriteria(Snooze.Criteria.newBuilder().build())
            .setInterval(TimeInterval.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    String name = "name3373707";

    Snooze actualResponse = client.getSnooze(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSnoozeRequest actualRequest = ((GetSnoozeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSnoozeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      String name = "name3373707";
      client.getSnooze(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSnoozeTest() throws Exception {
    Snooze expectedResponse =
        Snooze.newBuilder()
            .setName(SnoozeName.of("[PROJECT]", "[SNOOZE]").toString())
            .setCriteria(Snooze.Criteria.newBuilder().build())
            .setInterval(TimeInterval.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .build();
    mockSnoozeService.addResponse(expectedResponse);

    Snooze snooze = Snooze.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Snooze actualResponse = client.updateSnooze(snooze, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSnoozeService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSnoozeRequest actualRequest = ((UpdateSnoozeRequest) actualRequests.get(0));

    Assert.assertEquals(snooze, actualRequest.getSnooze());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSnoozeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSnoozeService.addException(exception);

    try {
      Snooze snooze = Snooze.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSnooze(snooze, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
