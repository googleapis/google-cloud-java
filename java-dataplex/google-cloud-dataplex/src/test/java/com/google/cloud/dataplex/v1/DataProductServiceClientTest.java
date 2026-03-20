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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

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
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
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
public class DataProductServiceClientTest {
  private static MockDataProductService mockDataProductService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataProductServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataProductService = new MockDataProductService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataProductService, mockLocations, mockIAMPolicy));
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
    DataProductServiceSettings settings =
        DataProductServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataProductServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDataProductTest() throws Exception {
    DataProduct expectedResponse =
        DataProduct.newBuilder()
            .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllOwnerEmails(new ArrayList<String>())
            .setAssetCount(1582344960)
            .putAllAccessGroups(new HashMap<String, DataProduct.AccessGroup>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataProductTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DataProduct dataProduct = DataProduct.newBuilder().build();
    String dataProductId = "dataProductId1437828576";

    DataProduct actualResponse =
        client.createDataProductAsync(parent, dataProduct, dataProductId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataProductRequest actualRequest = ((CreateDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataProduct, actualRequest.getDataProduct());
    Assert.assertEquals(dataProductId, actualRequest.getDataProductId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DataProduct dataProduct = DataProduct.newBuilder().build();
      String dataProductId = "dataProductId1437828576";
      client.createDataProductAsync(parent, dataProduct, dataProductId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataProductTest2() throws Exception {
    DataProduct expectedResponse =
        DataProduct.newBuilder()
            .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllOwnerEmails(new ArrayList<String>())
            .setAssetCount(1582344960)
            .putAllAccessGroups(new HashMap<String, DataProduct.AccessGroup>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataProductTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataProduct dataProduct = DataProduct.newBuilder().build();
    String dataProductId = "dataProductId1437828576";

    DataProduct actualResponse =
        client.createDataProductAsync(parent, dataProduct, dataProductId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataProductRequest actualRequest = ((CreateDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataProduct, actualRequest.getDataProduct());
    Assert.assertEquals(dataProductId, actualRequest.getDataProductId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataProduct dataProduct = DataProduct.newBuilder().build();
      String dataProductId = "dataProductId1437828576";
      client.createDataProductAsync(parent, dataProduct, dataProductId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataProductTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataProductTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");

    client.deleteDataProductAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataProductRequest actualRequest = ((DeleteDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
      client.deleteDataProductAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataProductTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataProductTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataProductAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataProductRequest actualRequest = ((DeleteDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataProductAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataProductTest() throws Exception {
    DataProduct expectedResponse =
        DataProduct.newBuilder()
            .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllOwnerEmails(new ArrayList<String>())
            .setAssetCount(1582344960)
            .putAllAccessGroups(new HashMap<String, DataProduct.AccessGroup>())
            .build();
    mockDataProductService.addResponse(expectedResponse);

    DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");

    DataProduct actualResponse = client.getDataProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataProductRequest actualRequest = ((GetDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataProductName name = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
      client.getDataProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataProductTest2() throws Exception {
    DataProduct expectedResponse =
        DataProduct.newBuilder()
            .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllOwnerEmails(new ArrayList<String>())
            .setAssetCount(1582344960)
            .putAllAccessGroups(new HashMap<String, DataProduct.AccessGroup>())
            .build();
    mockDataProductService.addResponse(expectedResponse);

    String name = "name3373707";

    DataProduct actualResponse = client.getDataProduct(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataProductRequest actualRequest = ((GetDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataProductExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataProduct(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataProductsTest() throws Exception {
    DataProduct responsesElement = DataProduct.newBuilder().build();
    ListDataProductsResponse expectedResponse =
        ListDataProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataProducts(Arrays.asList(responsesElement))
            .build();
    mockDataProductService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDataProductsPagedResponse pagedListResponse = client.listDataProducts(parent);

    List<DataProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataProductsRequest actualRequest = ((ListDataProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataProductsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDataProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataProductsTest2() throws Exception {
    DataProduct responsesElement = DataProduct.newBuilder().build();
    ListDataProductsResponse expectedResponse =
        ListDataProductsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataProducts(Arrays.asList(responsesElement))
            .build();
    mockDataProductService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataProductsPagedResponse pagedListResponse = client.listDataProducts(parent);

    List<DataProduct> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataProductsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataProductsRequest actualRequest = ((ListDataProductsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataProductsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataProducts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataProductTest() throws Exception {
    DataProduct expectedResponse =
        DataProduct.newBuilder()
            .setName(DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]").toString())
            .setUid("uid115792")
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setIcon(ByteString.EMPTY)
            .addAllOwnerEmails(new ArrayList<String>())
            .setAssetCount(1582344960)
            .putAllAccessGroups(new HashMap<String, DataProduct.AccessGroup>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataProductTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    DataProduct dataProduct = DataProduct.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataProduct actualResponse = client.updateDataProductAsync(dataProduct, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataProductRequest actualRequest = ((UpdateDataProductRequest) actualRequests.get(0));

    Assert.assertEquals(dataProduct, actualRequest.getDataProduct());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataProductExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataProduct dataProduct = DataProduct.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataProductAsync(dataProduct, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataAssetTest() throws Exception {
    DataAsset expectedResponse =
        DataAsset.newBuilder()
            .setName(
                DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setResource("resource-341064690")
            .putAllAccessGroupConfigs(new HashMap<String, DataAsset.AccessGroupConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
    DataAsset dataAsset = DataAsset.newBuilder().build();
    String dataAssetId = "dataAssetId2108984609";

    DataAsset actualResponse = client.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAssetRequest actualRequest = ((CreateDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataAsset, actualRequest.getDataAsset());
    Assert.assertEquals(dataAssetId, actualRequest.getDataAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
      DataAsset dataAsset = DataAsset.newBuilder().build();
      String dataAssetId = "dataAssetId2108984609";
      client.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDataAssetTest2() throws Exception {
    DataAsset expectedResponse =
        DataAsset.newBuilder()
            .setName(
                DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setResource("resource-341064690")
            .putAllAccessGroupConfigs(new HashMap<String, DataAsset.AccessGroupConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDataAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    String parent = "parent-995424086";
    DataAsset dataAsset = DataAsset.newBuilder().build();
    String dataAssetId = "dataAssetId2108984609";

    DataAsset actualResponse = client.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataAssetRequest actualRequest = ((CreateDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataAsset, actualRequest.getDataAsset());
    Assert.assertEquals(dataAssetId, actualRequest.getDataAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String parent = "parent-995424086";
      DataAsset dataAsset = DataAsset.newBuilder().build();
      String dataAssetId = "dataAssetId2108984609";
      client.createDataAssetAsync(parent, dataAsset, dataAssetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDataAssetTest() throws Exception {
    DataAsset expectedResponse =
        DataAsset.newBuilder()
            .setName(
                DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setResource("resource-341064690")
            .putAllAccessGroupConfigs(new HashMap<String, DataAsset.AccessGroupConfig>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDataAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    DataAsset dataAsset = DataAsset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataAsset actualResponse = client.updateDataAssetAsync(dataAsset, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataAssetRequest actualRequest = ((UpdateDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(dataAsset, actualRequest.getDataAsset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataAsset dataAsset = DataAsset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataAssetAsync(dataAsset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAssetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    DataAssetName name =
        DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");

    client.deleteDataAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAssetRequest actualRequest = ((DeleteDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataAssetName name =
          DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");
      client.deleteDataAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDataAssetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDataAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataProductService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDataAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataAssetRequest actualRequest = ((DeleteDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDataAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDataAssetTest() throws Exception {
    DataAsset expectedResponse =
        DataAsset.newBuilder()
            .setName(
                DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setResource("resource-341064690")
            .putAllAccessGroupConfigs(new HashMap<String, DataAsset.AccessGroupConfig>())
            .build();
    mockDataProductService.addResponse(expectedResponse);

    DataAssetName name =
        DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");

    DataAsset actualResponse = client.getDataAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAssetRequest actualRequest = ((GetDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataAssetName name =
          DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]");
      client.getDataAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataAssetTest2() throws Exception {
    DataAsset expectedResponse =
        DataAsset.newBuilder()
            .setName(
                DataAssetName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]", "[DATA_ASSET]")
                    .toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .putAllLabels(new HashMap<String, String>())
            .setResource("resource-341064690")
            .putAllAccessGroupConfigs(new HashMap<String, DataAsset.AccessGroupConfig>())
            .build();
    mockDataProductService.addResponse(expectedResponse);

    String name = "name3373707";

    DataAsset actualResponse = client.getDataAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataAssetRequest actualRequest = ((GetDataAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String name = "name3373707";
      client.getDataAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAssetsTest() throws Exception {
    DataAsset responsesElement = DataAsset.newBuilder().build();
    ListDataAssetsResponse expectedResponse =
        ListDataAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAssets(Arrays.asList(responsesElement))
            .build();
    mockDataProductService.addResponse(expectedResponse);

    DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");

    ListDataAssetsPagedResponse pagedListResponse = client.listDataAssets(parent);

    List<DataAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAssetsRequest actualRequest = ((ListDataAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
      client.listDataAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataAssetsTest2() throws Exception {
    DataAsset responsesElement = DataAsset.newBuilder().build();
    ListDataAssetsResponse expectedResponse =
        ListDataAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataAssets(Arrays.asList(responsesElement))
            .build();
    mockDataProductService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataAssetsPagedResponse pagedListResponse = client.listDataAssets(parent);

    List<DataAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataProductService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataAssetsRequest actualRequest = ((ListDataAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataAssetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataProductService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDataAssets(parent);
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

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(AspectTypeName.of("[PROJECT]", "[LOCATION]", "[ASPECT_TYPE]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
