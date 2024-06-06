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
import com.google.protobuf.FieldMask;
import com.google.type.PhoneNumber;
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
public class BusinessInfoServiceClientTest {
  private static MockBusinessInfoService mockBusinessInfoService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BusinessInfoServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBusinessInfoService = new MockBusinessInfoService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBusinessInfoService));
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
    BusinessInfoServiceSettings settings =
        BusinessInfoServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BusinessInfoServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getBusinessInfoTest() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockBusinessInfoService.addResponse(expectedResponse);

    BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");

    BusinessInfo actualResponse = client.getBusinessInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessInfoService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBusinessInfoRequest actualRequest = ((GetBusinessInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBusinessInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessInfoService.addException(exception);

    try {
      BusinessInfoName name = BusinessInfoName.of("[ACCOUNT]");
      client.getBusinessInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBusinessInfoTest2() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockBusinessInfoService.addResponse(expectedResponse);

    String name = "name3373707";

    BusinessInfo actualResponse = client.getBusinessInfo(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessInfoService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBusinessInfoRequest actualRequest = ((GetBusinessInfoRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBusinessInfoExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessInfoService.addException(exception);

    try {
      String name = "name3373707";
      client.getBusinessInfo(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBusinessInfoTest() throws Exception {
    BusinessInfo expectedResponse =
        BusinessInfo.newBuilder()
            .setName(BusinessInfoName.of("[ACCOUNT]").toString())
            .setAddress(PostalAddress.newBuilder().build())
            .setPhone(PhoneNumber.newBuilder().build())
            .setPhoneVerificationState(PhoneVerificationState.forNumber(0))
            .setCustomerService(CustomerService.newBuilder().build())
            .build();
    mockBusinessInfoService.addResponse(expectedResponse);

    BusinessInfo businessInfo = BusinessInfo.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BusinessInfo actualResponse = client.updateBusinessInfo(businessInfo, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessInfoService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBusinessInfoRequest actualRequest = ((UpdateBusinessInfoRequest) actualRequests.get(0));

    Assert.assertEquals(businessInfo, actualRequest.getBusinessInfo());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBusinessInfoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessInfoService.addException(exception);

    try {
      BusinessInfo businessInfo = BusinessInfo.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBusinessInfo(businessInfo, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
