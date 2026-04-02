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

final class ResourceTypeEnvironmentGetterImpl implements ResourceTypeEnvironmentGetter {

  @Override
  public String getEnv(String name) {
    // handle exception thrown if a security manager exists and blocks access to the
    // process environment
    try {
      return System.getenv(name);
    } catch (SecurityException ex) {
      return null;
    }
  }

  @Override
  public String getAttribute(String name) {
    return MetadataConfig.getAttribute(name);
  }
}
