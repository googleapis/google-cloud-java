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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListExtensionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Extension;
import com.google.cloud.aiplatform.v1beta1.GetExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Base stub class for the ExtensionRegistryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ExtensionRegistryServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importExtensionOperationCallable()");
  }

  public UnaryCallable<ImportExtensionRequest, Operation> importExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: importExtensionCallable()");
  }

  public UnaryCallable<GetExtensionRequest, Extension> getExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExtensionCallable()");
  }

  public UnaryCallable<ListExtensionsRequest, ListExtensionsPagedResponse>
      listExtensionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExtensionsPagedCallable()");
  }

  public UnaryCallable<ListExtensionsRequest, ListExtensionsResponse> listExtensionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExtensionsCallable()");
  }

  public UnaryCallable<UpdateExtensionRequest, Extension> updateExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExtensionCallable()");
  }

  public OperationCallable<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExtensionOperationCallable()");
  }

  public UnaryCallable<DeleteExtensionRequest, Operation> deleteExtensionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExtensionCallable()");
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
