package com.google.cloud;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.tools.opensource.classpath.ClassPathBuilder;
import com.google.cloud.tools.opensource.classpath.DependencyMediation;
import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.version.InvalidVersionSpecificationException;

/**
 * A utility class to check unmanaged dependencies in BOM.
 */
public class UnmanagedDependencyCheck {
  // Regex of handwritten artifacts.
  // There are customized artifacts defined in gapic-bom and handwritten libraries,
  // e.g., firestore and datastore, add entries in regex to exclude these artifacts.
  private final static String downstreamArtifact =
      "(com.google.cloud:google-.*)|"
          + "(com.google.api.grpc:(gapic|grpc|proto)-google-.*)|"
          + "(com.google.cloud:proto-google-cloud-firestore-bundle-.*)|"
          + "(com.google.cloud.datastore:datastore-.*-proto-client)|"
          + "(com.google.analytics:google-analytics-.*)|"
          + "(com.google.apis:google-api-.*)|"
          + "(com.google.area120:google-area120-.*)|"
          + "(io.grafeas:grafeas)";

  /**
   * @param args An array with two elements.<p> The first string is the path of Java shared
   * dependencies BOM. <p> The second string is the path of a pom.xml contains BOM.
   */
  public static void main(String[] args)
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    checkArgument(args.length == 2, "The length of the inputs should be 2");
    System.out.println(getUnmanagedDependencies(args[0], args[1]));
  }

  /**
   * Returns dependency coordinates that are not managed by shared dependency BOM.
   *
   * @param sharedDependenciesBomPath the path of shared dependency BOM
   * @param projectBomPath the path of current project BOM
   * @return a list of unmanaged dependencies by the given version of shared dependency BOM
   * @throws MavenRepositoryException thrown if the artifacts in Bom can't be reached in remote or
   * local Maven repository
   * @throws InvalidVersionSpecificationException thrown if the shared dependency version can't be
   * parsed
   */
  public static List<String> getUnmanagedDependencies(
      String sharedDependenciesBomPath, String projectBomPath)
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    Set<String> sharedDependencies = getManagedDependencies(sharedDependenciesBomPath);
    Set<String> managedDependencies = getManagedDependencies(projectBomPath);

    return managedDependencies.stream()
        .filter(dependency -> !sharedDependencies.contains(dependency))
        // handwritten artifacts, e.g., com.google.cloud:google-cloud-bigtable, should be excluded.
        .filter(dependency -> !dependency.matches(downstreamArtifact))
        .collect(Collectors.toList());
  }

  private static Set<String> getManagedDependencies(String projectBomPath)
      throws MavenRepositoryException, InvalidVersionSpecificationException {
    return getManagedDependenciesFromBom(Bom.readBom(Paths.get(projectBomPath)));
  }

  private static Set<String> getManagedDependenciesFromBom(Bom bom)
      throws InvalidVersionSpecificationException {
    Set<String> res = new HashSet<>();
    new ClassPathBuilder()
        .resolve(bom.getManagedDependencies(), false, DependencyMediation.MAVEN)
        .getClassPath()
        .forEach(
            classPath -> {
              Artifact artifact = classPath.getArtifact();
              res.add(String.format("%s:%s", artifact.getGroupId(), artifact.getArtifactId()));
            });

    return res;
  }

  private UnmanagedDependencyCheck() {
    throw new IllegalStateException("Utility class");
  }
}
