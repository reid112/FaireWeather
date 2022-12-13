package ca.rjreid.faireweather.domain.models

data class Sources(
    var title: String? = null,
    var slug: String? = null,
    var url: String? = null,
    var crawlRate: Int? = null
)