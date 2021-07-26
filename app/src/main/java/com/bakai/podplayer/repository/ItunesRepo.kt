package com.bakai.podplayer.repository

import com.bakai.podplayer.service.ItunesService

class ItunesRepo(private val itunesService: ItunesService) {

  suspend fun searchByTerm(term: String) = itunesService.searchPodcastByTerm(term)

}
