/*
 * Copyright 2025 Google LLC
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

import static com.google.common.truth.Truth.assertAbout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.StringSubject;
import com.google.common.truth.Subject;
import com.google.common.truth.ThrowableSubject;
import io.grpc.Status;
import io.grpc.Status.Code;
import javax.annotation.Nullable;

public class StatusSubject extends Subject {
  private final @Nullable Status actual;

  private StatusSubject(FailureMetadata failureMetadata, @Nullable Status subject) {
    super(failureMetadata, subject);
    this.actual = subject;
  }

  public void isOk() {
    code().isEqualTo(Code.OK);
  }

  public Subject code() {
    return check("code").that(actual.getCode());
  }

  public StringSubject description() {
    return check("description").that(actual.getDescription());
  }

  public ThrowableSubject cause() {
    return check("cause").that(actual.getCause());
  }

  public static StatusSubject assertThat(@Nullable Status status) {
    return assertAbout(statuses()).that(status);
  }

  public static Factory<StatusSubject, Status> statuses() {
    return StatusSubject::new;
  }
}
