/*
 * Copyright 2016, Google Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.resourcenames;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/**
 * A class to represent a {@link ResourceName} with an unknown format. This class in intended to
 * support the case of a resource name string in an unexpected format - generated resource name
 * classes with known formats should be preferred where possible.
 */
public class UntypedResourceName implements ResourceName {

  private final String rawValue;

  private volatile Map<String, String> fieldValuesMap;

  private UntypedResourceName(String rawValue) {
    this.rawValue = Preconditions.checkNotNull(rawValue);
  }

  public static UntypedResourceName of(ResourceName resourceName) {
    return new UntypedResourceName(resourceName.toString());
  }

  public static UntypedResourceName parse(String formattedString) {
    return new UntypedResourceName(formattedString);
  }

  public static boolean isParsableFrom(String formattedString) {
    return formattedString != null;
  }

  /* Returns a map with an empty String "" as the sole key, which maps to the raw value of this ResourceName. */
  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          fieldValuesMap = ImmutableMap.of("", rawValue);
        }
      }
    }
    return fieldValuesMap;
  }

  /* Returns the raw value of this ResourceName iff fieldName.equals(""), else returns null. */
  @Override
  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get("");
  }

  @Override
  public String toString() {
    return rawValue;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UntypedResourceName) {
      UntypedResourceName that = (UntypedResourceName) o;
      return this.rawValue.equals(that.rawValue);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return rawValue.hashCode();
  }
}
