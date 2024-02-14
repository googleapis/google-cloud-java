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

package com.google.cloud.recaptchaenterprise.v1;

import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListFirewallPoliciesPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListKeysPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupMembershipsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.SearchRelatedAccountGroupMembershipsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.recaptchaenterprise.v1.AccountDefenderAssessment;
import com.google.recaptchaenterprise.v1.AccountVerificationInfo;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.AssessmentName;
import com.google.recaptchaenterprise.v1.ChallengeMetrics;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.Event;
import com.google.recaptchaenterprise.v1.FirewallAction;
import com.google.recaptchaenterprise.v1.FirewallPolicy;
import com.google.recaptchaenterprise.v1.FirewallPolicyAssessment;
import com.google.recaptchaenterprise.v1.FirewallPolicyName;
import com.google.recaptchaenterprise.v1.FraudPreventionAssessment;
import com.google.recaptchaenterprise.v1.FraudSignals;
import com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.GetMetricsRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.KeyName;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse;
import com.google.recaptchaenterprise.v1.Metrics;
import com.google.recaptchaenterprise.v1.MetricsName;
import com.google.recaptchaenterprise.v1.MigrateKeyRequest;
import com.google.recaptchaenterprise.v1.PrivatePasswordLeakVerification;
import com.google.recaptchaenterprise.v1.ProjectName;
import com.google.recaptchaenterprise.v1.RelatedAccountGroup;
import com.google.recaptchaenterprise.v1.RelatedAccountGroupMembership;
import com.google.recaptchaenterprise.v1.RelatedAccountGroupName;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse;
import com.google.recaptchaenterprise.v1.RiskAnalysis;
import com.google.recaptchaenterprise.v1.ScoreMetrics;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.TestingOptions;
import com.google.recaptchaenterprise.v1.TokenProperties;
import com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import com.google.recaptchaenterprise.v1.WafSettings;
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
public class RecaptchaEnterpriseServiceClientTest {
  private static MockRecaptchaEnterpriseService mockRecaptchaEnterpriseService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RecaptchaEnterpriseServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRecaptchaEnterpriseService = new MockRecaptchaEnterpriseService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRecaptchaEnterpriseService));
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
    RecaptchaEnterpriseServiceSettings settings =
        RecaptchaEnterpriseServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RecaptchaEnterpriseServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createAssessmentTest() throws Exception {
    Assessment expectedResponse =
        Assessment.newBuilder()
            .setName(AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString())
            .setEvent(Event.newBuilder().build())
            .setRiskAnalysis(RiskAnalysis.newBuilder().build())
            .setTokenProperties(TokenProperties.newBuilder().build())
            .setAccountVerification(AccountVerificationInfo.newBuilder().build())
            .setAccountDefenderAssessment(AccountDefenderAssessment.newBuilder().build())
            .setPrivatePasswordLeakVerification(
                PrivatePasswordLeakVerification.newBuilder().build())
            .setFirewallPolicyAssessment(FirewallPolicyAssessment.newBuilder().build())
            .setFraudPreventionAssessment(FraudPreventionAssessment.newBuilder().build())
            .setFraudSignals(FraudSignals.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Assessment assessment = Assessment.newBuilder().build();

    Assessment actualResponse = client.createAssessment(parent, assessment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssessmentRequest actualRequest = ((CreateAssessmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(assessment, actualRequest.getAssessment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssessmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Assessment assessment = Assessment.newBuilder().build();
      client.createAssessment(parent, assessment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssessmentTest2() throws Exception {
    Assessment expectedResponse =
        Assessment.newBuilder()
            .setName(AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString())
            .setEvent(Event.newBuilder().build())
            .setRiskAnalysis(RiskAnalysis.newBuilder().build())
            .setTokenProperties(TokenProperties.newBuilder().build())
            .setAccountVerification(AccountVerificationInfo.newBuilder().build())
            .setAccountDefenderAssessment(AccountDefenderAssessment.newBuilder().build())
            .setPrivatePasswordLeakVerification(
                PrivatePasswordLeakVerification.newBuilder().build())
            .setFirewallPolicyAssessment(FirewallPolicyAssessment.newBuilder().build())
            .setFraudPreventionAssessment(FraudPreventionAssessment.newBuilder().build())
            .setFraudSignals(FraudSignals.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Assessment assessment = Assessment.newBuilder().build();

    Assessment actualResponse = client.createAssessment(parent, assessment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssessmentRequest actualRequest = ((CreateAssessmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(assessment, actualRequest.getAssessment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssessmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      Assessment assessment = Assessment.newBuilder().build();
      client.createAssessment(parent, assessment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void annotateAssessmentTest() throws Exception {
    AnnotateAssessmentResponse expectedResponse = AnnotateAssessmentResponse.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
    AnnotateAssessmentRequest.Annotation annotation =
        AnnotateAssessmentRequest.Annotation.forNumber(0);

    AnnotateAssessmentResponse actualResponse = client.annotateAssessment(name, annotation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateAssessmentRequest actualRequest = ((AnnotateAssessmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void annotateAssessmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
      AnnotateAssessmentRequest.Annotation annotation =
          AnnotateAssessmentRequest.Annotation.forNumber(0);
      client.annotateAssessment(name, annotation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void annotateAssessmentTest2() throws Exception {
    AnnotateAssessmentResponse expectedResponse = AnnotateAssessmentResponse.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";
    AnnotateAssessmentRequest.Annotation annotation =
        AnnotateAssessmentRequest.Annotation.forNumber(0);

    AnnotateAssessmentResponse actualResponse = client.annotateAssessment(name, annotation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateAssessmentRequest actualRequest = ((AnnotateAssessmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void annotateAssessmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      AnnotateAssessmentRequest.Annotation annotation =
          AnnotateAssessmentRequest.Annotation.forNumber(0);
      client.annotateAssessment(name, annotation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Key key = Key.newBuilder().build();

    Key actualResponse = client.createKey(parent, key);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = ((CreateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Key key = Key.newBuilder().build();
      client.createKey(parent, key);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKeyTest2() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Key key = Key.newBuilder().build();

    Key actualResponse = client.createKey(parent, key);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = ((CreateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      Key key = Key.newBuilder().build();
      client.createKey(parent, key);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKeysTest() throws Exception {
    Key responsesElement = Key.newBuilder().build();
    ListKeysResponse expectedResponse =
        ListKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeys(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = ((ListKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKeysTest2() throws Exception {
    Key responsesElement = Key.newBuilder().build();
    ListKeysResponse expectedResponse =
        ListKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeys(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListKeysPagedResponse pagedListResponse = client.listKeys(parent);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = ((ListKeysRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKeysExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveLegacySecretKeyTest() throws Exception {
    RetrieveLegacySecretKeyResponse expectedResponse =
        RetrieveLegacySecretKeyResponse.newBuilder()
            .setLegacySecretKey("legacySecretKey1016952774")
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    KeyName key = KeyName.of("[PROJECT]", "[KEY]");

    RetrieveLegacySecretKeyResponse actualResponse = client.retrieveLegacySecretKey(key);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveLegacySecretKeyRequest actualRequest =
        ((RetrieveLegacySecretKeyRequest) actualRequests.get(0));

    Assert.assertEquals(key.toString(), actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveLegacySecretKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      KeyName key = KeyName.of("[PROJECT]", "[KEY]");
      client.retrieveLegacySecretKey(key);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveLegacySecretKeyTest2() throws Exception {
    RetrieveLegacySecretKeyResponse expectedResponse =
        RetrieveLegacySecretKeyResponse.newBuilder()
            .setLegacySecretKey("legacySecretKey1016952774")
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String key = "key106079";

    RetrieveLegacySecretKeyResponse actualResponse = client.retrieveLegacySecretKey(key);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveLegacySecretKeyRequest actualRequest =
        ((RetrieveLegacySecretKeyRequest) actualRequests.get(0));

    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveLegacySecretKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String key = "key106079";
      client.retrieveLegacySecretKey(key);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[KEY]");

    Key actualResponse = client.getKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = ((GetKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[KEY]");
      client.getKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyTest2() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";

    Key actualResponse = client.getKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = ((GetKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      client.getKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    Key key = Key.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Key actualResponse = client.updateKey(key, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateKeyRequest actualRequest = ((UpdateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      Key key = Key.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateKey(key, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[KEY]");

    client.deleteKey(name);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = ((DeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[KEY]");
      client.deleteKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteKey(name);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = ((DeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void migrateKeyTest() throws Exception {
    Key expectedResponse =
        Key.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setTestingOptions(TestingOptions.newBuilder().build())
            .setWafSettings(WafSettings.newBuilder().build())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    MigrateKeyRequest request =
        MigrateKeyRequest.newBuilder()
            .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
            .setSkipBillingCheck(true)
            .build();

    Key actualResponse = client.migrateKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MigrateKeyRequest actualRequest = ((MigrateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getSkipBillingCheck(), actualRequest.getSkipBillingCheck());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void migrateKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      MigrateKeyRequest request =
          MigrateKeyRequest.newBuilder()
              .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
              .setSkipBillingCheck(true)
              .build();
      client.migrateKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetricsTest() throws Exception {
    Metrics expectedResponse =
        Metrics.newBuilder()
            .setName(MetricsName.of("[PROJECT]", "[KEY]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .addAllScoreMetrics(new ArrayList<ScoreMetrics>())
            .addAllChallengeMetrics(new ArrayList<ChallengeMetrics>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    MetricsName name = MetricsName.of("[PROJECT]", "[KEY]");

    Metrics actualResponse = client.getMetrics(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricsRequest actualRequest = ((GetMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      MetricsName name = MetricsName.of("[PROJECT]", "[KEY]");
      client.getMetrics(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMetricsTest2() throws Exception {
    Metrics expectedResponse =
        Metrics.newBuilder()
            .setName(MetricsName.of("[PROJECT]", "[KEY]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .addAllScoreMetrics(new ArrayList<ScoreMetrics>())
            .addAllChallengeMetrics(new ArrayList<ChallengeMetrics>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";

    Metrics actualResponse = client.getMetrics(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMetricsRequest actualRequest = ((GetMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMetricsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      client.getMetrics(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirewallPolicyTest() throws Exception {
    FirewallPolicy expectedResponse =
        FirewallPolicy.newBuilder()
            .setName(FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]").toString())
            .setDescription("description-1724546052")
            .setPath("path3433509")
            .setCondition("condition-861311717")
            .addAllActions(new ArrayList<FirewallAction>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();

    FirewallPolicy actualResponse = client.createFirewallPolicy(parent, firewallPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallPolicyRequest actualRequest =
        ((CreateFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(firewallPolicy, actualRequest.getFirewallPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();
      client.createFirewallPolicy(parent, firewallPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFirewallPolicyTest2() throws Exception {
    FirewallPolicy expectedResponse =
        FirewallPolicy.newBuilder()
            .setName(FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]").toString())
            .setDescription("description-1724546052")
            .setPath("path3433509")
            .setCondition("condition-861311717")
            .addAllActions(new ArrayList<FirewallAction>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();

    FirewallPolicy actualResponse = client.createFirewallPolicy(parent, firewallPolicy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFirewallPolicyRequest actualRequest =
        ((CreateFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(firewallPolicy, actualRequest.getFirewallPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFirewallPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();
      client.createFirewallPolicy(parent, firewallPolicy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirewallPoliciesTest() throws Exception {
    FirewallPolicy responsesElement = FirewallPolicy.newBuilder().build();
    ListFirewallPoliciesResponse expectedResponse =
        ListFirewallPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallPolicies(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListFirewallPoliciesPagedResponse pagedListResponse = client.listFirewallPolicies(parent);

    List<FirewallPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirewallPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallPoliciesRequest actualRequest =
        ((ListFirewallPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listFirewallPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFirewallPoliciesTest2() throws Exception {
    FirewallPolicy responsesElement = FirewallPolicy.newBuilder().build();
    ListFirewallPoliciesResponse expectedResponse =
        ListFirewallPoliciesResponse.newBuilder()
            .setNextPageToken("")
            .addAllFirewallPolicies(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFirewallPoliciesPagedResponse pagedListResponse = client.listFirewallPolicies(parent);

    List<FirewallPolicy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFirewallPoliciesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFirewallPoliciesRequest actualRequest =
        ((ListFirewallPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFirewallPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFirewallPolicies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallPolicyTest() throws Exception {
    FirewallPolicy expectedResponse =
        FirewallPolicy.newBuilder()
            .setName(FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]").toString())
            .setDescription("description-1724546052")
            .setPath("path3433509")
            .setCondition("condition-861311717")
            .addAllActions(new ArrayList<FirewallAction>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    FirewallPolicyName name = FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]");

    FirewallPolicy actualResponse = client.getFirewallPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallPolicyRequest actualRequest = ((GetFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      FirewallPolicyName name = FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]");
      client.getFirewallPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFirewallPolicyTest2() throws Exception {
    FirewallPolicy expectedResponse =
        FirewallPolicy.newBuilder()
            .setName(FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]").toString())
            .setDescription("description-1724546052")
            .setPath("path3433509")
            .setCondition("condition-861311717")
            .addAllActions(new ArrayList<FirewallAction>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";

    FirewallPolicy actualResponse = client.getFirewallPolicy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFirewallPolicyRequest actualRequest = ((GetFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFirewallPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      client.getFirewallPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFirewallPolicyTest() throws Exception {
    FirewallPolicy expectedResponse =
        FirewallPolicy.newBuilder()
            .setName(FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]").toString())
            .setDescription("description-1724546052")
            .setPath("path3433509")
            .setCondition("condition-861311717")
            .addAllActions(new ArrayList<FirewallAction>())
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FirewallPolicy actualResponse = client.updateFirewallPolicy(firewallPolicy, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFirewallPolicyRequest actualRequest =
        ((UpdateFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(firewallPolicy, actualRequest.getFirewallPolicy());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFirewallPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      FirewallPolicy firewallPolicy = FirewallPolicy.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFirewallPolicy(firewallPolicy, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFirewallPolicyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    FirewallPolicyName name = FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]");

    client.deleteFirewallPolicy(name);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallPolicyRequest actualRequest =
        ((DeleteFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      FirewallPolicyName name = FirewallPolicyName.of("[PROJECT]", "[FIREWALLPOLICY]");
      client.deleteFirewallPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFirewallPolicyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFirewallPolicy(name);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFirewallPolicyRequest actualRequest =
        ((DeleteFirewallPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFirewallPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteFirewallPolicy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reorderFirewallPoliciesTest() throws Exception {
    ReorderFirewallPoliciesResponse expectedResponse =
        ReorderFirewallPoliciesResponse.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    List<String> names = new ArrayList<>();

    ReorderFirewallPoliciesResponse actualResponse = client.reorderFirewallPolicies(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReorderFirewallPoliciesRequest actualRequest =
        ((ReorderFirewallPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reorderFirewallPoliciesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      List<String> names = new ArrayList<>();
      client.reorderFirewallPolicies(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reorderFirewallPoliciesTest2() throws Exception {
    ReorderFirewallPoliciesResponse expectedResponse =
        ReorderFirewallPoliciesResponse.newBuilder().build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<String> names = new ArrayList<>();

    ReorderFirewallPoliciesResponse actualResponse = client.reorderFirewallPolicies(parent, names);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReorderFirewallPoliciesRequest actualRequest =
        ((ReorderFirewallPoliciesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(names, actualRequest.getNamesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reorderFirewallPoliciesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      List<String> names = new ArrayList<>();
      client.reorderFirewallPolicies(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRelatedAccountGroupsTest() throws Exception {
    RelatedAccountGroup responsesElement = RelatedAccountGroup.newBuilder().build();
    ListRelatedAccountGroupsResponse expectedResponse =
        ListRelatedAccountGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroups(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListRelatedAccountGroupsPagedResponse pagedListResponse =
        client.listRelatedAccountGroups(parent);

    List<RelatedAccountGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRelatedAccountGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRelatedAccountGroupsRequest actualRequest =
        ((ListRelatedAccountGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRelatedAccountGroupsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listRelatedAccountGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRelatedAccountGroupsTest2() throws Exception {
    RelatedAccountGroup responsesElement = RelatedAccountGroup.newBuilder().build();
    ListRelatedAccountGroupsResponse expectedResponse =
        ListRelatedAccountGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroups(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRelatedAccountGroupsPagedResponse pagedListResponse =
        client.listRelatedAccountGroups(parent);

    List<RelatedAccountGroup> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRelatedAccountGroupsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRelatedAccountGroupsRequest actualRequest =
        ((ListRelatedAccountGroupsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRelatedAccountGroupsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRelatedAccountGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRelatedAccountGroupMembershipsTest() throws Exception {
    RelatedAccountGroupMembership responsesElement =
        RelatedAccountGroupMembership.newBuilder().build();
    ListRelatedAccountGroupMembershipsResponse expectedResponse =
        ListRelatedAccountGroupMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroupMemberships(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    RelatedAccountGroupName parent =
        RelatedAccountGroupName.of("[PROJECT]", "[RELATEDACCOUNTGROUP]");

    ListRelatedAccountGroupMembershipsPagedResponse pagedListResponse =
        client.listRelatedAccountGroupMemberships(parent);

    List<RelatedAccountGroupMembership> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRelatedAccountGroupMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRelatedAccountGroupMembershipsRequest actualRequest =
        ((ListRelatedAccountGroupMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRelatedAccountGroupMembershipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      RelatedAccountGroupName parent =
          RelatedAccountGroupName.of("[PROJECT]", "[RELATEDACCOUNTGROUP]");
      client.listRelatedAccountGroupMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRelatedAccountGroupMembershipsTest2() throws Exception {
    RelatedAccountGroupMembership responsesElement =
        RelatedAccountGroupMembership.newBuilder().build();
    ListRelatedAccountGroupMembershipsResponse expectedResponse =
        ListRelatedAccountGroupMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroupMemberships(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRelatedAccountGroupMembershipsPagedResponse pagedListResponse =
        client.listRelatedAccountGroupMemberships(parent);

    List<RelatedAccountGroupMembership> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRelatedAccountGroupMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRelatedAccountGroupMembershipsRequest actualRequest =
        ((ListRelatedAccountGroupMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRelatedAccountGroupMembershipsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRelatedAccountGroupMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchRelatedAccountGroupMembershipsTest() throws Exception {
    RelatedAccountGroupMembership responsesElement =
        RelatedAccountGroupMembership.newBuilder().build();
    SearchRelatedAccountGroupMembershipsResponse expectedResponse =
        SearchRelatedAccountGroupMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroupMemberships(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    RelatedAccountGroupName project =
        RelatedAccountGroupName.of("[PROJECT]", "[RELATEDACCOUNTGROUP]");
    ByteString hashedAccountId = ByteString.EMPTY;

    SearchRelatedAccountGroupMembershipsPagedResponse pagedListResponse =
        client.searchRelatedAccountGroupMemberships(project, hashedAccountId);

    List<RelatedAccountGroupMembership> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRelatedAccountGroupMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRelatedAccountGroupMembershipsRequest actualRequest =
        ((SearchRelatedAccountGroupMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(project.toString(), actualRequest.getProject());
    Assert.assertEquals(hashedAccountId, actualRequest.getHashedAccountId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchRelatedAccountGroupMembershipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      RelatedAccountGroupName project =
          RelatedAccountGroupName.of("[PROJECT]", "[RELATEDACCOUNTGROUP]");
      ByteString hashedAccountId = ByteString.EMPTY;
      client.searchRelatedAccountGroupMemberships(project, hashedAccountId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchRelatedAccountGroupMembershipsTest2() throws Exception {
    RelatedAccountGroupMembership responsesElement =
        RelatedAccountGroupMembership.newBuilder().build();
    SearchRelatedAccountGroupMembershipsResponse expectedResponse =
        SearchRelatedAccountGroupMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRelatedAccountGroupMemberships(Arrays.asList(responsesElement))
            .build();
    mockRecaptchaEnterpriseService.addResponse(expectedResponse);

    String project = "project-309310695";
    ByteString hashedAccountId = ByteString.EMPTY;

    SearchRelatedAccountGroupMembershipsPagedResponse pagedListResponse =
        client.searchRelatedAccountGroupMemberships(project, hashedAccountId);

    List<RelatedAccountGroupMembership> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getRelatedAccountGroupMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRelatedAccountGroupMembershipsRequest actualRequest =
        ((SearchRelatedAccountGroupMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(project, actualRequest.getProject());
    Assert.assertEquals(hashedAccountId, actualRequest.getHashedAccountId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchRelatedAccountGroupMembershipsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseService.addException(exception);

    try {
      String project = "project-309310695";
      ByteString hashedAccountId = ByteString.EMPTY;
      client.searchRelatedAccountGroupMemberships(project, hashedAccountId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
