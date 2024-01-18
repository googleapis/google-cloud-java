/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in READMEs and javadoc. Any change to this file should be reflected in
 * the project's READMEs and package-info.java.
 */

package com.google.cloud.examples.resourcemanager.snippets;

import com.google.cloud.resourcemanager.Project;
import com.google.cloud.resourcemanager.ProjectInfo;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;

/**
 * A snippet for Google Cloud Resource Manager showing how to create a project if it does not exist.
 */
public class GetOrCreateProject {

  public static void main(String... args) {
    // Create Resource Manager service object.
    // By default, credentials are inferred from the runtime environment.
    ResourceManager resourceManager = ResourceManagerOptions.getDefaultInstance().getService();

    String projectId = "my-globally-unique-project-id"; // Change to a unique project ID.
    // Get a project from the server.
    Project project = resourceManager.get(projectId);
    if (project == null) {
      // Create a project.
      project = resourceManager.create(ProjectInfo.newBuilder(projectId).build());
    }
    System.out.println("Got project " + project.getProjectId() + " from the server.");
  }
}
