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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
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
public class TermsOfServiceAgreementStateServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTermsOfServiceAgreementStateService mockTermsOfServiceAgreementStateService;
  private LocalChannelProvider channelProvider;
  private TermsOfServiceAgreementStateServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTermsOfServiceAgreementStateService = new MockTermsOfServiceAgreementStateService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTermsOfServiceAgreementStateService));
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
    TermsOfServiceAgreementStateServiceSettings settings =
        TermsOfServiceAgreementStateServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TermsOfServiceAgreementStateServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getTermsOfServiceAgreementStateTest() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockTermsOfServiceAgreementStateService.addResponse(expectedResponse);

    TermsOfServiceAgreementStateName name =
        TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");

    TermsOfServiceAgreementState actualResponse = client.getTermsOfServiceAgreementState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceAgreementStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTermsOfServiceAgreementStateRequest actualRequest =
        ((GetTermsOfServiceAgreementStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTermsOfServiceAgreementStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceAgreementStateService.addException(exception);

    try {
      TermsOfServiceAgreementStateName name =
          TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]");
      client.getTermsOfServiceAgreementState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTermsOfServiceAgreementStateTest2() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockTermsOfServiceAgreementStateService.addResponse(expectedResponse);

    String name = "name3373707";

    TermsOfServiceAgreementState actualResponse = client.getTermsOfServiceAgreementState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceAgreementStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTermsOfServiceAgreementStateRequest actualRequest =
        ((GetTermsOfServiceAgreementStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTermsOfServiceAgreementStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceAgreementStateService.addException(exception);

    try {
      String name = "name3373707";
      client.getTermsOfServiceAgreementState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateTest() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockTermsOfServiceAgreementStateService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    TermsOfServiceAgreementState actualResponse =
        client.retrieveForApplicationTermsOfServiceAgreementState(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceAgreementStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveForApplicationTermsOfServiceAgreementStateRequest actualRequest =
        ((RetrieveForApplicationTermsOfServiceAgreementStateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceAgreementStateService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.retrieveForApplicationTermsOfServiceAgreementState(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateTest2() throws Exception {
    TermsOfServiceAgreementState expectedResponse =
        TermsOfServiceAgreementState.newBuilder()
            .setName(TermsOfServiceAgreementStateName.of("[ACCOUNT]", "[IDENTIFIER]").toString())
            .setRegionCode("regionCode-1991004415")
            .setTermsOfServiceKind(TermsOfServiceKind.forNumber(0))
            .setAccepted(Accepted.newBuilder().build())
            .setRequired(Required.newBuilder().build())
            .build();
    mockTermsOfServiceAgreementStateService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    TermsOfServiceAgreementState actualResponse =
        client.retrieveForApplicationTermsOfServiceAgreementState(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceAgreementStateService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveForApplicationTermsOfServiceAgreementStateRequest actualRequest =
        ((RetrieveForApplicationTermsOfServiceAgreementStateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveForApplicationTermsOfServiceAgreementStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceAgreementStateService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.retrieveForApplicationTermsOfServiceAgreementState(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
