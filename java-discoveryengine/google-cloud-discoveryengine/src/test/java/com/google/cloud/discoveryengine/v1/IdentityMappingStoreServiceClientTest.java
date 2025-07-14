/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class IdentityMappingStoreServiceClientTest {
  private static MockIdentityMappingStoreService mockIdentityMappingStoreService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IdentityMappingStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIdentityMappingStoreService = new MockIdentityMappingStoreService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIdentityMappingStoreService, mockLocations));
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
    IdentityMappingStoreServiceSettings settings =
        IdentityMappingStoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityMappingStoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createIdentityMappingStoreTest() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
    String identityMappingStoreId = "identityMappingStoreId677904780";

    IdentityMappingStore actualResponse =
        client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIdentityMappingStoreRequest actualRequest =
        ((CreateIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(identityMappingStore, actualRequest.getIdentityMappingStore());
    Assert.assertEquals(identityMappingStoreId, actualRequest.getIdentityMappingStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIdentityMappingStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
      String identityMappingStoreId = "identityMappingStoreId677904780";
      client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIdentityMappingStoreTest2() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
    String identityMappingStoreId = "identityMappingStoreId677904780";

    IdentityMappingStore actualResponse =
        client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIdentityMappingStoreRequest actualRequest =
        ((CreateIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(identityMappingStore, actualRequest.getIdentityMappingStore());
    Assert.assertEquals(identityMappingStoreId, actualRequest.getIdentityMappingStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIdentityMappingStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      IdentityMappingStore identityMappingStore = IdentityMappingStore.newBuilder().build();
      String identityMappingStoreId = "identityMappingStoreId677904780";
      client.createIdentityMappingStore(parent, identityMappingStore, identityMappingStoreId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityMappingStoreTest() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    IdentityMappingStoreName name =
        IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");

    IdentityMappingStore actualResponse = client.getIdentityMappingStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIdentityMappingStoreRequest actualRequest =
        ((GetIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIdentityMappingStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      IdentityMappingStoreName name =
          IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
      client.getIdentityMappingStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityMappingStoreTest2() throws Exception {
    IdentityMappingStore expectedResponse =
        IdentityMappingStore.newBuilder()
            .setName(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setCmekConfig(CmekConfig.newBuilder().build())
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    IdentityMappingStore actualResponse = client.getIdentityMappingStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIdentityMappingStoreRequest actualRequest =
        ((GetIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIdentityMappingStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getIdentityMappingStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIdentityMappingStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIdentityMappingStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIdentityMappingStoreService.addResponse(resultOperation);

    IdentityMappingStoreName name =
        IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");

    client.deleteIdentityMappingStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIdentityMappingStoreRequest actualRequest =
        ((DeleteIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIdentityMappingStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      IdentityMappingStoreName name =
          IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]");
      client.deleteIdentityMappingStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIdentityMappingStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIdentityMappingStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIdentityMappingStoreService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIdentityMappingStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIdentityMappingStoreRequest actualRequest =
        ((DeleteIdentityMappingStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIdentityMappingStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIdentityMappingStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void importIdentityMappingsTest() throws Exception {
    ImportIdentityMappingsResponse expectedResponse =
        ImportIdentityMappingsResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importIdentityMappingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIdentityMappingStoreService.addResponse(resultOperation);

    ImportIdentityMappingsRequest request =
        ImportIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .build();

    ImportIdentityMappingsResponse actualResponse =
        client.importIdentityMappingsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportIdentityMappingsRequest actualRequest =
        ((ImportIdentityMappingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getIdentityMappingStore(), actualRequest.getIdentityMappingStore());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importIdentityMappingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      ImportIdentityMappingsRequest request =
          ImportIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .build();
      client.importIdentityMappingsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeIdentityMappingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeIdentityMappingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockIdentityMappingStoreService.addResponse(resultOperation);

    PurgeIdentityMappingsRequest request =
        PurgeIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setFilter("filter-1274492040")
            .setForce(true)
            .build();

    client.purgeIdentityMappingsAsync(request).get();

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeIdentityMappingsRequest actualRequest =
        ((PurgeIdentityMappingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getIdentityMappingStore(), actualRequest.getIdentityMappingStore());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getForce(), actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeIdentityMappingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      PurgeIdentityMappingsRequest request =
          PurgeIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setForce(true)
              .build();
      client.purgeIdentityMappingsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listIdentityMappingsTest() throws Exception {
    IdentityMappingEntry responsesElement = IdentityMappingEntry.newBuilder().build();
    ListIdentityMappingsResponse expectedResponse =
        ListIdentityMappingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingEntries(Arrays.asList(responsesElement))
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    ListIdentityMappingsRequest request =
        ListIdentityMappingsRequest.newBuilder()
            .setIdentityMappingStore(
                IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                    .toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIdentityMappingsPagedResponse pagedListResponse = client.listIdentityMappings(request);

    List<IdentityMappingEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIdentityMappingsRequest actualRequest =
        ((ListIdentityMappingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getIdentityMappingStore(), actualRequest.getIdentityMappingStore());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIdentityMappingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      ListIdentityMappingsRequest request =
          ListIdentityMappingsRequest.newBuilder()
              .setIdentityMappingStore(
                  IdentityMappingStoreName.of("[PROJECT]", "[LOCATION]", "[IDENTITY_MAPPING_STORE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIdentityMappings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityMappingStoresTest() throws Exception {
    IdentityMappingStore responsesElement = IdentityMappingStore.newBuilder().build();
    ListIdentityMappingStoresResponse expectedResponse =
        ListIdentityMappingStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingStores(Arrays.asList(responsesElement))
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIdentityMappingStoresPagedResponse pagedListResponse =
        client.listIdentityMappingStores(parent);

    List<IdentityMappingStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIdentityMappingStoresRequest actualRequest =
        ((ListIdentityMappingStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIdentityMappingStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIdentityMappingStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityMappingStoresTest2() throws Exception {
    IdentityMappingStore responsesElement = IdentityMappingStore.newBuilder().build();
    ListIdentityMappingStoresResponse expectedResponse =
        ListIdentityMappingStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityMappingStores(Arrays.asList(responsesElement))
            .build();
    mockIdentityMappingStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIdentityMappingStoresPagedResponse pagedListResponse =
        client.listIdentityMappingStores(parent);

    List<IdentityMappingStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIdentityMappingStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityMappingStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIdentityMappingStoresRequest actualRequest =
        ((ListIdentityMappingStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIdentityMappingStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityMappingStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIdentityMappingStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
