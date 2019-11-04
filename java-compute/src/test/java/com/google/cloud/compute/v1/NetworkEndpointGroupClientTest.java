/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.AggregatedListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointsNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.aggregatedListNetworkEndpointGroupsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.attachNetworkEndpointsNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.deleteNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.detachNetworkEndpointsNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.getNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.insertNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.listNetworkEndpointGroupsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.listNetworkEndpointsNetworkEndpointGroupsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonNetworkEndpointGroupStub.testIamPermissionsNetworkEndpointGroupMethodDescriptor;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.stub.NetworkEndpointGroupStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class NetworkEndpointGroupClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListNetworkEndpointGroupsMethodDescriptor,
              attachNetworkEndpointsNetworkEndpointGroupMethodDescriptor,
              deleteNetworkEndpointGroupMethodDescriptor,
              detachNetworkEndpointsNetworkEndpointGroupMethodDescriptor,
              getNetworkEndpointGroupMethodDescriptor,
              insertNetworkEndpointGroupMethodDescriptor,
              listNetworkEndpointGroupsMethodDescriptor,
              listNetworkEndpointsNetworkEndpointGroupsMethodDescriptor,
              testIamPermissionsNetworkEndpointGroupMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, NetworkEndpointGroupStubSettings.getDefaultEndpoint());

  private static NetworkEndpointGroupClient client;
  private static NetworkEndpointGroupSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        NetworkEndpointGroupSettings.newBuilder()
            .setTransportChannelProvider(
                NetworkEndpointGroupSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = NetworkEndpointGroupClient.create(clientSettings);
  }

  @After
  public void cleanUp() {
    mockService.reset();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void aggregatedListNetworkEndpointGroupsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    NetworkEndpointGroupsScopedList itemsItem =
        NetworkEndpointGroupsScopedList.newBuilder().build();
    Map<String, NetworkEndpointGroupsScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    NetworkEndpointGroupAggregatedList expectedResponse =
        NetworkEndpointGroupAggregatedList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListNetworkEndpointGroupsPagedResponse pagedListResponse =
        client.aggregatedListNetworkEndpointGroups(project);

    List<NetworkEndpointGroupsScopedList> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getItemsMap().values().iterator().next(), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void aggregatedListNetworkEndpointGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListNetworkEndpointGroups(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void attachNetworkEndpointsNetworkEndpointGroupTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    Integer httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationType = "operationType-1432962286";
    Integer progress = 1001078227;
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String status = "status-892481550";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatus(status)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
        ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
    NetworkEndpointGroupsAttachEndpointsRequest
        networkEndpointGroupsAttachEndpointsRequestResource =
            NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();

    Operation actualResponse =
        client.attachNetworkEndpointsNetworkEndpointGroup(
            networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void attachNetworkEndpointsNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
          ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
      NetworkEndpointGroupsAttachEndpointsRequest
          networkEndpointGroupsAttachEndpointsRequestResource =
              NetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();

      client.attachNetworkEndpointsNetworkEndpointGroup(
          networkEndpointGroup, networkEndpointGroupsAttachEndpointsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNetworkEndpointGroupTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    Integer httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationType = "operationType-1432962286";
    Integer progress = 1001078227;
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String status = "status-892481550";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatus(status)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
        ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");

    Operation actualResponse = client.deleteNetworkEndpointGroup(networkEndpointGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void deleteNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
          ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");

      client.deleteNetworkEndpointGroup(networkEndpointGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void detachNetworkEndpointsNetworkEndpointGroupTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    Integer httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationType = "operationType-1432962286";
    Integer progress = 1001078227;
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String status = "status-892481550";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatus(status)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
        ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
    NetworkEndpointGroupsDetachEndpointsRequest
        networkEndpointGroupsDetachEndpointsRequestResource =
            NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();

    Operation actualResponse =
        client.detachNetworkEndpointsNetworkEndpointGroup(
            networkEndpointGroup, networkEndpointGroupsDetachEndpointsRequestResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void detachNetworkEndpointsNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
          ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
      NetworkEndpointGroupsDetachEndpointsRequest
          networkEndpointGroupsDetachEndpointsRequestResource =
              NetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();

      client.detachNetworkEndpointsNetworkEndpointGroup(
          networkEndpointGroup, networkEndpointGroupsDetachEndpointsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getNetworkEndpointGroupTest() {
    String creationTimestamp = "creationTimestamp567396278";
    Integer defaultPort = 650363969;
    String description = "description-1724546052";
    String id = "id3355";
    String kind = "kind3292052";
    String name = "name3373707";
    ProjectGlobalNetworkName network = ProjectGlobalNetworkName.of("[PROJECT]", "[NETWORK]");
    String networkEndpointType = "networkEndpointType118301523";
    String selfLink = "selfLink-1691268851";
    Integer size = 3530753;
    ProjectRegionSubnetworkName subnetwork =
        ProjectRegionSubnetworkName.of("[PROJECT]", "[REGION]", "[SUBNETWORK]");
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    NetworkEndpointGroup expectedResponse =
        NetworkEndpointGroup.newBuilder()
            .setCreationTimestamp(creationTimestamp)
            .setDefaultPort(defaultPort)
            .setDescription(description)
            .setId(id)
            .setKind(kind)
            .setName(name)
            .setNetwork(network.toString())
            .setNetworkEndpointType(networkEndpointType)
            .setSelfLink(selfLink)
            .setSize(size)
            .setSubnetwork(subnetwork.toString())
            .setZone(zone.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
        ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");

    NetworkEndpointGroup actualResponse = client.getNetworkEndpointGroup(networkEndpointGroup);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void getNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
          ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");

      client.getNetworkEndpointGroup(networkEndpointGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertNetworkEndpointGroupTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    Integer httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationType = "operationType-1432962286";
    Integer progress = 1001078227;
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String status = "status-892481550";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    ProjectZoneName zone2 = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId(clientOperationId)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEndTime(endTime)
            .setHttpErrorMessage(httpErrorMessage)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setId(id)
            .setInsertTime(insertTime)
            .setKind(kind)
            .setName(name)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatus(status)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone2.toString())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();

    Operation actualResponse =
        client.insertNetworkEndpointGroup(zone, networkEndpointGroupResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void insertNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
      NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();

      client.insertNetworkEndpointGroup(zone, networkEndpointGroupResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNetworkEndpointGroupsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    NetworkEndpointGroup itemsElement = NetworkEndpointGroup.newBuilder().build();
    List<NetworkEndpointGroup> items = Arrays.asList(itemsElement);
    NetworkEndpointGroupList expectedResponse =
        NetworkEndpointGroupList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

    ListNetworkEndpointGroupsPagedResponse pagedListResponse =
        client.listNetworkEndpointGroups(zone);

    List<NetworkEndpointGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void listNetworkEndpointGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

      client.listNetworkEndpointGroups(zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNetworkEndpointsNetworkEndpointGroupsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    NetworkEndpointWithHealthStatus itemsElement =
        NetworkEndpointWithHealthStatus.newBuilder().build();
    List<NetworkEndpointWithHealthStatus> items = Arrays.asList(itemsElement);
    NetworkEndpointGroupsListNetworkEndpoints expectedResponse =
        NetworkEndpointGroupsListNetworkEndpoints.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
        ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
    NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource =
        NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();

    ListNetworkEndpointsNetworkEndpointGroupsPagedResponse pagedListResponse =
        client.listNetworkEndpointsNetworkEndpointGroups(
            networkEndpointGroup, networkEndpointGroupsListEndpointsRequestResource);

    List<NetworkEndpointWithHealthStatus> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void listNetworkEndpointsNetworkEndpointGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupName networkEndpointGroup =
          ProjectZoneNetworkEndpointGroupName.of("[PROJECT]", "[ZONE]", "[NETWORK_ENDPOINT_GROUP]");
      NetworkEndpointGroupsListEndpointsRequest networkEndpointGroupsListEndpointsRequestResource =
          NetworkEndpointGroupsListEndpointsRequest.newBuilder().build();

      client.listNetworkEndpointsNetworkEndpointGroups(
          networkEndpointGroup, networkEndpointGroupsListEndpointsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsNetworkEndpointGroupTest() {
    TestPermissionsResponse expectedResponse = TestPermissionsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ProjectZoneNetworkEndpointGroupResourceName resource =
        ProjectZoneNetworkEndpointGroupResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
    TestPermissionsRequest testPermissionsRequestResource =
        TestPermissionsRequest.newBuilder().build();

    TestPermissionsResponse actualResponse =
        client.testIamPermissionsNetworkEndpointGroup(resource, testPermissionsRequestResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneNetworkEndpointGroupResourceName resource =
          ProjectZoneNetworkEndpointGroupResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
      TestPermissionsRequest testPermissionsRequestResource =
          TestPermissionsRequest.newBuilder().build();

      client.testIamPermissionsNetworkEndpointGroup(resource, testPermissionsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
