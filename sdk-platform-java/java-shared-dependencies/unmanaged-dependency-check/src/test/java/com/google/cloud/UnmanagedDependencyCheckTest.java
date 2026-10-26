/*
 * Copyright 2026 Google LLC
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

package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.aether.version.InvalidVersionSpecificationException;
import org.junit.Test;

public class UnmanagedDependencyCheckTest {
  @Test
  public void getUnmanagedDependencyFromSamePomTest()
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    String sharedDependenciesBom = "src/test/resources/shared-dependency-pom.xml";
    List<String> unManagedDependencies =
        UnmanagedDependencyCheck.getUnmanagedDependencies(sharedDependenciesBom, sharedDependenciesBom);
    assertTrue(unManagedDependencies.isEmpty());
  }

  @Test
  public void getUnmanagedDependencyFromGapicAndHandwrittenBomTest()
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    List<String> unManagedDependencies =
        UnmanagedDependencyCheck.getUnmanagedDependencies(
            "src/test/resources/shared-dependency-pom.xml",
            "src/test/resources/google-internal-artifact-test-case-pom.xml");
    assertThat(unManagedDependencies).isEmpty();
  }

  @Test
  public void getUnmanagedDependencyFromNestedPomTest()
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    List<String> unManagedDependencies =
        UnmanagedDependencyCheck.getUnmanagedDependencies(
            "src/test/resources/shared-dependency-pom.xml", "src/test/resources/transitive-dependency-pom.xml");
    assertThat(unManagedDependencies)
        .containsAtLeastElementsIn(ImmutableList.of("com.h2database:h2"));
    // test dependency should be ignored.
    assertThat(unManagedDependencies)
        .doesNotContain(ImmutableList.of("com.mysql:mysql-connector-j"));
  }
}
