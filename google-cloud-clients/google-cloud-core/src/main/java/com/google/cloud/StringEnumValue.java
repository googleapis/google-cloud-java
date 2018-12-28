/*
 * Copyright 2017 Google LLC
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
package com.google.cloud;

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/**
 * This represents a specific instance of a concept having a known set of acceptable String values,
 * which can expand later due to new API features. Standard Java enums can't be used in such a
 * context.
 */
public abstract class StringEnumValue implements Serializable {
  private static final long serialVersionUID = 1501809419544297884L;
  private final String constant;

  /** Don't create subclasses outside of google-cloud-java. */
  @InternalApi("This class should only be extended within google-cloud-java")
  protected StringEnumValue(String constant) {
    this.constant = Preconditions.checkNotNull(constant);
  }

  public String name() {
    return constant;
  }

  @Override
  public String toString() {
    return constant;
  }

  @Override
  public boolean equals(Object that) {
    if (that == null) {
      return false;
    }
    if (this == that) {
      return true;
    }
    if (!(getClass().equals(that.getClass()))) {
      return false;
    }
    StringEnumValue thatEnumValue = (StringEnumValue) that;
    return this.constant.equals(thatEnumValue.constant);
  }

  @Override
  public int hashCode() {
    return constant.hashCode();
  }
}
