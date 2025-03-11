/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nonnull;

/** Wraps a {@link com.google.bigtable.v2.SampleRowKeysRequest}. */
public final class SampleRowKeysRequest implements Serializable {
  private final TargetId targetId;

  private SampleRowKeysRequest(TargetId targetId) {
    Preconditions.checkNotNull(targetId, "target id can't be null.");
    this.targetId = targetId;
  }

  /** Creates a new instance of the sample row keys builder for the given target with targetId */
  public static SampleRowKeysRequest create(TargetId targetId) {
    return new SampleRowKeysRequest(targetId);
  }

  @InternalApi
  public com.google.bigtable.v2.SampleRowKeysRequest toProto(RequestContext requestContext) {
    com.google.bigtable.v2.SampleRowKeysRequest.Builder builder =
        com.google.bigtable.v2.SampleRowKeysRequest.newBuilder();
    String resourceName =
        targetId.toResourceName(requestContext.getProjectId(), requestContext.getInstanceId());
    if (targetId.scopedForMaterializedView()) {
      builder.setMaterializedViewName(resourceName);
    } else if (targetId.scopedForAuthorizedView()) {
      builder.setAuthorizedViewName(resourceName);
    } else {
      builder.setTableName(resourceName);
    }
    return builder.setAppProfileId(requestContext.getAppProfileId()).build();
  }

  /**
   * Wraps the protobuf {@link com.google.bigtable.v2.SampleRowKeysRequest}.
   *
   * <p>WARNING: Please note that the project id & instance id in the table/authorized
   * view/materialized view name will be overwritten by the configuration in the BigtableDataClient.
   */
  @InternalApi
  public static SampleRowKeysRequest fromProto(
      @Nonnull com.google.bigtable.v2.SampleRowKeysRequest request) {
    String tableName = request.getTableName();
    String authorizedViewName = request.getAuthorizedViewName();
    String materializedViewName = request.getMaterializedViewName();

    SampleRowKeysRequest sampleRowKeysRequest =
        SampleRowKeysRequest.create(
            NameUtil.extractTargetId(tableName, authorizedViewName, materializedViewName));

    return sampleRowKeysRequest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleRowKeysRequest sampleRowKeysRequest = (SampleRowKeysRequest) o;
    return Objects.equal(targetId, sampleRowKeysRequest.targetId);
  }
}
