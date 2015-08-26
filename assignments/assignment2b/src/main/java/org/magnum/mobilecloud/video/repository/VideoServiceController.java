package org.magnum.mobilecloud.video.repository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ksa on 26/08/15.
 */
@Controller
public class VideoServiceController {
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value="/video",method= RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody Video addVideo(@RequestBody Video video){
        entityManager.persist(video);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
//TODO how to recover recently created entity ?
        video.setId(111);
        video.setLikes(0);

        return video;

    }
    @RequestMapping(value="/video/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Video getVideoById(){
        return new Video("Video", "video.com", 2, 0);
    }
}
