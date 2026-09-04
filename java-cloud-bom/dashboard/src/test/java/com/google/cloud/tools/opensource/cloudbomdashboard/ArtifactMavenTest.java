/*
 * Copyright 2026 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.opensource.cloudbomdashboard;

import static com.google.cloud.tools.opensource.cloudbomdashboard.ArtifactMavenData.isReachable;
import static com.google.cloud.tools.opensource.cloudbomdashboard.ArtifactMavenData.sharedDependencyPositionAndVersion;
import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.net.URL;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.junit.Test;

public class ArtifactMavenTest {
  @Test
  public void testSharedDependencies() {
    DefaultArtifact artifact =
        new DefaultArtifact("com.google.cloud:google-cloud-storage-control:2.37.0-alpha");
    String groupPath = artifact.getGroupId().replace('.', '/');
    String pomUrl =
        DashboardMain.basePath
            + "/"
            + groupPath
            + "/"
            + artifact.getArtifactId()
            + "/"
            + artifact.getVersion()
            + "/"
            + artifact.getArtifactId()
            + "-"
            + artifact.getVersion()
            + ".pom";
    ArtifactMavenData.SharedDependenciesData sharedDependenciesData =
        sharedDependencyPositionAndVersion(pomUrl, artifact);
    assertThat(sharedDependenciesData.getSharedDependencyPosition()).isEqualTo(pomUrl);
    assertThat(sharedDependenciesData.getSharedDependencyVersion()).isEqualTo("3.29.0");
  }

  @Test
  public void testSharedDependencies_invalidPomUrl() {
    DefaultArtifact artifact =
        new DefaultArtifact("com.google.cloud:google-cloud-storage-control:2.37.0-alpha");
    String groupPath = artifact.getGroupId().replace('.', '/');
    String parentPath =
        DashboardMain.basePath
            + "/"
            + groupPath
            + "/"
            + artifact.getArtifactId()
            + "-parent"
            + "/"
            + artifact.getVersion()
            + "/"
            + artifact.getArtifactId()
            + "-parent-"
            + artifact.getVersion()
            + ".pom";
    ArtifactMavenData.SharedDependenciesData sharedDependenciesData =
        sharedDependencyPositionAndVersion(parentPath, artifact);
    assertThat(sharedDependenciesData.getSharedDependencyPosition()).isEmpty();
    assertThat(sharedDependenciesData.getSharedDependencyVersion()).isEmpty();
  }

  @Test
  public void testIsReachable_validUrl() throws IOException {
    DefaultArtifact artifact =
        new DefaultArtifact("com.google.cloud:google-cloud-storage-control:2.37.0-alpha");
    String groupPath = artifact.getGroupId().replace('.', '/');
    String pomUrl =
        DashboardMain.basePath
            + "/"
            + groupPath
            + "/"
            + artifact.getArtifactId()
            + "/"
            + artifact.getVersion()
            + "/"
            + artifact.getArtifactId()
            + "-"
            + artifact.getVersion()
            + ".pom";
    assertThat(isReachable(new URL(pomUrl))).isTrue();
  }

  @Test
  public void testIsReachable_invalidUrl() throws IOException {
    DefaultArtifact artifact =
        new DefaultArtifact("com.google.cloud:google-cloud-storage-control:2.37.0-alpha");
    String groupPath = artifact.getGroupId().replace('.', '/');
    String parentPath =
        DashboardMain.basePath
            + "/"
            + groupPath
            + "/"
            + artifact.getArtifactId()
            + "-parent"
            + "/"
            + artifact.getVersion()
            + "/"
            + artifact.getArtifactId()
            + "-parent-"
            + artifact.getVersion()
            + ".pom";
    assertThat(isReachable(new URL(parentPath))).isFalse();
  }
}
