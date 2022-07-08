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

package com.google.protos.google.cloud.binaryauthorization.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.HttpJsonValidationHelperV1Stub;
import io.grafeas.v1.AttestationOccurrence;
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
public class ValidationHelperV1ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ValidationHelperV1Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonValidationHelperV1Stub.getMethodDescriptors(),
            ValidationHelperV1Settings.getDefaultEndpoint());
    ValidationHelperV1Settings settings =
        ValidationHelperV1Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ValidationHelperV1Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ValidationHelperV1Client.create(settings);
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
  public void validateAttestationOccurrenceTest() throws Exception {
    Service.ValidateAttestationOccurrenceResponse expectedResponse =
        Service.ValidateAttestationOccurrenceResponse.newBuilder()
            .setDenialReason("denialReason-966999989")
            .build();
    mockService.addResponse(expectedResponse);

    Service.ValidateAttestationOccurrenceRequest request =
        Service.ValidateAttestationOccurrenceRequest.newBuilder()
            .setAttestor("projects/project-380/attestors/attestor-380")
            .setAttestation(AttestationOccurrence.newBuilder().build())
            .setOccurrenceNote("occurrenceNote1722072419")
            .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
            .build();

    Service.ValidateAttestationOccurrenceResponse actualResponse =
        client.validateAttestationOccurrence(request);
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
  public void validateAttestationOccurrenceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Service.ValidateAttestationOccurrenceRequest request =
          Service.ValidateAttestationOccurrenceRequest.newBuilder()
              .setAttestor("projects/project-380/attestors/attestor-380")
              .setAttestation(AttestationOccurrence.newBuilder().build())
              .setOccurrenceNote("occurrenceNote1722072419")
              .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
              .build();
      client.validateAttestationOccurrence(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
