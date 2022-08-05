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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.KnowledgeBasesClient.ListKnowledgeBasesPagedResponse;
import static com.google.cloud.dialogflow.v2.KnowledgeBasesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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
public class KnowledgeBasesClientTest {
  private static MockKnowledgeBases mockKnowledgeBases;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private KnowledgeBasesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockKnowledgeBases = new MockKnowledgeBases();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockKnowledgeBases, mockLocations));
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
    KnowledgeBasesSettings settings =
        KnowledgeBasesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = KnowledgeBasesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listKnowledgeBasesTest() throws Exception {
    KnowledgeBase responsesElement = KnowledgeBase.newBuilder().build();
    ListKnowledgeBasesResponse expectedResponse =
        ListKnowledgeBasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllKnowledgeBases(Arrays.asList(responsesElement))
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListKnowledgeBasesPagedResponse pagedListResponse = client.listKnowledgeBases(parent);

    List<KnowledgeBase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKnowledgeBasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKnowledgeBasesRequest actualRequest = ((ListKnowledgeBasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKnowledgeBasesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listKnowledgeBases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKnowledgeBasesTest2() throws Exception {
    KnowledgeBase responsesElement = KnowledgeBase.newBuilder().build();
    ListKnowledgeBasesResponse expectedResponse =
        ListKnowledgeBasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllKnowledgeBases(Arrays.asList(responsesElement))
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListKnowledgeBasesPagedResponse pagedListResponse = client.listKnowledgeBases(parent);

    List<KnowledgeBase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKnowledgeBasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKnowledgeBasesRequest actualRequest = ((ListKnowledgeBasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKnowledgeBasesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listKnowledgeBases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKnowledgeBasesTest3() throws Exception {
    KnowledgeBase responsesElement = KnowledgeBase.newBuilder().build();
    ListKnowledgeBasesResponse expectedResponse =
        ListKnowledgeBasesResponse.newBuilder()
            .setNextPageToken("")
            .addAllKnowledgeBases(Arrays.asList(responsesElement))
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListKnowledgeBasesPagedResponse pagedListResponse = client.listKnowledgeBases(parent);

    List<KnowledgeBase> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKnowledgeBasesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKnowledgeBasesRequest actualRequest = ((ListKnowledgeBasesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKnowledgeBasesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listKnowledgeBases(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKnowledgeBaseTest() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    KnowledgeBaseName name =
        KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");

    KnowledgeBase actualResponse = client.getKnowledgeBase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKnowledgeBaseRequest actualRequest = ((GetKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKnowledgeBaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      KnowledgeBaseName name =
          KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
      client.getKnowledgeBase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKnowledgeBaseTest2() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    String name = "name3373707";

    KnowledgeBase actualResponse = client.getKnowledgeBase(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKnowledgeBaseRequest actualRequest = ((GetKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKnowledgeBaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      String name = "name3373707";
      client.getKnowledgeBase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKnowledgeBaseTest() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();

    KnowledgeBase actualResponse = client.createKnowledgeBase(parent, knowledgeBase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKnowledgeBaseRequest actualRequest = ((CreateKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(knowledgeBase, actualRequest.getKnowledgeBase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKnowledgeBaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
      client.createKnowledgeBase(parent, knowledgeBase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKnowledgeBaseTest2() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();

    KnowledgeBase actualResponse = client.createKnowledgeBase(parent, knowledgeBase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKnowledgeBaseRequest actualRequest = ((CreateKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(knowledgeBase, actualRequest.getKnowledgeBase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKnowledgeBaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
      client.createKnowledgeBase(parent, knowledgeBase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKnowledgeBaseTest3() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    String parent = "parent-995424086";
    KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();

    KnowledgeBase actualResponse = client.createKnowledgeBase(parent, knowledgeBase);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKnowledgeBaseRequest actualRequest = ((CreateKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(knowledgeBase, actualRequest.getKnowledgeBase());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKnowledgeBaseExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      String parent = "parent-995424086";
      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
      client.createKnowledgeBase(parent, knowledgeBase);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteKnowledgeBaseTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockKnowledgeBases.addResponse(expectedResponse);

    KnowledgeBaseName name =
        KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");

    client.deleteKnowledgeBase(name);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKnowledgeBaseRequest actualRequest = ((DeleteKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKnowledgeBaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      KnowledgeBaseName name =
          KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]");
      client.deleteKnowledgeBase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteKnowledgeBaseTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockKnowledgeBases.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteKnowledgeBase(name);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKnowledgeBaseRequest actualRequest = ((DeleteKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKnowledgeBaseExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      String name = "name3373707";
      client.deleteKnowledgeBase(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateKnowledgeBaseTest() throws Exception {
    KnowledgeBase expectedResponse =
        KnowledgeBase.newBuilder()
            .setName(
                KnowledgeBaseName.ofProjectKnowledgeBaseName("[PROJECT]", "[KNOWLEDGE_BASE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockKnowledgeBases.addResponse(expectedResponse);

    KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    KnowledgeBase actualResponse = client.updateKnowledgeBase(knowledgeBase, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockKnowledgeBases.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateKnowledgeBaseRequest actualRequest = ((UpdateKnowledgeBaseRequest) actualRequests.get(0));

    Assert.assertEquals(knowledgeBase, actualRequest.getKnowledgeBase());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateKnowledgeBaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockKnowledgeBases.addException(exception);

    try {
      KnowledgeBase knowledgeBase = KnowledgeBase.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateKnowledgeBase(knowledgeBase, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
