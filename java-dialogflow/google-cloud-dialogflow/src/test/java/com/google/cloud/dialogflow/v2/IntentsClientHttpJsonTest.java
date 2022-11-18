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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.v2.IntentsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2.stub.HttpJsonIntentsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
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
public class IntentsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static IntentsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonIntentsStub.getMethodDescriptors(), IntentsSettings.getDefaultEndpoint());
    IntentsSettings settings =
        IntentsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                IntentsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = IntentsClient.create(settings);
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
  public void listIntentsTest() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

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
  public void listIntentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      client.listIntents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntentsTest2() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2469/agent";

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

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
  public void listIntentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      client.listIntents(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntentsTest3() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    String languageCode = "languageCode-2092349083";

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent, languageCode);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

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
  public void listIntentsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      String languageCode = "languageCode-2092349083";
      client.listIntents(parent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntentsTest4() throws Exception {
    Intent responsesElement = Intent.newBuilder().build();
    ListIntentsResponse expectedResponse =
        ListIntentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntents(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2469/agent";
    String languageCode = "languageCode-2092349083";

    ListIntentsPagedResponse pagedListResponse = client.listIntents(parent, languageCode);

    List<Intent> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntentsList().get(0), resources.get(0));

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
  public void listIntentsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      String languageCode = "languageCode-2092349083";
      client.listIntents(parent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");

    Intent actualResponse = client.getIntent(name);
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
  public void getIntentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");
      client.getIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest2() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1783/agent/intents/intent-1783";

    Intent actualResponse = client.getIntent(name);
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
  public void getIntentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1783/agent/intents/intent-1783";
      client.getIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest3() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");
    String languageCode = "languageCode-2092349083";

    Intent actualResponse = client.getIntent(name, languageCode);
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
  public void getIntentExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");
      String languageCode = "languageCode-2092349083";
      client.getIntent(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntentTest4() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1783/agent/intents/intent-1783";
    String languageCode = "languageCode-2092349083";

    Intent actualResponse = client.getIntent(name, languageCode);
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
  public void getIntentExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1783/agent/intents/intent-1783";
      String languageCode = "languageCode-2092349083";
      client.getIntent(name, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    Intent intent = Intent.newBuilder().build();

    Intent actualResponse = client.createIntent(parent, intent);
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
  public void createIntentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      Intent intent = Intent.newBuilder().build();
      client.createIntent(parent, intent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest2() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2469/agent";
    Intent intent = Intent.newBuilder().build();

    Intent actualResponse = client.createIntent(parent, intent);
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
  public void createIntentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      Intent intent = Intent.newBuilder().build();
      client.createIntent(parent, intent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest3() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    Intent intent = Intent.newBuilder().build();
    String languageCode = "languageCode-2092349083";

    Intent actualResponse = client.createIntent(parent, intent, languageCode);
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
  public void createIntentExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      Intent intent = Intent.newBuilder().build();
      String languageCode = "languageCode-2092349083";
      client.createIntent(parent, intent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIntentTest4() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2469/agent";
    Intent intent = Intent.newBuilder().build();
    String languageCode = "languageCode-2092349083";

    Intent actualResponse = client.createIntent(parent, intent, languageCode);
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
  public void createIntentExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      Intent intent = Intent.newBuilder().build();
      String languageCode = "languageCode-2092349083";
      client.createIntent(parent, intent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIntentTest() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    Intent intent =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    String languageCode = "languageCode-2092349083";

    Intent actualResponse = client.updateIntent(intent, languageCode);
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
  public void updateIntentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Intent intent =
          Intent.newBuilder()
              .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
              .setDisplayName("displayName1714148973")
              .setPriority(-1165461084)
              .setIsFallback(true)
              .setMlDisabled(true)
              .setLiveAgentHandoff(true)
              .setEndInteraction(true)
              .addAllInputContextNames(new ArrayList<String>())
              .addAllEvents(new ArrayList<String>())
              .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
              .setAction("action-1422950858")
              .addAllOutputContexts(new ArrayList<Context>())
              .setResetContexts(true)
              .addAllParameters(new ArrayList<Intent.Parameter>())
              .addAllMessages(new ArrayList<Intent.Message>())
              .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
              .setRootFollowupIntentName("rootFollowupIntentName1370087157")
              .setParentFollowupIntentName("parentFollowupIntentName1233650877")
              .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
              .build();
      String languageCode = "languageCode-2092349083";
      client.updateIntent(intent, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIntentTest2() throws Exception {
    Intent expectedResponse =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    mockService.addResponse(expectedResponse);

    Intent intent =
        Intent.newBuilder()
            .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
            .setDisplayName("displayName1714148973")
            .setPriority(-1165461084)
            .setIsFallback(true)
            .setMlDisabled(true)
            .setLiveAgentHandoff(true)
            .setEndInteraction(true)
            .addAllInputContextNames(new ArrayList<String>())
            .addAllEvents(new ArrayList<String>())
            .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
            .setAction("action-1422950858")
            .addAllOutputContexts(new ArrayList<Context>())
            .setResetContexts(true)
            .addAllParameters(new ArrayList<Intent.Parameter>())
            .addAllMessages(new ArrayList<Intent.Message>())
            .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
            .setRootFollowupIntentName("rootFollowupIntentName1370087157")
            .setParentFollowupIntentName("parentFollowupIntentName1233650877")
            .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
            .build();
    String languageCode = "languageCode-2092349083";
    FieldMask updateMask = FieldMask.newBuilder().build();

    Intent actualResponse = client.updateIntent(intent, languageCode, updateMask);
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
  public void updateIntentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Intent intent =
          Intent.newBuilder()
              .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
              .setDisplayName("displayName1714148973")
              .setPriority(-1165461084)
              .setIsFallback(true)
              .setMlDisabled(true)
              .setLiveAgentHandoff(true)
              .setEndInteraction(true)
              .addAllInputContextNames(new ArrayList<String>())
              .addAllEvents(new ArrayList<String>())
              .addAllTrainingPhrases(new ArrayList<Intent.TrainingPhrase>())
              .setAction("action-1422950858")
              .addAllOutputContexts(new ArrayList<Context>())
              .setResetContexts(true)
              .addAllParameters(new ArrayList<Intent.Parameter>())
              .addAllMessages(new ArrayList<Intent.Message>())
              .addAllDefaultResponsePlatforms(new ArrayList<Intent.Message.Platform>())
              .setRootFollowupIntentName("rootFollowupIntentName1370087157")
              .setParentFollowupIntentName("parentFollowupIntentName1233650877")
              .addAllFollowupIntentInfo(new ArrayList<Intent.FollowupIntentInfo>())
              .build();
      String languageCode = "languageCode-2092349083";
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIntent(intent, languageCode, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIntentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");

    client.deleteIntent(name);

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
  public void deleteIntentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntentName name = IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]");
      client.deleteIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIntentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1783/agent/intents/intent-1783";

    client.deleteIntent(name);

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
  public void deleteIntentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1783/agent/intents/intent-1783";
      client.deleteIntent(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateIntentsTest() throws Exception {
    BatchUpdateIntentsResponse expectedResponse =
        BatchUpdateIntentsResponse.newBuilder().addAllIntents(new ArrayList<Intent>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    IntentBatch intentBatchInline = IntentBatch.newBuilder().build();

    BatchUpdateIntentsResponse actualResponse =
        client.batchUpdateIntentsAsync(parent, intentBatchInline).get();
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
  public void batchUpdateIntentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      IntentBatch intentBatchInline = IntentBatch.newBuilder().build();
      client.batchUpdateIntentsAsync(parent, intentBatchInline).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchUpdateIntentsTest2() throws Exception {
    BatchUpdateIntentsResponse expectedResponse =
        BatchUpdateIntentsResponse.newBuilder().addAllIntents(new ArrayList<Intent>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    String intentBatchUri = "intentBatchUri544125582";

    BatchUpdateIntentsResponse actualResponse =
        client.batchUpdateIntentsAsync(parent, intentBatchUri).get();
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
  public void batchUpdateIntentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      String intentBatchUri = "intentBatchUri544125582";
      client.batchUpdateIntentsAsync(parent, intentBatchUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchUpdateIntentsTest3() throws Exception {
    BatchUpdateIntentsResponse expectedResponse =
        BatchUpdateIntentsResponse.newBuilder().addAllIntents(new ArrayList<Intent>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2469/agent";
    IntentBatch intentBatchInline = IntentBatch.newBuilder().build();

    BatchUpdateIntentsResponse actualResponse =
        client.batchUpdateIntentsAsync(parent, intentBatchInline).get();
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
  public void batchUpdateIntentsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      IntentBatch intentBatchInline = IntentBatch.newBuilder().build();
      client.batchUpdateIntentsAsync(parent, intentBatchInline).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchUpdateIntentsTest4() throws Exception {
    BatchUpdateIntentsResponse expectedResponse =
        BatchUpdateIntentsResponse.newBuilder().addAllIntents(new ArrayList<Intent>()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchUpdateIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2469/agent";
    String intentBatchUri = "intentBatchUri544125582";

    BatchUpdateIntentsResponse actualResponse =
        client.batchUpdateIntentsAsync(parent, intentBatchUri).get();
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
  public void batchUpdateIntentsExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      String intentBatchUri = "intentBatchUri544125582";
      client.batchUpdateIntentsAsync(parent, intentBatchUri).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchDeleteIntentsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AgentName parent = AgentName.ofProjectName("[PROJECT]");
    List<Intent> intents = new ArrayList<>();

    client.batchDeleteIntentsAsync(parent, intents).get();

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
  public void batchDeleteIntentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AgentName parent = AgentName.ofProjectName("[PROJECT]");
      List<Intent> intents = new ArrayList<>();
      client.batchDeleteIntentsAsync(parent, intents).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void batchDeleteIntentsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchDeleteIntentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-2469/agent";
    List<Intent> intents = new ArrayList<>();

    client.batchDeleteIntentsAsync(parent, intents).get();

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
  public void batchDeleteIntentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2469/agent";
      List<Intent> intents = new ArrayList<>();
      client.batchDeleteIntentsAsync(parent, intents).get();
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
