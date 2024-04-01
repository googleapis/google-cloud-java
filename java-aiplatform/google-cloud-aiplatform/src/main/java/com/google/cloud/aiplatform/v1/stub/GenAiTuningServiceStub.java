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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.GenAiTuningServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.GenAiTuningServiceClient.ListTuningJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CancelTuningJobRequest;
import com.google.cloud.aiplatform.v1.CreateTuningJobRequest;
import com.google.cloud.aiplatform.v1.GetTuningJobRequest;
import com.google.cloud.aiplatform.v1.ListTuningJobsRequest;
import com.google.cloud.aiplatform.v1.ListTuningJobsResponse;
import com.google.cloud.aiplatform.v1.TuningJob;
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
 * Base stub class for the GenAiTuningService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GenAiTuningServiceStub implements BackgroundResource {

  public UnaryCallable<CreateTuningJobRequest, TuningJob> createTuningJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createTuningJobCallable()");
  }

  public UnaryCallable<GetTuningJobRequest, TuningJob> getTuningJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getTuningJobCallable()");
  }

  public UnaryCallable<ListTuningJobsRequest, ListTuningJobsPagedResponse>
      listTuningJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTuningJobsPagedCallable()");
  }

  public UnaryCallable<ListTuningJobsRequest, ListTuningJobsResponse> listTuningJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTuningJobsCallable()");
  }

  public UnaryCallable<CancelTuningJobRequest, Empty> cancelTuningJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelTuningJobCallable()");
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
