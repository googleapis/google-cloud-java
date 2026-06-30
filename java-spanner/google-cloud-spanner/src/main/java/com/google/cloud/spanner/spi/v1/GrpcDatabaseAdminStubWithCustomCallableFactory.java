/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.cloud.spanner.admin.database.v1.stub.GrpcDatabaseAdminStub;
import java.io.IOException;

/**
 * Wrapper around {@link GrpcDatabaseAdminStub} to make the constructor available inside this
 * package. This makes it possible to create a {@link GrpcDatabaseAdminStub} with a custom {@link
 * GrpcStubCallableFactory} and custom settings. This is used by integration tests to automatically
 * retry {@link StatusCode.Code#RESOURCE_EXHAUSTED} errors for certain administrative requests.
 */
class GrpcDatabaseAdminStubWithCustomCallableFactory extends GrpcDatabaseAdminStub {
  GrpcDatabaseAdminStubWithCustomCallableFactory(
      DatabaseAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    super(settings, clientContext, callableFactory);
  }
}
