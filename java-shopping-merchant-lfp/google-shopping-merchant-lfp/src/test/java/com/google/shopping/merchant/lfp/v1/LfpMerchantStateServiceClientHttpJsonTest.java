/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.lfp.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.shopping.merchant.lfp.v1.stub.HttpJsonLfpMerchantStateServiceStub;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LfpMerchantStateServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LfpMerchantStateServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLfpMerchantStateServiceStub.getMethodDescriptors(),
            LfpMerchantStateServiceSettings.getDefaultEndpoint());
    LfpMerchantStateServiceSettings settings =
        LfpMerchantStateServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LfpMerchantStateServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpMerchantStateServiceClient.create(settings);
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
  public void getLfpMerchantStateTest() throws Exception {
    LfpMerchantState expectedResponse =
        LfpMerchantState.newBuilder()
            .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
            .setLinkedGbps(-1308276092)
            .addAllStoreStates(new ArrayList<LfpMerchantState.LfpStoreState>())
            .setInventoryStats(LfpMerchantState.InventoryStats.newBuilder().build())
            .addAllCountrySettings(new ArrayList<LfpMerchantState.CountrySettings>())
            .build();
    mockService.addResponse(expectedResponse);

    LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");

    LfpMerchantState actualResponse = client.getLfpMerchantState(name);
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
  public void getLfpMerchantStateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LfpMerchantStateName name = LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]");
      client.getLfpMerchantState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLfpMerchantStateTest2() throws Exception {
    LfpMerchantState expectedResponse =
        LfpMerchantState.newBuilder()
            .setName(LfpMerchantStateName.of("[ACCOUNT]", "[LFP_MERCHANT_STATE]").toString())
            .setLinkedGbps(-1308276092)
            .addAllStoreStates(new ArrayList<LfpMerchantState.LfpStoreState>())
            .setInventoryStats(LfpMerchantState.InventoryStats.newBuilder().build())
            .addAllCountrySettings(new ArrayList<LfpMerchantState.CountrySettings>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-7096/lfpMerchantStates/lfpMerchantState-7096";

    LfpMerchantState actualResponse = client.getLfpMerchantState(name);
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
  public void getLfpMerchantStateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-7096/lfpMerchantStates/lfpMerchantState-7096";
      client.getLfpMerchantState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
