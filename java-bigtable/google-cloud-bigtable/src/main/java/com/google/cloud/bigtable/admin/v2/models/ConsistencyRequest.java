/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.DataBoostReadLocalWrites;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.StandardReadRemoteWrites;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.TableAdminRequestContext;
import javax.annotation.Nonnull;

@AutoValue
public abstract class ConsistencyRequest {
  @Nonnull
  protected abstract String getTableId();

  @Nonnull
  protected abstract CheckConsistencyRequest.ModeCase getMode();

  public static ConsistencyRequest forReplication(String tableId) {
    return new AutoValue_ConsistencyRequest(
        tableId, CheckConsistencyRequest.ModeCase.STANDARD_READ_REMOTE_WRITES);
  }

  public static ConsistencyRequest forDataBoost(String tableId) {
    return new AutoValue_ConsistencyRequest(
        tableId, CheckConsistencyRequest.ModeCase.DATA_BOOST_READ_LOCAL_WRITES);
  }

  @InternalApi
  public CheckConsistencyRequest toCheckConsistencyProto(
      TableAdminRequestContext requestContext, String token) {
    CheckConsistencyRequest.Builder builder = CheckConsistencyRequest.newBuilder();
    TableName tableName =
        TableName.of(requestContext.getProjectId(), requestContext.getInstanceId(), getTableId());

    if (getMode().equals(CheckConsistencyRequest.ModeCase.STANDARD_READ_REMOTE_WRITES)) {
      builder.setStandardReadRemoteWrites(StandardReadRemoteWrites.newBuilder().build());
    } else {
      builder.setDataBoostReadLocalWrites(DataBoostReadLocalWrites.newBuilder().build());
    }

    return builder.setName(tableName.toString()).setConsistencyToken(token).build();
  }

  @InternalApi
  public GenerateConsistencyTokenRequest toGenerateTokenProto(
      TableAdminRequestContext requestContext) {
    GenerateConsistencyTokenRequest.Builder builder = GenerateConsistencyTokenRequest.newBuilder();
    TableName tableName =
        TableName.of(requestContext.getProjectId(), requestContext.getInstanceId(), getTableId());

    return builder.setName(tableName.toString()).build();
  }
}
