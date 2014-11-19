package com.google.gcloud.datastore;

import java.util.Map;

public interface DatastoreService {

  DatastoreServiceOptions getOptions();

  CompleteKey put(Key key, Map<String, Value> values);

  Map<String, Value> get(CompleteKey key);

  void delete(CompleteKey... key);

  void allocateIds(Key... key);

  // query result item is a tuple of (key, value...) where values may be empty
  //QueryResult runQuery(Query query);

}
