/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

/**
 * A client to Google Cloud Resource Manager.
 *
 * <p>Here's a simple usage example for using gcloud-java from App/Compute Engine. This example
 * creates a project if it does not exist. For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/resourcemanager/snippets/GetOrCreateProject.java">
 * gcloud-java-examples:com.google.gcloud.examples.resourcemanager.snippets.GetOrCreateProject</a>.
 * <pre> {@code
 * ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();
 * String myProjectId = "my-globally-unique-project-id"; // Change to a unique project ID
 * Project myProject = resourceManager.get(myProjectId);
 * if (myProject == null) {
 *   myProject = resourceManager.create(ProjectInfo.builder(myProjectId).build());
 * }
 * System.out.println("Got project " + myProject.projectId() + " from the server.");
 * }</pre>
 * <p>
 * This second example shows how to update a project and list all projects the user has permission
 * to view. For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/resourcemanager/snippets/UpdateAndListProjects.java">
 * gcloud-java-examples:com.google.gcloud.examples.resourcemanager.snippets.UpdateAndListProjects</a>.
 * <pre> {@code
 * ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();
 * String myProjectId = "my-globally-unique-project-id"; // Change to a unique project ID.
 * Project myProject = resourceManager.create(ProjectInfo.builder(myProjectId).build());
 * Project newProject = myProject.toBuilder()
 *     .addLabel("launch-status", "in-development")
 *     .build()
 *     .replace();
 * Iterator<Project> projectIterator = resourceManager.list().iterateAll();
 * System.out.println("Projects I can view:");
 * while (projectIterator.hasNext()) {
 *   System.out.println(projectIterator.next().projectId());
 * }}</pre>
 * <p>Remember that you must authenticate using the Google Cloud SDK. See more about
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java#specifying-a-project-id">providing
 * credentials here</a>.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 */

package com.google.gcloud.resourcemanager;
