/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
 * This file is referenced in Query's javadoc. Any change to this file should be reflected in Query's
 * javadoc.
 */

package com.google.cloud.examples.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.Transaction;

/** This class contains a number of snippets for the {@link Transaction} interface. */
public class QuerySnippets {

  private final Transaction transaction;

  public QuerySnippets(Transaction transaction) {
    this.transaction = transaction;
  }

  // [TARGET gqlQueryBuilder(String)]
  public QueryResults<?> newQuery() {
    Datastore datastore = transaction.datastore();
    // [START newQuery]
    Query<?> query = Query.gqlQueryBuilder("select * from kind").build();
    QueryResults<?> results = datastore.run(query);
    // Use results
    // [END newQuery]
    return results;
  }

  // [TARGET gqlQueryBuilder(Query.ResultType, String)]
  public QueryResults<Entity> newTypedQuery() {
    Datastore datastore = transaction.datastore();
    // [START newTypedQuery]
    Query<Entity> query = Query.gqlQueryBuilder(Query.ResultType.ENTITY, "select * from kind").build();
    QueryResults<Entity> results = datastore.run(query);
    // Use results
    // [END newTypedQuery]
    return results;
  }

  // [TARGET gqlQueryBuilder(Query.ResultType, String)]
  public QueryResults<Entity> newEntityQuery(String kind) {
    Datastore datastore = transaction.datastore();
    // [START newEntityQuery]
    Query<Entity> query = Query.entityQueryBuilder().kind(kind).build();
    QueryResults<Entity> results = datastore.run(query);
    // Use results
    // [END newEntityQuery]
    return results;
  }

  // [TARGET keyQueryBuilder(Query.ResultType, String)]
  public Query<Key> newKeyQuery(String kind) {
    Datastore datastore = transaction.datastore();
    // [START newKeyQuery]
    Query<Key> query = Query.keyQueryBuilder().kind(kind).build();
    QueryResults<Key> results = datastore.run(query);
    // Use results
    // [END newKeyQuery]
    return query;
  }

  // [TARGET projectionEntityQueryBuilder(Query.ResultType, String)]
  public Query<ProjectionEntity> newProjectionEntityQuery(String kind) {
    Datastore datastore = transaction.datastore();
    // [START newProjectionEntityQuery]
    Query<ProjectionEntity> query = Query.projectionEntityQueryBuilder().kind(kind).build();
    QueryResults<ProjectionEntity> results = datastore.run(query);
    // Use results
    // [END newProjectionEntityQuery]
    return query;
  }
}
