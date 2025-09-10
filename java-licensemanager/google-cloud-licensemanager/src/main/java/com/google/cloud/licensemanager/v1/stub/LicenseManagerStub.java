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

package com.google.cloud.licensemanager.v1.stub;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.licensemanager.v1.AggregateUsageRequest;
import com.google.cloud.licensemanager.v1.AggregateUsageResponse;
import com.google.cloud.licensemanager.v1.Configuration;
import com.google.cloud.licensemanager.v1.CreateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeleteConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetInstanceRequest;
import com.google.cloud.licensemanager.v1.GetProductRequest;
import com.google.cloud.licensemanager.v1.Instance;
import com.google.cloud.licensemanager.v1.ListConfigurationsRequest;
import com.google.cloud.licensemanager.v1.ListConfigurationsResponse;
import com.google.cloud.licensemanager.v1.ListInstancesRequest;
import com.google.cloud.licensemanager.v1.ListInstancesResponse;
import com.google.cloud.licensemanager.v1.ListProductsRequest;
import com.google.cloud.licensemanager.v1.ListProductsResponse;
import com.google.cloud.licensemanager.v1.OperationMetadata;
import com.google.cloud.licensemanager.v1.Product;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse;
import com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.UpdateConfigurationRequest;
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
 * Base stub class for the LicenseManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LicenseManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConfigurationsPagedCallable()");
  }

  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConfigurationsCallable()");
  }

  public UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: getConfigurationCallable()");
  }

  public OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConfigurationOperationCallable()");
  }

  public UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConfigurationCallable()");
  }

  public OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConfigurationOperationCallable()");
  }

  public UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConfigurationCallable()");
  }

  public OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConfigurationOperationCallable()");
  }

  public UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConfigurationCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deactivateConfigurationOperationCallable()");
  }

  public UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: deactivateConfigurationCallable()");
  }

  public OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: reactivateConfigurationOperationCallable()");
  }

  public UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable() {
    throw new UnsupportedOperationException("Not implemented: reactivateConfigurationCallable()");
  }

  public UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryConfigurationLicenseUsageCallable()");
  }

  public UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateUsagePagedCallable()");
  }

  public UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> aggregateUsageCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateUsageCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsPagedCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsCallable()");
  }

  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductCallable()");
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
