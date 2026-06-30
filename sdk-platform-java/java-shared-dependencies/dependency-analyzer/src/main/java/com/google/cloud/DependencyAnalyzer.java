package com.google.cloud;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.external.DepsDevClient;
import com.google.cloud.model.Advisory;
import com.google.cloud.model.AdvisoryKey;
import com.google.cloud.model.AnalysisResult;
import com.google.cloud.model.License;
import com.google.cloud.model.ReportResult;
import com.google.cloud.model.PackageInfo;
import com.google.cloud.model.QueryResult;
import com.google.cloud.model.Result;
import com.google.cloud.model.Version;
import com.google.cloud.model.VersionKey;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DependencyAnalyzer {

  private final DepsDevClient depsDevClient;

  public DependencyAnalyzer(DepsDevClient depsDevClient) {
    this.depsDevClient = depsDevClient;
  }

  public AnalysisResult analyze(String system, String packageName, String packageVersion)
      throws URISyntaxException, IOException, InterruptedException, IllegalArgumentException {
    VersionKey root = VersionKey.from(system, packageName, packageVersion);
    Set<VersionKey> seenPackage = new HashSet<>();
    seenPackage.add(root);
    Queue<VersionKey> queue = new ArrayDeque<>();
    queue.offer(root);
    List<VersionKey> dependencies = new ArrayList<>();
    while (!queue.isEmpty()) {
      VersionKey versionKey = queue.poll();
      dependencies.add(versionKey);
      List<VersionKey> directDependencies = depsDevClient.getDirectDependencies(versionKey);
      // only add unseen dependencies to the queue.
      directDependencies
          .stream()
          .filter(seenPackage::add)
          .forEach(queue::offer);
    }

    List<PackageInfo> result = new ArrayList<>();
    for (VersionKey versionKey : dependencies) {
      QueryResult packageInfo = depsDevClient.getQueryResult(versionKey);
      List<License> licenses = new ArrayList<>();
      List<Advisory> advisories = new ArrayList<>();
      for (Result res : packageInfo.results()) {
        Version version = res.version();
        for (String license : version.licenses()) {
          licenses.add(License.toLicense(license));
        }
        for (AdvisoryKey advisoryKey : version.advisoryKeys()) {
          advisories.add(depsDevClient.getAdvisory(advisoryKey.id()));
        }
      }

      result.add(new PackageInfo(versionKey, licenses, advisories));
    }

    return AnalysisResult.of(result);
  }

  /**
   * For a given package, checks the package information via <a
   * href="https://deps.dev/">deps.dev</a> and reports error if risk information is found.
   * <p>
   * The types of risk checked by the dependency analyzer are:
   * <p>1. Non-compliant licenses</p>
   * <p>2. Security vulnerability</p>
   * The analyzer will report all types of risk before existing with error.
   *
   * @param args a package. A string array with three elements.
   * <p>The 1st element is the package management system, e.g., maven, npm, etc.</p>
   * <p>The 2nd element is the package name.</p>
   * <p>The 3rd element is the package version.</p>
   * @throws IllegalArgumentException if the format of package name is incorrect according to the
   * package management system.
   */
  public static void main(String[] args) throws IllegalArgumentException {
    checkArgument(args.length == 3,
        """
            The length of the inputs should be 3.
            The 1st input should be the package management system.
            The 2nd input should be the package name.
            The 3rd input should be the package version.
            """
    );

    String system = args[0];
    String packageName = args[1];
    String packageVersion = args[2];
    DependencyAnalyzer dependencyAnalyzer = new DependencyAnalyzer(
        new DepsDevClient(HttpClient.newHttpClient()));
    AnalysisResult analyzeReport = null;
    try {
      analyzeReport = dependencyAnalyzer.analyze(system, packageName, packageVersion);
    } catch (URISyntaxException | IOException | InterruptedException ex) {
      System.out.println(
          "Caught exception when fetching package information from https://deps.dev/");
      ex.printStackTrace();
      System.exit(1);
    }

    System.out.println("Please copy and paste the package information below to your ticket.\n");
    System.out.println(analyzeReport.toString());
    ReportResult result = analyzeReport.getAnalysisResult();
    System.out.println(result);
    if (result.equals(ReportResult.FAIL)) {
      System.out.println(
          "Please refer to go/cloud-java-rotations#security-advisories-monitoring for further actions");
      System.exit(1);
    }
  }
}
