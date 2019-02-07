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
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Preconditions;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Parameters for updating an existing Bigtable instance.
 *
 * <p>Existing instances maybe updated to change their superficial appearance (ie. display name) and
 * can also be upgraded from a DEVELOPMENT instance to a PRODUCTION instance. Please note that
 * upgrading to a PRODUCTION instance cannot be undone.
 */
public class UpdateInstanceRequest {
  private final String instanceId;
  private final PartialUpdateInstanceRequest.Builder builder =
      PartialUpdateInstanceRequest.newBuilder();

  /** Builds a new request to update an existing instance with the specified id. */
  public static UpdateInstanceRequest of(@Nonnull String instanceId) {
    return new UpdateInstanceRequest(instanceId);
  }

  private UpdateInstanceRequest(@Nonnull String instanceId) {
    Preconditions.checkNotNull(instanceId, "instanceId can't be null");
    this.instanceId = instanceId;
  }

  /** Changes the display name of the instance. */
  @SuppressWarnings("WeakerAccess")
  public UpdateInstanceRequest setDisplayName(@Nonnull String displayName) {
    Preconditions.checkNotNull(displayName);
    builder.getInstanceBuilder().setDisplayName(displayName);
    updateFieldMask(Instance.DISPLAY_NAME_FIELD_NUMBER);

    return this;
  }

  /**
   * Upgrades the instance from a DEVELOPMENT instance to a PRODUCTION instance. This cannot be
   * undone.
   */
  @SuppressWarnings("WeakerAccess")
  public UpdateInstanceRequest setProductionType() {
    builder.getInstanceBuilder().setType(Type.PRODUCTION);
    updateFieldMask(Instance.TYPE_FIELD_NUMBER);

    return this;
  }

  /**
   * Replaces the labels associated with the instance.
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/creating-managing-labels">For more
   *     details</a>
   */
  @SuppressWarnings("WeakerAccess")
  public UpdateInstanceRequest setAllLabels(@Nonnull Map<String, String> labels) {
    Preconditions.checkNotNull(labels, "labels can't be null");
    builder.getInstanceBuilder().clearLabels();
    builder.getInstanceBuilder().putAllLabels(labels);
    updateFieldMask(Instance.LABELS_FIELD_NUMBER);

    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask = FieldMaskUtil.fromFieldNumbers(Instance.class, fieldNumber);
    builder.setUpdateMask(FieldMaskUtil.union(builder.getUpdateMask(), newMask));
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public PartialUpdateInstanceRequest toProto(String projectId) {
    // Empty field mask implies full resource replacement, which would clear all fields in an empty
    // update request.
    Preconditions.checkState(
        !builder.getUpdateMask().getPathsList().isEmpty(), "Update request is empty");

    builder.getInstanceBuilder().setName(NameUtil.formatInstanceName(projectId, instanceId));

    return builder.build();
  }
}
