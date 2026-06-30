/*
 * Copyright 2021 Google LLC
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

package com.example.spanner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Generates database ids and backup ids. Keeps track of the generated ids so they can be deleted
 * afterwards.
 */
public class SampleIdGenerator {

  private static final int INSTANCE_NAME_MAX_LENGTH = 30;
  private static final int DATABASE_NAME_MAX_LENGTH = 30;
  private static final int BACKUP_NAME_MAX_LENGTH = 30;
  private static final int INSTANCE_CONFIG_ID_MAX_LENGTH = 30;
  private final List<String> instanceIds;
  private final List<String> databaseIds;
  private final List<String> backupIds;
  private final List<String> instanceConfigIds;
  private final String baseDatabaseId;
  private final String baseBackupId;
  private final String baseInstanceConfigId;
  private final String baseInstanceId;

  public SampleIdGenerator(String baseDatabaseId, String baseBackupId,
      String baseInstanceConfigId, String baseInstanceId) {
    this.baseDatabaseId = baseDatabaseId;
    this.baseBackupId = baseBackupId;
    this.baseInstanceConfigId = baseInstanceConfigId;
    this.baseInstanceId = baseInstanceId;
    this.databaseIds = new ArrayList<>();
    this.backupIds = new ArrayList<>();
    this.instanceConfigIds = new ArrayList<>();
    this.instanceIds = new ArrayList<>();
  }

  public String generateInstanceId() {
    final String instanceId =
        (baseInstanceId + "-" + UUID.randomUUID().toString().replaceAll("-", ""))
            .substring(0, INSTANCE_NAME_MAX_LENGTH);

    instanceIds.add(instanceId);
    return instanceId;
  }

  public String generateDatabaseId() {
    final String databaseId =
        (baseDatabaseId + "-" + UUID.randomUUID().toString().replaceAll("-", ""))
            .substring(0, DATABASE_NAME_MAX_LENGTH);

    databaseIds.add(databaseId);
    return databaseId;
  }

  public String generateBackupId() {
    final String databaseId =
        (baseBackupId + "-" + UUID.randomUUID().toString().replaceAll("-", ""))
            .substring(0, BACKUP_NAME_MAX_LENGTH);

    backupIds.add(databaseId);
    return databaseId;
  }

  public String generateInstanceConfigId() {
    final String instanceConfigId =
        ("custom-" + baseInstanceConfigId + "-" + UUID.randomUUID().toString().replaceAll("-", ""))
            .substring(0, INSTANCE_CONFIG_ID_MAX_LENGTH);

    instanceConfigIds.add(instanceConfigId);
    return instanceConfigId;
  }

  public List<String> getDatabaseIds() {
    return databaseIds;
  }

  public List<String> getBackupIds() {
    return backupIds;
  }

  public List<String> getInstanceIds() {
    return instanceIds;
  }

  public List<String> getInstanceConfigIds() {
    return instanceConfigIds;
  }
}
