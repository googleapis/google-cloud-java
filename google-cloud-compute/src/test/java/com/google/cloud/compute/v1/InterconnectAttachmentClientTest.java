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

import static com.google.cloud.compute.v1.InterconnectAttachmentClient.AggregatedListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.compute.v1.InterconnectAttachmentClient.ListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectAttachmentStub.aggregatedListInterconnectAttachmentsMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectAttachmentStub.deleteInterconnectAttachmentMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectAttachmentStub.getInterconnectAttachmentMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectAttachmentStub.insertInterconnectAttachmentMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonInterconnectAttachmentStub.listInterconnectAttachmentsMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.InterconnectAttachmentStubSettings;
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
public class InterconnectAttachmentClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListInterconnectAttachmentsMethodDescriptor,
              deleteInterconnectAttachmentMethodDescriptor,
              getInterconnectAttachmentMethodDescriptor,
              insertInterconnectAttachmentMethodDescriptor,
              listInterconnectAttachmentsMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, InterconnectAttachmentStubSettings.getDefaultEndpoint());

  private static InterconnectAttachmentClient client;
  private static InterconnectAttachmentSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        InterconnectAttachmentSettings.newBuilder()
            .setTransportChannelProvider(
                InterconnectAttachmentSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InterconnectAttachmentClient.create(clientSettings);
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
  public void aggregatedListInterconnectAttachmentsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    InterconnectAttachmentsScopedList itemsItem =
        InterconnectAttachmentsScopedList.newBuilder().build();
    Map<String, InterconnectAttachmentsScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    InterconnectAttachmentAggregatedList expectedResponse =
        InterconnectAttachmentAggregatedList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListInterconnectAttachmentsPagedResponse pagedListResponse =
        client.aggregatedListInterconnectAttachments(project);

    List<InterconnectAttachmentsScopedList> resources =
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
  public void aggregatedListInterconnectAttachmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListInterconnectAttachments(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteInterconnectAttachmentTest() {
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

    String requestId = "requestId37109963";
    ProjectRegionInterconnectAttachmentName interconnectAttachment =
        ProjectRegionInterconnectAttachmentName.of(
            "[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");

    Operation actualResponse =
        client.deleteInterconnectAttachment(requestId, interconnectAttachment);
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
  public void deleteInterconnectAttachmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectRegionInterconnectAttachmentName interconnectAttachment =
          ProjectRegionInterconnectAttachmentName.of(
              "[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");

      client.deleteInterconnectAttachment(requestId, interconnectAttachment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getInterconnectAttachmentTest() {
    String cloudRouterIpAddress = "cloudRouterIpAddress1361134600";
    String creationTimestamp = "creationTimestamp567396278";
    String customerRouterIpAddress = "customerRouterIpAddress-741266063";
    String description = "description-1724546052";
    String googleReferenceId = "googleReferenceId534944469";
    String id = "id3355";
    ProjectGlobalInterconnectName interconnect =
        ProjectGlobalInterconnectName.of("[PROJECT]", "[INTERCONNECT]");
    String kind = "kind3292052";
    String name = "name3373707";
    String operationalStatus = "operationalStatus1274812671";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    ProjectRegionRouterName router =
        ProjectRegionRouterName.of("[PROJECT]", "[REGION]", "[ROUTER]");
    String selfLink = "selfLink-1691268851";
    InterconnectAttachment expectedResponse =
        InterconnectAttachment.newBuilder()
            .setCloudRouterIpAddress(cloudRouterIpAddress)
            .setCreationTimestamp(creationTimestamp)
            .setCustomerRouterIpAddress(customerRouterIpAddress)
            .setDescription(description)
            .setGoogleReferenceId(googleReferenceId)
            .setId(id)
            .setInterconnect(interconnect.toString())
            .setKind(kind)
            .setName(name)
            .setOperationalStatus(operationalStatus)
            .setRegion(region.toString())
            .setRouter(router.toString())
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionInterconnectAttachmentName interconnectAttachment =
        ProjectRegionInterconnectAttachmentName.of(
            "[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");

    InterconnectAttachment actualResponse =
        client.getInterconnectAttachment(interconnectAttachment);
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
  public void getInterconnectAttachmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionInterconnectAttachmentName interconnectAttachment =
          ProjectRegionInterconnectAttachmentName.of(
              "[PROJECT]", "[REGION]", "[INTERCONNECT_ATTACHMENT]");

      client.getInterconnectAttachment(interconnectAttachment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertInterconnectAttachmentTest() {
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

    String requestId = "requestId37109963";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    InterconnectAttachment interconnectAttachmentResource =
        InterconnectAttachment.newBuilder().build();

    Operation actualResponse =
        client.insertInterconnectAttachment(requestId, region, interconnectAttachmentResource);
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
  public void insertInterconnectAttachmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
      InterconnectAttachment interconnectAttachmentResource =
          InterconnectAttachment.newBuilder().build();

      client.insertInterconnectAttachment(requestId, region, interconnectAttachmentResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInterconnectAttachmentsTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    InterconnectAttachment itemsElement = InterconnectAttachment.newBuilder().build();
    List<InterconnectAttachment> items = Arrays.asList(itemsElement);
    InterconnectAttachmentList expectedResponse =
        InterconnectAttachmentList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

    ListInterconnectAttachmentsPagedResponse pagedListResponse =
        client.listInterconnectAttachments(region);

    List<InterconnectAttachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listInterconnectAttachmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");

      client.listInterconnectAttachments(region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
