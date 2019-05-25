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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine global address. */
public final class GlobalAddressId extends AddressId {

  private static final String REGEX = ResourceId.REGEX + "global/addresses/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -2950815290049218593L;

  private GlobalAddressId(String project, String address) {
    super(project, address);
  }

  @Override
  public Type getType() {
    return Type.GLOBAL;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/addresses/" + getAddress();
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof GlobalAddressId && baseEquals((GlobalAddressId) obj);
  }

  @Override
  GlobalAddressId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return GlobalAddressId.of(projectId, getAddress());
  }

  /**
   * Returns an address identity given the address name. The address name must be 1-63 characters
   * long and comply with RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static GlobalAddressId of(String address) {
    return new GlobalAddressId(null, address);
  }

  /**
   * Returns an address identity given project and address names. The address name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static GlobalAddressId of(String project, String address) {
    return new GlobalAddressId(project, address);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a global address
   * URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static GlobalAddressId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid global address URL");
    }
    return GlobalAddressId.of(matcher.group(1), matcher.group(2));
  }
}
