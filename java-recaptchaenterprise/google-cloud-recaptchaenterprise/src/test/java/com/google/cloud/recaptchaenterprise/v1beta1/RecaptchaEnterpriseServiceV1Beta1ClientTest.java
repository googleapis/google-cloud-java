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
import com.google.protobuf.FieldMask;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.AssessmentName;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1beta1.Event;
import com.google.recaptchaenterprise.v1beta1.GetKeyRequest;
import com.google.recaptchaenterprise.v1beta1.Key;
import com.google.recaptchaenterprise.v1beta1.KeyName;
import com.google.recaptchaenterprise.v1beta1.ListKeysRequest;
import com.google.recaptchaenterprise.v1beta1.ListKeysResponse;
import com.google.recaptchaenterprise.v1beta1.ProjectName;
import com.google.recaptchaenterprise.v1beta1.TokenProperties;
import com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class RecaptchaEnterpriseServiceV1Beta1ClientTest {
  private static MockServiceHelper mockServiceHelper;
  private RecaptchaEnterpriseServiceV1Beta1Client client;
  private LocalChannelProvider channelProvider;
  private static MockRecaptchaEnterpriseServiceV1Beta1 mockRecaptchaEnterpriseServiceV1Beta1;

  @BeforeClass
  public static void startStaticServer() {
    mockRecaptchaEnterpriseServiceV1Beta1 = new MockRecaptchaEnterpriseServiceV1Beta1();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockRecaptchaEnterpriseServiceV1Beta1));
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
  public void createAssessmentTest() throws Exception {
    Assessment expectedResponse =
        Assessment.newBuilder()
            .setName(AssessmentName.of("[PROJECT]", "[ASSESSMENT]").toString())
            .setEvent(Event.newBuilder().build())
            .setScore(109264530)
            .setTokenProperties(TokenProperties.newBuilder().build())
            .addAllReasons(new ArrayList<Assessment.ClassificationReason>())
            .build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Assessment assessment = Assessment.newBuilder().build();

    Assessment actualResponse = client.createAssessment(parent, assessment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
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
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

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
            .setScore(109264530)
            .setTokenProperties(TokenProperties.newBuilder().build())
            .addAllReasons(new ArrayList<Assessment.ClassificationReason>())
            .build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Assessment assessment = Assessment.newBuilder().build();

    Assessment actualResponse = client.createAssessment(parent, assessment);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
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
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

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
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    AssessmentName name = AssessmentName.of("[PROJECT]", "[ASSESSMENT]");
    AnnotateAssessmentRequest.Annotation annotation =
        AnnotateAssessmentRequest.Annotation.forNumber(0);

    AnnotateAssessmentResponse actualResponse = client.annotateAssessment(name, annotation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
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
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

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
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    String name = "name3373707";
    AnnotateAssessmentRequest.Annotation annotation =
        AnnotateAssessmentRequest.Annotation.forNumber(0);

    AnnotateAssessmentResponse actualResponse = client.annotateAssessment(name, annotation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
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
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

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
            .build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    CreateKeyRequest request =
        CreateKeyRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setKey(Key.newBuilder().build())
            .build();

    Key actualResponse = client.createKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateKeyRequest actualRequest = ((CreateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getKey(), actualRequest.getKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      CreateKeyRequest request =
          CreateKeyRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setKey(Key.newBuilder().build())
              .build();
      client.createKey(request);
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
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    ListKeysRequest request =
        ListKeysRequest.newBuilder()
            .setParent(ProjectName.of("[PROJECT]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListKeysPagedResponse pagedListResponse = client.listKeys(request);

    List<Key> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeysList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListKeysRequest actualRequest = ((ListKeysRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      ListKeysRequest request =
          ListKeysRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listKeys(request);
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
            .build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    GetKeyRequest request =
        GetKeyRequest.newBuilder().setName(KeyName.of("[PROJECT]", "[KEY]").toString()).build();

    Key actualResponse = client.getKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetKeyRequest actualRequest = ((GetKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      GetKeyRequest request =
          GetKeyRequest.newBuilder().setName(KeyName.of("[PROJECT]", "[KEY]").toString()).build();
      client.getKey(request);
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
            .build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    UpdateKeyRequest request =
        UpdateKeyRequest.newBuilder()
            .setKey(Key.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Key actualResponse = client.updateKey(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateKeyRequest actualRequest = ((UpdateKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getKey(), actualRequest.getKey());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      UpdateKeyRequest request =
          UpdateKeyRequest.newBuilder()
              .setKey(Key.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRecaptchaEnterpriseServiceV1Beta1.addResponse(expectedResponse);

    DeleteKeyRequest request =
        DeleteKeyRequest.newBuilder().setName(KeyName.of("[PROJECT]", "[KEY]").toString()).build();

    client.deleteKey(request);

    List<AbstractMessage> actualRequests = mockRecaptchaEnterpriseServiceV1Beta1.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteKeyRequest actualRequest = ((DeleteKeyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRecaptchaEnterpriseServiceV1Beta1.addException(exception);

    try {
      DeleteKeyRequest request =
          DeleteKeyRequest.newBuilder()
              .setName(KeyName.of("[PROJECT]", "[KEY]").toString())
              .build();
      client.deleteKey(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
