/*
 * Copyright 2021 Google LLC
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
 * Enums for the Recovery Point Objective (RPO) of dual-region buckets, which determines how fast
 * data is replicated between regions.
 *
 * @see <a
 *     href="https://cloud.google.com/storage/docs/turbo-replication">https://cloud.google.com/storage/docs/turbo-replication</a>
 */
public final class Rpo extends StringEnumValue {

  private static final long serialVersionUID = -2916656819456559679L;

  private Rpo(String constant) {
    super(constant);
  }

  private static final ApiFunction<String, Rpo> CONSTRUCTOR = Rpo::new;

  private static final StringEnumType<Rpo> type = new StringEnumType<>(Rpo.class, CONSTRUCTOR);

  /**
   * Default recovery point objective. With this setting, there is no guarantee on the amount of
   * time it takes for data to replicate between regions.
   */
  public static final Rpo DEFAULT = type.createAndRegister("DEFAULT");

  /**
   * Turbo recovery point objective. With this setting, data in a dual-region bucket will replicate
   * between regions within 15 minutes.
   */
  public static final Rpo ASYNC_TURBO = type.createAndRegister("ASYNC_TURBO");

  /**
   * Get the Rpo for the given String constant, and throw an exception if the constant is not
   * recognized.
   */
  public static Rpo valueOfStrict(String constant) {
    return type.valueOfStrict(constant);
  }

  /** Get the Rpo for the given String constant, and allow unrecognized values. */
  public static Rpo valueOf(String constant) {
    return type.valueOf(constant);
  }

  /** Return the known values for Rpo. */
  public static Rpo[] values() {
    return type.values();
  }
}
