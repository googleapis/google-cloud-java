terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "redis_api" {
  service            = "redis.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "compute_api" {
  service            = "compute.googleapis.com"
  disable_on_destroy = false
}

resource "random_id" "id" {
  byte_length = 3
}
locals {
  redis_vpc_id = lower("redis-vpc-${random_id.id.hex}")
}
resource "google_compute_network" "redis_vpc" {
  name       = local.redis_vpc_id
  depends_on = [google_project_service.compute_api]
}
resource "time_sleep" "wait_2m" {
  depends_on      = [google_compute_network.redis_vpc]
  create_duration = "2m"
}
