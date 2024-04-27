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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.Timestamp;
import com.google.shopping.merchant.lfp.v1beta.stub.HttpJsonLfpInventoryServiceStub;
import com.google.shopping.type.Price;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LfpInventoryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LfpInventoryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLfpInventoryServiceStub.getMethodDescriptors(),
            LfpInventoryServiceSettings.getDefaultEndpoint());
    LfpInventoryServiceSettings settings =
        LfpInventoryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LfpInventoryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpInventoryServiceClient.create(settings);
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
  public void insertLfpInventoryTest() throws Exception {
    LfpInventory expectedResponse =
        LfpInventory.newBuilder()
            .setName(
                LfpInventoryName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]", "[OFFER]")
                    .toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setOfferId("offerId-1548813161")
            .setRegionCode("regionCode-1991004415")
            .setContentLanguage("contentLanguage810066673")
            .setGtin("gtin3183314")
            .setPrice(Price.newBuilder().build())
            .setAvailability("availability1997542747")
            .setQuantity(-1285004149)
            .setCollectionTime(Timestamp.newBuilder().build())
            .setPickupMethod("pickupMethod139786877")
            .setPickupSla("pickupSla-1416603380")
            .setFeedLabel("feedLabel-1661895690")
            .build();
    mockService.addResponse(expectedResponse);

    InsertLfpInventoryRequest request =
        InsertLfpInventoryRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setLfpInventory(LfpInventory.newBuilder().build())
            .build();

    LfpInventory actualResponse = client.insertLfpInventory(request);
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
  public void insertLfpInventoryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertLfpInventoryRequest request =
          InsertLfpInventoryRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setLfpInventory(LfpInventory.newBuilder().build())
              .build();
      client.insertLfpInventory(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
