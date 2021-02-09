/*
 * Copyright 2020 Google LLC
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
 * <p>======================= ArtifactRegistryClient =======================
 *
 * <p>Service Description: The Artifact Registry API service.
 *
 * <p>Artifact Registry is an artifact management system for storing artifacts from different
 * package management systems.
 *
 * <p>The resources managed by this API are:
 *
 * <ul>
 *   <li>Repositories, which group packages and their data.
 *   <li>Packages, which group versions and their tags.
 *   <li>Versions, which are specific forms of a package.
 *   <li>Tags, which represent alternative names for versions.
 *   <li>Files, which contain content and are optionally associated with a Package or Version.
 * </ul>
 *
 * <p>Sample for ArtifactRegistryClient:
 *
 * <pre>{@code
 * try (ArtifactRegistryClient artifactRegistryClient = ArtifactRegistryClient.create()) {
 *   String name = "name3373707";
 *   Repository response = artifactRegistryClient.getRepository(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.devtools.artifactregistry.v1beta2;

import javax.annotation.Generated;
