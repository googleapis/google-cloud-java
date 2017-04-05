/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

public class DatastoreBackupOptionsTest {

  private static final List<String> PROJECTION_FIELDS = ImmutableList.of("field1", "field2");
  private static final DatastoreBackupOptions BACKUP_OPTIONS = DatastoreBackupOptions.newBuilder()
      .setProjectionFields(PROJECTION_FIELDS)
      .build();

  @Test
  public void testToBuilder() {
    compareDatastoreBackupOptions(BACKUP_OPTIONS, BACKUP_OPTIONS.toBuilder().build());
    List<String> fields = ImmutableList.of("field1", "field2");
    DatastoreBackupOptions backupOptions = BACKUP_OPTIONS.toBuilder()
        .setProjectionFields(fields)
        .build();
    assertEquals(fields, backupOptions.getProjectionFields());
    backupOptions = backupOptions.toBuilder().setProjectionFields(PROJECTION_FIELDS).build();
    compareDatastoreBackupOptions(BACKUP_OPTIONS, backupOptions);
  }

  @Test
  public void testToBuilderIncomplete() {
    DatastoreBackupOptions backupOptions =
        DatastoreBackupOptions.newBuilder().setProjectionFields(PROJECTION_FIELDS).build();
    assertEquals(backupOptions, backupOptions.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FormatOptions.DATASTORE_BACKUP, BACKUP_OPTIONS.getType());
    assertEquals(PROJECTION_FIELDS, BACKUP_OPTIONS.getProjectionFields());
  }

  private void compareDatastoreBackupOptions(
      DatastoreBackupOptions expected, DatastoreBackupOptions value) {
    assertEquals(expected, value);
    assertEquals(expected.getProjectionFields(), value.getProjectionFields());
  }
}
