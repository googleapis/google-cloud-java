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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.DataStoreServiceClient.ListDataStoresPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateDataStoreMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateDataStoreRequest;
import com.google.cloud.discoveryengine.v1alpha.DataStore;
import com.google.cloud.discoveryengine.v1alpha.DeleteDataStoreMetadata;
import com.google.cloud.discoveryengine.v1alpha.DeleteDataStoreRequest;
import com.google.cloud.discoveryengine.v1alpha.DocumentProcessingConfig;
import com.google.cloud.discoveryengine.v1alpha.GetDataStoreRequest;
import com.google.cloud.discoveryengine.v1alpha.GetDocumentProcessingConfigRequest;
import com.google.cloud.discoveryengine.v1alpha.ListDataStoresRequest;
import com.google.cloud.discoveryengine.v1alpha.ListDataStoresResponse;
import com.google.cloud.discoveryengine.v1alpha.UpdateDataStoreRequest;
import com.google.cloud.discoveryengine.v1alpha.UpdateDocumentProcessingConfigRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataStoreServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataStoreOperationCallable()");
  }

  public UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataStoreCallable()");
  }

  public UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataStoreCallable()");
  }

  public UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataStoresPagedCallable()");
  }

  public UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> listDataStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataStoresCallable()");
  }

  public OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataStoreOperationCallable()");
  }

  public UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataStoreCallable()");
  }

  public UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataStoreCallable()");
  }

  public UnaryCallable<GetDocumentProcessingConfigRequest, DocumentProcessingConfig>
      getDocumentProcessingConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getDocumentProcessingConfigCallable()");
  }

  public UnaryCallable<UpdateDocumentProcessingConfigRequest, DocumentProcessingConfig>
      updateDocumentProcessingConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDocumentProcessingConfigCallable()");
  }

  @Override
  public abstract void close();
}
