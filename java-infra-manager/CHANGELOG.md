# Changelog

## 0.19.0 (2024-04-25)

### Features

* Annotations are now supported to help client tools identify deployments during automation ([acc7b71](https://github.com/googleapis/google-cloud-java/commit/acc7b71b5c72d049730df6a2184a1f374bfe8cbe))
* Infrastructure manager supports 1.2.3, 1.3.10, 1.4.7, 1.5.7 versions of Terraform when creating a preview of a deployment ([acc7b71](https://github.com/googleapis/google-cloud-java/commit/acc7b71b5c72d049730df6a2184a1f374bfe8cbe))



## 0.18.0 (2024-04-04)

* No change


## 0.16.0 (2024-03-28)

* No change


## 0.15.0 (2024-03-22)

### Features

* Infrastructure Manager can validate and enforce quota limits, preventing infrastructure that exceeds quota limits from being deployed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* Infrastructure Manager supports the deployment of infrastructure from Terraform configurations in a private Git repository ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* Infrastructure manager supports the following versions of Terraform when creating a deployment: Terraform version 1.2.3, 1.3.10, 1.4.7, 1.5.7 ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* A comment for field `page_size` in message `.google.cloud.config.v1.ListDeploymentsRequest` is changed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* A comment for field `page_size` in message `.google.cloud.config.v1.ListPreviewsRequest` is changed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* A comment for field `page_size` in message `.google.cloud.config.v1.ListResourcesRequest` is changed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* A comment for field `page_size` in message `.google.cloud.config.v1.ListRevisionsRequest` is changed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))
* A comment for field `service_account` in message `.google.cloud.config.v1.Preview` is changed ([3f89544](https://github.com/googleapis/google-cloud-java/commit/3f895447dec5d79d7b60907a629873de5dbdfa16))



## 0.14.0 (2024-03-06)

* No change


## 0.13.0 (2024-02-20)

* No change


## 0.12.0 (2024-02-09)

* No change


## 0.11.0 (2024-01-23)

### Features

* added Terraform Plan ([#10223](https://github.com/googleapis/google-cloud-java/issues/10223)) ([bd6f6bb](https://github.com/googleapis/google-cloud-java/commit/bd6f6bb577a0480e681b61a7e0872be42a78ad36))



## 0.10.0 (2024-01-10)

* No change


## 0.9.0 (2023-12-12)

* No change


## 0.8.0 (2023-12-04)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.20.0 ([#10093](https://github.com/googleapis/google-cloud-java/issues/10093)) ([91a4e4e](https://github.com/googleapis/google-cloud-java/commit/91a4e4e20252f667b8fc6bda0d9ceaf947348274))


## 0.7.0 (2023-11-06)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.1 ([#10014](https://github.com/googleapis/google-cloud-java/issues/10014)) ([7b1b742](https://github.com/googleapis/google-cloud-java/commit/7b1b742dab21139398032549fb03e127b1a03841))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.19.0 ([#10018](https://github.com/googleapis/google-cloud-java/issues/10018)) ([d9b705a](https://github.com/googleapis/google-cloud-java/commit/d9b705aaed8ea4447c7a02d5c54300f8909a30b1))


## 0.6.0 (2023-10-25)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.6.0 ([#9969](https://github.com/googleapis/google-cloud-java/issues/9969)) ([9e2be39](https://github.com/googleapis/google-cloud-java/commit/9e2be39c5b2d7764421325f65a6d0d06351fcda5))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.18.0 ([#9984](https://github.com/googleapis/google-cloud-java/issues/9984)) ([9814dc0](https://github.com/googleapis/google-cloud-java/commit/9814dc092ad7edb7b1b21f87fa48d76a2423d731))


## 0.5.0 (2023-10-11)

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-config to v1.5.8 ([#9941](https://github.com/googleapis/google-cloud-java/issues/9941)) ([f818d26](https://github.com/googleapis/google-cloud-java/commit/f818d26968e1f19d302da1f1ea0145b2cc496ce0))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.17.0 ([#9942](https://github.com/googleapis/google-cloud-java/issues/9942)) ([2cc7888](https://github.com/googleapis/google-cloud-java/commit/2cc78885d76ae5e7dfc4cc9f3034c25fa22c6cc1))


## 0.4.0 (2023-09-28)

* No change


## 0.2.0 (2023-09-27)

### Features

* change the config service's Ruby namespace to avoid a collision with a base class in the Ruby client platform ([#9856](https://github.com/googleapis/google-cloud-java/issues/9856)) ([24ec31f](https://github.com/googleapis/google-cloud-java/commit/24ec31f2f588b02b5216a37ea2ef2f866ec47fcd))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.0 ([#9866](https://github.com/googleapis/google-cloud-java/issues/9866)) ([aa36b2c](https://github.com/googleapis/google-cloud-java/commit/aa36b2c3c31b817052239fd771a21d20108b2c31))
* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.16.1 ([#9881](https://github.com/googleapis/google-cloud-java/issues/9881)) ([8a29511](https://github.com/googleapis/google-cloud-java/commit/8a2951166eb0305be040cc0ae38be105c437ba25))


## 0.1.0 (2023-09-11)

### Features

* new module for infra-manager ([#9802](https://github.com/googleapis/google-cloud-java/issues/9802)) ([3d82fb4](https://github.com/googleapis/google-cloud-java/commit/3d82fb4b24e210ad06eb5b1b9b2599a0326b0a20))

### Dependencies

* **deps:** update dependency com.google.cloud:google-cloud-shared-dependencies to v3.15.0 ([#9809](https://github.com/googleapis/google-cloud-java/issues/9809)) ([09dbd85](https://github.com/googleapis/google-cloud-java/commit/09dbd855f683b40a462c4f918511bee4671e0174))
