/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.attachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.deleteGlobalNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.detachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.getGlobalNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.insertGlobalNetworkEndpointGroupMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.listGlobalNetworkEndpointGroupsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonGlobalNetworkEndpointGroupStub.listNetworkEndpointsGlobalNetworkEndpointGroupsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.GlobalNetworkEndpointGroupStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class GlobalNetworkEndpointGroupClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              attachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor,
              deleteGlobalNetworkEndpointGroupMethodDescriptor,
              detachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor,
              getGlobalNetworkEndpointGroupMethodDescriptor,
              insertGlobalNetworkEndpointGroupMethodDescriptor,
              listGlobalNetworkEndpointGroupsMethodDescriptor,
              listNetworkEndpointsGlobalNetworkEndpointGroupsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, GlobalNetworkEndpointGroupStubSettings.getDefaultEndpoint());

  private static GlobalNetworkEndpointGroupClient client;
  private static GlobalNetworkEndpointGroupSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        GlobalNetworkEndpointGroupSettings.newBuilder()
            .setTransportChannelProvider(
                GlobalNetworkEndpointGroupSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GlobalNetworkEndpointGroupClient.create(clientSettings);
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
  public void attachNetworkEndpointsGlobalNetworkEndpointGroupTest() {
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

    ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
        ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
    GlobalNetworkEndpointGroupsAttachEndpointsRequest
        globalNetworkEndpointGroupsAttachEndpointsRequestResource =
            GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();

    Operation actualResponse =
        client.attachNetworkEndpointsGlobalNetworkEndpointGroup(
            networkEndpointGroup, globalNetworkEndpointGroupsAttachEndpointsRequestResource);
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
  public void attachNetworkEndpointsGlobalNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
          ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
      GlobalNetworkEndpointGroupsAttachEndpointsRequest
          globalNetworkEndpointGroupsAttachEndpointsRequestResource =
              GlobalNetworkEndpointGroupsAttachEndpointsRequest.newBuilder().build();

      client.attachNetworkEndpointsGlobalNetworkEndpointGroup(
          networkEndpointGroup, globalNetworkEndpointGroupsAttachEndpointsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGlobalNetworkEndpointGroupTest() {
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

    ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
        ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

    Operation actualResponse = client.deleteGlobalNetworkEndpointGroup(networkEndpointGroup);
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
  public void deleteGlobalNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
          ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

      client.deleteGlobalNetworkEndpointGroup(networkEndpointGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void detachNetworkEndpointsGlobalNetworkEndpointGroupTest() {
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

    ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
        ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
    GlobalNetworkEndpointGroupsDetachEndpointsRequest
        globalNetworkEndpointGroupsDetachEndpointsRequestResource =
            GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();

    Operation actualResponse =
        client.detachNetworkEndpointsGlobalNetworkEndpointGroup(
            networkEndpointGroup, globalNetworkEndpointGroupsDetachEndpointsRequestResource);
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
  public void detachNetworkEndpointsGlobalNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
          ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");
      GlobalNetworkEndpointGroupsDetachEndpointsRequest
          globalNetworkEndpointGroupsDetachEndpointsRequestResource =
              GlobalNetworkEndpointGroupsDetachEndpointsRequest.newBuilder().build();

      client.detachNetworkEndpointsGlobalNetworkEndpointGroup(
          networkEndpointGroup, globalNetworkEndpointGroupsDetachEndpointsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGlobalNetworkEndpointGroupTest() {
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

    ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
        ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

    NetworkEndpointGroup actualResponse =
        client.getGlobalNetworkEndpointGroup(networkEndpointGroup);
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
  public void getGlobalNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
          ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

      client.getGlobalNetworkEndpointGroup(networkEndpointGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertGlobalNetworkEndpointGroupTest() {
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

    ProjectName project = ProjectName.of("[PROJECT]");
    NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();

    Operation actualResponse =
        client.insertGlobalNetworkEndpointGroup(project, networkEndpointGroupResource);
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
  public void insertGlobalNetworkEndpointGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      NetworkEndpointGroup networkEndpointGroupResource = NetworkEndpointGroup.newBuilder().build();

      client.insertGlobalNetworkEndpointGroup(project, networkEndpointGroupResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listGlobalNetworkEndpointGroupsTest() {
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

    ProjectName project = ProjectName.of("[PROJECT]");

    ListGlobalNetworkEndpointGroupsPagedResponse pagedListResponse =
        client.listGlobalNetworkEndpointGroups(project);

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
  public void listGlobalNetworkEndpointGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listGlobalNetworkEndpointGroups(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listNetworkEndpointsGlobalNetworkEndpointGroupsTest() {
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

    ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
        ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

    ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse pagedListResponse =
        client.listNetworkEndpointsGlobalNetworkEndpointGroups(networkEndpointGroup);

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
  public void listNetworkEndpointsGlobalNetworkEndpointGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalNetworkEndpointGroupName networkEndpointGroup =
          ProjectGlobalNetworkEndpointGroupName.of("[PROJECT]", "[NETWORK_ENDPOINT_GROUP]");

      client.listNetworkEndpointsGlobalNetworkEndpointGroups(networkEndpointGroup);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
