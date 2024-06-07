/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.AcceptTermsRequest;
import com.google.cloud.retail.v2alpha.AlertConfig;
import com.google.cloud.retail.v2alpha.EnrollSolutionMetadata;
import com.google.cloud.retail.v2alpha.EnrollSolutionRequest;
import com.google.cloud.retail.v2alpha.EnrollSolutionResponse;
import com.google.cloud.retail.v2alpha.GetAlertConfigRequest;
import com.google.cloud.retail.v2alpha.GetLoggingConfigRequest;
import com.google.cloud.retail.v2alpha.GetProjectRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse;
import com.google.cloud.retail.v2alpha.LoggingConfig;
import com.google.cloud.retail.v2alpha.Project;
import com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest;
import com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ProjectServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: getProjectCallable()");
  }

  public UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable() {
    throw new UnsupportedOperationException("Not implemented: acceptTermsCallable()");
  }

  public OperationCallable<EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: enrollSolutionOperationCallable()");
  }

  public UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable() {
    throw new UnsupportedOperationException("Not implemented: enrollSolutionCallable()");
  }

  public UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnrolledSolutionsCallable()");
  }

  public UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getLoggingConfigCallable()");
  }

  public UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig> updateLoggingConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLoggingConfigCallable()");
  }

  public UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAlertConfigCallable()");
  }

  public UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAlertConfigCallable()");
  }

  @Override
  public abstract void close();
}
