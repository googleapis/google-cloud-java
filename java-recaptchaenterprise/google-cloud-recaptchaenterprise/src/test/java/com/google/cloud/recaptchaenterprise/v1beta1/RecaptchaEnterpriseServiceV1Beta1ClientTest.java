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

package com.google.cloud.recaptchaenterprise.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.recaptchaenterprise.v1beta1.AccountDefenderAssessment;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.AssessmentName;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.Event;
import com.google.recaptchaenterprise.v1beta1.PasswordLeakVerification;
import com.google.recaptchaenterprise.v1beta1.ProjectName;
import com.google.recaptchaenterprise.v1beta1.TokenProperties;
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
  private static MockRecaptchaEnterpriseServiceV1Beta1 mockRecaptchaEnterpriseServiceV1Beta1;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RecaptchaEnterpriseServiceV1Beta1Client client;

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
            .setPasswordLeakVerification(PasswordLeakVerification.newBuilder().build())
            .setAccountDefenderAssessment(AccountDefenderAssessment.newBuilder().build())
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
            .setPasswordLeakVerification(PasswordLeakVerification.newBuilder().build())
            .setAccountDefenderAssessment(AccountDefenderAssessment.newBuilder().build())
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
}
