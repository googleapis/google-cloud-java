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

package com.google.cloud.metastore.v1beta.stub;

import static com.google.cloud.metastore.v1beta.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.metastore.v1beta.CreateFederationRequest;
import com.google.cloud.metastore.v1beta.DeleteFederationRequest;
import com.google.cloud.metastore.v1beta.Federation;
import com.google.cloud.metastore.v1beta.GetFederationRequest;
import com.google.cloud.metastore.v1beta.ListFederationsRequest;
import com.google.cloud.metastore.v1beta.ListFederationsResponse;
import com.google.cloud.metastore.v1beta.OperationMetadata;
import com.google.cloud.metastore.v1beta.UpdateFederationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataprocMetastoreFederation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataprocMetastoreFederationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFederationsPagedCallable()");
  }

  public UnaryCallable<ListFederationsRequest, ListFederationsResponse> listFederationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFederationsCallable()");
  }

  public UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: getFederationCallable()");
  }

  public OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFederationOperationCallable()");
  }

  public UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFederationCallable()");
  }

  public OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFederationOperationCallable()");
  }

  public UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFederationCallable()");
  }

  public OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFederationOperationCallable()");
  }

  public UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFederationCallable()");
  }

  @Override
  public abstract void close();
}
