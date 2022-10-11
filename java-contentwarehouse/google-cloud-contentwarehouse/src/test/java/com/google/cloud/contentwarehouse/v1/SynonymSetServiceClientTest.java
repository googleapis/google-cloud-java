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

import static com.google.cloud.contentwarehouse.v1.SynonymSetServiceClient.ListSynonymSetsPagedResponse;

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
public class SynonymSetServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSynonymSetService mockSynonymSetService;
  private LocalChannelProvider channelProvider;
  private SynonymSetServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSynonymSetService = new MockSynonymSetService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSynonymSetService));
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
    SynonymSetServiceSettings settings =
        SynonymSetServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SynonymSetServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSynonymSetTest() throws Exception {
    SynonymSet expectedResponse =
        SynonymSet.newBuilder()
            .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
            .setContext("context951530927")
            .addAllSynonyms(new ArrayList<SynonymSet.Synonym>())
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    SynonymSet synonymSet = SynonymSet.newBuilder().build();

    SynonymSet actualResponse = client.createSynonymSet(parent, synonymSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSynonymSetRequest actualRequest = ((CreateSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(synonymSet, actualRequest.getSynonymSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSynonymSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      SynonymSet synonymSet = SynonymSet.newBuilder().build();
      client.createSynonymSet(parent, synonymSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSynonymSetTest2() throws Exception {
    SynonymSet expectedResponse =
        SynonymSet.newBuilder()
            .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
            .setContext("context951530927")
            .addAllSynonyms(new ArrayList<SynonymSet.Synonym>())
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SynonymSet synonymSet = SynonymSet.newBuilder().build();

    SynonymSet actualResponse = client.createSynonymSet(parent, synonymSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSynonymSetRequest actualRequest = ((CreateSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(synonymSet, actualRequest.getSynonymSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSynonymSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      String parent = "parent-995424086";
      SynonymSet synonymSet = SynonymSet.newBuilder().build();
      client.createSynonymSet(parent, synonymSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSynonymSetTest() throws Exception {
    SynonymSet expectedResponse =
        SynonymSet.newBuilder()
            .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
            .setContext("context951530927")
            .addAllSynonyms(new ArrayList<SynonymSet.Synonym>())
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");

    SynonymSet actualResponse = client.getSynonymSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSynonymSetRequest actualRequest = ((GetSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSynonymSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");
      client.getSynonymSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSynonymSetTest2() throws Exception {
    SynonymSet expectedResponse =
        SynonymSet.newBuilder()
            .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
            .setContext("context951530927")
            .addAllSynonyms(new ArrayList<SynonymSet.Synonym>())
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    String name = "name3373707";

    SynonymSet actualResponse = client.getSynonymSet(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSynonymSetRequest actualRequest = ((GetSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSynonymSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      String name = "name3373707";
      client.getSynonymSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSynonymSetTest() throws Exception {
    SynonymSet expectedResponse =
        SynonymSet.newBuilder()
            .setName(SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]").toString())
            .setContext("context951530927")
            .addAllSynonyms(new ArrayList<SynonymSet.Synonym>())
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    SynonymSet synonymSet = SynonymSet.newBuilder().build();

    SynonymSet actualResponse = client.updateSynonymSet(synonymSet);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSynonymSetRequest actualRequest = ((UpdateSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(synonymSet, actualRequest.getSynonymSet());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSynonymSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      SynonymSet synonymSet = SynonymSet.newBuilder().build();
      client.updateSynonymSet(synonymSet);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSynonymSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSynonymSetService.addResponse(expectedResponse);

    SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");

    client.deleteSynonymSet(name);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSynonymSetRequest actualRequest = ((DeleteSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSynonymSetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      SynonymSetName name = SynonymSetName.of("[PROJECT]", "[LOCATION]", "[CONTEXT]");
      client.deleteSynonymSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSynonymSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSynonymSetService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSynonymSet(name);

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSynonymSetRequest actualRequest = ((DeleteSynonymSetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSynonymSetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSynonymSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSynonymSetsTest() throws Exception {
    SynonymSet responsesElement = SynonymSet.newBuilder().build();
    ListSynonymSetsResponse expectedResponse =
        ListSynonymSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSynonymSets(Arrays.asList(responsesElement))
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSynonymSetsPagedResponse pagedListResponse = client.listSynonymSets(parent);

    List<SynonymSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSynonymSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSynonymSetsRequest actualRequest = ((ListSynonymSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSynonymSetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSynonymSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSynonymSetsTest2() throws Exception {
    SynonymSet responsesElement = SynonymSet.newBuilder().build();
    ListSynonymSetsResponse expectedResponse =
        ListSynonymSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSynonymSets(Arrays.asList(responsesElement))
            .build();
    mockSynonymSetService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSynonymSetsPagedResponse pagedListResponse = client.listSynonymSets(parent);

    List<SynonymSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSynonymSetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSynonymSetService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSynonymSetsRequest actualRequest = ((ListSynonymSetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSynonymSetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSynonymSetService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSynonymSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
