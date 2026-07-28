/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.test_helpers;

import static com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import static com.google.common.truth.Truth.assertAbout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import javax.annotation.Nullable;

public class VRpcCallContextSubject extends Subject {
  private final @Nullable VRpcCallContext actual;

  private VRpcCallContextSubject(FailureMetadata metadata, @Nullable VRpcCallContext subject) {
    super(metadata, subject);
    this.actual = subject;
  }

  public void isIdempotent() {
    check("operationinfo.isidempotent").that(actual.getOperationInfo().isIdempotent()).isTrue();
  }

  public void isNotIdempotent() {
    check("operationinfo.isidempotent").that(actual.getOperationInfo().isIdempotent()).isFalse();
  }

  public static VRpcCallContextSubject assertThat(@Nullable VRpcCallContext context) {
    return assertAbout(vRpcCallContexts()).that(context);
  }

  public static Factory<VRpcCallContextSubject, VRpcCallContext> vRpcCallContexts() {
    return VRpcCallContextSubject::new;
  }
}
