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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import io.grafeas.v1.AttestationOccurrence;
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
public class ValidationHelperV1ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockValidationHelperV1 mockValidationHelperV1;
  private LocalChannelProvider channelProvider;
  private ValidationHelperV1Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockValidationHelperV1 = new MockValidationHelperV1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockValidationHelperV1));
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
    ValidationHelperV1Settings settings =
        ValidationHelperV1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ValidationHelperV1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void validateAttestationOccurrenceTest() throws Exception {
    Service.ValidateAttestationOccurrenceResponse expectedResponse =
        Service.ValidateAttestationOccurrenceResponse.newBuilder()
            .setDenialReason("denialReason-966999989")
            .build();
    mockValidationHelperV1.addResponse(expectedResponse);

    Service.ValidateAttestationOccurrenceRequest request =
        Service.ValidateAttestationOccurrenceRequest.newBuilder()
            .setAttestor("attestor542920680")
            .setAttestation(AttestationOccurrence.newBuilder().build())
            .setOccurrenceNote("occurrenceNote1722072419")
            .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
            .build();

    Service.ValidateAttestationOccurrenceResponse actualResponse =
        client.validateAttestationOccurrence(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockValidationHelperV1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Service.ValidateAttestationOccurrenceRequest actualRequest =
        ((Service.ValidateAttestationOccurrenceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAttestor(), actualRequest.getAttestor());
    Assert.assertEquals(request.getAttestation(), actualRequest.getAttestation());
    Assert.assertEquals(request.getOccurrenceNote(), actualRequest.getOccurrenceNote());
    Assert.assertEquals(
        request.getOccurrenceResourceUri(), actualRequest.getOccurrenceResourceUri());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void validateAttestationOccurrenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockValidationHelperV1.addException(exception);

    try {
      Service.ValidateAttestationOccurrenceRequest request =
          Service.ValidateAttestationOccurrenceRequest.newBuilder()
              .setAttestor("attestor542920680")
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
