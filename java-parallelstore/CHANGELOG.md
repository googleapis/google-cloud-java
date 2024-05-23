# Changelog

## 0.7.0 (2024-05-23)

### Features

* An existing field `end_time` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata`
* An existing field `source` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata`
* An existing field `destination` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata`
* An existing field `create_time` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata`
* An existing field `destination_path` is renamed to `destination_parallelstore` in message `.google.cloud.parallelstore.v1beta.ImportDataRequest`
* An existing field `source_path` is renamed to `source_parallelstore` in message `.google.cloud.parallelstore.v1beta.ExportDataRequest`
* An existing field `destination_gcs_uri` is renamed to `destination_gcs_bucket` in message `.google.cloud.parallelstore.v1beta.ExportDataRequest`
* An existing field `source_gcs_uri` is renamed to `source_gcs_bucket` in message `.google.cloud.parallelstore.v1beta.ImportDataRequest`
* A new field `api_version` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `api_version` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `create_time` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `create_time` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `destination_gcs_bucket` is added to message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `destination_parallelstore` is added to message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `end_time` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `end_time` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `requested_cancellation` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `requested_cancellation` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `source_gcs_bucket` is added to message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `source_parallelstore` is added to message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `status_message` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `status_message` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `target` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `target` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `verb` is added to message `.google.cloud.parallelstore.v1beta.ExportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new field `verb` is added to message `.google.cloud.parallelstore.v1beta.ImportDataMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A new message `DestinationGcsBucket` is added ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* A new message `DestinationParallelstore` is added ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* A new message `SourceGcsBucket` is added ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* A new message `SourceParallelstore` is added ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* An existing field `create_time` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* An existing field `destination_gcs_uri` is renamed to `destination_gcs_bucket` in message `.google.cloud.parallelstore.v1beta.ExportDataRequest` ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* An existing field `destination_path` is renamed to `destination_parallelstore` in message `.google.cloud.parallelstore.v1beta.ImportDataRequest` ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* An existing field `destination` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* An existing field `end_time` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* An existing field `source_gcs_uri` is renamed to `source_gcs_bucket` in message `.google.cloud.parallelstore.v1beta.ImportDataRequest` ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* An existing field `source_path` is renamed to `source_parallelstore` in message `.google.cloud.parallelstore.v1beta.ExportDataRequest` ([46fa9ba](https://github.com/googleapis/google-cloud-java/commit/46fa9ba2eb614ba41ab527e13b0c400fe54b58e0))
* An existing field `source` is removed from message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A comment for field `counters` in message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` is changed ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))
* A comment for field `transfer_type` in message `.google.cloud.parallelstore.v1beta.TransferOperationMetadata` is changed ([821a3ea](https://github.com/googleapis/google-cloud-java/commit/821a3ea08819cb88d9c186178e29ad6fde611830))



## 0.6.0 (2024-05-08)

### Features

* fix typo in Instance.reserved_ip_range field doc ([8179bb9](https://github.com/googleapis/google-cloud-java/commit/8179bb98325eee54b44f44622e0157429539ec50))



## 0.5.0 (2024-04-25)

* No change


## 0.4.0 (2024-04-04)

* No change


## 0.2.0 (2024-03-28)

* No change


## 0.1.0 (2024-03-22)

### Features

* new module for parallelstore ([#10593](https://github.com/googleapis/google-cloud-java/issues/10593)) ([d688172](https://github.com/googleapis/google-cloud-java/commit/d68817289298a743aaa4331799f71fd769a6e624))

