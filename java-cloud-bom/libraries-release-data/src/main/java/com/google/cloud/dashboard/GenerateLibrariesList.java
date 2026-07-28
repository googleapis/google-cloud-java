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

package com.google.cloud.dashboard;

import com.google.cloud.tools.opensource.dependencies.Bom;
import com.google.cloud.tools.opensource.dependencies.MavenRepositoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.aether.artifact.Artifact;

/** Class to generate a list of all libraries included in the libraries-bom */
public class GenerateLibrariesList {

  public static void main(String[] argument) throws MavenRepositoryException {

    Path bomPath = Paths.get("..", "libraries-bom", "pom.xml").toAbsolutePath();
    Bom bom = Bom.readBom(bomPath);
    List<Artifact> artifacts = bom.getManagedDependencies();
    List<String> artifactList = new ArrayList<>();

    for (Artifact art : artifacts) {
      artifactList.add(art.getGroupId() + ":" + art.getArtifactId());
    }

    System.out.println(artifactList);
  }
}
