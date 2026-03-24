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

package com.google.cloud.spanner;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Objects;

/** Represents an id of a Cloud Spanner backup resource. */
public final class BackupId {
  private static final PathTemplate NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/backups/{backup}");

  private final InstanceId instanceId;
  private final String backup;

  BackupId(InstanceId instanceId, String backup) {
    this.instanceId = Preconditions.checkNotNull(instanceId);
    this.backup = Preconditions.checkNotNull(backup);
  }

  /** Returns the instance id for this backup. */
  public InstanceId getInstanceId() {
    return instanceId;
  }

  /** Returns the backup id. */
  public String getBackup() {
    return backup;
  }

  /** Returns the name of this backup. */
  public String getName() {
    return String.format(
        "projects/%s/instances/%s/backups/%s",
        instanceId.getProject(), instanceId.getInstance(), backup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, backup);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BackupId that = (BackupId) o;
    return that.instanceId.equals(instanceId) && that.backup.equals(backup);
  }

  @Override
  public String toString() {
    return getName();
  }

  /**
   * Creates a {@code BackupId} from the name of the backup.
   *
   * @param name the backup name of the form {@code
   *     projects/PROJECT_ID/instances/INSTANCE_ID/backups/BACKUP_ID}
   * @throws IllegalArgumentException if {@code name} does not conform to the expected pattern
   */
  static BackupId of(String name) {
    Preconditions.checkNotNull(name);
    Map<String, String> parts = NAME_TEMPLATE.match(name);
    Preconditions.checkArgument(
        parts != null, "Name should conform to pattern %s: %s", NAME_TEMPLATE, name);
    return of(parts.get("project"), parts.get("instance"), parts.get("backup"));
  }

  /**
   * Creates a {@code BackupId} given project, instance and backup IDs. The backup id must conform
   * to the regular expression [a-z][a-z0-9_\-]*[a-z0-9] and be between 2 and 60 characters in
   * length.
   */
  public static BackupId of(String project, String instance, String backup) {
    return new BackupId(new InstanceId(project, instance), backup);
  }

  /**
   * Creates a {@code BackupId} given the instance identity and backup id. The backup id must
   * conform to the regular expression [a-z][a-z0-9_\-]*[a-z0-9] and be between 2 and 60 characters
   * in length.
   */
  public static BackupId of(InstanceId instanceId, String backup) {
    return new BackupId(instanceId, backup);
  }
}
