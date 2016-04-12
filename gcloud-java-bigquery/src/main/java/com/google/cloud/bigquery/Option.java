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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.cloud.bigquery.spi.BigQueryRpc;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for BigQuery operation option.
 */
abstract class Option implements Serializable {

  private static final long serialVersionUID = -6647817677804099207L;

  private final BigQueryRpc.Option rpcOption;
  private final Object value;

  Option(BigQueryRpc.Option rpcOption, Object value) {
    this.rpcOption = checkNotNull(rpcOption);
    this.value = value;
  }

  BigQueryRpc.Option rpcOption() {
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
    return Objects.equals(rpcOption, other.rpcOption) && Objects.equals(value, other.value);
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
}
