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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxiesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.deleteMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.getMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.insertMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.listMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.setSslCertificatesMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonRegionTargetHttpsProxiesStub.setUrlMapMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStubSettings;
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
public class RegionTargetHttpsProxiesClientTest {
  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              deleteMethodDescriptor,
              getMethodDescriptor,
              insertMethodDescriptor,
              listMethodDescriptor,
              setSslCertificatesMethodDescriptor,
              setUrlMapMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(
          METHOD_DESCRIPTORS, RegionTargetHttpsProxiesStubSettings.getDefaultEndpoint());

  private static RegionTargetHttpsProxiesClient client;
  private static RegionTargetHttpsProxiesSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        RegionTargetHttpsProxiesSettings.newBuilder()
            .setTransportChannelProvider(
                RegionTargetHttpsProxiesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RegionTargetHttpsProxiesClient.create(clientSettings);
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
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region2 = "region2-690338393";
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
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region2)
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
    String region = "region-934795532";
    String targetHttpsProxy = "targetHttpsProxy-2095146900";

    Operation actualResponse = client.delete(project, region, targetHttpsProxy);
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
      String region = "region-934795532";
      String targetHttpsProxy = "targetHttpsProxy-2095146900";

      client.delete(project, region, targetHttpsProxy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTest() {
    String authorizationPolicy = "authorizationPolicy-1576667208";
    String creationTimestamp = "creationTimestamp567396278";
    String description = "description-1724546052";
    String id = "id3355";
    String kind = "kind3292052";
    String name = "name3373707";
    boolean proxyBind = true;
    String region2 = "region2-690338393";
    String selfLink = "selfLink-1691268851";
    String serverTlsPolicy = "serverTlsPolicy1906438002";
    String sslPolicy = "sslPolicy-1852293435";
    String urlMap = "urlMap-169850228";
    TargetHttpsProxy expectedResponse =
        TargetHttpsProxy.newBuilder()
            .setAuthorizationPolicy(authorizationPolicy)
            .setCreationTimestamp(creationTimestamp)
            .setDescription(description)
            .setId(id)
            .setKind(kind)
            .setName(name)
            .setProxyBind(proxyBind)
            .setRegion(region2)
            .setSelfLink(selfLink)
            .setServerTlsPolicy(serverTlsPolicy)
            .setSslPolicy(sslPolicy)
            .setUrlMap(urlMap)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String region = "region-934795532";
    String targetHttpsProxy = "targetHttpsProxy-2095146900";

    TargetHttpsProxy actualResponse = client.get(project, region, targetHttpsProxy);
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
      String region = "region-934795532";
      String targetHttpsProxy = "targetHttpsProxy-2095146900";

      client.get(project, region, targetHttpsProxy);
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
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region2 = "region2-690338393";
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
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region2)
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
    String region = "region-934795532";
    TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();

    Operation actualResponse = client.insert(project, region, targetHttpsProxyResource);
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
      String region = "region-934795532";
      TargetHttpsProxy targetHttpsProxyResource = TargetHttpsProxy.newBuilder().build();

      client.insert(project, region, targetHttpsProxyResource);
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
    TargetHttpsProxy itemsElement = TargetHttpsProxy.newBuilder().build();
    List<TargetHttpsProxy> items = Arrays.asList(itemsElement);
    TargetHttpsProxyList expectedResponse =
        TargetHttpsProxyList.newBuilder()
            .setId(id)
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-309310695";
    String region = "region-934795532";

    ListPagedResponse pagedListResponse = client.list(project, region);

    List<TargetHttpsProxy> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
      String region = "region-934795532";

      client.list(project, region);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setSslCertificatesTest() {
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
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region2 = "region2-690338393";
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
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region2)
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
    String region = "region-934795532";
    String targetHttpsProxy = "targetHttpsProxy-2095146900";
    RegionTargetHttpsProxiesSetSslCertificatesRequest
        regionTargetHttpsProxiesSetSslCertificatesRequestResource =
            RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();

    Operation actualResponse =
        client.setSslCertificates(
            project,
            region,
            targetHttpsProxy,
            regionTargetHttpsProxiesSetSslCertificatesRequestResource);
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
  public void setSslCertificatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String region = "region-934795532";
      String targetHttpsProxy = "targetHttpsProxy-2095146900";
      RegionTargetHttpsProxiesSetSslCertificatesRequest
          regionTargetHttpsProxiesSetSslCertificatesRequestResource =
              RegionTargetHttpsProxiesSetSslCertificatesRequest.newBuilder().build();

      client.setSslCertificates(
          project,
          region,
          targetHttpsProxy,
          regionTargetHttpsProxiesSetSslCertificatesRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setUrlMapTest() {
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
    String operationType = "operationType-1432962286";
    int progress = 1001078227;
    String region2 = "region2-690338393";
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
            .setOperationType(operationType)
            .setProgress(progress)
            .setRegion(region2)
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
    String region = "region-934795532";
    String targetHttpsProxy = "targetHttpsProxy-2095146900";
    UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();

    Operation actualResponse =
        client.setUrlMap(project, region, targetHttpsProxy, urlMapReferenceResource);
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
  public void setUrlMapExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-309310695";
      String region = "region-934795532";
      String targetHttpsProxy = "targetHttpsProxy-2095146900";
      UrlMapReference urlMapReferenceResource = UrlMapReference.newBuilder().build();

      client.setUrlMap(project, region, targetHttpsProxy, urlMapReferenceResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
