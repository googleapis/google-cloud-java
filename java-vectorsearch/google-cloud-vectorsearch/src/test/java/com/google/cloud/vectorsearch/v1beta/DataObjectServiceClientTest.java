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

package com.google.cloud.vectorsearch.v1beta;

import static com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient.ListLocationsPagedResponse;

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
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class DataObjectServiceClientTest {
  private static MockDataObjectService mockDataObjectService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataObjectServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataObjectService = new MockDataObjectService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataObjectService, mockLocations));
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
    DataObjectServiceSettings settings =
        DataObjectServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataObjectServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataObjectTest() throws Exception {
    DataObject expectedResponse =
        DataObject.newBuilder()
            .setName(
                DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
                    .toString())
            .setDataObjectId("dataObjectId1417732740")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(Struct.newBuilder().build())
            .putAllVectors(new HashMap<String, Vector>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    DataObject dataObject = DataObject.newBuilder().build();
    String dataObjectId = "dataObjectId1417732740";

    DataObject actualResponse = client.createDataObject(parent, dataObject, dataObjectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataObjectRequest actualRequest = ((CreateDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataObject, actualRequest.getDataObject());
    Assert.assertEquals(dataObjectId, actualRequest.getDataObjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      DataObject dataObject = DataObject.newBuilder().build();
      String dataObjectId = "dataObjectId1417732740";
      client.createDataObject(parent, dataObject, dataObjectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataObjectTest2() throws Exception {
    DataObject expectedResponse =
        DataObject.newBuilder()
            .setName(
                DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
                    .toString())
            .setDataObjectId("dataObjectId1417732740")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(Struct.newBuilder().build())
            .putAllVectors(new HashMap<String, Vector>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataObject dataObject = DataObject.newBuilder().build();
    String dataObjectId = "dataObjectId1417732740";

    DataObject actualResponse = client.createDataObject(parent, dataObject, dataObjectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataObjectRequest actualRequest = ((CreateDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataObject, actualRequest.getDataObject());
    Assert.assertEquals(dataObjectId, actualRequest.getDataObjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataObjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataObject dataObject = DataObject.newBuilder().build();
      String dataObjectId = "dataObjectId1417732740";
      client.createDataObject(parent, dataObject, dataObjectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateDataObjectsTest() throws Exception {
    BatchCreateDataObjectsResponse expectedResponse =
        BatchCreateDataObjectsResponse.newBuilder()
            .addAllDataObjects(new ArrayList<DataObject>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    BatchCreateDataObjectsRequest request =
        BatchCreateDataObjectsRequest.newBuilder()
            .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .addAllRequests(new ArrayList<CreateDataObjectRequest>())
            .build();

    BatchCreateDataObjectsResponse actualResponse = client.batchCreateDataObjects(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateDataObjectsRequest actualRequest =
        ((BatchCreateDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestsList(), actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      BatchCreateDataObjectsRequest request =
          BatchCreateDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .addAllRequests(new ArrayList<CreateDataObjectRequest>())
              .build();
      client.batchCreateDataObjects(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataObjectTest() throws Exception {
    DataObject expectedResponse =
        DataObject.newBuilder()
            .setName(
                DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
                    .toString())
            .setDataObjectId("dataObjectId1417732740")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(Struct.newBuilder().build())
            .putAllVectors(new HashMap<String, Vector>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    DataObjectName name =
        DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");

    DataObject actualResponse = client.getDataObject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataObjectRequest actualRequest = ((GetDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      DataObjectName name =
          DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");
      client.getDataObject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataObjectTest2() throws Exception {
    DataObject expectedResponse =
        DataObject.newBuilder()
            .setName(
                DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
                    .toString())
            .setDataObjectId("dataObjectId1417732740")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(Struct.newBuilder().build())
            .putAllVectors(new HashMap<String, Vector>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    String name = "name3373707";

    DataObject actualResponse = client.getDataObject(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataObjectRequest actualRequest = ((GetDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataObjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataObject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataObjectTest() throws Exception {
    DataObject expectedResponse =
        DataObject.newBuilder()
            .setName(
                DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]")
                    .toString())
            .setDataObjectId("dataObjectId1417732740")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setData(Struct.newBuilder().build())
            .putAllVectors(new HashMap<String, Vector>())
            .build();
    mockDataObjectService.addResponse(expectedResponse);

    DataObject dataObject = DataObject.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataObject actualResponse = client.updateDataObject(dataObject, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataObjectRequest actualRequest = ((UpdateDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(dataObject, actualRequest.getDataObject());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      DataObject dataObject = DataObject.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataObject(dataObject, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDataObjectsTest() throws Exception {
    BatchUpdateDataObjectsResponse expectedResponse =
        BatchUpdateDataObjectsResponse.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    List<UpdateDataObjectRequest> requests = new ArrayList<>();

    BatchUpdateDataObjectsResponse actualResponse = client.batchUpdateDataObjects(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateDataObjectsRequest actualRequest =
        ((BatchUpdateDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      List<UpdateDataObjectRequest> requests = new ArrayList<>();
      client.batchUpdateDataObjects(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDataObjectsTest2() throws Exception {
    BatchUpdateDataObjectsResponse expectedResponse =
        BatchUpdateDataObjectsResponse.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<UpdateDataObjectRequest> requests = new ArrayList<>();

    BatchUpdateDataObjectsResponse actualResponse = client.batchUpdateDataObjects(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateDataObjectsRequest actualRequest =
        ((BatchUpdateDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateDataObjectsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<UpdateDataObjectRequest> requests = new ArrayList<>();
      client.batchUpdateDataObjects(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataObjectTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    DataObjectName name =
        DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");

    client.deleteDataObject(name);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataObjectRequest actualRequest = ((DeleteDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataObjectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      DataObjectName name =
          DataObjectName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATAOBJECT]");
      client.deleteDataObject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataObjectTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataObject(name);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataObjectRequest actualRequest = ((DeleteDataObjectRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataObjectExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataObject(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteDataObjectsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    List<DeleteDataObjectRequest> requests = new ArrayList<>();

    client.batchDeleteDataObjects(parent, requests);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteDataObjectsRequest actualRequest =
        ((BatchDeleteDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
      List<DeleteDataObjectRequest> requests = new ArrayList<>();
      client.batchDeleteDataObjects(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteDataObjectsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataObjectService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<DeleteDataObjectRequest> requests = new ArrayList<>();

    client.batchDeleteDataObjects(parent, requests);

    List<AbstractMessage> actualRequests = mockDataObjectService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchDeleteDataObjectsRequest actualRequest =
        ((BatchDeleteDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchDeleteDataObjectsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<DeleteDataObjectRequest> requests = new ArrayList<>();
      client.batchDeleteDataObjects(parent, requests);
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
