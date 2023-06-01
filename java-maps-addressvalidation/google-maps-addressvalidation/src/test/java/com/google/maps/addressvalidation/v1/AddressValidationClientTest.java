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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.type.PostalAddress;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AddressValidationClientTest {
  private static MockAddressValidation mockAddressValidation;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AddressValidationClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAddressValidation = new MockAddressValidation();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockAddressValidation));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    AddressValidationSettings settings =
        AddressValidationSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AddressValidationClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void validateAddressTest() throws Exception {
    ValidateAddressResponse expectedResponse =
        ValidateAddressResponse.newBuilder()
            .setResult(ValidationResult.newBuilder().build())
            .setResponseId("responseId-633138884")
            .build();
    mockAddressValidation.addResponse(expectedResponse);

    ValidateAddressRequest request =
        ValidateAddressRequest.newBuilder()
            .setAddress(PostalAddress.newBuilder().build())
            .setPreviousResponseId("previousResponseId468754323")
            .setEnableUspsCass(true)
            .build();

    ValidateAddressResponse actualResponse = client.validateAddress(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAddressValidation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ValidateAddressRequest actualRequest = ((ValidateAddressRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAddress(), actualRequest.getAddress());
    Assert.assertEquals(request.getPreviousResponseId(), actualRequest.getPreviousResponseId());
    Assert.assertEquals(request.getEnableUspsCass(), actualRequest.getEnableUspsCass());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateAddressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAddressValidation.addException(exception);

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
    mockAddressValidation.addResponse(expectedResponse);

    ProvideValidationFeedbackRequest request =
        ProvideValidationFeedbackRequest.newBuilder().setResponseId("responseId-633138884").build();

    ProvideValidationFeedbackResponse actualResponse = client.provideValidationFeedback(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAddressValidation.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProvideValidationFeedbackRequest actualRequest =
        ((ProvideValidationFeedbackRequest) actualRequests.get(0));

    Assert.assertEquals(request.getConclusion(), actualRequest.getConclusion());
    Assert.assertEquals(request.getResponseId(), actualRequest.getResponseId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void provideValidationFeedbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAddressValidation.addException(exception);

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
