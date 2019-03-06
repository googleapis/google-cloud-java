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

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.resourcemanager.Project;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;

/** A snippet for Google Cloud Resource Manager showing how to modify a project's IAM policy. */
public class ModifyPolicy {

  public static void main(String... args) {
    // Create Resource Manager service object
    // By default, credentials are inferred from the runtime environment.
    ResourceManager resourceManager = ResourceManagerOptions.getDefaultInstance().getService();

    // Get a project from the server
    String projectId = "some-project-id"; // Use an existing project's ID
    Project project = resourceManager.get(projectId);

    // Get the project's policy
    Policy policy = project.getPolicy();

    // Add a viewer
    Policy.Builder modifiedPolicy = policy.toBuilder();
    Identity newViewer = Identity.user("<insert user's email address here>");
    modifiedPolicy.addIdentity(Role.viewer(), newViewer);

    // Write policy
    Policy updatedPolicy = project.replacePolicy(modifiedPolicy.build());

    // Print policy
    System.out.printf("Updated policy for %s: %n%s%n", projectId, updatedPolicy);
  }
}
