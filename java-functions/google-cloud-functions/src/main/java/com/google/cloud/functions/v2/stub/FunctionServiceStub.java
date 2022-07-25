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

package com.google.cloud.functions.v2.stub;

import static com.google.cloud.functions.v2.FunctionServiceClient.ListFunctionsPagedResponse;
import static com.google.cloud.functions.v2.FunctionServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v2.CreateFunctionRequest;
import com.google.cloud.functions.v2.DeleteFunctionRequest;
import com.google.cloud.functions.v2.Function;
import com.google.cloud.functions.v2.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v2.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v2.GenerateUploadUrlRequest;
import com.google.cloud.functions.v2.GenerateUploadUrlResponse;
import com.google.cloud.functions.v2.GetFunctionRequest;
import com.google.cloud.functions.v2.ListFunctionsRequest;
import com.google.cloud.functions.v2.ListFunctionsResponse;
import com.google.cloud.functions.v2.ListRuntimesRequest;
import com.google.cloud.functions.v2.ListRuntimesResponse;
import com.google.cloud.functions.v2.OperationMetadata;
import com.google.cloud.functions.v2.UpdateFunctionRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FunctionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FunctionServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetFunctionRequest, Function> getFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: getFunctionCallable()");
  }

  public UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFunctionsPagedCallable()");
  }

  public UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFunctionsCallable()");
  }

  public OperationCallable<CreateFunctionRequest, Function, OperationMetadata>
      createFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFunctionOperationCallable()");
  }

  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: createFunctionCallable()");
  }

  public OperationCallable<UpdateFunctionRequest, Function, OperationMetadata>
      updateFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFunctionOperationCallable()");
  }

  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFunctionCallable()");
  }

  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadata>
      deleteFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFunctionOperationCallable()");
  }

  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFunctionCallable()");
  }

  public UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    throw new UnsupportedOperationException("Not implemented: generateUploadUrlCallable()");
  }

  public UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    throw new UnsupportedOperationException("Not implemented: generateDownloadUrlCallable()");
  }

  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimesCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
