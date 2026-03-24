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
    assertTrue(unManagedDependencies.isEmpty());
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
