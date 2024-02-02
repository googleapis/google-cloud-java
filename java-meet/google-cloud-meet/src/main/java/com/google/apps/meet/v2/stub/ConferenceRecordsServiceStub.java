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

package com.google.apps.meet.v2.stub;

import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListConferenceRecordsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantSessionsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListParticipantsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListRecordingsPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptEntriesPagedResponse;
import static com.google.apps.meet.v2.ConferenceRecordsServiceClient.ListTranscriptsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.ConferenceRecord;
import com.google.apps.meet.v2.GetConferenceRecordRequest;
import com.google.apps.meet.v2.GetParticipantRequest;
import com.google.apps.meet.v2.GetParticipantSessionRequest;
import com.google.apps.meet.v2.GetRecordingRequest;
import com.google.apps.meet.v2.GetTranscriptEntryRequest;
import com.google.apps.meet.v2.GetTranscriptRequest;
import com.google.apps.meet.v2.ListConferenceRecordsRequest;
import com.google.apps.meet.v2.ListConferenceRecordsResponse;
import com.google.apps.meet.v2.ListParticipantSessionsRequest;
import com.google.apps.meet.v2.ListParticipantSessionsResponse;
import com.google.apps.meet.v2.ListParticipantsRequest;
import com.google.apps.meet.v2.ListParticipantsResponse;
import com.google.apps.meet.v2.ListRecordingsRequest;
import com.google.apps.meet.v2.ListRecordingsResponse;
import com.google.apps.meet.v2.ListTranscriptEntriesRequest;
import com.google.apps.meet.v2.ListTranscriptEntriesResponse;
import com.google.apps.meet.v2.ListTranscriptsRequest;
import com.google.apps.meet.v2.ListTranscriptsResponse;
import com.google.apps.meet.v2.Participant;
import com.google.apps.meet.v2.ParticipantSession;
import com.google.apps.meet.v2.Recording;
import com.google.apps.meet.v2.Transcript;
import com.google.apps.meet.v2.TranscriptEntry;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConferenceRecordsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConferenceRecordsServiceStub implements BackgroundResource {

  public UnaryCallable<GetConferenceRecordRequest, ConferenceRecord> getConferenceRecordCallable() {
    throw new UnsupportedOperationException("Not implemented: getConferenceRecordCallable()");
  }

  public UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsPagedResponse>
      listConferenceRecordsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConferenceRecordsPagedCallable()");
  }

  public UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConferenceRecordsCallable()");
  }

  public UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable() {
    throw new UnsupportedOperationException("Not implemented: getParticipantCallable()");
  }

  public UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listParticipantsPagedCallable()");
  }

  public UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listParticipantsCallable()");
  }

  public UnaryCallable<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getParticipantSessionCallable()");
  }

  public UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsPagedResponse>
      listParticipantSessionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listParticipantSessionsPagedCallable()");
  }

  public UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listParticipantSessionsCallable()");
  }

  public UnaryCallable<GetRecordingRequest, Recording> getRecordingCallable() {
    throw new UnsupportedOperationException("Not implemented: getRecordingCallable()");
  }

  public UnaryCallable<ListRecordingsRequest, ListRecordingsPagedResponse>
      listRecordingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRecordingsPagedCallable()");
  }

  public UnaryCallable<ListRecordingsRequest, ListRecordingsResponse> listRecordingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRecordingsCallable()");
  }

  public UnaryCallable<GetTranscriptRequest, Transcript> getTranscriptCallable() {
    throw new UnsupportedOperationException("Not implemented: getTranscriptCallable()");
  }

  public UnaryCallable<ListTranscriptsRequest, ListTranscriptsPagedResponse>
      listTranscriptsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTranscriptsPagedCallable()");
  }

  public UnaryCallable<ListTranscriptsRequest, ListTranscriptsResponse> listTranscriptsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTranscriptsCallable()");
  }

  public UnaryCallable<GetTranscriptEntryRequest, TranscriptEntry> getTranscriptEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: getTranscriptEntryCallable()");
  }

  public UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTranscriptEntriesPagedCallable()");
  }

  public UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTranscriptEntriesCallable()");
  }

  @Override
  public abstract void close();
}
