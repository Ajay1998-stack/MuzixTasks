package com.stackroute.Muzix.Application.tracks;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Track {
    @Id
    int id;
    String trackName;
    String comments;

}
