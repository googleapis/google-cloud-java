/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.spanner.v1.TypeCode;
import java.sql.DatabaseMetaData;
import java.sql.SQLType;

public class PgJsonbType implements SQLType {
  public static final PgJsonbType INSTANCE = new PgJsonbType();

  /**
   * Spanner/Spangres does not have any type numbers, but the code values are unique. Add 200,000 to
   * avoid conflicts with the type numbers in java.sql.Types. Native Cloud Spanner types already use
   * the range starting at 100,000 (see {@link JsonType}).
   */
  public static final int VENDOR_TYPE_NUMBER = 200_000 + TypeCode.JSON_VALUE;

  /**
   * Define a short type number as well, as this is what is expected to be returned in {@link
   * DatabaseMetaData#getTypeInfo()}.
   */
  public static final short SHORT_VENDOR_TYPE_NUMBER = (short) VENDOR_TYPE_NUMBER;

  private PgJsonbType() {}

  @Override
  public String getName() {
    return "JSONB";
  }

  @Override
  public String getVendor() {
    return PgJsonbType.class.getPackage().getName();
  }

  @Override
  public Integer getVendorTypeNumber() {
    return VENDOR_TYPE_NUMBER;
  }

  public String toString() {
    return getName();
  }
}
