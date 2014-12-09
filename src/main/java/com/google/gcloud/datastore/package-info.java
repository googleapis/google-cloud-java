/**
 * A client to the Google Cloud Datastore.
 * Typical usage would be:
 * <pre> {@code
 * DatastoreServiceOptions options = DatastoreServiceOptions.builder().dataset(DATASET).build();
 * DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
 * KeyBuilder keyBuilder = datastore.newKeyBuilder(kind);
 * Key key = keyBuilder.build(keyName);
 * Entity entity = datastore.get(key);
 * if (entity == null) {
 *   entity = Entity.builder(key)
 *       .setStringProperty("name", "John Do")
 *       .setProperty("age", LongValue.builder(100).indexed(false).build())
 *       .setBooleanProperty("updated", false)
 *       .build();
 *   datastore.put(entity);
 * } else {
 *   boolean updated = entity.booleanProperty("updated");
 *   if (!updated) {
 *     String[] name = entity.stringProperty("name").split(" ");
 *     entity = Entity.builder(entity)
 *         .setStringProperty("name", name[0])
 *         .setProperty("last_name", StringValue.builder(name[1]).indexed(false).build())
 *         .setBooleanProperty("updated", true)
 *         .removeProperty("old_property")
 *         .setDoubleProperty("new_property", 1.1)
 *         .build();
 *     datastore.update(entity);
 *   }
 * }
 * } </pre>
 */
package com.google.gcloud.datastore;
