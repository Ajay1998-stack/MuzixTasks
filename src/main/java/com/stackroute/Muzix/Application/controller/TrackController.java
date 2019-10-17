package com.stackroute.Muzix.Application.controller;

import com.stackroute.Muzix.Application.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Application.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Application.service.TrackService;
import com.stackroute.Muzix.Application.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

    @Autowired
    @Qualifier("trackServiceImpl")
    TrackService trackService;


    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
//        try{
            trackService.saveTrack(track);
            responseEntity= new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
//        }catch (TrackAlreadyExistsException ex){
//            responseEntity= new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

//        }
        return responseEntity;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable("id") int id,@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
//        try{
            trackService.saveTrack(trackService.updateTrack(id,track));
            responseEntity= new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
//        }catch (Exception ex){
//            responseEntity= new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//
//        }
        return responseEntity;
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> updatedTracks(@RequestBody Track track,@PathVariable ("id") int id){
        return  new ResponseEntity<List<Track>>(trackService.updatedTracks(track,id),HttpStatus.OK);
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return  new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }


    @GetMapping("user/{trackName}")
    public ResponseEntity<?> findByTrackName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {
        ResponseEntity responseEntity;
//        try{
            trackService.findByTrackName(trackName);
            responseEntity= new ResponseEntity<String>("Search found", HttpStatus.CREATED);
//        }catch (TrackNotFoundException ex){
//            responseEntity= new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//
//        }
        return responseEntity;
    }
}

