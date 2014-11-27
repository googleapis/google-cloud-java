package com.google.gcloud.datastore;

import java.util.Iterator;

public interface DatastoreReader {

  Entity get(Key key);

  // results are returned using request order
  Iterator<Entity> get(Key... key);

  // query result item is a tuple of (key, value...) where values may be empty
  //QueryResult runQuery(Query query);
}