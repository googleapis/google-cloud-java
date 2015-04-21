/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.examples;

import com.google.gcloud.datastore.DatastoreService;
import com.google.gcloud.datastore.DatastoreServiceFactory;
import com.google.gcloud.datastore.DatastoreServiceOptions;
import com.google.gcloud.datastore.DateTime;
import com.google.gcloud.datastore.Entity;
import com.google.gcloud.datastore.FullEntity;
import com.google.gcloud.datastore.IncompleteKey;
import com.google.gcloud.datastore.Key;
import com.google.gcloud.datastore.KeyFactory;
import com.google.gcloud.datastore.Query;
import com.google.gcloud.datastore.Query.ResultType;
import com.google.gcloud.datastore.QueryResults;
import com.google.gcloud.datastore.StructuredQuery.PropertyFilter;
import com.google.gcloud.datastore.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * An example of using the Google Cloud Datastore.
 * <p>
 * This example adds, display or clear comments for a given user.
 * <p>
 * Steps needed for running the example:<ol>
 * <li>login using gcloud SDK - {@code gcloud auth login}.</li>
 * <li>compile using maven - {@code mvn compile}</li>
 * <li>run using maven - {@code mvn exec:java
 * -Dexec.mainClass="com.google.gcloud.examples.DatastoreExample"
 * -Dexec.args="dataset [user] [delete|display|add comment]"}</li>
 * </ol>
 */
public class DatastoreExample {

  private static final String USER_KIND = "_DS_EXAMPLE_USER";
  private static final String COMMENT_KIND = "_DS_EXAMPLE_COMMENT";
  private static final String NAMESPACE = "gcloud_java_example";
  private static final String DEFAULT_ACTION = "display";
  private static final Map<String, DatastoreAction> ACTIONS = new HashMap<>();

  private interface DatastoreAction {
    void run(Transaction tx, Key userKey, String... args);
    String getRequiredParams();
  }

  private static class DeleteAction implements DatastoreAction {
    @Override
    public void run(Transaction tx, Key userKey, String... args) {
      Entity user = tx.get(userKey);
      if (user == null) {
        System.out.println("Nothing to delete, user does not exists.");
        return;
      }
      Query<Key> query = Query.keyQueryBuilder()
          .namespace(NAMESPACE)
          .kind(COMMENT_KIND)
          .filter(PropertyFilter.hasAncestor(userKey))
          .build();
      QueryResults<Key> comments = tx.run(query);
      int count = 0;
      while (comments.hasNext()) {
        tx.delete(comments.next());
        count++;
      }
      tx.delete(userKey);
      System.out.printf("Deleting user '%s' and %d comment[s].%n", userKey.name(), count);
    }

    @Override
    public String getRequiredParams() {
      return "";
    }
  }

  private static class DisplayAction implements DatastoreAction {
    @Override
    public void run(Transaction tx, Key userKey, String... args) {
      Entity user = tx.get(userKey);
      if (user == null) {
        System.out.println("No comments for '" + userKey.name() + "'.");
        return;
      }
      System.out.printf("User '%s' has %d comment[s].%n", userKey.name(), user.getLong("count"));
      // ORDER BY timestamp";
      String gql = "SELECT * FROM " + COMMENT_KIND + " WHERE __key__ HAS ANCESTOR @1";
      Query<Entity> query = Query.gqlQueryBuilder(ResultType.ENTITY, gql)
          .namespace(NAMESPACE)
          .addBinding(userKey)
          .build();
      QueryResults<Entity> results = tx.run(query);
      // We could have added "ORDER BY timestamp" to the query to avoid the sorting bellow
      // but that would require adding an ancestor index for timestamp
      // see: https://cloud.google.com/datastore/docs/tools/indexconfig
      Map<DateTime, String> sortedComments = new TreeMap<>();
      while (results.hasNext()) {
        Entity result = results.next();
        sortedComments.put(result.getDateTime("timestamp"), result.getString("content"));
      }
      for (Map.Entry<DateTime, String> entry : sortedComments.entrySet()) {
        System.out.printf("\t%s: %s%n", entry.getKey(), entry.getValue());
      }
    }

    @Override
    public String getRequiredParams() {
      return "";
    }
  }

  private static class AddAction implements DatastoreAction {
    @Override
    public void run(Transaction tx, Key userKey, String... args) {
      Entity user = tx.get(userKey);
      if (user == null) {
        System.out.println("Adding a new user.");
        user = Entity.builder(userKey)
            .set("count", 1L)
            .build();
        tx.add(user);
      } else {
        user = Entity.builder(user).set("count", user.getLong("count") + 1L).build();
        tx.update(user);
      }
      String content = "No comment.";
      if (args.length > 0) {
        StringBuilder stBuilder = new StringBuilder();
        for (String arg : args) {
          stBuilder.append(arg).append(' ');
        }
        stBuilder.setLength(stBuilder.length() - 1);
        content = stBuilder.toString();
      }
      IncompleteKey commentKey = IncompleteKey.builder(userKey, COMMENT_KIND).build();
      FullEntity<IncompleteKey> comment = FullEntity.builder(commentKey)
          .set("content", content)
          .set("timestamp", DateTime.now())
          .build();
      tx.addWithDeferredIdAllocation(comment);
      System.out.println("Adding a comment to user '" + userKey.name() + "'.");
    }

    @Override
    public String getRequiredParams() {
      return "comment";
    }
  }

  static {
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("add", new AddAction());
    ACTIONS.put("display", new DisplayAction());
  }

  public static void main(String... args) {
    DatastoreAction action = null;
    DatastoreService datastore = null;
    Key key = null;
    if (args.length > 0) {
      String dataset = args[0];
      // If you want to access a local Datastore running via the gcd sdk, do
//          DatastoreServiceOptions options = DatastoreServiceOptions.builder()
//              .dataset(dataset)
//              .namespace(NAMESPACE)
//              .host("http://localhost:8080")
//              .build();
      DatastoreServiceOptions options = DatastoreServiceOptions.builder()
          .dataset(dataset)
          .namespace(NAMESPACE)
          .build();
      String name = args.length > 1 ? args[1] : System.getProperty("user.name");
      datastore = DatastoreServiceFactory.instance().get(options);
      KeyFactory keyFactory = datastore.newKeyFactory().kind(USER_KIND);
      key = keyFactory.newKey(name);
      String actionName = args.length > 2 ? args[2].toLowerCase() : DEFAULT_ACTION;
      action = ACTIONS.get(actionName);
    }
    if (action == null) {
      StringBuilder actionAndParams = new StringBuilder();
      for (Map.Entry<String, DatastoreAction> entry : ACTIONS.entrySet()) {
        actionAndParams.append(entry.getKey());
        String param = entry.getValue().getRequiredParams();
        if (param != null && !param.isEmpty()) {
          actionAndParams.append(' ').append(param);
        }
        actionAndParams.append('|');
      }
      actionAndParams.setLength(actionAndParams.length() - 1);
      System.out.printf("Usage: %s dataset [user] [%s]%n",
          DatastoreExample.class.getSimpleName(), actionAndParams);
      return;
    }
    args = args.length > 3 ? Arrays.copyOfRange(args, 3, args.length): new String []{};
    Transaction tx = datastore.newTransaction();
    try {
      action.run(tx, key, args);
      tx.commit();
    } finally {
      if (tx.active()) {
        tx.rollback();
      }
    }
  }
}
