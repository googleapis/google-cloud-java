/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.RealmsServiceClient.ListRealmsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CreateRealmRequest;
import com.google.cloud.gaming.v1alpha.DeleteRealmRequest;
import com.google.cloud.gaming.v1alpha.GetRealmRequest;
import com.google.cloud.gaming.v1alpha.ListRealmsRequest;
import com.google.cloud.gaming.v1alpha.ListRealmsResponse;
import com.google.cloud.gaming.v1alpha.Realm;
import com.google.cloud.gaming.v1alpha.UpdateRealmRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RealmsServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRealmsPagedCallable()");
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRealmsCallable()");
  }

  public UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: getRealmCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateRealmRequest, Realm, Empty> createRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmOperationCallable()");
  }

  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteRealmRequest, Empty, Empty> deleteRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmOperationCallable()");
  }

  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateRealmRequest, Realm, Empty> updateRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmOperationCallable()");
  }

  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmCallable()");
  }

  @Override
  public abstract void close();
}
