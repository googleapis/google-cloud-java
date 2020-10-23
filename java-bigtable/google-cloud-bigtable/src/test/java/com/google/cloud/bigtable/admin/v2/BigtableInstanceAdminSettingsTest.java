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
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStubSettings;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BigtableInstanceAdminSettingsTest {
  @Test
  public void testProjectName() throws Exception {
    String projectId = "my-project";
    BigtableInstanceAdminSettings.Builder builder =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);

    assertThat(builder.getProjectId()).isEqualTo(projectId);
    assertThat(builder.build().getProjectId()).isEqualTo(projectId);
    assertThat(builder.build().toBuilder().getProjectId()).isEqualTo(projectId);
  }

  @Test
  public void testMissingProjectName() {
    Exception actualException = null;

    BigtableInstanceAdminSettings.Builder settingsBuilder =
        BigtableInstanceAdminSettings.newBuilder();
    assertThat(settingsBuilder.getProjectId()).isNull();

    try {
      settingsBuilder.build();
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testCredentials() throws IOException {
    CredentialsProvider credentialsProvider = Mockito.mock(CredentialsProvider.class);

    BigtableInstanceAdminSettings settings =
        BigtableInstanceAdminSettings.newBuilder()
            .setProjectId("my-project")
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
    String projectId = "my-project";

    BigtableInstanceAdminSettings.Builder builder =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);

    builder.stubSettings().createInstanceSettings().setRetryableCodes(Code.INVALID_ARGUMENT);

    assertThat(builder.build().getStubSettings().createInstanceSettings().getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);

    assertThat(
            builder
                .build()
                .toBuilder()
                .build()
                .getStubSettings()
                .createInstanceSettings()
                .getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);
  }

  static final String[] SETTINGS_LIST = {
    "createInstanceSettings",
    "createInstanceOperationSettings",
    "getInstanceSettings",
    "listInstancesSettings",
    "partialUpdateInstanceSettings",
    "partialUpdateInstanceOperationSettings",
    "deleteInstanceSettings",
    "createClusterSettings",
    "createClusterOperationSettings",
    "getClusterSettings",
    "listClustersSettings",
    "updateClusterSettings",
    "updateClusterOperationSettings",
    "deleteClusterSettings",
    "createAppProfileSettings",
    "getAppProfileSettings",
    "listAppProfilesSettings",
    "updateAppProfileSettings",
    "updateAppProfileOperationSettings",
    "deleteAppProfileSettings",
    "getIamPolicySettings",
    "setIamPolicySettings",
    "testIamPermissionsSettings",
  };

  @Test
  public void testToString() throws IOException {
    BigtableInstanceAdminSettings defaultSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectId("our-project-212").build();

    checkToString(defaultSettings);

    BigtableInstanceAdminSettings.Builder builder = defaultSettings.toBuilder();
    BigtableInstanceAdminStubSettings.Builder stubSettings =
        builder.stubSettings().setEndpoint("example.com:1234");

    stubSettings
        .getInstanceSettings()
        .setRetrySettings(
            RetrySettings.newBuilder().setTotalTimeout(Duration.ofMinutes(812)).build());

    BigtableInstanceAdminSettings settings = builder.build();
    checkToString(settings);
    assertThat(settings.toString()).contains("endpoint=example.com:1234");
    assertThat(settings.toString()).contains("totalTimeout=PT13H32M");
  }

  void checkToString(BigtableInstanceAdminSettings settings) {
    String projectId = settings.getProjectId();
    String toString = settings.toString();
    assertThat(toString).isEqualTo(settings.toString()); // no variety
    assertThat(toString).startsWith("BigtableInstanceAdminSettings{projectId=" + projectId);
    for (String subSettings : SETTINGS_LIST) {
      assertThat(toString).contains(subSettings + "=");
    }
    assertThat(toString.contains(settings.getStubSettings().toString()));
  }
}
