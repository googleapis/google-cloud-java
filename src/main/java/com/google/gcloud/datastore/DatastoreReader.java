package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * An interface to represent Google Cloud Datastore read operations.
 */
public interface DatastoreReader {

  Entity get(Key key);

  // results are returned using request order
  Iterator<Entity> get(Key... key);

  QueryResult<PartialEntity> runQuery(Query query);
}
