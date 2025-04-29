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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.EncryptionConfig;
import com.google.cloud.dataplex.v1.GetEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest;
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
 * Base stub class for the CmekService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CmekServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEncryptionConfigOperationCallable()");
  }

  public UnaryCallable<CreateEncryptionConfigRequest, Operation> createEncryptionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createEncryptionConfigCallable()");
  }

  public OperationCallable<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEncryptionConfigOperationCallable()");
  }

  public UnaryCallable<UpdateEncryptionConfigRequest, Operation> updateEncryptionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEncryptionConfigCallable()");
  }

  public OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEncryptionConfigOperationCallable()");
  }

  public UnaryCallable<DeleteEncryptionConfigRequest, Operation> deleteEncryptionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEncryptionConfigCallable()");
  }

  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEncryptionConfigsPagedCallable()");
  }

  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEncryptionConfigsCallable()");
  }

  public UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig> getEncryptionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getEncryptionConfigCallable()");
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
