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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.HttpJsonCheckoutSettingsServiceStub;
import com.google.shopping.type.Destination;
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
public class CheckoutSettingsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CheckoutSettingsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCheckoutSettingsServiceStub.getMethodDescriptors(),
            CheckoutSettingsServiceSettings.getDefaultEndpoint());
    CheckoutSettingsServiceSettings settings =
        CheckoutSettingsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CheckoutSettingsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CheckoutSettingsServiceClient.create(settings);
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
  public void getCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");

    CheckoutSettings actualResponse = client.getCheckoutSettings(name);
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
  public void getCheckoutSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
      client.getCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCheckoutSettingsTest2() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4747/programs/program-4747/checkoutSettings";

    CheckoutSettings actualResponse = client.getCheckoutSettings(name);
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
  public void getCheckoutSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4747/programs/program-4747/checkoutSettings";
      client.getCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ProgramName parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
    CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();

    CheckoutSettings actualResponse = client.createCheckoutSettings(parent, checkoutSettings);
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
  public void createCheckoutSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProgramName parent = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
      client.createCheckoutSettings(parent, checkoutSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCheckoutSettingsTest2() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "accounts/account-7358/programs/program-7358";
    CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();

    CheckoutSettings actualResponse = client.createCheckoutSettings(parent, checkoutSettings);
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
  public void createCheckoutSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "accounts/account-7358/programs/program-7358";
      CheckoutSettings checkoutSettings = CheckoutSettings.newBuilder().build();
      client.createCheckoutSettings(parent, checkoutSettings);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCheckoutSettingsTest() throws Exception {
    CheckoutSettings expectedResponse =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CheckoutSettings checkoutSettings =
        CheckoutSettings.newBuilder()
            .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setUriSettings(UriSettings.newBuilder().build())
            .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
            .setEffectiveUriSettings(UriSettings.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CheckoutSettings actualResponse = client.updateCheckoutSettings(checkoutSettings, updateMask);
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
  public void updateCheckoutSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckoutSettings checkoutSettings =
          CheckoutSettings.newBuilder()
              .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
              .setUriSettings(UriSettings.newBuilder().build())
              .addAllEligibleDestinations(new ArrayList<Destination.DestinationEnum>())
              .setEffectiveUriSettings(UriSettings.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCheckoutSettings(checkoutSettings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCheckoutSettingsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");

    client.deleteCheckoutSettings(name);

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
  public void deleteCheckoutSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CheckoutSettingsName name = CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]");
      client.deleteCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCheckoutSettingsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-4747/programs/program-4747/checkoutSettings";

    client.deleteCheckoutSettings(name);

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
  public void deleteCheckoutSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-4747/programs/program-4747/checkoutSettings";
      client.deleteCheckoutSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
