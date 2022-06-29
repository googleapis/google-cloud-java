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
package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BigtableTableAdminSettingsTest {

  @Test
  public void testInstanceName() throws IOException {
    BigtableTableAdminSettings.Builder builder =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance");

    assertThat(builder.getProjectId()).isEqualTo("my-project");
    assertThat(builder.getInstanceId()).isEqualTo("my-instance");
    assertThat(builder.build().getProjectId()).isEqualTo("my-project");
    assertThat(builder.build().getInstanceId()).isEqualTo("my-instance");
    assertThat(builder.build().toBuilder().getProjectId()).isEqualTo("my-project");
    assertThat(builder.build().toBuilder().getInstanceId()).isEqualTo("my-instance");
  }

  @Test
  public void testMissingInstanceName() {
    Exception actualException = null;

    try {
      BigtableTableAdminSettings.newBuilder().build();
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testCredentials() throws IOException {
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);

    BigtableTableAdminSettings settings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance")
            .setCredentialsProvider(credentialsProvider)
            .build();

    assertThat(settings.getCredentialsProvider()).isSameInstanceAs(credentialsProvider);
    assertThat(settings.getStubSettings().getCredentialsProvider())
        .isSameInstanceAs(credentialsProvider);
    assertThat(settings.toBuilder().getCredentialsProvider()).isSameInstanceAs(credentialsProvider);
    assertThat(settings.toBuilder().build().getCredentialsProvider())
        .isSameInstanceAs(credentialsProvider);
  }

  @Test
  public void testStubSettings() throws IOException {
    BigtableTableAdminSettings.Builder builder =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId("my-project")
            .setInstanceId("my-instance");

    builder.stubSettings().createTableSettings().setRetryableCodes(Code.INVALID_ARGUMENT);

    assertThat(builder.build().getStubSettings().createTableSettings().getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);

    assertThat(
            builder
                .build()
                .toBuilder()
                .build()
                .getStubSettings()
                .createTableSettings()
                .getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);
  }

  static final String[] SETTINGS_LIST = {
    "createTableSettings",
    "createTableFromSnapshotSettings",
    "createTableFromSnapshotOperationSettings",
    "listTablesSettings",
    "getTableSettings",
    "deleteTableSettings",
    "modifyColumnFamiliesSettings",
    "dropRowRangeSettings",
    "generateConsistencyTokenSettings",
    "checkConsistencySettings",
    "getIamPolicySettings",
    "setIamPolicySettings",
    "testIamPermissionsSettings",
    "snapshotTableSettings",
    "snapshotTableOperationSettings",
    "getSnapshotSettings",
    "listSnapshotsSettings",
    "deleteSnapshotSettings",
    "createBackupSettings",
    "createBackupOperationSettings",
    "getBackupSettings",
    "listBackupsSettings",
    "updateBackupSettings",
    "deleteBackupSettings",
    "restoreTableSettings",
    "restoreTableOperationSettings",
    "undeleteTableSettings",
    "undeleteTableOperationSettings"
  };

  @Test
  public void testToString() throws IOException {
    BigtableTableAdminSettings defaultSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId("our-project-85")
            .setInstanceId("our-instance-06")
            .build();

    checkToString(defaultSettings);

    BigtableTableAdminSettings.Builder builder = defaultSettings.toBuilder();
    BigtableTableAdminStubSettings.Builder stubSettings =
        builder.stubSettings().setEndpoint("example.com:1234");

    stubSettings
        .getBackupSettings()
        .setRetrySettings(
            RetrySettings.newBuilder().setTotalTimeout(Duration.ofMinutes(812)).build());

    BigtableTableAdminSettings settings = builder.build();
    checkToString(settings);
    assertThat(defaultSettings.toString()).doesNotContain("endpoint=example.com:1234");
    assertThat(settings.toString()).contains("endpoint=example.com:1234");
    assertThat(defaultSettings.toString()).doesNotContain("totalTimeout=PT13H32M");
    assertThat(settings.toString()).contains("totalTimeout=PT13H32M");

    List<String> nonStaticFields =
        Arrays.stream(BigtableTableAdminStubSettings.class.getDeclaredFields())
            .filter(field -> !Modifier.isStatic(field.getModifiers()))
            .map(Field::getName)
            .collect(Collectors.toList());

    // failure will signal about adding a new settings property
    assertThat(nonStaticFields).containsExactlyElementsIn(SETTINGS_LIST);
  }

  void checkToString(BigtableTableAdminSettings settings) {
    String projectId = settings.getProjectId();
    String instanceId = settings.getInstanceId();
    String toString = settings.toString();
    assertThat(toString).isEqualTo(settings.toString()); // no variety
    assertThat(toString)
        .startsWith(
            "BigtableTableAdminSettings{projectId=" + projectId + ", instanceId=" + instanceId);
    for (String subSettings : SETTINGS_LIST) {
      assertThat(toString).contains(subSettings + "=");
    }
    assertThat(toString.contains(settings.getStubSettings().toString()));
  }
}
