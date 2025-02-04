package org.example.assignment.network

import org.example.assignment.presentation.Breach

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreachDto(
    @SerialName("AddedDate") val addedDate: String,
    @SerialName("BreachDate") val breachDate: String,
    @SerialName("DataClasses") val dataClasses: List<String>,
    @SerialName("Description") val description: String,
    @SerialName("Domain") val domain: String,
    @SerialName("IsFabricated") val isFabricated: Boolean,
    @SerialName("IsMalware") val isMalware: Boolean,
    @SerialName("IsRetired") val isRetired: Boolean,
    @SerialName("IsSensitive") val isSensitive: Boolean,
    @SerialName("IsSpamList") val isSpamList: Boolean,
    @SerialName("IsStealerLog") val isStealerLog: Boolean,
    @SerialName("IsSubscriptionFree") val isSubscriptionFree: Boolean,
    @SerialName("IsVerified") val isVerified: Boolean,
    @SerialName("LogoPath") val logoPath: String,
    @SerialName("ModifiedDate") val modifiedDate: String,
    @SerialName("Name") val name: String,
    @SerialName("PwnCount") val pwnCount: Int,
    @SerialName("Title") val title: String
) {
    fun toBreach(): Breach {
        return Breach(
            name, title, domain, breachDate, description
        )
    }
}
