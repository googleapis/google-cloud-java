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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.BatchRunProcessRequest;
import com.google.cloud.visionai.v1.BatchRunProcessResponse;
import com.google.cloud.visionai.v1.CreateAnalysisRequest;
import com.google.cloud.visionai.v1.CreateOperatorRequest;
import com.google.cloud.visionai.v1.CreateProcessRequest;
import com.google.cloud.visionai.v1.DeleteAnalysisRequest;
import com.google.cloud.visionai.v1.DeleteOperatorRequest;
import com.google.cloud.visionai.v1.DeleteProcessRequest;
import com.google.cloud.visionai.v1.GetAnalysisRequest;
import com.google.cloud.visionai.v1.GetOperatorRequest;
import com.google.cloud.visionai.v1.GetProcessRequest;
import com.google.cloud.visionai.v1.ListAnalysesRequest;
import com.google.cloud.visionai.v1.ListAnalysesResponse;
import com.google.cloud.visionai.v1.ListOperatorsRequest;
import com.google.cloud.visionai.v1.ListOperatorsResponse;
import com.google.cloud.visionai.v1.ListProcessesRequest;
import com.google.cloud.visionai.v1.ListProcessesResponse;
import com.google.cloud.visionai.v1.ListPublicOperatorsRequest;
import com.google.cloud.visionai.v1.ListPublicOperatorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Operator;
import com.google.cloud.visionai.v1.Process;
import com.google.cloud.visionai.v1.ResolveOperatorInfoRequest;
import com.google.cloud.visionai.v1.ResolveOperatorInfoResponse;
import com.google.cloud.visionai.v1.UpdateAnalysisRequest;
import com.google.cloud.visionai.v1.UpdateOperatorRequest;
import com.google.cloud.visionai.v1.UpdateProcessRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LiveVideoAnalytics service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LiveVideoAnalyticsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublicOperatorsPagedCallable()");
  }

  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublicOperatorsCallable()");
  }

  public UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: resolveOperatorInfoCallable()");
  }

  public UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOperatorsPagedCallable()");
  }

  public UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOperatorsCallable()");
  }

  public UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable() {
    throw new UnsupportedOperationException("Not implemented: getOperatorCallable()");
  }

  public OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createOperatorOperationCallable()");
  }

  public UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable() {
    throw new UnsupportedOperationException("Not implemented: createOperatorCallable()");
  }

  public OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperatorOperationCallable()");
  }

  public UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperatorCallable()");
  }

  public OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperatorOperationCallable()");
  }

  public UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperatorCallable()");
  }

  public UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse> listAnalysesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysesPagedCallable()");
  }

  public UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysesCallable()");
  }

  public UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnalysisCallable()");
  }

  public OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnalysisOperationCallable()");
  }

  public UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnalysisCallable()");
  }

  public OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAnalysisOperationCallable()");
  }

  public UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAnalysisCallable()");
  }

  public OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAnalysisOperationCallable()");
  }

  public UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAnalysisCallable()");
  }

  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessesPagedCallable()");
  }

  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessesCallable()");
  }

  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: getProcessCallable()");
  }

  public OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessOperationCallable()");
  }

  public UnaryCallable<CreateProcessRequest, Operation> createProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessCallable()");
  }

  public OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProcessOperationCallable()");
  }

  public UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProcessCallable()");
  }

  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessOperationCallable()");
  }

  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessCallable()");
  }

  public OperationCallable<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRunProcessOperationCallable()");
  }

  public UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRunProcessCallable()");
  }

  @Override
  public abstract void close();
}
