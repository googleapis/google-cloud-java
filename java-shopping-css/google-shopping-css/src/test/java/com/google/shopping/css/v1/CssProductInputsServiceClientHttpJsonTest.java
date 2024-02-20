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

package com.google.shopping.css.v1;

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
import com.google.protobuf.Timestamp;
import com.google.shopping.css.v1.stub.HttpJsonCssProductInputsServiceStub;
import com.google.shopping.type.CustomAttribute;
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
public class CssProductInputsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CssProductInputsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCssProductInputsServiceStub.getMethodDescriptors(),
            CssProductInputsServiceSettings.getDefaultEndpoint());
    CssProductInputsServiceSettings settings =
        CssProductInputsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CssProductInputsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CssProductInputsServiceClient.create(settings);
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
  public void insertCssProductInputTest() throws Exception {
    CssProductInput expectedResponse =
        CssProductInput.newBuilder()
            .setName(CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]").toString())
            .setFinalName("finalName355075361")
            .setRawProvidedId("rawProvidedId-637295450")
            .setContentLanguage("contentLanguage810066673")
            .setFeedLabel("feedLabel-1661895690")
            .setFreshnessTime(Timestamp.newBuilder().build())
            .setAttributes(Attributes.newBuilder().build())
            .addAllCustomAttributes(new ArrayList<CustomAttribute>())
            .build();
    mockService.addResponse(expectedResponse);

    InsertCssProductInputRequest request =
        InsertCssProductInputRequest.newBuilder()
            .setParent(AccountName.of("[ACCOUNT]").toString())
            .setCssProductInput(CssProductInput.newBuilder().build())
            .setFeedId(-976011428)
            .build();

    CssProductInput actualResponse = client.insertCssProductInput(request);
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
  public void insertCssProductInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InsertCssProductInputRequest request =
          InsertCssProductInputRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setCssProductInput(CssProductInput.newBuilder().build())
              .setFeedId(-976011428)
              .build();
      client.insertCssProductInput(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCssProductInputTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CssProductInputName name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]");

    client.deleteCssProductInput(name);

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
  public void deleteCssProductInputExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CssProductInputName name = CssProductInputName.of("[ACCOUNT]", "[CSS_PRODUCT_INPUT]");
      client.deleteCssProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCssProductInputTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "accounts/account-861/cssProductInputs/cssProductInput-861";

    client.deleteCssProductInput(name);

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
  public void deleteCssProductInputExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "accounts/account-861/cssProductInputs/cssProductInput-861";
      client.deleteCssProductInput(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
