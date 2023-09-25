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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListDocumentsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsResponse;
import com.google.cloud.documentai.v1beta3.Dataset;
import com.google.cloud.documentai.v1beta3.DatasetSchema;
import com.google.cloud.documentai.v1beta3.GetDatasetSchemaRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentRequest;
import com.google.cloud.documentai.v1beta3.GetDocumentResponse;
import com.google.cloud.documentai.v1beta3.ImportDocumentsMetadata;
import com.google.cloud.documentai.v1beta3.ImportDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ImportDocumentsResponse;
import com.google.cloud.documentai.v1beta3.ListDocumentsRequest;
import com.google.cloud.documentai.v1beta3.ListDocumentsResponse;
import com.google.cloud.documentai.v1beta3.UpdateDatasetOperationMetadata;
import com.google.cloud.documentai.v1beta3.UpdateDatasetRequest;
import com.google.cloud.documentai.v1beta3.UpdateDatasetSchemaRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DocumentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DocumentServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<UpdateDatasetRequest, Dataset, UpdateDatasetOperationMetadata>
      updateDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetOperationCallable()");
  }

  public UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetCallable()");
  }

  public OperationCallable<ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importDocumentsOperationCallable()");
  }

  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: importDocumentsCallable()");
  }

  public UnaryCallable<GetDocumentRequest, GetDocumentResponse> getDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDocumentCallable()");
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentsPagedCallable()");
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentsCallable()");
  }

  public OperationCallable<
          BatchDeleteDocumentsRequest, BatchDeleteDocumentsResponse, BatchDeleteDocumentsMetadata>
      batchDeleteDocumentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteDocumentsOperationCallable()");
  }

  public UnaryCallable<BatchDeleteDocumentsRequest, Operation> batchDeleteDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteDocumentsCallable()");
  }

  public UnaryCallable<GetDatasetSchemaRequest, DatasetSchema> getDatasetSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetSchemaCallable()");
  }

  public UnaryCallable<UpdateDatasetSchemaRequest, DatasetSchema> updateDatasetSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetSchemaCallable()");
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
