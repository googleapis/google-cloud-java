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
public class HomepageServiceClientTest {
  private static MockHomepageService mockHomepageService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private HomepageServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockHomepageService = new MockHomepageService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockHomepageService));
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
    HomepageServiceSettings settings =
        HomepageServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = HomepageServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockHomepageService.addResponse(expectedResponse);

    HomepageName name = HomepageName.of("[ACCOUNT]");

    Homepage actualResponse = client.getHomepage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHomepageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHomepageRequest actualRequest = ((GetHomepageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHomepageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHomepageService.addException(exception);

    try {
      HomepageName name = HomepageName.of("[ACCOUNT]");
      client.getHomepage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getHomepageTest2() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockHomepageService.addResponse(expectedResponse);

    String name = "name3373707";

    Homepage actualResponse = client.getHomepage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHomepageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetHomepageRequest actualRequest = ((GetHomepageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getHomepageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHomepageService.addException(exception);

    try {
      String name = "name3373707";
      client.getHomepage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockHomepageService.addResponse(expectedResponse);

    Homepage homepage = Homepage.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Homepage actualResponse = client.updateHomepage(homepage, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHomepageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateHomepageRequest actualRequest = ((UpdateHomepageRequest) actualRequests.get(0));

    Assert.assertEquals(homepage, actualRequest.getHomepage());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateHomepageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHomepageService.addException(exception);

    try {
      Homepage homepage = Homepage.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateHomepage(homepage, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void claimHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockHomepageService.addResponse(expectedResponse);

    ClaimHomepageRequest request =
        ClaimHomepageRequest.newBuilder().setName(HomepageName.of("[ACCOUNT]").toString()).build();

    Homepage actualResponse = client.claimHomepage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHomepageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClaimHomepageRequest actualRequest = ((ClaimHomepageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void claimHomepageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHomepageService.addException(exception);

    try {
      ClaimHomepageRequest request =
          ClaimHomepageRequest.newBuilder()
              .setName(HomepageName.of("[ACCOUNT]").toString())
              .build();
      client.claimHomepage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unclaimHomepageTest() throws Exception {
    Homepage expectedResponse =
        Homepage.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .setUri("uri116076")
            .setClaimed(true)
            .build();
    mockHomepageService.addResponse(expectedResponse);

    UnclaimHomepageRequest request =
        UnclaimHomepageRequest.newBuilder()
            .setName(HomepageName.of("[ACCOUNT]").toString())
            .build();

    Homepage actualResponse = client.unclaimHomepage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockHomepageService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnclaimHomepageRequest actualRequest = ((UnclaimHomepageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unclaimHomepageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockHomepageService.addException(exception);

    try {
      UnclaimHomepageRequest request =
          UnclaimHomepageRequest.newBuilder()
              .setName(HomepageName.of("[ACCOUNT]").toString())
              .build();
      client.unclaimHomepage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
