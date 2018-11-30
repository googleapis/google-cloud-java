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

import com.google.common.base.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine global forwarding rule. */
public final class GlobalForwardingRuleId extends ForwardingRuleId {

  static final Function<String, GlobalForwardingRuleId> FROM_URL_FUNCTION =
      new Function<String, GlobalForwardingRuleId>() {
        @Override
        public GlobalForwardingRuleId apply(String pb) {
          return GlobalForwardingRuleId.fromUrl(pb);
        }
      };
  static final Function<GlobalForwardingRuleId, String> TO_URL_FUNCTION =
      new Function<GlobalForwardingRuleId, String>() {
        @Override
        public String apply(GlobalForwardingRuleId forwardingRuleId) {
          return forwardingRuleId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "global/forwardingRules/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -2648031793037534254L;

  private GlobalForwardingRuleId(String project, String rule) {
    super(project, rule);
  }

  @Override
  public Type getType() {
    return Type.GLOBAL;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/forwardingRules/" + getRule();
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof GlobalForwardingRuleId && baseEquals((GlobalForwardingRuleId) obj);
  }

  @Override
  GlobalForwardingRuleId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return GlobalForwardingRuleId.of(projectId, getRule());
  }

  /**
   * Returns a forwarding rule identity given the rule name. The forwarding rule name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static GlobalForwardingRuleId of(String rule) {
    return new GlobalForwardingRuleId(null, rule);
  }

  /**
   * Returns a forwarding rule identity given the project rule names. The forwarding rule name must
   * be 1-63 characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static GlobalForwardingRuleId of(String project, String rule) {
    return new GlobalForwardingRuleId(project, rule);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a global forwarding
   * rule URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static GlobalForwardingRuleId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid global forwarding rule URL");
    }
    return GlobalForwardingRuleId.of(matcher.group(1), matcher.group(2));
  }
}
