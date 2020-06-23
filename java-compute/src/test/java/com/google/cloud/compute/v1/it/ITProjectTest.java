/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectClient;
import com.google.cloud.compute.v1.ProjectSettings;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITProjectTest extends BaseTest {

  private static ProjectClient projectClient;

  @BeforeClass
  public static void setUp() throws IOException {
    ProjectSettings projectSettings =
        ProjectSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    projectClient = ProjectClient.create(projectSettings);
  }

  @AfterClass
  public static void tearDown() {
    projectClient.close();
  }

  @Test
  public void getProjectTest() {
    Project project = projectClient.getProject(PROJECT_NAME);
    assertThat(project).isNotNull();
    assertThat(project.getSelfLink()).isEqualTo(PROJECT_LINK);
  }
}
