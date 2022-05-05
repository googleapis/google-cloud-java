/*
 * Copyright 2022 Google LLC
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

package com.google.devtools.cloudprofiler.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ProfilerServiceClientTest {
  private static MockProfilerService mockProfilerService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProfilerServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProfilerService = new MockProfilerService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProfilerService));
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
    ProfilerServiceSettings settings =
        ProfilerServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProfilerServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName("name3373707")
            .setProfileType(ProfileType.forNumber(0))
            .setDeployment(Deployment.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setProfileBytes(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockProfilerService.addResponse(expectedResponse);

    CreateProfileRequest request =
        CreateProfileRequest.newBuilder()
            .setParent("parent-995424086")
            .setDeployment(Deployment.newBuilder().build())
            .addAllProfileType(new ArrayList<ProfileType>())
            .build();

    Profile actualResponse = client.createProfile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfilerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProfileRequest actualRequest = ((CreateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDeployment(), actualRequest.getDeployment());
    Assert.assertEquals(request.getProfileTypeList(), actualRequest.getProfileTypeList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfilerService.addException(exception);

    try {
      CreateProfileRequest request =
          CreateProfileRequest.newBuilder()
              .setParent("parent-995424086")
              .setDeployment(Deployment.newBuilder().build())
              .addAllProfileType(new ArrayList<ProfileType>())
              .build();
      client.createProfile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createOfflineProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName("name3373707")
            .setProfileType(ProfileType.forNumber(0))
            .setDeployment(Deployment.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setProfileBytes(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockProfilerService.addResponse(expectedResponse);

    CreateOfflineProfileRequest request =
        CreateOfflineProfileRequest.newBuilder()
            .setParent("parent-995424086")
            .setProfile(Profile.newBuilder().build())
            .build();

    Profile actualResponse = client.createOfflineProfile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfilerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateOfflineProfileRequest actualRequest =
        ((CreateOfflineProfileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getProfile(), actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createOfflineProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfilerService.addException(exception);

    try {
      CreateOfflineProfileRequest request =
          CreateOfflineProfileRequest.newBuilder()
              .setParent("parent-995424086")
              .setProfile(Profile.newBuilder().build())
              .build();
      client.createOfflineProfile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName("name3373707")
            .setProfileType(ProfileType.forNumber(0))
            .setDeployment(Deployment.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setProfileBytes(ByteString.EMPTY)
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockProfilerService.addResponse(expectedResponse);

    UpdateProfileRequest request =
        UpdateProfileRequest.newBuilder()
            .setProfile(Profile.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Profile actualResponse = client.updateProfile(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfilerService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProfileRequest actualRequest = ((UpdateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProfile(), actualRequest.getProfile());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfilerService.addException(exception);

    try {
      UpdateProfileRequest request =
          UpdateProfileRequest.newBuilder()
              .setProfile(Profile.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateProfile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
