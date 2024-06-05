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

import static com.google.cloud.aiplatform.v1beta1.GenAiCacheServiceClient.ListCachedContentsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.GenAiCacheServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CachedContent;
import com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest;
import com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest;
import com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest;
import com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GenAiCacheService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GenAiCacheServiceStub implements BackgroundResource {

  public UnaryCallable<CreateCachedContentRequest, CachedContent> createCachedContentCallable() {
    throw new UnsupportedOperationException("Not implemented: createCachedContentCallable()");
  }

  public UnaryCallable<GetCachedContentRequest, CachedContent> getCachedContentCallable() {
    throw new UnsupportedOperationException("Not implemented: getCachedContentCallable()");
  }

  public UnaryCallable<UpdateCachedContentRequest, CachedContent> updateCachedContentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCachedContentCallable()");
  }

  public UnaryCallable<DeleteCachedContentRequest, Empty> deleteCachedContentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCachedContentCallable()");
  }

  public UnaryCallable<ListCachedContentsRequest, ListCachedContentsPagedResponse>
      listCachedContentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCachedContentsPagedCallable()");
  }

  public UnaryCallable<ListCachedContentsRequest, ListCachedContentsResponse>
      listCachedContentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCachedContentsCallable()");
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
