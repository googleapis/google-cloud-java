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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.aether.artifact.Artifact;

/**
 * Consolidates all instances of ArtifactMavenData and assists in the creation of our template data
 * by constructing all maps for each artifact.
 */
public class VersionData {

  /* Contains all data from Maven central for the given artifact */
  private static final Map<Artifact, ArtifactMavenData> artifactData = new HashMap<>();
  private static final Map<String, Set<Artifact>> cloudBomVersionToArtifacts = new HashMap<>();

  public static final String ALL_VERSIONS_NAME = "all-versions";

  private VersionData() {}

  /**
   * @param cloudBomVersion the version of google-cloud-bom associated with the set of artifacts
   * @param artifacts the set of artifacts to be pulled from Maven central
   */
  public static void addData(String cloudBomVersion, Set<Artifact> artifacts) {
    cloudBomVersionToArtifacts.put(cloudBomVersion, artifacts);
    for (Artifact artifact : artifacts) {
      if (!artifactData.containsKey(artifact)) {
        artifactData.put(artifact, ArtifactMavenData.generateArtifactMavenData(artifact));
      }
    }
  }

  /** Returns the Freemarker 'template data' formatting of our artifacts */
  public static Map<String, Object> createTemplateData(String... versions) {
    // Freemarker template
    Map<String, Object> templateData = new HashMap<>();

    // Mappings used within Freemarker file
    // All mappings are of the form key=artifactId:cloudBomVersion
    // value=currentVersion of artifact in cloudBomVersion,
    // value=newestVersion of artifact, etc.
    Map<String, String> currentVersion = new HashMap<>();
    Map<String, String> newestVersion = new HashMap<>();
    Map<String, String> newestPomUrl = new HashMap<>();
    Map<String, String> sharedDependenciesVersion = new HashMap<>();
    Map<String, String> updatedTime = new HashMap<>();
    Map<String, String> metadataUrl = new HashMap<>();
    Map<String, String> sharedDependenciesPosition = new HashMap<>();

    Set<String> artifactIds = new HashSet<>();

    Set<String> versionSet = new HashSet<>(Arrays.asList(versions));
    // There are no artifacts directly associated with the 'all-versions' name.
    // This acts as a check in case it is passed.
    versionSet.remove(ALL_VERSIONS_NAME);

    for (String cloudBomVersion : versionSet) {
      Set<Artifact> cloudBomArtifacts = cloudBomVersionToArtifacts.get(cloudBomVersion);
      if (cloudBomArtifacts == null) {
        continue;
      }
      for (Artifact artifact : cloudBomArtifacts) {
        String artifactKey = artifact.getArtifactId() + ":" + cloudBomVersion;
        ArtifactMavenData artifactMavenData = artifactData.get(artifact);

        artifactIds.add(artifact.getArtifactId());
        currentVersion.put(artifactKey, artifact.getVersion());
        newestVersion.put(artifactKey, artifactMavenData.getLatestVersion());
        newestPomUrl.put(artifactKey, artifactMavenData.getPomFileUrl());
        sharedDependenciesVersion.put(
            artifactKey, artifactMavenData.getSharedDependenciesVersion());
        sharedDependenciesPosition.put(
            artifactKey, artifactMavenData.getSharedDependenciesPosition());
        updatedTime.put(artifactKey, artifactMavenData.getLastUpdated());
        metadataUrl.put(artifactKey, artifactMavenData.getMetadataUrl());
      }
    }
    templateData.put("currentVersion", currentVersion);
    templateData.put("sharedDependenciesPosition", sharedDependenciesPosition);
    templateData.put("newestVersion", newestVersion);
    templateData.put("newestPomUrl", newestPomUrl);
    templateData.put("sharedDependenciesVersion", sharedDependenciesVersion);
    templateData.put("updatedTime", updatedTime);
    templateData.put("metadataUrl", metadataUrl);
    templateData.put("artifacts", artifactIds);
    templateData.put("versions", versionSet);
    if (versions.length == 1) {
      templateData.put("staticVersion", versions[0]);
    } else {
      templateData.put("staticVersion", "All Versions");
    }
    templateData.put("lastUpdated", LocalDateTime.now());
    return templateData;
  }
}
