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

package com.google.cloud.webrisk.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.SubmitUriMetadata;
import com.google.webrisk.v1.SubmitUriRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WebRiskService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WebRiskServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable() {
    throw new UnsupportedOperationException("Not implemented: computeThreatListDiffCallable()");
  }

  public UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable() {
    throw new UnsupportedOperationException("Not implemented: searchUrisCallable()");
  }

  public UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchHashesCallable()");
  }

  public UnaryCallable<CreateSubmissionRequest, Submission> createSubmissionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubmissionCallable()");
  }

  public OperationCallable<SubmitUriRequest, Submission, SubmitUriMetadata>
      submitUriOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: submitUriOperationCallable()");
  }

  public UnaryCallable<SubmitUriRequest, Operation> submitUriCallable() {
    throw new UnsupportedOperationException("Not implemented: submitUriCallable()");
  }

  @Override
  public abstract void close();
}
