/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;

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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class ProfileServiceClientTest {
  private static MockApplicationService mockApplicationService;
  private static MockCompanyService mockCompanyService;
  private static MockCompletion mockCompletion;
  private static MockEventService mockEventService;
  private static MockJobService mockJobService;
  private static MockProfileService mockProfileService;
  private static MockTenantService mockTenantService;
  private static MockServiceHelper serviceHelper;
  private ProfileServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockApplicationService = new MockApplicationService();
    mockCompanyService = new MockCompanyService();
    mockCompletion = new MockCompletion();
    mockEventService = new MockEventService();
    mockJobService = new MockJobService();
    mockProfileService = new MockProfileService();
    mockTenantService = new MockTenantService();
    serviceHelper =
        new MockServiceHelper(
            "in-process-1",
            Arrays.<MockGrpcService>asList(
                mockApplicationService,
                mockCompanyService,
                mockCompletion,
                mockEventService,
                mockJobService,
                mockProfileService,
                mockTenantService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    ProfileServiceSettings settings =
        ProfileServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProfileServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listProfilesTest() {
    String nextPageToken = "";
    Profile profilesElement = Profile.newBuilder().build();
    List<Profile> profiles = Arrays.asList(profilesElement);
    ListProfilesResponse expectedResponse =
        ListProfilesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllProfiles(profiles)
            .build();
    mockProfileService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");

    ListProfilesPagedResponse pagedListResponse = client.listProfiles(parent);

    List<Profile> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProfilesRequest actualRequest = (ListProfilesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");

      client.listProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createProfileTest() {
    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
    String externalId = "externalId-1153075697";
    String source = "source-896505829";
    String uri = "uri116076";
    String groupId = "groupId506361563";
    boolean processed = true;
    String keywordSnippet = "keywordSnippet1325317319";
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(name.toString())
            .setExternalId(externalId)
            .setSource(source)
            .setUri(uri)
            .setGroupId(groupId)
            .setProcessed(processed)
            .setKeywordSnippet(keywordSnippet)
            .build();
    mockProfileService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Profile profile = Profile.newBuilder().build();

    Profile actualResponse = client.createProfile(parent, profile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProfileRequest actualRequest = (CreateProfileRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TenantName.parse(actualRequest.getParent()));
    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Profile profile = Profile.newBuilder().build();

      client.createProfile(parent, profile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getProfileTest() {
    ProfileName name2 = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
    String externalId = "externalId-1153075697";
    String source = "source-896505829";
    String uri = "uri116076";
    String groupId = "groupId506361563";
    boolean processed = true;
    String keywordSnippet = "keywordSnippet1325317319";
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(name2.toString())
            .setExternalId(externalId)
            .setSource(source)
            .setUri(uri)
            .setGroupId(groupId)
            .setProcessed(processed)
            .setKeywordSnippet(keywordSnippet)
            .build();
    mockProfileService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    Profile actualResponse = client.getProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProfileRequest actualRequest = (GetProfileRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProfileName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

      client.getProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateProfileTest() {
    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
    String externalId = "externalId-1153075697";
    String source = "source-896505829";
    String uri = "uri116076";
    String groupId = "groupId506361563";
    boolean processed = true;
    String keywordSnippet = "keywordSnippet1325317319";
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(name.toString())
            .setExternalId(externalId)
            .setSource(source)
            .setUri(uri)
            .setGroupId(groupId)
            .setProcessed(processed)
            .setKeywordSnippet(keywordSnippet)
            .build();
    mockProfileService.addResponse(expectedResponse);

    Profile profile = Profile.newBuilder().build();

    Profile actualResponse = client.updateProfile(profile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProfileRequest actualRequest = (UpdateProfileRequest) actualRequests.get(0);

    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      Profile profile = Profile.newBuilder().build();

      client.updateProfile(profile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProfileTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProfileService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    client.deleteProfile(name);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProfileRequest actualRequest = (DeleteProfileRequest) actualRequests.get(0);

    Assert.assertEquals(name, ProfileName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

      client.deleteProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
