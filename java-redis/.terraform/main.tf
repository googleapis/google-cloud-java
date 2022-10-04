terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = [
    "compute.googleapis.com",
    "redis.googleapis.com"
  ]
}

resource "random_id" "id" {
  byte_length = 3
}
locals {
  redis_vpc_id = lower("redis-vpc-${random_id.id.hex}")
}
resource "google_compute_network" "redis_vpc" {
  name       = local.redis_vpc_id
  depends_on = [module.project-services]
}
resource "time_sleep" "for_2m_allowRedisVpcToFullyEnable" {
  depends_on      = [google_compute_network.redis_vpc]
  create_duration = "2m"
}
