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

import static com.google.cloud.sql.v1beta4.SqlBackupsServiceClient.ListBackupsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.Backup;
import com.google.cloud.sql.v1beta4.CreateBackupRequest;
import com.google.cloud.sql.v1beta4.DeleteBackupRequest;
import com.google.cloud.sql.v1beta4.GetBackupRequest;
import com.google.cloud.sql.v1beta4.ListBackupsRequest;
import com.google.cloud.sql.v1beta4.ListBackupsResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.UpdateBackupRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SqlBackupsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SqlBackupsServiceStub implements BackgroundResource {

  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupCallable()");
  }

  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsPagedCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsCallable()");
  }

  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  @Override
  public abstract void close();
}
