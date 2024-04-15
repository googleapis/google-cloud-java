/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CatalogServiceClientTest {
  private static MockCatalogService mockCatalogService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CatalogServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCatalogService = new MockCatalogService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCatalogService, mockLocations, mockIAMPolicy));
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
    CatalogServiceSettings settings =
        CatalogServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CatalogServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EntryType entryType = EntryType.newBuilder().build();
    String entryTypeId = "entryTypeId-1105721081";

    EntryType actualResponse = client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryTypeRequest actualRequest = ((CreateEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entryType, actualRequest.getEntryType());
    Assert.assertEquals(entryTypeId, actualRequest.getEntryTypeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EntryType entryType = EntryType.newBuilder().build();
      String entryTypeId = "entryTypeId-1105721081";
      client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEntryTypeTest2() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String parent = "parent-995424086";
    EntryType entryType = EntryType.newBuilder().build();
    String entryTypeId = "entryTypeId-1105721081";

    EntryType actualResponse = client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryTypeRequest actualRequest = ((CreateEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entryType, actualRequest.getEntryType());
    Assert.assertEquals(entryTypeId, actualRequest.getEntryTypeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      EntryType entryType = EntryType.newBuilder().build();
      String entryTypeId = "entryTypeId-1105721081";
      client.createEntryTypeAsync(parent, entryType, entryTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    EntryType entryType = EntryType.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntryType actualResponse = client.updateEntryTypeAsync(entryType, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryTypeRequest actualRequest = ((UpdateEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(entryType, actualRequest.getEntryType());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryType entryType = EntryType.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntryTypeAsync(entryType, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntryTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");

    client.deleteEntryTypeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryTypeRequest actualRequest = ((DeleteEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
      client.deleteEntryTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntryTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEntryTypeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryTypeRequest actualRequest = ((DeleteEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntryTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEntryTypesTest() throws Exception {
    EntryType responsesElement = EntryType.newBuilder().build();
    ListEntryTypesResponse expectedResponse =
        ListEntryTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryTypes(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntryTypesPagedResponse pagedListResponse = client.listEntryTypes(parent);

    List<EntryType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryTypesRequest actualRequest = ((ListEntryTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntryTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryTypesTest2() throws Exception {
    EntryType responsesElement = EntryType.newBuilder().build();
    ListEntryTypesResponse expectedResponse =
        ListEntryTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryTypes(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntryTypesPagedResponse pagedListResponse = client.listEntryTypes(parent);

    List<EntryType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryTypesRequest actualRequest = ((ListEntryTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntryTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTypeTest() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");

    EntryType actualResponse = client.getEntryType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryTypeRequest actualRequest = ((GetEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryTypeName name = EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]");
      client.getEntryType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTypeTest2() throws Exception {
    EntryType expectedResponse =
        EntryType.newBuilder()
            .setName(EntryTypeName.of("[PROJECT]", "[LOCATION]", "[ENTRY_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllTypeAliases(new ArrayList<String>())
            .setPlatform("platform1874684019")
            .setSystem("system-887328209")
            .addAllRequiredAspects(new ArrayList<EntryType.AspectInfo>())
            .setAuthorization(EntryType.Authorization.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    EntryType actualResponse = client.getEntryType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryTypeRequest actualRequest = ((GetEntryTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.getEntryType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AspectType aspectType = AspectType.newBuilder().build();
    String aspectTypeId = "aspectTypeId-423030675";

    AspectType actualResponse =
        client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAspectTypeRequest actualRequest = ((CreateAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(aspectType, actualRequest.getAspectType());
    Assert.assertEquals(aspectTypeId, actualRequest.getAspectTypeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAspectTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AspectType aspectType = AspectType.newBuilder().build();
      String aspectTypeId = "aspectTypeId-423030675";
      client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAspectTypeTest2() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String parent = "parent-995424086";
    AspectType aspectType = AspectType.newBuilder().build();
    String aspectTypeId = "aspectTypeId-423030675";

    AspectType actualResponse =
        client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAspectTypeRequest actualRequest = ((CreateAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(aspectType, actualRequest.getAspectType());
    Assert.assertEquals(aspectTypeId, actualRequest.getAspectTypeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAspectTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      AspectType aspectType = AspectType.newBuilder().build();
      String aspectTypeId = "aspectTypeId-423030675";
      client.createAspectTypeAsync(parent, aspectType, aspectTypeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    AspectType aspectType = AspectType.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AspectType actualResponse = client.updateAspectTypeAsync(aspectType, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAspectTypeRequest actualRequest = ((UpdateAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(aspectType, actualRequest.getAspectType());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAspectTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      AspectType aspectType = AspectType.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAspectTypeAsync(aspectType, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAspectTypeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");

    client.deleteAspectTypeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAspectTypeRequest actualRequest = ((DeleteAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAspectTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
      client.deleteAspectTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAspectTypeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAspectTypeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAspectTypeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAspectTypeRequest actualRequest = ((DeleteAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAspectTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAspectTypeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAspectTypesTest() throws Exception {
    AspectType responsesElement = AspectType.newBuilder().build();
    ListAspectTypesResponse expectedResponse =
        ListAspectTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAspectTypes(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAspectTypesPagedResponse pagedListResponse = client.listAspectTypes(parent);

    List<AspectType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAspectTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAspectTypesRequest actualRequest = ((ListAspectTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAspectTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAspectTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAspectTypesTest2() throws Exception {
    AspectType responsesElement = AspectType.newBuilder().build();
    ListAspectTypesResponse expectedResponse =
        ListAspectTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAspectTypes(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAspectTypesPagedResponse pagedListResponse = client.listAspectTypes(parent);

    List<AspectType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAspectTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAspectTypesRequest actualRequest = ((ListAspectTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAspectTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAspectTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAspectTypeTest() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");

    AspectType actualResponse = client.getAspectType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAspectTypeRequest actualRequest = ((GetAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAspectTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      AspectTypeName name = AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]");
      client.getAspectType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAspectTypeTest2() throws Exception {
    AspectType expectedResponse =
        AspectType.newBuilder()
            .setName(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setAuthorization(AspectType.Authorization.newBuilder().build())
            .setMetadataTemplate(AspectType.MetadataTemplate.newBuilder().build())
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    AspectType actualResponse = client.getAspectType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAspectTypeRequest actualRequest = ((GetAspectTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAspectTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.getAspectType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    String entryGroupId = "entryGroupId1228924712";

    EntryGroup actualResponse =
        client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryGroupRequest actualRequest = ((CreateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertEquals(entryGroupId, actualRequest.getEntryGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      String entryGroupId = "entryGroupId1228924712";
      client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String parent = "parent-995424086";
    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    String entryGroupId = "entryGroupId1228924712";

    EntryGroup actualResponse =
        client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryGroupRequest actualRequest = ((CreateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertEquals(entryGroupId, actualRequest.getEntryGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      String entryGroupId = "entryGroupId1228924712";
      client.createEntryGroupAsync(parent, entryGroup, entryGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    EntryGroup entryGroup = EntryGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EntryGroup actualResponse = client.updateEntryGroupAsync(entryGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryGroupRequest actualRequest = ((UpdateEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(entryGroup, actualRequest.getEntryGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryGroup entryGroup = EntryGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntryGroupAsync(entryGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntryGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    client.deleteEntryGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryGroupRequest actualRequest = ((DeleteEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.deleteEntryGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEntryGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEntryGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCatalogService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEntryGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryGroupRequest actualRequest = ((DeleteEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntryGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEntryGroupsTest() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryGroupsRequest actualRequest = ((ListEntryGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntryGroupsTest2() throws Exception {
    EntryGroup responsesElement = EntryGroup.newBuilder().build();
    ListEntryGroupsResponse expectedResponse =
        ListEntryGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntryGroups(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntryGroupsPagedResponse pagedListResponse = client.listEntryGroups(parent);

    List<EntryGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntryGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntryGroupsRequest actualRequest = ((ListEntryGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntryGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntryGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    EntryGroup actualResponse = client.getEntryGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryGroupTest2() throws Exception {
    EntryGroup expectedResponse =
        EntryGroup.newBuilder()
            .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setTransferStatus(TransferStatus.forNumber(0))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    EntryGroup actualResponse = client.getEntryGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryGroupRequest actualRequest = ((GetEntryGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.getEntryGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
    Entry entry = Entry.newBuilder().build();
    String entryId = "entryId-1591558867";

    Entry actualResponse = client.createEntry(parent, entry, entryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryRequest actualRequest = ((CreateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertEquals(entryId, actualRequest.getEntryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      Entry entry = Entry.newBuilder().build();
      String entryId = "entryId-1591558867";
      client.createEntry(parent, entry, entryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Entry entry = Entry.newBuilder().build();
    String entryId = "entryId-1591558867";

    Entry actualResponse = client.createEntry(parent, entry, entryId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEntryRequest actualRequest = ((CreateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertEquals(entryId, actualRequest.getEntryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      Entry entry = Entry.newBuilder().build();
      String entryId = "entryId-1591558867";
      client.createEntry(parent, entry, entryId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    Entry entry = Entry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entry actualResponse = client.updateEntry(entry, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryRequest actualRequest = ((UpdateEntryRequest) actualRequests.get(0));

    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      Entry entry = Entry.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEntry(entry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.deleteEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryRequest actualRequest = ((DeleteEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    Entry actualResponse = client.deleteEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEntryRequest actualRequest = ((DeleteEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntriesRequest actualRequest = ((ListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEntriesTest2() throws Exception {
    Entry responsesElement = Entry.newBuilder().build();
    ListEntriesResponse expectedResponse =
        ListEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllEntries(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEntriesPagedResponse pagedListResponse = client.listEntries(parent);

    List<Entry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEntriesRequest actualRequest = ((ListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEntriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.getEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryRequest actualRequest = ((GetEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEntryTest2() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";

    Entry actualResponse = client.getEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryRequest actualRequest = ((GetEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      client.getEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupEntryTest() throws Exception {
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .setEntryType("entryType-479362356")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllAspects(new HashMap<String, Aspect>())
            .setParentEntry("parentEntry991029736")
            .setFullyQualifiedName("fullyQualifiedName288467357")
            .setEntrySource(EntrySource.newBuilder().build())
            .build();
    mockCatalogService.addResponse(expectedResponse);

    LookupEntryRequest request =
        LookupEntryRequest.newBuilder()
            .setName("name3373707")
            .setView(EntryView.forNumber(0))
            .addAllAspectTypes(new ArrayList<String>())
            .addAllPaths(new ArrayList<String>())
            .setEntry(
                EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
            .build();

    Entry actualResponse = client.lookupEntry(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupEntryRequest actualRequest = ((LookupEntryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getAspectTypesList(), actualRequest.getAspectTypesList());
    Assert.assertEquals(request.getPathsList(), actualRequest.getPathsList());
    Assert.assertEquals(request.getEntry(), actualRequest.getEntry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      LookupEntryRequest request =
          LookupEntryRequest.newBuilder()
              .setName("name3373707")
              .setView(EntryView.forNumber(0))
              .addAllAspectTypes(new ArrayList<String>())
              .addAllPaths(new ArrayList<String>())
              .setEntry(
                  EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
              .build();
      client.lookupEntry(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchEntriesTest() throws Exception {
    SearchEntriesResult responsesElement = SearchEntriesResult.newBuilder().build();
    SearchEntriesResponse expectedResponse =
        SearchEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockCatalogService.addResponse(expectedResponse);

    String name = "name3373707";
    String query = "query107944136";

    SearchEntriesPagedResponse pagedListResponse = client.searchEntries(name, query);

    List<SearchEntriesResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCatalogService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchEntriesRequest actualRequest = ((SearchEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCatalogService.addException(exception);

    try {
      String name = "name3373707";
      String query = "query107944136";
      client.searchEntries(name, query);
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
