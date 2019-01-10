/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.admin.v2.internal;

import com.google.api.core.InternalApi;
import java.util.logging.Logger;

/**
 * This class detects usage of and notifies users that the google-cloud-bigtable-admin artifact has
 * been deprecated in favor of the merged google-cloud-bigtable artifact.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public final class ArtifactDeprecationChecker {
  private static final Logger LOGGER = Logger.getLogger(ArtifactDeprecationChecker.class.getName());

  public static void checkDeprecatedArtifactUse() {
    if (isDeprecationMarkerPresent()) {
      LOGGER.warning(
          "google-cloud-bigtable-admin has been merged into google-cloud-bigtable."
              + " Please update your build file to stop depending on google-cloud-bigtable-admin"
              + " and use google-cloud-bigtable directly.");
    }
  }

  private static boolean isDeprecationMarkerPresent() {
    try {
      ArtifactDeprecationChecker.class
          .getClassLoader()
          .loadClass("com.google.cloud.bigtable.admin.v2.internal.DeprecationMarker");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
