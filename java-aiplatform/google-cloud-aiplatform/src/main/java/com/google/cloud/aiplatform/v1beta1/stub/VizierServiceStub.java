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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListStudiesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListTrialsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AddTrialMeasurementRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateMetatdata;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateResponse;
import com.google.cloud.aiplatform.v1beta1.CompleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.CreateStudyRequest;
import com.google.cloud.aiplatform.v1beta1.CreateTrialRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteStudyRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.GetStudyRequest;
import com.google.cloud.aiplatform.v1beta1.GetTrialRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.ListStudiesRequest;
import com.google.cloud.aiplatform.v1beta1.ListStudiesResponse;
import com.google.cloud.aiplatform.v1beta1.ListTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.LookupStudyRequest;
import com.google.cloud.aiplatform.v1beta1.StopTrialRequest;
import com.google.cloud.aiplatform.v1beta1.Study;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsMetadata;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.Trial;
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
 * Base stub class for the VizierService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class VizierServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateStudyRequest, Study> createStudyCallable() {
    throw new UnsupportedOperationException("Not implemented: createStudyCallable()");
  }

  public UnaryCallable<GetStudyRequest, Study> getStudyCallable() {
    throw new UnsupportedOperationException("Not implemented: getStudyCallable()");
  }

  public UnaryCallable<ListStudiesRequest, ListStudiesPagedResponse> listStudiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listStudiesPagedCallable()");
  }

  public UnaryCallable<ListStudiesRequest, ListStudiesResponse> listStudiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listStudiesCallable()");
  }

  public UnaryCallable<DeleteStudyRequest, Empty> deleteStudyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStudyCallable()");
  }

  public UnaryCallable<LookupStudyRequest, Study> lookupStudyCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupStudyCallable()");
  }

  public OperationCallable<SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: suggestTrialsOperationCallable()");
  }

  public UnaryCallable<SuggestTrialsRequest, Operation> suggestTrialsCallable() {
    throw new UnsupportedOperationException("Not implemented: suggestTrialsCallable()");
  }

  public UnaryCallable<CreateTrialRequest, Trial> createTrialCallable() {
    throw new UnsupportedOperationException("Not implemented: createTrialCallable()");
  }

  public UnaryCallable<GetTrialRequest, Trial> getTrialCallable() {
    throw new UnsupportedOperationException("Not implemented: getTrialCallable()");
  }

  public UnaryCallable<ListTrialsRequest, ListTrialsPagedResponse> listTrialsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTrialsPagedCallable()");
  }

  public UnaryCallable<ListTrialsRequest, ListTrialsResponse> listTrialsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTrialsCallable()");
  }

  public UnaryCallable<AddTrialMeasurementRequest, Trial> addTrialMeasurementCallable() {
    throw new UnsupportedOperationException("Not implemented: addTrialMeasurementCallable()");
  }

  public UnaryCallable<CompleteTrialRequest, Trial> completeTrialCallable() {
    throw new UnsupportedOperationException("Not implemented: completeTrialCallable()");
  }

  public UnaryCallable<DeleteTrialRequest, Empty> deleteTrialCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTrialCallable()");
  }

  public OperationCallable<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: checkTrialEarlyStoppingStateOperationCallable()");
  }

  public UnaryCallable<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: checkTrialEarlyStoppingStateCallable()");
  }

  public UnaryCallable<StopTrialRequest, Trial> stopTrialCallable() {
    throw new UnsupportedOperationException("Not implemented: stopTrialCallable()");
  }

  public UnaryCallable<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOptimalTrialsCallable()");
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
