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

import static com.google.cloud.compute.v1.PacketMirroringClient.AggregatedListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.PacketMirroringClient.ListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.aggregatedListPacketMirroringsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.deletePacketMirroringMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.getPacketMirroringMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.insertPacketMirroringMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.listPacketMirroringsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.patchPacketMirroringMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonPacketMirroringStub.testIamPermissionsPacketMirroringMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.PacketMirroringStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
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
public class PacketMirroringClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListPacketMirroringsMethodDescriptor,
              deletePacketMirroringMethodDescriptor,
              getPacketMirroringMethodDescriptor,
              insertPacketMirroringMethodDescriptor,
              listPacketMirroringsMethodDescriptor,
              patchPacketMirroringMethodDescriptor,
              testIamPermissionsPacketMirroringMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, PacketMirroringStubSettings.getDefaultEndpoint());

  private static PacketMirroringClient client;
  private static PacketMirroringSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        PacketMirroringSettings.newBuilder()
            .setTransportChannelProvider(
                PacketMirroringSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PacketMirroringClient.create(clientSettings);
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
  public void aggregatedListPacketMirroringsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    PacketMirroringsScopedList itemsItem = PacketMirroringsScopedList.newBuilder().build();
    Map<String, PacketMirroringsScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    PacketMirroringAggregatedList expectedResponse =
        PacketMirroringAggregatedList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    Boolean includeAllScopes = true;
    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListPacketMirroringsPagedResponse pagedListResponse =
        client.aggregatedListPacketMirrorings(includeAllScopes, project);

    List<PacketMirroringsScopedList> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void aggregatedListPacketMirroringsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Boolean includeAllScopes = true;
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListPacketMirrorings(includeAllScopes, project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deletePacketMirroringTest() {
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

    ProjectRegionPacketMirroringName packetMirroring =
        ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");

    Operation actualResponse = client.deletePacketMirroring(packetMirroring);
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
  public void deletePacketMirroringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionPacketMirroringName packetMirroring =
          ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");

      client.deletePacketMirroring(packetMirroring);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getPacketMirroringTest() {
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String enable = "enable-1298848381";
    String id = "id3355";
    String kind = "kind3292052";
    String name = "name3373707";
    Integer priority = 1165461084;
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    PacketMirroring expectedResponse =
        PacketMirroring.newBuilder()
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEnable(enable)
            .setId(id)
            .setKind(kind)
            .setName(name)
            .setPriority(priority)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionPacketMirroringName packetMirroring =
        ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");

    PacketMirroring actualResponse = client.getPacketMirroring(packetMirroring);
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
  public void getPacketMirroringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionPacketMirroringName packetMirroring =
          ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");

      client.getPacketMirroring(packetMirroring);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertPacketMirroringTest() {
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
    ProjectRegionName region2 = ProjectRegionName.of("[PROJECT]", "[REGION]");
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
            .setRegion(region2.toString())
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

    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();

    Operation actualResponse = client.insertPacketMirroring(region, packetMirroringResource);
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
  public void insertPacketMirroringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
      PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();

      client.insertPacketMirroring(region, packetMirroringResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listPacketMirroringsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    PacketMirroring itemsElement = PacketMirroring.newBuilder().build();
    List<PacketMirroring> items = Arrays.asList(itemsElement);
    PacketMirroringList expectedResponse =
        PacketMirroringList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

    ListPacketMirroringsPagedResponse pagedListResponse = client.listPacketMirrorings(region);

    List<PacketMirroring> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listPacketMirroringsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

      client.listPacketMirrorings(region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void patchPacketMirroringTest() {
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

    ProjectRegionPacketMirroringName packetMirroring =
        ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
    PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
    List<String> fieldMask = new ArrayList<>();

    Operation actualResponse =
        client.patchPacketMirroring(packetMirroring, packetMirroringResource, fieldMask);
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
  public void patchPacketMirroringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionPacketMirroringName packetMirroring =
          ProjectRegionPacketMirroringName.of("[PROJECT]", "[REGION]", "[PACKET_MIRRORING]");
      PacketMirroring packetMirroringResource = PacketMirroring.newBuilder().build();
      List<String> fieldMask = new ArrayList<>();

      client.patchPacketMirroring(packetMirroring, packetMirroringResource, fieldMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsPacketMirroringTest() {
    TestPermissionsResponse expectedResponse = TestPermissionsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ProjectRegionPacketMirroringResourceName resource =
        ProjectRegionPacketMirroringResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
    TestPermissionsRequest testPermissionsRequestResource =
        TestPermissionsRequest.newBuilder().build();

    TestPermissionsResponse actualResponse =
        client.testIamPermissionsPacketMirroring(resource, testPermissionsRequestResource);
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
  public void testIamPermissionsPacketMirroringExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionPacketMirroringResourceName resource =
          ProjectRegionPacketMirroringResourceName.of("[PROJECT]", "[REGION]", "[RESOURCE]");
      TestPermissionsRequest testPermissionsRequestResource =
          TestPermissionsRequest.newBuilder().build();

      client.testIamPermissionsPacketMirroring(resource, testPermissionsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
