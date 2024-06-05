/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.iap.v1.stub.HttpJsonIdentityAwareProxyOAuthServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
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
public class IdentityAwareProxyOAuthServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IdentityAwareProxyOAuthServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIdentityAwareProxyOAuthServiceStub.getMethodDescriptors(),
            IdentityAwareProxyOAuthServiceSettings.getDefaultEndpoint());
    IdentityAwareProxyOAuthServiceSettings settings =
        IdentityAwareProxyOAuthServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IdentityAwareProxyOAuthServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityAwareProxyOAuthServiceClient.create(settings);
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
  public void listBrandsTest() throws Exception {
    ListBrandsResponse expectedResponse =
        ListBrandsResponse.newBuilder().addAllBrands(new ArrayList<Brand>()).build();
    mockService.addResponse(expectedResponse);

    ListBrandsRequest request =
        ListBrandsRequest.newBuilder().setParent("projects/project-2353").build();

    ListBrandsResponse actualResponse = client.listBrands(request);
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
  public void listBrandsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListBrandsRequest request =
          ListBrandsRequest.newBuilder().setParent("projects/project-2353").build();
      client.listBrands(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBrandTest() throws Exception {
    Brand expectedResponse =
        Brand.newBuilder()
            .setName("name3373707")
            .setSupportEmail("supportEmail-1568709363")
            .setApplicationTitle("applicationTitle-9699608")
            .setOrgInternalOnly(true)
            .build();
    mockService.addResponse(expectedResponse);

    CreateBrandRequest request =
        CreateBrandRequest.newBuilder()
            .setParent("projects/project-2353")
            .setBrand(Brand.newBuilder().build())
            .build();

    Brand actualResponse = client.createBrand(request);
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
  public void createBrandExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateBrandRequest request =
          CreateBrandRequest.newBuilder()
              .setParent("projects/project-2353")
              .setBrand(Brand.newBuilder().build())
              .build();
      client.createBrand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBrandTest() throws Exception {
    Brand expectedResponse =
        Brand.newBuilder()
            .setName("name3373707")
            .setSupportEmail("supportEmail-1568709363")
            .setApplicationTitle("applicationTitle-9699608")
            .setOrgInternalOnly(true)
            .build();
    mockService.addResponse(expectedResponse);

    GetBrandRequest request =
        GetBrandRequest.newBuilder().setName("projects/project-3766/brands/brand-3766").build();

    Brand actualResponse = client.getBrand(request);
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
  public void getBrandExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetBrandRequest request =
          GetBrandRequest.newBuilder().setName("projects/project-3766/brands/brand-3766").build();
      client.getBrand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIdentityAwareProxyClientTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    CreateIdentityAwareProxyClientRequest request =
        CreateIdentityAwareProxyClientRequest.newBuilder()
            .setParent("projects/project-1513/brands/brand-1513")
            .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
            .build();

    IdentityAwareProxyClient actualResponse = client.createIdentityAwareProxyClient(request);
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
  public void createIdentityAwareProxyClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateIdentityAwareProxyClientRequest request =
          CreateIdentityAwareProxyClientRequest.newBuilder()
              .setParent("projects/project-1513/brands/brand-1513")
              .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
              .build();
      client.createIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityAwareProxyClientsTest() throws Exception {
    IdentityAwareProxyClient responsesElement = IdentityAwareProxyClient.newBuilder().build();
    ListIdentityAwareProxyClientsResponse expectedResponse =
        ListIdentityAwareProxyClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityAwareProxyClients(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListIdentityAwareProxyClientsRequest request =
        ListIdentityAwareProxyClientsRequest.newBuilder()
            .setParent("projects/project-1513/brands/brand-1513")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIdentityAwareProxyClientsPagedResponse pagedListResponse =
        client.listIdentityAwareProxyClients(request);

    List<IdentityAwareProxyClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getIdentityAwareProxyClientsList().get(0), resources.get(0));

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
  public void listIdentityAwareProxyClientsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListIdentityAwareProxyClientsRequest request =
          ListIdentityAwareProxyClientsRequest.newBuilder()
              .setParent("projects/project-1513/brands/brand-1513")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIdentityAwareProxyClients(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityAwareProxyClientTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    GetIdentityAwareProxyClientRequest request =
        GetIdentityAwareProxyClientRequest.newBuilder()
            .setName(
                "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
            .build();

    IdentityAwareProxyClient actualResponse = client.getIdentityAwareProxyClient(request);
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
  public void getIdentityAwareProxyClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIdentityAwareProxyClientRequest request =
          GetIdentityAwareProxyClientRequest.newBuilder()
              .setName(
                  "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
              .build();
      client.getIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetIdentityAwareProxyClientSecretTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockService.addResponse(expectedResponse);

    ResetIdentityAwareProxyClientSecretRequest request =
        ResetIdentityAwareProxyClientSecretRequest.newBuilder()
            .setName(
                "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
            .build();

    IdentityAwareProxyClient actualResponse = client.resetIdentityAwareProxyClientSecret(request);
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
  public void resetIdentityAwareProxyClientSecretExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResetIdentityAwareProxyClientSecretRequest request =
          ResetIdentityAwareProxyClientSecretRequest.newBuilder()
              .setName(
                  "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
              .build();
      client.resetIdentityAwareProxyClientSecret(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIdentityAwareProxyClientTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeleteIdentityAwareProxyClientRequest request =
        DeleteIdentityAwareProxyClientRequest.newBuilder()
            .setName(
                "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
            .build();

    client.deleteIdentityAwareProxyClient(request);

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
  public void deleteIdentityAwareProxyClientExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeleteIdentityAwareProxyClientRequest request =
          DeleteIdentityAwareProxyClientRequest.newBuilder()
              .setName(
                  "projects/project-4612/brands/brand-4612/identityAwareProxyClients/identityAwareProxyClient-4612")
              .build();
      client.deleteIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
