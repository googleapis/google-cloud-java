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

import static com.google.cloud.compute.v1.ZoneOperationClient.ListZoneOperationsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonZoneOperationStub.deleteZoneOperationMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonZoneOperationStub.getZoneOperationMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonZoneOperationStub.listZoneOperationsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.ZoneOperationStubSettings;
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
public class ZoneOperationClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              deleteZoneOperationMethodDescriptor,
              getZoneOperationMethodDescriptor,
              listZoneOperationsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, ZoneOperationStubSettings.getDefaultEndpoint());

  private static ZoneOperationClient client;
  private static ZoneOperationSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        ZoneOperationSettings.newBuilder()
            .setTransportChannelProvider(
                ZoneOperationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ZoneOperationClient.create(clientSettings);
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
  public void deleteZoneOperationTest() {
    mockService.addNullResponse();

    ProjectZoneOperationName operation =
        ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");

    client.deleteZoneOperation(operation);

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
  public void deleteZoneOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneOperationName operation =
          ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");

      client.deleteZoneOperation(operation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getZoneOperationTest() {
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

    ProjectZoneOperationName operation =
        ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");

    Operation actualResponse = client.getZoneOperation(operation);
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
  public void getZoneOperationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneOperationName operation =
          ProjectZoneOperationName.of("[PROJECT]", "[ZONE]", "[OPERATION]");

      client.getZoneOperation(operation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listZoneOperationsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    Operation itemsElement = Operation.newBuilder().build();
    List<Operation> items = Arrays.asList(itemsElement);
    OperationList expectedResponse =
        OperationList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

    ListZoneOperationsPagedResponse pagedListResponse = client.listZoneOperations(zone);

    List<Operation> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listZoneOperationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");

      client.listZoneOperations(zone);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
