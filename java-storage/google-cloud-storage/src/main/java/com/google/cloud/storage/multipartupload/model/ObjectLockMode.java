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
package com.google.cloud.storage.multipartupload.model;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

/**
 * Represents the object lock mode. See <a
 * href="https://cloud.google.com/storage/docs/object-lock">https://cloud.google.com/storage/docs/object-lock</a>
 * for details.
 *
 * @since 2.60.0
 */
public final class ObjectLockMode extends StringEnumValue {
  private static final long serialVersionUID = -1882734434792102329L;

  private ObjectLockMode(String constant) {
    super(constant);
  }

  private static final ApiFunction<String, ObjectLockMode> CONSTRUCTOR = ObjectLockMode::new;

  private static final StringEnumType<ObjectLockMode> type =
      new StringEnumType<>(ObjectLockMode.class, CONSTRUCTOR);

  /**
   * Governance mode. See <a
   * href="https://cloud.google.com/storage/docs/object-lock">https://cloud.google.com/storage/docs/object-lock</a>
   * for details.
   *
   * @since 2.60.0
   */
  public static final ObjectLockMode GOVERNANCE = type.createAndRegister("GOVERNANCE");

  /**
   * Compliance mode. See <a
   * href="https://cloud.google.com/storage/docs/object-lock">https://cloud.google.com/storage/docs/object-lock</a>
   * for details.
   *
   * @since 2.60.0
   */
  public static final ObjectLockMode COMPLIANCE = type.createAndRegister("COMPLIANCE");

  /**
   * Get the ObjectLockMode for the given String constant, and throw an exception if the constant is
   * not recognized.
   *
   * @since 2.60.0
   */
  public static ObjectLockMode valueOfStrict(String constant) {
    return type.valueOfStrict(constant);
  }

  /**
   * Get the ObjectLockMode for the given String constant, and allow unrecognized values.
   *
   * @since 2.60.0
   */
  public static ObjectLockMode valueOf(String constant) {
    return type.valueOf(constant);
  }

  /**
   * Return the known values for ObjectLockMode.
   *
   * @since 2.60.0
   */
  public static ObjectLockMode[] values() {
    return type.values();
  }
}
