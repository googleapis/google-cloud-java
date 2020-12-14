/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;
import static com.google.cloud.talent.v4beta1.ProfileServiceClient.SearchProfilesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
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
public class ProfileServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockProfileService mockProfileService;
  private ProfileServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockProfileService = new MockProfileService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProfileService));
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
  public void listProfilesTest() throws Exception {
    Profile responsesElement = Profile.newBuilder().build();
    ListProfilesResponse expectedResponse =
        ListProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProfiles(Arrays.asList(responsesElement))
            .build();
    mockProfileService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");

    ListProfilesPagedResponse pagedListResponse = client.listProfiles(parent);

    List<Profile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProfilesRequest actualRequest = ((ListProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      client.listProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProfilesTest2() throws Exception {
    Profile responsesElement = Profile.newBuilder().build();
    ListProfilesResponse expectedResponse =
        ListProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProfiles(Arrays.asList(responsesElement))
            .build();
    mockProfileService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProfilesPagedResponse pagedListResponse = client.listProfiles(parent);

    List<Profile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProfilesRequest actualRequest = ((ListProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]").toString())
            .setExternalId("externalId-1699764666")
            .setSource("source-896505829")
            .setUri("uri116076")
            .setGroupId("groupId293428218")
            .setIsHirable(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCandidateUpdateTime(Timestamp.newBuilder().build())
            .setResumeUpdateTime(Timestamp.newBuilder().build())
            .setResume(Resume.newBuilder().build())
            .addAllPersonNames(new ArrayList<PersonName>())
            .addAllAddresses(new ArrayList<Address>())
            .addAllEmailAddresses(new ArrayList<Email>())
            .addAllPhoneNumbers(new ArrayList<Phone>())
            .addAllPersonalUris(new ArrayList<PersonalUri>())
            .addAllAdditionalContactInfo(new ArrayList<AdditionalContactInfo>())
            .addAllEmploymentRecords(new ArrayList<EmploymentRecord>())
            .addAllEducationRecords(new ArrayList<EducationRecord>())
            .addAllSkills(new ArrayList<Skill>())
            .addAllActivities(new ArrayList<Activity>())
            .addAllPublications(new ArrayList<Publication>())
            .addAllPatents(new ArrayList<Patent>())
            .addAllCertifications(new ArrayList<Certification>())
            .addAllApplications(new ArrayList<String>())
            .addAllAssignments(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .setProcessed(true)
            .setKeywordSnippet("keywordSnippet-917986572")
            .addAllAvailabilitySignals(new ArrayList<AvailabilitySignal>())
            .addAllDerivedAddresses(new ArrayList<Location>())
            .build();
    mockProfileService.addResponse(expectedResponse);

    TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
    Profile profile = Profile.newBuilder().build();

    Profile actualResponse = client.createProfile(parent, profile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProfileRequest actualRequest = ((CreateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      TenantName parent = TenantName.of("[PROJECT]", "[TENANT]");
      Profile profile = Profile.newBuilder().build();
      client.createProfile(parent, profile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProfileTest2() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]").toString())
            .setExternalId("externalId-1699764666")
            .setSource("source-896505829")
            .setUri("uri116076")
            .setGroupId("groupId293428218")
            .setIsHirable(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCandidateUpdateTime(Timestamp.newBuilder().build())
            .setResumeUpdateTime(Timestamp.newBuilder().build())
            .setResume(Resume.newBuilder().build())
            .addAllPersonNames(new ArrayList<PersonName>())
            .addAllAddresses(new ArrayList<Address>())
            .addAllEmailAddresses(new ArrayList<Email>())
            .addAllPhoneNumbers(new ArrayList<Phone>())
            .addAllPersonalUris(new ArrayList<PersonalUri>())
            .addAllAdditionalContactInfo(new ArrayList<AdditionalContactInfo>())
            .addAllEmploymentRecords(new ArrayList<EmploymentRecord>())
            .addAllEducationRecords(new ArrayList<EducationRecord>())
            .addAllSkills(new ArrayList<Skill>())
            .addAllActivities(new ArrayList<Activity>())
            .addAllPublications(new ArrayList<Publication>())
            .addAllPatents(new ArrayList<Patent>())
            .addAllCertifications(new ArrayList<Certification>())
            .addAllApplications(new ArrayList<String>())
            .addAllAssignments(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .setProcessed(true)
            .setKeywordSnippet("keywordSnippet-917986572")
            .addAllAvailabilitySignals(new ArrayList<AvailabilitySignal>())
            .addAllDerivedAddresses(new ArrayList<Location>())
            .build();
    mockProfileService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Profile profile = Profile.newBuilder().build();

    Profile actualResponse = client.createProfile(parent, profile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProfileRequest actualRequest = ((CreateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      String parent = "parent-995424086";
      Profile profile = Profile.newBuilder().build();
      client.createProfile(parent, profile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]").toString())
            .setExternalId("externalId-1699764666")
            .setSource("source-896505829")
            .setUri("uri116076")
            .setGroupId("groupId293428218")
            .setIsHirable(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCandidateUpdateTime(Timestamp.newBuilder().build())
            .setResumeUpdateTime(Timestamp.newBuilder().build())
            .setResume(Resume.newBuilder().build())
            .addAllPersonNames(new ArrayList<PersonName>())
            .addAllAddresses(new ArrayList<Address>())
            .addAllEmailAddresses(new ArrayList<Email>())
            .addAllPhoneNumbers(new ArrayList<Phone>())
            .addAllPersonalUris(new ArrayList<PersonalUri>())
            .addAllAdditionalContactInfo(new ArrayList<AdditionalContactInfo>())
            .addAllEmploymentRecords(new ArrayList<EmploymentRecord>())
            .addAllEducationRecords(new ArrayList<EducationRecord>())
            .addAllSkills(new ArrayList<Skill>())
            .addAllActivities(new ArrayList<Activity>())
            .addAllPublications(new ArrayList<Publication>())
            .addAllPatents(new ArrayList<Patent>())
            .addAllCertifications(new ArrayList<Certification>())
            .addAllApplications(new ArrayList<String>())
            .addAllAssignments(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .setProcessed(true)
            .setKeywordSnippet("keywordSnippet-917986572")
            .addAllAvailabilitySignals(new ArrayList<AvailabilitySignal>())
            .addAllDerivedAddresses(new ArrayList<Location>())
            .build();
    mockProfileService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    Profile actualResponse = client.getProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProfileRequest actualRequest = ((GetProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
      client.getProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProfileTest2() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]").toString())
            .setExternalId("externalId-1699764666")
            .setSource("source-896505829")
            .setUri("uri116076")
            .setGroupId("groupId293428218")
            .setIsHirable(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCandidateUpdateTime(Timestamp.newBuilder().build())
            .setResumeUpdateTime(Timestamp.newBuilder().build())
            .setResume(Resume.newBuilder().build())
            .addAllPersonNames(new ArrayList<PersonName>())
            .addAllAddresses(new ArrayList<Address>())
            .addAllEmailAddresses(new ArrayList<Email>())
            .addAllPhoneNumbers(new ArrayList<Phone>())
            .addAllPersonalUris(new ArrayList<PersonalUri>())
            .addAllAdditionalContactInfo(new ArrayList<AdditionalContactInfo>())
            .addAllEmploymentRecords(new ArrayList<EmploymentRecord>())
            .addAllEducationRecords(new ArrayList<EducationRecord>())
            .addAllSkills(new ArrayList<Skill>())
            .addAllActivities(new ArrayList<Activity>())
            .addAllPublications(new ArrayList<Publication>())
            .addAllPatents(new ArrayList<Patent>())
            .addAllCertifications(new ArrayList<Certification>())
            .addAllApplications(new ArrayList<String>())
            .addAllAssignments(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .setProcessed(true)
            .setKeywordSnippet("keywordSnippet-917986572")
            .addAllAvailabilitySignals(new ArrayList<AvailabilitySignal>())
            .addAllDerivedAddresses(new ArrayList<Location>())
            .build();
    mockProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    Profile actualResponse = client.getProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProfileRequest actualRequest = ((GetProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.getProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProfileTest() throws Exception {
    Profile expectedResponse =
        Profile.newBuilder()
            .setName(ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]").toString())
            .setExternalId("externalId-1699764666")
            .setSource("source-896505829")
            .setUri("uri116076")
            .setGroupId("groupId293428218")
            .setIsHirable(BoolValue.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCandidateUpdateTime(Timestamp.newBuilder().build())
            .setResumeUpdateTime(Timestamp.newBuilder().build())
            .setResume(Resume.newBuilder().build())
            .addAllPersonNames(new ArrayList<PersonName>())
            .addAllAddresses(new ArrayList<Address>())
            .addAllEmailAddresses(new ArrayList<Email>())
            .addAllPhoneNumbers(new ArrayList<Phone>())
            .addAllPersonalUris(new ArrayList<PersonalUri>())
            .addAllAdditionalContactInfo(new ArrayList<AdditionalContactInfo>())
            .addAllEmploymentRecords(new ArrayList<EmploymentRecord>())
            .addAllEducationRecords(new ArrayList<EducationRecord>())
            .addAllSkills(new ArrayList<Skill>())
            .addAllActivities(new ArrayList<Activity>())
            .addAllPublications(new ArrayList<Publication>())
            .addAllPatents(new ArrayList<Patent>())
            .addAllCertifications(new ArrayList<Certification>())
            .addAllApplications(new ArrayList<String>())
            .addAllAssignments(new ArrayList<String>())
            .putAllCustomAttributes(new HashMap<String, CustomAttribute>())
            .setProcessed(true)
            .setKeywordSnippet("keywordSnippet-917986572")
            .addAllAvailabilitySignals(new ArrayList<AvailabilitySignal>())
            .addAllDerivedAddresses(new ArrayList<Location>())
            .build();
    mockProfileService.addResponse(expectedResponse);

    Profile profile = Profile.newBuilder().build();

    Profile actualResponse = client.updateProfile(profile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateProfileRequest actualRequest = ((UpdateProfileRequest) actualRequests.get(0));

    Assert.assertEquals(profile, actualRequest.getProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      Profile profile = Profile.newBuilder().build();
      client.updateProfile(profile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProfileService.addResponse(expectedResponse);

    ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");

    client.deleteProfile(name);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProfileRequest actualRequest = ((DeleteProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      ProfileName name = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
      client.deleteProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockProfileService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteProfile(name);

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProfileRequest actualRequest = ((DeleteProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchProfilesTest() throws Exception {
    HistogramQueryResult responsesElement = HistogramQueryResult.newBuilder().build();
    SearchProfilesResponse expectedResponse =
        SearchProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllHistogramQueryResults(Arrays.asList(responsesElement))
            .build();
    mockProfileService.addResponse(expectedResponse);

    SearchProfilesRequest request =
        SearchProfilesRequest.newBuilder()
            .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
            .setRequestMetadata(RequestMetadata.newBuilder().build())
            .setProfileQuery(ProfileQuery.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setOffset(-1019779949)
            .setDisableSpellCheck(true)
            .setOrderBy("orderBy-1207110587")
            .setCaseSensitiveSort(true)
            .addAllHistogramQueries(new ArrayList<HistogramQuery>())
            .setResultSetId("resultSetId-548600064")
            .setStrictKeywordsSearch(true)
            .build();

    SearchProfilesPagedResponse pagedListResponse = client.searchProfiles(request);

    List<HistogramQueryResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getHistogramQueryResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProfileService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchProfilesRequest actualRequest = ((SearchProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getRequestMetadata(), actualRequest.getRequestMetadata());
    Assert.assertEquals(request.getProfileQuery(), actualRequest.getProfileQuery());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getOffset(), actualRequest.getOffset());
    Assert.assertEquals(request.getDisableSpellCheck(), actualRequest.getDisableSpellCheck());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertEquals(request.getCaseSensitiveSort(), actualRequest.getCaseSensitiveSort());
    Assert.assertEquals(request.getHistogramQueriesList(), actualRequest.getHistogramQueriesList());
    Assert.assertEquals(request.getResultSetId(), actualRequest.getResultSetId());
    Assert.assertEquals(request.getStrictKeywordsSearch(), actualRequest.getStrictKeywordsSearch());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProfileService.addException(exception);

    try {
      SearchProfilesRequest request =
          SearchProfilesRequest.newBuilder()
              .setParent(TenantName.of("[PROJECT]", "[TENANT]").toString())
              .setRequestMetadata(RequestMetadata.newBuilder().build())
              .setProfileQuery(ProfileQuery.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOffset(-1019779949)
              .setDisableSpellCheck(true)
              .setOrderBy("orderBy-1207110587")
              .setCaseSensitiveSort(true)
              .addAllHistogramQueries(new ArrayList<HistogramQuery>())
              .setResultSetId("resultSetId-548600064")
              .setStrictKeywordsSearch(true)
              .build();
      client.searchProfiles(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
