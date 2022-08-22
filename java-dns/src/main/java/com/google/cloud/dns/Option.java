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

package com.google.cloud.dns;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/** A base class for options. */
abstract class Option implements Serializable {

  private static final long serialVersionUID = -5912727967831484228L;
  private final Object value;
  private final DnsRpc.Option rpcOption;

  Option(DnsRpc.Option rpcOption, Object value) {
    this.rpcOption = checkNotNull(rpcOption);
    this.value = value;
  }

  Object getValue() {
    return value;
  }

  DnsRpc.Option getRpcOption() {
    return rpcOption;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Option)) {
      return false;
    }
    Option other = (Option) obj;
    return Objects.equals(value, other.value) && Objects.equals(rpcOption, other.rpcOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, rpcOption);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("value", value)
        .add("rpcOption", rpcOption)
        .toString();
  }
}
