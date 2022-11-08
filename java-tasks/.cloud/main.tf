terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "cloudtasks" {
  service            = "cloudtasks.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "time_sleep" "for_90s_allowTasksToFullyEnable" {
  depends_on      = [google_project_service.cloudtasks]
  create_duration = "90s"
}