/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.PrivateAuctionServiceClient.ListPrivateAuctionsPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonPrivateAuctionServiceStub;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class PrivateAuctionServiceClientTest {
  private static MockHttpService mockService;
  private static PrivateAuctionServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPrivateAuctionServiceStub.getMethodDescriptors(),
            PrivateAuctionServiceSettings.getDefaultEndpoint());
    PrivateAuctionServiceSettings settings =
        PrivateAuctionServiceSettings.newBuilder()
            .setTransportChannelProvider(
                PrivateAuctionServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PrivateAuctionServiceClient.create(settings);
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
  public void getPrivateAuctionTest() throws Exception {
    PrivateAuction expectedResponse =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateAuctionName name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]");

    PrivateAuction actualResponse = client.getPrivateAuction(name);
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
  public void getPrivateAuctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateAuctionName name = PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]");
      client.getPrivateAuction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPrivateAuctionTest2() throws Exception {
    PrivateAuction expectedResponse =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-4294/privateAuctions/privateAuction-4294";

    PrivateAuction actualResponse = client.getPrivateAuction(name);
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
  public void getPrivateAuctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-4294/privateAuctions/privateAuction-4294";
      client.getPrivateAuction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateAuctionsTest() throws Exception {
    PrivateAuction responsesElement = PrivateAuction.newBuilder().build();
    ListPrivateAuctionsResponse expectedResponse =
        ListPrivateAuctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateAuctions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListPrivateAuctionsPagedResponse pagedListResponse = client.listPrivateAuctions(parent);

    List<PrivateAuction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateAuctionsList().get(0), resources.get(0));

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
  public void listPrivateAuctionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listPrivateAuctions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPrivateAuctionsTest2() throws Exception {
    PrivateAuction responsesElement = PrivateAuction.newBuilder().build();
    ListPrivateAuctionsResponse expectedResponse =
        ListPrivateAuctionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrivateAuctions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListPrivateAuctionsPagedResponse pagedListResponse = client.listPrivateAuctions(parent);

    List<PrivateAuction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPrivateAuctionsList().get(0), resources.get(0));

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
  public void listPrivateAuctionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listPrivateAuctions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateAuctionTest() throws Exception {
    PrivateAuction expectedResponse =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    PrivateAuction privateAuction = PrivateAuction.newBuilder().build();

    PrivateAuction actualResponse = client.createPrivateAuction(parent, privateAuction);
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
  public void createPrivateAuctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      PrivateAuction privateAuction = PrivateAuction.newBuilder().build();
      client.createPrivateAuction(parent, privateAuction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPrivateAuctionTest2() throws Exception {
    PrivateAuction expectedResponse =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    PrivateAuction privateAuction = PrivateAuction.newBuilder().build();

    PrivateAuction actualResponse = client.createPrivateAuction(parent, privateAuction);
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
  public void createPrivateAuctionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      PrivateAuction privateAuction = PrivateAuction.newBuilder().build();
      client.createPrivateAuction(parent, privateAuction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePrivateAuctionTest() throws Exception {
    PrivateAuction expectedResponse =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PrivateAuction privateAuction =
        PrivateAuction.newBuilder()
            .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
            .setPrivateAuctionId(-20317997)
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllSellerContactUsers(new ArrayList<String>())
            .setArchived(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PrivateAuction actualResponse = client.updatePrivateAuction(privateAuction, updateMask);
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
  public void updatePrivateAuctionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PrivateAuction privateAuction =
          PrivateAuction.newBuilder()
              .setName(PrivateAuctionName.of("[NETWORK_CODE]", "[PRIVATE_AUCTION]").toString())
              .setPrivateAuctionId(-20317997)
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .addAllSellerContactUsers(new ArrayList<String>())
              .setArchived(true)
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePrivateAuction(privateAuction, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
