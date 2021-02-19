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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCasesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.BatchDeleteTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageRequest;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageResponse;
import com.google.cloud.dialogflow.cx.v3.CreateTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.GetTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseMetadata;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseResponse;
import com.google.cloud.dialogflow.cx.v3.TestCase;
import com.google.cloud.dialogflow.cx.v3.UpdateTestCaseRequest;
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
@Generated("by gapic-generator-java")
public abstract class TestCasesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
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

  @Override
  public abstract void close();
}
