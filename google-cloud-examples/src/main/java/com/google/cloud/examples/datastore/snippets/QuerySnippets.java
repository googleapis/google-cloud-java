/*
 * Copyright 2016 Google LLC
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
 * This file is referenced in Query's javadoc. Any change to this file should be reflected in
 * Query's javadoc.
 */

package com.google.cloud.examples.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

/** This class contains a number of snippets for the {@link Query} class. */
public class QuerySnippets {

  private final Datastore datastore;

  public QuerySnippets(Datastore datastore) {
    this.datastore = datastore;
  }

  /** Example of creating and running a GQL query. */
  // [TARGET newGqlQueryBuilder(String)]
  // [VARIABLE "my_kind"]
  public QueryResults<?> newQuery(String kind) {
    // [START newQuery]
    String gqlQuery = "select * from " + kind;
    Query<?> query = Query.newGqlQueryBuilder(gqlQuery).build();
    QueryResults<?> results = datastore.run(query);
    // Use results
    // [END newQuery]
    return results;
  }

  /** Example of creating and running a typed GQL query. */
  // [TARGET newGqlQueryBuilder(ResultType, String)]
  // [VARIABLE "my_kind"]
  public QueryResults<Entity> newTypedQuery(String kind) {
    // [START newTypedQuery]
    String gqlQuery = "select * from " + kind;
    Query<Entity> query = Query.newGqlQueryBuilder(Query.ResultType.ENTITY, gqlQuery).build();
    QueryResults<Entity> results = datastore.run(query);
    // Use results
    // [END newTypedQuery]
    return results;
  }

  /** Example of creating and running an entity query. */
  // [TARGET newEntityQueryBuilder()]
  // [VARIABLE "my_kind"]
  public QueryResults<Entity> newEntityQuery(String kind) {
    // [START newEntityQuery]
    Query<Entity> query = Query.newEntityQueryBuilder().setKind(kind).build();
    QueryResults<Entity> results = datastore.run(query);
    // Use results
    // [END newEntityQuery]
    return results;
  }

  /** Example of creating and running a key query. */
  // [TARGET newKeyQueryBuilder()]
  // [VARIABLE "my_kind"]
  public QueryResults<Key> newKeyQuery(String kind) {
    // [START newKeyQuery]
    Query<Key> query = Query.newKeyQueryBuilder().setKind(kind).build();
    QueryResults<Key> results = datastore.run(query);
    // Use results
    // [END newKeyQuery]
    return results;
  }

  /** Example of creating and running a projection entity query. */
  // [TARGET newProjectionEntityQueryBuilder()]
  // [VARIABLE "my_kind"]
  // [VARIABLE "my_property"]
  public QueryResults<ProjectionEntity> newProjectionEntityQuery(String kind, String property) {
    // [START newProjectionEntityQuery]
    Query<ProjectionEntity> query =
        Query.newProjectionEntityQueryBuilder().setKind(kind).addProjection(property).build();
    QueryResults<ProjectionEntity> results = datastore.run(query);
    // Use results
    // [END newProjectionEntityQuery]
    return results;
  }
}
