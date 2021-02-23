/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.BatchMigrateResourcesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.BatchMigrateResourcesRequest;
import com.google.cloud.aiplatform.v1beta1.BatchMigrateResourcesResponse;
import com.google.cloud.aiplatform.v1beta1.SearchMigratableResourcesRequest;
import com.google.cloud.aiplatform.v1beta1.SearchMigratableResourcesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class MigrationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchMigratableResourcesPagedCallable()");
  }

  public UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
      searchMigratableResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchMigratableResourcesCallable()");
  }

  public OperationCallable<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchMigrateResourcesOperationCallable()");
  }

  public UnaryCallable<BatchMigrateResourcesRequest, Operation> batchMigrateResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchMigrateResourcesCallable()");
  }

  @Override
  public abstract void close();
}
