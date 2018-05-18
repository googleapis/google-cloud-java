/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.VpnTunnelClient.AggregatedListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelClient.ListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonVpnTunnelStub.aggregatedListVpnTunnelsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonVpnTunnelStub.deleteVpnTunnelMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonVpnTunnelStub.getVpnTunnelMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonVpnTunnelStub.insertVpnTunnelMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonVpnTunnelStub.listVpnTunnelsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.VpnTunnelStubSettings;
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
public class VpnTunnelClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListVpnTunnelsMethodDescriptor,
              deleteVpnTunnelMethodDescriptor,
              getVpnTunnelMethodDescriptor,
              insertVpnTunnelMethodDescriptor,
              listVpnTunnelsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, VpnTunnelStubSettings.getDefaultEndpoint());

  private static VpnTunnelClient client;
  private static VpnTunnelSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        VpnTunnelSettings.newBuilder()
            .setTransportChannelProvider(
                VpnTunnelSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VpnTunnelClient.create(clientSettings);
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
  public void aggregatedListVpnTunnelsTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    VpnTunnelsScopedList itemsItem = VpnTunnelsScopedList.newBuilder().build();
    Map<String, VpnTunnelsScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    VpnTunnelAggregatedList expectedResponse =
        VpnTunnelAggregatedList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListVpnTunnelsPagedResponse pagedListResponse =
        client.aggregatedListVpnTunnels(project);

    List<VpnTunnelsScopedList> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void aggregatedListVpnTunnelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListVpnTunnels(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteVpnTunnelTest() {
    String httpErrorMessage = "httpErrorMessage1276263769";
    String targetId = "targetId-815576439";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String insertTime = "insertTime-103148397";
    Integer httpErrorStatusCode = 1386087020;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String targetLink = "targetLink-2084812312";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    Integer progress = 1001078227;
    String operationType = "operationType-1432962286";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    String id = "id3355";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String clientOperationId = "clientOperationId-239630617";
    String user = "user3599307";
    String status = "status-892481550";
    Operation expectedResponse =
        Operation.newBuilder()
            .setHttpErrorMessage(httpErrorMessage)
            .setTargetId(targetId)
            .setKind(kind)
            .setDescription(description)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setInsertTime(insertTime)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setZone(zone.toString())
            .setTargetLink(targetLink)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setProgress(progress)
            .setOperationType(operationType)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setId(id)
            .setRegion(region.toString())
            .setClientOperationId(clientOperationId)
            .setUser(user)
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionVpnTunnelName vpnTunnel =
        ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");

    Operation actualResponse = client.deleteVpnTunnel(vpnTunnel);
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
  public void deleteVpnTunnelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionVpnTunnelName vpnTunnel =
          ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");

      client.deleteVpnTunnel(vpnTunnel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getVpnTunnelTest() {
    String sharedSecretHash = "sharedSecretHash935752803";
    String kind = "kind3292052";
    String description = "description-1724546052";
    Integer ikeVersion = 1292118044;
    String selfLink = "selfLink-1691268851";
    ProjectRegionRouterName router =
        ProjectRegionRouterName.of("[PROJECT]", "[REGION]", "[ROUTER]");
    String detailedStatus = "detailedStatus-740240799";
    String peerIp = "peerIp-690492124";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    String id = "id3355";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String sharedSecret = "sharedSecret-154938422";
    ProjectRegionTargetVpnGatewayName targetVpnGateway =
        ProjectRegionTargetVpnGatewayName.of("[PROJECT]", "[REGION]", "[TARGET_VPN_GATEWAY]");
    String status = "status-892481550";
    VpnTunnel expectedResponse =
        VpnTunnel.newBuilder()
            .setSharedSecretHash(sharedSecretHash)
            .setKind(kind)
            .setDescription(description)
            .setIkeVersion(ikeVersion)
            .setSelfLink(selfLink)
            .setRouter(router.toString())
            .setDetailedStatus(detailedStatus)
            .setPeerIp(peerIp)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setId(id)
            .setRegion(region.toString())
            .setSharedSecret(sharedSecret)
            .setTargetVpnGateway(targetVpnGateway.toString())
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionVpnTunnelName vpnTunnel =
        ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");

    VpnTunnel actualResponse = client.getVpnTunnel(vpnTunnel);
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
  public void getVpnTunnelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionVpnTunnelName vpnTunnel =
          ProjectRegionVpnTunnelName.of("[PROJECT]", "[REGION]", "[VPN_TUNNEL]");

      client.getVpnTunnel(vpnTunnel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertVpnTunnelTest() {
    String httpErrorMessage = "httpErrorMessage1276263769";
    String targetId = "targetId-815576439";
    String kind = "kind3292052";
    String description = "description-1724546052";
    String statusMessage = "statusMessage-239442758";
    String selfLink = "selfLink-1691268851";
    String insertTime = "insertTime-103148397";
    Integer httpErrorStatusCode = 1386087020;
    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
    String targetLink = "targetLink-2084812312";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    Integer progress = 1001078227;
    String operationType = "operationType-1432962286";
    String startTime = "startTime-1573145462";
    String endTime = "endTime1725551537";
    String id = "id3355";
    ProjectRegionName region2 = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String clientOperationId = "clientOperationId-239630617";
    String user = "user3599307";
    String status = "status-892481550";
    Operation expectedResponse =
        Operation.newBuilder()
            .setHttpErrorMessage(httpErrorMessage)
            .setTargetId(targetId)
            .setKind(kind)
            .setDescription(description)
            .setStatusMessage(statusMessage)
            .setSelfLink(selfLink)
            .setInsertTime(insertTime)
            .setHttpErrorStatusCode(httpErrorStatusCode)
            .setZone(zone.toString())
            .setTargetLink(targetLink)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setProgress(progress)
            .setOperationType(operationType)
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setId(id)
            .setRegion(region2.toString())
            .setClientOperationId(clientOperationId)
            .setUser(user)
            .setStatus(status)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();

    Operation actualResponse = client.insertVpnTunnel(region, vpnTunnelResource);
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
  public void insertVpnTunnelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
      VpnTunnel vpnTunnelResource = VpnTunnel.newBuilder().build();

      client.insertVpnTunnel(region, vpnTunnelResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listVpnTunnelsTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    VpnTunnel itemsElement = VpnTunnel.newBuilder().build();
    List<VpnTunnel> items = Arrays.asList(itemsElement);
    VpnTunnelList expectedResponse =
        VpnTunnelList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

    ListVpnTunnelsPagedResponse pagedListResponse = client.listVpnTunnels(region);

    List<VpnTunnel> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listVpnTunnelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

      client.listVpnTunnels(region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
