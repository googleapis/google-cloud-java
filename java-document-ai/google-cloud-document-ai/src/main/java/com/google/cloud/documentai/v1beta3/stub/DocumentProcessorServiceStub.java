/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.BatchProcessMetadata;
import com.google.cloud.documentai.v1beta3.BatchProcessRequest;
import com.google.cloud.documentai.v1beta3.BatchProcessResponse;
import com.google.cloud.documentai.v1beta3.CreateProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DisableProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorResponse;
import com.google.cloud.documentai.v1beta3.EnableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.EnableProcessorRequest;
import com.google.cloud.documentai.v1beta3.EnableProcessorResponse;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorsResponse;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.Processor;
import com.google.cloud.documentai.v1beta3.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1beta3.ReviewDocumentRequest;
import com.google.cloud.documentai.v1beta3.ReviewDocumentResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DocumentProcessorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DocumentProcessorServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: processDocumentCallable()");
  }

  public OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchProcessDocumentsOperationCallable()");
  }

  public UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchProcessDocumentsCallable()");
  }

  public UnaryCallable<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchProcessorTypesCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsPagedCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsCallable()");
  }

  public UnaryCallable<CreateProcessorRequest, Processor> createProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessorCallable()");
  }

  public OperationCallable<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessorOperationCallable()");
  }

  public UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessorCallable()");
  }

  public OperationCallable<EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: enableProcessorOperationCallable()");
  }

  public UnaryCallable<EnableProcessorRequest, Operation> enableProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: enableProcessorCallable()");
  }

  public OperationCallable<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: disableProcessorOperationCallable()");
  }

  public UnaryCallable<DisableProcessorRequest, Operation> disableProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: disableProcessorCallable()");
  }

  public OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reviewDocumentOperationCallable()");
  }

  public UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: reviewDocumentCallable()");
  }

  @Override
  public abstract void close();
}
