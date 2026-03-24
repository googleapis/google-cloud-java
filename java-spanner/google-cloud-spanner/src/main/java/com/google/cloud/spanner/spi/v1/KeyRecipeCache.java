/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RecipeList;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@InternalApi
public final class KeyRecipeCache {
  // Best-effort routing cache; compute calls are intentionally unsynchronized and may race with
  // updates. Requests still succeed without routing hints when data is stale.
  private static final Logger logger = Logger.getLogger(KeyRecipeCache.class.getName());
  private static final long DEFAULT_SCHEMA_RECIPE_CACHE_SIZE = 1000;
  private static final long DEFAULT_PREPARED_QUERY_CACHE_SIZE = 1000;
  private static final long DEFAULT_PREPARED_READ_CACHE_SIZE = 1000;

  @VisibleForTesting
  static long fingerprint(ReadRequest req) {
    Hasher hasher = Hashing.goodFastHash(64).newHasher();
    hasher.putString(req.getTable(), StandardCharsets.UTF_8);
    hasher.putString(req.getIndex(), StandardCharsets.UTF_8);
    hasher.putInt(req.getColumnsCount());
    for (String column : req.getColumnsList()) {
      hasher.putString(column, StandardCharsets.UTF_8);
    }
    return hasher.hash().asLong();
  }

  @VisibleForTesting
  static long fingerprint(ExecuteSqlRequest req) {
    Hasher hasher = Hashing.goodFastHash(64).newHasher();
    hasher.putString(req.getSql(), StandardCharsets.UTF_8);

    List<String> paramNames = new ArrayList<>(req.getParams().getFieldsMap().keySet());
    paramNames.sort(Comparator.naturalOrder());
    for (String name : paramNames) {
      hasher.putString(name, StandardCharsets.UTF_8);
      if (req.getParamTypesMap().containsKey(name)) {
        hasher.putBytes(req.getParamTypesMap().get(name).toByteArray());
      } else {
        Value value = req.getParams().getFieldsMap().get(name);
        hasher.putInt(value.getKindCase().getNumber());
      }
    }

    hasher.putBytes(req.getQueryOptions().toByteArray());
    return hasher.hash().asLong();
  }

  private final AtomicLong nextOperationUid = new AtomicLong(1);
  private volatile ByteString schemaGeneration = ByteString.EMPTY;

  private final Cache<String, KeyRecipe> schemaRecipes =
      CacheBuilder.newBuilder().maximumSize(DEFAULT_SCHEMA_RECIPE_CACHE_SIZE).build();
  private final Cache<Long, KeyRecipe> queryRecipes =
      CacheBuilder.newBuilder().maximumSize(DEFAULT_PREPARED_QUERY_CACHE_SIZE).build();
  private final Cache<Long, PreparedRead> preparedReads =
      CacheBuilder.newBuilder().maximumSize(DEFAULT_PREPARED_READ_CACHE_SIZE).build();
  private final Cache<Long, PreparedQuery> preparedQueries =
      CacheBuilder.newBuilder().maximumSize(DEFAULT_PREPARED_QUERY_CACHE_SIZE).build();

  public KeyRecipeCache() {}

  private static <K, V> V getIfPresent(Cache<K, V> cache, K key) {
    return cache.getIfPresent(key);
  }

  @VisibleForTesting
  static int getPreparedReadCacheSize(KeyRecipeCache cache) {
    return (int) cache.preparedReads.size();
  }

  @VisibleForTesting
  static int getPreparedQueryCacheSize(KeyRecipeCache cache) {
    return (int) cache.preparedQueries.size();
  }

  /**
   * Applies recipes from a server CacheUpdate.
   *
   * <p>This is expected to be called only when responses include new recipes, not on every request.
   * It is synchronized to atomically update schema generation and cache contents.
   */
  public synchronized void addRecipes(RecipeList recipeList) {
    int cmp =
        ByteString.unsignedLexicographicalComparator()
            .compare(recipeList.getSchemaGeneration(), schemaGeneration);
    if (cmp < 0) {
      return;
    }
    if (cmp > 0) {
      schemaGeneration = recipeList.getSchemaGeneration();
      schemaRecipes.invalidateAll();
      queryRecipes.invalidateAll();
    }

    int failedCount = 0;
    IllegalArgumentException failureExample = null;
    for (com.google.spanner.v1.KeyRecipe recipeProto : recipeList.getRecipeList()) {
      try {
        KeyRecipe recipe = KeyRecipe.create(recipeProto);
        if (recipeProto.hasTableName()) {
          schemaRecipes.put(recipeProto.getTableName(), recipe);
        } else if (recipeProto.hasIndexName()) {
          schemaRecipes.put(recipeProto.getIndexName(), recipe);
        } else if (recipeProto.hasOperationUid()) {
          queryRecipes.put(recipeProto.getOperationUid(), recipe);
        }
      } catch (IllegalArgumentException e) {
        failedCount++;
        if (failureExample == null) {
          failureExample = e;
        }
      }
    }
    if (failedCount > 0) {
      logger.warning(
          "Failed to add " + failedCount + " recipes, example: " + failureExample.getMessage());
    }
  }

  public void computeKeys(ReadRequest.Builder reqBuilder) {
    long reqFp = fingerprint(reqBuilder.buildPartial());

    RoutingHint.Builder hintBuilder = reqBuilder.getRoutingHintBuilder();
    if (!schemaGeneration.isEmpty()) {
      hintBuilder.setSchemaGeneration(schemaGeneration);
    }

    PreparedRead preparedRead = getIfPresent(preparedReads, reqFp);
    if (preparedRead == null) {
      preparedRead = PreparedRead.fromRequest(reqBuilder.buildPartial());
      preparedRead.operationUid = nextOperationUid.getAndIncrement();
      preparedReads.put(reqFp, preparedRead);
    } else if (!preparedRead.matches(reqBuilder.buildPartial())) {
      logger.fine("Fingerprint collision for ReadRequest: " + reqFp);
      return;
    }

    hintBuilder.setOperationUid(preparedRead.operationUid);
    String recipeKey = reqBuilder.getTable();
    if (!reqBuilder.getIndex().isEmpty()) {
      recipeKey = reqBuilder.getIndex();
    }

    KeyRecipe recipe = getIfPresent(schemaRecipes, recipeKey);
    if (recipe == null) {
      logger.fine("Schema recipe not found for: " + recipeKey);
      return;
    }

    try {
      TargetRange target = recipe.keySetToTargetRange(reqBuilder.getKeySet());
      hintBuilder.setKey(target.start);
      if (!target.limit.isEmpty()) {
        hintBuilder.setLimitKey(target.limit);
      }
    } catch (IllegalArgumentException e) {
      logger.fine("Failed key encoding: " + e.getMessage());
    }
  }

  public void computeKeys(ExecuteSqlRequest.Builder reqBuilder) {
    long reqFp = fingerprint(reqBuilder.buildPartial());

    RoutingHint.Builder hintBuilder = reqBuilder.getRoutingHintBuilder();
    if (!schemaGeneration.isEmpty()) {
      hintBuilder.setSchemaGeneration(schemaGeneration);
    }

    PreparedQuery preparedQuery = getIfPresent(preparedQueries, reqFp);
    if (preparedQuery == null) {
      preparedQuery = PreparedQuery.fromRequest(reqBuilder.buildPartial());
      preparedQuery.operationUid = nextOperationUid.getAndIncrement();
      preparedQueries.put(reqFp, preparedQuery);
    } else if (!preparedQuery.matches(reqBuilder.buildPartial())) {
      logger.fine("Fingerprint collision for ExecuteSqlRequest: " + reqFp);
      return;
    }

    hintBuilder.setOperationUid(preparedQuery.operationUid);
    KeyRecipe recipe = getIfPresent(queryRecipes, preparedQuery.operationUid);
    if (recipe == null) {
      return;
    }

    try {
      TargetRange target = recipe.queryParamsToTargetRange(reqBuilder.getParams());
      hintBuilder.setKey(target.start);
      if (!target.limit.isEmpty()) {
        hintBuilder.setLimitKey(target.limit);
      }
    } catch (IllegalArgumentException e) {
      logger.fine("Failed query param encoding: " + e.getMessage());
    }
  }

  public TargetRange mutationToTargetRange(Mutation mutation) {
    if (mutation == null) {
      return null;
    }
    String tableName = tableNameFromMutation(mutation);
    if (tableName == null || tableName.isEmpty()) {
      return null;
    }

    KeyRecipe recipe = getIfPresent(schemaRecipes, tableName);
    if (recipe == null) {
      logger.fine("Schema recipe not found for mutation table: " + tableName);
      return null;
    }

    try {
      return recipe.mutationToTargetRange(mutation);
    } catch (IllegalArgumentException e) {
      logger.fine("Failed mutation key encoding: " + e.getMessage());
      return null;
    }
  }

  private static String tableNameFromMutation(Mutation mutation) {
    switch (mutation.getOperationCase()) {
      case INSERT:
        return mutation.getInsert().getTable();
      case UPDATE:
        return mutation.getUpdate().getTable();
      case INSERT_OR_UPDATE:
        return mutation.getInsertOrUpdate().getTable();
      case REPLACE:
        return mutation.getReplace().getTable();
      case DELETE:
        return mutation.getDelete().getTable();
      default:
        return null;
    }
  }

  public synchronized void clear() {
    schemaGeneration = ByteString.EMPTY;
    preparedReads.invalidateAll();
    preparedQueries.invalidateAll();
    schemaRecipes.invalidateAll();
    queryRecipes.invalidateAll();
  }

  private static class PreparedRead {
    final String table;
    final ImmutableList<String> columns;
    long operationUid; // Not final, assigned after construction

    private PreparedRead(String table, List<String> columns) {
      this.table = table;
      this.columns = ImmutableList.copyOf(columns);
    }

    static PreparedRead fromRequest(ReadRequest req) {
      return new PreparedRead(req.getTable(), req.getColumnsList());
    }

    boolean matches(ReadRequest req) {
      if (!Objects.equals(table, req.getTable())) {
        return false;
      }
      return columns.equals(req.getColumnsList());
    }
  }

  private static final class PreparedQuery {
    private final String sql;
    private final ImmutableList<Param> params;
    private final ExecuteSqlRequest.QueryOptions queryOptions;
    private long operationUid;

    private PreparedQuery(
        String sql, List<Param> params, ExecuteSqlRequest.QueryOptions queryOptions) {
      this.sql = sql;
      this.params = ImmutableList.copyOf(params);
      this.queryOptions = queryOptions;
    }

    private static PreparedQuery fromRequest(ExecuteSqlRequest req) {
      List<Param> params = new ArrayList<>();
      for (Map.Entry<String, Value> entry : req.getParams().getFieldsMap().entrySet()) {
        String name = entry.getKey();
        if (req.getParamTypesMap().containsKey(name)) {
          params.add(Param.ofType(name, req.getParamTypesMap().get(name)));
        } else {
          params.add(Param.ofKind(name, entry.getValue().getKindCase()));
        }
      }
      params.sort(Comparator.comparing(param -> param.name));
      return new PreparedQuery(req.getSql(), params, req.getQueryOptions());
    }

    private boolean matches(ExecuteSqlRequest req) {
      if (!sql.equals(req.getSql())) {
        return false;
      }
      if (params.size() != req.getParams().getFieldsCount()) {
        return false;
      }
      for (Param param : params) {
        Value value = req.getParams().getFieldsMap().get(param.name);
        if (value == null) {
          return false;
        }
        if (param.type != null) {
          Type type = req.getParamTypesMap().get(param.name);
          if (type == null || !type.equals(param.type)) {
            return false;
          }
        } else if (param.kindCase != value.getKindCase()) {
          return false;
        }
      }
      return Objects.equals(queryOptions, req.getQueryOptions());
    }
  }

  private static final class Param {
    private final String name;
    private final Type type;
    private final Value.KindCase kindCase;

    private Param(String name, Type type, Value.KindCase kindCase) {
      this.name = name;
      this.type = type;
      this.kindCase = kindCase;
    }

    private static Param ofType(String name, Type type) {
      return new Param(name, type, null);
    }

    private static Param ofKind(String name, Value.KindCase kindCase) {
      return new Param(name, null, kindCase);
    }
  }
}
