/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1p4beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest;
import com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class AssetServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeIamPolicyCallable()");
  }

  public OperationCallable<
          ExportIamPolicyAnalysisRequest,
          ExportIamPolicyAnalysisResponse,
          ExportIamPolicyAnalysisRequest>
      exportIamPolicyAnalysisOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportIamPolicyAnalysisOperationCallable()");
  }

  public UnaryCallable<ExportIamPolicyAnalysisRequest, Operation>
      exportIamPolicyAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: exportIamPolicyAnalysisCallable()");
  }

  @Override
  public abstract void close();
}
