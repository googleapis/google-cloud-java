/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.resourcemanager.v3.stub.samples;

// [START resourcemanager_v3_generated_projectsstubsettings_getproject_sync]
import com.google.cloud.resourcemanager.v3.stub.ProjectsStubSettings;
import java.time.Duration;

public class SyncGetProject {

  public static void main(String[] args) throws Exception {
    syncGetProject();
  }

  public static void syncGetProject() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    ProjectsStubSettings.Builder projectsSettingsBuilder = ProjectsStubSettings.newBuilder();
    projectsSettingsBuilder
        .getProjectSettings()
        .setRetrySettings(
            projectsSettingsBuilder
                .getProjectSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    ProjectsStubSettings projectsSettings = projectsSettingsBuilder.build();
  }
}
// [END resourcemanager_v3_generated_projectsstubsettings_getproject_sync]
