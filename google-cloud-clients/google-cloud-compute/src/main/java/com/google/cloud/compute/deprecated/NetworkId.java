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

import com.google.common.base.MoreObjects.ToStringHelper;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine network. */
public final class NetworkId extends ResourceId {

  private static final String REGEX = ResourceId.REGEX + "global/networks/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 2386765228138819506L;

  private final String network;

  NetworkId(String project, String network) {
    super(project);
    this.network = checkNotNull(network);
  }

  private NetworkId(NetworkId networkId) {
    super(networkId.getProject());
    this.network = checkNotNull(networkId.getNetwork());
  }

  /**
   * Returns the name of the network. The network name must be 1-63 characters long and comply with
   * RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getNetwork() {
    return network;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/networks/" + network;
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper().add("network", network);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), network);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof NetworkId)) {
      return false;
    }
    NetworkId other = (NetworkId) obj;
    return baseEquals(other) && Objects.equals(network, other.network);
  }

  @Override
  NetworkId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return NetworkId.of(projectId, network);
  }

  /**
   * Returns a new network identity given project and network names. The network name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static NetworkId of(String project, String network) {
    return new NetworkId(project, network);
  }

  /**
   * Returns a new network identity given network name. The network name must be 1-63 characters
   * long and comply with RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static NetworkId of(String network) {
    return NetworkId.of(null, network);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a network URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static NetworkId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid network URL");
    }
    return NetworkId.of(matcher.group(1), matcher.group(2));
  }
}
