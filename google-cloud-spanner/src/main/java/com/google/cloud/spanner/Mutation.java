/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * Represents an individual table modification to be applied to Cloud Spanner.
 *
 * <p>The types of mutation that can be created are defined by {@link Op}. To construct a mutation,
 * use one of the builder methods. For example, to create a mutation that will insert a value of "x"
 * into "C1" and a value of "y" into "C2" of table "T", write the following code:
 *
 * <pre>
 *     Mutation m = Mutation.newInsertBuilder("T")
 *         .set("C1").to("x")
 *         .set("C2").to("y")
 *         .build();
 * </pre>
 *
 * Mutations are applied to a database by performing a standalone write or buffering them as part of
 * a transaction. TODO(user): Add links/code samples once the corresponding APIs are available.
 *
 * <p>{@code Mutation} instances are immutable.
 */
public final class Mutation {
  /** Enumerates the types of mutation that can be applied. */
  public enum Op {
    /**
     * Inserts a new row in a table. If the row already exists, the write or transaction fails with
     * {@link ErrorCode#ALREADY_EXISTS}.
     */
    INSERT,

    /**
     * Updates an existing row in a table. If the row does not already exist, the transaction fails
     * with error {@link ErrorCode#NOT_FOUND}.
     */
    UPDATE,

    /**
     * Like {@link #INSERT}, except that if the row already exists, then its column values are
     * overwritten with the ones provided. Any column values not explicitly written are preserved.
     */
    INSERT_OR_UPDATE,

    /**
     * Like {@link #INSERT}, except that if the row already exists, it is deleted, and the column
     * values provided are inserted instead. Unlike {@link #INSERT_OR_UPDATE}, this means any values
     * not explicitly written become {@code NULL}.
     */
    REPLACE,

    /** Deletes rows from a table. Succeeds whether or not the named rows were present. */
    DELETE,
  }

  private final String table;
  private final Op operation;
  private final ImmutableList<String> columns;
  private final ImmutableList<Value> values;
  private final KeySet keySet;

  private Mutation(
      String table,
      Op operation,
      @Nullable ImmutableList<String> columns,
      @Nullable ImmutableList<Value> values,
      @Nullable KeySet keySet) {
    this.table = table;
    this.operation = operation;
    this.columns = columns;
    this.values = values;
    this.keySet = keySet;
  }

  /**
   * Returns a builder that can be used to construct an {@link Op#INSERT} mutation against {@code
   * table}; see the {@code INSERT} documentation for mutation semantics.
   */
  public static WriteBuilder newInsertBuilder(String table) {
    return new WriteBuilder(table, Op.INSERT);
  }

  /**
   * Returns a builder that can be used to construct an {@link Op#UPDATE} mutation against {@code
   * table}; see the {@code UPDATE} documentation for mutation semantics.
   */
  public static WriteBuilder newUpdateBuilder(String table) {
    return new WriteBuilder(table, Op.UPDATE);
  }

  /**
   * Returns a builder that can be used to construct an {@link Op#INSERT_OR_UPDATE} mutation against
   * {@code table}; see the {@code INSERT_OR_UPDATE} documentation for mutation semantics.
   */
  public static WriteBuilder newInsertOrUpdateBuilder(String table) {
    return new WriteBuilder(table, Op.INSERT_OR_UPDATE);
  }

  /**
   * Returns a builder that can be used to construct an {@link Op#REPLACE} mutation against {@code
   * table}; see the {@code REPLACE} documentation for mutation semantics.
   */
  public static WriteBuilder newReplaceBuilder(String table) {
    return new WriteBuilder(table, Op.REPLACE);
  }

  /**
   * Returns a mutation that will delete the row with primary key {@code key}. Exactly equivalent to
   * {@code delete(table, KeySet.singleKey(key))}.
   */
  public static Mutation delete(String table, Key key) {
    return delete(table, KeySet.singleKey(key));
  }

  /** Returns a mutation that will delete all rows with primary keys covered by {@code keySet}. */
  public static Mutation delete(String table, KeySet keySet) {
    return new Mutation(table, Op.DELETE, null, null, checkNotNull(keySet));
  }

  /**
   * Builder for {@link Op#INSERT}, {@link Op#INSERT_OR_UPDATE}, {@link Op#UPDATE}, and {@link
   * Op#REPLACE} mutations.
   */
  public static class WriteBuilder {
    private final String table;
    private final Op operation;
    private final ImmutableList.Builder<String> columns;
    private final ImmutableList.Builder<Value> values;
    private final ValueBinder<WriteBuilder> binder;
    private String currentColumn;

    private WriteBuilder(String table, Op operation) {
      this.table = checkNotNull(table);
      this.operation = operation;
      // Empty writes are sufficiently rare that it is not worth optimizing for that case.
      this.columns = ImmutableList.builder();
      this.values = ImmutableList.builder();
      class BinderImpl extends ValueBinder<WriteBuilder> {
        @Override
        WriteBuilder handle(Value value) {
          checkBindingInProgress(true);
          columns.add(currentColumn);
          values.add(value);
          currentColumn = null;
          return WriteBuilder.this;
        }
      }
      this.binder = new BinderImpl();
    }

    /**
     * Returns a binder to set the value of {@code columnName} that should be applied by the
     * mutation.
     */
    public ValueBinder<WriteBuilder> set(String columnName) {
      checkBindingInProgress(false);
      currentColumn = checkNotNull(columnName);
      return binder;
    }

    public Mutation build() {
      checkBindingInProgress(false);
      return new Mutation(table, operation, columns.build(), values.build(), null);
    }

    private void checkBindingInProgress(boolean expectInProgress) {
      if (expectInProgress) {
        checkState(currentColumn != null, "No binding currently active");
      } else if (currentColumn != null) {
        throw new IllegalStateException("Incomplete binding for column " + currentColumn);
      }
    }
  }

  /** Returns the name of the table that this mutation will affect. */
  public String getTable() {
    return table;
  }

  /** Returns the type of operation that this mutation will perform. */
  public Op getOperation() {
    return operation;
  }

  /**
   * For all types except {@link Op#DELETE}, returns the columns that this mutation will affect.
   *
   * @throws IllegalStateException if {@code operation() == Op.DELETE}
   */
  public Iterable<String> getColumns() {
    checkState(operation != Op.DELETE, "columns() cannot be called for a DELETE mutation");
    return columns;
  }

  /**
   * For all types except {@link Op#DELETE}, returns the values that this mutation will write. The
   * number of elements returned is always the same as the number returned by {@link #getColumns()},
   * and the {@code i}th value corresponds to the {@code i}th column.
   *
   * @throws IllegalStateException if {@code operation() == Op.DELETE}
   */
  public Iterable<Value> getValues() {
    checkState(operation != Op.DELETE, "values() cannot be called for a DELETE mutation");
    return values;
  }

  /**
   * For all types except {@link Op#DELETE}, constructs a map from column name to value. This is
   * mainly intended as a convenience for testing; direct access via {@link #getColumns()} and
   * {@link #getValues()} is more efficient.
   *
   * @throws IllegalStateException if {@code operation() == Op.DELETE}, or if any duplicate columns
   *     are present. Detection of duplicates does not consider case.
   */
  public Map<String, Value> asMap() {
    checkState(operation != Op.DELETE, "asMap() cannot be called for a DELETE mutation");
    LinkedHashMap<String, Value> map = new LinkedHashMap<>();
    for (int i = 0; i < columns.size(); ++i) {
      Value existing = map.put(columns.get(i), values.get(i));
      if (existing != null) {
        throw new IllegalStateException("Duplicate column: " + columns.get(i));
      }
    }
    return Collections.unmodifiableMap(map);
  }

  /**
   * For {@link Op#DELETE} mutations, returns the key set that defines the rows to be deleted.
   *
   * @throws IllegalStateException if {@code operation() != Op.DELETE}
   */
  public KeySet getKeySet() {
    checkState(operation == Op.DELETE, "keySet() can only be called for a DELETE mutation");
    return keySet;
  }

  void toString(StringBuilder b) {
    String opName;
    boolean isWrite;
    switch (operation) {
      case INSERT:
        opName = "insert";
        isWrite = true;
        break;
      case INSERT_OR_UPDATE:
        opName = "insert_or_update";
        isWrite = true;
        break;
      case UPDATE:
        opName = "update";
        isWrite = true;
        break;
      case REPLACE:
        opName = "replace";
        isWrite = true;
        break;
      case DELETE:
        opName = "delete";
        isWrite = false;
        break;
      default:
        throw new AssertionError("Unhandled Op: " + operation);
    }
    if (isWrite) {
      b.append(opName).append('(').append(table).append('{');
      for (int i = 0; i < columns.size(); ++i) {
        if (i > 0) {
          b.append(',');
        }
        b.append(columns.get(i));
        b.append('=');
        b.append(values.get(i));
      }
      b.append("})");
    } else {
      b.append("delete(").append(table);
      keySet.toString(b);
      b.append(')');
    }
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    toString(b);
    return b.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Mutation that = (Mutation) o;
    return operation == that.operation
        && Objects.equals(table, that.table)
        && Objects.equals(columns, that.columns)
        && Objects.equals(values, that.values)
        && Objects.equals(keySet, that.keySet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, table, columns, values, keySet);
  }

  static void toProto(Iterable<Mutation> mutations, List<com.google.spanner.v1.Mutation> out) {
    Mutation last = null;
    // The mutation currently being built.
    com.google.spanner.v1.Mutation.Builder proto = null;
    // The "write" (!= DELETE) or "keySet" (==DELETE) for the last mutation encoded, for coalescing.
    com.google.spanner.v1.Mutation.Write.Builder write = null;
    com.google.spanner.v1.KeySet.Builder keySet = null;
    for (Mutation mutation : mutations) {
      if (mutation.operation == Op.DELETE) {
        if (last != null && last.operation == Op.DELETE && mutation.table.equals(last.table)) {
          mutation.keySet.appendToProto(keySet);
        } else {
          if (proto != null) {
            out.add(proto.build());
          }
          proto = com.google.spanner.v1.Mutation.newBuilder();
          com.google.spanner.v1.Mutation.Delete.Builder delete =
              proto.getDeleteBuilder().setTable(mutation.table);
          keySet = delete.getKeySetBuilder();
          mutation.keySet.appendToProto(keySet);
        }
        write = null;
      } else {
        ListValue.Builder values = ListValue.newBuilder();
        for (Value value : mutation.getValues()) {
          values.addValues(value.toProto());
        }
        if (last != null
            && mutation.operation == last.operation
            && mutation.table.equals(last.table)
            && mutation.columns.equals(last.columns)) {
          // Same as previous mutation: coalesce values to reduce request size.
          write.addValues(values);
        } else {
          if (proto != null) {
            out.add(proto.build());
          }
          proto = com.google.spanner.v1.Mutation.newBuilder();
          switch (mutation.operation) {
            case INSERT:
              write = proto.getInsertBuilder();
              break;
            case UPDATE:
              write = proto.getUpdateBuilder();
              break;
            case INSERT_OR_UPDATE:
              write = proto.getInsertOrUpdateBuilder();
              break;
            case REPLACE:
              write = proto.getReplaceBuilder();
              break;
            default:
              throw new AssertionError("Impossible: " + mutation.operation);
          }
          write.setTable(mutation.table).addAllColumns(mutation.columns).addValues(values);
        }
        keySet = null;
      }
      last = mutation;
    }
    // Flush last item.
    if (proto != null) {
      out.add(proto.build());
    }
  }
}
