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
import org.eclipse.aether.RepositoryException;

/** Cache of info looked up for an artifact. */
class ArtifactInfo {

  private DependencyGraph completeDependencies;
  private DependencyGraph transitiveDependencies;
  private RepositoryException exception;

  ArtifactInfo(DependencyGraph completeDependencies, DependencyGraph transitiveDependencies) {
    this.completeDependencies = completeDependencies;
    this.transitiveDependencies = transitiveDependencies;
  }

  ArtifactInfo(RepositoryException ex) {
    this.exception = ex;
  }

  DependencyGraph getCompleteDependencies() {
    return completeDependencies;
  }

  DependencyGraph getTransitiveDependencies() {
    return transitiveDependencies;
  }

  RepositoryException getException() {
    return exception;
  }
}
