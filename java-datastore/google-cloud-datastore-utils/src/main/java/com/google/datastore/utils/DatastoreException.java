/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import com.google.rpc.Code;

/** Indicates an error in a {@link Datastore} call. */
public class DatastoreException extends Exception {
  private final String methodName;
  private final Code code;

  public DatastoreException(String methodName, Code code, String message, Throwable cause) {
    super(message, cause);
    this.methodName = methodName;
    this.code = code;
  }

  /**
   * @return the canonical error code
   */
  public Code getCode() {
    return code;
  }

  /**
   * @return the datastore method name
   */
  public String getMethodName() {
    return methodName;
  }

  @Override
  public String toString() {
    return String.format("%s, code=%s", super.toString(), code);
  }
}
