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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.ConversationProfilesClient.ListConversationProfilesPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationProfilesClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2beta1.stub.HttpJsonConversationProfilesStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ConversationProfilesClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConversationProfilesClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConversationProfilesStub.getMethodDescriptors(),
            ConversationProfilesSettings.getDefaultEndpoint());
    ConversationProfilesSettings settings =
        ConversationProfilesSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConversationProfilesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationProfilesClient.create(settings);
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
  public void listConversationProfilesTest() throws Exception {
    ConversationProfile responsesElement = ConversationProfile.newBuilder().build();
    ListConversationProfilesResponse expectedResponse =
        ListConversationProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

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
  public void listConversationProfilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConversationProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationProfilesTest2() throws Exception {
    ConversationProfile responsesElement = ConversationProfile.newBuilder().build();
    ListConversationProfilesResponse expectedResponse =
        ListConversationProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

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
  public void listConversationProfilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listConversationProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationProfilesTest3() throws Exception {
    ConversationProfile responsesElement = ConversationProfile.newBuilder().build();
    ListConversationProfilesResponse expectedResponse =
        ListConversationProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationProfiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

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
  public void listConversationProfilesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listConversationProfiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationProfileTest() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    ConversationProfileName name =
        ConversationProfileName.ofProjectConversationProfileName(
            "[PROJECT]", "[CONVERSATION_PROFILE]");

    ConversationProfile actualResponse = client.getConversationProfile(name);
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
  public void getConversationProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationProfileName name =
          ConversationProfileName.ofProjectConversationProfileName(
              "[PROJECT]", "[CONVERSATION_PROFILE]");
      client.getConversationProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationProfileTest2() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-695/conversationProfiles/conversationProfile-695";

    ConversationProfile actualResponse = client.getConversationProfile(name);
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
  public void getConversationProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-695/conversationProfiles/conversationProfile-695";
      client.getConversationProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationProfileTest() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
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
  public void createConversationProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
      client.createConversationProfile(parent, conversationProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationProfileTest2() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
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
  public void createConversationProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
      client.createConversationProfile(parent, conversationProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationProfileTest3() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
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
  public void createConversationProfileExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
      client.createConversationProfile(parent, conversationProfile);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConversationProfileTest() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    mockService.addResponse(expectedResponse);

    ConversationProfile conversationProfile =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversationProfile actualResponse =
        client.updateConversationProfile(conversationProfile, updateMask);
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
  public void updateConversationProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationProfile conversationProfile =
          ConversationProfile.newBuilder()
              .setName(
                  ConversationProfileName.ofProjectConversationProfileName(
                          "[PROJECT]", "[CONVERSATION_PROFILE]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
              .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
              .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
              .setNotificationConfig(NotificationConfig.newBuilder().build())
              .setLoggingConfig(LoggingConfig.newBuilder().build())
              .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
              .setSttConfig(SpeechToTextConfig.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setTimeZone("timeZone-2077180903")
              .setSecuritySettings("securitySettings-1062971517")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversationProfile(conversationProfile, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationProfileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConversationProfileName name =
        ConversationProfileName.ofProjectConversationProfileName(
            "[PROJECT]", "[CONVERSATION_PROFILE]");

    client.deleteConversationProfile(name);

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
  public void deleteConversationProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationProfileName name =
          ConversationProfileName.ofProjectConversationProfileName(
              "[PROJECT]", "[CONVERSATION_PROFILE]");
      client.deleteConversationProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationProfileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-695/conversationProfiles/conversationProfile-695";

    client.deleteConversationProfile(name);

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
  public void deleteConversationProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-695/conversationProfiles/conversationProfile-695";
      client.deleteConversationProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setSuggestionFeatureConfigTest() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setSuggestionFeatureConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String conversationProfile =
        "projects/project-4204/conversationProfiles/conversationProfile-4204";

    ConversationProfile actualResponse =
        client.setSuggestionFeatureConfigAsync(conversationProfile).get();
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
  public void setSuggestionFeatureConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversationProfile =
          "projects/project-4204/conversationProfiles/conversationProfile-4204";
      client.setSuggestionFeatureConfigAsync(conversationProfile).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void clearSuggestionFeatureConfigTest() throws Exception {
    ConversationProfile expectedResponse =
        ConversationProfile.newBuilder()
            .setName(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setAutomatedAgentConfig(AutomatedAgentConfig.newBuilder().build())
            .setHumanAgentAssistantConfig(HumanAgentAssistantConfig.newBuilder().build())
            .setHumanAgentHandoffConfig(HumanAgentHandoffConfig.newBuilder().build())
            .setNotificationConfig(NotificationConfig.newBuilder().build())
            .setLoggingConfig(LoggingConfig.newBuilder().build())
            .setNewMessageEventNotificationConfig(NotificationConfig.newBuilder().build())
            .setSttConfig(SpeechToTextConfig.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setTimeZone("timeZone-2077180903")
            .setSecuritySettings("securitySettings-1062971517")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("clearSuggestionFeatureConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String conversationProfile =
        "projects/project-4204/conversationProfiles/conversationProfile-4204";

    ConversationProfile actualResponse =
        client.clearSuggestionFeatureConfigAsync(conversationProfile).get();
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
  public void clearSuggestionFeatureConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversationProfile =
          "projects/project-4204/conversationProfiles/conversationProfile-4204";
      client.clearSuggestionFeatureConfigAsync(conversationProfile).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
