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

package com.google.cloud.numberregistry.v1alpha;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

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
public class CloudNumberRegistryClientTest {
  private static MockCloudNumberRegistry mockCloudNumberRegistry;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CloudNumberRegistryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCloudNumberRegistry = new MockCloudNumberRegistry();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCloudNumberRegistry));
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
    CloudNumberRegistrySettings settings =
        CloudNumberRegistrySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CloudNumberRegistryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listIpamAdminScopesTest() throws Exception {
    IpamAdminScope responsesElement = IpamAdminScope.newBuilder().build();
    ListIpamAdminScopesResponse expectedResponse =
        ListIpamAdminScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIpamAdminScopes(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIpamAdminScopesPagedResponse pagedListResponse = client.listIpamAdminScopes(parent);

    List<IpamAdminScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIpamAdminScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIpamAdminScopesRequest actualRequest = ((ListIpamAdminScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIpamAdminScopesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIpamAdminScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIpamAdminScopesTest2() throws Exception {
    IpamAdminScope responsesElement = IpamAdminScope.newBuilder().build();
    ListIpamAdminScopesResponse expectedResponse =
        ListIpamAdminScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIpamAdminScopes(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIpamAdminScopesPagedResponse pagedListResponse = client.listIpamAdminScopes(parent);

    List<IpamAdminScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIpamAdminScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIpamAdminScopesRequest actualRequest = ((ListIpamAdminScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIpamAdminScopesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIpamAdminScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.getIpamAdminScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIpamAdminScopeRequest actualRequest = ((GetIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.getIpamAdminScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    IpamAdminScope actualResponse = client.getIpamAdminScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIpamAdminScopeRequest actualRequest = ((GetIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIpamAdminScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getIpamAdminScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAvailabilityIpamAdminScopesTest() throws Exception {
    CheckAvailabilityIpamAdminScopesResponse expectedResponse =
        CheckAvailabilityIpamAdminScopesResponse.newBuilder()
            .addAllScopeAvailabilities(new ArrayList<IpamAdminScopeAvailability>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> scopes = new ArrayList<>();

    CheckAvailabilityIpamAdminScopesResponse actualResponse =
        client.checkAvailabilityIpamAdminScopes(parent, scopes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAvailabilityIpamAdminScopesRequest actualRequest =
        ((CheckAvailabilityIpamAdminScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(scopes, actualRequest.getScopesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkAvailabilityIpamAdminScopesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> scopes = new ArrayList<>();
      client.checkAvailabilityIpamAdminScopes(parent, scopes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAvailabilityIpamAdminScopesTest2() throws Exception {
    CheckAvailabilityIpamAdminScopesResponse expectedResponse =
        CheckAvailabilityIpamAdminScopesResponse.newBuilder()
            .addAllScopeAvailabilities(new ArrayList<IpamAdminScopeAvailability>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> scopes = new ArrayList<>();

    CheckAvailabilityIpamAdminScopesResponse actualResponse =
        client.checkAvailabilityIpamAdminScopes(parent, scopes);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAvailabilityIpamAdminScopesRequest actualRequest =
        ((CheckAvailabilityIpamAdminScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(scopes, actualRequest.getScopesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkAvailabilityIpamAdminScopesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> scopes = new ArrayList<>();
      client.checkAvailabilityIpamAdminScopes(parent, scopes);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
    String ipamAdminScopeId = "ipamAdminScopeId1628703603";

    IpamAdminScope actualResponse =
        client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIpamAdminScopeRequest actualRequest =
        ((CreateIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(ipamAdminScope, actualRequest.getIpamAdminScope());
    Assert.assertEquals(ipamAdminScopeId, actualRequest.getIpamAdminScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
      String ipamAdminScopeId = "ipamAdminScopeId1628703603";
      client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
    String ipamAdminScopeId = "ipamAdminScopeId1628703603";

    IpamAdminScope actualResponse =
        client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIpamAdminScopeRequest actualRequest =
        ((CreateIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(ipamAdminScope, actualRequest.getIpamAdminScope());
    Assert.assertEquals(ipamAdminScopeId, actualRequest.getIpamAdminScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIpamAdminScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
      String ipamAdminScopeId = "ipamAdminScopeId1628703603";
      client.createIpamAdminScopeAsync(parent, ipamAdminScope, ipamAdminScopeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IpamAdminScope actualResponse =
        client.updateIpamAdminScopeAsync(ipamAdminScope, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIpamAdminScopeRequest actualRequest =
        ((UpdateIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(ipamAdminScope, actualRequest.getIpamAdminScope());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      IpamAdminScope ipamAdminScope = IpamAdminScope.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIpamAdminScopeAsync(ipamAdminScope, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIpamAdminScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    client.deleteIpamAdminScopeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIpamAdminScopeRequest actualRequest =
        ((DeleteIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.deleteIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteIpamAdminScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIpamAdminScopeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIpamAdminScopeRequest actualRequest =
        ((DeleteIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIpamAdminScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.disableIpamAdminScopeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableIpamAdminScopeRequest actualRequest =
        ((DisableIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.disableIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    IpamAdminScope actualResponse = client.disableIpamAdminScopeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableIpamAdminScopeRequest actualRequest =
        ((DisableIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableIpamAdminScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.disableIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cleanupIpamAdminScopeTest() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cleanupIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    IpamAdminScopeName name =
        IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");

    IpamAdminScope actualResponse = client.cleanupIpamAdminScopeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CleanupIpamAdminScopeRequest actualRequest =
        ((CleanupIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cleanupIpamAdminScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      IpamAdminScopeName name =
          IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
      client.cleanupIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cleanupIpamAdminScopeTest2() throws Exception {
    IpamAdminScope expectedResponse =
        IpamAdminScope.newBuilder()
            .setName(
                IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]").toString())
            .addAllEnabledAddonPlatforms(new ArrayList<IpamAdminScope.AddOnPlatform>())
            .addAllScopes(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cleanupIpamAdminScopeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    IpamAdminScope actualResponse = client.cleanupIpamAdminScopeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CleanupIpamAdminScopeRequest actualRequest =
        ((CleanupIpamAdminScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cleanupIpamAdminScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.cleanupIpamAdminScopeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRegistryBooksTest() throws Exception {
    RegistryBook responsesElement = RegistryBook.newBuilder().build();
    ListRegistryBooksResponse expectedResponse =
        ListRegistryBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistryBooks(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRegistryBooksPagedResponse pagedListResponse = client.listRegistryBooks(parent);

    List<RegistryBook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistryBooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegistryBooksRequest actualRequest = ((ListRegistryBooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegistryBooksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRegistryBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegistryBooksTest2() throws Exception {
    RegistryBook responsesElement = RegistryBook.newBuilder().build();
    ListRegistryBooksResponse expectedResponse =
        ListRegistryBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistryBooks(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRegistryBooksPagedResponse pagedListResponse = client.listRegistryBooks(parent);

    List<RegistryBook> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistryBooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegistryBooksRequest actualRequest = ((ListRegistryBooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegistryBooksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRegistryBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    RegistryBook actualResponse = client.getRegistryBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegistryBookRequest actualRequest = ((GetRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegistryBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.getRegistryBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistryBookTest2() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    RegistryBook actualResponse = client.getRegistryBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegistryBookRequest actualRequest = ((GetRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegistryBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getRegistryBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchIpResourcesTest() throws Exception {
    Range responsesElement = Range.newBuilder().build();
    SearchIpResourcesResponse expectedResponse =
        SearchIpResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    SearchIpResourcesPagedResponse pagedListResponse = client.searchIpResources(name);

    List<Range> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchIpResourcesRequest actualRequest = ((SearchIpResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchIpResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.searchIpResources(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchIpResourcesTest2() throws Exception {
    Range responsesElement = Range.newBuilder().build();
    SearchIpResourcesResponse expectedResponse =
        SearchIpResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    SearchIpResourcesPagedResponse pagedListResponse = client.searchIpResources(name);

    List<Range> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchIpResourcesRequest actualRequest = ((SearchIpResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchIpResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.searchIpResources(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    RegistryBook registryBook = RegistryBook.newBuilder().build();
    String registryBookId = "registryBookId2126801025";

    RegistryBook actualResponse =
        client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRegistryBookRequest actualRequest = ((CreateRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(registryBook, actualRequest.getRegistryBook());
    Assert.assertEquals(registryBookId, actualRequest.getRegistryBookId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRegistryBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      RegistryBook registryBook = RegistryBook.newBuilder().build();
      String registryBookId = "registryBookId2126801025";
      client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRegistryBookTest2() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    RegistryBook registryBook = RegistryBook.newBuilder().build();
    String registryBookId = "registryBookId2126801025";

    RegistryBook actualResponse =
        client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRegistryBookRequest actualRequest = ((CreateRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(registryBook, actualRequest.getRegistryBook());
    Assert.assertEquals(registryBookId, actualRequest.getRegistryBookId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRegistryBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      RegistryBook registryBook = RegistryBook.newBuilder().build();
      String registryBookId = "registryBookId2126801025";
      client.createRegistryBookAsync(parent, registryBook, registryBookId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRegistryBookTest() throws Exception {
    RegistryBook expectedResponse =
        RegistryBook.newBuilder()
            .setName(RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllClaimedScopes(new ArrayList<String>())
            .setIsDefault(true)
            .setAggregatedData(RegistryBook.AggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    RegistryBook registryBook = RegistryBook.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RegistryBook actualResponse = client.updateRegistryBookAsync(registryBook, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRegistryBookRequest actualRequest = ((UpdateRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(registryBook, actualRequest.getRegistryBook());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRegistryBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RegistryBook registryBook = RegistryBook.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRegistryBookAsync(registryBook, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRegistryBookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");

    client.deleteRegistryBookAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegistryBookRequest actualRequest = ((DeleteRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegistryBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RegistryBookName name = RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]");
      client.deleteRegistryBookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRegistryBookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistryBookTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRegistryBookAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegistryBookRequest actualRequest = ((DeleteRegistryBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegistryBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRegistryBookAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRealmsTest() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = ((ListRealmsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRealmsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRealmsTest2() throws Exception {
    Realm responsesElement = Realm.newBuilder().build();
    ListRealmsResponse expectedResponse =
        ListRealmsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRealms(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRealmsPagedResponse pagedListResponse = client.listRealms(parent);

    List<Realm> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRealmsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRealmsRequest actualRequest = ((ListRealmsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRealmsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRealms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    Realm actualResponse = client.getRealm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = ((GetRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    Realm actualResponse = client.getRealm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRealmRequest actualRequest = ((GetRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getRealm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = ((CreateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRealmTest2() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    Realm realm = Realm.newBuilder().build();
    String realmId = "realmId1080654858";

    Realm actualResponse = client.createRealmAsync(parent, realm, realmId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRealmRequest actualRequest = ((CreateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(realmId, actualRequest.getRealmId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      Realm realm = Realm.newBuilder().build();
      String realmId = "realmId1080654858";
      client.createRealmAsync(parent, realm, realmId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateRealmTest() throws Exception {
    Realm expectedResponse =
        Realm.newBuilder()
            .setName(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setRegistryBook(
                RegistryBookName.of("[PROJECT]", "[LOCATION]", "[REGISTRY_BOOK]").toString())
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setIpVersion(IpVersion.forNumber(0))
            .setAggregatedData(Realm.RealmAggregatedData.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    Realm realm = Realm.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Realm actualResponse = client.updateRealmAsync(realm, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRealmRequest actualRequest = ((UpdateRealmRequest) actualRequests.get(0));

    Assert.assertEquals(realm, actualRequest.getRealm());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      Realm realm = Realm.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRealmAsync(realm, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRealmTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    client.deleteRealmAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = ((DeleteRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRealmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRealmTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRealmTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRealmAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRealmRequest actualRequest = ((DeleteRealmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRealmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRealmAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDiscoveredRangesTest() throws Exception {
    DiscoveredRange responsesElement = DiscoveredRange.newBuilder().build();
    ListDiscoveredRangesResponse expectedResponse =
        ListDiscoveredRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDiscoveredRangesPagedResponse pagedListResponse = client.listDiscoveredRanges(parent);

    List<DiscoveredRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredRangesRequest actualRequest =
        ((ListDiscoveredRangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredRangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDiscoveredRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDiscoveredRangesTest2() throws Exception {
    DiscoveredRange responsesElement = DiscoveredRange.newBuilder().build();
    ListDiscoveredRangesResponse expectedResponse =
        ListDiscoveredRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDiscoveredRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDiscoveredRangesPagedResponse pagedListResponse = client.listDiscoveredRanges(parent);

    List<DiscoveredRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDiscoveredRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDiscoveredRangesRequest actualRequest =
        ((ListDiscoveredRangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDiscoveredRangesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDiscoveredRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredRangeTest() throws Exception {
    DiscoveredRange expectedResponse =
        DiscoveredRange.newBuilder()
            .setName(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .setDescription("description-1724546052")
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .addAllAttributes(new ArrayList<Attribute>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setChildCidrOverlapAllowed(true)
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");

    DiscoveredRange actualResponse = client.getDiscoveredRange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredRangeRequest actualRequest = ((GetDiscoveredRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      client.getDiscoveredRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDiscoveredRangeTest2() throws Exception {
    DiscoveredRange expectedResponse =
        DiscoveredRange.newBuilder()
            .setName(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .setDescription("description-1724546052")
            .setDiscoveryMetadata(DiscoveryMetadata.newBuilder().build())
            .addAllAttributes(new ArrayList<Attribute>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setChildCidrOverlapAllowed(true)
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    DiscoveredRange actualResponse = client.getDiscoveredRange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDiscoveredRangeRequest actualRequest = ((GetDiscoveredRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDiscoveredRangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getDiscoveredRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesTest() throws Exception {
    FindDiscoveredRangeFreeIpRangesResponse expectedResponse =
        FindDiscoveredRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
    int cidrPrefixLength = -954389592;

    FindDiscoveredRangeFreeIpRangesResponse actualResponse =
        client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindDiscoveredRangeFreeIpRangesRequest actualRequest =
        ((FindDiscoveredRangeFreeIpRangesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(cidrPrefixLength, actualRequest.getCidrPrefixLength());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      int cidrPrefixLength = -954389592;
      client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesTest2() throws Exception {
    FindDiscoveredRangeFreeIpRangesResponse expectedResponse =
        FindDiscoveredRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";
    int cidrPrefixLength = -954389592;

    FindDiscoveredRangeFreeIpRangesResponse actualResponse =
        client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindDiscoveredRangeFreeIpRangesRequest actualRequest =
        ((FindDiscoveredRangeFreeIpRangesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(cidrPrefixLength, actualRequest.getCidrPrefixLength());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findDiscoveredRangeFreeIpRangesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      int cidrPrefixLength = -954389592;
      client.findDiscoveredRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomRangesTest() throws Exception {
    CustomRange responsesElement = CustomRange.newBuilder().build();
    ListCustomRangesResponse expectedResponse =
        ListCustomRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCustomRangesPagedResponse pagedListResponse = client.listCustomRanges(parent);

    List<CustomRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomRangesRequest actualRequest = ((ListCustomRangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomRangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCustomRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCustomRangesTest2() throws Exception {
    CustomRange responsesElement = CustomRange.newBuilder().build();
    ListCustomRangesResponse expectedResponse =
        ListCustomRangesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCustomRanges(Arrays.asList(responsesElement))
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCustomRangesPagedResponse pagedListResponse = client.listCustomRanges(parent);

    List<CustomRange> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCustomRangesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCustomRangesRequest actualRequest = ((ListCustomRangesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCustomRangesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCustomRanges(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    CustomRange actualResponse = client.getCustomRange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomRangeRequest actualRequest = ((GetCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.getCustomRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCustomRangeTest2() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    CustomRange actualResponse = client.getCustomRange(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCustomRangeRequest actualRequest = ((GetCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCustomRangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.getCustomRange(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showCustomRangeUtilizationTest() throws Exception {
    ShowCustomRangeUtilizationResponse expectedResponse =
        ShowCustomRangeUtilizationResponse.newBuilder()
            .setCustomRange(CustomRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    ShowCustomRangeUtilizationResponse actualResponse = client.showCustomRangeUtilization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowCustomRangeUtilizationRequest actualRequest =
        ((ShowCustomRangeUtilizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showCustomRangeUtilizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.showCustomRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showCustomRangeUtilizationTest2() throws Exception {
    ShowCustomRangeUtilizationResponse expectedResponse =
        ShowCustomRangeUtilizationResponse.newBuilder()
            .setCustomRange(CustomRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ShowCustomRangeUtilizationResponse actualResponse = client.showCustomRangeUtilization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowCustomRangeUtilizationRequest actualRequest =
        ((ShowCustomRangeUtilizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showCustomRangeUtilizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.showCustomRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showDiscoveredRangeUtilizationTest() throws Exception {
    ShowDiscoveredRangeUtilizationResponse expectedResponse =
        ShowDiscoveredRangeUtilizationResponse.newBuilder()
            .setDiscoveredRange(DiscoveredRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    DiscoveredRangeName name =
        DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");

    ShowDiscoveredRangeUtilizationResponse actualResponse =
        client.showDiscoveredRangeUtilization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowDiscoveredRangeUtilizationRequest actualRequest =
        ((ShowDiscoveredRangeUtilizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showDiscoveredRangeUtilizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      DiscoveredRangeName name =
          DiscoveredRangeName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_RANGE]");
      client.showDiscoveredRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void showDiscoveredRangeUtilizationTest2() throws Exception {
    ShowDiscoveredRangeUtilizationResponse expectedResponse =
        ShowDiscoveredRangeUtilizationResponse.newBuilder()
            .setDiscoveredRange(DiscoveredRange.newBuilder().build())
            .setRangeUtilization(RangeUtilization.newBuilder().build())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";

    ShowDiscoveredRangeUtilizationResponse actualResponse =
        client.showDiscoveredRangeUtilization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShowDiscoveredRangeUtilizationRequest actualRequest =
        ((ShowDiscoveredRangeUtilizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void showDiscoveredRangeUtilizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.showDiscoveredRangeUtilization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findCustomRangeFreeIpRangesTest() throws Exception {
    FindCustomRangeFreeIpRangesResponse expectedResponse =
        FindCustomRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
    int cidrPrefixLength = -954389592;

    FindCustomRangeFreeIpRangesResponse actualResponse =
        client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindCustomRangeFreeIpRangesRequest actualRequest =
        ((FindCustomRangeFreeIpRangesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(cidrPrefixLength, actualRequest.getCidrPrefixLength());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findCustomRangeFreeIpRangesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      int cidrPrefixLength = -954389592;
      client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findCustomRangeFreeIpRangesTest2() throws Exception {
    FindCustomRangeFreeIpRangesResponse expectedResponse =
        FindCustomRangeFreeIpRangesResponse.newBuilder()
            .addAllFreeIpCidrRanges(new ArrayList<String>())
            .build();
    mockCloudNumberRegistry.addResponse(expectedResponse);

    String name = "name3373707";
    int cidrPrefixLength = -954389592;

    FindCustomRangeFreeIpRangesResponse actualResponse =
        client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindCustomRangeFreeIpRangesRequest actualRequest =
        ((FindCustomRangeFreeIpRangesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(cidrPrefixLength, actualRequest.getCidrPrefixLength());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findCustomRangeFreeIpRangesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      int cidrPrefixLength = -954389592;
      client.findCustomRangeFreeIpRanges(name, cidrPrefixLength);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CustomRange customRange = CustomRange.newBuilder().build();
    String customRangeId = "customRangeId1995399815";

    CustomRange actualResponse =
        client.createCustomRangeAsync(parent, customRange, customRangeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomRangeRequest actualRequest = ((CreateCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(customRange, actualRequest.getCustomRange());
    Assert.assertEquals(customRangeId, actualRequest.getCustomRangeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CustomRange customRange = CustomRange.newBuilder().build();
      String customRangeId = "customRangeId1995399815";
      client.createCustomRangeAsync(parent, customRange, customRangeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCustomRangeTest2() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String parent = "parent-995424086";
    CustomRange customRange = CustomRange.newBuilder().build();
    String customRangeId = "customRangeId1995399815";

    CustomRange actualResponse =
        client.createCustomRangeAsync(parent, customRange, customRangeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCustomRangeRequest actualRequest = ((CreateCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(customRange, actualRequest.getCustomRange());
    Assert.assertEquals(customRangeId, actualRequest.getCustomRangeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCustomRangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String parent = "parent-995424086";
      CustomRange customRange = CustomRange.newBuilder().build();
      String customRangeId = "customRangeId1995399815";
      client.createCustomRangeAsync(parent, customRange, customRangeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateCustomRangeTest() throws Exception {
    CustomRange expectedResponse =
        CustomRange.newBuilder()
            .setName(CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRealm(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setParentRange(
                CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]").toString())
            .setRegistryBook("registryBook-1329628986")
            .addAllAttributes(new ArrayList<Attribute>())
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    CustomRange customRange = CustomRange.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CustomRange actualResponse = client.updateCustomRangeAsync(customRange, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCustomRangeRequest actualRequest = ((UpdateCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(customRange, actualRequest.getCustomRange());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCustomRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      CustomRange customRange = CustomRange.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCustomRangeAsync(customRange, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCustomRangeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");

    client.deleteCustomRangeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomRangeRequest actualRequest = ((DeleteCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomRangeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      CustomRangeName name = CustomRangeName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_RANGE]");
      client.deleteCustomRangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCustomRangeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCustomRangeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCloudNumberRegistry.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCustomRangeAsync(name).get();

    List<AbstractMessage> actualRequests = mockCloudNumberRegistry.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCustomRangeRequest actualRequest = ((DeleteCustomRangeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCustomRangeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCloudNumberRegistry.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCustomRangeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
