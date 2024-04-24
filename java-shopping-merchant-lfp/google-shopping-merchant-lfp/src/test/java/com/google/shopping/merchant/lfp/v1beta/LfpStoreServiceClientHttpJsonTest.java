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

package com.google.shopping.merchant.lfp.v1beta;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.lfp.v1beta.stub.HttpJsonLfpStoreServiceStub;
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
public class LfpStoreServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LfpStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLfpStoreServiceStub.getMethodDescriptors(),
            LfpStoreServiceSettings.getDefaultEndpoint());
    LfpStoreServiceSettings settings =
        LfpStoreServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LfpStoreServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpStoreServiceClient.create(settings);
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
  public void getLfpStoreTest() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockService.addResponse(expectedResponse);

    LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");

    LfpStore actualResponse = client.getLfpStore(name);
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
  public void getLfpStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
      client.getLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLfpStoreTest2() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2688/lfpStores/lfpStore-2688";

    LfpStore actualResponse = client.getLfpStore(name);
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
  public void getLfpStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2688/lfpStores/lfpStore-2688";
      client.getLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertLfpStoreTest() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    LfpStore lfpStore = LfpStore.newBuilder().build();

    LfpStore actualResponse = client.insertLfpStore(parent, lfpStore);
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
  public void insertLfpStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      LfpStore lfpStore = LfpStore.newBuilder().build();
      client.insertLfpStore(parent, lfpStore);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertLfpStoreTest2() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";
    LfpStore lfpStore = LfpStore.newBuilder().build();

    LfpStore actualResponse = client.insertLfpStore(parent, lfpStore);
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
  public void insertLfpStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      LfpStore lfpStore = LfpStore.newBuilder().build();
      client.insertLfpStore(parent, lfpStore);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLfpStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");

    client.deleteLfpStore(name);

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
  public void deleteLfpStoreExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
      client.deleteLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLfpStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-2688/lfpStores/lfpStore-2688";

    client.deleteLfpStore(name);

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
  public void deleteLfpStoreExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-2688/lfpStores/lfpStore-2688";
      client.deleteLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLfpStoresTest() throws Exception {
    LfpStore responsesElement = LfpStore.newBuilder().build();
    ListLfpStoresResponse expectedResponse =
        ListLfpStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListLfpStoresPagedResponse pagedListResponse = client.listLfpStores(parent);

    List<LfpStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpStoresList().get(0), resources.get(0));

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
  public void listLfpStoresExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listLfpStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLfpStoresTest2() throws Exception {
    LfpStore responsesElement = LfpStore.newBuilder().build();
    ListLfpStoresResponse expectedResponse =
        ListLfpStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpStores(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-4811";

    ListLfpStoresPagedResponse pagedListResponse = client.listLfpStores(parent);

    List<LfpStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpStoresList().get(0), resources.get(0));

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
  public void listLfpStoresExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-4811";
      client.listLfpStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
