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

package com.google.cloud.kms.inventory.v1;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.kms.inventory.v1.stub.HttpJsonKeyTrackingServiceStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class KeyTrackingServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static KeyTrackingServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonKeyTrackingServiceStub.getMethodDescriptors(),
            KeyTrackingServiceSettings.getDefaultEndpoint());
    KeyTrackingServiceSettings settings =
        KeyTrackingServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                KeyTrackingServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = KeyTrackingServiceClient.create(settings);
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
  public void getProtectedResourcesSummaryTest() throws Exception {
    ProtectedResourcesSummary expectedResponse =
        ProtectedResourcesSummary.newBuilder()
            .setName(
                ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
                        "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setResourceCount(287552926)
            .setProjectCount(-953448343)
            .putAllResourceTypes(new HashMap<String, Long>())
            .putAllCloudProducts(new HashMap<String, Long>())
            .putAllLocations(new HashMap<String, Long>())
            .build();
    mockService.addResponse(expectedResponse);

    ProtectedResourcesSummaryName name =
        ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    ProtectedResourcesSummary actualResponse = client.getProtectedResourcesSummary(name);
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
  public void getProtectedResourcesSummaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProtectedResourcesSummaryName name =
          ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      client.getProtectedResourcesSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProtectedResourcesSummaryTest2() throws Exception {
    ProtectedResourcesSummary expectedResponse =
        ProtectedResourcesSummary.newBuilder()
            .setName(
                ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
                        "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setResourceCount(287552926)
            .setProjectCount(-953448343)
            .putAllResourceTypes(new HashMap<String, Long>())
            .putAllCloudProducts(new HashMap<String, Long>())
            .putAllLocations(new HashMap<String, Long>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4975/locations/location-4975/keyRings/keyRing-4975/cryptoKeys/cryptoKey-4975";

    ProtectedResourcesSummary actualResponse = client.getProtectedResourcesSummary(name);
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
  public void getProtectedResourcesSummaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4975/locations/location-4975/keyRings/keyRing-4975/cryptoKeys/cryptoKey-4975";
      client.getProtectedResourcesSummary(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
    ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

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
  public void searchProtectedResourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
      ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest2() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
    String cryptoKey = "cryptoKey1598288350";

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

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
  public void searchProtectedResourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      OrganizationName scope = OrganizationName.of("[ORGANIZATION]");
      String cryptoKey = "cryptoKey1598288350";
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest3() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "organizations/organization-6471";
    ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

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
  public void searchProtectedResourcesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "organizations/organization-6471";
      ResourceName cryptoKey = OrganizationName.of("[ORGANIZATION]");
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProtectedResourcesTest4() throws Exception {
    ProtectedResource responsesElement = ProtectedResource.newBuilder().build();
    SearchProtectedResourcesResponse expectedResponse =
        SearchProtectedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProtectedResources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String scope = "organizations/organization-6471";
    String cryptoKey = "cryptoKey1598288350";

    SearchProtectedResourcesPagedResponse pagedListResponse =
        client.searchProtectedResources(scope, cryptoKey);

    List<ProtectedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProtectedResourcesList().get(0), resources.get(0));

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
  public void searchProtectedResourcesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String scope = "organizations/organization-6471";
      String cryptoKey = "cryptoKey1598288350";
      client.searchProtectedResources(scope, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
