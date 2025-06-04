/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.UserLicenseServiceClient.ListUserLicensesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesMetadata;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesResponse;
import com.google.cloud.discoveryengine.v1.ListUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.ListUserLicensesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class UserLicenseServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListUserLicensesRequest, ListUserLicensesPagedResponse>
      listUserLicensesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserLicensesPagedCallable()");
  }

  public UnaryCallable<ListUserLicensesRequest, ListUserLicensesResponse>
      listUserLicensesCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserLicensesCallable()");
  }

  public OperationCallable<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateUserLicensesOperationCallable()");
  }

  public UnaryCallable<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateUserLicensesCallable()");
  }

  @Override
  public abstract void close();
}
