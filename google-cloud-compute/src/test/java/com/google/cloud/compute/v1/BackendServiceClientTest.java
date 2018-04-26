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

import static com.google.cloud.compute.v1.BackendServiceClient.AggregatedListBackendServicesPagedResponse;
import static com.google.cloud.compute.v1.BackendServiceClient.ListBackendServicesPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.aggregatedListBackendServicesMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.deleteBackendServiceMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.getBackendServiceMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.getHealthBackendServiceMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.insertBackendServiceMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.listBackendServicesMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.patchBackendServiceMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonBackendServiceStub.updateBackendServiceMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.BackendServiceStubSettings;
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
public class BackendServiceClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              aggregatedListBackendServicesMethodDescriptor,
              deleteBackendServiceMethodDescriptor,
              getBackendServiceMethodDescriptor,
              getHealthBackendServiceMethodDescriptor,
              insertBackendServiceMethodDescriptor,
              listBackendServicesMethodDescriptor,
              patchBackendServiceMethodDescriptor,
              updateBackendServiceMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, BackendServiceStubSettings.getDefaultEndpoint());

  private static BackendServiceClient client;
  private static BackendServiceSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        BackendServiceSettings.newBuilder()
            .setTransportChannelProvider(
                BackendServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BackendServiceClient.create(clientSettings);
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
  public void aggregatedListBackendServicesTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    BackendServicesScopedList itemsItem = BackendServicesScopedList.newBuilder().build();
    Map<String, BackendServicesScopedList> items = new HashMap<>();
    items.put("items", itemsItem);
    BackendServiceAggregatedList expectedResponse =
        BackendServiceAggregatedList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .putAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    AggregatedListBackendServicesPagedResponse pagedListResponse =
        client.aggregatedListBackendServices(project);

    List<BackendServicesScopedList> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void aggregatedListBackendServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.aggregatedListBackendServices(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteBackendServiceTest() {
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
    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");

    Operation actualResponse = client.deleteBackendService(requestId, backendService);
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
  public void deleteBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectGlobalBackendServiceName backendService =
          ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");

      client.deleteBackendService(requestId, backendService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getBackendServiceTest() {
    Integer affinityCookieTtlSec = 1777486694;
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    Boolean enableCDN = false;
    String fingerprint = "fingerprint-1375934236";
    String id = "id3355";
    String kind = "kind3292052";
    String loadBalancingScheme = "loadBalancingScheme1974502980";
    String name = "name3373707";
    Integer port = 3446913;
    String portName = "portName1115276169";
    String protocol = "protocol-989163880";
    ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
    String selfLink = "selfLink-1691268851";
    String sessionAffinity = "sessionAffinity1000759473";
    Integer timeoutSec = 2067488653;
    BackendService expectedResponse =
        BackendService.newBuilder()
            .setAffinityCookieTtlSec(affinityCookieTtlSec)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setEnableCDN(enableCDN)
            .setFingerprint(fingerprint)
            .setId(id)
            .setKind(kind)
            .setLoadBalancingScheme(loadBalancingScheme)
            .setName(name)
            .setPort(port)
            .setPortName(portName)
            .setProtocol(protocol)
            .setRegion(region.toString())
            .setSelfLink(selfLink)
            .setSessionAffinity(sessionAffinity)
            .setTimeoutSec(timeoutSec)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");

    BackendService actualResponse = client.getBackendService(backendService);
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
  public void getBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalBackendServiceName backendService =
          ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");

      client.getBackendService(backendService);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getHealthBackendServiceTest() {
    String kind = "kind3292052";
    BackendServiceGroupHealth expectedResponse =
        BackendServiceGroupHealth.newBuilder().setKind(kind).build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
    ResourceGroupReference resourceGroupReferenceResource =
        ResourceGroupReference.newBuilder().build();

    BackendServiceGroupHealth actualResponse =
        client.getHealthBackendService(backendService, resourceGroupReferenceResource);
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
  public void getHealthBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalBackendServiceName backendService =
          ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
      ResourceGroupReference resourceGroupReferenceResource =
          ResourceGroupReference.newBuilder().build();

      client.getHealthBackendService(backendService, resourceGroupReferenceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertBackendServiceTest() {
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
    ProjectName project = ProjectName.of("[PROJECT]");
    BackendService backendServiceResource = BackendService.newBuilder().build();

    Operation actualResponse =
        client.insertBackendService(requestId, project, backendServiceResource);
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
  public void insertBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectName project = ProjectName.of("[PROJECT]");
      BackendService backendServiceResource = BackendService.newBuilder().build();

      client.insertBackendService(requestId, project, backendServiceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listBackendServicesTest() {
    String id = "id3355";
    String kind = "kind3292052";
    String nextPageToken = "";
    String selfLink = "selfLink-1691268851";
    BackendService itemsElement = BackendService.newBuilder().build();
    List<BackendService> items = Arrays.asList(itemsElement);
    BackendServiceList expectedResponse =
        BackendServiceList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListBackendServicesPagedResponse pagedListResponse = client.listBackendServices(project);

    List<BackendService> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listBackendServicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listBackendServices(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void patchBackendServiceTest() {
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
    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
    BackendService backendServiceResource = BackendService.newBuilder().build();

    Operation actualResponse =
        client.patchBackendService(requestId, backendService, backendServiceResource);
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
  public void patchBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectGlobalBackendServiceName backendService =
          ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
      BackendService backendServiceResource = BackendService.newBuilder().build();

      client.patchBackendService(requestId, backendService, backendServiceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateBackendServiceTest() {
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
    ProjectGlobalBackendServiceName backendService =
        ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
    BackendService backendServiceResource = BackendService.newBuilder().build();

    Operation actualResponse =
        client.updateBackendService(requestId, backendService, backendServiceResource);
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
  public void updateBackendServiceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String requestId = "requestId37109963";
      ProjectGlobalBackendServiceName backendService =
          ProjectGlobalBackendServiceName.of("[PROJECT]", "[BACKEND_SERVICE]");
      BackendService backendServiceResource = BackendService.newBuilder().build();

      client.updateBackendService(requestId, backendService, backendServiceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
