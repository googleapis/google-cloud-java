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
import com.google.cloud.sql.v1beta4.SqlSslCertsDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsGetRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsInsertRequest;
import com.google.cloud.sql.v1beta4.SqlSslCertsListRequest;
import com.google.cloud.sql.v1beta4.SslCert;
import com.google.cloud.sql.v1beta4.SslCertsInsertResponse;
import com.google.cloud.sql.v1beta4.SslCertsListResponse;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SqlSslCertsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SqlSslCertsServiceStub implements BackgroundResource {

  public UnaryCallable<SqlSslCertsDeleteRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<SqlSslCertsGetRequest, SslCert> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<SqlSslCertsInsertRequest, SslCertsInsertResponse> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<SqlSslCertsListRequest, SslCertsListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
