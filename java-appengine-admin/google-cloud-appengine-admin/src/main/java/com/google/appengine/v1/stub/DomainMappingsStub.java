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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.CreateDomainMappingRequest;
import com.google.appengine.v1.DeleteDomainMappingRequest;
import com.google.appengine.v1.DomainMapping;
import com.google.appengine.v1.GetDomainMappingRequest;
import com.google.appengine.v1.ListDomainMappingsRequest;
import com.google.appengine.v1.ListDomainMappingsResponse;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.UpdateDomainMappingRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DomainMappings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DomainMappingsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsPagedResponse>
      listDomainMappingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDomainMappingsPagedCallable()");
  }

  public UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDomainMappingsCallable()");
  }

  public UnaryCallable<GetDomainMappingRequest, DomainMapping> getDomainMappingCallable() {
    throw new UnsupportedOperationException("Not implemented: getDomainMappingCallable()");
  }

  public OperationCallable<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDomainMappingOperationCallable()");
  }

  public UnaryCallable<CreateDomainMappingRequest, Operation> createDomainMappingCallable() {
    throw new UnsupportedOperationException("Not implemented: createDomainMappingCallable()");
  }

  public OperationCallable<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateDomainMappingOperationCallable()");
  }

  public UnaryCallable<UpdateDomainMappingRequest, Operation> updateDomainMappingCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDomainMappingCallable()");
  }

  public OperationCallable<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDomainMappingOperationCallable()");
  }

  public UnaryCallable<DeleteDomainMappingRequest, Operation> deleteDomainMappingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDomainMappingCallable()");
  }

  @Override
  public abstract void close();
}
