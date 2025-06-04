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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CmekConfig;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.GetCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CmekConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CmekConfigServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCmekConfigOperationCallable()");
  }

  public UnaryCallable<UpdateCmekConfigRequest, Operation> updateCmekConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCmekConfigCallable()");
  }

  public UnaryCallable<GetCmekConfigRequest, CmekConfig> getCmekConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getCmekConfigCallable()");
  }

  public UnaryCallable<ListCmekConfigsRequest, ListCmekConfigsResponse> listCmekConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCmekConfigsCallable()");
  }

  public OperationCallable<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCmekConfigOperationCallable()");
  }

  public UnaryCallable<DeleteCmekConfigRequest, Operation> deleteCmekConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCmekConfigCallable()");
  }

  @Override
  public abstract void close();
}
