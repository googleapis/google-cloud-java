/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4beta.stub;

import static com.google.devicesandservices.health.v4beta.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4beta.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4beta.DataPointsServiceClient.RollUpDataPointsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4beta.BatchDeleteDataPointsOperationMetadata;
import com.google.devicesandservices.health.v4beta.BatchDeleteDataPointsRequest;
import com.google.devicesandservices.health.v4beta.BatchDeleteDataPointsResponse;
import com.google.devicesandservices.health.v4beta.CreateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4beta.CreateDataPointRequest;
import com.google.devicesandservices.health.v4beta.DailyRollUpDataPointsRequest;
import com.google.devicesandservices.health.v4beta.DailyRollUpDataPointsResponse;
import com.google.devicesandservices.health.v4beta.DataPoint;
import com.google.devicesandservices.health.v4beta.ExportExerciseTcxRequest;
import com.google.devicesandservices.health.v4beta.ExportExerciseTcxResponse;
import com.google.devicesandservices.health.v4beta.GetDataPointRequest;
import com.google.devicesandservices.health.v4beta.ListDataPointsRequest;
import com.google.devicesandservices.health.v4beta.ListDataPointsResponse;
import com.google.devicesandservices.health.v4beta.ReconcileDataPointsRequest;
import com.google.devicesandservices.health.v4beta.ReconcileDataPointsResponse;
import com.google.devicesandservices.health.v4beta.RollUpDataPointsRequest;
import com.google.devicesandservices.health.v4beta.RollUpDataPointsResponse;
import com.google.devicesandservices.health.v4beta.UpdateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4beta.UpdateDataPointRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataPointsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataPointsServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataPointCallable()");
  }

  public UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataPointsPagedCallable()");
  }

  public UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> listDataPointsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataPointsCallable()");
  }

  public OperationCallable<CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataPointOperationCallable()");
  }

  public UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataPointCallable()");
  }

  public OperationCallable<UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataPointOperationCallable()");
  }

  public UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataPointCallable()");
  }

  public OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteDataPointsOperationCallable()");
  }

  public UnaryCallable<BatchDeleteDataPointsRequest, Operation> batchDeleteDataPointsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteDataPointsCallable()");
  }

  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: reconcileDataPointsPagedCallable()");
  }

  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable() {
    throw new UnsupportedOperationException("Not implemented: reconcileDataPointsCallable()");
  }

  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: rollUpDataPointsPagedCallable()");
  }

  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable() {
    throw new UnsupportedOperationException("Not implemented: rollUpDataPointsCallable()");
  }

  public UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable() {
    throw new UnsupportedOperationException("Not implemented: dailyRollUpDataPointsCallable()");
  }

  public UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable() {
    throw new UnsupportedOperationException("Not implemented: exportExerciseTcxCallable()");
  }

  @Override
  public abstract void close();
}
