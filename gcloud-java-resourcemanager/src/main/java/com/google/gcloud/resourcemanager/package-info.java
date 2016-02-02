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
 * <p>Here's a simple usage example for using gcloud-java-resourcemanager:
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
 *
 * <p>Remember that you must authenticate using the Google Cloud SDK. See more about
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java#specifying-a-project-id">providing
 * credentials here</a>.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 */

package com.google.gcloud.resourcemanager;
