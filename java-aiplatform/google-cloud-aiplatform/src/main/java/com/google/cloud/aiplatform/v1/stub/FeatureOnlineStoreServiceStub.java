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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.FeatureViewDirectWriteRequest;
import com.google.cloud.aiplatform.v1.FeatureViewDirectWriteResponse;
import com.google.cloud.aiplatform.v1.FetchFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.FetchFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.SearchNearestEntitiesRequest;
import com.google.cloud.aiplatform.v1.SearchNearestEntitiesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FeatureOnlineStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FeatureOnlineStoreServiceStub implements BackgroundResource {

  public UnaryCallable<FetchFeatureValuesRequest, FetchFeatureValuesResponse>
      fetchFeatureValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchFeatureValuesCallable()");
  }

  public UnaryCallable<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>
      searchNearestEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchNearestEntitiesCallable()");
  }

  public BidiStreamingCallable<FeatureViewDirectWriteRequest, FeatureViewDirectWriteResponse>
      featureViewDirectWriteCallable() {
    throw new UnsupportedOperationException("Not implemented: featureViewDirectWriteCallable()");
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
