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

package com.google.api.apikeys.v2.stub;

import static com.google.api.apikeys.v2.ApiKeysClient.ListKeysPagedResponse;

import com.google.api.apikeys.v2.CreateKeyRequest;
import com.google.api.apikeys.v2.DeleteKeyRequest;
import com.google.api.apikeys.v2.GetKeyRequest;
import com.google.api.apikeys.v2.GetKeyStringRequest;
import com.google.api.apikeys.v2.GetKeyStringResponse;
import com.google.api.apikeys.v2.Key;
import com.google.api.apikeys.v2.ListKeysRequest;
import com.google.api.apikeys.v2.ListKeysResponse;
import com.google.api.apikeys.v2.LookupKeyRequest;
import com.google.api.apikeys.v2.LookupKeyResponse;
import com.google.api.apikeys.v2.UndeleteKeyRequest;
import com.google.api.apikeys.v2.UpdateKeyRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiKeysStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateKeyRequest, Key, Empty> createKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createKeyOperationCallable()");
  }

  public UnaryCallable<CreateKeyRequest, Operation> createKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createKeyCallable()");
  }

  public UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeysPagedCallable()");
  }

  public UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeysCallable()");
  }

  public UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getKeyCallable()");
  }

  public UnaryCallable<GetKeyStringRequest, GetKeyStringResponse> getKeyStringCallable() {
    throw new UnsupportedOperationException("Not implemented: getKeyStringCallable()");
  }

  public OperationCallable<UpdateKeyRequest, Key, Empty> updateKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKeyOperationCallable()");
  }

  public UnaryCallable<UpdateKeyRequest, Operation> updateKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKeyCallable()");
  }

  public OperationCallable<DeleteKeyRequest, Key, Empty> deleteKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteKeyOperationCallable()");
  }

  public UnaryCallable<DeleteKeyRequest, Operation> deleteKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteKeyCallable()");
  }

  public OperationCallable<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteKeyOperationCallable()");
  }

  public UnaryCallable<UndeleteKeyRequest, Operation> undeleteKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteKeyCallable()");
  }

  public UnaryCallable<LookupKeyRequest, LookupKeyResponse> lookupKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupKeyCallable()");
  }

  @Override
  public abstract void close();
}
