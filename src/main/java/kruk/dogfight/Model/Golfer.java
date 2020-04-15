package kruk.dogfight.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "golfers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Golfer{

    @Id
    @Field(name = "_id")
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private List<Score> scores;

    public Double getPreciseQuota(){
        int counter = scores.size() - 1;
        int tot = 0;

        while (counter > 0 && counter > scores.size() - 6){
            tot += scores.get(counter).getScore();
            counter --;
        }

        return tot / 5.0;
    }

    public int getQuota(){
        Double val = Math.ceil(getPreciseQuota());
        return val.intValue();
    }

}
