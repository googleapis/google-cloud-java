/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.SessionControllerClient.ListSessionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataproc.v1.stub.HttpJsonSessionControllerStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class SessionControllerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SessionControllerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSessionControllerStub.getMethodDescriptors(),
            SessionControllerSettings.getDefaultEndpoint());
    SessionControllerSettings settings =
        SessionControllerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SessionControllerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SessionControllerClient.create(settings);
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
  public void createSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Session session = Session.newBuilder().build();
    String sessionId = "sessionId607796817";

    Session actualResponse = client.createSessionAsync(parent, session, sessionId).get();
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
  public void createSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Session session = Session.newBuilder().build();
      String sessionId = "sessionId607796817";
      client.createSessionAsync(parent, session, sessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Session session = Session.newBuilder().build();
    String sessionId = "sessionId607796817";

    Session actualResponse = client.createSessionAsync(parent, session, sessionId).get();
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
  public void createSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Session session = Session.newBuilder().build();
      String sessionId = "sessionId607796817";
      client.createSessionAsync(parent, session, sessionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9117/locations/location-9117/sessions/session-9117";

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9117/locations/location-9117/sessions/session-9117";
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest2() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void terminateSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("terminateSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");

    Session actualResponse = client.terminateSessionAsync(name).get();
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
  public void terminateSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");
      client.terminateSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void terminateSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("terminateSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9117/locations/location-9117/sessions/session-9117";

    Session actualResponse = client.terminateSessionAsync(name).get();
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
  public void terminateSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9117/locations/location-9117/sessions/session-9117";
      client.terminateSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");

    Session actualResponse = client.deleteSessionAsync(name).get();
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
  public void deleteSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name = SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");
      client.deleteSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(SessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setUuid("uuid3601339")
            .setCreateTime(Timestamp.newBuilder().build())
            .setRuntimeInfo(RuntimeInfo.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setStateTime(Timestamp.newBuilder().build())
            .setCreator("creator1028554796")
            .putAllLabels(new HashMap<String, String>())
            .setRuntimeConfig(RuntimeConfig.newBuilder().build())
            .setEnvironmentConfig(EnvironmentConfig.newBuilder().build())
            .setUser("user3599307")
            .addAllStateHistory(new ArrayList<Session.SessionStateHistory>())
            .setSessionTemplate(
                SessionTemplateName.of("[PROJECT]", "[LOCATION]", "[TEMPLATE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSessionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9117/locations/location-9117/sessions/session-9117";

    Session actualResponse = client.deleteSessionAsync(name).get();
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
  public void deleteSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9117/locations/location-9117/sessions/session-9117";
      client.deleteSessionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                        "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
                          "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
