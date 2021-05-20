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

import static com.google.cloud.compute.v1.InterconnectsClient.ListPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.deleteMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.getDiagnosticsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.getMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.insertMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.listMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectsStub.patchMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.InterconnectsStubSettings;
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
public class InterconnectsClientTest {
  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              deleteMethodDescriptor,
              getMethodDescriptor,
              getDiagnosticsMethodDescriptor,
              insertMethodDescriptor,
              listMethodDescriptor,
              patchMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, InterconnectsStubSettings.getDefaultEndpoint());

  private static InterconnectsClient client;
  private static InterconnectsSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        InterconnectsSettings.newBuilder()
            .setTransportChannelProvider(
                InterconnectsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InterconnectsClient.create(clientSettings);
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
    String zone = "zone3744684";
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
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String interconnect = "interconnect-849140594";

    Operation actualResponse = client.delete(project, interconnect);
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
      String interconnect = "interconnect-849140594";

      client.delete(project, interconnect);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTest() {
    boolean adminEnabled = false;
    String creationTimestamp = "creationTimestamp567396278";
    String customerName = "customerName-2143818164";
    String description = "description-1724546052";
    String googleIpAddress = "googleIpAddress1516847778";
    String googleReferenceId = "googleReferenceId534944469";
    String id = "id3355";
    String kind = "kind3292052";
    String location = "location1901043637";
    String name = "name3373707";
    String nocContactEmail = "nocContactEmail1087814656";
    String peerIpAddress = "peerIpAddress-1939747879";
    int provisionedLinkCount = 1199724171;
    int requestedLinkCount = 1118793211;
    String selfLink = "selfLink-1691268851";
    Interconnect expectedResponse =
        Interconnect.newBuilder()
            .setAdminEnabled(adminEnabled)
            .setCreationTimestamp(creationTimestamp)
            .setCustomerName(customerName)
            .setDescription(description)
            .setGoogleIpAddress(googleIpAddress)
            .setGoogleReferenceId(googleReferenceId)
            .setId(id)
            .setKind(kind)
            .setLocation(location)
            .setName(name)
            .setNocContactEmail(nocContactEmail)
            .setPeerIpAddress(peerIpAddress)
            .setProvisionedLinkCount(provisionedLinkCount)
            .setRequestedLinkCount(requestedLinkCount)
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String interconnect = "interconnect-849140594";

    Interconnect actualResponse = client.get(project, interconnect);
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
      String interconnect = "interconnect-849140594";

      client.get(project, interconnect);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDiagnosticsTest() {
    InterconnectsGetDiagnosticsResponse expectedResponse =
        InterconnectsGetDiagnosticsResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String interconnect = "interconnect-849140594";

    InterconnectsGetDiagnosticsResponse actualResponse =
        client.getDiagnostics(project, interconnect);
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
  public void getDiagnosticsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String interconnect = "interconnect-849140594";

      client.getDiagnostics(project, interconnect);
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
    String zone = "zone3744684";
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
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    Interconnect interconnectResource = Interconnect.newBuilder().build();

    Operation actualResponse = client.insert(project, interconnectResource);
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
      Interconnect interconnectResource = Interconnect.newBuilder().build();

      client.insert(project, interconnectResource);
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
    Interconnect itemsElement = Interconnect.newBuilder().build();
    List<Interconnect> items = Arrays.asList(itemsElement);
    InterconnectList expectedResponse =
        InterconnectList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";

    ListPagedResponse pagedListResponse = client.list(project);

    List<Interconnect> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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

      client.list(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void patchTest() {
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
    String zone = "zone3744684";
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
            .setZone(zone)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String interconnect = "interconnect-849140594";
    Interconnect interconnectResource = Interconnect.newBuilder().build();

    Operation actualResponse = client.patch(project, interconnect, interconnectResource);
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
  public void patchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String interconnect = "interconnect-849140594";
      Interconnect interconnectResource = Interconnect.newBuilder().build();

      client.patch(project, interconnect, interconnectResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
