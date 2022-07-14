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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.RealmsServiceClient.ListRealmsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1beta.CreateRealmRequest;
import com.google.cloud.gaming.v1beta.DeleteRealmRequest;
import com.google.cloud.gaming.v1beta.GetRealmRequest;
import com.google.cloud.gaming.v1beta.ListRealmsRequest;
import com.google.cloud.gaming.v1beta.ListRealmsResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
import com.google.cloud.gaming.v1beta.PreviewRealmUpdateRequest;
import com.google.cloud.gaming.v1beta.PreviewRealmUpdateResponse;
import com.google.cloud.gaming.v1beta.Realm;
import com.google.cloud.gaming.v1beta.UpdateRealmRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RealmsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class RealmsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmOperationCallable()");
  }

  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: createRealmCallable()");
  }

  public OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmOperationCallable()");
  }

  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRealmCallable()");
  }

  public OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmOperationCallable()");
  }

  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRealmCallable()");
  }

  public UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable() {
    throw new UnsupportedOperationException("Not implemented: previewRealmUpdateCallable()");
  }

  @Override
  public abstract void close();
}
