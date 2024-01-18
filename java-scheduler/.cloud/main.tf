terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
    time = {
      source = "hashicorp/time"
    }
  }
}
resource "google_project_service" "pubsub" {
  service            = "pubsub.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "cloudscheduler" {
  service            = "cloudscheduler.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "cloudtrace" {
  service            = "cloudtrace.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "time_sleep" "for_1m_allowServicesTimeToFullyEnable" {
  create_duration = "1m"
  depends_on      = [
    google_project_service.pubsub,
    google_project_service.cloudscheduler,
    google_project_service.cloudtrace
  ]
}
