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

package com.google.apps.meet.v2beta;

import com.google.api.core.BetaApi;
import com.google.apps.meet.v2beta.ConferenceRecordsServiceGrpc.ConferenceRecordsServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockConferenceRecordsServiceImpl extends ConferenceRecordsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConferenceRecordsServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void getConferenceRecord(
      GetConferenceRecordRequest request, StreamObserver<ConferenceRecord> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConferenceRecord) {
      requests.add(request);
      responseObserver.onNext(((ConferenceRecord) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConferenceRecord, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConferenceRecord.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConferenceRecords(
      ListConferenceRecordsRequest request,
      StreamObserver<ListConferenceRecordsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConferenceRecordsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConferenceRecordsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConferenceRecords, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConferenceRecordsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getParticipant(
      GetParticipantRequest request, StreamObserver<Participant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Participant) {
      requests.add(request);
      responseObserver.onNext(((Participant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetParticipant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Participant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listParticipants(
      ListParticipantsRequest request, StreamObserver<ListParticipantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListParticipantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListParticipantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListParticipants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListParticipantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getParticipantSession(
      GetParticipantSessionRequest request, StreamObserver<ParticipantSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ParticipantSession) {
      requests.add(request);
      responseObserver.onNext(((ParticipantSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetParticipantSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ParticipantSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listParticipantSessions(
      ListParticipantSessionsRequest request,
      StreamObserver<ListParticipantSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListParticipantSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListParticipantSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListParticipantSessions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListParticipantSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRecording(
      GetRecordingRequest request, StreamObserver<Recording> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recording) {
      requests.add(request);
      responseObserver.onNext(((Recording) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRecording, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recording.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRecordings(
      ListRecordingsRequest request, StreamObserver<ListRecordingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRecordingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRecordingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRecordings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRecordingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTranscript(
      GetTranscriptRequest request, StreamObserver<Transcript> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Transcript) {
      requests.add(request);
      responseObserver.onNext(((Transcript) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTranscript, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Transcript.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTranscripts(
      ListTranscriptsRequest request, StreamObserver<ListTranscriptsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTranscriptsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTranscriptsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTranscripts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTranscriptsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTranscriptEntry(
      GetTranscriptEntryRequest request, StreamObserver<TranscriptEntry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TranscriptEntry) {
      requests.add(request);
      responseObserver.onNext(((TranscriptEntry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTranscriptEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TranscriptEntry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTranscriptEntries(
      ListTranscriptEntriesRequest request,
      StreamObserver<ListTranscriptEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTranscriptEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTranscriptEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTranscriptEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTranscriptEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
