/**
 * A client to the Google Cloud Datastore.
 * Typical usage would be:
 * <pre> {@code
 * DatastoreServiceOptions options = new DatastoreServiceOptions.Builder().dataset(DATASET).build();
 * DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
 * KeyBuilder keyBuilder = datastore.newKeyBuilder(kind);
 * Key key = keyBuilder.build(keyName);
 * Entity entity = datastore.get(key);
 * if (entity == null) {
 *   entity = new Entity.Builder(key)
 *       .setStringProperty("name", "John Do")
 *       .setProperty("age", new LongValue.Builder(100).indexed(false).build())
 *       .setBooleanProperty("updated", false)
 *       .build();
 *   datastore.put(entity);
 * } else {
 *   boolean updated = entity.booleanProperty("updated");
 *   if (!updated.get) {
 *     String[] name = entity.stringProperty("name").split(" ");
 *     entity = entity.builder()
 *         .setStringProperty("name", name[0])
 *         .setProperty("last_name", new StringProperty.Builder(name[1]).indexed(false).build())
 *         .setBooleanProperty("updated", true)
 *         .removeProperty("old_property")
 *         .setDoubleProperty("new_property", 1.1)
 *         .build();
 *     datastore.update(entity);
 *   }
 * }
 * } </pre>
 *
 */
package com.google.gcloud.datastore;
