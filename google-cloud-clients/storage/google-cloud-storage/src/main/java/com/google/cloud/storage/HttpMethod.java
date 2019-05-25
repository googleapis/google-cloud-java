/*
 * Copyright 2015 Google LLC
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

/** Http method supported by Storage service. */
public final class HttpMethod extends StringEnumValue {
  private static final long serialVersionUID = -1394461645628254471L;

  private HttpMethod(String constant) {
    super(constant);
  }

  private static final ApiFunction<String, HttpMethod> CONSTRUCTOR =
      new ApiFunction<String, HttpMethod>() {
        @Override
        public HttpMethod apply(String constant) {
          return new HttpMethod(constant);
        }
      };

  private static final StringEnumType<HttpMethod> type =
      new StringEnumType(HttpMethod.class, CONSTRUCTOR);

  public static final HttpMethod GET = type.createAndRegister("GET");
  public static final HttpMethod HEAD = type.createAndRegister("HEAD");
  public static final HttpMethod PUT = type.createAndRegister("PUT");
  public static final HttpMethod POST = type.createAndRegister("POST");
  public static final HttpMethod DELETE = type.createAndRegister("DELETE");
  public static final HttpMethod OPTIONS = type.createAndRegister("OPTIONS");

  /**
   * Get the HttpMethod for the given String constant, and throw an exception if the constant is not
   * recognized.
   */
  public static HttpMethod valueOfStrict(String constant) {
    return type.valueOfStrict(constant);
  }

  /** Get the HttpMethod for the given String constant, and allow unrecognized values. */
  public static HttpMethod valueOf(String constant) {
    return type.valueOf(constant);
  }

  /** Return the known values for HttpMethod. */
  public static HttpMethod[] values() {
    return type.values();
  }
}
