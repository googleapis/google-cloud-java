/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Identity for a Google Compute Engine license.
 */
public final class LicenseId extends ResourceId {

  static final Function<String, LicenseId> FROM_URL_FUNCTION = new Function<String, LicenseId>() {
    @Override
    public LicenseId apply(String pb) {
      return LicenseId.fromUrl(pb);
    }
  };
  static final Function<LicenseId, String> TO_URL_FUNCTION = new Function<LicenseId, String>() {
    @Override
    public String apply(LicenseId licenseId) {
      return licenseId.toUrl();
    }
  };

  private static final long serialVersionUID = -2239484554024469651L;

  private final String license;

  LicenseId(String project, String license) {
    super(project);
    this.license = checkNotNull(license);
  }

  /**
   * Returns the name of the license. The name must be 1-63 characters long, and comply with
   * RFC1035. Specifically, the name must be 1-63 characters long and match the regular expression
   * {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter,
   * and all following characters must be a dash, lowercase letter, or digit, except the last
   * character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String license() {
    return license;
  }

  @Override
  public String toUrl() {
    return super.toUrl() + "/global/licenses/" + license;
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
    return obj instanceof LicenseId && baseEquals((LicenseId) obj);
  }

  @Override
  LicenseId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return LicenseId.of(projectId, license);
  }

  /**
   * Returns a license identity given the license name.
   */
  public static LicenseId of(String license) {
    return new LicenseId(null, license);
  }

  /**
   * Returns a license identity given project and license names.
   */
  public static LicenseId of(String project, String license) {
    return new LicenseId(project, license);
  }

  static LicenseId fromUrl(String url) {
    int projectsIndex = url.indexOf("/projects/");
    int licensesIndex = url.indexOf("/global/licenses/");
    String project = url.substring(projectsIndex + 10, licensesIndex);
    String license = url.substring(licensesIndex + 17, url.length());
    return LicenseId.of(project, license);
  }
}
