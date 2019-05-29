/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.testing;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Simplified wrapper for emulator's versions. */
class Version implements Comparable<Version> {

  private static final Pattern VERSION_PATTERN = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$");

  private final int major;
  private final int minor;
  private final int patch;

  private Version(int major, int minor, int patch) {
    this.major = major;
    this.minor = minor;
    this.patch = patch;
  }

  @Override
  public int compareTo(Version version) {
    int result = major - version.major;
    if (result == 0) {
      result = minor - version.minor;
      if (result == 0) {
        result = patch - version.patch;
      }
    }
    return result;
  }

  @Override
  public String toString() {
    return String.format("%d.%d.%d", major, minor, patch);
  }

  @Override
  public boolean equals(Object other) {
    return this == other || other instanceof Version && compareTo((Version) other) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch);
  }

  int getMajor() {
    return major;
  }

  int getMinor() {
    return minor;
  }

  int getPatch() {
    return patch;
  }

  static Version fromString(String version) {
    Matcher matcher = VERSION_PATTERN.matcher(checkNotNull(version));
    if (matcher.matches()) {
      return new Version(
          Integer.valueOf(matcher.group(1)),
          Integer.valueOf(matcher.group(2)),
          Integer.valueOf(matcher.group(3)));
    }
    throw new IllegalArgumentException("Invalid version format");
  }
}
