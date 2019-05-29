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

/** Base class for Google Compute Engine forwarding rule identities. */
public abstract class ForwardingRuleId extends ResourceId {

  private static final long serialVersionUID = -4352410760458355391L;

  private final String rule;

  ForwardingRuleId(String project, String rule) {
    super(project);
    this.rule = checkNotNull(rule);
  }

  /** Possible types for a Google Compute Engine forwarding rule identity. */
  enum Type {
    /**
     * Global forwarding rules are used to forward traffic to the correct load balancer for HTTP(S)
     * load balancing.
     */
    GLOBAL,

    /**
     * Region forwarding rules are used to forward traffic to the correct pool of target virtual
     * machines.
     */
    REGION
  }

  /** Returns the type of this forwarding rule identity. */
  public abstract Type getType();

  /**
   * Returns the name of the forwarding rule. The forwarding rule name must be 1-63 characters long
   * and comply with RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getRule() {
    return rule;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("rule", rule);
  }

  @Override
  final int baseHashCode() {
    return Objects.hash(super.baseHashCode(), rule);
  }

  @Override
  final boolean baseEquals(ResourceId resourceId) {
    return resourceId instanceof ForwardingRuleId
        && super.baseEquals(resourceId)
        && Objects.equals(rule, ((ForwardingRuleId) resourceId).rule);
  }

  @Override
  abstract ForwardingRuleId setProjectId(String projectId);
}
