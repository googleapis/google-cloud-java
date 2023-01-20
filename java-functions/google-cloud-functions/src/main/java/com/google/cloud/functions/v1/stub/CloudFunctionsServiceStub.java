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

package com.google.cloud.functions.v1.stub;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunction;
import com.google.cloud.functions.v1.CreateFunctionRequest;
import com.google.cloud.functions.v1.DeleteFunctionRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v1.GenerateUploadUrlRequest;
import com.google.cloud.functions.v1.GenerateUploadUrlResponse;
import com.google.cloud.functions.v1.GetFunctionRequest;
import com.google.cloud.functions.v1.ListFunctionsRequest;
import com.google.cloud.functions.v1.ListFunctionsResponse;
import com.google.cloud.functions.v1.OperationMetadataV1;
import com.google.cloud.functions.v1.UpdateFunctionRequest;
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
 * Base stub class for the CloudFunctionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudFunctionsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListFunctionsRequest, ListFunctionsPagedResponse>
      listFunctionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFunctionsPagedCallable()");
  }

  public UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> listFunctionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFunctionsCallable()");
  }

  public UnaryCallable<GetFunctionRequest, CloudFunction> getFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: getFunctionCallable()");
  }

  public OperationCallable<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFunctionOperationCallable()");
  }

  public UnaryCallable<CreateFunctionRequest, Operation> createFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: createFunctionCallable()");
  }

  public OperationCallable<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFunctionOperationCallable()");
  }

  public UnaryCallable<UpdateFunctionRequest, Operation> updateFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFunctionCallable()");
  }

  public OperationCallable<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFunctionOperationCallable()");
  }

  public UnaryCallable<DeleteFunctionRequest, Operation> deleteFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFunctionCallable()");
  }

  public UnaryCallable<CallFunctionRequest, CallFunctionResponse> callFunctionCallable() {
    throw new UnsupportedOperationException("Not implemented: callFunctionCallable()");
  }

  public UnaryCallable<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlCallable() {
    throw new UnsupportedOperationException("Not implemented: generateUploadUrlCallable()");
  }

  public UnaryCallable<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlCallable() {
    throw new UnsupportedOperationException("Not implemented: generateDownloadUrlCallable()");
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
