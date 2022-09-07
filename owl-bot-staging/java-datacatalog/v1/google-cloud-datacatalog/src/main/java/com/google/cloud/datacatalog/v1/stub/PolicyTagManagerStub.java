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

package com.google.cloud.datacatalog.v1.stub;

import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.CreatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.CreateTaxonomyRequest;
import com.google.cloud.datacatalog.v1.DeletePolicyTagRequest;
import com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest;
import com.google.cloud.datacatalog.v1.GetPolicyTagRequest;
import com.google.cloud.datacatalog.v1.GetTaxonomyRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsResponse;
import com.google.cloud.datacatalog.v1.ListTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ListTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.PolicyTag;
import com.google.cloud.datacatalog.v1.Taxonomy;
import com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PolicyTagManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PolicyTagManagerStub implements BackgroundResource {

  public UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: createTaxonomyCallable()");
  }

  public UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTaxonomyCallable()");
  }

  public UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTaxonomyCallable()");
  }

  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTaxonomiesPagedCallable()");
  }

  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse> listTaxonomiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTaxonomiesCallable()");
  }

  public UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaxonomyCallable()");
  }

  public UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyTagCallable()");
  }

  public UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyTagCallable()");
  }

  public UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyTagCallable()");
  }

  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPolicyTagsPagedCallable()");
  }

  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse> listPolicyTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPolicyTagsCallable()");
  }

  public UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyTagCallable()");
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
