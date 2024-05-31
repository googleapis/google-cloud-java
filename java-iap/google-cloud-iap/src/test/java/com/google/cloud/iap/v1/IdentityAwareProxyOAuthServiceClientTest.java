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

package com.google.cloud.iap.v1;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class IdentityAwareProxyOAuthServiceClientTest {
  private static MockIdentityAwareProxyOAuthService mockIdentityAwareProxyOAuthService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private IdentityAwareProxyOAuthServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockIdentityAwareProxyOAuthService = new MockIdentityAwareProxyOAuthService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockIdentityAwareProxyOAuthService));
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
    IdentityAwareProxyOAuthServiceSettings settings =
        IdentityAwareProxyOAuthServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IdentityAwareProxyOAuthServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listBrandsTest() throws Exception {
    ListBrandsResponse expectedResponse =
        ListBrandsResponse.newBuilder().addAllBrands(new ArrayList<Brand>()).build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    ListBrandsRequest request =
        ListBrandsRequest.newBuilder().setParent("parent-995424086").build();

    ListBrandsResponse actualResponse = client.listBrands(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBrandsRequest actualRequest = ((ListBrandsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBrandsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      ListBrandsRequest request =
          ListBrandsRequest.newBuilder().setParent("parent-995424086").build();
      client.listBrands(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBrandTest() throws Exception {
    Brand expectedResponse =
        Brand.newBuilder()
            .setName("name3373707")
            .setSupportEmail("supportEmail-1568709363")
            .setApplicationTitle("applicationTitle-9699608")
            .setOrgInternalOnly(true)
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    CreateBrandRequest request =
        CreateBrandRequest.newBuilder()
            .setParent("parent-995424086")
            .setBrand(Brand.newBuilder().build())
            .build();

    Brand actualResponse = client.createBrand(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBrandRequest actualRequest = ((CreateBrandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getBrand(), actualRequest.getBrand());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBrandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      CreateBrandRequest request =
          CreateBrandRequest.newBuilder()
              .setParent("parent-995424086")
              .setBrand(Brand.newBuilder().build())
              .build();
      client.createBrand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBrandTest() throws Exception {
    Brand expectedResponse =
        Brand.newBuilder()
            .setName("name3373707")
            .setSupportEmail("supportEmail-1568709363")
            .setApplicationTitle("applicationTitle-9699608")
            .setOrgInternalOnly(true)
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    GetBrandRequest request = GetBrandRequest.newBuilder().setName("name3373707").build();

    Brand actualResponse = client.getBrand(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBrandRequest actualRequest = ((GetBrandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBrandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      GetBrandRequest request = GetBrandRequest.newBuilder().setName("name3373707").build();
      client.getBrand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIdentityAwareProxyClientTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    CreateIdentityAwareProxyClientRequest request =
        CreateIdentityAwareProxyClientRequest.newBuilder()
            .setParent("parent-995424086")
            .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
            .build();

    IdentityAwareProxyClient actualResponse = client.createIdentityAwareProxyClient(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIdentityAwareProxyClientRequest actualRequest =
        ((CreateIdentityAwareProxyClientRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(
        request.getIdentityAwareProxyClient(), actualRequest.getIdentityAwareProxyClient());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIdentityAwareProxyClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      CreateIdentityAwareProxyClientRequest request =
          CreateIdentityAwareProxyClientRequest.newBuilder()
              .setParent("parent-995424086")
              .setIdentityAwareProxyClient(IdentityAwareProxyClient.newBuilder().build())
              .build();
      client.createIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIdentityAwareProxyClientsTest() throws Exception {
    IdentityAwareProxyClient responsesElement = IdentityAwareProxyClient.newBuilder().build();
    ListIdentityAwareProxyClientsResponse expectedResponse =
        ListIdentityAwareProxyClientsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIdentityAwareProxyClients(Arrays.asList(responsesElement))
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    ListIdentityAwareProxyClientsRequest request =
        ListIdentityAwareProxyClientsRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListIdentityAwareProxyClientsPagedResponse pagedListResponse =
        client.listIdentityAwareProxyClients(request);

    List<IdentityAwareProxyClient> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getIdentityAwareProxyClientsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIdentityAwareProxyClientsRequest actualRequest =
        ((ListIdentityAwareProxyClientsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIdentityAwareProxyClientsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      ListIdentityAwareProxyClientsRequest request =
          ListIdentityAwareProxyClientsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listIdentityAwareProxyClients(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIdentityAwareProxyClientTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    GetIdentityAwareProxyClientRequest request =
        GetIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();

    IdentityAwareProxyClient actualResponse = client.getIdentityAwareProxyClient(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIdentityAwareProxyClientRequest actualRequest =
        ((GetIdentityAwareProxyClientRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIdentityAwareProxyClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      GetIdentityAwareProxyClientRequest request =
          GetIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
      client.getIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetIdentityAwareProxyClientSecretTest() throws Exception {
    IdentityAwareProxyClient expectedResponse =
        IdentityAwareProxyClient.newBuilder()
            .setName("name3373707")
            .setSecret("secret-906277200")
            .setDisplayName("displayName1714148973")
            .build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    ResetIdentityAwareProxyClientSecretRequest request =
        ResetIdentityAwareProxyClientSecretRequest.newBuilder().setName("name3373707").build();

    IdentityAwareProxyClient actualResponse = client.resetIdentityAwareProxyClientSecret(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetIdentityAwareProxyClientSecretRequest actualRequest =
        ((ResetIdentityAwareProxyClientSecretRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetIdentityAwareProxyClientSecretExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      ResetIdentityAwareProxyClientSecretRequest request =
          ResetIdentityAwareProxyClientSecretRequest.newBuilder().setName("name3373707").build();
      client.resetIdentityAwareProxyClientSecret(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIdentityAwareProxyClientTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockIdentityAwareProxyOAuthService.addResponse(expectedResponse);

    DeleteIdentityAwareProxyClientRequest request =
        DeleteIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();

    client.deleteIdentityAwareProxyClient(request);

    List<AbstractMessage> actualRequests = mockIdentityAwareProxyOAuthService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIdentityAwareProxyClientRequest actualRequest =
        ((DeleteIdentityAwareProxyClientRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIdentityAwareProxyClientExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIdentityAwareProxyOAuthService.addException(exception);

    try {
      DeleteIdentityAwareProxyClientRequest request =
          DeleteIdentityAwareProxyClientRequest.newBuilder().setName("name3373707").build();
      client.deleteIdentityAwareProxyClient(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
