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

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.OperationsListResponse;
import com.google.cloud.sql.v1beta4.SqlOperationsCancelRequest;
import com.google.cloud.sql.v1beta4.SqlOperationsGetRequest;
import com.google.cloud.sql.v1beta4.SqlOperationsListRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SqlOperationsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SqlOperationsServiceStub implements BackgroundResource {

  public UnaryCallable<SqlOperationsGetRequest, Operation> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<SqlOperationsListRequest, OperationsListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<SqlOperationsCancelRequest, Empty> cancelCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCallable()");
  }

  @Override
  public abstract void close();
}
