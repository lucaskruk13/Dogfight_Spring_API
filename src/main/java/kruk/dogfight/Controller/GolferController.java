package kruk.dogfight.Controller;

import kruk.dogfight.Model.Golfer;
import kruk.dogfight.Model.Score;
import kruk.dogfight.Repository.GolferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GolferController {

    final GolferRepo golferRepo;

    @Autowired
    public GolferController(GolferRepo golferRepo) {
        this.golferRepo = golferRepo;
    }


//    @GetMapping
//    public List<Golfer> getGolferByLastName(@RequestParam String lastName){
//        return golferRepo.getGolferByLastName(lastName);
//    }

    @GetMapping("/golfers")
    public List<Golfer> findAll(){
        return golferRepo.findAll();
    }

    @GetMapping("/golfers/{id}/last5scores")
    public Golfer getLastFiveScores(@PathVariable String id){
        return golferRepo.getLastFiveScores(id);
    }

    @GetMapping("/golfers/{id}/currentQuotaPrecise")
    public Double getPreciseQuotaForGolferByID(@PathVariable String id){
        return golferRepo.getLastFiveScores(id).getPreciseQuota();
    }

    @GetMapping("/golfers/{id}/currentQuota")
    public int getQuotaFOrGolferByID(@PathVariable String id){
        return golferRepo.getLastFiveScores(id).getQuota();
    }

}
