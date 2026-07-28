/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

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
public class UserStoreServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockUserStoreService mockUserStoreService;
  private LocalChannelProvider channelProvider;
  private UserStoreServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserStoreService = new MockUserStoreService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockUserStoreService, mockLocations));
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
    UserStoreServiceSettings settings =
        UserStoreServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserStoreServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getUserStoreTest() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockUserStoreService.addResponse(expectedResponse);

    UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");

    UserStore actualResponse = client.getUserStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserStoreRequest actualRequest = ((GetUserStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserStoreService.addException(exception);

    try {
      UserStoreName name = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
      client.getUserStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getUserStoreTest2() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockUserStoreService.addResponse(expectedResponse);

    String name = "name3373707";

    UserStore actualResponse = client.getUserStore(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetUserStoreRequest actualRequest = ((GetUserStoreRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getUserStoreExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserStoreService.addException(exception);

    try {
      String name = "name3373707";
      client.getUserStore(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateUserStoreTest() throws Exception {
    UserStore expectedResponse =
        UserStore.newBuilder()
            .setName(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDisplayName("displayName1714148973")
            .setDefaultLicenseConfig(
                LicenseConfigName.of("[PROJECT]", "[LOCATION]", "[LICENSE_CONFIG]").toString())
            .setEnableLicenseAutoRegister(true)
            .setEnableExpiredLicenseAutoUpdate(true)
            .build();
    mockUserStoreService.addResponse(expectedResponse);

    UserStore userStore = UserStore.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    UserStore actualResponse = client.updateUserStore(userStore, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserStoreService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateUserStoreRequest actualRequest = ((UpdateUserStoreRequest) actualRequests.get(0));

    Assert.assertEquals(userStore, actualRequest.getUserStore());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateUserStoreExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserStoreService.addException(exception);

    try {
      UserStore userStore = UserStore.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateUserStore(userStore, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
