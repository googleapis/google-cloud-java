/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.logging;

import com.google.cloud.MetadataConfig;

public interface ResourceTypeEnvironmentGetter {

  /**
   * Gets the value of the specified environment variable.
   *
   * @param name the name of the environment variable
   * @return the string value of the variable, or <code>null</code> if the variable is not defined
   *     in the system environment
   * @see System#getenv()
   */
  String getEnv(String name);

  /**
   * Gets the value of the specified metadata server attribute.
   *
   * @param name the name of the metadata server attribute.
   * @return the string value of the attribute, or <code>null</code> if the attribute is not defined
   *     in the metadata or the server is not available.
   * @see MetadataConfig#getAttribute(String)
   */
  String getAttribute(String name);
}
