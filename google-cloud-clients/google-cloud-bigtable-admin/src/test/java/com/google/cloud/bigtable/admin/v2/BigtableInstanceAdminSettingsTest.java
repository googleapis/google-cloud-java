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

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings.Builder;
import java.io.IOException;
import org.junit.Test;

public class BigtableInstanceAdminSettingsTest {
  @Test
  public void testProjectName() throws Exception {
    ProjectName projectName = ProjectName.of("my-project");
    Builder builder = BigtableInstanceAdminSettings.newBuilder()
        .setProjectName(projectName);

    assertThat(builder.getProjectName()).isEqualTo(projectName);
    assertThat(builder.build().getProjectName()).isEqualTo(projectName);
    assertThat(builder.build().toBuilder().getProjectName()).isEqualTo(projectName);
  }

  @Test
  public void testMissingProjectName() {
    Exception actualException = null;

    Builder settingsBuilder = BigtableInstanceAdminSettings.newBuilder();
    assertThat(settingsBuilder.getProjectName()).isNull();

    try {
      settingsBuilder.build();
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testStubSettings() throws IOException {
    ProjectName projectName = ProjectName.of("my-project");

    BigtableInstanceAdminSettings.Builder builder = BigtableInstanceAdminSettings.newBuilder()
        .setProjectName(projectName);

    builder.stubSettings().createInstanceSettings()
        .setRetryableCodes(Code.INVALID_ARGUMENT);

    assertThat(builder.build().getStubSettings().createInstanceSettings().getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);

    assertThat(builder.build().toBuilder().build().getStubSettings().createInstanceSettings()
        .getRetryableCodes())
        .containsExactly(Code.INVALID_ARGUMENT);
  }
}
