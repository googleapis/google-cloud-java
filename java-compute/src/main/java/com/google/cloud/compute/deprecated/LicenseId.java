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

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine license. */
public final class LicenseId extends ResourceId {

  static final Function<String, LicenseId> FROM_URL_FUNCTION =
      new Function<String, LicenseId>() {
        @Override
        public LicenseId apply(String pb) {
          return LicenseId.fromUrl(pb);
        }
      };
  static final Function<LicenseId, String> TO_URL_FUNCTION =
      new Function<LicenseId, String>() {
        @Override
        public String apply(LicenseId licenseId) {
          return licenseId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "global/licenses/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -2239484554024469651L;

  private final String license;

  private LicenseId(String project, String license) {
    super(project);
    this.license = checkNotNull(license);
  }

  /** Returns the name of the license. */
  public String getLicense() {
    return license;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/licenses/" + license;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("license", license);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), license);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof LicenseId)) {
      return false;
    }
    LicenseId other = (LicenseId) obj;
    return baseEquals(other) && Objects.equals(license, other.license);
  }

  @Override
  LicenseId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return LicenseId.of(projectId, license);
  }

  /** Returns a license identity given the license name. */
  public static LicenseId of(String license) {
    return new LicenseId(null, license);
  }

  /** Returns a license identity given project and license names. */
  public static LicenseId of(String project, String license) {
    return new LicenseId(project, license);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a license URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static LicenseId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid license URL");
    }
    return LicenseId.of(matcher.group(1), matcher.group(2));
  }
}
