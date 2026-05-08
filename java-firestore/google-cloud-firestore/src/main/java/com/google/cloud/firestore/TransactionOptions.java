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

package com.google.cloud.firestore;

import com.google.api.core.InternalExtensionOnly;
import com.google.common.base.Preconditions;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Options specifying the behavior of Firestore Transactions.
 *
 * <p>A transaction in Firestore can be either read-write or read-only.
 *
 * <p>The default set of options is a read-write transaction with a maximum number of 5 attempts.
 * This attempt count can be customized via the {@link
 * ReadWriteOptionsBuilder#setNumberOfAttempts(int)} method. A new instance of a builder can be
 * created by calling {@link #createReadWriteOptionsBuilder()}.
 *
 * <p>A read-only transaction can be configured via the {@link ReadOnlyOptionsBuilder} class. A new
 * instance can be created by calling {@link #createReadOnlyOptionsBuilder()}.
 *
 * @see com.google.firestore.v1.TransactionOptions
 */
public final class TransactionOptions {

  private static final TransactionOptions DEFAULT_READ_WRITE_TRANSACTION_OPTIONS =
      createReadWriteOptionsBuilder().build();

  private static final int DEFAULT_NUM_ATTEMPTS = 5;

  private final Executor executor;
  private final TransactionOptionsType type;
  private final int numberOfAttempts;
  @Nullable private final Timestamp readTime;

  TransactionOptions(
      Executor executor,
      TransactionOptionsType type,
      int numberOfAttempts,
      @Nullable Timestamp readTime) {
    this.executor = executor;
    this.type = type;
    this.numberOfAttempts = numberOfAttempts;
    this.readTime = readTime;
  }

  /**
   * Returns the maximum number of times a transaction will be attempted before resulting in an
   * error.
   *
   * @return The max number of attempts to try and commit the transaction.
   */
  public int getNumberOfAttempts() {
    return numberOfAttempts;
  }

  /**
   * @return Executor to be used to run user callbacks on
   */
  @Nullable
  public Executor getExecutor() {
    return executor;
  }

  /**
   * A type flag indicating the type of transaction represented.
   *
   * @return The type of transaction this represents. Either read-only or read-write.
   */
  @Nonnull
  public TransactionOptionsType getType() {
    return type;
  }

  /**
   * A {@link Timestamp} specifying the time documents are to be read at. If null, the server will
   * read documents at the most up to date available. If non-null, the specified {@code Timestamp}
   * may not be more than 60 minutes in the past (evaluated when the request is processed by the
   * server).
   *
   * @return The specific time to read documents at. A null value means reading the most up to date
   *     data.
   */
  @Nullable
  public Timestamp getReadTime() {
    // This if statement is not strictly necessary, however is kept here for clarity sake to show
    // that readTime is only applicable to a read-only transaction type.
    if (TransactionOptionsType.READ_ONLY.equals(type)) {
      return readTime;
    } else {
      return null;
    }
  }

  /**
   * Create a default set of options suitable for most use cases. Transactions will be opened as
   * ReadWrite transactions and attempted up to 5 times.
   *
   * @return The TransactionOptions object.
   * @see #createReadWriteOptionsBuilder()
   */
  @Nonnull
  public static TransactionOptions create() {
    return DEFAULT_READ_WRITE_TRANSACTION_OPTIONS;
  }

  /**
   * Create a default set of options with a custom number of retry attempts.
   *
   * @param numberOfAttempts The number of execution attempts.
   * @return The TransactionOptions object.
   * @deprecated as of 2.0.0, replaced by {@link ReadWriteOptionsBuilder#setNumberOfAttempts(int)}
   * @see #createReadWriteOptionsBuilder()
   */
  @Nonnull
  @Deprecated
  public static TransactionOptions create(int numberOfAttempts) {
    return createReadWriteOptionsBuilder().setNumberOfAttempts(numberOfAttempts).build();
  }

  /**
   * Create a default set of options with a custom executor.
   *
   * @param executor The executor to run the user callback code on.
   * @return The TransactionOptions object.
   * @deprecated as of 2.0.0, replaced by {@link ReadWriteOptionsBuilder#setExecutor(Executor)}
   * @see #createReadWriteOptionsBuilder()
   */
  @Nonnull
  @Deprecated
  public static TransactionOptions create(@Nullable Executor executor) {
    return createReadWriteOptionsBuilder().setExecutor(executor).build();
  }

  /**
   * Create a default set of options with a custom executor and a custom number of retry attempts.
   *
   * @param executor The executor to run the user callback code on.
   * @param numberOfAttempts The number of execution attempts.
   * @return The TransactionOptions object.
   * @deprecated as of 2.0.0, replaced by {@link ReadWriteOptionsBuilder#setExecutor(Executor)} and
   *     {@link ReadWriteOptionsBuilder#setNumberOfAttempts(int)}
   * @see #createReadWriteOptionsBuilder()
   */
  @Nonnull
  @Deprecated
  public static TransactionOptions create(@Nullable Executor executor, int numberOfAttempts) {
    return createReadWriteOptionsBuilder()
        .setExecutor(executor)
        .setNumberOfAttempts(numberOfAttempts)
        .build();
  }

  /**
   * @return a new Builder with default values applicable to configuring options for a read-write
   *     transaction.
   */
  @Nonnull
  public static ReadWriteOptionsBuilder createReadWriteOptionsBuilder() {
    return new ReadWriteOptionsBuilder(null, DEFAULT_NUM_ATTEMPTS);
  }

  /**
   * @return a new Builder with default values applicable to configuring options for a read-only
   *     transaction.
   */
  @Nonnull
  public static ReadOnlyOptionsBuilder createReadOnlyOptionsBuilder() {
    return new ReadOnlyOptionsBuilder(null, null);
  }

  @InternalExtensionOnly
  public abstract static class Builder<B extends Builder<B>> {
    @Nullable protected Executor executor;

    protected Builder(@Nullable Executor executor) {
      this.executor = executor;
    }

    /**
     * @return The {@link Executor} user callbacks will execute on, If null, the default executor
     *     will be used.
     */
    @Nullable
    public Executor getExecutor() {
      return executor;
    }

    /**
     * @param executor The {@link Executor} user callbacks will executed on. If null, the default
     *     executor will be used.
     * @return {@code this} builder
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    public B setExecutor(@Nullable Executor executor) {
      this.executor = executor;
      return (B) this;
    }

    /**
     * @return an instance of {@link TransactionOptions} from the values passed to this builder
     */
    @Nonnull
    public abstract TransactionOptions build();
  }

  /**
   * A typesafe builder class representing those options that are applicable when configuring a
   * transaction to be read-only. All methods function as "set" rather than returning a new copy
   * with a value set on it.
   */
  public static final class ReadOnlyOptionsBuilder extends Builder<ReadOnlyOptionsBuilder> {
    @Nullable private TimestampOrBuilder readTime;

    private ReadOnlyOptionsBuilder(@Nullable Executor executor, @Nullable Timestamp readTime) {
      super(executor);
      this.readTime = readTime;
    }

    /**
     * @return the currently set value that will be used as the readTime.
     */
    @Nullable
    public TimestampOrBuilder getReadTime() {
      return readTime;
    }

    /**
     * Specify to read documents at the given time. This may not be more than 60 minutes in the past
     * from when the request is processed by the server.
     *
     * @param readTime The specific time to read documents at. Must not be older than 60 minutes. A
     *     null value means read most up to date data.
     * @return {@code this} builder
     */
    @Nonnull
    public ReadOnlyOptionsBuilder setReadTime(@Nullable TimestampOrBuilder readTime) {
      this.readTime = readTime;
      return this;
    }

    @Nonnull
    @Override
    public TransactionOptions build() {
      final Timestamp timestamp;
      if (readTime != null && readTime instanceof Timestamp.Builder) {
        timestamp = ((Timestamp.Builder) readTime).build();
      } else {
        timestamp = (Timestamp) readTime;
      }
      return new TransactionOptions(executor, TransactionOptionsType.READ_ONLY, 1, timestamp);
    }
  }

  /**
   * A typesafe builder class representing those options that are applicable when configuring a
   * transaction to be read-write. All methods function as "set" rather than returning a new copy
   * with a value set on it. By default, a read-write transaction will be attempted a max of 5
   * times.
   */
  public static final class ReadWriteOptionsBuilder extends Builder<ReadWriteOptionsBuilder> {
    private int numberOfAttempts;

    private ReadWriteOptionsBuilder(@Nullable Executor executor, int numberOfAttempts) {
      super(executor);
      this.numberOfAttempts = numberOfAttempts;
    }

    /**
     * Specify the max number of attempts a transaction will be attempted before resulting in an
     * error.
     *
     * @return The max number of attempts to try and commit the transaction.
     */
    public int getNumberOfAttempts() {
      return numberOfAttempts;
    }

    /**
     * Specify the max number of attempts a transaction will be attempted before resulting in an
     * error.
     *
     * @param numberOfAttempts The max number of attempts to try and commit the transaction.
     * @return {@code this} builder
     * @throws IllegalArgumentException if numberOfAttempts is less than or equal to 0
     */
    @Nonnull
    public ReadWriteOptionsBuilder setNumberOfAttempts(int numberOfAttempts) {
      Preconditions.checkArgument(numberOfAttempts > 0, "You must allow at least one attempt");
      this.numberOfAttempts = numberOfAttempts;
      return this;
    }

    @Nonnull
    @Override
    public TransactionOptions build() {
      return new TransactionOptions(
          executor, TransactionOptionsType.READ_WRITE, numberOfAttempts, null);
    }
  }

  public enum TransactionOptionsType {
    READ_ONLY,
    READ_WRITE
  }
}
