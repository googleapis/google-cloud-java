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

package com.google.cloud.spanner;

import com.google.gson.internal.JavaVersion;

/** Util class for getting the Java version the tests are executed on. */
public class JavaVersionUtil {

  /** Returns the major Java version (e.g. 8, 11, 17) */
  public static int getJavaMajorVersion() {
    return JavaVersion.getMajorJavaVersion();
  }
}
