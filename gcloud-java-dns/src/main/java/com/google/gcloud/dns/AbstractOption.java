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

package com.google.gcloud.dns;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import com.google.gcloud.FieldSelector;
import com.google.gcloud.dns.spi.DnsRpc;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A base class for options.
 */
abstract class AbstractOption implements Serializable {

  private static final long serialVersionUID = -5912727967831484228L;
  private final Object value;
  private final DnsRpc.Option rpcOption;

  AbstractOption(DnsRpc.Option rpcOption, Object value) {
    this.rpcOption = checkNotNull(rpcOption);
    this.value = value;
  }

  Object value() {
    return value;
  }

  DnsRpc.Option rpcOption() {
    return rpcOption;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AbstractOption)) {
      return false;
    }
    AbstractOption other = (AbstractOption) obj;
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

  static String selector(List<FieldSelector> required, FieldSelector... others) {
    Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(required.size() + others.length);
    for (FieldSelector field : required) {
      fieldStrings.add(field.selector());
    }
    for (FieldSelector field : others) {
      fieldStrings.add(field.selector());
    }
    return Joiner.on(',').join(fieldStrings);
  }

  static StringBuilder selector(StringBuilder partialSelector, List<FieldSelector> required,
      FieldSelector... others) {
    return partialSelector.append(selector(required, others));
  }
}
