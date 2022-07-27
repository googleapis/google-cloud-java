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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.VizierServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.VizierServiceClient.ListStudiesPagedResponse;
import static com.google.cloud.aiplatform.v1.VizierServiceClient.ListTrialsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class VizierServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVizierService mockVizierService;
  private LocalChannelProvider channelProvider;
  private VizierServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVizierService = new MockVizierService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVizierService, mockLocations, mockIAMPolicy));
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
    VizierServiceSettings settings =
        VizierServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VizierServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createStudyTest() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Study study = Study.newBuilder().build();

    Study actualResponse = client.createStudy(parent, study);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStudyRequest actualRequest = ((CreateStudyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(study, actualRequest.getStudy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStudyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Study study = Study.newBuilder().build();
      client.createStudy(parent, study);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createStudyTest2() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Study study = Study.newBuilder().build();

    Study actualResponse = client.createStudy(parent, study);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateStudyRequest actualRequest = ((CreateStudyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(study, actualRequest.getStudy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createStudyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      Study study = Study.newBuilder().build();
      client.createStudy(parent, study);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStudyTest() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");

    Study actualResponse = client.getStudy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStudyRequest actualRequest = ((GetStudyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStudyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
      client.getStudy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStudyTest2() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    String name = "name3373707";

    Study actualResponse = client.getStudy(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetStudyRequest actualRequest = ((GetStudyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getStudyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String name = "name3373707";
      client.getStudy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStudiesTest() throws Exception {
    Study responsesElement = Study.newBuilder().build();
    ListStudiesResponse expectedResponse =
        ListStudiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStudies(Arrays.asList(responsesElement))
            .build();
    mockVizierService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListStudiesPagedResponse pagedListResponse = client.listStudies(parent);

    List<Study> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStudiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStudiesRequest actualRequest = ((ListStudiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStudiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listStudies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listStudiesTest2() throws Exception {
    Study responsesElement = Study.newBuilder().build();
    ListStudiesResponse expectedResponse =
        ListStudiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllStudies(Arrays.asList(responsesElement))
            .build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListStudiesPagedResponse pagedListResponse = client.listStudies(parent);

    List<Study> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getStudiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListStudiesRequest actualRequest = ((ListStudiesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listStudiesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listStudies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStudyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVizierService.addResponse(expectedResponse);

    StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");

    client.deleteStudy(name);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStudyRequest actualRequest = ((DeleteStudyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStudyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StudyName name = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
      client.deleteStudy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteStudyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVizierService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteStudy(name);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteStudyRequest actualRequest = ((DeleteStudyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteStudyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteStudy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupStudyTest() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    Study actualResponse = client.lookupStudy(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupStudyRequest actualRequest = ((LookupStudyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupStudyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.lookupStudy(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void lookupStudyTest2() throws Exception {
    Study expectedResponse =
        Study.newBuilder()
            .setName(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setDisplayName("displayName1714148973")
            .setStudySpec(StudySpec.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setInactiveReason("inactiveReason1923653263")
            .build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    Study actualResponse = client.lookupStudy(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupStudyRequest actualRequest = ((LookupStudyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupStudyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.lookupStudy(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestTrialsTest() throws Exception {
    SuggestTrialsResponse expectedResponse =
        SuggestTrialsResponse.newBuilder()
            .addAllTrials(new ArrayList<Trial>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("suggestTrialsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVizierService.addResponse(resultOperation);

    SuggestTrialsRequest request =
        SuggestTrialsRequest.newBuilder()
            .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
            .setSuggestionCount(390130452)
            .setClientId("clientId908408390")
            .build();

    SuggestTrialsResponse actualResponse = client.suggestTrialsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestTrialsRequest actualRequest = ((SuggestTrialsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSuggestionCount(), actualRequest.getSuggestionCount());
    Assert.assertEquals(request.getClientId(), actualRequest.getClientId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestTrialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      SuggestTrialsRequest request =
          SuggestTrialsRequest.newBuilder()
              .setParent(StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]").toString())
              .setSuggestionCount(390130452)
              .setClientId("clientId908408390")
              .build();
      client.suggestTrialsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTrialTest() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
    Trial trial = Trial.newBuilder().build();

    Trial actualResponse = client.createTrial(parent, trial);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTrialRequest actualRequest = ((CreateTrialRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(trial, actualRequest.getTrial());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTrialExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
      Trial trial = Trial.newBuilder().build();
      client.createTrial(parent, trial);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTrialTest2() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Trial trial = Trial.newBuilder().build();

    Trial actualResponse = client.createTrial(parent, trial);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTrialRequest actualRequest = ((CreateTrialRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(trial, actualRequest.getTrial());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTrialExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      Trial trial = Trial.newBuilder().build();
      client.createTrial(parent, trial);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTrialTest() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");

    Trial actualResponse = client.getTrial(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTrialRequest actualRequest = ((GetTrialRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTrialExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");
      client.getTrial(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTrialTest2() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    String name = "name3373707";

    Trial actualResponse = client.getTrial(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTrialRequest actualRequest = ((GetTrialRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTrialExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String name = "name3373707";
      client.getTrial(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrialsTest() throws Exception {
    Trial responsesElement = Trial.newBuilder().build();
    ListTrialsResponse expectedResponse =
        ListTrialsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrials(Arrays.asList(responsesElement))
            .build();
    mockVizierService.addResponse(expectedResponse);

    StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");

    ListTrialsPagedResponse pagedListResponse = client.listTrials(parent);

    List<Trial> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrialsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTrialsRequest actualRequest = ((ListTrialsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTrialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
      client.listTrials(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTrialsTest2() throws Exception {
    Trial responsesElement = Trial.newBuilder().build();
    ListTrialsResponse expectedResponse =
        ListTrialsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTrials(Arrays.asList(responsesElement))
            .build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTrialsPagedResponse pagedListResponse = client.listTrials(parent);

    List<Trial> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTrialsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTrialsRequest actualRequest = ((ListTrialsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTrialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTrials(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addTrialMeasurementTest() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    AddTrialMeasurementRequest request =
        AddTrialMeasurementRequest.newBuilder()
            .setTrialName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setMeasurement(Measurement.newBuilder().build())
            .build();

    Trial actualResponse = client.addTrialMeasurement(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddTrialMeasurementRequest actualRequest = ((AddTrialMeasurementRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTrialName(), actualRequest.getTrialName());
    Assert.assertEquals(request.getMeasurement(), actualRequest.getMeasurement());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addTrialMeasurementExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      AddTrialMeasurementRequest request =
          AddTrialMeasurementRequest.newBuilder()
              .setTrialName(
                  TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
              .setMeasurement(Measurement.newBuilder().build())
              .build();
      client.addTrialMeasurement(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeTrialTest() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    CompleteTrialRequest request =
        CompleteTrialRequest.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .setTrialInfeasible(true)
            .setInfeasibleReason("infeasibleReason1040725388")
            .build();

    Trial actualResponse = client.completeTrial(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteTrialRequest actualRequest = ((CompleteTrialRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFinalMeasurement(), actualRequest.getFinalMeasurement());
    Assert.assertEquals(request.getTrialInfeasible(), actualRequest.getTrialInfeasible());
    Assert.assertEquals(request.getInfeasibleReason(), actualRequest.getInfeasibleReason());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeTrialExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      CompleteTrialRequest request =
          CompleteTrialRequest.newBuilder()
              .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
              .setFinalMeasurement(Measurement.newBuilder().build())
              .setTrialInfeasible(true)
              .setInfeasibleReason("infeasibleReason1040725388")
              .build();
      client.completeTrial(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTrialTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVizierService.addResponse(expectedResponse);

    TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");

    client.deleteTrial(name);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTrialRequest actualRequest = ((DeleteTrialRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTrialExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      TrialName name = TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]");
      client.deleteTrial(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTrialTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockVizierService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTrial(name);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTrialRequest actualRequest = ((DeleteTrialRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTrialExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTrial(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkTrialEarlyStoppingStateTest() throws Exception {
    CheckTrialEarlyStoppingStateResponse expectedResponse =
        CheckTrialEarlyStoppingStateResponse.newBuilder().setShouldStop(true).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("checkTrialEarlyStoppingStateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVizierService.addResponse(resultOperation);

    CheckTrialEarlyStoppingStateRequest request =
        CheckTrialEarlyStoppingStateRequest.newBuilder()
            .setTrialName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .build();

    CheckTrialEarlyStoppingStateResponse actualResponse =
        client.checkTrialEarlyStoppingStateAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckTrialEarlyStoppingStateRequest actualRequest =
        ((CheckTrialEarlyStoppingStateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getTrialName(), actualRequest.getTrialName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkTrialEarlyStoppingStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      CheckTrialEarlyStoppingStateRequest request =
          CheckTrialEarlyStoppingStateRequest.newBuilder()
              .setTrialName(
                  TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
              .build();
      client.checkTrialEarlyStoppingStateAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopTrialTest() throws Exception {
    Trial expectedResponse =
        Trial.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .setId("id3355")
            .addAllParameters(new ArrayList<Trial.Parameter>())
            .setFinalMeasurement(Measurement.newBuilder().build())
            .addAllMeasurements(new ArrayList<Measurement>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setClientId("clientId908408390")
            .setInfeasibleReason("infeasibleReason1040725388")
            .setCustomJob(CustomJobName.of("[PROJECT]", "[LOCATION]", "[CUSTOM_JOB]").toString())
            .putAllWebAccessUris(new HashMap<String, String>())
            .build();
    mockVizierService.addResponse(expectedResponse);

    StopTrialRequest request =
        StopTrialRequest.newBuilder()
            .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
            .build();

    Trial actualResponse = client.stopTrial(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopTrialRequest actualRequest = ((StopTrialRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopTrialExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StopTrialRequest request =
          StopTrialRequest.newBuilder()
              .setName(TrialName.of("[PROJECT]", "[LOCATION]", "[STUDY]", "[TRIAL]").toString())
              .build();
      client.stopTrial(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOptimalTrialsTest() throws Exception {
    ListOptimalTrialsResponse expectedResponse =
        ListOptimalTrialsResponse.newBuilder().addAllOptimalTrials(new ArrayList<Trial>()).build();
    mockVizierService.addResponse(expectedResponse);

    StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");

    ListOptimalTrialsResponse actualResponse = client.listOptimalTrials(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOptimalTrialsRequest actualRequest = ((ListOptimalTrialsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOptimalTrialsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      StudyName parent = StudyName.of("[PROJECT]", "[LOCATION]", "[STUDY]");
      client.listOptimalTrials(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listOptimalTrialsTest2() throws Exception {
    ListOptimalTrialsResponse expectedResponse =
        ListOptimalTrialsResponse.newBuilder().addAllOptimalTrials(new ArrayList<Trial>()).build();
    mockVizierService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListOptimalTrialsResponse actualResponse = client.listOptimalTrials(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVizierService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListOptimalTrialsRequest actualRequest = ((ListOptimalTrialsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listOptimalTrialsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVizierService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listOptimalTrials(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
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
