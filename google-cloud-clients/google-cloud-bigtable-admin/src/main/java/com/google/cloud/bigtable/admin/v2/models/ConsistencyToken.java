/*
 * Copyright 2018 Google LLC
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
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;

/**
 * Wrapper for {@link GenerateConsistencyTokenResponse#getConsistencyToken()}
 *
 * <p>Cannot be created. They are obtained by invoking {@link
 * com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient#generateConsistencyToken(String)}
 */
public final class ConsistencyToken {
  private final String token;

  @InternalApi
  public static ConsistencyToken fromProto(GenerateConsistencyTokenResponse proto) {
    return new ConsistencyToken(proto.getConsistencyToken());
  }

  private ConsistencyToken(String token) {
    this.token = token;
  }

  // TODO(igorbernstein): tableName should be part of the token and be parameterized
  @InternalApi
  public CheckConsistencyRequest toProto(String tableName) {
    return CheckConsistencyRequest.newBuilder()
        .setName(tableName)
        .setConsistencyToken(token)
        .build();
  }

  @VisibleForTesting
  String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("token", token).toString();
  }
}
