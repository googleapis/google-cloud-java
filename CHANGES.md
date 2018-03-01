# v0.33.0
## BigQuery
- Fix spelling. The name "Bigquery" is some methods are now properly spelled "BigQuery".
- `Job.getQueryResults` now waits for the query to complete.
  - You no longer have to call `Job.waitFor`.
- `BigQuery.getQueryResults(JobId)` is replaced.
  - Instead of `bigquery.getQueryResults(id)`, use `bigquery.getJob(id).getQueryResults()`.
- `BigQuery.query` and `Job.getQueryResults` returns `TableResult`, not `QueryResponse`.
  - Instead of `queryResponse.getResult().iterateAll()`, use `tableResult.iterateAll()`.
  - This change should make iterating large result sets significantly faster.
- `BigQuery.listTableData` and `Table.list` returns `TableResult` instead of `Page<FieldValueList>`.
  - This remains source-compatible, since `TableResult` implements `Page<FieldValueList>`.
  - `TableResult` allows inserting `Shema` into each iterated row.
  - `TableResult.getTotalRows()` can be called to obtain the total number of rows across pages.
- Various `Job` statistics are no longer available at `QueryResponse`.
  - Use `BigQuery.getJob` then `Job.getStatistics` instead.
# v0.36.0
## Pub/Sub
- `TopicName` is renamed to `ProjectTopicName`, and now inherits from a new base class `TopicName`
- `TopicNameOneOf`, `ProjectNameType` are deleted
  - `TopicNameOneOf.parse(String)`: use `TopicNames.parse(String)` instead
  - To check the subtype of the new `TopicName` base class, use `instanceof(...)`
- `SubscriptionName` is renamed to `ProjectSubscriptionName`
- `SnapshotName` is renamed to `ProjectSnapshotName`
- Resource name helper methods are removed from request classes:
  - `setProjectWithProjectName(myProject)`: use `setProject(myProject.toString())` instead
  - `setNameWithTopicName(myTopic)`: use `setName(myTopic.toString())` instead
  - `setTopicWithTopicName(myTopic)`: use `setTopic(myTopic.toString())` instead
  - `setNameWithSubscriptionName(mySubscription)`: use `setName(mySubscription.toString())` instead
  - `setSubscriptionWithSubscriptionName(mySubscription)`: use `setSubscription(mySubscription.toString())` instead
  - `setNameWithSnapshotName(mySnapshot)`: use `setName(mySnapshot.toString())` instead
  - `setSnapshotWithSnapshotName(mySnapshot)`: use `setSnapshot(mySnapshot.toString())` instead
  - `topic.getNameAsTopicName()`: use `ProjectTopicName.parse(topic.getName())`
  - `subscription.getTopicAsTopicNameOneof()`: use `TopicNames.parse(subscription.getTopic())`
  - `subscription.getNameAsSubscriptionName()`: use `ProjectSubscriptionName.parse(subscription.getName())`
  - `snapshot.getNameAsSnapshotName()`: use `ProjectSnapshotName.parse(snapshot.getName())`
