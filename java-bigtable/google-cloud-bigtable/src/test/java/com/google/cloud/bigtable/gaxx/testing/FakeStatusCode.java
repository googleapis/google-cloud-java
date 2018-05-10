/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.testing;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.StatusCode;

@InternalApi("for testing")
public class FakeStatusCode implements StatusCode {
  private final Code code;

  public FakeStatusCode(Code code) {
    this.code = code;
  }

  @Override
  public Code getCode() {
    return code;
  }

  @Override
  public Code getTransportCode() {
    return getCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FakeStatusCode that = (FakeStatusCode) o;

    return code == that.code;
  }

  @Override
  public int hashCode() {
    return code != null ? code.hashCode() : 0;
  }

  public static FakeStatusCode of(Code code) {
    return new FakeStatusCode(code);
  }
}
