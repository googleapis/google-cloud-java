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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.DataStoreServiceClient.ListDataStoresPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class DataStoreServiceClientTest {
  private static MockDataStoreService mockDataStoreService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataStoreService = new MockDataStoreService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataStoreService, mockLocations));
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
    DataStoreServiceSettings settings =
        DataStoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataStoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataStoreService.addResponse(resultOperation);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    DataStore dataStore = DataStore.newBuilder().build();
    String dataStoreId = "dataStoreId929489618";

    DataStore actualResponse = client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataStoreRequest actualRequest = ((CreateDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataStore, actualRequest.getDataStore());
    Assert.assertEquals(dataStoreId, actualRequest.getDataStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      DataStore dataStore = DataStore.newBuilder().build();
      String dataStoreId = "dataStoreId929489618";
      client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataStoreTest2() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataStoreService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataStore dataStore = DataStore.newBuilder().build();
    String dataStoreId = "dataStoreId929489618";

    DataStore actualResponse = client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataStoreRequest actualRequest = ((CreateDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataStore, actualRequest.getDataStore());
    Assert.assertEquals(dataStoreId, actualRequest.getDataStoreId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataStore dataStore = DataStore.newBuilder().build();
      String dataStoreId = "dataStoreId929489618";
      client.createDataStoreAsync(parent, dataStore, dataStoreId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockDataStoreService.addResponse(expectedResponse);

    DataStoreName name =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    DataStore actualResponse = client.getDataStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataStoreRequest actualRequest = ((GetDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      DataStoreName name =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.getDataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataStoreTest2() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockDataStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    DataStore actualResponse = client.getDataStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataStoreRequest actualRequest = ((GetDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStoresTest() throws Exception {
    DataStore responsesElement = DataStore.newBuilder().build();
    ListDataStoresResponse expectedResponse =
        ListDataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStores(Arrays.asList(responsesElement))
            .build();
    mockDataStoreService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    ListDataStoresPagedResponse pagedListResponse = client.listDataStores(parent);

    List<DataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataStoresRequest actualRequest = ((ListDataStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      client.listDataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataStoresTest2() throws Exception {
    DataStore responsesElement = DataStore.newBuilder().build();
    ListDataStoresResponse expectedResponse =
        ListDataStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataStores(Arrays.asList(responsesElement))
            .build();
    mockDataStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataStoresPagedResponse pagedListResponse = client.listDataStores(parent);

    List<DataStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataStoresRequest actualRequest = ((ListDataStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataStoreService.addResponse(resultOperation);

    DataStoreName name =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    client.deleteDataStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataStoreRequest actualRequest = ((DeleteDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      DataStoreName name =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.deleteDataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataStoreTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataStoreService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataStoreAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataStoreRequest actualRequest = ((DeleteDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataStoreAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataStoreTest() throws Exception {
    DataStore expectedResponse =
        DataStore.newBuilder()
            .setName(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setIndustryVertical(IndustryVertical.forNumber(0))
            .addAllSolutionTypes(new ArrayList<SolutionType>())
            .setDefaultSchemaId("defaultSchemaId1300415485")
            .setCreateTime(Timestamp.newBuilder().build())
            .setStartingSchema(Schema.newBuilder().build())
            .build();
    mockDataStoreService.addResponse(expectedResponse);

    DataStore dataStore = DataStore.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataStore actualResponse = client.updateDataStore(dataStore, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataStoreRequest actualRequest = ((UpdateDataStoreRequest) actualRequests.get(0));

    Assert.assertEquals(dataStore, actualRequest.getDataStore());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataStoreService.addException(exception);

    try {
      DataStore dataStore = DataStore.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataStore(dataStore, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
