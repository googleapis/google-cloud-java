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

package com.google.cloud.bigquery.datapolicies.v1.stub;

import static com.google.cloud.bigquery.datapolicies.v1.DataPolicyServiceClient.ListDataPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datapolicies.v1.CreateDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1.DataPolicy;
import com.google.cloud.bigquery.datapolicies.v1.DeleteDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1.GetDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1.ListDataPoliciesRequest;
import com.google.cloud.bigquery.datapolicies.v1.ListDataPoliciesResponse;
import com.google.cloud.bigquery.datapolicies.v1.RenameDataPolicyRequest;
import com.google.cloud.bigquery.datapolicies.v1.UpdateDataPolicyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataPolicyServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDataPolicyRequest, DataPolicy> createDataPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataPolicyCallable()");
  }

  public UnaryCallable<UpdateDataPolicyRequest, DataPolicy> updateDataPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataPolicyCallable()");
  }

  public UnaryCallable<RenameDataPolicyRequest, DataPolicy> renameDataPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: renameDataPolicyCallable()");
  }

  public UnaryCallable<DeleteDataPolicyRequest, Empty> deleteDataPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataPolicyCallable()");
  }

  public UnaryCallable<GetDataPolicyRequest, DataPolicy> getDataPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataPolicyCallable()");
  }

  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesPagedResponse>
      listDataPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataPoliciesPagedCallable()");
  }

  public UnaryCallable<ListDataPoliciesRequest, ListDataPoliciesResponse>
      listDataPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataPoliciesCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
