# v0.84.0

## Bigtable

  - Remove reference to deprecated typesafe name
    ([\#4671](https://github.com/googleapis/google-cloud-java/pull/4671))

## BigQuery

  - Added missing partitioned fields to listTables.
    ([\#4701](https://github.com/googleapis/google-cloud-java/pull/4701))

## Firestore

  - Update CustomClassMapper
    ([\#4675](https://github.com/googleapis/google-cloud-java/pull/4675))
  - Regenerate firestore client
    ([\#4686](https://github.com/googleapis/google-cloud-java/pull/4686))

## Language

  - Regenerate language client
    ([\#4676](https://github.com/googleapis/google-cloud-java/pull/4676))

## Logback Appender

  - Add MDC support in Logback appender
    ([\#4477](https://github.com/googleapis/google-cloud-java/pull/4477))

## Logging

  - Optimize pendingWrites
    ([\#4697](https://github.com/googleapis/google-cloud-java/pull/4697))
  - Fix pendingWrite race condition
    ([\#4696](https://github.com/googleapis/google-cloud-java/pull/4696))

## Pub/Sub

  - OpenCensus Support for Cloud Pub/Sub
    ([\#4240](https://github.com/googleapis/google-cloud-java/pull/4240))
  - Change each StreamingSubscriberConnection to have its own executor
    by default.
    ([\#4622](https://github.com/googleapis/google-cloud-java/pull/4622))

## Security Center

  - Regenerate securitycenter client
    ([\#4704](https://github.com/googleapis/google-cloud-java/pull/4704))
  - Regenerate securitycenter client
    ([\#4677](https://github.com/googleapis/google-cloud-java/pull/4677))
  - Regenerate securitycenter client
    ([\#4667](https://github.com/googleapis/google-cloud-java/pull/4667))

## Spanner

  - [\#4685](https://github.com/googleapis/google-cloud-java/pull/4685)
    Spanner now extends AutoCloseable
    ([\#4687](https://github.com/googleapis/google-cloud-java/pull/4687))

## Speech

  - Update speech readme to point to v1 javadoc.
    ([\#4693](https://github.com/googleapis/google-cloud-java/pull/4693))

## Talent

  - Add Cloud Talent Solution API.
    ([\#4699](https://github.com/googleapis/google-cloud-java/pull/4699))
  - Regenerate talent client
    ([\#4705](https://github.com/googleapis/google-cloud-java/pull/4705))

## Video Intelligence

  - Add Cloud Video Intelligence v1p3beta1 API.
    ([\#4669](https://github.com/googleapis/google-cloud-java/pull/4669))

## Documentation

  - Better explain how to use explicit credentials
    ([\#4694](https://github.com/googleapis/google-cloud-java/pull/4694))

# v0.83.0

  - BigQuery: add long term storage bytes to standard table definition.
    ([\#4387](https://github.com/googleapis/google-cloud-java/pull/4387))

## Compute

  - Regenerate compute client
    ([\#4662](https://github.com/googleapis/google-cloud-java/pull/4662))

## Firestore

  - Adding FieldValue.increment()
    ([\#4018](https://github.com/googleapis/google-cloud-java/pull/4018))

## Security Center

  - Add Cloud Security Center v1 API.
    ([\#4659](https://github.com/googleapis/google-cloud-java/pull/4659))

## Scheduler

  - Add Cloud Scheduler v1 API.
    ([\#4658](https://github.com/googleapis/google-cloud-java/pull/4658))

## Spanner

  - Batch dml mainline
    ([\#4653](https://github.com/googleapis/google-cloud-java/pull/4653))
  - Spanner: Throw exception when SSLHandshakeException occurs instead
    of infinite retry loop
    ([\#4663](https://github.com/googleapis/google-cloud-java/pull/4663))

## Dependencies

  - Bump gax to 1.42.0
    ([\#4624](https://github.com/googleapis/google-cloud-java/pull/4624))

## Internal / Testing Changes

  - Fix Timestamp.parseTimestamp.
    ([\#4656](https://github.com/googleapis/google-cloud-java/pull/4656))
  - Regenerate tasks client
    ([\#4648](https://github.com/googleapis/google-cloud-java/pull/4648))
  - Regenerate logging client
    ([\#4641](https://github.com/googleapis/google-cloud-java/pull/4641))
  - Regenerate spanner client
    ([\#4647](https://github.com/googleapis/google-cloud-java/pull/4647))
  - Regenerate trace client
    ([\#4649](https://github.com/googleapis/google-cloud-java/pull/4649))
  - Regenerate dlp client
    ([\#4636](https://github.com/googleapis/google-cloud-java/pull/4636))
  - Regenerate containeranalysis client
    ([\#4633](https://github.com/googleapis/google-cloud-java/pull/4633))
  - Regenerate securitycenter client
    ([\#4646](https://github.com/googleapis/google-cloud-java/pull/4646))
  - Regenerate websecurityscanner client
    ([\#4651](https://github.com/googleapis/google-cloud-java/pull/4651))
  - Regenerate vision client
    ([\#4650](https://github.com/googleapis/google-cloud-java/pull/4650))
  - Regenerate kms client
    ([\#4640](https://github.com/googleapis/google-cloud-java/pull/4640))
  - Regenerate scheduler client
    ([\#4645](https://github.com/googleapis/google-cloud-java/pull/4645))
  - Regenerate bigquerydatatransfer client
    ([\#4630](https://github.com/googleapis/google-cloud-java/pull/4630))
  - Regenerate redis client
    ([\#4644](https://github.com/googleapis/google-cloud-java/pull/4644))
  - Regenerate automl client
    ([\#4629](https://github.com/googleapis/google-cloud-java/pull/4629))
  - Regenerate pubsub client
    ([\#4643](https://github.com/googleapis/google-cloud-java/pull/4643))
  - Regenerate errorreporting client
    ([\#4637](https://github.com/googleapis/google-cloud-java/pull/4637))
  - Regenerate bigtable client
    ([\#4631](https://github.com/googleapis/google-cloud-java/pull/4631))
  - Regenerate monitoring client
    ([\#4642](https://github.com/googleapis/google-cloud-java/pull/4642))
  - Regenerate iot client
    ([\#4639](https://github.com/googleapis/google-cloud-java/pull/4639))
  - Regenerate firestore client
    ([\#4638](https://github.com/googleapis/google-cloud-java/pull/4638))
  - Regenerate dialogflow client
    ([\#4635](https://github.com/googleapis/google-cloud-java/pull/4635))
  - Regenerate dataproc client
    ([\#4634](https://github.com/googleapis/google-cloud-java/pull/4634))
  - Regenerate vision client
    ([\#4625](https://github.com/googleapis/google-cloud-java/pull/4625))
  - Bump next snapshot
    ([\#4623](https://github.com/googleapis/google-cloud-java/pull/4623))

# v0.82.0

## AutoML

  - Regenerate automl client
    ([\#4563](https://github.com/googleapis/google-cloud-java/pull/4563))

## Asset

  - Regenerate asset client
    ([\#4562](https://github.com/googleapis/google-cloud-java/pull/4562))

## Bigtable

  - Regenerate bigtable client
    ([\#4564](https://github.com/googleapis/google-cloud-java/pull/4564))
  - Bigtable: integrate OpenCensus tracing into the bigtable data client
    ([\#4493](https://github.com/googleapis/google-cloud-java/pull/4493))

## BigQuery

  - Fix useAvroLogicalTypes option in LoadJobConfiguration And
    WriteChannelConfiguration.
    ([\#4615](https://github.com/googleapis/google-cloud-java/pull/4615))
  - Fixes When Table,Dataset and Job is not found
    ([\#4389](https://github.com/googleapis/google-cloud-java/pull/4389))

## BigQuery Data Transfer

  - Regenerate bigquerydatatransfer client
    ([\#4600](https://github.com/googleapis/google-cloud-java/pull/4600))

## BigQuery Storage

  - Regenerate bigquerystorage client
    ([\#4601](https://github.com/googleapis/google-cloud-java/pull/4601))
  - Regenerate bigquerystorage client
    ([\#4586](https://github.com/googleapis/google-cloud-java/pull/4586))
  - bigquerystorage: address doc nits
    ([\#4544](https://github.com/googleapis/google-cloud-java/pull/4544))

## Compute

  - Regenerate compute client
    ([\#4587](https://github.com/googleapis/google-cloud-java/pull/4587))

## Container Analysis

  - Regenerate containeranalysis client
    ([\#4565](https://github.com/googleapis/google-cloud-java/pull/4565))

## Dataproc

  - Regenerate dataproc client
    ([\#4602](https://github.com/googleapis/google-cloud-java/pull/4602))

## Datastore

  - Regenerate datastore client
    ([\#4566](https://github.com/googleapis/google-cloud-java/pull/4566))

## Dialogflow

  - Regenerate dialogflow client
    ([\#4567](https://github.com/googleapis/google-cloud-java/pull/4567))

## Data Loss Prevention

  - Regenerate dlp client
    ([\#4603](https://github.com/googleapis/google-cloud-java/pull/4603))

## Error Reporting

  - Regenerate errorreporting client
    ([\#4568](https://github.com/googleapis/google-cloud-java/pull/4568))

## Firestore

  - Regenerate firestore client
    ([\#4604](https://github.com/googleapis/google-cloud-java/pull/4604))

## IAM

  - Regenerate iamcredentials client
    ([\#4605](https://github.com/googleapis/google-cloud-java/pull/4605))

## IoT

  - Regenerate iot client
    ([\#4569](https://github.com/googleapis/google-cloud-java/pull/4569))

## KMS

  - Prepare for KMS GA release - upgrade versions to 1.0.0.
    ([\#4581](https://github.com/googleapis/google-cloud-java/pull/4581))
  - Regenerate kms client
    ([\#4570](https://github.com/googleapis/google-cloud-java/pull/4570))

## Language

  - Regenerate language client
    ([\#4606](https://github.com/googleapis/google-cloud-java/pull/4606))

## Logging

  - Regenerate logging client
    ([\#4571](https://github.com/googleapis/google-cloud-java/pull/4571))

## Monitoring

  - Regenerate monitoring client
    ([\#4572](https://github.com/googleapis/google-cloud-java/pull/4572))

## OS-Login

  - Regenerate os-login client
    ([\#4607](https://github.com/googleapis/google-cloud-java/pull/4607))

## Pub/Sub

  - Clean up MessageDispatcher by changing processOutstandingBatches to
    explicitly loop instead of while(true) with breaks. There is now
    only 1 explicit return and 1 runtime error.
    ([\#4619](https://github.com/googleapis/google-cloud-java/pull/4619))
  - Extract the single message processing functionality from
    processOutstandingBatches.
    ([\#4618](https://github.com/googleapis/google-cloud-java/pull/4618))
  - Regenerate pubsub client
    ([\#4608](https://github.com/googleapis/google-cloud-java/pull/4608))
  - Scale the system executor provider with the number of pull channels
    opened.
    ([\#4592](https://github.com/googleapis/google-cloud-java/pull/4592))
  - Change MessageDispatcher to own its own queue.
    ([\#4590](https://github.com/googleapis/google-cloud-java/pull/4590))
  - Remove package private dead code from the subscriber client library.
    None of this code is ever called, and none of it is usable outside
    of the library.
    ([\#4589](https://github.com/googleapis/google-cloud-java/pull/4589))
  - Regenerate pubsub client
    ([\#4588](https://github.com/googleapis/google-cloud-java/pull/4588))

## Redis

  - Regenerate redis client
    ([\#4573](https://github.com/googleapis/google-cloud-java/pull/4573))

## Scheduler

  - Regenerate scheduler client
    ([\#4609](https://github.com/googleapis/google-cloud-java/pull/4609))

## Security Center

  - Regenerate securitycenter client
    ([\#4610](https://github.com/googleapis/google-cloud-java/pull/4610))

## Spanner

  - add propagateTimeout in SpannerExceptionFactory
    ([\#4598](https://github.com/googleapis/google-cloud-java/pull/4598))
  - Regenerate spanner client
    ([\#4574](https://github.com/googleapis/google-cloud-java/pull/4574))

## Speech

  - Regenerate speech client
    ([\#4575](https://github.com/googleapis/google-cloud-java/pull/4575))

## Tasks

  - Regenerate tasks client
    ([\#4611](https://github.com/googleapis/google-cloud-java/pull/4611))
  - Regenerate tasks client
    ([\#4550](https://github.com/googleapis/google-cloud-java/pull/4550))

## Text-to-Speech

  - Regenerate texttospeech client
    ([\#4576](https://github.com/googleapis/google-cloud-java/pull/4576))

## Trace

  - Regenerate trace client
    ([\#4577](https://github.com/googleapis/google-cloud-java/pull/4577))

## Video Intelligence

  - Regenerate video-intelligence client
    ([\#4612](https://github.com/googleapis/google-cloud-java/pull/4612))

## Vision

  - Adding vision v1p4beta1
    ([\#4584](https://github.com/googleapis/google-cloud-java/pull/4584))
  - Regenerate vision client
    ([\#4613](https://github.com/googleapis/google-cloud-java/pull/4613))

## Web Security Scanner

  - Regenerate websecurityscanner client
    ([\#4614](https://github.com/googleapis/google-cloud-java/pull/4614))

## Dependencies

  - Upgrading grpc in google-api-grpc
    ([\#4593](https://github.com/googleapis/google-cloud-java/pull/4593))
  - Using the latest version of truth
    ([\#4597](https://github.com/googleapis/google-cloud-java/pull/4597))
  - Using the google-cloud-http-bom
    ([\#4594](https://github.com/googleapis/google-cloud-java/pull/4594))

## Internal / Testing Changes

  - \[Storage\] Set the isDirectory flag appropriately
    ([\#4616](https://github.com/googleapis/google-cloud-java/pull/4616))
  - Update Issue Templates to match other google-cloud repositories
    ([\#4591](https://github.com/googleapis/google-cloud-java/pull/4591))

# v0.81.0

## BigQuery

  - BigQuery: Fixes Support for StandardSQLTypeName in
    Field.newBuilder(name, type).
    ([\#4483](https://github.com/googleapis/google-cloud-java/pull/4483))
  - BigQuery: Fix timestamp parsing regression
    ([\#4510](https://github.com/googleapis/google-cloud-java/pull/4510))
  - BigQuery: Fix support standard java date in QueryParameterValue
    classToType
    ([\#4489](https://github.com/googleapis/google-cloud-java/pull/4489))

## Bigtable

  - Bigtable: Deemphasize most of the settings and move them to the
    StubSettings
    ([\#4509](https://github.com/googleapis/google-cloud-java/pull/4509))
  - Bigtable: expose credential provider as a toplevel setting
    ([\#4508](https://github.com/googleapis/google-cloud-java/pull/4508))
  - Bigtable: add a helper method to easily connect to an emulator
    ([\#4506](https://github.com/googleapis/google-cloud-java/pull/4506))
  - Bump gax-java dependency
    ([\#4496](https://github.com/googleapis/google-cloud-java/pull/4496))
  - \[Bigtable\] Added HeaderProvider onto ClientContext\#create
    settings
    ([\#4491](https://github.com/googleapis/google-cloud-java/pull/4491))
  - Adding Cloud Bigtable Mutation fromProto
    ([\#4461](https://github.com/googleapis/google-cloud-java/pull/4461))
  - Bigtable: Remove deprecated typesafe names
    ([\#4505](https://github.com/googleapis/google-cloud-java/pull/4505))
  - Bigtable: Expose the default transport builder
    ([\#4507](https://github.com/googleapis/google-cloud-java/pull/4507))

## Compute

  - Regenerate compute client
    ([\#4527](https://github.com/googleapis/google-cloud-java/pull/4527))
  - Regenerate compute client
    ([\#4476](https://github.com/googleapis/google-cloud-java/pull/4476))

## Datastore

  - Datastore: Fix `more_results` value to query results
    ([\#4516](https://github.com/googleapis/google-cloud-java/pull/4516))

## DLP

  - Regenerate dlp client
    ([\#4520](https://github.com/googleapis/google-cloud-java/pull/4520))

## Firestore

  - Fixes
    [\#4423](https://github.com/googleapis/google-cloud-java/pull/4423)
    - Getter on mutations size
    ([\#4424](https://github.com/googleapis/google-cloud-java/pull/4424))

## KMS

  - Regenerate kms client
    ([\#4511](https://github.com/googleapis/google-cloud-java/pull/4511))

## PubSub

  - Regenerate pubsub client
    ([\#4487](https://github.com/googleapis/google-cloud-java/pull/4487))

## Storage

  - 4117: Added Md5String() method and updated tests.
    ([\#4397](https://github.com/googleapis/google-cloud-java/pull/4397))

## Spanner

  - Regenerate spanner client
    ([\#4528](https://github.com/googleapis/google-cloud-java/pull/4528))
  - \[cloud spanner\] Add dependency for surefire-junit47
    ([\#4526](https://github.com/googleapis/google-cloud-java/pull/4526))
  - Remove duplicate span.end() causing log pollution.
    ([\#4497](https://github.com/googleapis/google-cloud-java/pull/4497))
  - Fix
    [\#4466](https://github.com/googleapis/google-cloud-java/pull/4466)
    support date data type in toproto of key
    ([\#4473](https://github.com/googleapis/google-cloud-java/pull/4473))

## Video Intelligence

  - Regenerate video-intelligence client
    ([\#4529](https://github.com/googleapis/google-cloud-java/pull/4529))

## Vision

  - Regenerate vision client
    ([\#4502](https://github.com/googleapis/google-cloud-java/pull/4502))

## Web Security Scanner

  - Regenerate websecurityscanner client
    ([\#4488](https://github.com/googleapis/google-cloud-java/pull/4488))
  - Regenerate websecurityscanner client
    ([\#4435](https://github.com/googleapis/google-cloud-java/pull/4435))

## Dependencies

  - Upgrade gax dependency to 1.40.0.
    ([\#4534](https://github.com/googleapis/google-cloud-java/pull/4534))

## Documentation

  - Update KMS README.md to include link to code examples.
    ([\#4519](https://github.com/googleapis/google-cloud-java/pull/4519))
  - Fix broken link to DEVELOPING.md
    ([\#4518](https://github.com/googleapis/google-cloud-java/pull/4518))

## Internal / Testing Changes

  - add mvn call
    ([\#4521](https://github.com/googleapis/google-cloud-java/pull/4521))
  - Removing deprecated ServiceAccount creation in StorageImplTest.
    ([\#4490](https://github.com/googleapis/google-cloud-java/pull/4490))
  - Bump next snapshot
    ([\#4467](https://github.com/googleapis/google-cloud-java/pull/4467))
  - Add KMS IT test and kokoro configs.
    ([\#4517](https://github.com/googleapis/google-cloud-java/pull/4517))
  - VPC Tests
    ([\#4484](https://github.com/googleapis/google-cloud-java/pull/4484))
  - Removing joda
    ([\#4471](https://github.com/googleapis/google-cloud-java/pull/4471))
  - Set connect/read timeout when calling the metadata service
    ([\#4413](https://github.com/googleapis/google-cloud-java/pull/4413))

# v0.80.0

## Asset

  - Regenerate asset client
    ([\#4426](https://github.com/googleapis/google-cloud-java/pull/4426))

## AutoML

  - Regenerate automl client
    ([\#4455](https://github.com/googleapis/google-cloud-java/pull/4455))
  - Regenerate automl client
    ([\#4418](https://github.com/googleapis/google-cloud-java/pull/4418))

## BigQuery

  - Fix Location configurable at BigQueryOptions
    ([\#4329](https://github.com/googleapis/google-cloud-java/pull/4329))
  - Empty table results can have a schema
    ([\#4185](https://github.com/googleapis/google-cloud-java/pull/4185))

## Bigtable

  - expose helper to convert proto rows into model rows
    ([\#4458](https://github.com/googleapis/google-cloud-java/pull/4458))
  - make request context serializable
    ([\#4459](https://github.com/googleapis/google-cloud-java/pull/4459))
  - Regenerate bigtable client
    ([\#4427](https://github.com/googleapis/google-cloud-java/pull/4427))
  - make row & cell ordering more consistent.
    ([\#4421](https://github.com/googleapis/google-cloud-java/pull/4421))

## Compute

  - Regenerate compute client
    ([\#4462](https://github.com/googleapis/google-cloud-java/pull/4462))
  - Regenerate compute client
    ([\#4444](https://github.com/googleapis/google-cloud-java/pull/4444))
  - Regenerate compute client
    ([\#4399](https://github.com/googleapis/google-cloud-java/pull/4399))

## Core HTTP

  - Made HttpTransportOptions constructor public.
    ([\#4439](https://github.com/googleapis/google-cloud-java/pull/4439))

## Dataproc

  - Regenerate dataproc client
    ([\#4428](https://github.com/googleapis/google-cloud-java/pull/4428))

## Dialogflow

  - Regenerate dialogflow client
    ([\#4429](https://github.com/googleapis/google-cloud-java/pull/4429))
  - Regenerate dialogflow client
    ([\#4429](https://github.com/googleapis/google-cloud-java/pull/4429))

## Firestore

  - Add firestore grpc and proto versions to versions.txt
    ([\#4464](https://github.com/googleapis/google-cloud-java/pull/4464))
  - Regenerate firestore client
    ([\#4348](https://github.com/googleapis/google-cloud-java/pull/4348))
  - Firestore: Migrate client to use v1 gapic client / protos.
    ([\#4419](https://github.com/googleapis/google-cloud-java/pull/4419))
  - Generate Firestore API v1
    ([\#4410](https://github.com/googleapis/google-cloud-java/pull/4410))

## Redis

  - Regenerate redis client
    ([\#4431](https://github.com/googleapis/google-cloud-java/pull/4431))

## Security Command Center

  - Regenerate securitycenter client
    ([\#4432](https://github.com/googleapis/google-cloud-java/pull/4432))

## Spanner

  - Regenerate spanner client
    ([\#4433](https://github.com/googleapis/google-cloud-java/pull/4433))
  - Fix usages of any(.class) matchers
    ([\#4453](https://github.com/googleapis/google-cloud-java/pull/4453))

## Speech

  - Regenerate speech client
    ([\#4456](https://github.com/googleapis/google-cloud-java/pull/4456))
  - Regenerate speech client
    ([\#4422](https://github.com/googleapis/google-cloud-java/pull/4422))

## Storage

  - Added a new create method to pass offset and length of sub array.
    ([\#4407](https://github.com/googleapis/google-cloud-java/pull/4407))
  - Implement BucketPolicyOnly
    ([\#4404](https://github.com/googleapis/google-cloud-java/pull/4404))

## Tasks

  - Regenerate tasks client
    ([\#4411](https://github.com/googleapis/google-cloud-java/pull/4411))

## Text-to-Speech

  - Regenerate texttospeech client
    ([\#4463](https://github.com/googleapis/google-cloud-java/pull/4463))
  - Regenerate texttospeech client
    ([\#4333](https://github.com/googleapis/google-cloud-java/pull/4333))

## Video Intelligence

  - Regenerate video-intelligence client
    ([\#4434](https://github.com/googleapis/google-cloud-java/pull/4434))

## Dependencies

  - use gax 1.38.0
    ([\#4460](https://github.com/googleapis/google-cloud-java/pull/4460))
  - fix shading
    ([\#4406](https://github.com/googleapis/google-cloud-java/pull/4406))
  - Removing non-deprecated uses of joda time.
    ([\#4351](https://github.com/googleapis/google-cloud-java/pull/4351))
  - Removing some unused dependencies
    ([\#4385](https://github.com/googleapis/google-cloud-java/pull/4385))
  - Fixing some deprecation warnings
    ([\#4390](https://github.com/googleapis/google-cloud-java/pull/4390))

## Documentation

  - Update some default retry setting values
    ([\#4425](https://github.com/googleapis/google-cloud-java/pull/4425))
  - add comments
    ([\#4441](https://github.com/googleapis/google-cloud-java/pull/4441))
  - update TESTING.md
    ([\#4409](https://github.com/googleapis/google-cloud-java/pull/4409))

## Internal / Testing Changes

  - Skip integration tests if no changes
    ([\#4392](https://github.com/googleapis/google-cloud-java/pull/4392))
  - Fix code formatting
    ([\#4437](https://github.com/googleapis/google-cloud-java/pull/4437))

# v0.79.0

## Asset

  - Regenerate asset client
    ([\#4395](https://github.com/googleapis/google-cloud-java/pull/4395))

## Bigtable

  - tableAdmin sample
    ([\#4313](https://github.com/googleapis/google-cloud-java/pull/4313))

## Compute

  - Regenerate compute client
    ([\#4359](https://github.com/googleapis/google-cloud-java/pull/4359))

## Firestore

  - Include a trailing /documents on root resource paths
    ([\#4352](https://github.com/googleapis/google-cloud-java/pull/4352))

## Spanner

  - Regenerate spanner client
    ([\#4388](https://github.com/googleapis/google-cloud-java/pull/4388))

## Scheduler

  - Regenerate scheduler client
    ([\#4294](https://github.com/googleapis/google-cloud-java/pull/4294))
  - Regenerate scheduler client
    ([\#4396](https://github.com/googleapis/google-cloud-java/pull/4396))

# v0.78.0

  - BigQuery: Fix NPE for null table schema fields
    ([\#4338](https://github.com/googleapis/google-cloud-java/pull/4338))

## Bigtable

  - Cloud Bigtable: HelloWorld sample updates
    ([\#4339](https://github.com/googleapis/google-cloud-java/pull/4339))
  - Bigtable: Fixing a typo for KeyOffSet\#geyKey to getKey
    ([\#4342](https://github.com/googleapis/google-cloud-java/pull/4342))
  - Bigtable: Expose single row read settings
    ([\#4321](https://github.com/googleapis/google-cloud-java/pull/4321))
  - Bigtable: fix handling of unset rpc timeouts
    ([\#4323](https://github.com/googleapis/google-cloud-java/pull/4323))
  - separate properties for bigtable.project and bigtable.instance
    ([\#4346](https://github.com/googleapis/google-cloud-java/pull/4346))

## Compute

  - Regenerate compute client
    ([\#4327](https://github.com/googleapis/google-cloud-java/pull/4327))

## Firestore

  - Firestore: (BREAKING CHANGE) change timestampsInSnapshots default to
    true.
    ([\#4353](https://github.com/googleapis/google-cloud-java/pull/4353))

## Pub/Sub

  - Pub/Sub: default values in batch settings comments
    ([\#4350](https://github.com/googleapis/google-cloud-java/pull/4350))

## Spanner

  - Spanner: remove junit from compile dependencies
    ([\#4334](https://github.com/googleapis/google-cloud-java/pull/4334))
  - Regenerate spanner client
    ([\#4332](https://github.com/googleapis/google-cloud-java/pull/4332))

## Dependencies

  - Update maven-surefire-plugin to 3.0.0-M3 to fix Java 8 classloader
    ([\#4344](https://github.com/googleapis/google-cloud-java/pull/4344))

## Documentation

  - Regenerate clients with updated copyright year
    ([\#4382](https://github.com/googleapis/google-cloud-java/pull/4382))
  - Update README version to use bom version
    ([\#4322](https://github.com/googleapis/google-cloud-java/pull/4322))
  - Regenerate speech client
    ([\#4328](https://github.com/googleapis/google-cloud-java/pull/4328))

## Internal / Testing Changes

  - Bump next snapshot
    ([\#4325](https://github.com/googleapis/google-cloud-java/pull/4325))
  - Bump gax, grpc & opencensus version
    ([\#4336](https://github.com/googleapis/google-cloud-java/pull/4336))

# v0.77.0

## Bigtable

  - Merge bigtable-admin into the bigtable artifact
    ([\#4307](https://github.com/googleapis/google-cloud-java/pull/4307))
  - Added Query\#fromProto to convert protobuf ReadRowsRequest
    ([\#4291](https://github.com/googleapis/google-cloud-java/pull/4291))
  - instanceAdmin sample
    ([\#4299](https://github.com/googleapis/google-cloud-java/pull/4299))

## BigQuery

  - corrected equality check on subclasses of StringEnumValue
    ([\#4283](https://github.com/googleapis/google-cloud-java/pull/4283))

## Storage

  - 3822: Fixed setDisableGZipContent call
    ([\#4314](https://github.com/googleapis/google-cloud-java/pull/4314))
  - 3918: Added checking of attributes size for 0. Added unit test
    ([\#4304](https://github.com/googleapis/google-cloud-java/pull/4304))
  - 4152: Added checking PAGE\_TOKEN from options
    ([\#4303](https://github.com/googleapis/google-cloud-java/pull/4303))

## Dependencies

  - 3540: Used transformer for shaded plugin
    ([\#4305](https://github.com/googleapis/google-cloud-java/pull/4305))

## Internal / Testing Changes

  - Regenerate speech client: enable multi-channel features
    ([\#4317](https://github.com/googleapis/google-cloud-java/pull/4317))
  - Regenerate bigtable client
    ([\#4318](https://github.com/googleapis/google-cloud-java/pull/4318))
  - Regenerate monitoring client
    ([\#4316](https://github.com/googleapis/google-cloud-java/pull/4316))
  - Regenerate PubSub: documentation updates
    ([\#4293](https://github.com/googleapis/google-cloud-java/pull/4293))
  - Regenerate securitycenter client
    ([\#4311](https://github.com/googleapis/google-cloud-java/pull/4311))
  - Regenerate dataproc client
    ([\#4301](https://github.com/googleapis/google-cloud-java/pull/4301))
  - Fix
    [\#4269](https://github.com/googleapis/google-cloud-java/pull/4269)
    update metata url to FQDN
    ([\#4278](https://github.com/googleapis/google-cloud-java/pull/4278))

# v0.76.0

## Bigtable Admin

  - Deprecate typesafe names part 2
    ([\#4258](https://github.com/googleapis/google-cloud-java/pull/4258))

## Compute

  - Fix NPE for getZone
    ([\#4289](https://github.com/googleapis/google-cloud-java/pull/4289))

## IAM Credentials

  - Regenerate iamcredentials client
    ([\#4277](https://github.com/googleapis/google-cloud-java/pull/4277))

## Pub/Sub

  - Revert message abandonment feature which should not have been added
    to surface area.
    ([\#4297](https://github.com/googleapis/google-cloud-java/pull/4297))

## Security Center

  - Regenerate securitycenter client
    ([\#4290](https://github.com/googleapis/google-cloud-java/pull/4290))

## Internal / Testing Changes

  - Bump next snapshot
    ([\#4286](https://github.com/googleapis/google-cloud-java/pull/4286))

# v0.75.0

## Bigtable

  - helloWorld sample
    ([\#4274](https://github.com/googleapis/google-cloud-java/pull/4274))
  - deprecate the use of typesafe names
    ([\#4257](https://github.com/googleapis/google-cloud-java/pull/4257))
  - add a separate callable for point reads
    ([\#4264](https://github.com/googleapis/google-cloud-java/pull/4264))

## BigQuery

  - Fix numBytes, numRows in TableInfo/Table
    ([\#4271](https://github.com/googleapis/google-cloud-java/pull/4271))
  - Fix Maximum Bytes Billed property.
    ([\#4262](https://github.com/googleapis/google-cloud-java/pull/4262))
  - Fix NPE in BQ's StandardTableDefinition
    ([\#4247](https://github.com/googleapis/google-cloud-java/pull/4247))
  - Add BadRecords to LoadStatistics
    ([\#4230](https://github.com/googleapis/google-cloud-java/pull/4230))
  - Fix setProjectId
    ([\#4227](https://github.com/googleapis/google-cloud-java/pull/4227))

## Logging

  - disable severity based flush on write by default
    ([\#4254](https://github.com/googleapis/google-cloud-java/pull/4254))

## Pub/Sub

  - Update UsePubSubEmulatorSnippet.java
    ([\#4256](https://github.com/googleapis/google-cloud-java/pull/4256))
  - ~~Add message abandonment
    ([\#4250](https://github.com/googleapis/google-cloud-java/pull/4250))~~

## Spanner

  - closed watch-dog daemon threads spawned by Spanner client
    ([\#4263](https://github.com/googleapis/google-cloud-java/pull/4263))

## Compute

  - Regenerate google-cloud-compute
    ([\#4213](https://github.com/googleapis/google-cloud-java/pull/4213))

## IAMCredentials

  - Fix name/description in pom
    ([\#4238](https://github.com/googleapis/google-cloud-java/pull/4238))

## Implementation Changes

  - Fixed cannot call public methods in via reflection
    ([\#4249](https://github.com/googleapis/google-cloud-java/pull/4249))

## Documentation

  - Fix maven site generation
    ([\#4232](https://github.com/googleapis/google-cloud-java/pull/4232))
  - Update javadoc link for api-common-java.
    ([\#4236](https://github.com/googleapis/google-cloud-java/pull/4236))

## Internal / Testing Changes

  - Add .tmpl extension for README.md so releasetool is not confused
    ([\#4280](https://github.com/googleapis/google-cloud-java/pull/4280))
  - Fix Kokoro release jobs
    ([\#4225](https://github.com/googleapis/google-cloud-java/pull/4225))
  - Ignore
    testRotateFromCustomerEncryptionToKmsKeyWithCustomerEncryption while
    we work out backend change
    ([\#4266](https://github.com/googleapis/google-cloud-java/pull/4266))
  - Add script to help bootstrap new client libraries
    ([\#4111](https://github.com/googleapis/google-cloud-java/pull/4111))

# v0.74.0

## Bigtable

  - Bigtable: fix emulator publishing
    ([\#4189](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4189))

## BigQuery

  - BigQuery: Allow job to extract or load table across projects
    ([\#4183](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4183))
  - BigQuery: insertAll always retries operation
    ([\#4165](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4165))
  - BigQuery: Fix TableId behaviour for non default BigQueryClient
    project
    ([\#4115](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4115))

## Firestore

  - Adding FieldMask support to GetAll()
    ([\#4017](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4017))

## Logging

  - Logging: Allow deferred formatting for trace and spanId
    ([\#3661](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3661))

## Pub/Sub

  - Regenerate: Fix empty list returns
    ([\#4159](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4159))
  - Pub/Sub: Update ApiFutures.addCallback() to take 3 arguments
    ([\#4120](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4120))

## Spanner

  - **Spanner Client is now GA**
  - Spanner: Handle AbortedExceptions that occur before commit
    ([\#4181](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4181))

## Storage

  - Storage: Give users the ability to disable gzip content encoding to
    increase throughput
    ([\#4170](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4170))
  - Storage: Fixed link to StorageExamples page
    ([\#4173](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4173))
  - Storage: Close response body after request
    ([\#4116](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4116))
  - Storage: fix ability to set customized port in HttpStorageRpc
    ([\#4109](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4109))

## New Features

  - Java 11 compatibility
    ([\#3821](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3821))

## Dependencies

  - google-cloud-bom should not need google-cloud-core test-jar
    ([\#4168](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4168))
  - Remove exclusions for guava-jdk5 and google-api-client
    ([\#4177](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4177))
  - Update maven-javadoc-plugin to 3.0.1 and disable doclint.
    ([\#4167](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4167))

## Documentation

  - Document purpose of test-jar and testlib dependencies
    ([\#4164](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4164))
  - Update Spanner description for GA
    ([\#4174](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4174))
  - Remove the old clients compatibility chart.
    ([\#4163](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4163))

## Internal / Testing Changes

  - Integration test deflake
    ([\#4176](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4176))
  - Run google-java-format on all artifacts
    ([\#4121](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4121))
  - Add lint test and format generated code
    ([\#4114](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4114))
  - Add release profile to bigtable emulator
    ([\#4119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4119))
  - Make TestServiceFactory and TestServiceRpcFactory interfaces public
    ([\#4112](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4112))
  - Bump next snapshot
    ([\#4118](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/4118))

# v0.73.0

  - Bigtable: publish emulator to maven central
    ([\#4106](https://github.com/googleapis/google-cloud-java/pull/4106))

## BigQuery

  - BigQuery Storage: Add shim layer settings and configuration
    ([\#4022](https://github.com/googleapis/google-cloud-java/pull/4022))
  - Fix BigQuery NullPointerException when estimatedFields is empty
    ([\#3984](https://github.com/googleapis/google-cloud-java/pull/3984))

## Container

  - Regenerate container client
    ([\#3979](https://github.com/googleapis/google-cloud-java/pull/3979))

## Dataproc

  - Regenerate dataproc client - Adds workflow templating
    ([\#4110](https://github.com/googleapis/google-cloud-java/pull/4110))

## Datastore

  - Datastore: Add `skippedResults` in `QueryResults`
    ([\#4093](https://github.com/googleapis/google-cloud-java/pull/4093))

## IoT

  - Regenerate IoT client
    ([\#4069](https://github.com/googleapis/google-cloud-java/pull/4069))

## Storage

  - Storage NIO: Add new retry options in CloudStorageConfiguration
    ([\#3869](https://github.com/googleapis/google-cloud-java/pull/3869))
  - Storage: Added feature to change host name of signed url
    ([\#3910](https://github.com/googleapis/google-cloud-java/pull/3910))

## Spanner

  - Spanner: fix code formatting
    ([\#4105](https://github.com/googleapis/google-cloud-java/pull/4105))

## Implementation Changes

  - Add missing fields on MonitoredResourceUtil
    ([\#3887](https://github.com/googleapis/google-cloud-java/pull/3887))
  - Add helpers to convert core Date class with java.util.Date class
    ([\#3911](https://github.com/googleapis/google-cloud-java/pull/3911))

## Dependencies

  - \[Snyk\] Fix for 1 vulnerable dependencies
    (kr.motd.maven:os-maven-plugin)
    ([\#4097](https://github.com/googleapis/google-cloud-java/pull/4097))

## Documentation

  - Cloud Asset fix README links
    ([\#3985](https://github.com/googleapis/google-cloud-java/pull/3985))

## Internal / Testing Changes

  - Regenerate language client: remove unused imports
    ([\#4071](https://github.com/googleapis/google-cloud-java/pull/4071))
  - Regenerate speech client: remove unused imports
    ([\#4077](https://github.com/googleapis/google-cloud-java/pull/4077))
  - Bump next snapshot
    ([\#3981](https://github.com/googleapis/google-cloud-java/pull/3981))
  - Add synth metadata for many clients
    ([\#4020](https://github.com/googleapis/google-cloud-java/pull/4020))
  - Regenerate websecurityscanner client
    ([\#4080](https://github.com/googleapis/google-cloud-java/pull/4080))
  - Delay download of Bigtable emulator
    ([\#4102](https://github.com/googleapis/google-cloud-java/pull/4102))
  - Trace: list response returns empty list instead of null
    ([\#4079](https://github.com/googleapis/google-cloud-java/pull/4079))
  - fix: google-cloud-testing/google-cloud-gcloud-maven-plugin/pom.xml
    to reduce vulnerabilities
    ([\#4100](https://github.com/googleapis/google-cloud-java/pull/4100))
  - Update generated code: List responses return empty list instead of
    null
    ([\#4104](https://github.com/googleapis/google-cloud-java/pull/4104))
  - Moving surefire-junit4 out of the dependency lists to allow others
    to better run tests.
    ([\#4058](https://github.com/googleapis/google-cloud-java/pull/4058))

# v0.72.0

## Bigtable

  - **\[Breaking change\]** listTables() now returns relative table
    names
    ([\#3696](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3696))
  - Add Bigtable emulator helpers
    ([\#3840](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3840))

## BigQuery Storage

  - New Client: BigQuery Storage
    ([\#3935](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3935))
  - Regenerate: Adds documentation
    ([\#3939](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3939))

## Security Command Center

  - New Client: Cloud Security Command Center
    ([\#3885](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3885))

## Spanner

  - Spanner: use WatchdogProvider
    ([\#3923](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3923))

## Speech

  - Regenerate: Adds `result_end_time` to `StreamingRecognitionResult`
    ([\#3933](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3933))

## Dependencies

  - Update gax, grpc, and guava dependencies
    ([\#3980](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3980))
  - Update google-auth-library-java, apiary core libraries
    ([\#3945](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3945))
  - fix: google-cloud-clients/pom.xml to reduce vulnerabilities
    ([\#3943](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3943))

## Documentation

  - Update README to suggest importing BOM
    ([\#3269](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3269))

## Internal / Testing Changes

  - Add namespace and schema to settings.xml
    ([\#3941](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3941))
  - Add Kokoro nightly build configs
    ([\#3926](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3926))
  - Update container synth script for new artman config name
    ([\#3925](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3925))
  - Bump next snapshot
    ([\#3922](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3922))

# v0.71.0

## Bigtable

  - Add `exists` method in `BigtableInstanceAdminClient`
    ([\#3891](https://github.com/googleapis/google-cloud-java/pull/3891))
  - Add synchronous row methods
    ([\#3856](https://github.com/googleapis/google-cloud-java/pull/3856))
  - Tests: Fix admin tests to able to run concurrently
    ([\#3895](https://github.com/googleapis/google-cloud-java/pull/3895))

## Compute

  - Regenerate: Adds Interconnect features
    ([\#3916](https://github.com/googleapis/google-cloud-java/pull/3916))

## Dataproc

  - Regenerate: Unset empty list of no-retry status codes
    ([\#3906](https://github.com/googleapis/google-cloud-java/pull/3906))

## DLP

  - Regenerate: Adds `excluded_fields` to
    `BigQueryOptions`([\#3917](https://github.com/googleapis/google-cloud-java/pull/3917))
  - Regenerate: Adds InfoTypeNames
    ([\#3823](https://github.com/googleapis/google-cloud-java/pull/3823))

## Firestore

  - Tests: Validate that at least one argument is provided for Cursor
    ([\#3900](https://github.com/googleapis/google-cloud-java/pull/3900))

## Logging

  - Add a `traceSampled` field to the LogEntry class.
    ([\#3863](https://github.com/googleapis/google-cloud-java/pull/3863))
  - Regenerate: Test fixes
    ([\#3907](https://github.com/googleapis/google-cloud-java/pull/3907))

## Monitoring

  - Regenerate: Unset empty list of no-retry status codes
    ([\#3908](https://github.com/googleapis/google-cloud-java/pull/3908))

## Pub/Sub

  - Use gapic client
    ([\#3581](https://github.com/googleapis/google-cloud-java/pull/3581))

## Scheduler

  - New Client: Cloud Scheduler
    ([\#3913](https://github.com/googleapis/google-cloud-java/pull/3913))

## Spanner

  - **Breaking Change**: Gapic migration
    ([\#3881](https://github.com/googleapis/google-cloud-java/pull/3881))
      - LRO (`createInstance`, `updateInstance`, `createDatabase`,
        `updateDatabaseDdl`) methods are changed to return
        `OperationFuture` instead of `Operation`.
      - `SpannerOptions.Builder` now takes a `TransportChannelProvider`
        instead of a `RpcChannelFactory`.
      - `SpannerOptions.Builder` now takes a `GrpcInterceptorProvider`
        which provides interceptors to intercept grpc calls.

## Storage NIO

  - Stop leaving leftover buckets in IT
    ([\#3898](https://github.com/googleapis/google-cloud-java/pull/3898))
  - Add a feature to list the buckets
    ([\#3915](https://github.com/googleapis/google-cloud-java/pull/3915))

## Vision

  - Regenerate: Adds product search
    ([\#3888](https://github.com/googleapis/google-cloud-java/pull/3888))

## Documentation

  - Move BOM info to right after Quick Start
    ([\#3555](https://github.com/googleapis/google-cloud-java/pull/3555))
  - Fix deprecation warning in `ApiFutures.addCallback()` in Pub/Sub
    snippets
    ([\#3886](https://github.com/googleapis/google-cloud-java/pull/3886))

## Internal / Testing Changes

  - Update CODEOWNERS - wildcard is last resort
  - Bump next snapshot
    ([\#3892](https://github.com/googleapis/google-cloud-java/pull/3892))

# v0.70.0

## Bigtable

  - Bigtable: Add integration test to test nonexistent row handling
    ([\#3870](https://github.com/googleapis/google-cloud-java/pull/3870))

## BigQuery

  - BigQuery: Add support for retreiving labels
    ([\#3879](https://github.com/googleapis/google-cloud-java/pull/3879))
  - Fixes BigQuery getTableId with empty projectId
    ([\#3808](https://github.com/googleapis/google-cloud-java/issues/3808)).
    ([\#3873](https://github.com/googleapis/google-cloud-java/pull/3873))

## Datastore

  - Added project ID in validation failure
    [\#3292](https://github.com/googleapis/google-cloud-java/pull/3292)
    ([\#3875](https://github.com/googleapis/google-cloud-java/pull/3875))

## Spanner

  - Fix: writeAtLeastOnce should use a ReadWriteSession
    ([\#3882](https://github.com/googleapis/google-cloud-java/pull/3882))

## Video Intelligence

  - Regenerate video-intelligence client
    ([\#3865](https://github.com/googleapis/google-cloud-java/pull/3865))

## Dependencies

  - Added explicit dependencies for surefile-junit4 in order to fix
    testing in offline mode.
    ([\#3820](https://github.com/googleapis/google-cloud-java/pull/3820))
  - Cleanup: Stop bundling test-jars
    ([\#3874](https://github.com/googleapis/google-cloud-java/pull/3874))

## Internal / Testing Changes

  - Fix search folder for BQDT synth output
    ([\#3878](https://github.com/googleapis/google-cloud-java/pull/3878))
  - Bump next snapshot
    ([\#3862](https://github.com/googleapis/google-cloud-java/pull/3862))

# v0.69.0

  - Exists method added
    ([\#3769](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3769))
  - Bigtable: non-functional improvements relating to error handling
    ([\#3809](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3809))
  - bigtable: updated\_documentation
    ([\#3833](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3833))

## Pub/Sub

  - pubsub: remove TODO
    ([\#3845](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3845))
  - Pubsub: Set default maxInboundMessageSize to 20MB
    ([\#3844](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3844))
  - setMaxInboundMessageSize in Pubsub exmaple
    ([\#3825](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3825))
  - pubsub: reject expired and duplicate messages
    ([\#3743](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3743))
  - Re-generate library using
    google-cloud-clients/google-cloud-pubsub/synth.py
    ([\#3824](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3824))

## Storage

  - WIP: Storage: Deprecate DeleteRules and add LifecycleRules to
    accommodate SetStorageClass actions
    ([\#3795](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3795))
  - Add assumptions to storage integration tests
    ([\#3813](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3813))

## Dependencies

  - Grpc
    ([\#3733](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3733))

## Documentation

  - Fix \[cloud-nio\] link
    ([\#3835](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3835))
    - docs: Update javadoc for network client
    ([\#3832](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3832))
  - Fix container analysis link
    ([\#3814](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3814))
  - Add android note
    ([\#3631](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3631))

## Internal / Testing Changes

  - Add codecov
    ([\#3842](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3842))
  - Bumping gax, using gax-bom
    ([\#3841](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3841))
  - Add compute synth
    ([\#3830](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3830))
  - Update CODEOWNERS.
    ([\#3831](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3831))
  - Make testDownloadPublicBlobWithoutAuthentication skippable with an
    environment variable
    ([\#3828](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3828))
  - Bump next snapshot
    ([\#3810](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3810))
  - Add issue/pr templates
    ([\#3794](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3794))
  - Add Kokoro release scripts
    ([\#3818](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3818))

# v0.68.0

## BigTable

  - Add createUnsafe factory method in Mutation model
    ([\#3800](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3800))

## DLP

  - Re-generate models
    ([\#3785](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3785))

## Logging

  - Re-generate models
    ([\#3789](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3789))

## Spanner

  - Expand test coverage for ResultSets
    ([\#3717](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3717))

## Storage

  - NIO: Try harder to make believable directories
    ([\#3775](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3775))
  - NIO: walkFiles consistently relative or absolute
    ([\#3773](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3773))

## Video Intelligence

  - Re-generate models
    ([\#3796](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3796))

## Dependencies

  - update gax to 1.33.1
    ([\#3792](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3792))

## Documentation

  - Follow these instructions link corrected
    ([\#3790](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3790))
  - Fix urls from GoogleCloudPlatform org to googleapis org
    ([\#3793](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3793))

## Internal / Testing Changes

  - yoshi-java as CODEOWNERS
    ([\#3798](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3798))
  - Simplify release process
    ([\#3799](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3799))
  - releasetool compatibility and instructions
    ([\#3787](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3787))
  - Release v0.66.1-SNAPSHOT
    ([\#3784](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3784))

# v0.67.0

## BigQuery

  - add null check to JobInfo.fromPb(Job) and .toPb()
    ([\#3770](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3770))

## Cloud Spanner

  - Cloud Spanner DML & PDML Release
    ([\#3781](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3781))

## Cloud Firestore

  - Add listDocuments() API
    ([\#3759](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3759))
  - Don't raise empty Snapshots on resets
    ([\#3750](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3750))

## Documentation

  - Remove CircleCI status, coveralls, and version eye badges
    ([\#3771](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3771))

## Internal / Testing Changes

  - Add synthtool scripts
    ([\#3765](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3765))
  - Bump to next snapshot version
    ([\#3768](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/3768))

# v0.66.0

  - Regenerated data models

**Firestore**

  - Deprecate `getCollections` in favor of `listCollections`
    ([\#3758](https://github.com/googleapis/google-cloud-java/pull/3758))

**Storage**

  - Adding Bucket Lock
    ([\#3727](https://github.com/googleapis/google-cloud-java/pull/3727))

**Tasks**

  - Regenerated data models

**Testing**

  - Expanded test coverage for spanner
    ([\#3702](https://github.com/googleapis/google-cloud-java/pull/3702))

**Documentation**

  - Fix link to automl
    ([\#3748](https://github.com/googleapis/google-cloud-java/pull/3748))
  - Fix NIO sample typo
    ([\#3762](https://github.com/googleapis/google-cloud-java/pull/3762))

# v0.65.0

  - spanner: Options: Fix null dereference, expand test coverage
    ([\#3706](https://github.com/googleapis/google-cloud-java/pull/3706))

**Testing**

  - Add ArrayUnion/ArrayRemove conformance tests
    ([\#3704](https://github.com/googleapis/google-cloud-java/pull/3704))

**Internal**

  - bump proto version
    ([\#3718](https://github.com/googleapis/google-cloud-java/pull/3718))
  - Remove Circle CI and Travis configs
    ([\#3723](https://github.com/googleapis/google-cloud-java/pull/3723))

**Cloud Asset**

  - Remove duplicated folders
    ([\#3732](https://github.com/googleapis/google-cloud-java/pull/3732))

**Misc**

  - Remove dependency on vulnerable version of jackson, upgrade to
    jackson2
    ([\#3724](https://github.com/googleapis/google-cloud-java/pull/3724))
  - Add retries to downloadEmulator() to mitigate transient network
    issues
    ([\#3719](https://github.com/googleapis/google-cloud-java/pull/3719))

# v0.64.0

  - Bigtable: limit mutation sizes in the client to avoid overloading
    the server
    ([\#3695](https://github.com/googleapis/google-cloud-java/pull/3695))
  - Bigtable: add await replication
    ([\#3658](https://github.com/googleapis/google-cloud-java/pull/3658))
  - Bigtable: wrap proto enums
    ([\#3659](https://github.com/googleapis/google-cloud-java/pull/3659))
  - Bigtable: add enhanced stub for bigtable table admin client
    ([\#3691](https://github.com/googleapis/google-cloud-java/pull/3691))

**Bigquery**

  - bigquery: properly fail when setting TableId's project twice
    ([\#3694](https://github.com/googleapis/google-cloud-java/pull/3694))

**Pub/Sub**

  - Migrate Pub/Sub client to ApiFutures.
    ([\#3700](https://github.com/googleapis/google-cloud-java/pull/3700))
  - pubsub: add Publisher.awaitTermination
    ([\#3688](https://github.com/googleapis/google-cloud-java/pull/3688))

**Spanner**

  - Spanner: Block nested transactions
    ([\#3628](https://github.com/googleapis/google-cloud-java/pull/3628))
  - spanner: expand test coverage for getDatabaseClient()
    ([\#3686](https://github.com/googleapis/google-cloud-java/pull/3686))
  - spanner: Add snippets for ReadContext
    ([\#3662](https://github.com/googleapis/google-cloud-java/pull/3662))
  - Clean up snippets for BatchClient and Spanner
    ([\#3684](https://github.com/googleapis/google-cloud-java/pull/3684))

**Storage**

  - Add region tags around an informative sample.
    ([\#3705](https://github.com/googleapis/google-cloud-java/pull/3705))
  - Add downloadFile sample and reformat storage snippets
    ([\#3689](https://github.com/googleapis/google-cloud-java/pull/3689))
  - storage: include information on a bucket prefix
    ([\#3671](https://github.com/googleapis/google-cloud-java/pull/3671))

**Internal**

  - ci: make javadoc not spam us
    ([\#3699](https://github.com/googleapis/google-cloud-java/pull/3699))
  - Kokoro additions
    ([\#3685](https://github.com/googleapis/google-cloud-java/pull/3685))
  - Verify protoc version for batch-generation
    ([\#3676](https://github.com/googleapis/google-cloud-java/pull/3676))
  - Add Kokoro CI config
    ([\#3664](https://github.com/googleapis/google-cloud-java/pull/3664))

**Misc**

# v0.63.0

  - bigtable: RowMutation should allow passing of a Mutation
    ([\#3643](https://github.com/googleapis/google-cloud-java/pull/3643))

## Generated clients

  - Add redis-v1 and video-intelligence-v1p2beta1 to batch
    ([\#3670](https://github.com/googleapis/google-cloud-java/pull/3670))
  - Regenerate proto/grpc files with protoc 3.6.0
    ([\#3672](https://github.com/googleapis/google-cloud-java/pull/3672))
  - Adding redis-v1 and video-intelligence-v1p2beta1
    ([\#3669](https://github.com/googleapis/google-cloud-java/pull/3669))
  - Weekly proto refresh
    ([\#3674](https://github.com/googleapis/google-cloud-java/pull/3674))

## Dependencies

  - update gax to 1.31/0.48
    ([\#3675](https://github.com/googleapis/google-cloud-java/pull/3675))

## Internal

  - Add handwritten integration test for Compute GAPIC
    ([\#3660](https://github.com/googleapis/google-cloud-java/pull/3660))
  - Releasing.md instructions to uncomment nexus-staging-maven-plugin
    ([\#3654](https://github.com/googleapis/google-cloud-java/pull/3654))
  - Fixes for ITComputeTest
    ([\#3667](https://github.com/googleapis/google-cloud-java/pull/3667))

# v0.62.0

  - Improve list tables spooler
    ([\#3639](https://github.com/googleapis/google-cloud-java/pull/3639))
  - Cosmetic cleanup of table admin
    ([\#3638](https://github.com/googleapis/google-cloud-java/pull/3638))
  - Table model improvements
    ([\#3640](https://github.com/googleapis/google-cloud-java/pull/3640))
  - Add resource level IAM
    ([\#3624](https://github.com/googleapis/google-cloud-java/pull/3624))
  - Add CRUD for AppProfiles
    ([\#3619](https://github.com/googleapis/google-cloud-java/pull/3619))
  - Add CRUD for clusters
    ([\#3612](https://github.com/googleapis/google-cloud-java/pull/3612))
  - Clean up consistency token
    ([\#3570](https://github.com/googleapis/google-cloud-java/pull/3570))

## Datastore

  - Make DatastoreBatchWriter public
    ([\#3387](https://github.com/googleapis/google-cloud-java/pull/3387))

## Logging

  - Fix logging integration test failure on when running on GCE
    ([\#3641](https://github.com/googleapis/google-cloud-java/pull/3641))
  - Fix logging unit tests
    ([\#3630](https://github.com/googleapis/google-cloud-java/pull/3630))

## Pubsub

  - Clean up after extension gives up
    ([\#3633](https://github.com/googleapis/google-cloud-java/pull/3633))

## Storage

  - Update signUrl documentation
    ([\#3546](https://github.com/googleapis/google-cloud-java/pull/3546))

## Spanner

  - Add snippets for Spanner, BatchClient and BatchReadOnlyTransaction
    ([\#3611](https://github.com/googleapis/google-cloud-java/pull/3611))

## NIO

  - Retry on 502 errors, and increase max depth when doing channel
    reopens
    ([\#3557](https://github.com/googleapis/google-cloud-java/pull/3557))

## Misc

  - CI build fixes
    ([\#3650](https://github.com/googleapis/google-cloud-java/pull/3650))

# v0.61.0

  - Make integration tests easier to setup with new projects
    ([\#3608](https://github.com/googleapis/google-cloud-java/pull/3608))

## Dependencies

  - Upgrade auth version
    ([\#3606](https://github.com/googleapis/google-cloud-java/pull/3606))

## Documentations

  - Removing word "natural" from Container Analysis product name
    ([\#3610](https://github.com/googleapis/google-cloud-java/pull/3610))

# v0.60.0

Initial release

# BigTable

  - Models are promoted to top level class
    ([\#3513](https://github.com/googleapis/google-cloud-java/pull/3513))
  - Introduce `BigtableInstanceAdmin`
    ([\#3564](https://github.com/googleapis/google-cloud-java/pull/3564))

# NIO

The artifact JAR is shaded more narrowly
([\#3568](https://github.com/googleapis/google-cloud-java/pull/3568))

# v0.59.0

  - Initial release
    ([\#3563](https://github.com/googleapis/google-cloud-java/pull/3563))

## Firestore

  - Elevate access level to support mocking
    ([\#3562](https://github.com/googleapis/google-cloud-java/pull/3562))
  - Add Array Features
    ([\#3561](https://github.com/googleapis/google-cloud-java/pull/3561))

## Logging

  - Update tags for samples
    ([\#3560](https://github.com/googleapis/google-cloud-java/pull/3560))

## Bigtable

  - Implement query sharding by generalizing ReadRows resume request
    builder
    ([\#3103](https://github.com/googleapis/google-cloud-java/pull/3103))

## Pub/Sub

  - Modified RetrySettings in examples
    ([\#3549](https://github.com/googleapis/google-cloud-java/pull/3549))

# v0.58.0

  - Add model table type for the new BigQuery ML models
    ([\#3529](https://github.com/googleapis/google-cloud-java/pull/3529))

## Bigtable

  - Prefix gapic generated clients with `Base`, prefix overlay clients
    with `Bigtable`
    ([\#3538](https://github.com/googleapis/google-cloud-java/pull/3538))
    **breaking change**
  - Decouple TableAdminClient from BigtableTableAdminSettings.
    ([\#3512](https://github.com/googleapis/google-cloud-java/pull/3512))

## Firestore

  - Fix Credentials
    ([\#3541](https://github.com/googleapis/google-cloud-java/pull/3541))

## Storage

  - Set userProject from static default in FileSystemProvider
    ([\#3504](https://github.com/googleapis/google-cloud-java/pull/3504))

## dependencies

  - Bump api-common: 1.6 -\> 1.7
  - Bump gax-java: 1.29.0 -\> 1.30.0
  - Bump api-client: 1.23.0 -\> 1.24.1

## documentation

  - Fix ordering of Default Credentials
    ([\#3539](https://github.com/googleapis/google-cloud-java/pull/3539))

# v0.57.0

  - BigQuery: Add Clustering support
    ([\#3415](https://github.com/googleapis/google-cloud-java/pull/3415))

## Bigtable

  - Bigtable: Move admin api into its own artifact.
    ([\#3494](https://github.com/googleapis/google-cloud-java/pull/3494))
    **breaking change**

## Dataproc

  - Adding dataproc-v1beta2
    ([\#3520](https://github.com/googleapis/google-cloud-java/pull/3520))

## regeneration

  - Regenerating with protoc 3.6.0
    ([\#3506](https://github.com/googleapis/google-cloud-java/pull/3506))
  - Regenerating proto/client classes
    ([\#3519](https://github.com/googleapis/google-cloud-java/pull/3519))

## dependencies

  - update opencensus
    ([\#3481](https://github.com/googleapis/google-cloud-java/pull/3481))
  - bump auth version
    ([\#3498](https://github.com/googleapis/google-cloud-java/pull/3498))

## documentation

  - actually set speech to beta
    ([\#3487](https://github.com/googleapis/google-cloud-java/pull/3487))
  - Fix pom urls
    ([\#3499](https://github.com/googleapis/google-cloud-java/pull/3499))
  - pubsub: minor doc fix for Publisher
    ([\#3501](https://github.com/googleapis/google-cloud-java/pull/3501))
  - pubsub: document auto message extension
    ([\#3491](https://github.com/googleapis/google-cloud-java/pull/3491))
  - fixed Tasks client library link \[skip ci\]
    ([\#3516](https://github.com/googleapis/google-cloud-java/pull/3516))

## internal

  - Bigtable: remove regen scripts in favor of
    utilities/generate\_api.py
    ([\#3495](https://github.com/googleapis/google-cloud-java/pull/3495))
  - ci: don't JAR javadoc
    ([\#3493](https://github.com/googleapis/google-cloud-java/pull/3493))
  - Using --aspect CODE from artman; supporting java\_proto
    ([\#3507](https://github.com/googleapis/google-cloud-java/pull/3507))

# v0.56.0

Fix 0.55.0 importing incorrect vision package (hopefully).

# v0.55.1

add vision/v1p3beta1 and automl clients

bigquery: avoid listing table data for destination of CREATE VIEW DDL
queries

firestore: use custom credential and channel provider by default

storage: fix rewrite operation to support predefinedAcl on a copy

# v0.55.0

  - Set project id from credentials
    ([\#3413](https://github.com/googleapis/google-cloud-java/pull/3413))
  - Fix the error when calling Timestamp.of(Date date) when date is pre
    epoch
    ([\#3434](https://github.com/googleapis/google-cloud-java/pull/3434))
  - Retry IOException: Error writing request body to server to fix the
    intermittent failure when uploading to
    gcs([\#3433](https://github.com/googleapis/google-cloud-java/pull/3433))

## dependencies

  - Bump gax versions to 1.29.0/0.46.0
    ([\#3439](https://github.com/googleapis/google-cloud-java/pull/3439))
  - bump grpc version
    ([\#3447](https://github.com/googleapis/google-cloud-java/pull/3447))
  - Bump protobuf java to 3.6.0
    ([\#3449](https://github.com/googleapis/google-cloud-java/pull/3449))

## multiple clients

  - Release gapics
    ([\#3423](https://github.com/googleapis/google-cloud-java/pull/3423))
  - Regenerating proto/grpc/gapic code
    ([\#3444](https://github.com/googleapis/google-cloud-java/pull/3444))

## BigQuery

  - BigQuery: Document the behavior that streaming inserts are not
    present in destination output
    ([\#3407](https://github.com/googleapis/google-cloud-java/pull/3407))

## BigTable

  - bigtable: Fluent DSL TableAdmin client
    ([\#3395](https://github.com/googleapis/google-cloud-java/pull/3395))
  - Fixing BigTable javadoc errors
    ([\#3459](https://github.com/googleapis/google-cloud-java/pull/3459))

## Compute

  - Regenerate Compute client
    ([\#3438](https://github.com/googleapis/google-cloud-java/pull/3438))
  - Update READMEs for Compute
    ([\#3388](https://github.com/googleapis/google-cloud-java/pull/3388))
  - Ignore deprecated Compute integration test
    ([\#3446](https://github.com/googleapis/google-cloud-java/pull/3446))

## KMS

  - Adding kms-v1
    ([\#3450](https://github.com/googleapis/google-cloud-java/pull/3450))

## Nio

  - ignore nio tests related to requester pays bucket
    ([\#3452](https://github.com/googleapis/google-cloud-java/pull/3452))

## Speech

  - Bumping Speech from alpha to beta
    ([\#3404](https://github.com/googleapis/google-cloud-java/pull/3404))

## Storage

  - Requester-Pays bucket support.
    ([\#3406](https://github.com/googleapis/google-cloud-java/pull/3406))

## Tasks

  - Generation refresh - Cloud Tasks
    ([\#3453](https://github.com/googleapis/google-cloud-java/pull/3453))

## general documentation

  - Point ALPN not configured properly in TROUBLESHOOTING.md to
    ([\#3408](https://github.com/googleapis/google-cloud-java/pull/3408))
  - Fixing versioning comments for GA clients
    ([\#3411](https://github.com/googleapis/google-cloud-java/pull/3411))
  - Fix indentation in code example
    ([\#3456](https://github.com/googleapis/google-cloud-java/pull/3456))

## internal

  - Creating batch\_generate\_apis.py
    ([\#3428](https://github.com/googleapis/google-cloud-java/pull/3428))
  - new approach for snippet injection
    ([\#2838](https://github.com/googleapis/google-cloud-java/pull/2838))
  - Bump maven-source-plugin to 3.0.1
    ([\#3435](https://github.com/googleapis/google-cloud-java/pull/3435))
  - Fix appveyor CI by using TLS 1.2 for Java 7
    ([\#3440](https://github.com/googleapis/google-cloud-java/pull/3440))
  - Add GCE and discogapic to batch gen script
    ([\#3441](https://github.com/googleapis/google-cloud-java/pull/3441))
  - Add IoT, KMS and Tasks to batch generation
    ([\#3445](https://github.com/googleapis/google-cloud-java/pull/3445))
  - Cleanup: generation instructions, version ordering
    ([\#3451](https://github.com/googleapis/google-cloud-java/pull/3451))

# v0.54.0

  - Add ORC format support for load jobs
    ([\#3391](https://github.com/googleapis/google-cloud-java/pull/3391))
  - Plumb in the Bigtable forformat support for federated tables
    ([\#3391](https://github.com/googleapis/google-cloud-java/pull/3391))

# v0.53.0

  - Add samples for managing tables.
    ([\#3361](https://github.com/googleapis/google-cloud-java/pull/3361))
  - Batch sample now reflects Go and Python versions
    ([\#3359](https://github.com/googleapis/google-cloud-java/pull/3359))
  - Removes old sample
    ([\#3364](https://github.com/googleapis/google-cloud-java/pull/3364))

## BigTable

  - Bigtable: enable JWT tokens
    ([\#3351](https://github.com/googleapis/google-cloud-java/pull/3351))

## Compute

  - Add GAPIC Compute java library
    ([\#3100](https://github.com/googleapis/google-cloud-java/pull/3100))

## Firestore

  - Exposing TransportChannelProvider & CredentialsProvider
    ([\#3320](https://github.com/googleapis/google-cloud-java/pull/3320))

## Monitoring

  - Bumping monitoring-v3 to GA
    ([\#3365](https://github.com/googleapis/google-cloud-java/pull/3365))

## Spanner

  - spanner: add support for struct-typed parameters.
    ([\#3287](https://github.com/googleapis/google-cloud-java/pull/3287))

## Web Security Scanner

  - update websecurityscanner readme
    ([\#3352](https://github.com/googleapis/google-cloud-java/pull/3352))

## dependencies

  - bump grpc version to 1.12.0
    ([\#3374](https://github.com/googleapis/google-cloud-java/pull/3374))
  - Bumping gax to 1.28.0 (bidi streaming updates)
    ([\#3375](https://github.com/googleapis/google-cloud-java/pull/3375))

## testing

  - Fix zipslip vulnerability
    ([\#3366](https://github.com/googleapis/google-cloud-java/pull/3366))

# v0.52.0

  - Allow deleting partition expiration by setting the value to `null`

# FireStore

  - Return dates as `com.google.cloud.Timestamp`s.

# Logging

  - Set tracing information in the appropriate place.
  - Add `spanId` to `LogEntry`
  - Add `SourceLocation.newBuilder()`

# Storage

  - Batch requests now honor `options.getHost()`

# Examples

  - New examples for GCS and KMS integration

# v0.51.0

  - Add v1 client

## Core

  - Make MetadataConfig.getAttribute() public
  - Add Timestamp.toDate() method

## Storage

  - Add port to upload URL

## Documentation

  - Update README.md

## Misc

  - Update gax-java, api-common dependencies

# v0.50.0

  - Correct ITBigQueryTest
  - Add support for NUMERIC type
  - Add missing query statistics

## Documentation

  - Update README.md

## Pubsub

  - Add missing region tags
  - Update region tags to standard
  - Declare GA
  - Add the publisher error handler sample.

## Spanner

  - Use method getters

## Storage

  - Fix integration test
  - Storage kms integration

# v0.49.0

  - Move grpc and proto artifacts to google-cloud-java from
    api-client-staging (second part)
    ([\#3251](https://github.com/googleapis/google-cloud-java/pull/3251))
  - Fix integration CI
    ([\#3222](https://github.com/googleapis/google-cloud-java/pull/3222)),
    ([\#3262](https://github.com/googleapis/google-cloud-java/pull/3262))

## BigQuery

  - Unbox Boolean in examples
    ([\#3248](https://github.com/googleapis/google-cloud-java/pull/3248))
  - Let users contruct TableResult for testing
    ([\#3242](https://github.com/googleapis/google-cloud-java/pull/3242))

## Spanner

  - Fix log syntax
    ([\#3241](https://github.com/googleapis/google-cloud-java/pull/3241))

## Translate

  - Document concurrent use
    ([\#3243](https://github.com/googleapis/google-cloud-java/pull/3243))

## Pub/Sub

  - Update pubsub sample links
    ([\#3285](https://github.com/googleapis/google-cloud-java/pull/3285))

## New and regenerated GAPIC clients

  - Add IoT and Web Security Scanner clients
    ([\#3282](https://github.com/googleapis/google-cloud-java/pull/3282))
  - Regenerate existing clients for updated APIs
    ([\#3282](https://github.com/googleapis/google-cloud-java/pull/3282))

## Redis

  - Properly link Redis docs
    ([\#3272](https://github.com/googleapis/google-cloud-java/pull/3272))

## Misc

  - Post-release cleanup and fixes (specific to recent repository
    restructure)
    ([\#3290](https://github.com/googleapis/google-cloud-java/pull/3290))
  - Adjust documentation creation to new repo structure
    ([\#3274](https://github.com/googleapis/google-cloud-java/pull/3274))
  - Fix README API link
    ([\#3273](https://github.com/googleapis/google-cloud-java/pull/3273))
  - Add new clients to README.md
    ([\#3266](https://github.com/googleapis/google-cloud-java/pull/3266))
  - Versions: fix typos in versions and docs
    ([\#3261](https://github.com/googleapis/google-cloud-java/pull/3261))
  - Remove dead assignment
    ([\#3247](https://github.com/googleapis/google-cloud-java/pull/3247))

# v0.48.0

  - Add timeline to statistics information
    ([\#3201](https://github.com/googleapis/google-cloud-java/pull/3201))
  - Add "managing datasets" samples
    ([\#3232](https://github.com/googleapis/google-cloud-java/pull/3232))

# Firestore

  - Catch `Throwable`s in transactions
    ([\#3224](https://github.com/googleapis/google-cloud-java/pull/3224))

# Redis

  - Add client
    ([\#3237](https://github.com/googleapis/google-cloud-java/pull/3237))

# v0.47.0

  - bump auth library version
    ([\#3197](https://github.com/googleapis/google-cloud-java/pull/3197))
  - Regenerating GAPIC clients, updating deps
    ([\#3208](https://github.com/googleapis/google-cloud-java/pull/3208))

## BigQuery

  - bigquery: remove QueryParameterValue validation
    [\#3179](https://github.com/googleapis/google-cloud-java/pull/3179)
  - BigQuery: Standardizes region tags and adds query snippets from
    java-docs-samples
    [\#3180](https://github.com/googleapis/google-cloud-java/pull/3180)
  - BigQuery: Add extended statistics to QueryStage.
    ([\#3185](https://github.com/googleapis/google-cloud-java/pull/3185))

## Bigtable

  - Bigtable: Expose an API to allow users to create their own batches
    for MutateRows
    ([\#3129](https://github.com/googleapis/google-cloud-java/pull/3129))
  - Fixing javadoc
    ([\#3209](https://github.com/googleapis/google-cloud-java/pull/3209))

## Firestore

  - firestore: use the right compare function for FieldPaths
    ([\#3189](https://github.com/googleapis/google-cloud-java/pull/3189))
  - Census tracing integration for Firestore.
    ([\#2729](https://github.com/googleapis/google-cloud-java/pull/2729))
  - firestore: fixing bug in QuerySnapshot
    ([\#3195](https://github.com/googleapis/google-cloud-java/pull/3195))
  - firestore: allow non-POJO classes to be subclassed for mocking.
    ([\#3176](https://github.com/googleapis/google-cloud-java/pull/3176))
  - Java Format PR
    ([\#3200](https://github.com/googleapis/google-cloud-java/pull/3200))
  - Updating Watch conformance tests
    ([\#3202](https://github.com/googleapis/google-cloud-java/pull/3202))

## Spanner

  - spanner: make TransactionManager.close() idempotent
    ([\#3183](https://github.com/googleapis/google-cloud-java/pull/3183))

## etc

  - fixing typos
    ([\#3204](https://github.com/googleapis/google-cloud-java/pull/3204))

# v0.46.0

  - Stop Subscriber asynchronously
    ([\#3144](https://github.com/googleapis/google-cloud-java/pull/3144))

## Bigquery

  - Add support for Google Sheets external tables in BigQuery
    ([\#3160](https://github.com/googleapis/google-cloud-java/pull/3160))
  - Throw the creation exception if there isn't a job created
    ([\#3163](https://github.com/googleapis/google-cloud-java/pull/3163))
  - Add support for new api features in BigQuery TimePartitioning.
    ([\#3158](https://github.com/googleapis/google-cloud-java/pull/3158))
  - Expose the schema of dry run query jobs.
    ([\#3159](https://github.com/googleapis/google-cloud-java/pull/3159))

## Firestore

  - Adding Watch conformane tests
    ([\#3171](https://github.com/googleapis/google-cloud-java/pull/3171))

## Misc

  - Add javadoc test to circleci
    ([\#3165](https://github.com/googleapis/google-cloud-java/pull/3165))
  - Regenerate java clients, bump proto-/grpc-artifacts dependency
    versions
    ([\#3173](https://github.com/googleapis/google-cloud-java/pull/3173))

# v0.45.0

  - document job location
  - implement regionalization

## Bigtable

  - make models serializable

## Core

  - add parent resource names

## Dialogflow

  - add dialogflow v2

## Doc

  - fix site (documentation) generation
  - improve pubsub javadoc

## Misc

  - update maven enforcer

## Pubsub

  - change Subscriber defaults

## Spanner

  - add Transaction manager API for manually managing retries of a
    transaction

# v0.44.0

  - Add location property
    ([\#3121](https://github.com/googleapis/google-cloud-java/pull/3121))

#### Pubsub

  - Use unary calls to send acks/modacks
    ([\#3123](https://github.com/googleapis/google-cloud-java/pull/3123))
  - Expose the publishAllOutstanding() method as public
    ([\#3093](https://github.com/googleapis/google-cloud-java/pull/3093))

#### Testing

  - Update test for set({}, mergeAll:true)
    ([\#3115](https://github.com/googleapis/google-cloud-java/pull/3115))

## Misc

  - Prefetcher, to read fast.
    ([\#3054](https://github.com/googleapis/google-cloud-java/pull/3054))
  - Minor javadoc fixes
    ([\#3104](https://github.com/googleapis/google-cloud-java/pull/3104))

# v0.43.0

  - Bigtable: 21. Refactor Batching - Move retries behind batching
    ([\#3026](https://github.com/googleapis/google-cloud-java/pull/3026))

#### Cross-API

  - Bumping proto/grpc deps and regenerating clients
    ([\#3111](https://github.com/googleapis/google-cloud-java/pull/3111))

#### Dependencies

  - Update gRPC version to 1.10.1, same as used in gax-java
    ([\#3101](https://github.com/googleapis/google-cloud-java/pull/3101))
  - Update gax versions to 1.22.0/0.39.0
    ([\#3102](https://github.com/googleapis/google-cloud-java/pull/3102))
  - Update gax dependencies
    ([\#3107](https://github.com/googleapis/google-cloud-java/pull/3107))

#### Testing

  - Adding Query Tests for NaN and Null
    ([\#3091](https://github.com/googleapis/google-cloud-java/pull/3091))
  - add a smoke-test mvn profile
    ([\#3085](https://github.com/googleapis/google-cloud-java/pull/3085))
  - Let surefire not run smoke tests
    ([\#3113](https://github.com/googleapis/google-cloud-java/pull/3113))

# v0.42.1

  - Add support for commit timestamp columns in spanner
    ([\#3080](https://github.com/googleapis/google-cloud-java/pull/3080))

#### Bigtable

  - Add README
    ([\#3090](https://github.com/googleapis/google-cloud-java/pull/3090))

#### Misc

  - Bump proto/grpc package versions to 0.7.0/1.6.0
    ([\#3092](https://github.com/googleapis/google-cloud-java/pull/3092))

# v0.42.0

  - Update auth snippets

#### Text-to-Speech

  - Add texttospeech module (initial release)
    ([\#3075](https://github.com/googleapis/google-cloud-java/pull/3075))

#### Pub/Sub

  - Update code examples
    ([\#3059](https://github.com/googleapis/google-cloud-java/pull/3059))
  - Delete getSubscriptionName
    ([\#3060](https://github.com/googleapis/google-cloud-java/pull/3060))

#### Bigtable

  - Add tests for data resource headers
    ([\#3062](https://github.com/googleapis/google-cloud-java/pull/3062))
  - Implement integration tests
    ([\#2997](https://github.com/googleapis/google-cloud-java/pull/2997))
  - Copy InstanceName to data.models.
    ([\#3063](https://github.com/googleapis/google-cloud-java/pull/3063))
  - Resource Prefixes
    ([\#3050](https://github.com/googleapis/google-cloud-java/pull/3050))

#### Logginig

  - Add interface for enhancing Logback events
    ([\#2734](https://github.com/googleapis/google-cloud-java/pull/2734))

# v0.41.0

Release 0.41.0
([\#3076](https://github.com/googleapis/google-cloud-java/pull/3076))

# v0.40.1

  - Upgrade to gax 1.20.0

## DLP

  - Add a utility conversion function
  - Add DLP v2 client

## Logging

  - Fix page size not propagating

## Pubsub

  - Make Publisher use GAPIC client
  - Remove polling implementation

## Storage

  - Change batch endpoint from /batch to /batch/storage/v1
  - Speed up IT

## Video intelligence

  - Add Video-intelligence v1p1beta1

# v0.40.0

  - Improve ranges
  - Implement bulk mutations
  - Improve RowCell by using getters for attributes

## Bigquery

  - Update dependencies
  - Declare GA
  - Added a snippet to show how to read a newline-delimited-json file
    and store it in a Table

## Datastore

  - Mark entity bindings as unsupported operation and deprecated

## Documentation

  - Firestore: removed extra 'a' in ArraySortedMap findkey documentation

## Firestore

  - Fixing order test to verify that we order by components

## Pubsub

  - Make Publisher/Subscriber accept plain strings

## Spanner

  - Add auto-generated GAPIC client

## Translate

  - Fix log messages

## Vision

  - Add Vision v1p2beta1

# v0.39.0

  - Update proto and grpc dependency versions
  - Added more detail to troubleshooting guide
    ([\#2988](https://github.com/googleapis/google-cloud-java/pull/2988))
  - Update api-common dependency to 1.4.0
    ([\#2991](https://github.com/googleapis/google-cloud-java/pull/2991))
  - Delete APPENGINE.md
  - Move generated protobuf and grpc dependencies to bom
    ([\#2990](https://github.com/googleapis/google-cloud-java/pull/2990))
  - Update README.md
  - Upgrade cloudresourcemanager dependency version
    ([\#2944](https://github.com/googleapis/google-cloud-java/pull/2944))
  - Move bom dependencies to outer pom
    ([\#2976](https://github.com/googleapis/google-cloud-java/pull/2976))
  - Add TROUBLESHOOTING.md
    ([\#2977](https://github.com/googleapis/google-cloud-java/pull/2977))
  - Clarifying Alpha (deletion is possible)
    ([\#2975](https://github.com/googleapis/google-cloud-java/pull/2975))

#### Bigtable

  - Implement ReadRows retries
    ([\#2986](https://github.com/googleapis/google-cloud-java/pull/2986))
  - Implement ReadModifyWriteRow
    ([\#2981](https://github.com/googleapis/google-cloud-java/pull/2981))
  - Implement CheckAndMutateRow
    ([\#2980](https://github.com/googleapis/google-cloud-java/pull/2980))
  - Implement MutateRow
    ([\#2941](https://github.com/googleapis/google-cloud-java/pull/2941))
  - Implementation: integrate ReadRows
    ([\#2940](https://github.com/googleapis/google-cloud-java/pull/2940))
  - Bulk Mutations
    ([\#2936](https://github.com/googleapis/google-cloud-java/pull/2936))
  - ReadModifyWriteRow
    ([\#2939](https://github.com/googleapis/google-cloud-java/pull/2939))
  - CheckAndMutate
    ([\#2938](https://github.com/googleapis/google-cloud-java/pull/2938))

#### Bigquery

  - BigQuery GA
    ([\#2982](https://github.com/googleapis/google-cloud-java/pull/2982))

#### Storage

  - Delete blobs faster
    ([\#2972](https://github.com/googleapis/google-cloud-java/pull/2972))

#### Firestore

  - Equals to the Public API + Allowing empty merges + Test Fix
    ([\#2971](https://github.com/googleapis/google-cloud-java/pull/2971))

# v0.38.0

  - Support for Batch Read API
    ([\#2953](https://github.com/googleapis/google-cloud-java/pull/2953))

# v0.37.0

  - Update proto and grpc dependency versions
  - Version fixes (tagging, incorrect versions, bigtable downgrade)
    ([\#2956](https://github.com/googleapis/google-cloud-java/pull/2956))
  - Add new version update scripts
    ([\#2947](https://github.com/googleapis/google-cloud-java/pull/2947))
  - Add grpc-core to BOM
    ([\#2931](https://github.com/googleapis/google-cloud-java/pull/2931))

#### Bigtable

  - Rewrite ReframingResponseObserver
    ([\#2925](https://github.com/googleapis/google-cloud-java/pull/2925))
  - Implement SampleRowKeys
    ([\#2913](https://github.com/googleapis/google-cloud-java/pull/2913))
  - Update helper script to work with the latest artman changes
    ([\#2943](https://github.com/googleapis/google-cloud-java/pull/2943))
  - Update Settings test to use StubSettings, formatting
    ([\#2935](https://github.com/googleapis/google-cloud-java/pull/2935))
  - Rename surface
    ([\#2934](https://github.com/googleapis/google-cloud-java/pull/2934))
  - Implement ReadRows row merging logic.
    ([\#2914](https://github.com/googleapis/google-cloud-java/pull/2914))
  - Surface: MutateRow
    ([\#2861](https://github.com/googleapis/google-cloud-java/pull/2861))

#### Core

  - oneof -\> inheritance conversion
    ([\#2930](https://github.com/googleapis/google-cloud-java/pull/2930))
    **breaking change**

## Logging

  - Log more kubernetes properties
    ([\#2937](https://github.com/googleapis/google-cloud-java/pull/2937))

#### Firestore

  - Fix integration test
    ([\#2950](https://github.com/googleapis/google-cloud-java/pull/2950))

# v0.36.0

  - Update\_versions.sh script: update versions in bom pom
    ([\#2703](https://github.com/googleapis/google-cloud-java/pull/2703))
  - Add XML syntax highlighting in READMEs
    ([\#2922](https://github.com/googleapis/google-cloud-java/pull/2922))
  - Add missing copyright headers to scripts
    ([\#2923](https://github.com/googleapis/google-cloud-java/pull/2923))
  - Remove Travis
    ([\#2883](https://github.com/googleapis/google-cloud-java/pull/2883))
  - Update CONTRIBUTING.MD for installing
    ([\#2881](https://github.com/googleapis/google-cloud-java/pull/2881))
  - Adding basic builds to CircleCI config
    ([\#2877](https://github.com/googleapis/google-cloud-java/pull/2877))
  - Use new googleapis javadoc page
    ([\#2862](https://github.com/googleapis/google-cloud-java/pull/2862))
  - Add a veneer-dev profile that autoformats modified sources during
    maven runs
    ([\#2851](https://github.com/googleapis/google-cloud-java/pull/2851))

#### Bigtable

  - Cleanup - tweak filters
    ([\#2919](https://github.com/googleapis/google-cloud-java/pull/2919))
  - Bug fix - Fix Reframer error handling
    ([\#2920](https://github.com/googleapis/google-cloud-java/pull/2920))
  - Bug fix - Make ranges mutable
    ([\#2915](https://github.com/googleapis/google-cloud-java/pull/2915))
  - Add a generic reframer
    ([\#2907](https://github.com/googleapis/google-cloud-java/pull/2907))
  - Add Base structure for Bigtable surface updates
    ([\#2842](https://github.com/googleapis/google-cloud-java/pull/2842))
  - Add SampleRowKeys to the surface
    ([\#2857](https://github.com/googleapis/google-cloud-java/pull/2857))
  - Add Readrows to the surface
    ([\#2849](https://github.com/googleapis/google-cloud-java/pull/2849))
  - Add a couple of developer helper scripts
    ([\#2841](https://github.com/googleapis/google-cloud-java/pull/2841))

#### Bigquery

  - Add table label
    ([\#2873](https://github.com/googleapis/google-cloud-java/pull/2873))
  - Make FieldValue publicly construct-able
    ([\#2891](https://github.com/googleapis/google-cloud-java/pull/2891))
  - Try getting job if create fails
    ([\#2887](https://github.com/googleapis/google-cloud-java/pull/2887))
  - Add support for customer supplied encryption keys
    ([\#2870](https://github.com/googleapis/google-cloud-java/pull/2870))

#### Storage

  - Add documentation to FakeStorageRpc and LocalStorageHelper
    ([\#2906](https://github.com/googleapis/google-cloud-java/pull/2906))
  - Make download in StorageExamples more straightforward
    ([\#2905](https://github.com/googleapis/google-cloud-java/pull/2905))
  - Fix Storage integration tests
    ([\#2886](https://github.com/googleapis/google-cloud-java/pull/2886))
  - Add initial opencensus instrumentation code in Cloud Storage
    ([\#2846](https://github.com/googleapis/google-cloud-java/pull/2846))
  - Fix intermittent Storage integration test failures
    ([\#2872](https://github.com/googleapis/google-cloud-java/pull/2872))

#### Speech

  - Remove PageResponseWrappers, add speech v1p1beta1
    ([\#2927](https://github.com/googleapis/google-cloud-java/pull/2927))

#### Core

  - Allow custom roles
    ([\#2863](https://github.com/googleapis/google-cloud-java/pull/2863))
  - Make BaseWriteChannel surprise less
    ([\#2900](https://github.com/googleapis/google-cloud-java/pull/2900))
  - Add validation for project-id returned by metadata server
    ([\#2868](https://github.com/googleapis/google-cloud-java/pull/2868))
  - Update gax to 1.19.0
    ([\#2885](https://github.com/googleapis/google-cloud-java/pull/2885))
  - Use grpc-netty-shaded
    ([\#2832](https://github.com/googleapis/google-cloud-java/pull/2832))
  - Use GAE\_RUNTIME to detect java version
    ([\#2837](https://github.com/googleapis/google-cloud-java/pull/2837))

#### Logginig

  - Support HTTP request latency
    ([\#2908](https://github.com/googleapis/google-cloud-java/pull/2908))
  - Fix Logging integration tests
    ([\#2860](https://github.com/googleapis/google-cloud-java/pull/2860))
  - Delete redundant tests
    ([\#2850](https://github.com/googleapis/google-cloud-java/pull/2850))

#### Firestore

  - Accept strings in where(FieldPath.documentId(), ...)
    ([\#2903](https://github.com/googleapis/google-cloud-java/pull/2903))
  - Pull in newest version of Conformance Tests
    ([\#2898](https://github.com/googleapis/google-cloud-java/pull/2898))

#### Datastore

  - Document DatastoreWriter.update exception
    ([\#2894](https://github.com/googleapis/google-cloud-java/pull/2894))

#### Dns

  - Fix Dns batch operations
    ([\#2858](https://github.com/googleapis/google-cloud-java/pull/2858))

# v0.35.0

  - bigquery: properly forward Dataset labels
    ([\#2799](https://github.com/googleapis/google-cloud-java/pull/2799))
  - bigquery: support null values in inserts
    ([\#2798](https://github.com/googleapis/google-cloud-java/pull/2798))
  - simplify string concat
    ([\#2773](https://github.com/googleapis/google-cloud-java/pull/2773))
  - bigquery: small refactorings
    ([\#2817](https://github.com/googleapis/google-cloud-java/pull/2817))
  - bigquery: allow users to construct TableDefinition
    ([\#2814](https://github.com/googleapis/google-cloud-java/pull/2814))
  - bigquery: fix failing integ test
    ([\#2831](https://github.com/googleapis/google-cloud-java/pull/2831))

## Compute

  - compute: deprecate
    ([\#2819](https://github.com/googleapis/google-cloud-java/pull/2819))
    *breaking change*

## Datastore

  - support datastore transaction options
    ([\#2613](https://github.com/googleapis/google-cloud-java/pull/2613))
  - datastore: better document emulator functions
    ([\#2828](https://github.com/googleapis/google-cloud-java/pull/2828))

## Dependencies/build logic

  - add logback to bom
    ([\#2815](https://github.com/googleapis/google-cloud-java/pull/2815))
  - Initial CircleCI config for integration tests
    ([\#2808](https://github.com/googleapis/google-cloud-java/pull/2808))
  - CircleCI: Adding speech integration tests
    ([\#2826](https://github.com/googleapis/google-cloud-java/pull/2826))
  - CircleCI integration tests: adding more APIs
    ([\#2829](https://github.com/googleapis/google-cloud-java/pull/2829))
  - CircleCI: Adding firestore, bumping compute timeout
    ([\#2836](https://github.com/googleapis/google-cloud-java/pull/2836))
  - CircleCI: Adding Storage
    ([\#2839](https://github.com/googleapis/google-cloud-java/pull/2839))
  - Disabling integration tests in Travis/Appveyor
    ([\#2840](https://github.com/googleapis/google-cloud-java/pull/2840))

## Firestore

  - Adding test for return value of runTransaction()
    ([\#2801](https://github.com/googleapis/google-cloud-java/pull/2801))
  - Adding .close() to Firestore Service
    ([\#2807](https://github.com/googleapis/google-cloud-java/pull/2807))
  - Making sure Firestore Java doesn't drop update values
    ([\#2818](https://github.com/googleapis/google-cloud-java/pull/2818))
  - Adding Query Conformance Tests
    ([\#2811](https://github.com/googleapis/google-cloud-java/pull/2811))
  - Adding Transaction.getAll()
    ([\#2844](https://github.com/googleapis/google-cloud-java/pull/2844))

## Logging

  - logging: clear null trace\_id
    ([\#2760](https://github.com/googleapis/google-cloud-java/pull/2760))
  - logback: log stack trace
    ([\#2765](https://github.com/googleapis/google-cloud-java/pull/2765))
  - logging delete unused methods
    ([\#2827](https://github.com/googleapis/google-cloud-java/pull/2827))

## Storage

  - Using extended headers with sign URL
    ([\#2422](https://github.com/googleapis/google-cloud-java/pull/2422))
  - Filesys name
    ([\#2809](https://github.com/googleapis/google-cloud-java/pull/2809))

## Cross-API

  - Gax java stubsettings
    ([\#2825](https://github.com/googleapis/google-cloud-java/pull/2825))
    *widespread breaking changes*
  - batch refresh
    ([\#2843](https://github.com/googleapis/google-cloud-java/pull/2843))
  - fix build
    ([\#2830](https://github.com/googleapis/google-cloud-java/pull/2830))

## Readmes/other docs

  - firestore: document transport
    ([\#2790](https://github.com/googleapis/google-cloud-java/pull/2790))
  - READMEs: clarifying umbrella package
    ([\#2806](https://github.com/googleapis/google-cloud-java/pull/2806))
  - firestore: fix doc typo
    ([\#2747](https://github.com/googleapis/google-cloud-java/pull/2747))
  - Removing self from CODEOWNERS
    ([\#2824](https://github.com/googleapis/google-cloud-java/pull/2824))

# v0.34.0

  - bigquery: properly handle empty array params
    ([\#2695](https://github.com/googleapis/google-cloud-java/pull/2695))
  - bigquery: allow schema-ful data listing
    ([\#2697](https://github.com/googleapis/google-cloud-java/pull/2697))
  - bigquery: properly spell "BigQuery"
    ([\#2716](https://github.com/googleapis/google-cloud-java/pull/2716))
    *breaking change*
  - bigquery: also allow schema-ful list from Table
    ([\#2718](https://github.com/googleapis/google-cloud-java/pull/2718))
  - bigquery: add setUseLegacySql to ViewDefinition
    ([\#2743](https://github.com/googleapis/google-cloud-java/pull/2743))
  - bigquery: properly detect statistics type
    ([\#2742](https://github.com/googleapis/google-cloud-java/pull/2742))
  - bigquery: loudly report invalid operations on dryruns
    ([\#2772](https://github.com/googleapis/google-cloud-java/pull/2772))
  - bigquery: use standard SQL by default
    ([\#2766](https://github.com/googleapis/google-cloud-java/pull/2766))

**Firestore**

  - Adding Firestore Watch
    ([\#2665](https://github.com/googleapis/google-cloud-java/pull/2665))
  - Adding Conformance Test for the Java Firestore SDK
    ([\#2719](https://github.com/googleapis/google-cloud-java/pull/2719))
  - Stripping Empty Write Requests
    ([\#2739](https://github.com/googleapis/google-cloud-java/pull/2739))
  - Pulling in the latest version of the Conformance Tests
    ([\#2767](https://github.com/googleapis/google-cloud-java/pull/2767))
  - Adding support for DocumentSnapshot cursors
    ([\#2768](https://github.com/googleapis/google-cloud-java/pull/2768))
  - Adding QueryDocumentSnapshot
    ([\#2738](https://github.com/googleapis/google-cloud-java/pull/2738))

**Logging**

  - logging: flowcontrol should block
    ([\#2741](https://github.com/googleapis/google-cloud-java/pull/2741))

**NIO**

  - Generation support
    ([\#2232](https://github.com/googleapis/google-cloud-java/pull/2232))

**Pub/Sub**

  - pubsub: use system executor for stream reconnection
    ([\#2749](https://github.com/googleapis/google-cloud-java/pull/2749))
  - pubsub: respect total expiration while modacking
    ([\#2715](https://github.com/googleapis/google-cloud-java/pull/2715))
  - pubsub: use gax pool
    ([\#2751](https://github.com/googleapis/google-cloud-java/pull/2751))
  - pubsub: document Subscriber running forever
    ([\#2750](https://github.com/googleapis/google-cloud-java/pull/2750))

**Spanner**

  - Cloud Spanner: Adds tracing
    ([\#2677](https://github.com/googleapis/google-cloud-java/pull/2677))
  - Treat RESOURCE\_EXHAUSTED with retry information as aborted.
    ([\#2645](https://github.com/googleapis/google-cloud-java/pull/2645))
  - We can retry on "Received unexpected EOS".
    ([\#2757](https://github.com/googleapis/google-cloud-java/pull/2757))

**Cross-API**

  - Add support for custom static headers
    ([\#2690](https://github.com/googleapis/google-cloud-java/pull/2690))
    *breaking change*
  - Regenerating GAPIC clients
    ([\#2774](https://github.com/googleapis/google-cloud-java/pull/2774))
  - Java autogen client refresh, proto/grpc bump
    ([\#2779](https://github.com/googleapis/google-cloud-java/pull/2779))

**New Clients**

  - Adding dataproc and oslogin
    ([\#2780](https://github.com/googleapis/google-cloud-java/pull/2780))
      - Adding missing modules (os-login & dataproc)
        ([\#2785](https://github.com/googleapis/google-cloud-java/pull/2785))
      - Fixing google-cloud-dataproc version
        ([\#2786](https://github.com/googleapis/google-cloud-java/pull/2786))

**Dependencies/build logic**

  - Removing compile dependency on org.json
    ([\#2728](https://github.com/googleapis/google-cloud-java/pull/2728))
  - add grpc-testing to bom
    ([\#2761](https://github.com/googleapis/google-cloud-java/pull/2761))
  - Update license check to be compatible with toolkit changes
    ([\#2762](https://github.com/googleapis/google-cloud-java/pull/2762))
  - Update google-cloud-datastore proto driver to v1.6.0.
    ([\#2770](https://github.com/googleapis/google-cloud-java/pull/2770))
  - Deleting google-cloud-dep-verification
    ([\#2782](https://github.com/googleapis/google-cloud-java/pull/2782))
  - Bumping grpc from 1.7 to 1.9
    ([\#2783](https://github.com/googleapis/google-cloud-java/pull/2783))

**Readmes/other docs**

  - \[video-intelligence\] update readme v1beta to v1
    ([\#2704](https://github.com/googleapis/google-cloud-java/pull/2704))
  - Fix css for doc page
    ([\#2711](https://github.com/googleapis/google-cloud-java/pull/2711))
  - add bigquery release notes
    ([\#2717](https://github.com/googleapis/google-cloud-java/pull/2717))
  - Compute readme: this client is no longer being updated
    ([\#2726](https://github.com/googleapis/google-cloud-java/pull/2726))
  - Adding readme for google-cloud-bom
    ([\#2725](https://github.com/googleapis/google-cloud-java/pull/2725))
  - Reword comment
    ([\#2541](https://github.com/googleapis/google-cloud-java/pull/2541))
  - Fix the code snippet in README
    ([\#2455](https://github.com/googleapis/google-cloud-java/pull/2455))
  - Fixes typo in javadocs for Datastore's BaseEntity class.
    ([\#2403](https://github.com/googleapis/google-cloud-java/pull/2403))
  - Adding README for dialogflow
    ([\#2730](https://github.com/googleapis/google-cloud-java/pull/2730))
  - Improve GCS signUrlOption javadoc
    ([\#1928](https://github.com/googleapis/google-cloud-java/pull/1928))
  - all: fix copyright header
    ([\#2763](https://github.com/googleapis/google-cloud-java/pull/2763))

**Note**  
We have started a new reference page which details breaking changes at
<https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CHANGES.md>
. This will be updated to reflect breaking changes in a more descriptive
way going forward, and will be the best place to consult for finding out
how to adjust to the breaking changes in each release.

# v0.33.0

  - Adding container-v1
    ([\#2689](https://github.com/googleapis/google-cloud-java/pull/2689)
    )
  - Adding bigquerydatatransfer-v1
    ([\#2689](https://github.com/googleapis/google-cloud-java/pull/2689)
    )
  - Adding vision-v1p1beta1
    ([\#2689](https://github.com/googleapis/google-cloud-java/pull/2689)
    )

**Firestore**

  - Adding data structures
    ([\#2658](https://github.com/googleapis/google-cloud-java/pull/2658)
    )
  - Adding v1beta1 ordering semantics
    ([\#2662](https://github.com/googleapis/google-cloud-java/pull/2662)
    )

**Notification**

  - Adding notification client, a light wrapper around pubsub and
    storage clients
    ([\#2571](https://github.com/googleapis/google-cloud-java/pull/2571)
    )

**Storage**

  - Public data download available to unauthenticated clients
    ([\#2649](https://github.com/googleapis/google-cloud-java/pull/2649)
    )

**Datastore**

  - Adding `toString()` to `OrderBy`

**Other**

  - Codegen refresh
    ([\#2689](https://github.com/googleapis/google-cloud-java/pull/2689)
    )
  - Removing deprecated code
    ([\#2640](https://github.com/googleapis/google-cloud-java/pull/2640)
    )
  - Add Maven bill of materials (BOM)
    ([\#2679](https://github.com/googleapis/google-cloud-java/pull/2679)
    )

# v0.32.0

  - Adding cloud-trace-v2
    ([\#2630](https://github.com/googleapis/google-cloud-java/pull/2630))
  - Adding videointelligence-v1
    ([\#2632](https://github.com/googleapis/google-cloud-java/pull/2632))
  - Promoting google-cloud-vision to GA
    ([\#2633](https://github.com/googleapis/google-cloud-java/pull/2633))

**Firestore**

  - Rejecting conflicting field paths
    ([\#2625](https://github.com/googleapis/google-cloud-java/pull/2625))

**Other**

  - Codegen refresh
    ([\#2631](https://github.com/googleapis/google-cloud-java/pull/2631))

# v0.30.0

  - Fix long-running operations
    ([\#2619](https://github.com/googleapis/google-cloud-java/pull/2619))
  - Clean up generated proto property names
    ([\#2608](https://github.com/googleapis/google-cloud-java/pull/2608))

**Dialog Flow**

  - Initial release
    ([\#2626](https://github.com/googleapis/google-cloud-java/pull/2626))

**Datastore**

  - Update google-cloud-datastore protos + client
    ([\#2574](https://github.com/googleapis/google-cloud-java/pull/2574))

**PubSub**

  - *BREAKING CHANGE* Fix and simplify deadline extension
    ([\#2604](https://github.com/googleapis/google-cloud-java/pull/2604))
      - This release removes the ability to set padding time. Setting
        this time  
        too high or too low has created many bugs in the past.  
        Currently the value is set to 5 seconds, which should be enough
        to account  
        for communication latency between client and server.  
        If you believe you need this configuration, please file an
        issue.
  - Remove tests from SubscriberTest
    ([\#2618](https://github.com/googleapis/google-cloud-java/pull/2618))
  - Make connection log less aggressively
    ([\#2615](https://github.com/googleapis/google-cloud-java/pull/2615))
  - Clarify sleep-then-stop in snippet
    ([\#2617](https://github.com/googleapis/google-cloud-java/pull/2617))
  - Send message receipts
    ([\#2580](https://github.com/googleapis/google-cloud-java/pull/2580))

**Firestore**

  - Make FieldPath public
    ([\#2602](https://github.com/googleapis/google-cloud-java/pull/2602))
  - Make getPath() relative to the database root
    ([\#2599](https://github.com/googleapis/google-cloud-java/pull/2599))
  - Allow DocumentReferences for Query cursors

# v0.29.0

Regenerating clients with surface cleanup
([\#2598](https://github.com/googleapis/google-cloud-java/pull/2598))

Bumping dependencies (api-common, gax, protos)
([\#2600](https://github.com/googleapis/google-cloud-java/pull/2600))

  - api-common -\> 1.2.0
  - gax -\> 1.14.0
  - gax-grpc -\> 1.14.0 (first 1.x version)
  - generated proto packages -\> 1.0.0/0.1.24

Bumping language to GA, 4 others to Beta
([\#2601](https://github.com/googleapis/google-cloud-java/pull/2601))

  - google-cloud-language: Beta -\> GA
  - google-cloud-dlp: Alpha -\> Beta
  - google-cloud-errorreporting: Alpha -\> Beta
  - google-cloud-monitoring: Alpha -\> Beta
  - google-cloud-trace: Alpha -\> Beta

# v0.28.0

  - api-client -\> 1.23.0
  - gax-java -\> 1.13.0
  - gax-grpc -\> 0.30.0
  - google-auth-library -\> 0.9.0
  - grpc -\> 1.7.0
  - nettyssl -\> 2.0.6

**General:**

  - Add new surface for Bigtable v2 and admin-v2 APIs
  - Adjustments to breaking changes in gax-java

**Bigquery:**

  - Allow user to set null schema
  - Add simple benchmarks

**Firestore:**

  - `DatabaseName` renamed to `DatabaseRootName`
  - Using the pageable response from `ListCollectionIds`

**Pubsub:**

  - Add keepalive
  - Translate exception to ApiException

**Storage:**

  - Support userProject param for some Requester Pays operations

**Video Intelligence:**

  - `annotateVideoAsync` has parameters removed

**Documentation:**

  - Pubsub: point users to Guava's Service doc
  - Fix doc link for Firestore

# v0.27.0

  - missing features and fix found bugs (see
    [\#2446](https://github.com/googleapis/google-cloud-java/pull/2446))
  - add retries for insertAll

**Dependency**

  - gax dependency -\> 1.9.0
  - google-cloud-datastore client dependency -\> 1.4.1

**DLP**

  - refreshed client lib

**Firestore**

  - Using commitTime instead of updateTime for deletes

**PubSub**

  - fix race condition in streaming connection
  - clarify subscriber shutdown doc
  - make logs quieter
  - reconnect with old executor

**Samples**

  - update download requester pays sample

**Spanner**

  - tests and style fixes

# v0.26.0

  - getQueryResults no longer returns null on 404

**Example:**

  - add PubSub emulator snippet  
    **Firestore:**
  - google-cloud-firestore beta released

**Logging:**

  - remove unused `flushSize` logging configuration parameter

**PubSub:**

  - retry on ABORTED
  - all connections share one message queue

**Spanner:**

  - increase response header size

**Storage:**

  - fix requester pays issues

**Video intelligence:**

  - beta release

# v0.25.0

  - generated Proto/gRPC packages -\> 0.1.19

**Video Intelligence**

  - add google-cloud-video-intelligence v1beta2

**Natural Language**

  - refresh google-cloud-language v1

**Documentation**

  - Spanner: update documentation of INSERT\_OR\_UPDATE mutation
  - Storage: adding `RequesterPays` snippets

# v0.24.0

  - Update gax versions
    ([\#2434](https://github.com/googleapis/google-cloud-java/pull/2434))
  - Update dependency verification versions
    ([\#2435](https://github.com/googleapis/google-cloud-java/pull/2435))

# v0.23.1

Update dependencies

  - gax -\> 1.8.0
  - google-auth -\> 0.8.0
  - grpc -\> 1.6.1
  - generated proto -\> 0.1.17

# v0.23.0

  - Fix response code retrying logic for HTTP responses with
    "Content-Type" other than "application/json".
    ([\#2329](https://github.com/googleapis/google-cloud-java/pull/2329))

## BigQuery

  - Skip 0 byte writes
  - Add numDmlAffectedRows to QueryResponse
    ([\#2320](https://github.com/googleapis/google-cloud-java/pull/2320))
  - Using Jobs.insert instead of Jobs.query for queries
    ([\#2323](https://github.com/googleapis/google-cloud-java/pull/2323))

## Datastore

  - datastore: cache application name
    ([\#2292](https://github.com/googleapis/google-cloud-java/pull/2292))
  - fix NullPointerException
    ([\#2271](https://github.com/googleapis/google-cloud-java/pull/2271))

## Logging

  - Add missing fields to LogEntry
    ([\#2313](https://github.com/googleapis/google-cloud-java/pull/2313))

## Nio

  - \[NIO\] Fix inconsistent failure messages.
    ([\#2330](https://github.com/googleapis/google-cloud-java/pull/2330))

## Pub/Sub

  - pubsub: enable streaming pull
    ([\#2344](https://github.com/googleapis/google-cloud-java/pull/2344))

## Storage

  - Fixing retries of Storage.create
    ([\#2359](https://github.com/googleapis/google-cloud-java/pull/2359))

## Util

  - Creating google-cloud-compat-checker
    ([\#2317](https://github.com/googleapis/google-cloud-java/pull/2317))
  - Checking more things in google-cloud-compat-checker
    ([\#2347](https://github.com/googleapis/google-cloud-java/pull/2347))

## Documentation-only

  - P0 auth sample
    ([\#2298](https://github.com/googleapis/google-cloud-java/pull/2298))
  - Fix storage bucket listing sample in README.md
    ([\#2301](https://github.com/googleapis/google-cloud-java/issues/2301))
  - Fix typo in storage README.md s/while/for
  - Describing services in package-info files
    ([\#2312](https://github.com/googleapis/google-cloud-java/pull/2312))
  - Updating and expanding explanation of supported platforms
    ([\#2314](https://github.com/googleapis/google-cloud-java/pull/2314))
  - Add documentation about how google-cloud-pom can be used as BOM
    ([\#2318](https://github.com/googleapis/google-cloud-java/pull/2318))
  - Clarify that AppEngine SDK is not required for Flex and Standard J8
    ([\#2264](https://github.com/googleapis/google-cloud-java/pull/2264))
  - README : Project ID helper
    ([\#2134](https://github.com/googleapis/google-cloud-java/pull/2134))
  - Clarify usage of LocalStorageHelper, explicitly specify which
    operations are supported and which are not
    ([\#2334](https://github.com/googleapis/google-cloud-java/pull/2334))
  - Add missing READMEs
    ([\#2338](https://github.com/googleapis/google-cloud-java/pull/2338))
  - Moving API-specific sections out of main README into API-specific
    READMEs
    ([\#2336](https://github.com/googleapis/google-cloud-java/pull/2336),
    [\#2337](https://github.com/googleapis/google-cloud-java/pull/2337),
    [\#2346](https://github.com/googleapis/google-cloud-java/pull/2346),
    [\#2345](https://github.com/googleapis/google-cloud-java/pull/2345),
    [\#2350](https://github.com/googleapis/google-cloud-java/pull/2350),
    [\#2352](https://github.com/googleapis/google-cloud-java/pull/2352),
    [\#2354](https://github.com/googleapis/google-cloud-java/pull/2354))
  - README link cleanup
    ([\#2355](https://github.com/googleapis/google-cloud-java/pull/2355))

## Testing-only

  - Ignore analyze\* Tests
    ([\#2327](https://github.com/googleapis/google-cloud-java/pull/2327))
  - Adding BigQuery integration test for query dry runs
    ([\#2328](https://github.com/googleapis/google-cloud-java/pull/2328))
  - Travis config changes - retaining Precise, removing oraclejdk7
    ([\#2325](https://github.com/googleapis/google-cloud-java/pull/2325))
  - Disabling failing integration test
    ([\#2360](https://github.com/googleapis/google-cloud-java/pull/2360))
  - Update sink IT: expecting exception when sink doesn't exist
    ([\#2362](https://github.com/googleapis/google-cloud-java/pull/2362))

# v0.22.0

Add Speech Time Stamp feature (the new 'WordInfo' structure)

# v0.21.1

  - pubsub: correct emulator sample
    ([\#2254](https://github.com/googleapis/google-cloud-java/pull/2254))

## Dependencies

  - use objenesis 2.6
    ([\#2252](https://github.com/googleapis/google-cloud-java/pull/2252))
  - Unify proto-google-cloud-\* and grpc-google-cloud-\* dependencies,
    bump proto/grpc dependency to 0.1.14.
  - Fixing dependency problems for consumers of google-cloud-java
    ([\#2284](https://github.com/googleapis/google-cloud-java/pull/2284))

## Translate

  - support 'format' option for google translate api
    ([\#2253](https://github.com/googleapis/google-cloud-java/pull/2253))

## Storage

  - Add user project options for requester pays flag
    ([\#2260](https://github.com/googleapis/google-cloud-java/pull/2260))
    *Alpha feature (behind whitelist)*

## Logging

  - Adding `@BetaApi` to particular exception constructors
    ([\#2286](https://github.com/googleapis/google-cloud-java/pull/2286))

## Auto-generated clients

  - Refactoring to allow multiple transports in GAPIC clients
    ([\#2156](https://github.com/googleapis/google-cloud-java/pull/2156))
    *widespread breaking change*
      - Not affected:
          - Non-advanced calls to API methods (i.e. not using
            \*Callable() methods)
          - Trivial instantiation of clients
      - Affected:
          - Catching exceptions that are thrown
          - Customized instantiation of clients
          - Advanced calls to API methods (i.e. using \*Callable()
            methods)
      - Other notes:
          - This change adds \*Stub classes for every API, which allows
            advanced calls to every API method for an API whether or not
            they are exposed on \*Client classes (particularly relevant
            for Pub/Sub)

# v0.21.0

Declare General Availability for Translation API client.

# v0.20.3

  - cache library version

#### Datastore

  - fix BaseKey builder issue

#### Auth

  - Update Travis Secure variable for API key integration test
  - Fix Travis setup for API key integration test

#### Dependency

  - Make guava dependency consistent
  - Update java version doc

#### DLP

  - add DLP gap

#### ErrorReporting

  - Add README

#### Example

  - add snippets for DatabaseClient
  - fix ApiFuture Path

#### Logging

  - fix ConcurrentModificationException when flushing async log messages

#### NIO

  - Mark AutoService as optional and update to latest version

#### Storage

  - add labels to BucketInfo
  - Add setDefaultCloudStorageConfiguration
  - Add nullable annotations, enable test
  - Add requester pays field to BucketInfo

#### Translate

  - Polish Translate docs
  - Make Translate auth documentation clear and consistent

# v0.20.2

  - gRPC 1.2.0 -\> 1.4.0
  - Protocol Buffer: 3.2.0 -\> 3.3.0

## Pubsub

  - Reduce number of calls to `GetSubscription` when creating new
    `Subscribers`
    ([\#2127](https://github.com/googleapis/google-cloud-java/pull/2127))

## Storage

  - Avoid infinite loop while walking directories
    ([\#2124](https://github.com/googleapis/google-cloud-java/pull/2124))

## Translation

  - Discourage the use of API Key
    ([\#2147](https://github.com/googleapis/google-cloud-java/pull/2147))

## All autogenerated clients

  - New LRO implementation
    ([\#2164](https://github.com/googleapis/google-cloud-java/pull/2164))

# v0.20.1

  - Convert all BigQuery deserialized enum types to StringEnumValue
    ([\#2128](https://github.com/googleapis/google-cloud-java/pull/2128))
    *minor breaking change*

## Compute

  - Convert all Compute deserialized enum types to StringEnumValue
    ([\#2136](https://github.com/googleapis/google-cloud-java/pull/2136))
    *minor breaking change*

## DNS

  - Convert all DNS deserialized enum types to StringEnumValue
    ([\#2137](https://github.com/googleapis/google-cloud-java/pull/2137))
    *minor breaking change*

## Logging

  - Logging logback appender : Class loader fix for custom enhancers
    ([\#2130](https://github.com/googleapis/google-cloud-java/pull/2130))

## Pub/Sub (Now beta\!)

  - pubsub: make poll wait for messages
    ([\#2112](https://github.com/googleapis/google-cloud-java/pull/2112))
  - make `Subscriber.stopAsync` actually stop pulling more messages
    ([\#2113](https://github.com/googleapis/google-cloud-java/pull/2113))
  - remove `Publisher`'s flow-control
    ([\#2102](https://github.com/googleapis/google-cloud-java/pull/2102))
    *breaking change*
      - We feel that our design could use improvement, and we'd rather
        remove it now, early on, rather than have many clients depend on
        a flawed client surface.
  - pubsub: start subscriber connections quickly again
    ([\#2104](https://github.com/googleapis/google-cloud-java/pull/2104))
  - Switching PubSub from alpha to beta
    ([\#2121](https://github.com/googleapis/google-cloud-java/pull/2121))

## Resource Manager

  - Convert all Resource Manager deserialized enum types to
    StringEnumValue
    ([\#2138](https://github.com/googleapis/google-cloud-java/pull/2138))
    *minor breaking change*

## Storage

  - Add getter docs for service objects
    ([\#2129](https://github.com/googleapis/google-cloud-java/pull/2129))

## Spanner

  - Cloud Spanner: Make Spanner value classes serializable
    ([\#2040](https://github.com/googleapis/google-cloud-java/pull/2040))

## All auto-generated clients

  - regenerate from toolkit
    ([\#2116](https://github.com/googleapis/google-cloud-java/pull/2116))
      - This moves credentials to the root settings level instead of
        living inside channel settings
  - Removing .spi from generated package names
    ([\#2135](https://github.com/googleapis/google-cloud-java/pull/2135))
    *widespread breaking change*

## Tests

  - fix wrong logging filter format, which causes 502 error
    ([\#2145](https://github.com/googleapis/google-cloud-java/pull/2145))

## Internal

  - Update release instructions and scripts
    ([\#2120](https://github.com/googleapis/google-cloud-java/pull/2120))
  - verify.sh: make verify more debug-friendly
    ([\#2133](https://github.com/googleapis/google-cloud-java/pull/2133))
  - update\_version.sh: make maven run in batch mode
    ([\#2132](https://github.com/googleapis/google-cloud-java/pull/2132))

# v0.20.0

  - Add Logback support for google-cloud-logging
    ([\#2045](https://github.com/googleapis/google-cloud-java/pull/2045))
  - Make NIO retry more aggressive
    ([\#2083](https://github.com/googleapis/google-cloud-java/pull/2083))

## BigQuery

  - Expose null marker in load configuration
    ([\#2073](https://github.com/googleapis/google-cloud-java/pull/2073))
  - Expose maximum billing tier in job configuration
    ([\#2044](https://github.com/googleapis/google-cloud-java/pull/2044))
  - Expose labels in Dataset
    ([\#1990](https://github.com/googleapis/google-cloud-java/pull/1990))

## Pub/Sub

  - Add setCredentialsProvider to Publisher and Subscriber builders
    ([\#2087](https://github.com/googleapis/google-cloud-java/pull/2087),
    [\#2088](https://github.com/googleapis/google-cloud-java/pull/2088))
  - Move polling task to system executor
    ([\#2079](https://github.com/googleapis/google-cloud-java/pull/2079))
  - Make minor updates to documentation/samples
    ([\#2074](https://github.com/googleapis/google-cloud-java/pull/2074),
    [\#2075](https://github.com/googleapis/google-cloud-java/pull/2075),
    [\#2078](https://github.com/googleapis/google-cloud-java/pull/2078))

## Translation

  - Make minor updates to documentation/samples
    ([\#2097](https://github.com/googleapis/google-cloud-java/pull/2097),
    [\#1782](https://github.com/googleapis/google-cloud-java/issues/1782))

## Spanner

  - Make minor updates to documentation
    ([\#2095](https://github.com/googleapis/google-cloud-java/pull/2095))

## Dependencies

  - Bump version of google-auth-library to 0.7.0, including:
      - Retry HTTP failures in access token refresh for service account
        credentials
        ([\#1545](https://github.com/googleapis/google-cloud-java/issues/1545))
  - Bump version of gax to 1.3.0, including:
      - Move credential provider up from channel provider to client
        settings
        ([\#2034](https://github.com/googleapis/google-cloud-java/issues/2034))

# v0.19.0

  - Fix fake storage extend
    ([\#1935](https://github.com/googleapis/google-cloud-java/pull/1935))

## Datastore

  - Fix Datastore - call to setNamespace fails under certain Locales
    ([\#2037](https://github.com/googleapis/google-cloud-java/pull/2037))

## Pub/Sub

  - Pubsub snippets minor updates
    ([\#2046](https://github.com/googleapis/google-cloud-java/pull/2046))
  - make Polling work with Long element count
    ([\#2047](https://github.com/googleapis/google-cloud-java/pull/2047))
  - standardize pubsub doc tags
    ([\#2051](https://github.com/googleapis/google-cloud-java/pull/2051))
  - start connections slowly
    ([\#2055](https://github.com/googleapis/google-cloud-java/pull/2055))
  - add-max-retry-property-support
    ([\#2062](https://github.com/googleapis/google-cloud-java/pull/2062))
  - add default flow control
    ([\#2054](https://github.com/googleapis/google-cloud-java/pull/2054))

## Spanner

  - Removed an unused import
    ([\#2052](https://github.com/googleapis/google-cloud-java/pull/2052))
  - Enhance session pool behavior
    ([\#2026](https://github.com/googleapis/google-cloud-java/pull/2026))
    *breaking change*

## Storage

  - Remove project id requirement for creating a GCS client.
    ([\#2038](https://github.com/googleapis/google-cloud-java/pull/2038))

## Video Intelligence

  - Add video intelligence
    ([\#2067](https://github.com/googleapis/google-cloud-java/pull/2067))

## General documentation

  - adding note for spring boot with tc
    ([\#2053](https://github.com/googleapis/google-cloud-java/pull/2053))

## Dependencies

  - bump version of api-common to 1.1.0
    ([\#2048](https://github.com/googleapis/google-cloud-java/pull/2048))

## Core

  - Change Timestamp to not use jodatime classes for parsing/formatting
    ([\#2059](https://github.com/googleapis/google-cloud-java/pull/2059))

# v0.18.0

  - pubsub: delete Subscriber.Builder::setCredentials
    ([\#1975](https://github.com/googleapis/google-cloud-java/pull/1975))
    *breaking change* (to broken method)
  - (Documentation) Fixing doc on Publisher/Subscriber about credentials
    ([\#2019](https://github.com/googleapis/google-cloud-java/pull/2019))
  - (Documentation) Update README.md
    ([\#2015](https://github.com/googleapis/google-cloud-java/pull/2015))
    (fixing PubSub code sample)
  - make PollingSubscriberConnection less chatty
    ([\#2014](https://github.com/googleapis/google-cloud-java/pull/2014))
  - (Documentation) Pubsub snippets
    ([\#2023](https://github.com/googleapis/google-cloud-java/pull/2023))
  - (Documentation) Pubsub doc tag fix
    ([\#2027](https://github.com/googleapis/google-cloud-java/pull/2027))

## Logging

  - Fix : JUL logging on Flex
    ([\#2011](https://github.com/googleapis/google-cloud-java/pull/2011))
  - `TraceLoggingEnhancer`, `MonitoredResourceUtil` public methods
    reverted to 1.0.0 surface.
    ([\#2032](https://github.com/googleapis/google-cloud-java/pull/2032))

## Storage

  - (Documentation) \[Storage\] Bucket-level IAM Samples
    ([\#2008](https://github.com/googleapis/google-cloud-java/pull/2008))

## Dependencies

  - datastore: force import grpc-google-common-protos:0.1.9
    ([\#2029](https://github.com/googleapis/google-cloud-java/pull/2029))

## General Documentation

  - README Update (declaring GA)
    ([\#2007](https://github.com/googleapis/google-cloud-java/pull/2007))
  - Fix missing READMEs
    ([\#2017](https://github.com/googleapis/google-cloud-java/pull/2017))
  - Update doc generation
    ([\#2025](https://github.com/googleapis/google-cloud-java/pull/2025))

## Internal (repo management)

  - update\_versions.sh script fix
    ([\#2005](https://github.com/googleapis/google-cloud-java/pull/2005))

# v0.17.2

This means no more breaking changes for classes/interfaces not marked
`@BetaApi` or `@InternalApi` in google-cloud-datastore,
google-cloud-storage, or google-cloud-logging. This also pulls in 1.0.0
releases of gax and api-common.

## Logging

  - bug fix on duplicate label
    ([\#1995](https://github.com/googleapis/google-cloud-java/pull/1995))

## Storage

  - Expose LocalStorageHelper for storage testing
    ([\#1993](https://github.com/googleapis/google-cloud-java/pull/1993))

## Dependencies

  - Bumping api-common, gax to 1.0.0
    ([\#2001](https://github.com/googleapis/google-cloud-java/pull/2001))
  - Versioning cleanup:
    ([\#2002](https://github.com/googleapis/google-cloud-java/pull/2002))

## Documentation

  - Add minimum documentation for GAPIC-only clients
    ([\#1983](https://github.com/googleapis/google-cloud-java/pull/1983))
  - Adding qualifications on usage of semantic versioning
    ([\#1998](https://github.com/googleapis/google-cloud-java/pull/1998))

## Other

  - Fix build setup of project.properties
    ([\#2003](https://github.com/googleapis/google-cloud-java/pull/2003))

# v0.17.1

  - Update site creation script
    ([\#1980](https://github.com/googleapis/google-cloud-java/pull/1980))
    (allows coverage reports)

## Documentation

  - add javadocs for gql binding methods
    ([\#1991](https://github.com/googleapis/google-cloud-java/pull/1991))

## Surface changes

  - make one Tuple class aross all the projects
    ([\#1992](https://github.com/googleapis/google-cloud-java/pull/1992))
    *minor breaking change*

# v0.17.0

  - Reducing visibility of some things, adding @InternalApi
    ([\#1979](https://github.com/googleapis/google-cloud-java/pull/1979))
    *breaking change that shouldn't affect most consumers*
  - Migrating from Joda Duration/Instant to ThreeTenBP
    ([\#1985](https://github.com/googleapis/google-cloud-java/pull/1985))
    *Widespread breaking change*

## Dependencies

  - Update proto packages
    ([\#1984](https://github.com/googleapis/google-cloud-java/pull/1984))

## Logging

  - fix credentials NPE bug
    ([\#1961](https://github.com/googleapis/google-cloud-java/pull/1961))

## Documentation

  - update datastore snippet in front page
    ([\#1976](https://github.com/googleapis/google-cloud-java/pull/1976))
  - adding supported/unsupported platforms to README
    ([\#1982](https://github.com/googleapis/google-cloud-java/pull/1982))

# v0.16.0

  - Splitting core into core, core-http, and core-grpc
    ([\#1968](https://github.com/googleapis/google-cloud-java/pull/1968))
    *breaking change*

# v0.15.0

  - Make Cloud Spanner Mutations serializable
    ([\#1952](https://github.com/googleapis/google-cloud-java/pull/1952))

## Dependencies

  - Remove guava from surface
    ([\#1960](https://github.com/googleapis/google-cloud-java/pull/1960))
  - Update developer list
    ([\#1954](https://github.com/googleapis/google-cloud-java/pull/1954))
  - Converting NettyChannelBuilder reference to ManagedChannelBuilder
    ([\#1951](https://github.com/googleapis/google-cloud-java/pull/1951))
  - Removing grpc-all exclusions in pom.xml
    ([\#1942](https://github.com/googleapis/google-cloud-java/pull/1942))
  - Adding dependency convergence
    ([\#1943](https://github.com/googleapis/google-cloud-java/pull/1943))

## Pub/Sub

  - Fixing executor and flow control issues in subscriber
    ([\#1915](https://github.com/googleapis/google-cloud-java/pull/1915))

## Core

  - Make SSLHandShakeException retryable
    ([\#1938](https://github.com/googleapis/google-cloud-java/pull/1938))
  - Creating an expandable enum type, converting StorageClass
    ([\#1937](https://github.com/googleapis/google-cloud-java/pull/1937))
  - Marking some core types @BetaApi and @InternalApi
    ([\#1933](https://github.com/googleapis/google-cloud-java/pull/1933))
  - Removing timeout settings that are set but never used
    ([\#1934](https://github.com/googleapis/google-cloud-java/pull/1934))

## Logging

  - Converting Logging deserialized enum types to StringEnumValue
    ([\#1945](https://github.com/googleapis/google-cloud-java/pull/1945))

## Datastore

  - Converting all Datastore deserialized enum types to StringEnumValue
    ([\#1941](https://github.com/googleapis/google-cloud-java/pull/1941))
  - Retry datastore transactions
    ([\#1242](https://github.com/googleapis/google-cloud-java/issues/1242))
    ([\#1932](https://github.com/googleapis/google-cloud-java/pull/1932))
  - Mark LocalDatastoreHelper as internal
    ([\#1931](https://github.com/googleapis/google-cloud-java/pull/1931))
  - Update testing instructions for Datastore.
    ([\#1930](https://github.com/googleapis/google-cloud-java/pull/1930))
  - Force query results to become strongly consistent
    ([\#1806](https://github.com/googleapis/google-cloud-java/pull/1806))
  - Removing deprecated Value.meaning methods that were missed
    ([\#1921](https://github.com/googleapis/google-cloud-java/pull/1921))

## Storage

  - Converting all Storage deserialized enum types to StringEnumValue
    ([\#1940](https://github.com/googleapis/google-cloud-java/pull/1940))

## Translate

  - Fixing google-cloud-translate version in README
    ([\#1926](https://github.com/googleapis/google-cloud-java/pull/1926))

## Misc

  - Improve update\_versions.sh script
    ([\#1964](https://github.com/googleapis/google-cloud-java/pull/1964))
  - Regenerating SPI: method descriptors, removing usage of deprecated
    ([\#1946](https://github.com/googleapis/google-cloud-java/pull/1946))
  - Setup appveyor
    ([\#1949](https://github.com/googleapis/google-cloud-java/pull/1949))
  - Replace DateTime with Timestamp
    ([\#1947](https://github.com/googleapis/google-cloud-java/pull/1947))
  - Changes required for updated api-common
    ([\#1927](https://github.com/googleapis/google-cloud-java/pull/1927))
  - Update README.md version update script
    ([\#1929](https://github.com/googleapis/google-cloud-java/pull/1929))
  - Update release scripts to handle 1.x and 0.x versions living
    together
    ([\#1922](https://github.com/googleapis/google-cloud-java/pull/1922))

## Examples

  - Logging refactor of JUL + monitored resource construction
    ([\#1847](https://github.com/googleapis/google-cloud-java/pull/1847))

# v0.14.0

  - Update version of google-auth-java to 0.6.1
    ([\#1888](https://github.com/googleapis/google-cloud-java/pull/1888))
    - fix for auth token refresh failures.
  - Update org.json to latest version
    ([\#1904](https://github.com/googleapis/google-cloud-java/pull/1904))
  - bump grpc dependency to 1.2.0
    ([\#1902](https://github.com/googleapis/google-cloud-java/pull/1902))
    - also bumps protobuf to 3.2.0
  - Updating tcnative version to match grpc version
    ([\#1912](https://github.com/googleapis/google-cloud-java/pull/1912))

## App engine Flex

  - Don't use `UrlFetchTransport` in App Engine Flex environment
    ([\#1893](https://github.com/googleapis/google-cloud-java/pull/1893))

## Pub/Sub

  - Max ack extension
    ([\#1898](https://github.com/googleapis/google-cloud-java/pull/1898))
  - Change AckReplyConsumer to expose individual methods for replying
    ([\#1899](https://github.com/googleapis/google-cloud-java/pull/1899))
    *breaking change*
  - make Subscriber use ChannelProvider
    ([\#1911](https://github.com/googleapis/google-cloud-java/pull/1911))
    *breaking change*

## Storage

  - Add Identity Access Management (IAM) to the Storage API
    ([\#1812](https://github.com/googleapis/google-cloud-java/pull/1812))

## Other

  - Add annotations to specify GCP launch stage
    ([\#1889](https://github.com/googleapis/google-cloud-java/pull/1889))
  - Update page
    ([\#1894](https://github.com/googleapis/google-cloud-java/pull/1894))
    *widespread breaking change*
  - Make project.properties path independent per API
    ([\#1863](https://github.com/googleapis/google-cloud-java/pull/1863))
    - http header update
  - Refresh gapic clients
    ([\#1917](https://github.com/googleapis/google-cloud-java/pull/1917))
    - http header update

# v0.13.0

Natural Language v1beta2 Release
([\#1878](https://github.com/googleapis/google-cloud-java/pull/1878))

## Core

Remove last use of setPort/setServiceAddress
([\#1880](https://github.com/googleapis/google-cloud-java/pull/1880))  
Regenerating SPI: use setEndpoint
([\#1879](https://github.com/googleapis/google-cloud-java/pull/1879))

## Pub/Sub

Rename newBuilder to defaultBuilder
([\#1873](https://github.com/googleapis/google-cloud-java/pull/1873))  
Make deprecated methods package-private
([\#1861](https://github.com/googleapis/google-cloud-java/pull/1861))

## Spanner

Replace a constant of type Set with ImmutableSet
([\#1876](https://github.com/googleapis/google-cloud-java/pull/1876))

## Samples

New code snippet for push subscription + cleanup of deprecated snippets
([\#1875](https://github.com/googleapis/google-cloud-java/pull/1875))

## Testing

GAE (Flex\_Java/Flex\_Custom/Flex\_Compat/Std\_Java8), GCE, GKE testing
app for gcj
([\#1859](https://github.com/googleapis/google-cloud-java/pull/1859))

# v0.12.0

  - Add Speech V1
    ([\#1858](https://github.com/googleapis/google-cloud-java/pull/1858))  
    The Speech v1 library is not backwards-compatible with v1beta1:
      - The` LanguageCode` parameter is no longer optional anywhere. It
        must be explicitly specified, and does not default to 'en-US'.
      - The `syncRecognize` method has been renamed to recognize on
        every class where it appears.
      - The `asyncRecognize` method has been renamed to
        `longRunningRecognizeAsync` on every class where it appears.
      - The `sampleRate` parameter and property has been renamed to
        `sampleRateHertz` everywhere it appears.

## Logging

  - Override the default channel provider
    ([\#1820](https://github.com/googleapis/google-cloud-java/pull/1820))

## Translation

  - Rename Translate docs to Translation
    ([\#1867](https://github.com/googleapis/google-cloud-java/pull/1867))

# v0.11.2

  - SPI: Adding @ExperimentalApi back to logging client classes
    ([\#1844](https://github.com/googleapis/google-cloud-java/pull/1844))

## Natural Language

  - Bumping NL, Translate to beta
    ([\#1848](https://github.com/googleapis/google-cloud-java/pull/1848))

## PubSub

  - pubsub: make Subscriber use ApiService
    ([\#1824](https://github.com/googleapis/google-cloud-java/pull/1824))

## Translate

  - Bumping NL, Translate to beta
    ([\#1848](https://github.com/googleapis/google-cloud-java/pull/1848))

# v0.11.1

  - Remove ServiceRpcT parameterization
    ([\#1759](https://github.com/googleapis/google-cloud-java/pull/1759))
  - Narrow dependencies to avoid servlet-api
    ([\#1766](https://github.com/googleapis/google-cloud-java/pull/1766))
  - Reconcile RetrySettings & Clock (google-cloud-java part)
    ([\#1738](https://github.com/googleapis/google-cloud-java/pull/1738))
  - Renames from GAX: Function -\> ApiFunction, RpcStreamObserver -\>
    ApiStreamObserver
    ([\#1787](https://github.com/googleapis/google-cloud-java/pull/1787))
  - Add x-goog-api-client support to HTTP1.1
    ([\#1790](https://github.com/googleapis/google-cloud-java/pull/1790))

## BigQuery

  - Add DatastoreBackupOptions class for BigQuery
    ([\#1757](https://github.com/googleapis/google-cloud-java/pull/1757))
  - Implement BigQuery: LoadJobConfiguration to support
    schemaUpdateOptions
    ([\#1647](https://github.com/googleapis/google-cloud-java/pull/1647))
  - Add support for experimental schema autodetection feature within
    BigQuery
    ([\#1648](https://github.com/googleapis/google-cloud-java/pull/1648))

## Datastore

  - Fix allocateId so it cannot be called on complete keys
    ([\#1783](https://github.com/googleapis/google-cloud-java/pull/1783))

## Logging

  - Remove handler's buffer
    ([\#1796](https://github.com/googleapis/google-cloud-java/pull/1796))
  - Make flush wait for writes
    ([\#1815](https://github.com/googleapis/google-cloud-java/pull/1815))
  - use new PartitionKey implementation
    ([\#1841](https://github.com/googleapis/google-cloud-java/pull/1841))

## PubSub

  - Change the AckReplyConsumer interface
    ([\#1758](https://github.com/googleapis/google-cloud-java/pull/1758))
  - Rename bundling to batching
    ([\#1775](https://github.com/googleapis/google-cloud-java/pull/1775))
  - Delete deprecated code
    ([\#1771](https://github.com/googleapis/google-cloud-java/pull/1771))
  - Update 'PubSubExample' to latest api
    ([\#1808](https://github.com/googleapis/google-cloud-java/pull/1808))
  - Pubsub SPI update
    ([\#1818](https://github.com/googleapis/google-cloud-java/pull/1818))
  - Update spi classes
    ([\#1817](https://github.com/googleapis/google-cloud-java/pull/1817))
  - use new PartitionKey implementation
    ([\#1841](https://github.com/googleapis/google-cloud-java/pull/1841))

## Spanner

  - Move some classes from spanner to core
    ([\#1770](https://github.com/googleapis/google-cloud-java/pull/1770))
  - Change a test to not fail if the ordering of map changed.
    ([\#1793](https://github.com/googleapis/google-cloud-java/pull/1793))

## Storage

  - Bump the storage API version.
    ([\#1799](https://github.com/googleapis/google-cloud-java/pull/1799))
  - Add DURABLE\_REDUCED\_AVAILABILITY storage class
    ([\#1834](https://github.com/googleapis/google-cloud-java/pull/1834))

## Contrib

  - Rename shaded.cloud-nio to shaded.cloud\_nio
    ([\#1767](https://github.com/googleapis/google-cloud-java/pull/1767))

# v0.11.0

  - Added support for per-object storage classes
    ([\#1670](https://github.com/googleapis/google-cloud-java/pull/1670))
  - Add helper for Google Cloud Storage IAM roles
    ([\#1724](https://github.com/googleapis/google-cloud-java/pull/1724))

## Logging

  - Switch from `Future` to `ApiFuture`
    ([\#1706](https://github.com/googleapis/google-cloud-java/pull/1706))
  - Renamed generated client classes
    ([\#1708](https://github.com/googleapis/google-cloud-java/pull/1708))
  - Reduce memory consumption
    ([\#1754](https://github.com/googleapis/google-cloud-java/pull/1754))
  - Add async/sync setting to logging handler
    ([\#1716](https://github.com/googleapis/google-cloud-java/pull/1716))

## Pubsub

  - Switch from `Future` to `ApiFuture`
    ([\#1709](https://github.com/googleapis/google-cloud-java/pull/1709))
  - Reduce generated logs
    ([\#1749](https://github.com/googleapis/google-cloud-java/pull/1749),
    [\#1748](https://github.com/googleapis/google-cloud-java/pull/1748))
  - Fix potential deadlocks in startConnections
    ([\#1674](https://github.com/googleapis/google-cloud-java/pull/1674))

## Bigquery

  - Add support of DATE, TIME, DATETIME for Field
    ([\#1755](https://github.com/googleapis/google-cloud-java/pull/1755))

## NIO

  - Add convenience method for files with spaces
    ([\#1463](https://github.com/googleapis/google-cloud-java/pull/1463))
  - Add option for re-opening the channel to retry some errors
    ([\#1715](https://github.com/googleapis/google-cloud-java/pull/1715))

## Updates

  - Rename RpcFuture to ApiFuture
    ([\#1690](https://github.com/googleapis/google-cloud-java/pull/1690))
  - Add flow control to bundling
    ([\#1687](https://github.com/googleapis/google-cloud-java/pull/1687))
  - Improved bundling performance
    ([\#1721](https://github.com/googleapis/google-cloud-java/pull/1721))
  - Remove deprecated methods
    ([\#1678](https://github.com/googleapis/google-cloud-java/pull/1678),
    [\#1707](https://github.com/googleapis/google-cloud-java/pull/1707),
    [\#1753](https://github.com/googleapis/google-cloud-java/pull/1753))
  - Remove transport from ServiceOptions hierarchy
    ([\#1723](https://github.com/googleapis/google-cloud-java/pull/1723))
  - Add project role identities to the Identity helper
    ([\#1718](https://github.com/googleapis/google-cloud-java/pull/1718))

## Samples/docs

  - Miscellaneous improvements

# v0.10.0

  - Cloud Vision API v1.1
    ([\#1693](https://github.com/googleapis/google-cloud-java/pull/1693))

## Fixes:

  - Retry logic on HttpResponseException
    ([\#1677](https://github.com/googleapis/google-cloud-java/pull/1677))
  - PubSub: make subscriber connections split requests properly
    ([\#1675](https://github.com/googleapis/google-cloud-java/pull/1675))
  - Properly stop MessageDispatcher if Subscriber fails
    ([\#1665](https://github.com/googleapis/google-cloud-java/pull/1665))
  - Directory listing with leading slash
    ([\#1644](https://github.com/googleapis/google-cloud-java/pull/1644))

## Updates

  - Update gapic clients with latest toolkit (http headers updated)
    ([\#1684](https://github.com/googleapis/google-cloud-java/pull/1684))
  - Make class com.google.cloud.ServiceOptions$Builder public
    ([\#1672](https://github.com/googleapis/google-cloud-java/pull/1672))
  - Add test for Publisher and Subscriber snippets
    ([\#1658](https://github.com/googleapis/google-cloud-java/pull/1658))
  - Expose static method to get default project ID
    ([\#1380](https://github.com/googleapis/google-cloud-java/pull/1380))

## Samples/docs

  - PublisherClient/SubscriberClient snippets
    ([\#1663](https://github.com/googleapis/google-cloud-java/pull/1663))
  - PubSub: update README to use high perf clients
    ([\#1671](https://github.com/googleapis/google-cloud-java/pull/1671))
  - PubSub: fix typo in example
    ([\#1649](https://github.com/googleapis/google-cloud-java/pull/1649))

# v0.9.4

  - pubsub: start with polling by default
    ([\#1625](https://github.com/googleapis/google-cloud-java/pull/1625))
      - Patches over a server issue where the wrong error code is being
        returned for an unimplemented method.

## Moves/renames

  - move LocalPubSubHelper into deprecated
    ([\#1633](https://github.com/googleapis/google-cloud-java/pull/1633))

## Runtime updates

  - Update client name in header for Veneer layer
    ([\#1638](https://github.com/googleapis/google-cloud-java/pull/1638))
  - Updating GAX to 0.1.2 (for header changes)
    ([\#1640](https://github.com/googleapis/google-cloud-java/pull/1640))

## Samples/docs

  - pubsub: new publish snippet
    ([\#1608](https://github.com/googleapis/google-cloud-java/pull/1608))

# v0.9.3

`google-cloud-spanner` has been added. Find out more about Cloud Spanner
at
<https://cloudplatform.googleblog.com/2017/02/introducing-Cloud-Spanner-a-global-database-service-for-mission-critical-applications.html>
.

# v0.9.2

The Pub/Sub client has been completely rewritten to enable high
throughput. The handwritten layer on top of the SPI layer has been
deprecated, and two handwritten classes have been added in the SPI
layer, `Publisher` and `Subscriber`, for publishing and subscribing.
(Note for those concerned: synchronous pull is still possible in
`SubscriberClient`.) The handwritten layer was deprecated because the
SPI layer can be kept up to date more easily with new service features.
Since the change is so disruptive, we have retained the deprecated
classes, but moved them under `com.google.cloud.pubsub.deprecated`. They
will be removed before the Pub/Sub client goes to GA.

## Logging

  - add zone to GAE Flex logging enhancer
    ([\#1589](https://github.com/googleapis/google-cloud-java/pull/1589))
  - fix(logging): Make LoggingHandler.Enhancer interface public
    ([\#1607](https://github.com/googleapis/google-cloud-java/pull/1607))

## SPI layer changes

  - SPI layer: Regenerating with RpcStreamObserver
    ([\#1611](https://github.com/googleapis/google-cloud-java/pull/1611))
      - This change is a prerequisite to enabling the shading of Guava

## Docs

  - Javadocs: adding links to external types
    ([\#1600](https://github.com/googleapis/google-cloud-java/pull/1600))
  - fix a typo in README.md
    ([\#1604](https://github.com/googleapis/google-cloud-java/pull/1604))

# v0.9.0

  - (Storage) Allow path in URIs passed to newFileSystem
    ([\#1470](https://github.com/googleapis/google-cloud-java/pull/1470))
  - (Storage) Add a PathMatcher for CloudStorageFileSystem
    ([\#1469](https://github.com/googleapis/google-cloud-java/pull/1469))
  - (Logging) Preventing logging re-entrance at FINE level
    ([\#1523](https://github.com/googleapis/google-cloud-java/pull/1523))
  - (Logging) Set timestamp from LogRecord
    ([\#1533](https://github.com/googleapis/google-cloud-java/pull/1533))
  - (Logging) Initialize the default MonitoredResource from a GAE
    environment
    ([\#1535](https://github.com/googleapis/google-cloud-java/pull/1535))
  - (BigQuery) BigQuery: Add support to FormatOptions for AVRO
    ([\#1576](https://github.com/googleapis/google-cloud-java/pull/1576))

## SPI layer changes

  - use RpcFuture and remove old BundlingSettings
    ([\#1572](https://github.com/googleapis/google-cloud-java/pull/1572))
  - fix DefaultLoggingRpc
    ([\#1584](https://github.com/googleapis/google-cloud-java/pull/1584))

# v0.8.3

The dependency on grpc was bumped from 1.0.1 to 1.0.3.
([\#1504](https://github.com/googleapis/google-cloud-java/pull/1504))

## Interface changes

  - SPI layer: Converted Error Reporting, Monitoring, and Pub/Sub to use
    resource name types, and removed formatX/parseX methods
    ([\#1454](https://github.com/googleapis/google-cloud-java/pull/1454))

## Test improvements

  - Fixed more races in pubsub tests
    ([\#1473](https://github.com/googleapis/google-cloud-java/pull/1473))

# v0.8.1

In this release, clients for four APIs are moving to beta:

  - Google Cloud BigQuery
  - Stackdriver Logging
  - Google Cloud Datastore
  - Google Cloud Storage

Their versions will have “-beta” on the end call out that fact. All
other clients are still Alpha.

## Features

  - QueryParameter support added to BigQuery, DATE/TIME/DATETIME added
    to LegacySQLTypeName
    ([\#1451](https://github.com/googleapis/google-cloud-java/pull/1451))

## Interface changes

  - Logging api layer: using resource name classes instead of strings
    where appropriate
    ([\#1454](https://github.com/googleapis/google-cloud-java/pull/1454))

## Test improvements

Several tests were flaky on AppVeyor, so improvements were made to make
them more reliable.

  - BlockingProcessStreamReader
    ([\#1457](https://github.com/googleapis/google-cloud-java/pull/1457))
  - BigQuery integration tests
    ([\#1456](https://github.com/googleapis/google-cloud-java/pull/1456))
  - PubSub integration tests
    ([\#1453](https://github.com/googleapis/google-cloud-java/pull/1453))
  - DNS tests: removed LocalDnsHelper and its test
    ([\#1446](https://github.com/googleapis/google-cloud-java/pull/1446))

Despite that, integration tests were still failing on AppVeyor, so they
have been disabled until they can all run reliably - tracking issue:
[\#1429](https://github.com/googleapis/google-cloud-java/issues/1429)

## Documentation, Snippets

  - Various snippet updates -
    ([\#1399](https://github.com/googleapis/google-cloud-java/pull/1399)),
    ([\#1400](https://github.com/googleapis/google-cloud-java/pull/1400))

# v0.8.0

  - SPI classes ending in `Api` have been renamed so that they end in
    `Client`
    ([\#1417](https://github.com/googleapis/google-cloud-java/pull/1417))
  - Deleted the client for Natural Language v1beta1, added the client
    for Natural Language v1
    ([\#1417](https://github.com/googleapis/google-cloud-java/pull/1417))
  - PubSub SPI classes now take resource name classes instead of strings
    ([\#1403](https://github.com/googleapis/google-cloud-java/pull/1403))

## Features

  - Speech SPI layer: AsyncRecognize now returns a new `OperationFuture`
    type which enables an easier way to get the final result of the
    long-running operation.
    ([\#1419](https://github.com/googleapis/google-cloud-java/pull/1419))

## Documentation, Snippets

  - Various documentation fixes -
    ([\#1419](https://github.com/googleapis/google-cloud-java/pull/1419)),
    ([\#1415](https://github.com/googleapis/google-cloud-java/pull/1415))
  - Various snippet updates for BigQuery -
    ([\#1410](https://github.com/googleapis/google-cloud-java/pull/1410)),
    ([\#1407](https://github.com/googleapis/google-cloud-java/pull/1407)),
    ([\#1406](https://github.com/googleapis/google-cloud-java/pull/1406))

# v0.7.0

`AuthCredentials` classes have been deleted. Use classes from
[google-auth-library-java](https://github.com/google/google-auth-library-java)
for authentication.

`google-cloud` will still try to infer credentials from the environment
when no credentials are provided:

<div class="highlight highlight-source-java">

    Storage storage = StorageOptions.getDefaultInstance().getService();

</div>

You can also explicitly provide credentials. For instance, to use a JSON
credentials file try the following code:

    Storage storage = StorageOptions.newBuilder()
        .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("/path/to/my/key.json"))
        .build()
        .getService();

For more details see the [Authentication
section](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication)
of the main README.

## Features

#### PubSub

  - All `pullAsync` methods now use `returnImmediately=false` and are
    not subject to client-side timeouts
    ([\#1387](https://github.com/googleapis/google-cloud-java/pull/1387))

#### Translate

  - Add support for the
    [`TranslateOption.model(String)`](http://googlecloudplatform.github.io/google-cloud-java/0.6.0/apidocs/com/google/cloud/translate/Translate.TranslateOption.html#model%28java.lang.String%29)
    option which allows to set the language translation model used to
    translate text. This option is only available to whitelisted users
    ([\#1393](https://github.com/googleapis/google-cloud-java/pull/1393))

## Fixes

#### Storage

  - Change `BaseWriteChannel`'s `position` to `long` to fix integer
    overflow on big files
    ([\#1390](https://github.com/googleapis/google-cloud-java/pull/1390))

# v0.6.0

#### All

  - Reduce gRPC dependency footprint. In particular, some gRPC-related
    dependencies are removed from `google-cloud-core` module. Get rid of
    duplicate classes
    ([\#1365](https://github.com/googleapis/google-cloud-java/pull/1365))

#### Datastore

  - Deprecate `DatastoreOptions.Builder`'s `namespace(String)` setter in
    favor of `setNamespace(String)`, undo deprecating
    `Transaction.Response.getGeneratedKeys()`
    ([\#1358](https://github.com/googleapis/google-cloud-java/pull/1358))

#### 

  - Avoid shading `javax` package in `google-cloud-nio` shaded jar
    ([\#1362](https://github.com/googleapis/google-cloud-java/pull/1362))

# v0.5.1

  - Getters and setters with the `get` and `set` prefix have been added
    to all classes/builders. Older getters/setters (without `get/set`
    prefix) have been deprecated
  - Builder factory methods `builder()` have been deprecated, you should
    use `newBuilder()` instead
  - `defaultInstance()` factory methods have been deprecated, you should
    use `getDefaultInstance()` instead

See the following example of using `google-cloud-storage` after the
naming changes:

<div class="highlight highlight-source-java">

    Storage storage = StorageOptions.getDefaultInstance().getService();
    BlobId blobId = BlobId.of("bucket", "blob_name");
    Blob blob = storage.get(blobId);
    if (blob != null) {
      byte[] prevContent = blob.getContent();
      System.out.println(new String(prevContent, UTF_8));
      WritableByteChannel channel = blob.writer();
      channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
      channel.close();
    }

</div>

## Features

#### Datastore

  - Add support to `LocalDatastoreHelper` for more recent version of the
    Datastore emulator installed via `gcloud`
    ([\#1303](https://github.com/googleapis/google-cloud-java/pull/1303))
  - Add `reset()` method to `LocalDatastoreHelper` to clear the status
    of the Datastore emulator
    ([\#1293](https://github.com/googleapis/google-cloud-java/pull/1293))

#### PubSub

  - Add support for PubSub emulator host variable. If the
    `PUBSUB_EMULATOR_HOST` environment variable is set, the PubSub
    client uses it to locate the PubSub emulator.
    ([\#1317](https://github.com/googleapis/google-cloud-java/pull/1317))

## Fixes

#### Datastore

  - Allow `LocalDatastoreHelper` to properly cache downloaded copies of
    the Datastore emulator
    ([\#1302](https://github.com/googleapis/google-cloud-java/pull/1302))

#### Storage

  - Fix regression in `Storage.signUrl` to support blob names containing
    `/` characters
    ([\#1346](https://github.com/googleapis/google-cloud-java/issues/1346))
  - Allow `Storage.reader` to read gzip blobs in compressed chunks. This
    prevents `ReadChannel` from trying (and failing) to uncompress
    gzipped chunks
    ([\#1301](https://github.com/googleapis/google-cloud-java/pull/1301))

#### Storage NIO

  - All dependencies are now shaded in the `google-cloud-nio` shaded jar
    ([\#1327](https://github.com/googleapis/google-cloud-java/pull/1327))

# v0.5.0

#### BigQuery

  - Add `of(String)` factory method to DatasetInfo
    ([\#1275](https://github.com/googleapis/google-cloud-java/pull/1275))

<div class="highlight highlight-source-java">

    bigquery.create(DatasetInfo.of("dataset-name"));

</div>

#### Core

  - `google-cloud` now depends on `protobuf 3.0.0` and `grpc 1.0.1`
    ([\#1273](https://github.com/googleapis/google-cloud-java/pull/1273))

#### PubSub

  - Add support for IAM methods for sinks and subscriptions
    ([\#1231](https://github.com/googleapis/google-cloud-java/pull/1231))

<div class="highlight highlight-source-java">

    // Example of replacing a subscription policy
    Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    updatedPolicy = pubsub.replaceSubscriptionPolicy(subscriptionName, updatedPolicy);
    
    // Example of asynchronously replacing a topic policy
    Policy policy = pubsub.getTopicPolicy(topicName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    Future<Policy> future = pubsub.replaceTopicPolicyAsync(topicName, updatedPolicy);
    // ...
    updatedPolicy = future.get();

</div>

#### Storage

  - Add support for create/get/update/delete/list ACLs for blobs and
    buckets
    ([\#1228](https://github.com/googleapis/google-cloud-java/pull/1228))

<div class="highlight highlight-source-java">

    // Example of updating the ACL for a blob
    BlobId blobId = BlobId.of(bucketName, blobName, blobGeneration);
    Acl acl = storage.updateAcl(blobId, Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER));
    
    // Example of listing the ACL entries for a bucket
    List<Acl> acls = storage.listAcls(bucketName);
    for (Acl acl : acls) {
       // do something with ACL entry
    }

</div>

  - Add support for [customer-supplied encryption
    keys](https://cloud.google.com/storage/docs/encryption#customer-supplied)
    ([\#1236](https://github.com/googleapis/google-cloud-java/pull/1236))

<div class="highlight highlight-source-java">

    Key key = ...;
    String base64Key = ...;
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    BlobInfo blobInfo = BlobInfo.builder(bucketName, blobName).build();
    
    // Example of creating a blob with a customer-supplied encryption key (as Key object)
    storage.create(blobInfo, content, Storage.BlobTargetOption.encryptionKey(key));
    
    // Example of reading a blob with a customer-supplied decryption key (as base64 String)
    byte[] readBytes =
        storage.readAllBytes(bucketName, blobName, Storage.BlobSourceOption.decryptionKey(base64Key));

</div>

## Fixes

#### BigQuery

  - Support operations on tables/datasets/jobs in projects other than
    the one set in `BigQueryOptions`
    ([\#1217](https://github.com/googleapis/google-cloud-java/pull/1217))
  - Allow constructing a `RowToInsert` using `Map<Str, ? extends
    Object>` rather than `Map<Str, Object>`
    ([\#1259](https://github.com/googleapis/google-cloud-java/pull/1259))

#### Datastore

  - Retry `ABORTED` Datastore commits only when the commit was
    `NON_TRANSACTIONAL`
    ([\#1235](https://github.com/googleapis/google-cloud-java/pull/1235))

#### Logging

  - Remove unnecessary `MetricInfo` parameter from
    `Metric.updateAsync()`
    ([\#1221](https://github.com/googleapis/google-cloud-java/pull/1221))
  - Remove unnecessary `SinkInfo` parameter from `Sink.updateAsync()`
    ([\#1222](https://github.com/googleapis/google-cloud-java/pull/1222))
  - `Logging.deleteSink` now returns `false` on `NOT_FOUND`
    ([\#1222](https://github.com/googleapis/google-cloud-java/pull/1222))

#### Storage

  - Retry calls that open a resumable upload session in `WriteChannel`,
    when they fail with a retryable error
    ([\#1233](https://github.com/googleapis/google-cloud-java/pull/1233))
  - Fix generation of signed URLs for blobs containing spaces and other
    special chars
    ([\#1277](https://github.com/googleapis/google-cloud-java/pull/1277)
    - thanks to [@ostronom](https://github.com/ostronom))

# v0.4.0

`gcloud-java` has been deprecated and renamed to `google-cloud`.

If you are using Maven, add this to your pom.xml file

<div class="highlight highlight-text-xml">

    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud</artifactId>
      <version>0.3.0</version>
    </dependency>

</div>

If you are using Gradle, add this to your dependencies

<div class="highlight highlight-source-groovy">

    compile 'com.google.cloud:google-cloud:0.3.0'

</div>

If you are using SBT, add this to your dependencies

<div class="highlight highlight-source-scala">

    libraryDependencies += "com.google.cloud" % "google-cloud" % "0.3.0"

</div>

## `gcloud-java-<service>` renamed to `google-cloud-<service>`

Service-specific artifacts have also been renamed from
`gcloud-java-<service>` to `google-cloud-<service>`. See the following
for examples of adding `google-cloud-datastore` as a dependency:

<div class="highlight highlight-text-xml">

    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-datastore</artifactId>
      <version>0.3.0</version>
    </dependency>

</div>

If you are using Gradle, add this to your dependencies

<div class="highlight highlight-source-groovy">

    compile 'com.google.cloud:google-cloud-datastore:0.3.0'

</div>

If you are using SBT, add this to your
    dependencies

<div class="highlight highlight-source-scala">

    libraryDependencies += "com.google.cloud" % "google-cloud-datastore" % "0.3.0"

</div>

## Other changes

  - `GCLOUD_PROJECT` environment variable is now deprecated, use
    `GOOGLE_CLOUD_PROJECT` to set your default project id.
  - The project URL is now:
    <https://googlecloudplatform.github.io/google-cloud-java/>
  - The GitHub repo is now:
    <https://github.com/GoogleCloudPlatform/google-cloud-java/>

# v0.3.0

#### Datastore

  - `gcloud-java-datastore` now uses Datastore v1
    ([\#1169](https://github.com/googleapis/google-cloud-java/pull/1169))

#### Translate

  - `gcloud-java-translate`, a new client library to interact with
    Google Translate, is released and is in alpha. See the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-translate#google-cloud-java-client-for-translate-alpha)
    for more information.  
    See
    [TranslateExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/translate/TranslateExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/cloud/translate/package-summary.html)
    for `gcloud-java-translate` javadoc.  
    The following snippet shows how to detect the language of some text
    and how to translate some text.  
    Complete source code can be found
    on  
    [DetectLanguageAndTranslate.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/translate/snippets/DetectLanguageAndTranslate.java).

<div class="highlight highlight-source-java">

    import com.google.cloud.translate.Detection;
    import com.google.cloud.translate.Translate;
    import com.google.cloud.translate.Translate.TranslateOption;
    import com.google.cloud.translate.TranslateOptions;
    import com.google.cloud.translate.Translation;
    
    Translate translate = TranslateOptions.defaultInstance().service();
    
    Detection detection = translate.detect("Hola");
    String detectedLanguage = detection.language();
    
    Translation translation = translate.translate(
        "World",
        TranslateOption.sourceLanguage("en"),
        TranslateOption.targetLanguage(detectedLanguage));
    
    System.out.printf("Hola %s%n", translation.translatedText());

</div>

## Fixes

#### Core

  - `SocketException` and "insufficient data written" `IOException` are
    now retried
    ([\#1187](https://github.com/googleapis/google-cloud-java/pull/1187))

#### Storage NIO

  - Enumerating filesystems no longer fails if `gcloud-java-nio` is in
    the classpath and no credentials are available
    ([\#1189](https://github.com/googleapis/google-cloud-java/pull/1189))
  - Rename `CloudStorageFileSystemProvider.setGCloudOptions` to
    `CloudStorageFileSystemProvider.setStorageOptions`
    ([\#1189](https://github.com/googleapis/google-cloud-java/pull/1189))

# v0.2.8

## BigQuery

  - String setters for `DeprecationStatus` timestamps are removed from
    `DeprecationStatus.Builder`. Getters are still available in
    `DeprecationStatus` for legacy support
    ([\#1127](https://github.com/googleapis/google-cloud-java/pull/1127)).
  - Fix table's `StreamingBuffer` to allow `oldestEntryTime` to be
    `null`
    ([\#1141](https://github.com/googleapis/google-cloud-java/pull/1141)).
  - Add support for `useLegacySql` to `QueryRequest` and
    `QueryJobConfiguration`
    ([\#1142](https://github.com/googleapis/google-cloud-java/pull/1142)).

## Datastore

  - Fix Datastore exceptions conversion: use `getNumber()` instead of
    `ordinal()` to get `DatastoreException`'s error code
    ([\#1140](https://github.com/googleapis/google-cloud-java/pull/1140)).
  - Use HTTP transport factory, as set via `DatastoreOptions`, to
    perform service requests
    ([\#1144](https://github.com/googleapis/google-cloud-java/pull/1144)).

## Logging

  - Set `gcloud-java` user agent in `gcloud-java-logging`, as done for
    other modules
    ([\#1147](https://github.com/googleapis/google-cloud-java/pull/1147)).

## PubSub

  - Change Pub/Sub endpoint from `pubsub-experimental.googleapis.com` to
    `pubsub.googleapis.com`
    ([\#1149](https://github.com/googleapis/google-cloud-java/pull/1149)).

# v0.2.7

#### BigQuery

  - Add support for time-partitioned tables. For example, you can now
    create a time partitioned table using the following code:

<div class="highlight highlight-source-java">

    TableId tableId = TableId.of(datasetName, tableName);
    TimePartitioning partitioning = TimePartitioning.of(Type.DAY);
    // You can also set the expiration
    // TimePartitioning partitioning = TimePartitioning.of(Type.DAY, 2592000000);
    StandardTableDefinition tableDefinition = StandardTableDefinition.builder()
        .schema(tableSchema)
        .timePartitioning(partitioning)
        .build();
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));

</div>

#### Logging

  - `gcloud-java-logging`, a new client library to interact with
    Stackdriver Logging, is released and is in alpha. See the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-logging#google-cloud-java-client-for-logging-alpha)
    for more information.  
    `gcloud-java-logging` uses gRPC as transport layer, which is not
    (yet) supported by App Engine Standard. `gcloud-java-logging` will
    work on App Engine Flexible.  
    See
    [LoggingExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/logging/LoggingExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/cloud/logging/package-summary.html)
    for `gcloud-java-logging` javadoc.  
    The following snippet shows how to write and list log entries.
    Complete source code can be found
    on  
    [WriteAndListLogEntries.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/logging/snippets/WriteAndListLogEntries.java).

<div class="highlight highlight-source-java">

    import com.google.cloud.MonitoredResource;
    import com.google.cloud.Page;
    import com.google.cloud.logging.LogEntry;
    import com.google.cloud.logging.Logging;
    import com.google.cloud.logging.Logging.EntryListOption;
    import com.google.cloud.logging.LoggingOptions;
    import com.google.cloud.logging.Payload.StringPayload;
    
    import java.util.Collections;
    import java.util.Iterator;
    
    LoggingOptions options = LoggingOptions.defaultInstance();
    try(Logging logging = options.service()) {
    
      LogEntry firstEntry = LogEntry.builder(StringPayload.of("message"))
          .logName("test-log")
          .resource(MonitoredResource.builder("global")
              .addLabel("project_id", options.projectId())
              .build())
          .build();
      logging.write(Collections.singleton(firstEntry));
    
      Page<LogEntry> entries = logging.listLogEntries(
          EntryListOption.filter("logName=projects/" + options.projectId() + "/logs/test-log"));
      Iterator<LogEntry> entryIterator = entries.iterateAll();
      while (entryIterator.hasNext()) {
        System.out.println(entryIterator.next());
      }
    }

</div>

The following snippet, instead, shows how to use a
`java.util.logging.Logger` to write log entries to Stackdriver Logging.
The snippet installs a Stackdriver Logging handler using  
`LoggingHandler.addHandler(Logger, LoggingHandler)`. Notice that this
could also be done through the `logging.properties` file, adding the
following
    line:

    com.google.cloud.examples.logging.snippets.AddLoggingHandler.handlers=com.google.cloud.logging.LoggingHandler}

The complete code can be found on
[AddLoggingHandler.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/logging/snippets/AddLoggingHandler.java).

<div class="highlight highlight-source-java">

    import com.google.cloud.logging.LoggingHandler;
    
    import java.util.logging.Logger;
    
    Logger logger = Logger.getLogger(AddLoggingHandler.class.getName());
    LoggingHandler.addHandler(logger, new LoggingHandler());
    logger.warning("test warning");

</div>

# v0.2.6

#### Storage NIO

  - `gcloud-java-nio`, a new client library that allows to interact with
    Google Cloud Storage using Java's NIO API, is released and is in
    alpha. Not all NIO features have been implemented yet, see the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-contrib/gcloud-java-nio)
    for more information.  
    The simplest way to get started with `gcloud-java-nio` is with
    `Paths` and `Files`:

<div class="highlight highlight-source-java">

    Path path = Paths.get(URI.create("gs://bucket/lolcat.csv"));
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

</div>

`InputStream` and `OutputStream` can also be used for streaming:

<div class="highlight highlight-source-java">

    Path path = Paths.get(URI.create("gs://bucket/lolcat.csv"));
    try (InputStream input = Files.newInputStream(path)) {
      // use input stream
    }

</div>

To configure a bucket per-environment, you can use the `FileSystem`
    API:

<div class="highlight highlight-source-java">

    FileSystem fs = FileSystems.getFileSystem(URI.create("gs://bucket"));
    byte[] data = "hello world".getBytes(StandardCharsets.UTF_8);
    Path path = fs.getPath("/object");
    Files.write(path, data);
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

</div>

If you don't want to rely on Java SPI, which requires a META-INF file in
your jar generated by Google Auto, you can instantiate this file system
directly as
    follows:

<div class="highlight highlight-source-java">

    CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("bucket");
    byte[] data = "hello world".getBytes(StandardCharsets.UTF_8);
    Path path = fs.getPath("/object");
    Files.write(path, data);
    data = Files.readAllBytes(path);

</div>

For instructions on how to add Google Cloud Storage NIO support to a
legacy jar see [this
example](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-contrib/gcloud-java-nio-examples).
For more examples see
[here](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/nio).

## Fixes

#### Storage

  - Fix `BlobReadChannel` to support reading and seeking files larger
    than `Integer.MAX_VALUE` bytes

# v0.2.5

#### Pub/Sub

  - `gcloud-java-pubsub`, a new client library to interact with Google
    Cloud Pub/Sub, is released and is in alpha. See the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-pubsub#google-cloud-java-client-for-pubsub-alpha)
    for more information.  
    `gcloud-java-pubsub` uses gRPC as transport layer, which is not
    (yet) supported by App Engine Standard. `gcloud-java-pubsub` will
    work on App Engine Flexible.  
    See
    [PubSubExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/pubsub/PubSubExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/cloud/pubsub/package-summary.html)
    for `gcloud-java-pubsub` javadoc.  
    The following snippet shows how to create a Pub/Sub topic and
    asynchronously publish messages to it. See
    [CreateTopicAndPublishMessages.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateTopicAndPublishMessages.java)
    for the full source code.

<div class="highlight highlight-source-java">

``` 
  try (PubSub pubsub = PubSubOptions.defaultInstance().service()) {
    Topic topic = pubsub.create(TopicInfo.of("test-topic"));
    Message message1 = Message.of("First message");
    Message message2 = Message.of("Second message");
    topic.publishAsync(message1, message2);
  }
```

</div>

The following snippet, instead, shows how to create a Pub/Sub pull
subscription and asynchronously pull messages from it. See
[CreateSubscriptionAndPullMessages.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/pubsub/snippets/CreateSubscriptionAndPullMessages.java)
for the full source code.

<div class="highlight highlight-source-java">

``` 
  try (PubSub pubsub = PubSubOptions.defaultInstance().service()) {
    Subscription subscription =
        pubsub.create(SubscriptionInfo.of("test-topic", "test-subscription"));
    MessageProcessor callback = new MessageProcessor() {
      @Override
      public void process(Message message) throws Exception {
        System.out.printf("Received message \"%s\"%n", message.payloadAsString());
      }
    };
    // Create a message consumer and pull messages (for 60 seconds)
    try (MessageConsumer consumer = subscription.pullAsync(callback)) {
      Thread.sleep(60_000);
    }
  }
```

</div>

# v0.2.4

#### BigQuery

  - Add support for the `BYTES` datatype. A field of type `BYTES` can be
    created by using
    [`Field.Value.bytes()`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-bigquery/src/main/java/com/google/cloud/bigquery/Field.java#L114).
    The [`byte[]
    bytesValue()`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-bigquery/src/main/java/com/google/cloud/bigquery/FieldValue.java#L133)
    method is added to `FieldValue` to return the value of a field as a
    byte array.
  - A `Job waitFor(WaitForOption... waitOptions)` method is added to
    `Job` class. This method waits for the job to complete and returns
    job's updated information:

<div class="highlight highlight-source-java">

    Job completedJob = job.waitFor();
    if (completedJob == null) {
      // job no longer exists
    } else if (completedJob.status().error() != null) {
      // job failed, handle error
    } else {
      // job completed successfully
    }

</div>

By default, the job status is checked every 500 milliseconds, to
configure this value `WaitForOption.checkEvery(long, TimeUnit)` can be
used. `WaitForOption.timeout(long, TimeUnit)`, instead, sets the maximum
time to
    wait.

#### Core

  - [`AuthCredentials.createFor(String)`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/AuthCredentials.java#L499)
    and [`AuthCredentials.createFor(String,
    Date)`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/AuthCredentials.java#L510)
    methods have been added to create `AuthCredentials` objects given an
    OAuth2 access token (and possibly its expiration date).

#### Compute

  - A `Operation waitFor(WaitForOption... waitOptions)` method is added
    to `Operation` class. This method waits for the operation to
    complete and returns operation's updated information:

<div class="highlight highlight-source-java">

    Operation completedOperation = operation.waitFor();
    if (completedOperation == null) {
      // operation no longer exists
    } else if (completedOperation.errors() != null) {
      // operation failed, handle error
    } else {
      // operation completed successfully
    }

</div>

By default, the operation status is checked every 500 milliseconds, to
configure this value `WaitForOption.checkEvery(long, TimeUnit)` can be
used. `WaitForOption.timeout(long, TimeUnit)`, instead, sets the maximum
time to
    wait.

#### Datastore

  - [`Datastore.put`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-datastore/src/main/java/com/google/cloud/datastore/Datastore.java#L101)
    and
    [`DatastoreBatchWriter.put`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-datastore/src/main/java/com/google/cloud/datastore/DatastoreBatchWriter.java#L87)
    now support entities with incomplete keys. Both `put` methods return
    the just updated/created entities. A
    [`putWithDeferredIdAllocation`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-datastore/src/main/java/com/google/cloud/datastore/DatastoreBatchWriter.java#L78)
    method has been also added to `DatastoreBatchWriter`.

## Fixes

## Storage

  - `StorageExample` now contains examples on how to add ACLs to blobs
    and buckets
    ([\#1033](https://github.com/googleapis/google-cloud-java/pull/1033)).
  - `BlobInfo.createTime()` getter has been added. This method returns
    the time at which a blob was created
    ([\#1034](https://github.com/googleapis/google-cloud-java/pull/1034)).

# v0.2.3

#### Core

  - [`Clock`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/Clock.java)
    abstract class is moved out of `ServiceOptions`.
    [`ServiceOptions.clock()`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/ServiceOptions.java#L562)
    is now used by
    [`RetryHelper`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/RetryHelper.java)
    in all service calls. This enables mocking the `Clock` source used
    for retries when testing your code.

#### Storage

  - Refactor storage batches to use the common
    [`BatchResult`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-core/src/main/java/com/google/cloud/BatchResult.java)
    class. Sending batch requests in Storage is now as simple as in DNS.
    See the following example of sending a batch request:

<div class="highlight highlight-source-java">

    StorageBatch batch = storage.batch();
    BlobId firstBlob = BlobId.of("bucket", "blob1");
    BlobId secondBlob = BlobId.of("bucket", "blob2");
    BlobId thirdBlob = BlobId.of("bucket", "blob3");
    // Users can either register a callback on an operation
    batch.delete(firstBlob).notify(new BatchResult.Callback<Boolean, StorageException>() {
      @Override
      public void success(Boolean result) {
        // handle delete result
      }
    
      @Override
      public void error(StorageException exception) {
        // handle exception
      }
    });
    // Ignore its result
    batch.update(BlobInfo.builder(secondBlob).contentType("text/plain").build());
    StorageBatchResult<Blob> result = batch.get(thirdBlob);
    batch.submit();
    // Or get the result
    Blob blob = result.get(); // returns the operation's result or throws StorageException

</div>

## Fixes

#### Datastore

  - Update datastore client to accept IP addresses for localhost
    ([\#1002](https://github.com/googleapis/google-cloud-java/pull/1002)).
  - `LocalDatastoreHelper` now uses https to download the emulator -
    thanks to [@pehrs](https://github.com/pehrs)
    ([\#942](https://github.com/googleapis/google-cloud-java/pull/942)).
  - Add example on embedded entities to
    [`DatastoreExample`](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/datastore/DatastoreExample.java)
    ([\#980](https://github.com/googleapis/google-cloud-java/pull/980)).

## Storage

  - Fix `StorageImpl.signUrl` for blob names that start with "/" -
    thanks to [@clementdenis](https://github.com/clementdenis)
    ([\#1013](https://github.com/googleapis/google-cloud-java/pull/1013)).
  - Fix `readAllBytes` permission error on Google AppEngine
    ([\#1010](https://github.com/googleapis/google-cloud-java/pull/1010)).

# v0.2.2

#### Compute

  - `gcloud-java-compute`, a new client library to interact with Google
    Compute Engine is released and is in alpha. See the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-compute#google-cloud-java-client-for-compute-alpha)
    for more information. See
    [ComputeExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/compute/ComputeExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/cloud/compute/package-summary.html)
    for `gcloud-java-compute` javadoc.  
    The following snippet shows how to create a region external IP
    address, a persistent boot disk and a virtual machine instance that
    uses both the IP address and the persistent disk. See
    [CreateAddressDiskAndInstance.java](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/cloud/examples/compute/snippets/CreateAddressDiskAndInstance.java)
    for the full source code.

<div class="highlight highlight-source-java">

``` 
    // Create a service object
    // Credentials are inferred from the environment.
    Compute compute = ComputeOptions.defaultInstance().service();

    // Create an external region address
    RegionAddressId addressId = RegionAddressId.of("us-central1", "test-address");
    Operation operation = compute.create(AddressInfo.of(addressId));
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Address " + addressId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Address creation failed");
    }

    // Create a persistent disk
    ImageId imageId = ImageId.of("debian-cloud", "debian-8-jessie-v20160329");
    DiskId diskId = DiskId.of("us-central1-a", "test-disk");
    ImageDiskConfiguration diskConfiguration = ImageDiskConfiguration.of(imageId);
    DiskInfo disk = DiskInfo.of(diskId, diskConfiguration);
    operation = compute.create(disk);
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Disk " + diskId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Disk creation failed");
    }

    // Create a virtual machine instance
    Address externalIp = compute.getAddress(addressId);
    InstanceId instanceId = InstanceId.of("us-central1-a", "test-instance");
    NetworkId networkId = NetworkId.of("default");
    PersistentDiskConfiguration attachConfiguration =
        PersistentDiskConfiguration.builder(diskId).boot(true).build();
    AttachedDisk attachedDisk = AttachedDisk.of("dev0", attachConfiguration);
    NetworkInterface networkInterface = NetworkInterface.builder(networkId)
        .accessConfigurations(AccessConfig.of(externalIp.address()))
        .build();
    MachineTypeId machineTypeId = MachineTypeId.of("us-central1-a", "n1-standard-1");
    InstanceInfo instance =
        InstanceInfo.of(instanceId, machineTypeId, attachedDisk, networkInterface);
    operation = compute.create(instance);
    // Wait for operation to complete
    while (!operation.isDone()) {
      Thread.sleep(1000L);
    }
    // Check operation errors
    operation = operation.reload();
    if (operation.errors() == null) {
      System.out.println("Instance " + instanceId + " was successfully created");
    } else {
      // inspect operation.errors()
      throw new RuntimeException("Instance creation failed");
    }
```

</div>

#### Datastore

  - `options(String namespace)` method has been added to
    `LocalDatastoreHelper` allowing to create testing options for a
    specific namespace
    ([\#936](https://github.com/googleapis/google-cloud-java/pull/936)).
  - `of` methods have been added to `ListValue` to support specific
    types (`String`, `long`, `double`, `boolean`, `DateTime`, `LatLng`,
    `Key`, `FullEntity` and `Blob`). `addValue` methods have been added
    to `ListValue.Builder` to support the same set of specific types
    ([\#934](https://github.com/googleapis/google-cloud-java/pull/934)).

#### DNS

  - Support for batches has been added to `gcloud-java-dns`
    ([\#940](https://github.com/googleapis/google-cloud-java/pull/940)).
    Batches allow to perform a number of operations in one single RPC
    request.

## Fixes

#### Core

  - The causing exception is now chained in
    `BaseServiceException.getCause()`
    ([\#774](https://github.com/googleapis/google-cloud-java/pull/774)).

# v0.2.1

#### General

  - `gcloud-java` has been repackaged. `com.google.gcloud` has now
    changed to `com.google.cloud`, and we're releasing our artifacts on
    maven under the Group ID `com.google.cloud` rather than
    `com.google.gcloud`. The new way to add our library as a dependency
    in your project is as follows:

If you're using Maven, add this to your pom.xml file

    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>gcloud-java</artifactId>
      <version>0.2.0</version>
    </dependency>

If you are using Gradle, add this to your dependencies

    compile 'com.google.cloud:gcloud-java:0.2.0'

If you are using SBT, add this to your dependencies

    libraryDependencies += "com.google.cloud" % "gcloud-java" % "0.2.0"

#### Storage

  - The interface `ServiceAccountSigner` was added. Both
    `AppEngineAuthCredentials` and `ServiceAccountAuthCredentials`
    extend this interface and can be used to sign Google Cloud Storage
    blob URLs
    ([\#701](https://github.com/googleapis/google-cloud-java/issues/701),
    [\#854](https://github.com/googleapis/google-cloud-java/pull/854)).

## Fixes

#### General

  - The default RPC retry parameters were changed to align with the
    backoff policy requirement listed in the Service Level Agreements
    (SLAs) for Cloud BigQuery, and Cloud Datastore, and Cloud Storage
    ([\#857](https://github.com/googleapis/google-cloud-java/issues/857),
    [\#860](https://github.com/googleapis/google-cloud-java/pull/860)).
  - The expiration date is now properly populated for App Engine
    credentials
    ([\#873](https://github.com/googleapis/google-cloud-java/issues/873),
    [\#894](https://github.com/googleapis/google-cloud-java/pull/894)).
  - `gcloud-java` now uses the project ID given in the credentials file
    specified by the environment variable
    `GOOGLE_APPLICATION_CREDENTIALS` (if set)
    ([\#845](https://github.com/googleapis/google-cloud-java/pull/845)).

#### BigQuery

  - `Job`'s `isDone` method is fixed to return true if the job is
    complete or the job doesn't exist
    ([\#853](https://github.com/googleapis/google-cloud-java/pull/853)).

#### Datastore

  - `LocalGcdHelper` has been renamed to `RemoteDatastoreHelper`, and
    the command line startup/shutdown of the helper has been removed.
    The helper is now more consistent with other modules' test helpers
    and can be used via the `create`, `start`, and `stop` methods
    ([\#821](https://github.com/googleapis/google-cloud-java/pull/821)).
  - `ListValue` no longer rejects empty lists, since Cloud Datastore
    v1beta3 supports empty array values
    ([\#862](https://github.com/googleapis/google-cloud-java/pull/862)).

#### DNS

  - There were some minor changes to `ChangeRequest`, namely adding
    `reload`/`isDone` methods and changing the method signature of
    `applyTo`
    ([\#849](https://github.com/googleapis/google-cloud-java/pull/849)).

#### Storage

  - `RemoteGcsHelper` was renamed to `RemoteStorageHelper` to be more
    consistent with other modules' test helpers
    ([\#821](https://github.com/googleapis/google-cloud-java/pull/821)).

# v0.2.0

#### Datastore

  - `gcloud-java-datastore` now uses Cloud Datastore v1beta3. You can
    read more about updates in Datastore v1beta3
    [here](https://cloud.google.com/datastore/release-notes#april_2016).
    Note that to use this new API, you may have to re-enable the [Google
    Cloud Datastore
    API](https://console.cloud.google.com/apis/api/datastore.googleapis.com)
    in the Developers Console. The following API changes are coupled
    with this update.
      - Entity-related changes:
          - Entities are indexed by default, and `indexed` has been
            changed to `excludeFromIndexes`. Properties of type
            `EntityValue` and type `ListValue` can now be indexed.
            Moreover, indexing and querying properties inside of entity
            values is now supported. Values inside entity values are
            indexed by default.
          - `LatLng` and `LatLngValue`, representing the new property
            type for latitude & longitude, are added.
          - The getter for a value's `meaning` has been made package
            scope instead of public, as it is a deprecated field.
      - Read/write-related changes:
          - Force writes have been removed. Since force writes were the
            only existing option in batch and transaction options, the
            `BatchOption` and `TransactionOption` classes are now
            removed.
          - `ReadOption` is added to allow users to specify eventual
            consistency on Datastore reads. This can be a useful
            optimization when strongly consistent results for
            `get`/`fetch` or ancestor queries aren't necessary.
      - Query-related changes:
          - `QueryResults.cursorAfter()` is updated to point to the
            position after the last consumed result. In v1beta2,
            `cursorAfter` was only updated after all results were
            consumed.
          - `groupBy` is replaced by `distinctOn`.
          - The `Projection` class in `StructuredQuery` is replaced with
            a string representing the property name. Aggregation
            functions are removed.
          - There are changes in GQL syntax:
              - In synthetic literal KEY, DATASET is now PROJECT.
              - The BLOBKEY synthetic literal is removed.
              - The FIRST aggregator is removed.
              - The GROUP BY clause is replaced with DISTINCT ON.
              - Fully-qualified property names are now supported.
              - Query filters on timestamps prior to the epoch are now
                supported.
      - Other miscellaneous changes:
          - The "userinfo.email" authentication scope is no longer
            required. This means you don't need to enable that
            permission when creating new instances on Google Compute
            Engine to use `gcloud-java-datastore`.
          - The default value for namespace is now an empty string
            rather than null.

## Fixes

#### General

  - In `gcloud-java-bigquery`, `gcloud-java-dns`, and
    `gcloud-java-storage`, the field `id()` has been renamed to
    `generatedId` for classes that are assigned `id`s from the service.

#### Datastore

  - Issue
    [\#548](https://github.com/googleapis/google-cloud-java/issues/548)
    (internal errors when trying to load large numbers of entities
    without setting a limit) is fixed. The work around mentioned in that
    issue is no longer necessary.

# v0.1.7

#### DNS

  - `gcloud-java-dns`, a new client library to interact with Google
    Cloud DNS, is released and is in alpha. See the
    [docs](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-dns#google-cloud-java-client-for-dns)
    for more information and samples.

#### Resource Manager

  - Project-level [IAM (Identity and Access
    Management)](https://cloud.google.com/iam/) functionality is now
    available. See docs and example code
    [here](https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-resourcemanager#managing-iam-policies).

## Fixes

#### Big Query

  - `startPageToken` is now called `pageToken`
    ([\#774](https://github.com/googleapis/google-cloud-java/pull/774))
    and `maxResults` is now called `pageSize`
    ([\#745](https://github.com/googleapis/google-cloud-java/pull/745))
    to be consistent with page-based listing methods in other
    `gcloud-java` modules.

#### Storage

  - Default content type, once a required field for bucket creation and
    copying/composing blobs, is now removed
    ([\#288](https://github.com/googleapis/google-cloud-java/issues/288),
    [\#762](https://github.com/googleapis/google-cloud-java/pull/762)).
  - A new boolean `overrideInfo` is added to copy requests to denote
    whether metadata should be overridden
    ([\#762](https://github.com/googleapis/google-cloud-java/pull/762)).
  - `startPageToken` is now called `pageToken`
    ([\#774](https://github.com/googleapis/google-cloud-java/pull/774))
    and `maxResults` is now called `pageSize`
    ([\#745](https://github.com/googleapis/google-cloud-java/pull/745))
    to be consistent with page-based listing methods in other
    `gcloud-java` modules.

# v0.1.6

#### Storage

  - Add `versions(boolean versions)` option to `BlobListOption` to
    enable/disable versioned `Blob` listing. If enabled all versions of
    an object as distinct results
    ([\#688](https://github.com/googleapis/google-cloud-java/pull/688)).
  - `BlobTargetOption` and `BlobWriteOption` classes are added to
    `Bucket` to allow setting options for `create` methods
    ([\#705](https://github.com/googleapis/google-cloud-java/pull/705)).

## Fixes

#### BigQuery

  - Fix pagination when listing tables and dataset with selected fields
    ([\#668](https://github.com/googleapis/google-cloud-java/pull/668)).

#### Core

  - Fix authentication issue when using revoked Cloud SDK credentials
    with local test helpers. The `NoAuthCredentials` class is added with
    the `AuthCredentials.noAuth()` method, to ne used when testing
    service against local emulators
    ([\#719](https://github.com/googleapis/google-cloud-java/pull/719)).

#### Storage

  - Fix pagination when listing blobs and buckets with selected fields
    ([\#668](https://github.com/googleapis/google-cloud-java/pull/668)).
  - Fix wrong usage of `Storage.BlobTargetOption` and
    `Storage.BlobWriteOption` in `Bucket`'s `create` methods. New
    classes (`Bucket.BlobTargetOption` and `Bucket.BlobWriteOption`) are
    added to provide options to `Bucket.create`
    ([\#705](https://github.com/googleapis/google-cloud-java/pull/705)).
  - Fix "Failed to parse Content-Range header" error when
    `BlobWriteChannel` writes a blob whose size is a multiple of the
    chunk size used
    ([\#725](https://github.com/googleapis/google-cloud-java/pull/725)).
  - Fix NPE when reading with `BlobReadChannel` a blob whose size is a
    multiple of the chunk/buffer size
    ([\#725](https://github.com/googleapis/google-cloud-java/pull/725)).

# v0.1.5

#### BigQuery

  - The `JobInfo` and `TableInfo` class hierarchies are flattened
    ([\#584](https://github.com/googleapis/google-cloud-java/pull/584),
    [\#600](https://github.com/googleapis/google-cloud-java/pull/600)).
    Instead, `JobInfo` contains a field `JobConfiguration`, which is
    subclassed to provide configurations for different types of jobs.
    Likewise, `TableInfo` contains a new field `TableDefinition`, which
    is subclassed to provide table settings depending on the table type.
  - Functional classes (`Job`, `Table`, `Dataset`) now extend their
    associated metadata classes (`JobInfo`, `TableInfo`, `DatasetInfo`)
    ([\#530](https://github.com/googleapis/google-cloud-java/issues/530),
    [\#609](https://github.com/googleapis/google-cloud-java/pull/609)).
    The `BigQuery` service methods now return functional objects instead
    of the metadata objects.

#### Datastore

  - Setting list properties containing values of a single type is more
    concise
    ([\#640](https://github.com/googleapis/google-cloud-java/issues/640),
    [\#648](https://github.com/googleapis/google-cloud-java/pull/648)).
    
    For example, to set a list of string values as a property on an
    entity, you'd previously have to
        type:
    
    <div class="highlight highlight-source-java">
    
        someEntity.set("someStringListProperty", StringValue.of("a"), StringValue.of("b"),
            StringValue.of("c"));
    
    </div>
    
    Now you can set the property using:
    
    <div class="highlight highlight-source-java">
    
        someEntity.set("someStringListProperty", "a", "b", "c");
    
    </div>

  - There is now a more concise way to get the parent of an entity key
    ([\#640](https://github.com/googleapis/google-cloud-java/issues/640),
    [\#648](https://github.com/googleapis/google-cloud-java/pull/648)).
    
    <div class="highlight highlight-source-java">
    
        Key parentOfCompleteKey = someKey.parent();
    
    </div>

  - The consistency setting (defaults to 0.9 both before and after this
    change) can be set in `LocalGcdHelper`
    ([\#639](https://github.com/googleapis/google-cloud-java/issues/639),
    [\#648](https://github.com/googleapis/google-cloud-java/pull/648)).

  - You no longer have to cast or use the unknown type when getting a
    `ListValue` from an entity
    ([\#648](https://github.com/googleapis/google-cloud-java/pull/648)).
    Now you can use something like the following to get a list of double
    values:
    
    <div class="highlight highlight-source-java">
    
        List<DoubleValue> doublesList = someEntity.get("myDoublesList");
    
    </div>

#### ResourceManager

  - Paging for the `ResourceManager` `list` method is now supported.
    ([\#651](https://github.com/googleapis/google-cloud-java/pull/651))
  - `Project` is now a subclass of `ProjectInfo`
    ([\#530](https://github.com/googleapis/google-cloud-java/issues/530)).
    The `ResourceManager` service methods now return `Project` instead
    of `ProjectInfo`.

#### Storage

  - Functional classes (`Bucket`, `Blob`) now extend their associated
    metadata classes (`BucketInfo`, `BlobInfo`)
    ([\#530](https://github.com/googleapis/google-cloud-java/issues/530),
    [\#603](https://github.com/googleapis/google-cloud-java/issues/603),
    [\#614](https://github.com/googleapis/google-cloud-java/pull/614)).
    The `Storage` service methods now return functional objects instead
    of metadata objects.

## Fixes

#### BigQuery

  - The potential NPE in metadata objects equals methods is fixed
    ([\#632](https://github.com/googleapis/google-cloud-java/pull/632)).
  - Methods in `Table` that were meant to be public but kept package
    scope are now fixed
    ([\#621](https://github.com/googleapis/google-cloud-java/pull/621)).

# v0.1.4

#### BigQuery

  - Resumable uploads via write channel are now supported
    ([\#540](https://github.com/googleapis/google-cloud-java/pull/540))
    
    An example of uploading a CSV file in chunks of CHUNK\_SIZE
        bytes:
    
    <div class="highlight highlight-source-java">
    
        try (FileChannel fileChannel = FileChannel.open(Paths.get("/path/to/your/file"))) {
          ByteBuffer buffer = ByteBuffer.allocate(256 * 1024);
          TableId tableId = TableId.of("YourDataset", "YourTable");
          LoadConfiguration configuration =
              LoadConfiguration.of(tableId, FormatOptions.of("CSV"));
          WriteChannel writeChannel = bigquery.writer(configuration);
          long position = 0;
          long written = fileChannel.transferTo(position, CHUNK_SIZE, writeChannel);
          while (written > 0) {
            position += written;
            written = fileChannel.transferTo(position, CHUNK_SIZE, writeChannel);
          }
          writeChannel.close();
        }
    
    </div>

  - `defaultDataset(String dataset)` (in `QueryJobInfo` and
    `QueryRequest`) can be used to specify a default dataset
    ([\#567](https://github.com/googleapis/google-cloud-java/pull/567)).

#### Storage

  - The name of the method to submit a batch request has changed from
    `apply` to `submit`
    ([\#562](https://github.com/googleapis/google-cloud-java/pull/562)).

## Fixes

#### BigQuery

  - `hashCode` and `equals` are now overridden in subclasses of
    `BaseTableInfo`
    ([\#565](https://github.com/googleapis/google-cloud-java/pull/565),
    [\#573](https://github.com/googleapis/google-cloud-java/pull/573)).
  - `jobComplete` is renamed to `jobCompleted` in `QueryResult`
    ([\#567](https://github.com/googleapis/google-cloud-java/pull/567)).

#### Datastore

  - The precondition check that cursors are UTF-8 strings has been
    removed
    ([\#578](https://github.com/googleapis/google-cloud-java/pull/578)).

  - `EntityQuery`, `KeyQuery`, and `ProjectionEntityQuery` classes have
    been introduced
    ([\#585](https://github.com/googleapis/google-cloud-java/pull/585)).
    This enables users to use modify projections and group by clauses
    for projection entity queries after using `toBuilder()`. For
    example, this now
        works:
    
    <div class="highlight highlight-source-java">
    
        ProjectionEntityQuery query = Query.projectionEntityQueryBuilder()
            .kind("Person")
            .projection(Projection.property("name"))
            .build();
        ProjectionEntityQuery newQuery =
            query.toBuilder().projection(Projection.property("favorite_food")).build();
    
    </div>

# v0.1.3

#### Core

  - By default, requests are now retried
    ([\#547](https://github.com/googleapis/google-cloud-java/pull/547)).
    
    For example:
    
    <div class="highlight highlight-source-java">
    
        // Use the default retry strategy
        Storage storageWithRetries = StorageOptions.defaultInstance().service();
        
        // Don't use retries
        Storage storageWithoutRetries = StorageOptions.builder()
            .retryParams(RetryParams.noRetries())
            .build()
            .service()
    
    </div>

#### BigQuery

  - Functional classes for datasets, jobs, and tables are added
    ([\#516](https://github.com/googleapis/google-cloud-java/pull/516))
  - [Query
    Plan](https://cloud.google.com/bigquery/query-plan-explanation) is
    now supported
    ([\#523](https://github.com/googleapis/google-cloud-java/pull/523)).
  - [Template
    suffix](https://cloud.google.com/bigquery/streaming-data-into-bigquery#template_table_details)
    is now supported
    ([\#514](https://github.com/googleapis/google-cloud-java/pull/514)).

## Fixes

#### Datastore

  - `QueryResults.cursorAfter()` is now set when all results from a
    query have been exhausted
    ([\#549](https://github.com/googleapis/google-cloud-java/pull/549)).
    
    When running large queries, users may see Datastore-internal errors
    with code 500 due to a [Datastore
    issue](https://github.com/GoogleCloudPlatform/google-cloud-datastore/issues/85).
    This issue will be fixed in the next version of Datastore. Until
    then, users can set a limit on their query and use the cursor to get
    more results in subsequent queries. Here is an example:
    
    <div class="highlight highlight-source-java">
    
        int limit = 100;
        StructuredQuery<Entity> query = Query.entityQueryBuilder()
            .kind("user")
            .limit(limit)
            .build();
        while (true) {
          QueryResults<Entity> results = datastore.run(query);
          int resultCount = 0;
          while (results.hasNext()) {
            Entity result = results.next(); // consume all results
            // do something with the result
            resultCount++;
          }
          if (resultCount < limit) {
            break;
          }
          query = query.toBuilder().startCursor(results.cursorAfter()).build();
        }
    
    </div>

  - `load` is renamed to `get` in functional classes
    ([\#535](https://github.com/googleapis/google-cloud-java/pull/535))

# v0.1.2

#### BigQuery

  - Introduce support for [Google Cloud
    BigQuery](https://cloud.google.com/bigquery)
    ([\#503](https://github.com/googleapis/google-cloud-java/pull/503)):
    create datasets and tables, manage jobs, insert and list table data.
    See
    [BigQueryExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/BigQueryExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/bigquery/package-summary.html)
    for `gcloud-java-bigquery` javadoc.
    
    <div class="highlight highlight-source-java">
    
        import com.google.gcloud.bigquery.BaseTableInfo;
        import com.google.gcloud.bigquery.BigQuery;
        import com.google.gcloud.bigquery.BigQueryOptions;
        import com.google.gcloud.bigquery.Field;
        import com.google.gcloud.bigquery.JobStatus;
        import com.google.gcloud.bigquery.LoadJobInfo;
        import com.google.gcloud.bigquery.Schema;
        import com.google.gcloud.bigquery.TableId;
        import com.google.gcloud.bigquery.TableInfo;
        
        BigQuery bigquery = BigQueryOptions.defaultInstance().service();
        TableId tableId = TableId.of("dataset", "table");
        BaseTableInfo info = bigquery.getTable(tableId);
        if (info == null) {
          System.out.println("Creating table " + tableId);
          Field integerField = Field.of("fieldName", Field.Type.integer());
          bigquery.create(TableInfo.of(tableId, Schema.of(integerField)));
        } else {
          System.out.println("Loading data into table " + tableId);
          LoadJobInfo loadJob = LoadJobInfo.of(tableId, "gs://bucket/path");
          loadJob = bigquery.create(loadJob);
          while (loadJob.status().state() != JobStatus.State.DONE) {
            Thread.sleep(1000L);
            loadJob = bigquery.getJob(loadJob.jobId());
          }
          if (loadJob.status().error() != null) {
            System.out.println("Job completed with errors");
          } else {
            System.out.println("Job succeeded");
          }
        }
    
    </div>

#### Resource Manager

  - Introduce support for [Google Cloud Resource
    Manager](https://cloud.google.com/resource-manager/)
    ([\#495](https://github.com/googleapis/google-cloud-java/pull/495)):
    get a list of all projects associated with an account,
    create/update/delete projects, undelete projects that you don't want
    to delete. See
    [ResourceManagerExample](https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/ResourceManagerExample.java)
    for a complete example or [API
    Documentation](http://googlecloudplatform.github.io/gcloud-java/apidocs/index.html?com/google/gcloud/resourcemanager/package-summary.html)
    for `gcloud-java-resourcemanager` javadoc.
    
    <div class="highlight highlight-source-java">
    
        import com.google.gcloud.resourcemanager.ProjectInfo;
        import com.google.gcloud.resourcemanager.ResourceManager;
        import com.google.gcloud.resourcemanager.ResourceManagerOptions;
        
        import java.util.Iterator;
        
        ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();
        // Replace "some-project-id" with an existing project's ID
        ProjectInfo myProject = resourceManager.get("some-project-id");
        ProjectInfo newProjectInfo = resourceManager.replace(myProject.toBuilder()
            .addLabel("launch-status", "in-development").build());
        System.out.println("Updated the labels of project " + newProjectInfo.projectId()
            + " to be " + newProjectInfo.labels());
        // List all the projects you have permission to view.
        Iterator<ProjectInfo> projectIterator = resourceManager.list().iterateAll();
        System.out.println("Projects I can view:");
        while (projectIterator.hasNext()) {
          System.out.println(projectIterator.next().projectId());
        }
    
    </div>

#### Storage

  - Remove the `RemoteGcsHelper.create(String, String)` method
    ([\#494](https://github.com/googleapis/google-cloud-java/pull/494))

## Fixes

#### Datastore

  - HTTP Transport is now specified in `DefaultDatastoreRpc`
    ([\#448](https://github.com/googleapis/google-cloud-java/pull/448))

# v0.1.1

#### Core

  - The project ID set in the Google Cloud SDK now supersedes the
    project ID set by Compute Engine
    ([\#337](https://github.com/googleapis/google-cloud-java/pull/337)).
    
    ###### Before
    
    The project ID is determined by iterating through the following list
    in order, stopping when a valid project ID is found:
    
    1.  Project ID supplied when building the service options
    2.  Project ID specified by the environment variable
        `GCLOUD_PROJECT`
    3.  App Engine project ID
    4.  Compute Engine project ID
    5.  Google Cloud SDK project ID
    
    ###### After
    
    1.  Project ID supplied when building the service options
    2.  Project ID specified by the environment variable
        `GCLOUD_PROJECT`
    3.  App Engine project ID
    4.  Google Cloud SDK project ID
    5.  Compute Engine project ID

  - The explicit `AuthCredentials.noCredentials` option was removed.

#### Storage

  - The testing helper class `RemoteGCSHelper` now uses
    `GOOGLE_APPLICATION_CREDENTIALS` and `GCLOUD_PROJECT` environment
    variables to set credentials and project
    ([\#335](https://github.com/googleapis/google-cloud-java/issues/335),
    [\#339](https://github.com/googleapis/google-cloud-java/pull/339)).
    
    ###### Before
    
        export GCLOUD_TESTS_PROJECT_ID="MY_PROJECT_ID"
        export GCLOUD_TESTS_KEY=/path/to/my/key.json
    
    ###### After
    
        export GCLOUD_PROJECT="MY_PROJECT_ID"
        export GOOGLE_APPLICATION_CREDENTIALS=/path/to/my/key.json

  - `BlobReadChannel` throws a `StorageException` if a blob is updated
    during a read
    ([\#359](https://github.com/googleapis/google-cloud-java/issues/359),
    [\#390](https://github.com/googleapis/google-cloud-java/pull/390))

  - `generation` is moved from `BlobInfo` to `BlobId`, and
    `generationMatch` and `generationNotMatch` methods are added to
    `BlobSourceOption` and `BlobGetOption`
    ([\#363](https://github.com/googleapis/google-cloud-java/issues/363),
    [\#366](https://github.com/googleapis/google-cloud-java/pull/366)).
    
    ###### Before
    
    <div class="highlight highlight-source-java">
    
        BlobInfo myBlobInfo = someAlreadyExistingBlobInfo.toBuilder().generation(1L);
    
    </div>
    
    ###### After
    
    <div class="highlight highlight-source-java">
    
        BlobId myBlobId = BlobId.of("bucketName", "idName", 1L);
    
    </div>

  - The `Blob`'s batch delete method now returns false for blobs that
    were not found
    ([\#380](https://github.com/googleapis/google-cloud-java/pull/380)).

## Fixes

#### Core

  - An exception is no longer thrown when reading the default project ID
    in the App Engine environment
    ([\#378](https://github.com/googleapis/google-cloud-java/pull/378)).
  - `SocketTimeoutExceptions` are now retried
    ([\#410](https://github.com/googleapis/google-cloud-java/issues/410),
    [\#414](https://github.com/googleapis/google-cloud-java/pull/414)).

#### Datastore

  - A `SocketException` exception is no longer thrown when creating the
    Datastore service object from within the App Engine production
    environment
    ([\#411](https://github.com/googleapis/google-cloud-java/pull/411)).

#### Storage

  - The `toBuilder` methods in `BlobInfo` and `BucketInfo` are fixed so
    that `info.equals(info.toBuilder().build())` is true
    ([\#415](https://github.com/googleapis/google-cloud-java/issues/415),
    [\#416](https://github.com/googleapis/google-cloud-java/pull/416)).

# v0.1.0

No content.

# v0.0.12

No content.

# v0.0.11

Fixes build issues that caused ClassNotFoundExceptions in 0.0.9 maven
artifact.

# v0.0.10

No content.

