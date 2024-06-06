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
public class BusinessIdentityServiceClientTest {
  private static MockBusinessIdentityService mockBusinessIdentityService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BusinessIdentityServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBusinessIdentityService = new MockBusinessIdentityService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBusinessIdentityService));
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
    BusinessIdentityServiceSettings settings =
        BusinessIdentityServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BusinessIdentityServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getBusinessIdentityTest() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockBusinessIdentityService.addResponse(expectedResponse);

    BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");

    BusinessIdentity actualResponse = client.getBusinessIdentity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessIdentityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBusinessIdentityRequest actualRequest = ((GetBusinessIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBusinessIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessIdentityService.addException(exception);

    try {
      BusinessIdentityName name = BusinessIdentityName.of("[ACCOUNT]");
      client.getBusinessIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBusinessIdentityTest2() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockBusinessIdentityService.addResponse(expectedResponse);

    String name = "name3373707";

    BusinessIdentity actualResponse = client.getBusinessIdentity(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessIdentityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBusinessIdentityRequest actualRequest = ((GetBusinessIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBusinessIdentityExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessIdentityService.addException(exception);

    try {
      String name = "name3373707";
      client.getBusinessIdentity(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBusinessIdentityTest() throws Exception {
    BusinessIdentity expectedResponse =
        BusinessIdentity.newBuilder()
            .setName(BusinessIdentityName.of("[ACCOUNT]").toString())
            .setBlackOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setWomenOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setVeteranOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setLatinoOwned(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .setSmallBusiness(BusinessIdentity.IdentityAttribute.newBuilder().build())
            .build();
    mockBusinessIdentityService.addResponse(expectedResponse);

    BusinessIdentity businessIdentity = BusinessIdentity.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BusinessIdentity actualResponse = client.updateBusinessIdentity(businessIdentity, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBusinessIdentityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBusinessIdentityRequest actualRequest =
        ((UpdateBusinessIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(businessIdentity, actualRequest.getBusinessIdentity());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBusinessIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBusinessIdentityService.addException(exception);

    try {
      BusinessIdentity businessIdentity = BusinessIdentity.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBusinessIdentity(businessIdentity, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
