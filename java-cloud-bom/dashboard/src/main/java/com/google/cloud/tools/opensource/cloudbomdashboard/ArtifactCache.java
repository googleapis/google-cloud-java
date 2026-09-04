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

import com.google.cloud.tools.opensource.dependencies.DependencyGraph;
import java.util.List;
import java.util.Map;
import org.eclipse.aether.artifact.Artifact;

/** Unified return type to bundle a lot of information about multiple artifacts together. */
class ArtifactCache {

  private Map<Artifact, ArtifactInfo> infoMap;
  private List<DependencyGraph> globalDependencies;

  void setInfoMap(Map<Artifact, ArtifactInfo> infoMap) {
    this.infoMap = infoMap;
  }

  void setGlobalDependencies(List<DependencyGraph> globalDependencies) {
    this.globalDependencies = globalDependencies;
  }

  Map<Artifact, ArtifactInfo> getInfoMap() {
    return infoMap;
  }

  List<DependencyGraph> getGlobalDependencies() {
    return globalDependencies;
  }
}
