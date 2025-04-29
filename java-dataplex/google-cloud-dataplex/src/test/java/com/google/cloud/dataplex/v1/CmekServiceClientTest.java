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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

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
public class CmekServiceClientTest {
  private static MockCmekService mockCmekService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CmekServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCmekService = new MockCmekService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCmekService, mockLocations, mockIAMPolicy));
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
    CmekServiceSettings settings =
        CmekServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CmekServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createEncryptionConfigTest() throws Exception {
    EncryptionConfig expectedResponse =
        EncryptionConfig.newBuilder()
            .setName(
                EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
                    .toString())
            .setKey("key106079")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setFailureDetails(EncryptionConfig.FailureDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEncryptionConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
    String encryptionConfigId = "encryptionConfigId-1583151968";

    EncryptionConfig actualResponse =
        client.createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEncryptionConfigRequest actualRequest =
        ((CreateEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(encryptionConfig, actualRequest.getEncryptionConfig());
    Assert.assertEquals(encryptionConfigId, actualRequest.getEncryptionConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEncryptionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
      String encryptionConfigId = "encryptionConfigId-1583151968";
      client.createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEncryptionConfigTest2() throws Exception {
    EncryptionConfig expectedResponse =
        EncryptionConfig.newBuilder()
            .setName(
                EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
                    .toString())
            .setKey("key106079")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setFailureDetails(EncryptionConfig.FailureDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEncryptionConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekService.addResponse(resultOperation);

    String parent = "parent-995424086";
    EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
    String encryptionConfigId = "encryptionConfigId-1583151968";

    EncryptionConfig actualResponse =
        client.createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEncryptionConfigRequest actualRequest =
        ((CreateEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(encryptionConfig, actualRequest.getEncryptionConfig());
    Assert.assertEquals(encryptionConfigId, actualRequest.getEncryptionConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEncryptionConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      String parent = "parent-995424086";
      EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
      String encryptionConfigId = "encryptionConfigId-1583151968";
      client.createEncryptionConfigAsync(parent, encryptionConfig, encryptionConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEncryptionConfigTest() throws Exception {
    EncryptionConfig expectedResponse =
        EncryptionConfig.newBuilder()
            .setName(
                EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
                    .toString())
            .setKey("key106079")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setFailureDetails(EncryptionConfig.FailureDetails.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEncryptionConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekService.addResponse(resultOperation);

    EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EncryptionConfig actualResponse =
        client.updateEncryptionConfigAsync(encryptionConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEncryptionConfigRequest actualRequest =
        ((UpdateEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(encryptionConfig, actualRequest.getEncryptionConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEncryptionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      EncryptionConfig encryptionConfig = EncryptionConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEncryptionConfigAsync(encryptionConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEncryptionConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEncryptionConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekService.addResponse(resultOperation);

    EncryptionConfigName name =
        EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");

    client.deleteEncryptionConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEncryptionConfigRequest actualRequest =
        ((DeleteEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEncryptionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      EncryptionConfigName name =
          EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");
      client.deleteEncryptionConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEncryptionConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEncryptionConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCmekService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEncryptionConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEncryptionConfigRequest actualRequest =
        ((DeleteEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEncryptionConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEncryptionConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEncryptionConfigsTest() throws Exception {
    EncryptionConfig responsesElement = EncryptionConfig.newBuilder().build();
    ListEncryptionConfigsResponse expectedResponse =
        ListEncryptionConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEncryptionConfigs(Arrays.asList(responsesElement))
            .build();
    mockCmekService.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListEncryptionConfigsPagedResponse pagedListResponse = client.listEncryptionConfigs(parent);

    List<EncryptionConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEncryptionConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEncryptionConfigsRequest actualRequest =
        ((ListEncryptionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEncryptionConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listEncryptionConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEncryptionConfigsTest2() throws Exception {
    EncryptionConfig responsesElement = EncryptionConfig.newBuilder().build();
    ListEncryptionConfigsResponse expectedResponse =
        ListEncryptionConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEncryptionConfigs(Arrays.asList(responsesElement))
            .build();
    mockCmekService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEncryptionConfigsPagedResponse pagedListResponse = client.listEncryptionConfigs(parent);

    List<EncryptionConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEncryptionConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEncryptionConfigsRequest actualRequest =
        ((ListEncryptionConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEncryptionConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEncryptionConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEncryptionConfigTest() throws Exception {
    EncryptionConfig expectedResponse =
        EncryptionConfig.newBuilder()
            .setName(
                EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
                    .toString())
            .setKey("key106079")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setFailureDetails(EncryptionConfig.FailureDetails.newBuilder().build())
            .build();
    mockCmekService.addResponse(expectedResponse);

    EncryptionConfigName name =
        EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");

    EncryptionConfig actualResponse = client.getEncryptionConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEncryptionConfigRequest actualRequest = ((GetEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEncryptionConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      EncryptionConfigName name =
          EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]");
      client.getEncryptionConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEncryptionConfigTest2() throws Exception {
    EncryptionConfig expectedResponse =
        EncryptionConfig.newBuilder()
            .setName(
                EncryptionConfigName.of("[ORGANIZATION]", "[LOCATION]", "[ENCRYPTION_CONFIG]")
                    .toString())
            .setKey("key106079")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .setFailureDetails(EncryptionConfig.FailureDetails.newBuilder().build())
            .build();
    mockCmekService.addResponse(expectedResponse);

    String name = "name3373707";

    EncryptionConfig actualResponse = client.getEncryptionConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCmekService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEncryptionConfigRequest actualRequest = ((GetEncryptionConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEncryptionConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCmekService.addException(exception);

    try {
      String name = "name3373707";
      client.getEncryptionConfig(name);
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
