/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.asset.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1beta1.ExportAssetsRequest;
import com.google.cloud.asset.v1beta1.ExportAssetsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Asset API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 *
 * @deprecated The v1beta1 endpoint was turned down 2020-09-28.
 */
@Deprecated
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class AssetServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAssetsOperationCallable()");
  }

  public UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAssetsCallable()");
  }

  public UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetAssetsHistoryCallable()");
  }

  @Override
  public abstract void close();
}
