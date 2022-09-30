# Testing
In addition to using / requiring `GOOGLE_CLOUD_PROJECT` to be set, the samples require a secret known as `java-cts-v4-samples-secrets` which currently contains:
```shell
export CTS_JOB_ID="84408022903726790"
export CTS_COMPANY_ID="a37ec657-3491-4f44-9a0a-ec2e4cefbfd3"
export CTS_TENANT_ID="29470357-321b-43db-8d65-41ffdb943140"
```
I created them by running the samples in stand alone mode.  First I had to create `CTS_TENANT_ID` by modifying **JobSearchCreateTenant** and providing the
`projectId` and the `externalId = "Initial Tenant";`  I also had to rename the method to `main(String args[])`.

Next I had to create the `CTS_COMPANY_ID` by modifying **JobSearchCreateCompany** providing - note - tenantId came from the earlier step:
```java
    String projectId = "java-docs-samples-testing";
    String tenantId = "29470357-321b-43db-8d65-41ffdb943140";
    String displayName = "DO_NOT_DELETE_COMPANY";
    String externalId = "Company External ID";
```

Then to create `CTS_JOB_ID`, I modified **JobSearchCreateJob** providing both tenantId & companyId came from earlier steps:
```java
    String projectId = "java-docs-samples-testing";
    String tenantId = "29470357-321b-43db-8d65-41ffdb943140";
    String displayName = "DO_NOT_DELETE_COMPANY";
    String externalId = "Company External ID";
    String companyId = "a37ec657-3491-4f44-9a0a-ec2e4cefbfd3";
    String requisitionId = "core-requisitionid-1";
    String jobApplicationUrl = "http://job.url";
```
