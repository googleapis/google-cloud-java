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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.devtools.cloudprofiler.v2.stub.HttpJsonProfilerServiceStub;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ProfilerServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ProfilerServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonProfilerServiceStub.getMethodDescriptors(),
            ProfilerServiceSettings.getDefaultEndpoint());
    ProfilerServiceSettings settings =
        ProfilerServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ProfilerServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProfilerServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    CreateProfileRequest request =
        CreateProfileRequest.newBuilder()
            .setParent("projects/project-2353")
            .setDeployment(Deployment.newBuilder().build())
            .addAllProfileType(new ArrayList<ProfileType>())
            .build();

    Profile actualResponse = client.createProfile(request);
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
  public void createProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateProfileRequest request =
          CreateProfileRequest.newBuilder()
              .setParent("projects/project-2353")
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
    mockService.addResponse(expectedResponse);

    CreateOfflineProfileRequest request =
        CreateOfflineProfileRequest.newBuilder()
            .setParent("projects/project-2353")
            .setProfile(Profile.newBuilder().build())
            .build();

    Profile actualResponse = client.createOfflineProfile(request);
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
  public void createOfflineProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CreateOfflineProfileRequest request =
          CreateOfflineProfileRequest.newBuilder()
              .setParent("projects/project-2353")
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
    mockService.addResponse(expectedResponse);

    UpdateProfileRequest request =
        UpdateProfileRequest.newBuilder()
            .setProfile(
                Profile.newBuilder()
                    .setName("projects/project-4284/profiles/profile-4284")
                    .setProfileType(ProfileType.forNumber(0))
                    .setDeployment(Deployment.newBuilder().build())
                    .setDuration(Duration.newBuilder().build())
                    .setProfileBytes(ByteString.EMPTY)
                    .putAllLabels(new HashMap<String, String>())
                    .build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Profile actualResponse = client.updateProfile(request);
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
  public void updateProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UpdateProfileRequest request =
          UpdateProfileRequest.newBuilder()
              .setProfile(
                  Profile.newBuilder()
                      .setName("projects/project-4284/profiles/profile-4284")
                      .setProfileType(ProfileType.forNumber(0))
                      .setDeployment(Deployment.newBuilder().build())
                      .setDuration(Duration.newBuilder().build())
                      .setProfileBytes(ByteString.EMPTY)
                      .putAllLabels(new HashMap<String, String>())
                      .build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateProfile(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
