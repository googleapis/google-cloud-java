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
package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

/**
 * Enums for the storage classes.
 * See https://cloud.google.com/storage/docs/storage-classes for details.
 */
public class StorageClass extends StringEnumValue {

  private StorageClass(String constant) {
    super(constant);
  }

  private static final ApiFunction<String, StorageClass> CONSTRUCTOR =
      new ApiFunction<String, StorageClass>() {
        @Override
        public StorageClass apply(String constant) {
          return new StorageClass(constant);
        }
      };

  private static final StringEnumType<StorageClass> type = new StringEnumType(
      StorageClass.class,
      CONSTRUCTOR);

  /**
   * Regional storage class.
   */
  public static final StorageClass REGIONAL = type.createAndRegister("REGIONAL");

  /**
   * Multi-regional storage class.
   */
  public static final StorageClass MULTI_REGIONAL = type.createAndRegister("MULTI_REGIONAL");

  /**
   * Nearline storage class.
   */
  public static final StorageClass NEARLINE = type.createAndRegister("NEARLINE");

  /**
   * Coldline storage class.
   */
  public static final StorageClass COLDLINE = type.createAndRegister("COLDLINE");

  /**
   * Standard storage class.
   */
  public static final StorageClass STANDARD = type.createAndRegister("STANDARD");

  /**
   * Durable Reduced Availability (deprecated)
   */
  public static final StorageClass DURABLE_REDUCED_AVAILABILITY = type.createAndRegister(
      "DURABLE_REDUCED_AVAILABILITY");

  /**
   * Get the StorageClass for the given String constant, and throw an exception if the constant is
   * not recognized.
   */
  public static StorageClass valueOfStrict(String constant) {
    return type.valueOfStrict(constant);
  }

  /**
   * Get the StorageClass for the given String constant, and allow unrecognized values.
   */
  public static StorageClass valueOf(String constant) {
    return type.valueOf(constant);
  }

  /**
   * Return the known values for StorageClass.
   */
  public static StorageClass[] values() {
    return type.values();
  }
}
