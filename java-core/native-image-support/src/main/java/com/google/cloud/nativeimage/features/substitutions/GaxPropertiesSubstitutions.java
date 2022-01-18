/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.nativeimage.features.substitutions;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;
import java.util.function.BooleanSupplier;

/**
 * This file contains the GaxProperties substitution to correctly set the Java language string in
 * API call headers for Native Image users.
 */
@TargetClass(
    className = "com.google.api.gax.core.GaxProperties",
    onlyWith = GaxPropertiesSubstitutions.OnlyIfInClassPath.class)
final class GaxPropertiesSubstitutions {

  @Alias
  @RecomputeFieldValue(kind = Kind.FromAlias)
  private static String JAVA_VERSION = System.getProperty("java.version") + "-graalvm";

  private GaxPropertiesSubstitutions() {}

  static class OnlyIfInClassPath implements BooleanSupplier {

    @Override
    public boolean getAsBoolean() {
      try {
        // Note: Set initialize = false to avoid initializing the class when looking it up.
        Class.forName(
            "com.google.api.gax.core.GaxProperties",
            false,
            Thread.currentThread().getContextClassLoader());
        return true;
      } catch (ClassNotFoundException e) {
        return false;
      }
    }
  }
}
