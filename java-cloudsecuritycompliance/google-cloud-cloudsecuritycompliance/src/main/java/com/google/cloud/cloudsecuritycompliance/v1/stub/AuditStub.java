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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListFrameworkAuditsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Audit service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AuditStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateFrameworkAuditScopeReportCallable()");
  }

  public OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFrameworkAuditOperationCallable()");
  }

  public UnaryCallable<CreateFrameworkAuditRequest, Operation> createFrameworkAuditCallable() {
    throw new UnsupportedOperationException("Not implemented: createFrameworkAuditCallable()");
  }

  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFrameworkAuditsPagedCallable()");
  }

  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFrameworkAuditsCallable()");
  }

  public UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable() {
    throw new UnsupportedOperationException("Not implemented: getFrameworkAuditCallable()");
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
