/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.appengine.v1;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.appengine.v1.stub.HttpJsonAuthorizedCertificatesStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AuthorizedCertificatesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AuthorizedCertificatesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAuthorizedCertificatesStub.getMethodDescriptors(),
            AuthorizedCertificatesSettings.getDefaultEndpoint());
    AuthorizedCertificatesSettings settings =
        AuthorizedCertificatesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AuthorizedCertificatesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuthorizedCertificatesClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listAuthorizedCertificatesTest() throws Exception {
    AuthorizedCertificate responsesElement = AuthorizedCertificate.newBuilder().build();
    ListAuthorizedCertificatesResponse expectedResponse =
        ListAuthorizedCertificatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListAuthorizedCertificatesRequest request =
        ListAuthorizedCertificatesRequest.newBuilder()
            .setParent("apps/app-3559")
            .setView(AuthorizedCertificateView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAuthorizedCertificatesPagedResponse pagedListResponse =
        client.listAuthorizedCertificates(request);

    List<AuthorizedCertificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

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
  public void listAuthorizedCertificatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListAuthorizedCertificatesRequest request =
          ListAuthorizedCertificatesRequest.newBuilder()
              .setParent("apps/app-3559")
              .setView(AuthorizedCertificateView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAuthorizedCertificates(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockService.addResponse(expectedResponse);

    GetAuthorizedCertificateRequest request =
        GetAuthorizedCertificateRequest.newBuilder()
            .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
            .setView(AuthorizedCertificateView.forNumber(0))
            .build();

    AuthorizedCertificate actualResponse = client.getAuthorizedCertificate(request);
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
  public void getAuthorizedCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetAuthorizedCertificateRequest request =
          GetAuthorizedCertificateRequest.newBuilder()
              .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
              .setView(AuthorizedCertificateView.forNumber(0))
              .build();
      client.getAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockService.addResponse(expectedResponse);

    CreateAuthorizedCertificateRequest request =
        CreateAuthorizedCertificateRequest.newBuilder()
            .setParent("apps/app-3559")
            .setCertificate(AuthorizedCertificate.newBuilder().build())
            .build();

    AuthorizedCertificate actualResponse = client.createAuthorizedCertificate(request);
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
  public void createAuthorizedCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateAuthorizedCertificateRequest request =
          CreateAuthorizedCertificateRequest.newBuilder()
              .setParent("apps/app-3559")
              .setCertificate(AuthorizedCertificate.newBuilder().build())
              .build();
      client.createAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockService.addResponse(expectedResponse);

    UpdateAuthorizedCertificateRequest request =
        UpdateAuthorizedCertificateRequest.newBuilder()
            .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
            .setCertificate(AuthorizedCertificate.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    AuthorizedCertificate actualResponse = client.updateAuthorizedCertificate(request);
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
  public void updateAuthorizedCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateAuthorizedCertificateRequest request =
          UpdateAuthorizedCertificateRequest.newBuilder()
              .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
              .setCertificate(AuthorizedCertificate.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthorizedCertificateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteAuthorizedCertificateRequest request =
        DeleteAuthorizedCertificateRequest.newBuilder()
            .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
            .build();

    client.deleteAuthorizedCertificate(request);

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
  public void deleteAuthorizedCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteAuthorizedCertificateRequest request =
          DeleteAuthorizedCertificateRequest.newBuilder()
              .setName("apps/app-9719/authorizedCertificates/authorizedCertificate-9719")
              .build();
      client.deleteAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
