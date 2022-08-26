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

package com.google.cloud.documentai.v1.stub;

import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorTypesPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorVersionsPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1.BatchProcessMetadata;
import com.google.cloud.documentai.v1.BatchProcessRequest;
import com.google.cloud.documentai.v1.BatchProcessResponse;
import com.google.cloud.documentai.v1.CreateProcessorRequest;
import com.google.cloud.documentai.v1.DeleteProcessorMetadata;
import com.google.cloud.documentai.v1.DeleteProcessorRequest;
import com.google.cloud.documentai.v1.DeleteProcessorVersionMetadata;
import com.google.cloud.documentai.v1.DeleteProcessorVersionRequest;
import com.google.cloud.documentai.v1.DeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1.DeployProcessorVersionRequest;
import com.google.cloud.documentai.v1.DeployProcessorVersionResponse;
import com.google.cloud.documentai.v1.DisableProcessorMetadata;
import com.google.cloud.documentai.v1.DisableProcessorRequest;
import com.google.cloud.documentai.v1.DisableProcessorResponse;
import com.google.cloud.documentai.v1.EnableProcessorMetadata;
import com.google.cloud.documentai.v1.EnableProcessorRequest;
import com.google.cloud.documentai.v1.EnableProcessorResponse;
import com.google.cloud.documentai.v1.FetchProcessorTypesRequest;
import com.google.cloud.documentai.v1.FetchProcessorTypesResponse;
import com.google.cloud.documentai.v1.GetProcessorRequest;
import com.google.cloud.documentai.v1.GetProcessorVersionRequest;
import com.google.cloud.documentai.v1.ListProcessorTypesRequest;
import com.google.cloud.documentai.v1.ListProcessorTypesResponse;
import com.google.cloud.documentai.v1.ListProcessorVersionsRequest;
import com.google.cloud.documentai.v1.ListProcessorVersionsResponse;
import com.google.cloud.documentai.v1.ListProcessorsRequest;
import com.google.cloud.documentai.v1.ListProcessorsResponse;
import com.google.cloud.documentai.v1.ProcessRequest;
import com.google.cloud.documentai.v1.ProcessResponse;
import com.google.cloud.documentai.v1.Processor;
import com.google.cloud.documentai.v1.ProcessorVersion;
import com.google.cloud.documentai.v1.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1.ReviewDocumentRequest;
import com.google.cloud.documentai.v1.ReviewDocumentResponse;
import com.google.cloud.documentai.v1.SetDefaultProcessorVersionMetadata;
import com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest;
import com.google.cloud.documentai.v1.SetDefaultProcessorVersionResponse;
import com.google.cloud.documentai.v1.UndeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1.UndeployProcessorVersionRequest;
import com.google.cloud.documentai.v1.UndeployProcessorVersionResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
@Generated("by gapic-generator-java")
public abstract class DocumentProcessorServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesPagedResponse>
      listProcessorTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorTypesPagedCallable()");
  }

  public UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesResponse>
      listProcessorTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorTypesCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsPagedCallable()");
  }

  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorsCallable()");
  }

  public UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    throw new UnsupportedOperationException("Not implemented: getProcessorCallable()");
  }

  public UnaryCallable<GetProcessorVersionRequest, ProcessorVersion> getProcessorVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getProcessorVersionCallable()");
  }

  public UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsPagedResponse>
      listProcessorVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listProcessorVersionsPagedCallable()");
  }

  public UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
      listProcessorVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessorVersionsCallable()");
  }

  public OperationCallable<DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteProcessorVersionOperationCallable()");
  }

  public UnaryCallable<DeleteProcessorVersionRequest, Operation> deleteProcessorVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessorVersionCallable()");
  }

  public OperationCallable<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deployProcessorVersionOperationCallable()");
  }

  public UnaryCallable<DeployProcessorVersionRequest, Operation> deployProcessorVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deployProcessorVersionCallable()");
  }

  public OperationCallable<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeployProcessorVersionOperationCallable()");
  }

  public UnaryCallable<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployProcessorVersionCallable()");
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
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setDefaultProcessorVersionOperationCallable()");
  }

  public UnaryCallable<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setDefaultProcessorVersionCallable()");
  }

  public OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reviewDocumentOperationCallable()");
  }

  public UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: reviewDocumentCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
