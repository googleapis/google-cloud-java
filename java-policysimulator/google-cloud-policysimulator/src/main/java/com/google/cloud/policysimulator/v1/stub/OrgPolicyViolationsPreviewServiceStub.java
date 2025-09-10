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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewOperationMetadata;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OrgPolicyViolationsPreviewService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class OrgPolicyViolationsPreviewServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrgPolicyViolationsPreviewsPagedCallable()");
  }

  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrgPolicyViolationsPreviewsCallable()");
  }

  public UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getOrgPolicyViolationsPreviewCallable()");
  }

  public OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOrgPolicyViolationsPreviewOperationCallable()");
  }

  public UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOrgPolicyViolationsPreviewCallable()");
  }

  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrgPolicyViolationsPagedCallable()");
  }

  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrgPolicyViolationsCallable()");
  }

  @Override
  public abstract void close();
}
