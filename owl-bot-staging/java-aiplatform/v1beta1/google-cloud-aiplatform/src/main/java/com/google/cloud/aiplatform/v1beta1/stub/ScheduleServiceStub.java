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

import static com.google.cloud.aiplatform.v1beta1.ScheduleServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ScheduleServiceClient.ListSchedulesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateScheduleRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteScheduleRequest;
import com.google.cloud.aiplatform.v1beta1.GetScheduleRequest;
import com.google.cloud.aiplatform.v1beta1.ListSchedulesRequest;
import com.google.cloud.aiplatform.v1beta1.ListSchedulesResponse;
import com.google.cloud.aiplatform.v1beta1.PauseScheduleRequest;
import com.google.cloud.aiplatform.v1beta1.ResumeScheduleRequest;
import com.google.cloud.aiplatform.v1beta1.Schedule;
import com.google.cloud.aiplatform.v1beta1.UpdateScheduleRequest;
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
 * Base stub class for the ScheduleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ScheduleServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateScheduleRequest, Schedule> createScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: createScheduleCallable()");
  }

  public OperationCallable<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
      deleteScheduleOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScheduleOperationCallable()");
  }

  public UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScheduleCallable()");
  }

  public UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: getScheduleCallable()");
  }

  public UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchedulesPagedCallable()");
  }

  public UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchedulesCallable()");
  }

  public UnaryCallable<PauseScheduleRequest, Empty> pauseScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseScheduleCallable()");
  }

  public UnaryCallable<ResumeScheduleRequest, Empty> resumeScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeScheduleCallable()");
  }

  public UnaryCallable<UpdateScheduleRequest, Schedule> updateScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScheduleCallable()");
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
