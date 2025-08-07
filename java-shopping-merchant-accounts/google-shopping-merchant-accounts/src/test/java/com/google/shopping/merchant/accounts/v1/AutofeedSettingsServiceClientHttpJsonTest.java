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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1.stub.HttpJsonAutofeedSettingsServiceStub;
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
public class AutofeedSettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AutofeedSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAutofeedSettingsServiceStub.getMethodDescriptors(),
            AutofeedSettingsServiceSettings.getDefaultEndpoint());
    AutofeedSettingsServiceSettings settings =
        AutofeedSettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AutofeedSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AutofeedSettingsServiceClient.create(settings);
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
  public void getAutofeedSettingsTest() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");

    AutofeedSettings actualResponse = client.getAutofeedSettings(name);
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
  public void getAutofeedSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutofeedSettingsName name = AutofeedSettingsName.of("[ACCOUNT]");
      client.getAutofeedSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAutofeedSettingsTest2() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-3997/autofeedSettings";

    AutofeedSettings actualResponse = client.getAutofeedSettings(name);
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
  public void getAutofeedSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-3997/autofeedSettings";
      client.getAutofeedSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAutofeedSettingsTest() throws Exception {
    AutofeedSettings expectedResponse =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    AutofeedSettings autofeedSettings =
        AutofeedSettings.newBuilder()
            .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
            .setEnableProducts(true)
            .setEligible(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AutofeedSettings actualResponse = client.updateAutofeedSettings(autofeedSettings, updateMask);
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
  public void updateAutofeedSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AutofeedSettings autofeedSettings =
          AutofeedSettings.newBuilder()
              .setName(AutofeedSettingsName.of("[ACCOUNT]").toString())
              .setEnableProducts(true)
              .setEligible(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAutofeedSettings(autofeedSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
