/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.resourcemanager;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import com.google.gcloud.FieldSelector;
import com.google.gcloud.resourcemanager.spi.ResourceManagerRpc;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Base class for Resource Manager operation options.
 */
class Option implements Serializable {

  private static final long serialVersionUID = 2655177550880762967L;

  private final ResourceManagerRpc.Option rpcOption;
  private final Object value;

  Option(ResourceManagerRpc.Option rpcOption, Object value) {
    this.rpcOption = checkNotNull(rpcOption);
    this.value = value;
  }

  ResourceManagerRpc.Option rpcOption() {
    return rpcOption;
  }

  Object value() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Option)) {
      return false;
    }
    Option other = (Option) obj;
    return Objects.equals(rpcOption, other.rpcOption)
        && Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rpcOption, value);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", rpcOption.value())
        .add("value", value)
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
