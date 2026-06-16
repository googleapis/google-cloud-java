/*
 * Copyright 2026 Google LLC
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

import java.util.List;

/** Helper for Spanner transaction tags. */
final class AutoTagHelper {

  /** Maximum allowed character length for resolved tags. */
  private static final int MAX_TAG_LENGTH = 50;

  /** Ignored packages. */
  private static final String[] INTERNAL_PACKAGES;

  static {
    INTERNAL_PACKAGES =
        new String[] {
          "java.",
          "javax.",
          "jdk.",
          "sun.",
          "io.grpc.",
          "com.google.cloud.spanner.",
          "com.google.api."
        };
  }

  private AutoTagHelper() {
    // prevent instantiation
  }

  static String getAutoTag(final SpannerOptions options) {
    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
    int tracerLimit = options.getAutoTaggingTracerLimit();
    int limit = Math.min(stackTrace.length, tracerLimit);
    List<String> targetPackages = options.getAutoTaggingPackages();
    boolean hasTarget = targetPackages != null && !targetPackages.isEmpty();

    for (int i = 0; i < limit; i++) {
      StackTraceElement element = stackTrace[i];
      String className = element.getClassName();
      if (hasTarget) {
        for (String targetPackage : targetPackages) {
          if (className.startsWith(targetPackage)) {
            return formatTag(className, element.getMethodName());
          }
        }
      } else if (isInternalPackage(className)) {
        continue;
      } else {
        return formatTag(className, element.getMethodName());
      }
    }
    return null;
  }

  private static boolean isInternalPackage(final String cls) {
    for (String internalPackage : INTERNAL_PACKAGES) {
      if (cls.startsWith(internalPackage)) {
        return true;
      }
    }
    return false;
  }

  private static String formatTag(final String cls, final String method) {
    int lastDot = cls.lastIndexOf('.');
    String simpleClassName;
    if (lastDot == -1) {
      simpleClassName = cls;
    } else {
      simpleClassName = cls.substring(lastDot + 1);
    }
    String tag = simpleClassName + "." + method;
    if (tag.length() > MAX_TAG_LENGTH) {
      tag = tag.substring(tag.length() - MAX_TAG_LENGTH);
    }
    return tag;
  }
}
