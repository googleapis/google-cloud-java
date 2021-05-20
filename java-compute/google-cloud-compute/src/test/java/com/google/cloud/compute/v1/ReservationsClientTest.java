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

import static com.google.cloud.compute.v1.ReservationsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ReservationsClient.ListPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.aggregatedListMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.deleteMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.getIamPolicyMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.getMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.insertMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.listMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.resizeMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.setIamPolicyMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonReservationsStub.testIamPermissionsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.ReservationsStubSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ReservationsClientTest {
  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListMethodDescriptor,
              deleteMethodDescriptor,
              getMethodDescriptor,
              getIamPolicyMethodDescriptor,
              insertMethodDescriptor,
              listMethodDescriptor,
              resizeMethodDescriptor,
              setIamPolicyMethodDescriptor,
              testIamPermissionsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, ReservationsStubSettings.getDefaultEndpoint());

  private static ReservationsClient client;
  private static ReservationsSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        ReservationsSettings.newBuilder()
            .setTransportChannelProvider(
                ReservationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReservationsClient.create(clientSettings);
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
  public void aggregatedListTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    ReservationsScopedList itemsItem = ReservationsScopedList.newBuilder().build();
    Map<String, ReservationsScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    ReservationAggregatedList expectedResponse =
        ReservationAggregatedList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";

    AggregatedListPagedResponse pagedListResponse = client.aggregatedList(project);

    List<Entry<String, ReservationsScopedList>> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getItemsMap().entrySet().iterator().next(), resources.get(0));

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
  public void aggregatedListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";

      client.aggregatedList(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone2 = "zone2-696322977";
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
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone2)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String reservation = "reservation-1563081780";

    Operation actualResponse = client.delete(project, zone, reservation);
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
  public void deleteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String reservation = "reservation-1563081780";

      client.delete(project, zone, reservation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTest() {
    String commitment = "commitment1019005717";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String id = "id3355";
    String kind = "kind3292052";
    String name = "name3373707";
    boolean satisfiesPzs = false;
    String selfLink = "selfLink-1691268851";
    boolean specificReservationRequired = false;
    String zone2 = "zone2-696322977";
    Reservation expectedResponse =
        Reservation.newBuilder()
            .setCommitment(commitment)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setId(id)
            .setKind(kind)
            .setName(name)
            .setSatisfiesPzs(satisfiesPzs)
            .setSelfLink(selfLink)
            .setSpecificReservationRequired(specificReservationRequired)
            .setZone(zone2)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String reservation = "reservation-1563081780";

    Reservation actualResponse = client.get(project, zone, reservation);
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
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String reservation = "reservation-1563081780";

      client.get(project, zone, reservation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    String etag = "etag3123477";
    boolean iamOwned = false;
    int version = 351608024;
    Policy expectedResponse =
        Policy.newBuilder().setEtag(etag).setIamOwned(iamOwned).setVersion(version).build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(project, zone, resource);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String resource = "resource-341064690";

      client.getIamPolicy(project, zone, resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone2 = "zone2-696322977";
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
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone2)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    Reservation reservationResource = Reservation.newBuilder().build();

    Operation actualResponse = client.insert(project, zone, reservationResource);
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
  public void insertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      Reservation reservationResource = Reservation.newBuilder().build();

      client.insert(project, zone, reservationResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    Reservation itemsElement = Reservation.newBuilder().build();
    List<Reservation> items = Arrays.asList(itemsElement);
    ReservationList expectedResponse =
        ReservationList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";

    ListPagedResponse pagedListResponse = client.list(project, zone);

    List<Reservation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";

      client.list(project, zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void resizeTest() {
    String clientOperationId = "clientOperationId-239630617";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String endTime = "endTime1725551537";
    String httpErrorMessage = "httpErrorMessage1276263769";
    int httpErrorStatusCode = 1386087020;
    String id = "id3355";
    String insertTime = "insertTime-103148397";
    String kind = "kind3292052";
    String name = "name3373707";
    String operationGroupId = "operationGroupId40171187";
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region = "region-934795532";
    String selfLink = "selfLink-1691268851";
    String startTime = "startTime-1573145462";
    String statusMessage = "statusMessage-239442758";
    String targetId = "targetId-815576439";
    String targetLink = "targetLink-2084812312";
    String user = "user3599307";
    String zone2 = "zone2-696322977";
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
            .setOperationGroupId(operationGroupId)
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region)
            .setSelfLink(selfLink)
            .setStartTime(startTime)
            .setStatusMessage(statusMessage)
            .setTargetId(targetId)
            .setTargetLink(targetLink)
            .setUser(user)
            .setZone(zone2)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String reservation = "reservation-1563081780";
    ReservationsResizeRequest reservationsResizeRequestResource =
        ReservationsResizeRequest.newBuilder().build();

    Operation actualResponse =
        client.resize(project, zone, reservation, reservationsResizeRequestResource);
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
  public void resizeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String reservation = "reservation-1563081780";
      ReservationsResizeRequest reservationsResizeRequestResource =
          ReservationsResizeRequest.newBuilder().build();

      client.resize(project, zone, reservation, reservationsResizeRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    String etag = "etag3123477";
    boolean iamOwned = false;
    int version = 351608024;
    Policy expectedResponse =
        Policy.newBuilder().setEtag(etag).setIamOwned(iamOwned).setVersion(version).build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String resource = "resource-341064690";
    ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();

    Policy actualResponse =
        client.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String resource = "resource-341064690";
      ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();

      client.setIamPolicy(project, zone, resource, zoneSetPolicyRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestPermissionsResponse expectedResponse = TestPermissionsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String zone = "zone3744684";
    String resource = "resource-341064690";
    TestPermissionsRequest testPermissionsRequestResource =
        TestPermissionsRequest.newBuilder().build();

    TestPermissionsResponse actualResponse =
        client.testIamPermissions(project, zone, resource, testPermissionsRequestResource);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String zone = "zone3744684";
      String resource = "resource-341064690";
      TestPermissionsRequest testPermissionsRequestResource =
          TestPermissionsRequest.newBuilder().build();

      client.testIamPermissions(project, zone, resource, testPermissionsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
