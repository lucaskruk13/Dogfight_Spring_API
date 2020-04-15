package kruk.dogfight.Repository;

import kruk.dogfight.Model.Golfer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GolferRepo extends MongoRepository<Golfer, String> {

    @Query(value="{id:?0}", fields = "{scores:{$slice:-5}}")
    Golfer getLastFiveScores(String id);

    @Query(value="{}", fields = "{email:0}}")
    List<Golfer> findAll();

    @Query(value="{id:?0}", fields = "{email:0}")
    Optional<Golfer> findById(String id);
}
