terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "compute" {
  service            = "compute.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "redis" {
  service            = "redis.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
locals {
  redis_vpc_id = "redis-vpc"
}
resource "google_compute_network" "redis_vpc" {
  count      = var.inputs.should_create_redis_network ? 1 : 0
  name       = local.redis_vpc_id
  depends_on = [
    google_project_service.compute,
    google_project_service.redis
  ]
}
resource "time_sleep" "for_2m_allowRedisVpcToFullyEnable" {
  count           = var.inputs.should_create_redis_network ? 1 : 0
  depends_on      = [google_compute_network.redis_vpc]
  create_duration = "2m"
}
data "google_compute_network" "existing_network" {
  count = var.inputs.should_create_redis_network ? 0 : 1
  name  = local.redis_vpc_id
}
