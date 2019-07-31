/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Arrays;
import java.util.List;

/**
 * Convenience class for executing Data Definition Language statements on transactions that support
 * DDL statements, i.e. DdlBatchTransaction and SingleUseTransaction.
 */
class DdlClient {
  private final DatabaseAdminClient dbAdminClient;
  private final String instanceId;
  private final String databaseName;

  static class Builder {
    private DatabaseAdminClient dbAdminClient;
    private String instanceId;
    private String databaseName;

    private Builder() {}

    Builder setDatabaseAdminClient(DatabaseAdminClient client) {
      Preconditions.checkNotNull(client);
      this.dbAdminClient = client;
      return this;
    }

    Builder setInstanceId(String instanceId) {
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(instanceId), "Empty instanceId is not allowed");
      this.instanceId = instanceId;
      return this;
    }

    Builder setDatabaseName(String name) {
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(name), "Empty database name is not allowed");
      this.databaseName = name;
      return this;
    }

    DdlClient build() {
      Preconditions.checkState(dbAdminClient != null, "No DatabaseAdminClient specified");
      Preconditions.checkState(!Strings.isNullOrEmpty(instanceId), "No InstanceId specified");
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(databaseName), "No database name specified");
      return new DdlClient(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private DdlClient(Builder builder) {
    this.dbAdminClient = builder.dbAdminClient;
    this.instanceId = builder.instanceId;
    this.databaseName = builder.databaseName;
  }

  /** Execute a single DDL statement. */
  OperationFuture<Void, UpdateDatabaseDdlMetadata> executeDdl(String ddl) {
    return executeDdl(Arrays.asList(ddl));
  }

  /** Execute a list of DDL statements as one operation. */
  OperationFuture<Void, UpdateDatabaseDdlMetadata> executeDdl(List<String> statements) {
    return dbAdminClient.updateDatabaseDdl(instanceId, databaseName, statements, null);
  }
}
