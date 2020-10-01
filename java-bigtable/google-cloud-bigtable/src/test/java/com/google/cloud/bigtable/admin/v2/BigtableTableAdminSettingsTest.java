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
import com.google.api.gax.rpc.StatusCode.Code;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

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
}
