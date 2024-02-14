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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.retail.v2alpha.stub.HttpJsonMerchantCenterAccountLinkServiceStub;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MerchantCenterAccountLinkServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MerchantCenterAccountLinkServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMerchantCenterAccountLinkServiceStub.getMethodDescriptors(),
            MerchantCenterAccountLinkServiceSettings.getDefaultEndpoint());
    MerchantCenterAccountLinkServiceSettings settings =
        MerchantCenterAccountLinkServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MerchantCenterAccountLinkServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MerchantCenterAccountLinkServiceClient.create(settings);
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
  public void listMerchantCenterAccountLinksTest() throws Exception {
    ListMerchantCenterAccountLinksResponse expectedResponse =
        ListMerchantCenterAccountLinksResponse.newBuilder()
            .addAllMerchantCenterAccountLinks(new ArrayList<MerchantCenterAccountLink>())
            .build();
    mockService.addResponse(expectedResponse);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");

    ListMerchantCenterAccountLinksResponse actualResponse =
        client.listMerchantCenterAccountLinks(parent);
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
  public void listMerchantCenterAccountLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      client.listMerchantCenterAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMerchantCenterAccountLinksTest2() throws Exception {
    ListMerchantCenterAccountLinksResponse expectedResponse =
        ListMerchantCenterAccountLinksResponse.newBuilder()
            .addAllMerchantCenterAccountLinks(new ArrayList<MerchantCenterAccountLink>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";

    ListMerchantCenterAccountLinksResponse actualResponse =
        client.listMerchantCenterAccountLinks(parent);
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
  public void listMerchantCenterAccountLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      client.listMerchantCenterAccountLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMerchantCenterAccountLinkTest() throws Exception {
    MerchantCenterAccountLink expectedResponse =
        MerchantCenterAccountLink.newBuilder()
            .setName(
                MerchantCenterAccountLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
                    .toString())
            .setId("id3355")
            .setMerchantCenterAccountId(-1368465440)
            .setBranchId("branchId-25407907")
            .setFeedLabel("feedLabel-1661895690")
            .setLanguageCode("languageCode-2092349083")
            .addAllFeedFilters(new ArrayList<MerchantCenterAccountLink.MerchantCenterFeedFilter>())
            .setProjectId("projectId-894832108")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMerchantCenterAccountLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
    MerchantCenterAccountLink merchantCenterAccountLink =
        MerchantCenterAccountLink.newBuilder().build();

    MerchantCenterAccountLink actualResponse =
        client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
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
  public void createMerchantCenterAccountLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      MerchantCenterAccountLink merchantCenterAccountLink =
          MerchantCenterAccountLink.newBuilder().build();
      client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createMerchantCenterAccountLinkTest2() throws Exception {
    MerchantCenterAccountLink expectedResponse =
        MerchantCenterAccountLink.newBuilder()
            .setName(
                MerchantCenterAccountLinkName.of(
                        "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]")
                    .toString())
            .setId("id3355")
            .setMerchantCenterAccountId(-1368465440)
            .setBranchId("branchId-25407907")
            .setFeedLabel("feedLabel-1661895690")
            .setLanguageCode("languageCode-2092349083")
            .addAllFeedFilters(new ArrayList<MerchantCenterAccountLink.MerchantCenterFeedFilter>())
            .setProjectId("projectId-894832108")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createMerchantCenterAccountLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
    MerchantCenterAccountLink merchantCenterAccountLink =
        MerchantCenterAccountLink.newBuilder().build();

    MerchantCenterAccountLink actualResponse =
        client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
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
  public void createMerchantCenterAccountLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6267/locations/location-6267/catalogs/catalog-6267";
      MerchantCenterAccountLink merchantCenterAccountLink =
          MerchantCenterAccountLink.newBuilder().build();
      client.createMerchantCenterAccountLinkAsync(parent, merchantCenterAccountLink).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteMerchantCenterAccountLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    MerchantCenterAccountLinkName name =
        MerchantCenterAccountLinkName.of(
            "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]");

    client.deleteMerchantCenterAccountLink(name);

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
  public void deleteMerchantCenterAccountLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      MerchantCenterAccountLinkName name =
          MerchantCenterAccountLinkName.of(
              "[PROJECT]", "[LOCATION]", "[CATALOG]", "[MERCHANT_CENTER_ACCOUNT_LINK]");
      client.deleteMerchantCenterAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMerchantCenterAccountLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-217/locations/location-217/catalogs/catalog-217/merchantCenterAccountLinks/merchantCenterAccountLink-217";

    client.deleteMerchantCenterAccountLink(name);

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
  public void deleteMerchantCenterAccountLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-217/locations/location-217/catalogs/catalog-217/merchantCenterAccountLinks/merchantCenterAccountLink-217";
      client.deleteMerchantCenterAccountLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
