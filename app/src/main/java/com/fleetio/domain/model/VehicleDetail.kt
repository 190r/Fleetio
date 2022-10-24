package com.fleetio.domain.model


import com.google.gson.annotations.SerializedName

data class VehicleDetail(
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("ai_enabled")
    val aiEnabled: Boolean,
    @SerializedName("archived_at")
    val archivedAt: Any?,
    @SerializedName("assetable_type")
    val assetableType: String,
    @SerializedName("color")
    val color: Any?,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_location_entry")
    val currentLocationEntry: CurrentLocationEntry?,
    @SerializedName("current_location_entry_id")
    val currentLocationEntryId: Int,
    @SerializedName("current_meter_date")
    val currentMeterDate: String,
    @SerializedName("current_meter_value")
    val currentMeterValue: Float,
    @SerializedName("custom_fields")
    val customFields: CustomFields,
    @SerializedName("default_image_url")
    val defaultImageUrl: String,
    @SerializedName("default_image_url_large")
    val defaultImageUrlLarge: String,
    @SerializedName("default_image_url_medium")
    val defaultImageUrlMedium: String,
    @SerializedName("default_image_url_small")
    val defaultImageUrlSmall: String,
    @SerializedName("documents_count")
    val documentsCount: Int,
    @SerializedName("driver")
    val driver: Driver,
    @SerializedName("estimated_replacement_mileage")
    val estimatedReplacementMileage: Any?,
    @SerializedName("estimated_resale_price")
    val estimatedResalePrice: Any?,
    @SerializedName("estimated_service_months")
    val estimatedServiceMonths: Any?,
    @SerializedName("external_ids")
    val externalIds: ExternalIds,
    @SerializedName("fuel_entries_count")
    val fuelEntriesCount: Int,
    @SerializedName("fuel_type_id")
    val fuelTypeId: Any?,
    @SerializedName("fuel_type_name")
    val fuelTypeName: Any?,
    @SerializedName("fuel_volume_units")
    val fuelVolumeUnits: String,
    @SerializedName("group_ancestry")
    val groupAncestry: String,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("group_name")
    val groupName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images_count")
    val imagesCount: Int,
    @SerializedName("in_service_date")
    val inServiceDate: Any?,
    @SerializedName("in_service_meter")
    val inServiceMeter: Any?,
    @SerializedName("inspection_schedules_count")
    val inspectionSchedulesCount: Int,
    @SerializedName("is_sample")
    val isSample: Boolean,
    @SerializedName("issues_count")
    val issuesCount: Int,
    @SerializedName("license_plate")
    val licensePlate: Any?,
    @SerializedName("loan_account_number")
    val loanAccountNumber: Any?,
    @SerializedName("loan_ended_at")
    val loanEndedAt: Any?,
    @SerializedName("loan_interest_rate")
    val loanInterestRate: Any?,
    @SerializedName("loan_notes")
    val loanNotes: Any?,
    @SerializedName("loan_started_at")
    val loanStartedAt: Any?,
    @SerializedName("loan_vendor_id")
    val loanVendorId: Any?,
    @SerializedName("loan_vendor_name")
    val loanVendorName: Any?,
    @SerializedName("make")
    val make: String?,
    @SerializedName("meter_name")
    val meterName: String,
    @SerializedName("meter_unit")
    val meterUnit: String,
    @SerializedName("model")
    val model: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("out_of_service_date")
    val outOfServiceDate: String?,
    @SerializedName("out_of_service_meter")
    val outOfServiceMeter: String?,
    @SerializedName("ownership")
    val ownership: String?,
    @SerializedName("primary_meter_usage_per_day")
    val primaryMeterUsagePerDay: String,
    @SerializedName("registration_expiration_month")
    val registrationExpirationMonth: Int,
    @SerializedName("registration_state")
    val registrationState: Any?,
    @SerializedName("secondary_meter")
    val secondaryMeter: Boolean,
    @SerializedName("secondary_meter_date")
    val secondaryMeterDate: Any?,
    @SerializedName("secondary_meter_name")
    val secondaryMeterName: String,
    @SerializedName("secondary_meter_unit")
    val secondaryMeterUnit: Any?,
    @SerializedName("secondary_meter_usage_per_day")
    val secondaryMeterUsagePerDay: String,
    @SerializedName("secondary_meter_value")
    val secondaryMeterValue: Float,
    @SerializedName("service_entries_count")
    val serviceEntriesCount: Int,
    @SerializedName("service_reminders_count")
    val serviceRemindersCount: Int,
    @SerializedName("specs")
    val specs: Specs,
    @SerializedName("system_of_measurement")
    val systemOfMeasurement: String,
    @SerializedName("trim")
    val trim: String?,
    @SerializedName("type_name")
    val typeName: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("vehicle_renewal_reminders_count")
    val vehicleRenewalRemindersCount: Int,
    @SerializedName("vehicle_status_color")
    val vehicleStatusColor: String,
    @SerializedName("vehicle_status_id")
    val vehicleStatusId: Int,
    @SerializedName("vehicle_status_name")
    val vehicleStatusName: String,
    @SerializedName("vehicle_type_id")
    val vehicleTypeId: Int,
    @SerializedName("vehicle_type_name")
    val vehicleTypeName: String,
    @SerializedName("vin")
    val vin: String?,
    @SerializedName("work_orders_count")
    val workOrdersCount: Int,
    @SerializedName("year")
    val year: String?
)