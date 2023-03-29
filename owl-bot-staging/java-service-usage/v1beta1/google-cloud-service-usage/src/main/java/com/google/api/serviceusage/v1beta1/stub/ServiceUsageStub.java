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

package com.google.api.serviceusage.v1beta1.stub;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric;
import com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DisableServiceRequest;
import com.google.api.serviceusage.v1beta1.EnableServiceRequest;
import com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest;
import com.google.api.serviceusage.v1beta1.GetServiceRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse;
import com.google.api.serviceusage.v1beta1.ListServicesRequest;
import com.google.api.serviceusage.v1beta1.ListServicesResponse;
import com.google.api.serviceusage.v1beta1.OperationMetadata;
import com.google.api.serviceusage.v1beta1.QuotaOverride;
import com.google.api.serviceusage.v1beta1.Service;
import com.google.api.serviceusage.v1beta1.ServiceIdentity;
import com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ServiceUsageStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  @Deprecated
  public OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: enableServiceCallable()");
  }

  @Deprecated
  public OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: disableServiceCallable()");
  }

  @Deprecated
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  @Deprecated
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  @Deprecated
  public OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchEnableServicesOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchEnableServicesCallable()");
  }

  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConsumerQuotaMetricsPagedCallable()");
  }

  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConsumerQuotaMetricsCallable()");
  }

  public UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: getConsumerQuotaMetricCallable()");
  }

  public UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable() {
    throw new UnsupportedOperationException("Not implemented: getConsumerQuotaLimitCallable()");
  }

  public OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAdminOverrideOperationCallable()");
  }

  public UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdminOverrideCallable()");
  }

  public OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAdminOverrideOperationCallable()");
  }

  public UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAdminOverrideCallable()");
  }

  public OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAdminOverrideOperationCallable()");
  }

  public UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAdminOverrideCallable()");
  }

  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdminOverridesPagedCallable()");
  }

  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdminOverridesCallable()");
  }

  public OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importAdminOverridesOperationCallable()");
  }

  public UnaryCallable<ImportAdminOverridesRequest, Operation> importAdminOverridesCallable() {
    throw new UnsupportedOperationException("Not implemented: importAdminOverridesCallable()");
  }

  public OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConsumerOverrideOperationCallable()");
  }

  public UnaryCallable<CreateConsumerOverrideRequest, Operation> createConsumerOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: createConsumerOverrideCallable()");
  }

  public OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConsumerOverrideOperationCallable()");
  }

  public UnaryCallable<UpdateConsumerOverrideRequest, Operation> updateConsumerOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConsumerOverrideCallable()");
  }

  public OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConsumerOverrideOperationCallable()");
  }

  public UnaryCallable<DeleteConsumerOverrideRequest, Operation> deleteConsumerOverrideCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConsumerOverrideCallable()");
  }

  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConsumerOverridesPagedCallable()");
  }

  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConsumerOverridesCallable()");
  }

  public OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importConsumerOverridesOperationCallable()");
  }

  public UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable() {
    throw new UnsupportedOperationException("Not implemented: importConsumerOverridesCallable()");
  }

  public OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateServiceIdentityOperationCallable()");
  }

  public UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable() {
    throw new UnsupportedOperationException("Not implemented: generateServiceIdentityCallable()");
  }

  @Override
  public abstract void close();
}
