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

package io.grafeas.v1.stub;

import static io.grafeas.v1.GrafeasClient.ListNoteOccurrencesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListNotesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListOccurrencesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import io.grafeas.v1.BatchCreateNotesRequest;
import io.grafeas.v1.BatchCreateNotesResponse;
import io.grafeas.v1.BatchCreateOccurrencesRequest;
import io.grafeas.v1.BatchCreateOccurrencesResponse;
import io.grafeas.v1.CreateNoteRequest;
import io.grafeas.v1.CreateOccurrenceRequest;
import io.grafeas.v1.DeleteNoteRequest;
import io.grafeas.v1.DeleteOccurrenceRequest;
import io.grafeas.v1.GetNoteRequest;
import io.grafeas.v1.GetOccurrenceNoteRequest;
import io.grafeas.v1.GetOccurrenceRequest;
import io.grafeas.v1.ListNoteOccurrencesRequest;
import io.grafeas.v1.ListNoteOccurrencesResponse;
import io.grafeas.v1.ListNotesRequest;
import io.grafeas.v1.ListNotesResponse;
import io.grafeas.v1.ListOccurrencesRequest;
import io.grafeas.v1.ListOccurrencesResponse;
import io.grafeas.v1.Note;
import io.grafeas.v1.Occurrence;
import io.grafeas.v1.UpdateNoteRequest;
import io.grafeas.v1.UpdateOccurrenceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Grafeas service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class GrafeasStub implements BackgroundResource {

  public UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    throw new UnsupportedOperationException("Not implemented: getOccurrenceCallable()");
  }

  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOccurrencesPagedCallable()");
  }

  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse> listOccurrencesCallable() {
    throw new UnsupportedOperationException("Not implemented: listOccurrencesCallable()");
  }

  public UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOccurrenceCallable()");
  }

  public UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    throw new UnsupportedOperationException("Not implemented: createOccurrenceCallable()");
  }

  public UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateOccurrencesCallable()");
  }

  public UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOccurrenceCallable()");
  }

  public UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    throw new UnsupportedOperationException("Not implemented: getOccurrenceNoteCallable()");
  }

  public UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    throw new UnsupportedOperationException("Not implemented: getNoteCallable()");
  }

  public UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotesPagedCallable()");
  }

  public UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotesCallable()");
  }

  public UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNoteCallable()");
  }

  public UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    throw new UnsupportedOperationException("Not implemented: createNoteCallable()");
  }

  public UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateNotesCallable()");
  }

  public UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNoteCallable()");
  }

  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNoteOccurrencesPagedCallable()");
  }

  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    throw new UnsupportedOperationException("Not implemented: listNoteOccurrencesCallable()");
  }

  @Override
  public abstract void close();
}
