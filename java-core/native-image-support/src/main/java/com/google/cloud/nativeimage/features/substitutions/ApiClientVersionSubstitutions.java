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
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import java.util.function.BooleanSupplier;

/** Substitution for setting Java version correctly in the Google Java Http Client. */
@TargetClass(
    className =
        "com.google.api.client.googleapis.services.AbstractGoogleClientRequest$ApiClientVersion",
    onlyWith = ApiClientVersionSubstitutions.OnlyIfInClassPath.class)
final class ApiClientVersionSubstitutions {

  @Alias private String versionString;

  @Substitute
  public String toString() {
    String[] tokens = versionString.split(" ");

    if (tokens.length > 0 && tokens[0].startsWith("gl-java")) {
      tokens[0] += "-graalvm";
      return String.join(" ", tokens);
    } else {
      return versionString;
    }
  }

  private ApiClientVersionSubstitutions() {}

  static class OnlyIfInClassPath implements BooleanSupplier {

    @Override
    public boolean getAsBoolean() {
      try {
        // Note: Set initialize = false to avoid initializing the class when looking it up.
        Class.forName(
            "com.google.api.client.googleapis.services."
                + "AbstractGoogleClientRequest$ApiClientVersion",
            false,
            Thread.currentThread().getContextClassLoader());
        return true;
      } catch (ClassNotFoundException e) {
        return false;
      }
    }
  }
}
