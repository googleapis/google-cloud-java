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

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine snapshot. */
public final class SnapshotId extends ResourceId {

  private static final String REGEX = ResourceId.REGEX + "global/snapshots/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -1699492866663041082L;

  private final String snapshot;

  private SnapshotId(String project, String snapshot) {
    super(project);
    this.snapshot = checkNotNull(snapshot);
  }

  /**
   * Returns the name of the snapshot. The name must be 1-63 characters long and comply with
   * RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getSnapshot() {
    return snapshot;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/snapshots/" + snapshot;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("snapshot", snapshot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), snapshot);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SnapshotId)) {
      return false;
    }
    SnapshotId other = (SnapshotId) obj;
    return baseEquals(other) && Objects.equals(snapshot, other.snapshot);
  }

  @Override
  SnapshotId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return SnapshotId.of(projectId, snapshot);
  }

  /**
   * Returns a snapshot identity given the snapshot name. The snapshot name must be 1-63 characters
   * long and comply with RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static SnapshotId of(String snapshot) {
    return new SnapshotId(null, snapshot);
  }

  /**
   * Returns a snapshot identity given project and snapshot names. The snapshot name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static SnapshotId of(String project, String snapshot) {
    return new SnapshotId(project, snapshot);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a snapshot URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return url.matches(REGEX);
  }

  static SnapshotId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid snapshot URL");
    }
    return SnapshotId.of(matcher.group(1), matcher.group(2));
  }
}
