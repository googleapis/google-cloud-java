/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import java.util.Objects;

/** Represents a Cloud Spanner instance config resource. */
public class InstanceConfigInfo {

  private final InstanceConfigId id;
  private final String displayName;

  public InstanceConfigInfo(InstanceConfigId id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }

  /*
   * Returns the id of this instance config.
   */
  public InstanceConfigId getId() {
    return id;
  }

  /** Returns the display name of this instance config. */
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceConfigInfo that = (InstanceConfigInfo) o;
    return that.id.equals(id) && that.displayName.equals(displayName);
  }

  @Override
  public String toString() {
    return String.format("Instance Config[%s, %s]", id, displayName);
  }
}
