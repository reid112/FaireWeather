package ca.rjreid.faireweather.data.remote.dto

import com.squareup.moshi.Json

data class SourcesDto(
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "slug") var slug: String? = null,
    @field:Json(name = "url") var url: String? = null,
    @field:Json(name = "crawl_rate") var crawlRate: Int? = null
)