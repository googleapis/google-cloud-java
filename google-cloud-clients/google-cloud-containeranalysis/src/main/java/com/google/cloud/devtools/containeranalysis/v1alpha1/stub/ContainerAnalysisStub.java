/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1alpha1.stub;

import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListOccurrencesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.containeranalysis.v1alpha1.CreateNoteRequest;
import com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.DeleteNoteRequest;
import com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.ListNotesRequest;
import com.google.containeranalysis.v1alpha1.ListNotesResponse;
import com.google.containeranalysis.v1alpha1.ListOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.Note;
import com.google.containeranalysis.v1alpha1.Occurrence;
import com.google.containeranalysis.v1alpha1.UpdateNoteRequest;
import com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Container Analysis API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ContainerAnalysisStub implements BackgroundResource {

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

  public UnaryCallable<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummaryCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getVulnzOccurrencesSummaryCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
