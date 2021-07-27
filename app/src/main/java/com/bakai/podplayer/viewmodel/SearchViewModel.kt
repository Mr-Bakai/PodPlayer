package com.bakai.podplayer.viewmodel

import com.bakai.podplayer.core.ui.base.BaseViewModel
import com.bakai.podplayer.repository.ItunesRepo
import com.bakai.podplayer.service.PodcastResponse
import com.bakai.podplayer.util.DateUtils

class SearchViewModel(var iTunesRepo: ItunesRepo? = null) : BaseViewModel() {

    data class PodcastSummaryViewData(
            var name: String? = "",
            var lastUpdated: String? = "",
            var imageUrl: String? = "",
            var feedUrl: String? = "")

    private fun itunesPodcastToPodcastSummaryView(
            itunesPodcast: PodcastResponse.ItunesPodcast):
            PodcastSummaryViewData {
        return PodcastSummaryViewData(
                itunesPodcast.collectionCensoredName,
                DateUtils.jsonDateToShortDate(itunesPodcast.releaseDate),
                itunesPodcast.artworkUrl100,
                itunesPodcast.feedUrl)
    }

    suspend fun searchPodcasts(term: String): List<PodcastSummaryViewData> {
        val results = iTunesRepo?.searchByTerm(term)

        if (results != null && results.isSuccessful) {
            val podcasts = results.body()?.results
            if (!podcasts.isNullOrEmpty()) {
                return podcasts.map { podcast ->
                    itunesPodcastToPodcastSummaryView(podcast)
                }
            }
        }
        return emptyList()
    }
}