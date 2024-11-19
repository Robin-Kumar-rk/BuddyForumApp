package com.example.buddyforum

data class Complaint(
    var id: Int, // Unique identifier for the complaint
    var title: String, // Title of the complaint
    var description: String, // Detailed description of the complaint
    var image: String? = null, // Path or URI to the media file (can be null if no image is provided)
    var upvote: Int = 0, // Number of upvotes (default is 0)
    var category: String = "",
    var upvoted: Boolean = false
) {
    // Computed property for Severity
    val severity: Severity
        get() = when {
            upvote >= 10 -> Severity.MAJOR
            upvote >= 5 -> Severity.MODERATE
            else -> Severity.MINOR
        }
}


// Enum class for Severity Levels
enum class Severity {
    MAJOR,
    MINOR,
    MODERATE
}
