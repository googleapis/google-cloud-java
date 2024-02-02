/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2;

import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListConferenceRecordsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantSessionsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListRecordingsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptEntriesPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.apps.meet.v2.stub.HttpJsonConferenceRecordsServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import java.io.IOException;
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
public class ConferenceRecordsServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConferenceRecordsServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConferenceRecordsServiceStub.getMethodDescriptors(),
            ConferenceRecordsServiceSettings.getDefaultEndpoint());
    ConferenceRecordsServiceSettings settings =
        ConferenceRecordsServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConferenceRecordsServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConferenceRecordsServiceClient.create(settings);
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
  public void getConferenceRecordTest() throws Exception {
    ConferenceRecord expectedResponse =
        ConferenceRecord.newBuilder()
            .setName(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setSpace(SpaceName.of("[SPACE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    ConferenceRecordName name = ConferenceRecordName.of("[CONFERENCE_RECORD]");

    ConferenceRecord actualResponse = client.getConferenceRecord(name);
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
  public void getConferenceRecordExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConferenceRecordName name = ConferenceRecordName.of("[CONFERENCE_RECORD]");
      client.getConferenceRecord(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConferenceRecordTest2() throws Exception {
    ConferenceRecord expectedResponse =
        ConferenceRecord.newBuilder()
            .setName(ConferenceRecordName.of("[CONFERENCE_RECORD]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setSpace(SpaceName.of("[SPACE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "conferenceRecords/conferenceRecord-4138";

    ConferenceRecord actualResponse = client.getConferenceRecord(name);
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
  public void getConferenceRecordExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "conferenceRecords/conferenceRecord-4138";
      client.getConferenceRecord(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConferenceRecordsTest() throws Exception {
    ConferenceRecord responsesElement = ConferenceRecord.newBuilder().build();
    ListConferenceRecordsResponse expectedResponse =
        ListConferenceRecordsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConferenceRecords(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListConferenceRecordsRequest request =
        ListConferenceRecordsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .build();

    ListConferenceRecordsPagedResponse pagedListResponse = client.listConferenceRecords(request);

    List<ConferenceRecord> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConferenceRecordsList().get(0), resources.get(0));

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
  public void listConferenceRecordsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListConferenceRecordsRequest request =
          ListConferenceRecordsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listConferenceRecords(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantTest() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
            .setEarliestStartTime(Timestamp.newBuilder().build())
            .setLatestEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName name = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");

    Participant actualResponse = client.getParticipant(name);
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
  public void getParticipantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName name = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");
      client.getParticipant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantTest2() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
            .setEarliestStartTime(Timestamp.newBuilder().build())
            .setLatestEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "conferenceRecords/conferenceRecord-6004/participants/participant-6004";

    Participant actualResponse = client.getParticipant(name);
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
  public void getParticipantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "conferenceRecords/conferenceRecord-6004/participants/participant-6004";
      client.getParticipant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantsTest() throws Exception {
    Participant responsesElement = Participant.newBuilder().build();
    ListParticipantsResponse expectedResponse =
        ListParticipantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

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
  public void listParticipantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
      client.listParticipants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantsTest2() throws Exception {
    Participant responsesElement = Participant.newBuilder().build();
    ListParticipantsResponse expectedResponse =
        ListParticipantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "conferenceRecords/conferenceRecord-7879";

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

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
  public void listParticipantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "conferenceRecords/conferenceRecord-7879";
      client.listParticipants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantSessionTest() throws Exception {
    ParticipantSession expectedResponse =
        ParticipantSession.newBuilder()
            .setName(
                ParticipantSessionName.of(
                        "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantSessionName name =
        ParticipantSessionName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]");

    ParticipantSession actualResponse = client.getParticipantSession(name);
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
  public void getParticipantSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantSessionName name =
          ParticipantSessionName.of(
              "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]");
      client.getParticipantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantSessionTest2() throws Exception {
    ParticipantSession expectedResponse =
        ParticipantSession.newBuilder()
            .setName(
                ParticipantSessionName.of(
                        "[CONFERENCE_RECORD]", "[PARTICIPANT]", "[PARTICIPANT_SESSION]")
                    .toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "conferenceRecords/conferenceRecord-5872/participants/participant-5872/participantSessions/participantSession-5872";

    ParticipantSession actualResponse = client.getParticipantSession(name);
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
  public void getParticipantSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "conferenceRecords/conferenceRecord-5872/participants/participant-5872/participantSessions/participantSession-5872";
      client.getParticipantSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantSessionsTest() throws Exception {
    ParticipantSession responsesElement = ParticipantSession.newBuilder().build();
    ListParticipantSessionsResponse expectedResponse =
        ListParticipantSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipantSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName parent = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");

    ListParticipantSessionsPagedResponse pagedListResponse = client.listParticipantSessions(parent);

    List<ParticipantSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantSessionsList().get(0), resources.get(0));

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
  public void listParticipantSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName parent = ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]");
      client.listParticipantSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantSessionsTest2() throws Exception {
    ParticipantSession responsesElement = ParticipantSession.newBuilder().build();
    ListParticipantSessionsResponse expectedResponse =
        ListParticipantSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipantSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "conferenceRecords/conferenceRecord-8605/participants/participant-8605";

    ListParticipantSessionsPagedResponse pagedListResponse = client.listParticipantSessions(parent);

    List<ParticipantSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantSessionsList().get(0), resources.get(0));

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
  public void listParticipantSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "conferenceRecords/conferenceRecord-8605/participants/participant-8605";
      client.listParticipantSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecordingTest() throws Exception {
    Recording expectedResponse =
        Recording.newBuilder()
            .setName(RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RecordingName name = RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]");

    Recording actualResponse = client.getRecording(name);
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
  public void getRecordingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RecordingName name = RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]");
      client.getRecording(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRecordingTest2() throws Exception {
    Recording expectedResponse =
        Recording.newBuilder()
            .setName(RecordingName.of("[CONFERENCE_RECORD]", "[RECORDING]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "conferenceRecords/conferenceRecord-9994/recordings/recording-9994";

    Recording actualResponse = client.getRecording(name);
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
  public void getRecordingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "conferenceRecords/conferenceRecord-9994/recordings/recording-9994";
      client.getRecording(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecordingsTest() throws Exception {
    Recording responsesElement = Recording.newBuilder().build();
    ListRecordingsResponse expectedResponse =
        ListRecordingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecordings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");

    ListRecordingsPagedResponse pagedListResponse = client.listRecordings(parent);

    List<Recording> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecordingsList().get(0), resources.get(0));

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
  public void listRecordingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
      client.listRecordings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRecordingsTest2() throws Exception {
    Recording responsesElement = Recording.newBuilder().build();
    ListRecordingsResponse expectedResponse =
        ListRecordingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRecordings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "conferenceRecords/conferenceRecord-7879";

    ListRecordingsPagedResponse pagedListResponse = client.listRecordings(parent);

    List<Recording> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRecordingsList().get(0), resources.get(0));

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
  public void listRecordingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "conferenceRecords/conferenceRecord-7879";
      client.listRecordings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTranscriptTest() throws Exception {
    Transcript expectedResponse =
        Transcript.newBuilder()
            .setName(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TranscriptName name = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");

    Transcript actualResponse = client.getTranscript(name);
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
  public void getTranscriptExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TranscriptName name = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");
      client.getTranscript(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTranscriptTest2() throws Exception {
    Transcript expectedResponse =
        Transcript.newBuilder()
            .setName(TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]").toString())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "conferenceRecords/conferenceRecord-8047/transcripts/transcript-8047";

    Transcript actualResponse = client.getTranscript(name);
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
  public void getTranscriptExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "conferenceRecords/conferenceRecord-8047/transcripts/transcript-8047";
      client.getTranscript(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTranscriptsTest() throws Exception {
    Transcript responsesElement = Transcript.newBuilder().build();
    ListTranscriptsResponse expectedResponse =
        ListTranscriptsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTranscripts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");

    ListTranscriptsPagedResponse pagedListResponse = client.listTranscripts(parent);

    List<Transcript> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTranscriptsList().get(0), resources.get(0));

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
  public void listTranscriptsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConferenceRecordName parent = ConferenceRecordName.of("[CONFERENCE_RECORD]");
      client.listTranscripts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTranscriptsTest2() throws Exception {
    Transcript responsesElement = Transcript.newBuilder().build();
    ListTranscriptsResponse expectedResponse =
        ListTranscriptsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTranscripts(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "conferenceRecords/conferenceRecord-7879";

    ListTranscriptsPagedResponse pagedListResponse = client.listTranscripts(parent);

    List<Transcript> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTranscriptsList().get(0), resources.get(0));

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
  public void listTranscriptsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "conferenceRecords/conferenceRecord-7879";
      client.listTranscripts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTranscriptEntryTest() throws Exception {
    TranscriptEntry expectedResponse =
        TranscriptEntry.newBuilder()
            .setName(
                TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]").toString())
            .setParticipant(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
            .setText("text3556653")
            .setLanguageCode("languageCode-2092349083")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    TranscriptEntryName name =
        TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]");

    TranscriptEntry actualResponse = client.getTranscriptEntry(name);
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
  public void getTranscriptEntryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TranscriptEntryName name =
          TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]");
      client.getTranscriptEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTranscriptEntryTest2() throws Exception {
    TranscriptEntry expectedResponse =
        TranscriptEntry.newBuilder()
            .setName(
                TranscriptEntryName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]", "[ENTRY]").toString())
            .setParticipant(ParticipantName.of("[CONFERENCE_RECORD]", "[PARTICIPANT]").toString())
            .setText("text3556653")
            .setLanguageCode("languageCode-2092349083")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "conferenceRecords/conferenceRecord-4037/transcripts/transcript-4037/entries/entrie-4037";

    TranscriptEntry actualResponse = client.getTranscriptEntry(name);
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
  public void getTranscriptEntryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "conferenceRecords/conferenceRecord-4037/transcripts/transcript-4037/entries/entrie-4037";
      client.getTranscriptEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTranscriptEntriesTest() throws Exception {
    TranscriptEntry responsesElement = TranscriptEntry.newBuilder().build();
    ListTranscriptEntriesResponse expectedResponse =
        ListTranscriptEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTranscriptEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    TranscriptName parent = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");

    ListTranscriptEntriesPagedResponse pagedListResponse = client.listTranscriptEntries(parent);

    List<TranscriptEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTranscriptEntriesList().get(0), resources.get(0));

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
  public void listTranscriptEntriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TranscriptName parent = TranscriptName.of("[CONFERENCE_RECORD]", "[TRANSCRIPT]");
      client.listTranscriptEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTranscriptEntriesTest2() throws Exception {
    TranscriptEntry responsesElement = TranscriptEntry.newBuilder().build();
    ListTranscriptEntriesResponse expectedResponse =
        ListTranscriptEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTranscriptEntries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "conferenceRecords/conferenceRecord-976/transcripts/transcript-976";

    ListTranscriptEntriesPagedResponse pagedListResponse = client.listTranscriptEntries(parent);

    List<TranscriptEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTranscriptEntriesList().get(0), resources.get(0));

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
  public void listTranscriptEntriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "conferenceRecords/conferenceRecord-976/transcripts/transcript-976";
      client.listTranscriptEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
