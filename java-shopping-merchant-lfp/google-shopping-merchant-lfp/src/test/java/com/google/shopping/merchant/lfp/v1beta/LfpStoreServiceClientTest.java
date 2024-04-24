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

package com.google.shopping.merchant.lfp.v1beta;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

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
public class LfpStoreServiceClientTest {
  private static MockLfpStoreService mockLfpStoreService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LfpStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLfpStoreService = new MockLfpStoreService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLfpStoreService));
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
    LfpStoreServiceSettings settings =
        LfpStoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LfpStoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getLfpStoreTest() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");

    LfpStore actualResponse = client.getLfpStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLfpStoreRequest actualRequest = ((GetLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLfpStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
      client.getLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLfpStoreTest2() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    LfpStore actualResponse = client.getLfpStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLfpStoreRequest actualRequest = ((GetLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLfpStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertLfpStoreTest() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");
    LfpStore lfpStore = LfpStore.newBuilder().build();

    LfpStore actualResponse = client.insertLfpStore(parent, lfpStore);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertLfpStoreRequest actualRequest = ((InsertLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lfpStore, actualRequest.getLfpStore());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertLfpStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      LfpStore lfpStore = LfpStore.newBuilder().build();
      client.insertLfpStore(parent, lfpStore);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertLfpStoreTest2() throws Exception {
    LfpStore expectedResponse =
        LfpStore.newBuilder()
            .setName(LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]").toString())
            .setTargetAccount(-475823745)
            .setStoreCode("storeCode1691468398")
            .setStoreAddress("storeAddress-110711853")
            .setStoreName("storeName1691782924")
            .setPhoneNumber("phoneNumber-1192969641")
            .setWebsiteUri("websiteUri1317135057")
            .addAllGcidCategory(new ArrayList<String>())
            .setPlaceId("placeId-494224254")
            .setMatchingStateHint("matchingStateHint751503163")
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LfpStore lfpStore = LfpStore.newBuilder().build();

    LfpStore actualResponse = client.insertLfpStore(parent, lfpStore);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InsertLfpStoreRequest actualRequest = ((InsertLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lfpStore, actualRequest.getLfpStore());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void insertLfpStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      LfpStore lfpStore = LfpStore.newBuilder().build();
      client.insertLfpStore(parent, lfpStore);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLfpStoreTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLfpStoreService.addResponse(expectedResponse);

    LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");

    client.deleteLfpStore(name);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLfpStoreRequest actualRequest = ((DeleteLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLfpStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
      client.deleteLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteLfpStoreTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLfpStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteLfpStore(name);

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLfpStoreRequest actualRequest = ((DeleteLfpStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLfpStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLfpStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLfpStoresTest() throws Exception {
    LfpStore responsesElement = LfpStore.newBuilder().build();
    ListLfpStoresResponse expectedResponse =
        ListLfpStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpStores(Arrays.asList(responsesElement))
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListLfpStoresPagedResponse pagedListResponse = client.listLfpStores(parent);

    List<LfpStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLfpStoresRequest actualRequest = ((ListLfpStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLfpStoresExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listLfpStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLfpStoresTest2() throws Exception {
    LfpStore responsesElement = LfpStore.newBuilder().build();
    ListLfpStoresResponse expectedResponse =
        ListLfpStoresResponse.newBuilder()
            .setNextPageToken("")
            .addAllLfpStores(Arrays.asList(responsesElement))
            .build();
    mockLfpStoreService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLfpStoresPagedResponse pagedListResponse = client.listLfpStores(parent);

    List<LfpStore> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLfpStoresList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLfpStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLfpStoresRequest actualRequest = ((ListLfpStoresRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLfpStoresExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLfpStoreService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLfpStores(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
