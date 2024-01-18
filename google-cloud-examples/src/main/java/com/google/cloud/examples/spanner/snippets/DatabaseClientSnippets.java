/*
 * Copyright 2017 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in DatabaseClient's javadoc. Any change to this file should be reflected
 * in DatabaseClient's javadoc.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/** This class contains snippets for {@link DatabaseClient} interface. */
public class DatabaseClientSnippets {

  private final DatabaseClient dbClient;

  public DatabaseClientSnippets(DatabaseClient dbClient) {
    this.dbClient = dbClient;
  }

  /** Example of blind write. */
  // [TARGET write(Iterable)]
  // [VARIABLE my_singer_id]
  public void write(long singerId) {
    // [START write]
    Mutation mutation =
        Mutation.newInsertBuilder("Singer")
            .set("SingerId")
            .to(singerId)
            .set("FirstName")
            .to("Billy")
            .set("LastName")
            .to("Joel")
            .build();
    dbClient.write(Collections.singletonList(mutation));
    // [END write]
  }

  /** Example of unprotected blind write. */
  // [TARGET writeAtLeastOnce(Iterable)]
  // [VARIABLE my_singer_id]
  public void writeAtLeastOnce(long singerId) {
    // [START writeAtLeastOnce]
    Mutation mutation =
        Mutation.newInsertBuilder("Singers")
            .set("SingerId")
            .to(singerId)
            .set("FirstName")
            .to("Billy")
            .set("LastName")
            .to("Joel")
            .build();
    dbClient.writeAtLeastOnce(Collections.singletonList(mutation));
    // [END writeAtLeastOnce]
  }

  /** Example of single use. */
  // [TARGET singleUse()]
  // [VARIABLE my_singer_id]
  public String singleUse(long singerId) {
    // [START singleUse]
    String column = "FirstName";
    Struct row =
        dbClient.singleUse().readRow("Singers", Key.of(singerId), Collections.singleton(column));
    String firstName = row.getString(column);
    // [END singleUse]
    return firstName;
  }

  /** Example of single use with timestamp bound. */
  // [TARGET singleUse(TimestampBound)]
  // [VARIABLE my_singer_id]
  public String singleUseStale(long singerId) {
    // [START singleUseStale]
    String column = "FirstName";
    Struct row =
        dbClient
            .singleUse(TimestampBound.ofMaxStaleness(10, TimeUnit.SECONDS))
            .readRow("Singers", Key.of(singerId), Collections.singleton(column));
    String firstName = row.getString(column);
    // [END singleUseStale]
    return firstName;
  }

  /** Example of single use read only transaction. */
  // [TARGET singleUseReadOnlyTransaction()]
  // [VARIABLE my_singer_id]
  public Timestamp singleUseReadOnlyTransaction(long singerId) {
    // [START singleUseReadOnlyTransaction]
    String column = "FirstName";
    ReadOnlyTransaction txn = dbClient.singleUseReadOnlyTransaction();
    Struct row = txn.readRow("Singers", Key.of(singerId), Collections.singleton(column));
    row.getString(column);
    Timestamp timestamp = txn.getReadTimestamp();
    // [END singleUseReadOnlyTransaction]
    return timestamp;
  }

  /** Example of single use read only transaction with timestamp bound. */
  // [TARGET singleUseReadOnlyTransaction(TimestampBound)]
  // [VARIABLE my_singer_id]
  public Timestamp singleUseReadOnlyTransactionTimestamp(long singerId) {
    // [START singleUseReadOnlyTransactionTimestamp]
    String column = "FirstName";
    ReadOnlyTransaction txn =
        dbClient.singleUseReadOnlyTransaction(TimestampBound.ofMaxStaleness(10, TimeUnit.SECONDS));
    Struct row = txn.readRow("Singers", Key.of(singerId), Collections.singleton(column));
    row.getString(column);
    Timestamp timestamp = txn.getReadTimestamp();
    // [END singleUseReadOnlyTransactionTimestamp]
    return timestamp;
  }

  /** Example of read only transaction. */
  // [TARGET readOnlyTransaction()]
  // [VARIABLE my_singer_id]
  // [VARIABLE my_album_id]
  public String readOnlyTransaction(long singerId, long albumId) {
    // [START readOnlyTransaction]
    String singerColumn = "FirstName";
    String albumColumn = "AlbumTitle";
    String albumTitle = null;
    // ReadOnlyTransaction should be closed to prevent resource leak.
    try (ReadOnlyTransaction txn = dbClient.readOnlyTransaction()) {
      Struct singerRow =
          txn.readRow("Singers", Key.of(singerId), Collections.singleton(singerColumn));
      Struct albumRow =
          txn.readRow("Albums", Key.of(singerId, albumId), Collections.singleton(albumColumn));
      singerRow.getString(singerColumn);
      albumTitle = albumRow.getString(albumColumn);
    }
    // [END readOnlyTransaction]
    return albumTitle;
  }

  /** Example of read only transaction with timestamp bound. */
  // [TARGET readOnlyTransaction(TimestampBound)]
  // [VARIABLE my_singer_id]
  // [VARIABLE my_album_id]
  public String readOnlyTransactionTimestamp(long singerId, long albumId) {
    // [START readOnlyTransactionTimestamp]
    String singerColumn = "FirstName";
    String albumColumn = "AlbumTitle";
    String albumTitle = null;
    // ReadOnlyTransaction should be closed to prevent resource leak.
    try (ReadOnlyTransaction txn =
        dbClient.readOnlyTransaction(TimestampBound.ofExactStaleness(10, TimeUnit.SECONDS))) {
      Struct singerRow =
          txn.readRow("Singers", Key.of(singerId), Collections.singleton(singerColumn));
      Struct albumRow =
          txn.readRow("Albums", Key.of(singerId, albumId), Collections.singleton(albumColumn));
      singerRow.getString(singerColumn);
      albumTitle = albumRow.getString(albumColumn);
    }
    // [END readOnlyTransactionTimestamp]
    return albumTitle;
  }

  /** Example of a read write transaction. */
  // [TARGET readWriteTransaction()]
  // [VARIABLE my_singer_id]
  public void readWriteTransaction(final long singerId) {
    // [START readWriteTransaction]
    TransactionRunner runner = dbClient.readWriteTransaction();
    runner.run(
        new TransactionCallable<Void>() {

          @Override
          public Void run(TransactionContext transaction) throws Exception {
            String column = "FirstName";
            Struct row =
                transaction.readRow("Singers", Key.of(singerId), Collections.singleton(column));
            String name = row.getString(column);
            transaction.buffer(
                Mutation.newUpdateBuilder("Singers").set(column).to(name.toUpperCase()).build());
            return null;
          }
        });
    // [END readWriteTransaction]
  }

  /** Example of using {@link TransactionManager}. */
  // [TARGET transactionManager()]
  // [VARIABLE my_singer_id]
  public void transactionManager(final long singerId) throws InterruptedException {
    // [START transactionManager]
    try (TransactionManager manager = dbClient.transactionManager()) {
      TransactionContext txn = manager.begin();
      while (true) {
        try {
          String column = "FirstName";
          Struct row = txn.readRow("Singers", Key.of(singerId), Collections.singleton(column));
          String name = row.getString(column);
          txn.buffer(
              Mutation.newUpdateBuilder("Singers").set(column).to(name.toUpperCase()).build());
          manager.commit();
          break;
        } catch (AbortedException e) {
          Thread.sleep(e.getRetryDelayInMillis() / 1000);
          txn = manager.resetForRetry();
        }
      }
    }
    // [END transactionManager]
  }
}
