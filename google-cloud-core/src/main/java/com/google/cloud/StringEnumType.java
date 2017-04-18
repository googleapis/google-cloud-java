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
package com.google.cloud;

import com.google.api.core.ApiFunction;
import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This represents a concept having a known set of acceptable String values, which can expand later
 * due to new API features.
 */
@InternalApi
public class StringEnumType<EnumT> {

  private final Class<EnumT> clazz;
  private final ApiFunction<String, EnumT> constructor;
  private final Map<String, EnumT> knownValues = new LinkedHashMap<>();

  public StringEnumType(Class<EnumT> clazz, ApiFunction<String, EnumT> constructor) {
    this.clazz = Preconditions.checkNotNull(clazz);
    this.constructor = Preconditions.checkNotNull(constructor);
  }

  /**
   * Create a new constant and register it in the known values.
   */
  public EnumT createAndRegister(String constant) {
      EnumT instance = constructor.apply(constant);
      knownValues.put(constant, instance);
      return instance;
  }

  /**
   * Get the enum object for the given String constant, and throw an exception if the constant is
   * not recognized.
   */
  public EnumT valueOfStrict(String constant) {
    EnumT value = knownValues.get(constant);
    if (value != null) {
      return value;
    } else {
      throw new IllegalArgumentException(
          "Constant \"" + constant + "\" not found for enum \"" + clazz.getName() + "\"");
    }
  }

  /**
   * Get the enum object for the given String constant, and allow unrecognized values.
   */
  public EnumT valueOf(String constant) {
    EnumT value = knownValues.get(constant);
    if (value != null) {
      return value;
    } else {
      return constructor.apply(constant);
    }
  }

  /**
   * Return the known values of this enum type.
   */
  public EnumT[] values() {
    Collection<EnumT> valueCollection = knownValues.values();

    @SuppressWarnings("unchecked")
    final EnumT[] valueArray = (EnumT[]) Array.newInstance(clazz, valueCollection.size());
    int i = 0;
    for (EnumT enumV : valueCollection) {
      valueArray[i] = enumV;
      i++;
    }

    return valueArray;
  }
}
