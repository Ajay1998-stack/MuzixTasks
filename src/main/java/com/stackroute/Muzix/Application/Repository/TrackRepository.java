package com.stackroute.Muzix.Application.Repository;

import com.stackroute.Muzix.Application.tracks.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
    @Query("SELECT t FROM Track t where t.trackName = ?1")
    public Optional<Track> findByTrackName(String trackName);
}
