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

package com.google.cloud.discoveryengine.v1;

import static com.google.cloud.discoveryengine.v1.UserLicenseServiceClient.ListUserLicensesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class UserLicenseServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockUserLicenseService mockUserLicenseService;
  private LocalChannelProvider channelProvider;
  private UserLicenseServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockUserLicenseService = new MockUserLicenseService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockUserLicenseService, mockLocations));
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
    UserLicenseServiceSettings settings =
        UserLicenseServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = UserLicenseServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listUserLicensesTest() throws Exception {
    UserLicense responsesElement = UserLicense.newBuilder().build();
    ListUserLicensesResponse expectedResponse =
        ListUserLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserLicenseService.addResponse(expectedResponse);

    UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");

    ListUserLicensesPagedResponse pagedListResponse = client.listUserLicenses(parent);

    List<UserLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLicensesRequest actualRequest = ((ListUserLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserLicensesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserLicenseService.addException(exception);

    try {
      UserStoreName parent = UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]");
      client.listUserLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listUserLicensesTest2() throws Exception {
    UserLicense responsesElement = UserLicense.newBuilder().build();
    ListUserLicensesResponse expectedResponse =
        ListUserLicensesResponse.newBuilder()
            .setNextPageToken("")
            .addAllUserLicenses(Arrays.asList(responsesElement))
            .build();
    mockUserLicenseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListUserLicensesPagedResponse pagedListResponse = client.listUserLicenses(parent);

    List<UserLicense> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getUserLicensesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockUserLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListUserLicensesRequest actualRequest = ((ListUserLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listUserLicensesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserLicenseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listUserLicenses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateUserLicensesTest() throws Exception {
    BatchUpdateUserLicensesResponse expectedResponse =
        BatchUpdateUserLicensesResponse.newBuilder()
            .addAllUserLicenses(new ArrayList<UserLicense>())
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateUserLicensesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockUserLicenseService.addResponse(resultOperation);

    BatchUpdateUserLicensesRequest request =
        BatchUpdateUserLicensesRequest.newBuilder()
            .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
            .setDeleteUnassignedUserLicenses(true)
            .build();

    BatchUpdateUserLicensesResponse actualResponse =
        client.batchUpdateUserLicensesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockUserLicenseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchUpdateUserLicensesRequest actualRequest =
        ((BatchUpdateUserLicensesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(
        request.getDeleteUnassignedUserLicenses(), actualRequest.getDeleteUnassignedUserLicenses());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchUpdateUserLicensesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockUserLicenseService.addException(exception);

    try {
      BatchUpdateUserLicensesRequest request =
          BatchUpdateUserLicensesRequest.newBuilder()
              .setParent(UserStoreName.of("[PROJECT]", "[LOCATION]", "[USER_STORE]").toString())
              .setDeleteUnassignedUserLicenses(true)
              .build();
      client.batchUpdateUserLicensesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
