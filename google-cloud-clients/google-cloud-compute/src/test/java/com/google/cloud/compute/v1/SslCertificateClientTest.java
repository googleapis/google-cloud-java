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

import static com.google.cloud.compute.v1.SslCertificateClient.ListSslCertificatesPagedResponse;
import static com.google.cloud.compute.v1.stub.HttpJsonSslCertificateStub.deleteSslCertificateMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSslCertificateStub.getSslCertificateMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSslCertificateStub.insertSslCertificateMethodDescriptor;
import static com.google.cloud.compute.v1.stub.HttpJsonSslCertificateStub.listSslCertificatesMethodDescriptor;

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
import com.google.cloud.compute.v1.stub.SslCertificateStubSettings;
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
public class SslCertificateClientTest {

  private static final List<ApiMethodDescriptor> METHOD_DESCRIPTORS =
      ImmutableList.copyOf(
          Lists.<ApiMethodDescriptor>newArrayList(
              deleteSslCertificateMethodDescriptor,
              getSslCertificateMethodDescriptor,
              insertSslCertificateMethodDescriptor,
              listSslCertificatesMethodDescriptor));
  private static final MockHttpService mockService =
      new MockHttpService(METHOD_DESCRIPTORS, SslCertificateStubSettings.getDefaultEndpoint());

  private static SslCertificateClient client;
  private static SslCertificateSettings clientSettings;

  @BeforeClass
  public static void setUp() throws IOException {
    clientSettings =
        SslCertificateSettings.newBuilder()
            .setTransportChannelProvider(
                SslCertificateSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SslCertificateClient.create(clientSettings);
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
  public void deleteSslCertificateTest() {
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

    ProjectGlobalSslCertificateName sslCertificate =
        ProjectGlobalSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");

    Operation actualResponse = client.deleteSslCertificate(sslCertificate);
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
  public void deleteSslCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalSslCertificateName sslCertificate =
          ProjectGlobalSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");

      client.deleteSslCertificate(sslCertificate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSslCertificateTest() {
    String privateKey = "privateKey1971943843";
    String kind = "kind3292052";
    String certificate = "certificate1952399767";
    String creationTimestamp = "creationTimestamp567396278";
    String name = "name3373707";
    String description = "description-1724546052";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    SslCertificate expectedResponse =
        SslCertificate.newBuilder()
            .setPrivateKey(privateKey)
            .setKind(kind)
            .setCertificate(certificate)
            .setCreationTimestamp(creationTimestamp)
            .setName(name)
            .setDescription(description)
            .setId(id)
            .setSelfLink(selfLink)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectGlobalSslCertificateName sslCertificate =
        ProjectGlobalSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");

    SslCertificate actualResponse = client.getSslCertificate(sslCertificate);
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
  public void getSslCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectGlobalSslCertificateName sslCertificate =
          ProjectGlobalSslCertificateName.of("[PROJECT]", "[SSL_CERTIFICATE]");

      client.getSslCertificate(sslCertificate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void insertSslCertificateTest() {
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

    ProjectName project = ProjectName.of("[PROJECT]");
    SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();

    Operation actualResponse = client.insertSslCertificate(project, sslCertificateResource);
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
  public void insertSslCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");
      SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();

      client.insertSslCertificate(project, sslCertificateResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSslCertificatesTest() {
    String kind = "kind3292052";
    String nextPageToken = "";
    String id = "id3355";
    String selfLink = "selfLink-1691268851";
    SslCertificate itemsElement = SslCertificate.newBuilder().build();
    List<SslCertificate> items = Arrays.asList(itemsElement);
    SslCertificateList expectedResponse =
        SslCertificateList.newBuilder()
            .setKind(kind)
            .setNextPageToken(nextPageToken)
            .setId(id)
            .setSelfLink(selfLink)
            .addAllItems(items)
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName project = ProjectName.of("[PROJECT]");

    ListSslCertificatesPagedResponse pagedListResponse = client.listSslCertificates(project);

    List<SslCertificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
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
  public void listSslCertificatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName project = ProjectName.of("[PROJECT]");

      client.listSslCertificates(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
