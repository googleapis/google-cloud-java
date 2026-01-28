/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.auditmanager.v1.stub;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.auditmanager.v1.AuditReport;
import com.google.cloud.auditmanager.v1.AuditScopeReport;
import com.google.cloud.auditmanager.v1.EnrollResourceRequest;
import com.google.cloud.auditmanager.v1.Enrollment;
import com.google.cloud.auditmanager.v1.GenerateAuditReportRequest;
import com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest;
import com.google.cloud.auditmanager.v1.GetAuditReportRequest;
import com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsResponse;
import com.google.cloud.auditmanager.v1.ListControlsRequest;
import com.google.cloud.auditmanager.v1.ListControlsResponse;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse;
import com.google.cloud.auditmanager.v1.OperationMetadata;
import com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AuditManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AuditManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: enrollResourceCallable()");
  }

  public UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAuditScopeReportCallable()");
  }

  public OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAuditReportOperationCallable()");
  }

  public UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAuditReportCallable()");
  }

  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuditReportsPagedCallable()");
  }

  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuditReportsCallable()");
  }

  public UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuditReportCallable()");
  }

  public UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getResourceEnrollmentStatusCallable()");
  }

  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listResourceEnrollmentStatusesPagedCallable()");
  }

  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listResourceEnrollmentStatusesCallable()");
  }

  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listControlsPagedCallable()");
  }

  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    throw new UnsupportedOperationException("Not implemented: listControlsCallable()");
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
