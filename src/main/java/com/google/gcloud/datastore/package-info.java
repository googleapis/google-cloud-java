/**
 * A client to the Google Cloud Datastore.
 *
 * <p>A simple usage example:
 * <pre> {@code
 * DatastoreServiceOptions options = DatastoreServiceOptions.builder().dataset(DATASET).build();
 * DatastoreService datastore = DatastoreServiceFactory.getDefault(options);
 * KeyFactory keyBuilder = datastore.newKeyBuilder(kind);
 * Key key = keyBuilder.build(keyName);
 * Entity entity = datastore.get(key);
 * if (entity == null) {
 *   entity = Entity.builder(key)
 *       .set("name", "John Do")
 *       .set("age", LongValue.builder(100).indexed(false).build())
 *       .set("updated", false)
 *       .build();
 *   datastore.put(entity);
 * } else {
 *   boolean updated = entity.getBoolean("updated");
 *   if (!updated) {
 *     String[] name = entity.getString("name").split(" ");
 *     entity = Entity.builder(entity)
 *         .set("name", name[0])
 *         .set("last_name", StringValue.builder(name[1]).indexed(false).build())
 *         .set("updated", true)
 *         .remove("old_property")
 *         .set("new_property", 1.1)
 *         .build();
 *     datastore.update(entity);
 *   }
 * }
 * } </pre>
 *
 * @see <a href="https://cloud.google.com/datastore/">Google Cloud Datastore</a>
 */
package com.google.gcloud.datastore;
