/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import static com.google.cloud.datastore.ReadOption.eventualConsistency;
import static com.google.cloud.datastore.ReadOption.readTime;
import static com.google.cloud.datastore.ReadOption.transactionId;
import static com.google.common.truth.Truth.assertThat;
import static com.google.datastore.v1.ReadOptions.ReadConsistency.EVENTUAL;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.ReadOptions;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Test;

public class ReadOptionProtoPreparerTest {

  private final ReadOptionProtoPreparer protoPreparer = new ReadOptionProtoPreparer();

  @Test
  public void shouldThrowErrorWhenUsingMultipleReadOptions() {
    assertThrows(
        DatastoreException.class,
        () ->
            protoPreparer.prepare(Arrays.asList(eventualConsistency(), readTime(Timestamp.now()))));
    assertThrows(
        DatastoreException.class,
        () ->
            protoPreparer.prepare(
                Arrays.asList(eventualConsistency(), transactionId("transaction-id"))));
    assertThrows(
        DatastoreException.class,
        () ->
            protoPreparer.prepare(
                Arrays.asList(transactionId("transaction-id"), readTime(Timestamp.now()))));
    assertThrows(
        DatastoreException.class,
        () ->
            protoPreparer.prepare(
                Arrays.asList(
                    eventualConsistency(),
                    readTime(Timestamp.now()),
                    transactionId("transaction-id"))));
  }

  @Test
  public void shouldPrepareReadOptionsWithEventualConsistency() {
    Optional<ReadOptions> readOptions = protoPreparer.prepare(singletonList(eventualConsistency()));

    assertThat(readOptions.get().getReadConsistency()).isEqualTo(EVENTUAL);
  }

  @Test
  public void shouldPrepareReadOptionsWithReadTime() {
    Timestamp timestamp = Timestamp.now();
    Optional<ReadOptions> readOptions = protoPreparer.prepare(singletonList(readTime(timestamp)));

    assertThat(Timestamp.fromProto(readOptions.get().getReadTime())).isEqualTo(timestamp);
  }

  @Test
  public void shouldPrepareReadOptionsWithTransactionId() {
    String dummyTransactionId = "transaction-id";
    Optional<ReadOptions> readOptions =
        protoPreparer.prepare(singletonList(transactionId(dummyTransactionId)));

    assertThat(readOptions.get().getTransaction().toStringUtf8()).isEqualTo(dummyTransactionId);
  }

  @Test
  public void shouldReturnNullWhenReadOptionsIsNull() {
    assertFalse(protoPreparer.prepare(null).isPresent());
  }

  @Test
  public void shouldReturnNullWhenReadOptionsIsAnEmptyList() {
    assertFalse(protoPreparer.prepare(ImmutableList.of()).isPresent());
  }
}
