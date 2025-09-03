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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListAddressGroupReferencesPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListAddressGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationAddressGroupServiceClient.ListLocationsPagedResponse;

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
public class OrganizationAddressGroupServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockOrganizationAddressGroupService mockOrganizationAddressGroupService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OrganizationAddressGroupServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOrganizationAddressGroupService = new MockOrganizationAddressGroupService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockOrganizationAddressGroupService, mockLocations, mockIAMPolicy));
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
    OrganizationAddressGroupServiceSettings settings =
        OrganizationAddressGroupServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OrganizationAddressGroupServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAddressGroupsTest() throws Exception {
    AddressGroup responsesElement = AddressGroup.newBuilder().build();
    ListAddressGroupsResponse expectedResponse =
        ListAddressGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAddressGroups(Arrays.asList(responsesElement))
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAddressGroupsPagedResponse pagedListResponse = client.listAddressGroups(parent);

    List<AddressGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAddressGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAddressGroupsRequest actualRequest = ((ListAddressGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAddressGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAddressGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAddressGroupsTest2() throws Exception {
    AddressGroup responsesElement = AddressGroup.newBuilder().build();
    ListAddressGroupsResponse expectedResponse =
        ListAddressGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAddressGroups(Arrays.asList(responsesElement))
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAddressGroupsPagedResponse pagedListResponse = client.listAddressGroups(parent);

    List<AddressGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAddressGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAddressGroupsRequest actualRequest = ((ListAddressGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAddressGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAddressGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAddressGroupTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    AddressGroupName name =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");

    AddressGroup actualResponse = client.getAddressGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAddressGroupRequest actualRequest = ((GetAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAddressGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName name =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      client.getAddressGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAddressGroupTest2() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    String name = "name3373707";

    AddressGroup actualResponse = client.getAddressGroup(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAddressGroupRequest actualRequest = ((GetAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAddressGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.getAddressGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAddressGroupTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AddressGroup addressGroup = AddressGroup.newBuilder().build();
    String addressGroupId = "addressGroupId705215846";

    AddressGroup actualResponse =
        client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAddressGroupRequest actualRequest = ((CreateAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(addressGroupId, actualRequest.getAddressGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAddressGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AddressGroup addressGroup = AddressGroup.newBuilder().build();
      String addressGroupId = "addressGroupId705215846";
      client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAddressGroupTest2() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    AddressGroup addressGroup = AddressGroup.newBuilder().build();
    String addressGroupId = "addressGroupId705215846";

    AddressGroup actualResponse =
        client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAddressGroupRequest actualRequest = ((CreateAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(addressGroupId, actualRequest.getAddressGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAddressGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      AddressGroup addressGroup = AddressGroup.newBuilder().build();
      String addressGroupId = "addressGroupId705215846";
      client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAddressGroupTest3() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String parent = "parent-995424086";
    AddressGroup addressGroup = AddressGroup.newBuilder().build();
    String addressGroupId = "addressGroupId705215846";

    AddressGroup actualResponse =
        client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAddressGroupRequest actualRequest = ((CreateAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(addressGroupId, actualRequest.getAddressGroupId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAddressGroupExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String parent = "parent-995424086";
      AddressGroup addressGroup = AddressGroup.newBuilder().build();
      String addressGroupId = "addressGroupId705215846";
      client.createAddressGroupAsync(parent, addressGroup, addressGroupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAddressGroupTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroup addressGroup = AddressGroup.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AddressGroup actualResponse = client.updateAddressGroupAsync(addressGroup, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAddressGroupRequest actualRequest = ((UpdateAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAddressGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroup addressGroup = AddressGroup.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAddressGroupAsync(addressGroup, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addAddressGroupItemsTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroupName addressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
    List<String> items = new ArrayList<>();

    AddressGroup actualResponse = client.addAddressGroupItemsAsync(addressGroup, items).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddAddressGroupItemsRequest actualRequest =
        ((AddAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup.toString(), actualRequest.getAddressGroup());
    Assert.assertEquals(items, actualRequest.getItemsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addAddressGroupItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName addressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      List<String> items = new ArrayList<>();
      client.addAddressGroupItemsAsync(addressGroup, items).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void addAddressGroupItemsTest2() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String addressGroup = "addressGroup242074347";
    List<String> items = new ArrayList<>();

    AddressGroup actualResponse = client.addAddressGroupItemsAsync(addressGroup, items).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddAddressGroupItemsRequest actualRequest =
        ((AddAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(items, actualRequest.getItemsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addAddressGroupItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String addressGroup = "addressGroup242074347";
      List<String> items = new ArrayList<>();
      client.addAddressGroupItemsAsync(addressGroup, items).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeAddressGroupItemsTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroupName addressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
    List<String> items = new ArrayList<>();

    AddressGroup actualResponse = client.removeAddressGroupItemsAsync(addressGroup, items).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveAddressGroupItemsRequest actualRequest =
        ((RemoveAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup.toString(), actualRequest.getAddressGroup());
    Assert.assertEquals(items, actualRequest.getItemsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeAddressGroupItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName addressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      List<String> items = new ArrayList<>();
      client.removeAddressGroupItemsAsync(addressGroup, items).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void removeAddressGroupItemsTest2() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String addressGroup = "addressGroup242074347";
    List<String> items = new ArrayList<>();

    AddressGroup actualResponse = client.removeAddressGroupItemsAsync(addressGroup, items).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveAddressGroupItemsRequest actualRequest =
        ((RemoveAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(items, actualRequest.getItemsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeAddressGroupItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String addressGroup = "addressGroup242074347";
      List<String> items = new ArrayList<>();
      client.removeAddressGroupItemsAsync(addressGroup, items).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cloneAddressGroupItemsTest() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cloneAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroupName addressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
    AddressGroupName sourceAddressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");

    AddressGroup actualResponse =
        client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloneAddressGroupItemsRequest actualRequest =
        ((CloneAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup.toString(), actualRequest.getAddressGroup());
    Assert.assertEquals(sourceAddressGroup.toString(), actualRequest.getSourceAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cloneAddressGroupItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName addressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      AddressGroupName sourceAddressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cloneAddressGroupItemsTest2() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cloneAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroupName addressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
    String sourceAddressGroup = "sourceAddressGroup-314626394";

    AddressGroup actualResponse =
        client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloneAddressGroupItemsRequest actualRequest =
        ((CloneAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup.toString(), actualRequest.getAddressGroup());
    Assert.assertEquals(sourceAddressGroup, actualRequest.getSourceAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cloneAddressGroupItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName addressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      String sourceAddressGroup = "sourceAddressGroup-314626394";
      client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cloneAddressGroupItemsTest3() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cloneAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String addressGroup = "addressGroup242074347";
    AddressGroupName sourceAddressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");

    AddressGroup actualResponse =
        client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloneAddressGroupItemsRequest actualRequest =
        ((CloneAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(sourceAddressGroup.toString(), actualRequest.getSourceAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cloneAddressGroupItemsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String addressGroup = "addressGroup242074347";
      AddressGroupName sourceAddressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void cloneAddressGroupItemsTest4() throws Exception {
    AddressGroup expectedResponse =
        AddressGroup.newBuilder()
            .setName(
                AddressGroupName.ofOrganizationLocationAddressGroupName(
                        "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllItems(new ArrayList<String>())
            .setCapacity(-67824454)
            .setSelfLink("selfLink1191800166")
            .addAllPurpose(new ArrayList<AddressGroup.Purpose>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("cloneAddressGroupItemsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String addressGroup = "addressGroup242074347";
    String sourceAddressGroup = "sourceAddressGroup-314626394";

    AddressGroup actualResponse =
        client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CloneAddressGroupItemsRequest actualRequest =
        ((CloneAddressGroupItemsRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertEquals(sourceAddressGroup, actualRequest.getSourceAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cloneAddressGroupItemsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String addressGroup = "addressGroup242074347";
      String sourceAddressGroup = "sourceAddressGroup-314626394";
      client.cloneAddressGroupItemsAsync(addressGroup, sourceAddressGroup).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAddressGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    AddressGroupName name =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");

    client.deleteAddressGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAddressGroupRequest actualRequest = ((DeleteAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAddressGroupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName name =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      client.deleteAddressGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAddressGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAddressGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockOrganizationAddressGroupService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAddressGroupAsync(name).get();

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAddressGroupRequest actualRequest = ((DeleteAddressGroupRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAddressGroupExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAddressGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAddressGroupReferencesTest() throws Exception {
    ListAddressGroupReferencesResponse.AddressGroupReference responsesElement =
        ListAddressGroupReferencesResponse.AddressGroupReference.newBuilder().build();
    ListAddressGroupReferencesResponse expectedResponse =
        ListAddressGroupReferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAddressGroupReferences(Arrays.asList(responsesElement))
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    AddressGroupName addressGroup =
        AddressGroupName.ofOrganizationLocationAddressGroupName(
            "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");

    ListAddressGroupReferencesPagedResponse pagedListResponse =
        client.listAddressGroupReferences(addressGroup);

    List<ListAddressGroupReferencesResponse.AddressGroupReference> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAddressGroupReferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAddressGroupReferencesRequest actualRequest =
        ((ListAddressGroupReferencesRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup.toString(), actualRequest.getAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAddressGroupReferencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      AddressGroupName addressGroup =
          AddressGroupName.ofOrganizationLocationAddressGroupName(
              "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
      client.listAddressGroupReferences(addressGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAddressGroupReferencesTest2() throws Exception {
    ListAddressGroupReferencesResponse.AddressGroupReference responsesElement =
        ListAddressGroupReferencesResponse.AddressGroupReference.newBuilder().build();
    ListAddressGroupReferencesResponse expectedResponse =
        ListAddressGroupReferencesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAddressGroupReferences(Arrays.asList(responsesElement))
            .build();
    mockOrganizationAddressGroupService.addResponse(expectedResponse);

    String addressGroup = "addressGroup242074347";

    ListAddressGroupReferencesPagedResponse pagedListResponse =
        client.listAddressGroupReferences(addressGroup);

    List<ListAddressGroupReferencesResponse.AddressGroupReference> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAddressGroupReferencesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockOrganizationAddressGroupService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAddressGroupReferencesRequest actualRequest =
        ((ListAddressGroupReferencesRequest) actualRequests.get(0));

    Assert.assertEquals(addressGroup, actualRequest.getAddressGroup());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAddressGroupReferencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOrganizationAddressGroupService.addException(exception);

    try {
      String addressGroup = "addressGroup242074347";
      client.listAddressGroupReferences(addressGroup);
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
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
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
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
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
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
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
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
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
            .setResource(
                AddressGroupName.ofProjectLocationAddressGroupName(
                        "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                    .toString())
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
              .setResource(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
