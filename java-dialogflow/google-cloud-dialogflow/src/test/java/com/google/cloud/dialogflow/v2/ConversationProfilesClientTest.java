/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListConversationProfilesPagedResponse;

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
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class ConversationProfilesClientTest {
  private static MockConversationProfiles mockConversationProfiles;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConversationProfilesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConversationProfiles = new MockConversationProfiles();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockConversationProfiles));
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
    ConversationProfilesSettings settings =
        ConversationProfilesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationProfilesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listConversationProfilesTest() throws Exception {
    ConversationProfile responsesElement = ConversationProfile.newBuilder().build();
    ListConversationProfilesResponse expectedResponse =
        ListConversationProfilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversationProfiles(Arrays.asList(responsesElement))
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationProfilesRequest actualRequest =
        ((ListConversationProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationProfilesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
    mockConversationProfiles.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationProfilesRequest actualRequest =
        ((ListConversationProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationProfilesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
    mockConversationProfiles.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationProfilesPagedResponse pagedListResponse =
        client.listConversationProfiles(parent);

    List<ConversationProfile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationProfilesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationProfilesRequest actualRequest =
        ((ListConversationProfilesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationProfilesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    ConversationProfileName name =
        ConversationProfileName.ofProjectConversationProfileName(
            "[PROJECT]", "[CONVERSATION_PROFILE]");

    ConversationProfile actualResponse = client.getConversationProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationProfileRequest actualRequest =
        ((GetConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    String name = "name3373707";

    ConversationProfile actualResponse = client.getConversationProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationProfileRequest actualRequest =
        ((GetConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

    try {
      String name = "name3373707";
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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationProfileRequest actualRequest =
        ((CreateConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversationProfile, actualRequest.getConversationProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationProfileRequest actualRequest =
        ((CreateConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversationProfile, actualRequest.getConversationProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();

    ConversationProfile actualResponse =
        client.createConversationProfile(parent, conversationProfile);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationProfileRequest actualRequest =
        ((CreateConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversationProfile, actualRequest.getConversationProfile());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationProfileExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .build();
    mockConversationProfiles.addResponse(expectedResponse);

    ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConversationProfile actualResponse =
        client.updateConversationProfile(conversationProfile, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConversationProfileRequest actualRequest =
        ((UpdateConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(conversationProfile, actualRequest.getConversationProfile());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConversationProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

    try {
      ConversationProfile conversationProfile = ConversationProfile.newBuilder().build();
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
    mockConversationProfiles.addResponse(expectedResponse);

    ConversationProfileName name =
        ConversationProfileName.ofProjectConversationProfileName(
            "[PROJECT]", "[CONVERSATION_PROFILE]");

    client.deleteConversationProfile(name);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationProfileRequest actualRequest =
        ((DeleteConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

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
    mockConversationProfiles.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversationProfile(name);

    List<AbstractMessage> actualRequests = mockConversationProfiles.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationProfileRequest actualRequest =
        ((DeleteConversationProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationProfiles.addException(exception);

    try {
      String name = "name3373707";
      client.deleteConversationProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
