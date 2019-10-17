package com.stackroute.Muzix.Application.Repository;

import com.stackroute.Muzix.Application.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer>{
    @Query("SELECT t FROM Track t where t.trackName = ?1")
    public Optional<Track> findByTrackName(String trackName);
}
