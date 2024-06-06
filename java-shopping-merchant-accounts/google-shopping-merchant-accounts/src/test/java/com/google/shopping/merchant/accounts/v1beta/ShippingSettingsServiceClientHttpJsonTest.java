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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonShippingSettingsServiceStub;
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
public class ShippingSettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ShippingSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonShippingSettingsServiceStub.getMethodDescriptors(),
            ShippingSettingsServiceSettings.getDefaultEndpoint());
    ShippingSettingsServiceSettings settings =
        ShippingSettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ShippingSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ShippingSettingsServiceClient.create(settings);
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
  public void getShippingSettingsTest() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");

    ShippingSettings actualResponse = client.getShippingSettings(name);
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
  public void getShippingSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShippingSettingsName name = ShippingSettingsName.of("[ACCOUNT]");
      client.getShippingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShippingSettingsTest2() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-1652/shippingSettings";

    ShippingSettings actualResponse = client.getShippingSettings(name);
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
  public void getShippingSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-1652/shippingSettings";
      client.getShippingSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertShippingSettingsTest() throws Exception {
    ShippingSettings expectedResponse =
        ShippingSettings.newBuilder()
            .setName(ShippingSettingsName.of("[ACCOUNT]").toString())
            .addAllServices(new ArrayList<Service>())
            .addAllWarehouses(new ArrayList<Warehouse>())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    InsertShippingSettingsRequest request =
        InsertShippingSettingsRequest.newBuilder()
            .setParent("accounts/account-4811")
            .setShippingSetting(ShippingSettings.newBuilder().build())
            .build();

    ShippingSettings actualResponse = client.insertShippingSettings(request);
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
  public void insertShippingSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertShippingSettingsRequest request =
          InsertShippingSettingsRequest.newBuilder()
              .setParent("accounts/account-4811")
              .setShippingSetting(ShippingSettings.newBuilder().build())
              .build();
      client.insertShippingSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
