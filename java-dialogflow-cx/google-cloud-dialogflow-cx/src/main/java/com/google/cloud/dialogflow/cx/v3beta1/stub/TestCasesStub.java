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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCasesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse;
import com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse;
import com.google.cloud.dialogflow.cx.v3beta1.TestCase;
import com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TestCases service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TestCasesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestCasesPagedCallable()");
  }

  public UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestCasesCallable()");
  }

  public UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteTestCasesCallable()");
  }

  public UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getTestCaseCallable()");
  }

  public UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createTestCaseCallable()");
  }

  public UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTestCaseCallable()");
  }

  public OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runTestCaseOperationCallable()");
  }

  public UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: runTestCaseCallable()");
  }

  public OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRunTestCasesOperationCallable()");
  }

  public UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRunTestCasesCallable()");
  }

  public UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable() {
    throw new UnsupportedOperationException("Not implemented: calculateCoverageCallable()");
  }

  public OperationCallable<ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importTestCasesOperationCallable()");
  }

  public UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: importTestCasesCallable()");
  }

  public OperationCallable<ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportTestCasesOperationCallable()");
  }

  public UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportTestCasesCallable()");
  }

  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestCaseResultsPagedCallable()");
  }

  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestCaseResultsCallable()");
  }

  public UnaryCallable<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getTestCaseResultCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
