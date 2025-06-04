/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreMetadata;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.IdentityMappingEntryOperationMetadata;
import com.google.cloud.discoveryengine.v1.IdentityMappingStore;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IdentityMappingStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IdentityMappingStoreServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIdentityMappingStoreCallable()");
  }

  public UnaryCallable<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getIdentityMappingStoreCallable()");
  }

  public OperationCallable<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIdentityMappingStoreOperationCallable()");
  }

  public UnaryCallable<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIdentityMappingStoreCallable()");
  }

  public OperationCallable<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importIdentityMappingsOperationCallable()");
  }

  public UnaryCallable<ImportIdentityMappingsRequest, Operation> importIdentityMappingsCallable() {
    throw new UnsupportedOperationException("Not implemented: importIdentityMappingsCallable()");
  }

  public OperationCallable<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: purgeIdentityMappingsOperationCallable()");
  }

  public UnaryCallable<PurgeIdentityMappingsRequest, Operation> purgeIdentityMappingsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeIdentityMappingsCallable()");
  }

  public UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsPagedResponse>
      listIdentityMappingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIdentityMappingsPagedCallable()");
  }

  public UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIdentityMappingsCallable()");
  }

  public UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listIdentityMappingStoresPagedCallable()");
  }

  public UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listIdentityMappingStoresCallable()");
  }

  @Override
  public abstract void close();
}
