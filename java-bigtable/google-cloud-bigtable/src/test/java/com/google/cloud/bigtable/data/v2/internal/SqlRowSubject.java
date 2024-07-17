/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.common.truth.Truth.assertAbout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import javax.annotation.Nullable;

/** Truth subject for {@link ProtoSqlRow}. Intended for ease-of-use in testing. */
public final class SqlRowSubject extends Subject {

  private final @Nullable SqlRow actual;

  private SqlRowSubject(FailureMetadata metadata, @Nullable SqlRow actual) {
    super(metadata, actual);
    this.actual = actual;
  }

  public static Factory<SqlRowSubject, SqlRow> sqlRow() {
    return SqlRowSubject::new;
  }

  public static SqlRowSubject assertThat(@Nullable SqlRow actual) {
    return assertAbout(sqlRow()).that(actual);
  }
}
