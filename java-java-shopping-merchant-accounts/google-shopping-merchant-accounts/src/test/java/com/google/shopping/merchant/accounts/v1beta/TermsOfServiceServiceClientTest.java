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
import com.google.protobuf.Empty;
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
public class TermsOfServiceServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTermsOfServiceService mockTermsOfServiceService;
  private LocalChannelProvider channelProvider;
  private TermsOfServiceServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTermsOfServiceService = new MockTermsOfServiceService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockTermsOfServiceService));
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
    TermsOfServiceServiceSettings settings =
        TermsOfServiceServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TermsOfServiceServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getTermsOfServiceTest() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockTermsOfServiceService.addResponse(expectedResponse);

    TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");

    TermsOfService actualResponse = client.getTermsOfService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTermsOfServiceRequest actualRequest = ((GetTermsOfServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTermsOfServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceService.addException(exception);

    try {
      TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
      client.getTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTermsOfServiceTest2() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockTermsOfServiceService.addResponse(expectedResponse);

    String name = "name3373707";

    TermsOfService actualResponse = client.getTermsOfService(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTermsOfServiceRequest actualRequest = ((GetTermsOfServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTermsOfServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceService.addException(exception);

    try {
      String name = "name3373707";
      client.getTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveLatestTermsOfServiceTest() throws Exception {
    TermsOfService expectedResponse =
        TermsOfService.newBuilder()
            .setName(TermsOfServiceName.of("[VERSION]").toString())
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .setFileUri("fileUri-855009712")
            .setExternal(true)
            .build();
    mockTermsOfServiceService.addResponse(expectedResponse);

    RetrieveLatestTermsOfServiceRequest request =
        RetrieveLatestTermsOfServiceRequest.newBuilder()
            .setRegionCode("regionCode-1991004415")
            .setKind(TermsOfServiceKind.forNumber(0))
            .build();

    TermsOfService actualResponse = client.retrieveLatestTermsOfService(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTermsOfServiceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveLatestTermsOfServiceRequest actualRequest =
        ((RetrieveLatestTermsOfServiceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRegionCode(), actualRequest.getRegionCode());
    Assert.assertEquals(request.getKind(), actualRequest.getKind());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveLatestTermsOfServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceService.addException(exception);

    try {
      RetrieveLatestTermsOfServiceRequest request =
          RetrieveLatestTermsOfServiceRequest.newBuilder()
              .setRegionCode("regionCode-1991004415")
              .setKind(TermsOfServiceKind.forNumber(0))
              .build();
      client.retrieveLatestTermsOfService(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsOfServiceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTermsOfServiceService.addResponse(expectedResponse);

    TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");

    client.acceptTermsOfService(name);

    List<AbstractMessage> actualRequests = mockTermsOfServiceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptTermsOfServiceRequest actualRequest =
        ((AcceptTermsOfServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptTermsOfServiceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceService.addException(exception);

    try {
      TermsOfServiceName name = TermsOfServiceName.of("[VERSION]");
      client.acceptTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void acceptTermsOfServiceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockTermsOfServiceService.addResponse(expectedResponse);

    String name = "name3373707";

    client.acceptTermsOfService(name);

    List<AbstractMessage> actualRequests = mockTermsOfServiceService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcceptTermsOfServiceRequest actualRequest =
        ((AcceptTermsOfServiceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acceptTermsOfServiceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTermsOfServiceService.addException(exception);

    try {
      String name = "name3373707";
      client.acceptTermsOfService(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
