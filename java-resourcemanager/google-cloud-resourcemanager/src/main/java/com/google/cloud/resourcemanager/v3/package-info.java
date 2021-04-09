/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= FoldersClient =======================
 *
 * <p>Service Description: Manages Cloud Platform folder resources. Folders can be used to organize
 * the resources under an organization and to control the policies applied to groups of resources.
 *
 * <p>Sample for FoldersClient:
 *
 * <pre>{@code
 * try (FoldersClient foldersClient = FoldersClient.create()) {
 *   FolderName name = FolderName.of("[FOLDER]");
 *   Folder response = foldersClient.getFolder(name);
 * }
 * }</pre>
 *
 * <p>======================= OrganizationsClient =======================
 *
 * <p>Service Description: Allows users to manage their organization resources.
 *
 * <p>Sample for OrganizationsClient:
 *
 * <pre>{@code
 * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
 *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
 *   Organization response = organizationsClient.getOrganization(name);
 * }
 * }</pre>
 *
 * <p>======================= ProjectsClient =======================
 *
 * <p>Service Description: Manages Google Cloud Projects.
 *
 * <p>Sample for ProjectsClient:
 *
 * <pre>{@code
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   Project response = projectsClient.getProject(name);
 * }
 * }</pre>
 *
 * <p>======================= TagBindingsClient =======================
 *
 * <p>Service Description: Allow users to create and manage TagBindings between TagValues and
 * different cloud resources throughout the GCP resource hierarchy.
 *
 * <p>Sample for TagBindingsClient:
 *
 * <pre>{@code
 * try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
 *   ResourceName parent = TagValueName.of("[TAG_VALUE]");
 *   for (TagBinding element : tagBindingsClient.listTagBindings(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= TagKeysClient =======================
 *
 * <p>Service Description: Allow users to create and manage tag keys.
 *
 * <p>Sample for TagKeysClient:
 *
 * <pre>{@code
 * try (TagKeysClient tagKeysClient = TagKeysClient.create()) {
 *   TagKeyName name = TagKeyName.of("[TAG_KEY]");
 *   TagKey response = tagKeysClient.getTagKey(name);
 * }
 * }</pre>
 *
 * <p>======================= TagValuesClient =======================
 *
 * <p>Service Description: Allow users to create and manage tag values.
 *
 * <p>Sample for TagValuesClient:
 *
 * <pre>{@code
 * try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
 *   TagValueName name = TagValueName.of("[TAG_VALUE]");
 *   TagValue response = tagValuesClient.getTagValue(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.resourcemanager.v3;

import javax.annotation.Generated;
