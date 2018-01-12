package com.google.cloud.spanner;

import com.google.cloud.Timestamp;

/**
 * An interface for managing the life cycle of a read write transaction including all its retries.
 * See {@link TransactionContext} for a description of transaction semantics.
 * 
 * <p>At any point in time there can be at most one active transaction in this manager. When that
 * transaction is committed, if it fails with an {@code ABORTED} error, calling
 * {@link #resetForRetry()} would create a new {@link TransactionContext}. The newly created
 * transaction would use the same session thus increasing its lock priority. If the transaction is
 * committed successfully, or is rolled back or commit fails with any error other than
 * {@code ABORTED}, the manager is considered complete and no further transactions are allowed to be
 * created in it.
 * 
 * <p>Example
 * <pre><code>
 * try (TransactionManager manager : dbClient.transactionManager()) {
 *   TransactionContext txn = manager.begin();
 *   while (true) {
 *     String column = "FirstName";
 *     Struct row = txn.readRow("Singers", Key.of(singerId), Collections.singleton(column));
 *     String name = row.getString(column);
 *     txn.buffer(
 *             Mutation.newUpdateBuilder("Singers").set(column).to(name.toUpperCase()).build());
 *     try {
 *       txn.commit();
 *       break;
 *     } catch (AbortedException e) {
 *       txn = manager.resetForRetry();
 *     }
 *   }
 * }
 * </code></pre>
 */
public interface TransactionManager extends AutoCloseable {
  
  /**
   * Creates a new read write transaction. This must be called before doing any other operation and
   * can only be called once. To create a new transaction for subsequent retries, see
   * {@link #resetForRetry()}.
   */
  TransactionContext begin();
  
  /**
   * Commits the currently active transaction.
   */
  void commit();
  
  /**
   * Rolls back the currently active transaction. In most cases there should be no need to call this
   * explicitly since {@link #close()} would automatically roll back any active transaction.
   */
  void rollback();
  
  /**
   * Creates a new transaction for retry. This should only be called if the previous transaction
   * failed with {@code ABORTED}. In all other cases, this will throw a {@link SpannerException}.
   */
  TransactionContext resetForRetry();
  
  /**
   * Returns the commit timestamp if the transaction committed successfully.
   */
  Timestamp getCommitTimestamp();
  
  /**
   * Closes the manager. If there is an active transaction, it will be rolled back. Underlying
   * session will be released back to the session pool.
   */
  @Override
  void close();
}
