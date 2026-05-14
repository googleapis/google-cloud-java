/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.firestore;

import com.google.firestore.v1.MapValue;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;

/** Represents a regular expression type in Firestore documents. */
public class RegexValue implements Serializable {
  private static final long serialVersionUID = 8656163047921688827L;

  public final String pattern;
  public final String options;

  public RegexValue(@Nonnull String pattern, @Nonnull String options) {
    this.pattern = pattern;
    this.options = options;
  }

  MapValue toProto() {
    return UserDataConverter.encodeRegexValue(pattern, options);
  }

  /**
   * Returns true if this RegexValue is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this RegexValue is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    RegexValue other = (RegexValue) obj;
    return Objects.equals(pattern, other.pattern) && Objects.equals(options, other.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.pattern, this.options);
  }

  @Nonnull
  @Override
  public String toString() {
    return "RegexValue{pattern=" + this.pattern + ", options=" + this.options + "}";
  }
}
