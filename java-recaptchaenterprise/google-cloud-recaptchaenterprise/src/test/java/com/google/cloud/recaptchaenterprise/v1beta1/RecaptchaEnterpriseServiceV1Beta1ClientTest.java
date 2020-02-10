/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.recaptchaenterprise.v1beta1;

import static com.google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1Client.ListKeysPagedResponse;

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
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.AssessmentName;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1beta1.GetKeyRequest;
import com.google.recaptchaenterprise.v1beta1.Key;
import com.google.recaptchaenterprise.v1beta1.KeyName;
import com.google.recaptchaenterprise.v1beta1.ListKeysRequest;
import com.google.recaptchaenterprise.v1beta1.ListKeysResponse;
import com.google.recaptchaenterprise.v1beta1.ProjectName;
import com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class RecaptchaEnterpriseServiceV1Beta1ClientTest {
  private static MockRecaptchaEnterpriseServiceV1Beta1 mockRecaptchaEnterpriseServiceV1Beta1;
  private static MockServiceHelper serviceHelper;
  private RecaptchaEnterpriseServiceV1Beta1Client client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockRecaptchaEnterpriseServiceV1Beta1 = new MockRecaptchaEnterpriseServiceV1Beta1();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRecaptchaEnterpriseServiceV1Beta1));
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
    RecaptchaEnterpriseServiceV1Beta1Settings settings =
        RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RecaptchaEnterpriseServiceV1Beta1Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createAssessmentTest() {
    AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
    float score = 1.0926453E7F;
    Assessment expectedResponse =
        Assessment.newBuilder().setName(name.toString()).setScore(score).build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Assessment assessment = Assessment.newBuilder().build();

    Assessment actualResponse = client.createAssessment(parent, assessment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssessmentRequest actualRequest = (CreateAssessmentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(assessment, actualRequest.getAssessment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAssessmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Assessment assessment = Assessment.newBuilder().build();

      client.createAssessment(parent, assessment);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void annotateAssessmentTest() {
    AnnotateAssessmentResponse expectedResponse = AnnotateAssessmentResponse.newBuilder().build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
    AnnotateAssessmentRequest.Annotation annotation =
        AnnotateAssessmentRequest.Annotation.ANNOTATION_UNSPECIFIED;

    AnnotateAssessmentResponse actualResponse = client.annotateAssessment(name, annotation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnnotateAssessmentRequest actualRequest = (AnnotateAssessmentRequest) actualRequests.get(0);

    Assert.assertEquals(name, AssessmentName.parse(actualRequest.getName()));
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void annotateAssessmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
      AnnotateAssessmentRequest.Annotation annotation =
          AnnotateAssessmentRequest.Annotation.ANNOTATION_UNSPECIFIED;

      client.annotateAssessment(name, annotation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createKeyTest() {
    KeyName name = KeyName.of("[PROJECT]", "[KEY]");
    String displayName = "displayName1615086568";
    Key expectedResponse =
        Key.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Key key = Key.newBuilder().build();
    CreateKeyRequest request =
        CreateKeyRequest.newBuilder().setParent(parent.toString()).setKey(key).build();

    Key actualResponse = client.createKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = (CreateKeyRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Key key = Key.newBuilder().build();
      CreateKeyRequest request =
          CreateKeyRequest.newBuilder().setParent(parent.toString()).setKey(key).build();

      client.createKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listKeysTest() {
    String nextPageToken = "";
    Key keysElement = Key.newBuilder().build();
    List<Key> keys = Arrays.asList(keysElement);
    ListKeysResponse expectedResponse =
        ListKeysResponse.newBuilder().setNextPageToken(nextPageToken).addAllKeys(keys).build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ListKeysRequest request = ListKeysRequest.newBuilder().setParent(parent.toString()).build();

    ListKeysPagedResponse pagedListResponse = client.listKeys(request);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = (ListKeysRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ListKeysRequest request = ListKeysRequest.newBuilder().setParent(parent.toString()).build();

      client.listKeys(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getKeyTest() {
    KeyName name2 = KeyName.of("[PROJECT]", "[KEY]");
    String displayName = "displayName1615086568";
    Key expectedResponse =
        Key.newBuilder().setName(name2.toString()).setDisplayName(displayName).build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[KEY]");
    GetKeyRequest request = GetKeyRequest.newBuilder().setName(name.toString()).build();

    Key actualResponse = client.getKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = (GetKeyRequest) actualRequests.get(0);

    Assert.assertEquals(name, KeyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[KEY]");
      GetKeyRequest request = GetKeyRequest.newBuilder().setName(name.toString()).build();

      client.getKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateKeyTest() {
    KeyName name = KeyName.of("[PROJECT]", "[KEY]");
    String displayName = "displayName1615086568";
    Key expectedResponse =
        Key.newBuilder().setName(name.toString()).setDisplayName(displayName).build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    Key key = Key.newBuilder().build();
    UpdateKeyRequest request = UpdateKeyRequest.newBuilder().setKey(key).build();

    Key actualResponse = client.updateKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateKeyRequest actualRequest = (UpdateKeyRequest) actualRequests.get(0);

    Assert.assertEquals(key, actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      Key key = Key.newBuilder().build();
      UpdateKeyRequest request = UpdateKeyRequest.newBuilder().setKey(key).build();

      client.updateKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteKeyTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    KeyName name = KeyName.of("[PROJECT]", "[KEY]");
    DeleteKeyRequest request = DeleteKeyRequest.newBuilder().setName(name.toString()).build();

    client.deleteKey(request);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = (DeleteKeyRequest) actualRequests.get(0);

    Assert.assertEquals(name, KeyName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      KeyName name = KeyName.of("[PROJECT]", "[KEY]");
      DeleteKeyRequest request = DeleteKeyRequest.newBuilder().setName(name.toString()).build();

      client.deleteKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
