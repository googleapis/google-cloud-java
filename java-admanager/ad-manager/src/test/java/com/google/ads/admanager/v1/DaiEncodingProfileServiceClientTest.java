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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.DaiEncodingProfileServiceClient.ListDaiEncodingProfilesPagedResponse;

import com.google.ads.admanager.v1.stub.HttpJsonDaiEncodingProfileServiceStub;
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
public class DaiEncodingProfileServiceClientTest {
  private static MockHttpService mockService;
  private static DaiEncodingProfileServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDaiEncodingProfileServiceStub.getMethodDescriptors(),
            DaiEncodingProfileServiceSettings.getDefaultEndpoint());
    DaiEncodingProfileServiceSettings settings =
        DaiEncodingProfileServiceSettings.newBuilder()
            .setTransportChannelProvider(
                DaiEncodingProfileServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DaiEncodingProfileServiceClient.create(settings);
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
  public void getDaiEncodingProfileTest() throws Exception {
    DaiEncodingProfile expectedResponse =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DaiEncodingProfileName name =
        DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]");

    DaiEncodingProfile actualResponse = client.getDaiEncodingProfile(name);
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
  public void getDaiEncodingProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DaiEncodingProfileName name =
          DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]");
      client.getDaiEncodingProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDaiEncodingProfileTest2() throws Exception {
    DaiEncodingProfile expectedResponse =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "networks/network-560/daiEncodingProfiles/daiEncodingProfile-560";

    DaiEncodingProfile actualResponse = client.getDaiEncodingProfile(name);
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
  public void getDaiEncodingProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "networks/network-560/daiEncodingProfiles/daiEncodingProfile-560";
      client.getDaiEncodingProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDaiEncodingProfilesTest() throws Exception {
    DaiEncodingProfile responsesElement = DaiEncodingProfile.newBuilder().build();
    ListDaiEncodingProfilesResponse expectedResponse =
        ListDaiEncodingProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDaiEncodingProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");

    ListDaiEncodingProfilesPagedResponse pagedListResponse = client.listDaiEncodingProfiles(parent);

    List<DaiEncodingProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDaiEncodingProfilesList().get(0), resources.get(0));

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
  public void listDaiEncodingProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      client.listDaiEncodingProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDaiEncodingProfilesTest2() throws Exception {
    DaiEncodingProfile responsesElement = DaiEncodingProfile.newBuilder().build();
    ListDaiEncodingProfilesResponse expectedResponse =
        ListDaiEncodingProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDaiEncodingProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";

    ListDaiEncodingProfilesPagedResponse pagedListResponse = client.listDaiEncodingProfiles(parent);

    List<DaiEncodingProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDaiEncodingProfilesList().get(0), resources.get(0));

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
  public void listDaiEncodingProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      client.listDaiEncodingProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDaiEncodingProfileTest() throws Exception {
    DaiEncodingProfile expectedResponse =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();

    DaiEncodingProfile actualResponse = client.createDaiEncodingProfile(parent, daiEncodingProfile);
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
  public void createDaiEncodingProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();
      client.createDaiEncodingProfile(parent, daiEncodingProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDaiEncodingProfileTest2() throws Exception {
    DaiEncodingProfile expectedResponse =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();

    DaiEncodingProfile actualResponse = client.createDaiEncodingProfile(parent, daiEncodingProfile);
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
  public void createDaiEncodingProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      DaiEncodingProfile daiEncodingProfile = DaiEncodingProfile.newBuilder().build();
      client.createDaiEncodingProfile(parent, daiEncodingProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateDaiEncodingProfilesTest() throws Exception {
    BatchCreateDaiEncodingProfilesResponse expectedResponse =
        BatchCreateDaiEncodingProfilesResponse.newBuilder()
            .addAllDaiEncodingProfiles(new ArrayList<DaiEncodingProfile>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchCreateDaiEncodingProfilesResponse actualResponse =
        client.batchCreateDaiEncodingProfiles(parent, requests);
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
  public void batchCreateDaiEncodingProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchCreateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateDaiEncodingProfilesTest2() throws Exception {
    BatchCreateDaiEncodingProfilesResponse expectedResponse =
        BatchCreateDaiEncodingProfilesResponse.newBuilder()
            .addAllDaiEncodingProfiles(new ArrayList<DaiEncodingProfile>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchCreateDaiEncodingProfilesResponse actualResponse =
        client.batchCreateDaiEncodingProfiles(parent, requests);
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
  public void batchCreateDaiEncodingProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<CreateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchCreateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDaiEncodingProfileTest() throws Exception {
    DaiEncodingProfile expectedResponse =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DaiEncodingProfile daiEncodingProfile =
        DaiEncodingProfile.newBuilder()
            .setName(
                DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
            .setDisplayName("displayName1714148973")
            .setVideoSettings(VideoSettings.newBuilder().build())
            .setAudioSettings(AudioSettings.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DaiEncodingProfile actualResponse =
        client.updateDaiEncodingProfile(daiEncodingProfile, updateMask);
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
  public void updateDaiEncodingProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DaiEncodingProfile daiEncodingProfile =
          DaiEncodingProfile.newBuilder()
              .setName(
                  DaiEncodingProfileName.of("[NETWORK_CODE]", "[DAI_ENCODING_PROFILE]").toString())
              .setDisplayName("displayName1714148973")
              .setVideoSettings(VideoSettings.newBuilder().build())
              .setAudioSettings(AudioSettings.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDaiEncodingProfile(daiEncodingProfile, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDaiEncodingProfilesTest() throws Exception {
    BatchUpdateDaiEncodingProfilesResponse expectedResponse =
        BatchUpdateDaiEncodingProfilesResponse.newBuilder()
            .addAllDaiEncodingProfiles(new ArrayList<DaiEncodingProfile>())
            .build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchUpdateDaiEncodingProfilesResponse actualResponse =
        client.batchUpdateDaiEncodingProfiles(parent, requests);
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
  public void batchUpdateDaiEncodingProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchUpdateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateDaiEncodingProfilesTest2() throws Exception {
    BatchUpdateDaiEncodingProfilesResponse expectedResponse =
        BatchUpdateDaiEncodingProfilesResponse.newBuilder()
            .addAllDaiEncodingProfiles(new ArrayList<DaiEncodingProfile>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchUpdateDaiEncodingProfilesResponse actualResponse =
        client.batchUpdateDaiEncodingProfiles(parent, requests);
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
  public void batchUpdateDaiEncodingProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<UpdateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchUpdateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateDaiEncodingProfilesTest() throws Exception {
    BatchActivateDaiEncodingProfilesResponse expectedResponse =
        BatchActivateDaiEncodingProfilesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchActivateDaiEncodingProfilesResponse actualResponse =
        client.batchActivateDaiEncodingProfiles(parent, requests);
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
  public void batchActivateDaiEncodingProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchActivateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchActivateDaiEncodingProfilesTest2() throws Exception {
    BatchActivateDaiEncodingProfilesResponse expectedResponse =
        BatchActivateDaiEncodingProfilesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchActivateDaiEncodingProfilesResponse actualResponse =
        client.batchActivateDaiEncodingProfiles(parent, requests);
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
  public void batchActivateDaiEncodingProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<ActivateDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchActivateDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveDaiEncodingProfilesTest() throws Exception {
    BatchArchiveDaiEncodingProfilesResponse expectedResponse =
        BatchArchiveDaiEncodingProfilesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    NetworkName parent = NetworkName.of("[NETWORK_CODE]");
    List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchArchiveDaiEncodingProfilesResponse actualResponse =
        client.batchArchiveDaiEncodingProfiles(parent, requests);
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
  public void batchArchiveDaiEncodingProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NetworkName parent = NetworkName.of("[NETWORK_CODE]");
      List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchArchiveDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchArchiveDaiEncodingProfilesTest2() throws Exception {
    BatchArchiveDaiEncodingProfilesResponse expectedResponse =
        BatchArchiveDaiEncodingProfilesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "networks/network-5450";
    List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();

    BatchArchiveDaiEncodingProfilesResponse actualResponse =
        client.batchArchiveDaiEncodingProfiles(parent, requests);
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
  public void batchArchiveDaiEncodingProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "networks/network-5450";
      List<ArchiveDaiEncodingProfileRequest> requests = new ArrayList<>();
      client.batchArchiveDaiEncodingProfiles(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
