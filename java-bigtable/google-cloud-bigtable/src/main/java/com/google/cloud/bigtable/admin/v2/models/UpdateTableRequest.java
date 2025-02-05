/*
 * Copyright 2023 Google LLC
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
import com.google.bigtable.admin.v2.ChangeStreamConfig;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Preconditions;
import java.util.Objects;
import org.threeten.bp.Duration;

/**
 * Wrapper for {@link com.google.bigtable.admin.v2.UpdateTableRequest}
 *
 * <p>Allows for updating table:
 *
 * <ul>
 *   <li>Change stream retention period.
 * </ul>
 */
public class UpdateTableRequest {

  private final String tableId;

  private final com.google.bigtable.admin.v2.UpdateTableRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.UpdateTableRequest.newBuilder();

  private final com.google.bigtable.admin.v2.Table.AutomatedBackupPolicy.Builder
      automatedPolicyBuilder =
          com.google.bigtable.admin.v2.Table.AutomatedBackupPolicy.newBuilder();

  public static UpdateTableRequest of(String tableId) {
    return new UpdateTableRequest(tableId);
  }

  private UpdateTableRequest(String tableId) {
    this.tableId = tableId;
  }

  /** Update change stream retention period between 1 day and 7 days. */
  public UpdateTableRequest addChangeStreamRetention(Duration retention) {
    Preconditions.checkNotNull(retention);
    if (!retention.isZero()) {
      requestBuilder
          .getTableBuilder()
          .setChangeStreamConfig(
              ChangeStreamConfig.newBuilder()
                  .setRetentionPeriod(
                      com.google.protobuf.Duration.newBuilder()
                          .setSeconds(retention.getSeconds())
                          .setNanos(retention.getNano())
                          .build())
                  .build());
      requestBuilder.getUpdateMaskBuilder().addPaths("change_stream_config.retention_period");
    } else {
      requestBuilder.getTableBuilder().clearChangeStreamConfig();
      requestBuilder.getUpdateMaskBuilder().addPaths("change_stream_config");
    }
    return this;
  }

  /** Disable change stream for table. */
  public UpdateTableRequest disableChangeStreamRetention() {
    return addChangeStreamRetention(Duration.ZERO);
  }

  /** Changes the deletion protection of an existing table. */
  public UpdateTableRequest setDeletionProtection(boolean deletionProtection) {
    requestBuilder.getTableBuilder().setDeletionProtection(deletionProtection);
    requestBuilder.getUpdateMaskBuilder().addPaths("deletion_protection");
    return this;
  }

  /** Disables table automated backup policy. */
  public UpdateTableRequest disableAutomatedBackup() {
    requestBuilder.getTableBuilder().setAutomatedBackupPolicy(automatedPolicyBuilder.build());
    requestBuilder.getUpdateMaskBuilder().addPaths("automated_backup_policy");
    return this;
  }

  /** Set an automated backup policy for the table. */
  public UpdateTableRequest setAutomatedBackup(Duration retentionPeriod, Duration frequency) {
    com.google.bigtable.admin.v2.Table.AutomatedBackupPolicy policy =
        com.google.bigtable.admin.v2.Table.AutomatedBackupPolicy.newBuilder()
            .setRetentionPeriod(
                com.google.protobuf.Duration.newBuilder()
                    .setSeconds(retentionPeriod.getSeconds())
                    .setNanos(retentionPeriod.getNano())
                    .build())
            .setFrequency(
                com.google.protobuf.Duration.newBuilder()
                    .setSeconds(frequency.getSeconds())
                    .setNanos(frequency.getNano())
                    .build())
            .build();

    requestBuilder.getTableBuilder().setAutomatedBackupPolicy(policy);
    requestBuilder.getUpdateMaskBuilder().addPaths("automated_backup_policy");
    return this;
  }

  /** Updates table automated backup policy retention period. */
  public UpdateTableRequest setAutomatedBackupRetentionPeriod(Duration retention) {
    requestBuilder
        .getTableBuilder()
        .setAutomatedBackupPolicy(
            automatedPolicyBuilder
                .setRetentionPeriod(
                    com.google.protobuf.Duration.newBuilder()
                        .setSeconds(retention.getSeconds())
                        .setNanos(retention.getNano())
                        .build())
                .build());
    requestBuilder.getUpdateMaskBuilder().addPaths("automated_backup_policy.retention_period");
    return this;
  }

  /** Updates table automated backup policy frequency. */
  public UpdateTableRequest setAutomatedBackupFrequency(Duration frequency) {
    requestBuilder
        .getTableBuilder()
        .setAutomatedBackupPolicy(
            automatedPolicyBuilder
                .setFrequency(
                    com.google.protobuf.Duration.newBuilder()
                        .setSeconds(frequency.getSeconds())
                        .setNanos(frequency.getNano())
                        .build())
                .build());
    requestBuilder.getUpdateMaskBuilder().addPaths("automated_backup_policy.frequency");
    return this;
  }

  @InternalApi
  public com.google.bigtable.admin.v2.UpdateTableRequest toProto(
      String projectId, String instanceId) {
    requestBuilder
        .getTableBuilder()
        .setName(NameUtil.formatTableName(projectId, instanceId, tableId));
    return requestBuilder.build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UpdateTableRequest)) return false;
    UpdateTableRequest that = (UpdateTableRequest) o;
    return Objects.equals(requestBuilder, that.requestBuilder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestBuilder);
  }
}
