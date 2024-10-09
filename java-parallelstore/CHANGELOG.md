# Changelog

## 0.15.0 (2024-10-09)

### Bug Fixes

* minor documentation formatting fix for Parallelstore ([30455f7](https://github.com/googleapis/google-cloud-java/commit/30455f78e0aa9343d7db83d7a1a736ffd7a2b7e6))
* minor documentation formatting fix for Parallelstore ([30455f7](https://github.com/googleapis/google-cloud-java/commit/30455f78e0aa9343d7db83d7a1a736ffd7a2b7e6))



## 0.13.0 (2024-09-26)

### Bug Fixes

* cleanup of Parallelstore API descriptions ([b1293e2](https://github.com/googleapis/google-cloud-java/commit/b1293e24112b911c31c6c0452080ffa4edca462f))



## 0.12.0 (2024-09-11)

* No change


## 0.11.0 (2024-08-21)

### Features

* add file_stripe_level and directory_stripe_level fields to Instance ([4aae553](https://github.com/googleapis/google-cloud-java/commit/4aae5537bed9ddb992a85749aa1199b475c2db87))



## 0.10.0 (2024-07-31)

### Features

* add iam.googleapis.com/ServiceAccount resource definition ([f4a2a5a](https://github.com/googleapis/google-cloud-java/commit/f4a2a5ae3f2771343e09af1933ba4a9ee28edcd6))



## 0.9.0 (2024-06-27)

* No change


## 0.8.0 (None)

* No change


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

