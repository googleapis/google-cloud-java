/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationMetadata;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for DLP API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public abstract class DlpServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    throw new UnsupportedOperationException("Not implemented: deidentifyContentCallable()");
  }

  public OperationCallable<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: analyzeDataSourceRiskOperationCallable()");
  }

  public UnaryCallable<AnalyzeDataSourceRiskRequest, Operation> analyzeDataSourceRiskCallable() {
    throw new UnsupportedOperationException("Not implemented: analyzeDataSourceRiskCallable()");
  }

  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    throw new UnsupportedOperationException("Not implemented: inspectContentCallable()");
  }

  public UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable() {
    throw new UnsupportedOperationException("Not implemented: redactContentCallable()");
  }

  public OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInspectOperationOperationCallable()");
  }

  public UnaryCallable<CreateInspectOperationRequest, Operation> createInspectOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInspectOperationCallable()");
  }

  public UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInspectFindingsCallable()");
  }

  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInfoTypesCallable()");
  }

  public UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRootCategoriesCallable()");
  }
}
