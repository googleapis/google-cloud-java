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

package com.google.gcloud.storage;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Storage operation option
 */
public class Option implements Serializable {

  private static final long serialVersionUID = -73199088766477208L;

  private final String name;
  private final Object value;

  Option(String name, Object value) {
    this.name = checkNotNull(name);
    this.value = value;
  }

  public String name() {
    return name;
  }

  public Object value() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Option)) {
      return false;
    }
    Option other = (Option) obj;
    return Objects.equals(name, other.name)
        && Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }
}
