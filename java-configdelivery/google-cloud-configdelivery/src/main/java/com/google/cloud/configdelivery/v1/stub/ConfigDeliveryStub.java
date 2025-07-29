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

package com.google.cloud.configdelivery.v1.stub;

import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListVariantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.configdelivery.v1.AbortRolloutRequest;
import com.google.cloud.configdelivery.v1.CreateFleetPackageRequest;
import com.google.cloud.configdelivery.v1.CreateReleaseRequest;
import com.google.cloud.configdelivery.v1.CreateResourceBundleRequest;
import com.google.cloud.configdelivery.v1.CreateVariantRequest;
import com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest;
import com.google.cloud.configdelivery.v1.DeleteReleaseRequest;
import com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest;
import com.google.cloud.configdelivery.v1.DeleteVariantRequest;
import com.google.cloud.configdelivery.v1.FleetPackage;
import com.google.cloud.configdelivery.v1.GetFleetPackageRequest;
import com.google.cloud.configdelivery.v1.GetReleaseRequest;
import com.google.cloud.configdelivery.v1.GetResourceBundleRequest;
import com.google.cloud.configdelivery.v1.GetRolloutRequest;
import com.google.cloud.configdelivery.v1.GetVariantRequest;
import com.google.cloud.configdelivery.v1.ListFleetPackagesRequest;
import com.google.cloud.configdelivery.v1.ListFleetPackagesResponse;
import com.google.cloud.configdelivery.v1.ListReleasesRequest;
import com.google.cloud.configdelivery.v1.ListReleasesResponse;
import com.google.cloud.configdelivery.v1.ListResourceBundlesRequest;
import com.google.cloud.configdelivery.v1.ListResourceBundlesResponse;
import com.google.cloud.configdelivery.v1.ListRolloutsRequest;
import com.google.cloud.configdelivery.v1.ListRolloutsResponse;
import com.google.cloud.configdelivery.v1.ListVariantsRequest;
import com.google.cloud.configdelivery.v1.ListVariantsResponse;
import com.google.cloud.configdelivery.v1.OperationMetadata;
import com.google.cloud.configdelivery.v1.Release;
import com.google.cloud.configdelivery.v1.ResourceBundle;
import com.google.cloud.configdelivery.v1.ResumeRolloutRequest;
import com.google.cloud.configdelivery.v1.Rollout;
import com.google.cloud.configdelivery.v1.SuspendRolloutRequest;
import com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest;
import com.google.cloud.configdelivery.v1.UpdateReleaseRequest;
import com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest;
import com.google.cloud.configdelivery.v1.UpdateVariantRequest;
import com.google.cloud.configdelivery.v1.Variant;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConfigDelivery service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConfigDeliveryStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourceBundlesPagedCallable()");
  }

  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable() {
    throw new UnsupportedOperationException("Not implemented: listResourceBundlesCallable()");
  }

  public UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable() {
    throw new UnsupportedOperationException("Not implemented: getResourceBundleCallable()");
  }

  public OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createResourceBundleOperationCallable()");
  }

  public UnaryCallable<CreateResourceBundleRequest, Operation> createResourceBundleCallable() {
    throw new UnsupportedOperationException("Not implemented: createResourceBundleCallable()");
  }

  public OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateResourceBundleOperationCallable()");
  }

  public UnaryCallable<UpdateResourceBundleRequest, Operation> updateResourceBundleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateResourceBundleCallable()");
  }

  public OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteResourceBundleOperationCallable()");
  }

  public UnaryCallable<DeleteResourceBundleRequest, Operation> deleteResourceBundleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteResourceBundleCallable()");
  }

  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFleetPackagesPagedCallable()");
  }

  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFleetPackagesCallable()");
  }

  public UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable() {
    throw new UnsupportedOperationException("Not implemented: getFleetPackageCallable()");
  }

  public OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFleetPackageOperationCallable()");
  }

  public UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable() {
    throw new UnsupportedOperationException("Not implemented: createFleetPackageCallable()");
  }

  public OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFleetPackageOperationCallable()");
  }

  public UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFleetPackageCallable()");
  }

  public OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFleetPackageOperationCallable()");
  }

  public UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFleetPackageCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesPagedCallable()");
  }

  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReleasesCallable()");
  }

  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getReleaseCallable()");
  }

  public OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseOperationCallable()");
  }

  public UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createReleaseCallable()");
  }

  public OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReleaseOperationCallable()");
  }

  public UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReleaseCallable()");
  }

  public OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReleaseOperationCallable()");
  }

  public UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReleaseCallable()");
  }

  public UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse> listVariantsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVariantsPagedCallable()");
  }

  public UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVariantsCallable()");
  }

  public UnaryCallable<GetVariantRequest, Variant> getVariantCallable() {
    throw new UnsupportedOperationException("Not implemented: getVariantCallable()");
  }

  public OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createVariantOperationCallable()");
  }

  public UnaryCallable<CreateVariantRequest, Operation> createVariantCallable() {
    throw new UnsupportedOperationException("Not implemented: createVariantCallable()");
  }

  public OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVariantOperationCallable()");
  }

  public UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVariantCallable()");
  }

  public OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVariantOperationCallable()");
  }

  public UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVariantCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsPagedCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRolloutsCallable()");
  }

  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: getRolloutCallable()");
  }

  public OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: suspendRolloutOperationCallable()");
  }

  public UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: suspendRolloutCallable()");
  }

  public OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeRolloutOperationCallable()");
  }

  public UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeRolloutCallable()");
  }

  public OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: abortRolloutOperationCallable()");
  }

  public UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: abortRolloutCallable()");
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

  @Override
  public abstract void close();
}
