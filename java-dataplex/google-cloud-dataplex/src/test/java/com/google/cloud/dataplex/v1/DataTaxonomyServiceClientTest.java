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

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

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
public class DataTaxonomyServiceClientTest {
  private static MockDataTaxonomyService mockDataTaxonomyService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataTaxonomyServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataTaxonomyService = new MockDataTaxonomyService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataTaxonomyService, mockLocations, mockIAMPolicy));
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
    DataTaxonomyServiceSettings settings =
        DataTaxonomyServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataTaxonomyServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
    String dataTaxonomyId = "dataTaxonomyId987458454";

    DataTaxonomy actualResponse =
        client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTaxonomyRequest actualRequest = ((CreateDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataTaxonomy, actualRequest.getDataTaxonomy());
    Assert.assertEquals(dataTaxonomyId, actualRequest.getDataTaxonomyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
      String dataTaxonomyId = "dataTaxonomyId987458454";
      client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataTaxonomyTest2() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
    String dataTaxonomyId = "dataTaxonomyId987458454";

    DataTaxonomy actualResponse =
        client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataTaxonomyRequest actualRequest = ((CreateDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataTaxonomy, actualRequest.getDataTaxonomy());
    Assert.assertEquals(dataTaxonomyId, actualRequest.getDataTaxonomyId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
      String dataTaxonomyId = "dataTaxonomyId987458454";
      client.createDataTaxonomyAsync(parent, dataTaxonomy, dataTaxonomyId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataTaxonomy actualResponse = client.updateDataTaxonomyAsync(dataTaxonomy, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataTaxonomyRequest actualRequest = ((UpdateDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(dataTaxonomy, actualRequest.getDataTaxonomy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataTaxonomy dataTaxonomy = DataTaxonomy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataTaxonomyAsync(dataTaxonomy, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataTaxonomyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    client.deleteDataTaxonomyAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTaxonomyRequest actualRequest = ((DeleteDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.deleteDataTaxonomyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataTaxonomyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataTaxonomyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataTaxonomyAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataTaxonomyRequest actualRequest = ((DeleteDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataTaxonomyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDataTaxonomiesTest() throws Exception {
    DataTaxonomy responsesElement = DataTaxonomy.newBuilder().build();
    ListDataTaxonomiesResponse expectedResponse =
        ListDataTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataTaxonomiesPagedResponse pagedListResponse = client.listDataTaxonomies(parent);

    List<DataTaxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTaxonomiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTaxonomiesRequest actualRequest = ((ListDataTaxonomiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTaxonomiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataTaxonomiesTest2() throws Exception {
    DataTaxonomy responsesElement = DataTaxonomy.newBuilder().build();
    ListDataTaxonomiesResponse expectedResponse =
        ListDataTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataTaxonomiesPagedResponse pagedListResponse = client.listDataTaxonomies(parent);

    List<DataTaxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataTaxonomiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataTaxonomiesRequest actualRequest = ((ListDataTaxonomiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataTaxonomiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTaxonomyTest() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    DataTaxonomy actualResponse = client.getDataTaxonomy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTaxonomyRequest actualRequest = ((GetDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTaxonomyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataTaxonomyName name = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.getDataTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataTaxonomyTest2() throws Exception {
    DataTaxonomy expectedResponse =
        DataTaxonomy.newBuilder()
            .setName(
                DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setClassCount(-424516728)
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String name = "name3373707";

    DataTaxonomy actualResponse = client.getDataTaxonomy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataTaxonomyRequest actualRequest = ((GetDataTaxonomyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataTaxonomyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
    String dataAttributeBindingId = "dataAttributeBindingId1952425102";

    DataAttributeBinding actualResponse =
        client
            .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAttributeBindingRequest actualRequest =
        ((CreateDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAttributeBinding, actualRequest.getDataAttributeBinding());
    Assert.assertEquals(dataAttributeBindingId, actualRequest.getDataAttributeBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAttributeBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
      String dataAttributeBindingId = "dataAttributeBindingId1952425102";
      client
          .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataAttributeBindingTest2() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
    String dataAttributeBindingId = "dataAttributeBindingId1952425102";

    DataAttributeBinding actualResponse =
        client
            .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAttributeBindingRequest actualRequest =
        ((CreateDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAttributeBinding, actualRequest.getDataAttributeBinding());
    Assert.assertEquals(dataAttributeBindingId, actualRequest.getDataAttributeBindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAttributeBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
      String dataAttributeBindingId = "dataAttributeBindingId1952425102";
      client
          .createDataAttributeBindingAsync(parent, dataAttributeBinding, dataAttributeBindingId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAttributeBinding actualResponse =
        client.updateDataAttributeBindingAsync(dataAttributeBinding, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAttributeBindingRequest actualRequest =
        ((UpdateDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(dataAttributeBinding, actualRequest.getDataAttributeBinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAttributeBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttributeBinding dataAttributeBinding = DataAttributeBinding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAttributeBindingAsync(dataAttributeBinding, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAttributeBindingTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataAttributeBindingName name =
        DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");

    client.deleteDataAttributeBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAttributeBindingRequest actualRequest =
        ((DeleteDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAttributeBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttributeBindingName name =
          DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
      client.deleteDataAttributeBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAttributeBindingTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeBindingTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataAttributeBindingAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAttributeBindingRequest actualRequest =
        ((DeleteDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAttributeBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAttributeBindingAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDataAttributeBindingsTest() throws Exception {
    DataAttributeBinding responsesElement = DataAttributeBinding.newBuilder().build();
    ListDataAttributeBindingsResponse expectedResponse =
        ListDataAttributeBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributeBindings(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataAttributeBindingsPagedResponse pagedListResponse =
        client.listDataAttributeBindings(parent);

    List<DataAttributeBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributeBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAttributeBindingsRequest actualRequest =
        ((ListDataAttributeBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAttributeBindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataAttributeBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAttributeBindingsTest2() throws Exception {
    DataAttributeBinding responsesElement = DataAttributeBinding.newBuilder().build();
    ListDataAttributeBindingsResponse expectedResponse =
        ListDataAttributeBindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributeBindings(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAttributeBindingsPagedResponse pagedListResponse =
        client.listDataAttributeBindings(parent);

    List<DataAttributeBinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributeBindingsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAttributeBindingsRequest actualRequest =
        ((ListDataAttributeBindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAttributeBindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAttributeBindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeBindingTest() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    DataAttributeBindingName name =
        DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");

    DataAttributeBinding actualResponse = client.getDataAttributeBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAttributeBindingRequest actualRequest =
        ((GetDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAttributeBindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttributeBindingName name =
          DataAttributeBindingName.of("[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]");
      client.getDataAttributeBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeBindingTest2() throws Exception {
    DataAttributeBinding expectedResponse =
        DataAttributeBinding.newBuilder()
            .setName(
                DataAttributeBindingName.of(
                        "[PROJECT]", "[LOCATION]", "[DATA_ATTRIBUTE_BINDING_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .addAllAttributes(new ArrayList<String>())
            .addAllPaths(new ArrayList<DataAttributeBinding.Path>())
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAttributeBinding actualResponse = client.getDataAttributeBinding(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAttributeBindingRequest actualRequest =
        ((GetDataAttributeBindingRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAttributeBindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAttributeBinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataTaxonomyName parent = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
    DataAttribute dataAttribute = DataAttribute.newBuilder().build();
    String dataAttributeId = "dataAttributeId-44128563";

    DataAttribute actualResponse =
        client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAttributeRequest actualRequest = ((CreateDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAttribute, actualRequest.getDataAttribute());
    Assert.assertEquals(dataAttributeId, actualRequest.getDataAttributeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataTaxonomyName parent =
          DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      DataAttribute dataAttribute = DataAttribute.newBuilder().build();
      String dataAttributeId = "dataAttributeId-44128563";
      client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataAttributeTest2() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataAttribute dataAttribute = DataAttribute.newBuilder().build();
    String dataAttributeId = "dataAttributeId-44128563";

    DataAttribute actualResponse =
        client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAttributeRequest actualRequest = ((CreateDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAttribute, actualRequest.getDataAttribute());
    Assert.assertEquals(dataAttributeId, actualRequest.getDataAttributeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAttribute dataAttribute = DataAttribute.newBuilder().build();
      String dataAttributeId = "dataAttributeId-44128563";
      client.createDataAttributeAsync(parent, dataAttribute, dataAttributeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataAttribute dataAttribute = DataAttribute.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAttribute actualResponse = client.updateDataAttributeAsync(dataAttribute, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAttributeRequest actualRequest = ((UpdateDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(dataAttribute, actualRequest.getDataAttribute());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttribute dataAttribute = DataAttribute.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAttributeAsync(dataAttribute, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAttributeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    DataAttributeName name =
        DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");

    client.deleteDataAttributeAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAttributeRequest actualRequest = ((DeleteDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttributeName name =
          DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
      client.deleteDataAttributeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAttributeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAttributeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataTaxonomyService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataAttributeAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAttributeRequest actualRequest = ((DeleteDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAttributeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDataAttributesTest() throws Exception {
    DataAttribute responsesElement = DataAttribute.newBuilder().build();
    ListDataAttributesResponse expectedResponse =
        ListDataAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributes(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    DataTaxonomyName parent = DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");

    ListDataAttributesPagedResponse pagedListResponse = client.listDataAttributes(parent);

    List<DataAttribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAttributesRequest actualRequest = ((ListDataAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAttributesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataTaxonomyName parent =
          DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]");
      client.listDataAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAttributesTest2() throws Exception {
    DataAttribute responsesElement = DataAttribute.newBuilder().build();
    ListDataAttributesResponse expectedResponse =
        ListDataAttributesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAttributes(Arrays.asList(responsesElement))
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAttributesPagedResponse pagedListResponse = client.listDataAttributes(parent);

    List<DataAttribute> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAttributesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAttributesRequest actualRequest = ((ListDataAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAttributesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAttributes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeTest() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    DataAttributeName name =
        DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");

    DataAttribute actualResponse = client.getDataAttribute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAttributeRequest actualRequest = ((GetDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAttributeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      DataAttributeName name =
          DataAttributeName.of("[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]");
      client.getDataAttribute(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAttributeTest2() throws Exception {
    DataAttribute expectedResponse =
        DataAttribute.newBuilder()
            .setName(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setParentId(
                DataAttributeName.of(
                        "[PROJECT]", "[LOCATION]", "[DATATAXONOMY]", "[DATA_ATTRIBUTE_ID]")
                    .toString())
            .setAttributeCount(-688916052)
            .setEtag("etag3123477")
            .setResourceAccessSpec(ResourceAccessSpec.newBuilder().build())
            .setDataAccessSpec(DataAccessSpec.newBuilder().build())
            .build();
    mockDataTaxonomyService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAttribute actualResponse = client.getDataAttribute(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataTaxonomyService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAttributeRequest actualRequest = ((GetDataAttributeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAttributeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataTaxonomyService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAttribute(name);
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
