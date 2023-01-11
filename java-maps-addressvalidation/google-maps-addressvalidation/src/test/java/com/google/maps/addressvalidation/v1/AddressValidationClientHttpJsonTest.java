/*
 * Copyright 2022 Google LLC
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

package com.google.maps.addressvalidation.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.maps.addressvalidation.v1.stub.HttpJsonAddressValidationStub;
import com.google.type.PostalAddress;
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
public class AddressValidationClientHttpJsonTest {
  private static MockHttpService mockService;
  private static AddressValidationClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonAddressValidationStub.getMethodDescriptors(),
            AddressValidationSettings.getDefaultEndpoint());
    AddressValidationSettings settings =
        AddressValidationSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                AddressValidationSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AddressValidationClient.create(settings);
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
  public void validateAddressTest() throws Exception {
    ValidateAddressResponse expectedResponse =
        ValidateAddressResponse.newBuilder()
            .setResult(ValidationResult.newBuilder().build())
            .setResponseId("responseId-633138884")
            .build();
    mockService.addResponse(expectedResponse);

    ValidateAddressRequest request =
        ValidateAddressRequest.newBuilder()
            .setAddress(PostalAddress.newBuilder().build())
            .setPreviousResponseId("previousResponseId468754323")
            .setEnableUspsCass(true)
            .build();

    ValidateAddressResponse actualResponse = client.validateAddress(request);
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
  public void validateAddressExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ValidateAddressRequest request =
          ValidateAddressRequest.newBuilder()
              .setAddress(PostalAddress.newBuilder().build())
              .setPreviousResponseId("previousResponseId468754323")
              .setEnableUspsCass(true)
              .build();
      client.validateAddress(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void provideValidationFeedbackTest() throws Exception {
    ProvideValidationFeedbackResponse expectedResponse =
        ProvideValidationFeedbackResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ProvideValidationFeedbackRequest request =
        ProvideValidationFeedbackRequest.newBuilder().setResponseId("responseId-633138884").build();

    ProvideValidationFeedbackResponse actualResponse = client.provideValidationFeedback(request);
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
  public void provideValidationFeedbackExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProvideValidationFeedbackRequest request =
          ProvideValidationFeedbackRequest.newBuilder()
              .setResponseId("responseId-633138884")
              .build();
      client.provideValidationFeedback(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
